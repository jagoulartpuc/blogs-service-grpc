package grpc.blog.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.proto.blog.*;
import com.proto.blog.SemaphoreServiceGrpc.SemaphoreServiceBlockingStub;
import com.proto.blog.BlogServiceGrpc.BlogServiceImplBase;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.proto.blog.Type;

import static com.mongodb.client.model.Filters.eq;
import static com.proto.blog.SemaphoreServiceGrpc.newBlockingStub;

;

public class BlogServiceImpl extends BlogServiceImplBase {

    private final MongoClient mongoClient = MongoClients.create("mongodb+srv://admin:admin@cluster0.mmz1f.mongodb.net/blog-db?retryWrites=true&w=majority");
    private final MongoCollection<Document> collection = mongoClient.getDatabase("blog-db").getCollection("blogs");

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
    SemaphoreServiceBlockingStub semaphoreClient = newBlockingStub(channel);

    @Override
    public void createBlog(CreateBlogRequest request, StreamObserver<CreateBlogResponse> responseObserver) {
        // TODO somente uma inserção por vez, podendo ter várias buscas em paralelo
        // TODO Se inserção ocorrendo = não deixa inserir
        // TODO Se deleção ocorrendo  = deixa inserir
        // TODO Se busca ocorrendo    = deixa inserir
        System.out.println("Received Create Blog Request");
        Blog blog = request.getBlog();

        Document document = new Document().append("authorId", blog.getAuthorId())
                .append("title", blog.getTitle())
                .append("content", blog.getContent());
        try {
            // Critical session
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(Type.INSERT).build());
            collection.insertOne(document);
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(Type.INSERT).build());
        } catch (Exception ex) {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("An error ocurred while the blog is inserted.")
                            .augmentDescription(ex.getLocalizedMessage())
                            .asRuntimeException()
            );
        }

        String id = document.get("_id").toString();
        System.out.println("Inserted Blog id: " + id);

        CreateBlogResponse response = CreateBlogResponse.newBuilder()
                .setBlog(blog.toBuilder()
                        .setId(id)
                        .build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteBlog(DeleteBlogRequest request, StreamObserver<DeleteBlogResponse> responseObserver) {
        // TODO Somente uma deleção por vez
        // TODO Se inserção ocorrendo = não deixa deletar
        // TODO Se deleção ocorrendo  = não deixa deletar
        // TODO Se busca ocorrendo    = não deixa deletar
        System.out.println("Received Delete Blog Request");
        DeleteResult result = null;
        try {
            //Critical Session
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(Type.INSERT).build());
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(Type.DELETE).build());
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(Type.SEARCH).build());
            result = collection.deleteOne(eq("_id", new ObjectId(request.getBlogId())));
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(Type.INSERT).build());
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(Type.DELETE).build());
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(Type.SEARCH).build());
        } catch (Exception ex) {
            System.out.println("Blog id: " + request.getBlogId() + " not found.");

            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("The blog with the corresponding id was not found.")
                            .augmentDescription(ex.getLocalizedMessage())
                            .asRuntimeException()
            );
        }

        assert result != null;
        if (result.getDeletedCount() == 0) {
            System.out.println("Blog id: " + request.getBlogId() + " not found.");

            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("The blog with the corresponding id was not found.")
                            .augmentDescription("Blog id: " + request.getBlogId() + " not found.")
                            .asRuntimeException()
            );
        }

        System.out.println("Deleted! Sending as response");

        responseObserver.onNext(DeleteBlogResponse.newBuilder().setBlogId(request.getBlogId()).build());
        responseObserver.onCompleted();

    }

    @Override
    public void findAllBlog(FindAllBlogRequest request, StreamObserver<FindAllBlogResponse> responseObserver) {
        // TODO pode ocorrer concorrentemente com inserção. ação bloqueada quando tiver ocorrendo uma exclusão
        // TODO Se inserção ocorrendo = deixa buscar
        // TODO Se deleção ocorrendo  = não deixa buscar
        // TODO Se busca ocorrendo    = deixa buscar

        System.out.println("Received Find All Blog Request");
        semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(Type.DELETE).build());
        collection.find().forEach(document -> responseObserver.onNext(FindAllBlogResponse.newBuilder().setBlog(documentToBlog(document)).build()));
        semaphoreClient.release(SemaphoreRequest.newBuilder().setType(Type.DELETE).build());
        responseObserver.onCompleted();
    }

    private Blog documentToBlog(Document document) {
        return Blog.newBuilder()
                .setId(document.getObjectId("_id").toString())
                .setAuthorId(document.getString("authorId"))
                .setContent(document.getString("content"))
                .setTitle(document.getString("title"))
                .build();
    }
}