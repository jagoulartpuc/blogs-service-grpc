package grpc.blog.client;

import com.proto.blog.Blog;
import com.proto.blog.CreateBlogRequest;
import com.proto.blog.CreateBlogResponse;
import com.proto.blog.DeleteBlogRequest;
import com.proto.blog.DeleteBlogResponse;
import com.proto.blog.FindAllBlogRequest;
import com.proto.blog.ReadBlogRequest;
import com.proto.blog.ReadBlogResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static com.proto.blog.BlogServiceGrpc.*;

public class BlogClient {

    public static void main(String[] args) {
        startClient().run();
        startClient().run();
        startClient().run();
    }

    public static Runnable startClient() {
        return () -> {
            System.out.println("Client starting at thread: " + Thread.currentThread().getId());

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

            BlogServiceBlockingStub blogClient = newBlockingStub(channel);

            CreateBlogResponse response = blogClient.createBlog(CreateBlogRequest.newBuilder()
                    .setBlog(Blog.newBuilder()
                            .setAuthorId("Jose e Andre")
                            .setTitle("Trabalho de programacao distribuida")
                            .setContent("Implementacao de grpc com banco de dados compartilhado")
                            .build())
                    .build());

            System.out.println("Received create Blog response");
            System.out.println(response.toString());

            System.out.println("Reading blog...");
            String blogId = response.getBlog().getId();

            ReadBlogResponse blogResponse = blogClient.readBlog(ReadBlogRequest.newBuilder().setBlogId(blogId).build());
            System.out.println("Received Blog response");
            System.out.println(blogResponse.toString());

            System.out.println("Deleting blog...");
            DeleteBlogResponse deleteBlogResponse = blogClient.deleteBlog(DeleteBlogRequest.newBuilder()
                    .setBlogId(response.getBlog().getId())
                    .build());

            System.out.println("Deleted blog!");
            System.out.println(deleteBlogResponse.toString());

            System.out.println("Finding All blogs...");

            blogClient.findAllBlog(FindAllBlogRequest.newBuilder().build())
                    .forEachRemaining(blog -> System.out.println(blog.toString()));

            System.out.println("Shutting down channel");
            channel.shutdown();
        };
    }
}
