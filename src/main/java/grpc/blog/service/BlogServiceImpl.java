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

import static com.mongodb.client.model.Filters.eq;
import static com.proto.blog.SemaphoreServiceGrpc.newBlockingStub;

;

public class BlogServiceImpl extends BlogServiceImplBase {

    private final MongoClient mongoClient = MongoClients.create("mongodb+srv://admin:admin@cluster0.mmz1f.mongodb.net/blog-db?retryWrites=true&w=majority");
    private final MongoCollection<Document> collection = mongoClient.getDatabase("blog-db").getCollection("blogs");

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9007).usePlaintext().build();
    SemaphoreServiceBlockingStub semaphoreClient = newBlockingStub(channel);

    @Override
    public void createBlog(CreateBlogRequest request, StreamObserver<CreateBlogResponse> responseObserver) {
        System.out.println("Received Create Blog Request");
        Blog blog = request.getBlog();

        Document document = new Document().append("authorId", blog.getAuthorId())
                .append("title", blog.getTitle())
                .append("content", blog.getContent());
        try {
            // Critical session
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(0).build());
            collection.insertOne(document);
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(0).build());
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
        System.out.println("Received Delete Blog Request");
        DeleteResult result = null;
        try {
            //Critical Session
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(0).build());
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(1).build());
            semaphoreClient.acquire(SemaphoreRequest.newBuilder().setType(2).build());
            result = collection.deleteOne(eq("_id", new ObjectId(request.getBlogId())));
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(0).build());
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(1).build());
            semaphoreClient.release(SemaphoreRequest.newBuilder().setType(2).build());
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

        responseObserver.onNext(DeleteBlogResponse.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void findAllBlog(FindAllBlogRequest request, StreamObserver<FindAllBlogResponse> responseObserver) {

        System.out.println("Received Find All Blog Request");
        collection.find().forEach(document -> responseObserver.onNext(FindAllBlogResponse.newBuilder().setBlog(documentToBlog(document)).build()));
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