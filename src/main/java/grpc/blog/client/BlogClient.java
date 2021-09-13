package grpc.blog.client;

import com.proto.blog.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.proto.blog.BlogServiceGrpc.*;

public class BlogClient {

    private static int period = 2;

    public static void main(String[] args) {
        System.out.println("Selecione o IP:");
        String host = args[0];
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(startClient(host), 1, period, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(startClient(host), 1, period, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(startClient(host), 1, period, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(startClient(host), 1, period, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(startClient(host), 1, period, TimeUnit.SECONDS);
    }

    public static Runnable startClient(String host) {
        return () -> {
            System.out.println("Starting client at thread: " + Thread.currentThread().getId());
            Random random = new Random();
            int[] ports = {8000, 8001, 8002, 8003, 8004, 8005};
            int port = ports[random.nextInt(6)];
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            BlogServiceBlockingStub blogClient = newBlockingStub(channel);

            String[] operations = {"INSERT", "READ", "DELETE"};
            String operation = operations[random.nextInt(3)];
            if (operation.equals("INSERT")) {
                insertBlogRequest(blogClient);
            } else if (operation.equals("READ")) {
                readAllBlogsRequest(blogClient);
            } else {
                deleteBlogRequest(blogClient);
            }
        };
    }

    public static void readAllBlogsRequest(BlogServiceBlockingStub blogClient) {
        System.out.println("Reading All blogs...");
        blogClient.findAllBlog(FindAllBlogRequest.newBuilder().build())
                .forEachRemaining(blog -> System.out.println(blog.toString()));
    }

    public static void insertBlogRequest(BlogServiceBlockingStub blogClient) {
        CreateBlogResponse response = blogClient.createBlog(CreateBlogRequest.newBuilder()
                .setBlog(Blog.newBuilder()
                        .setAuthorId("Jose, Andre e Gui")
                        .setTitle("Trabalho de programacao distribuida")
                        .setContent("Implementacao de grpc com banco de dados compartilhado")
                        .build())
                .build());

        System.out.println("Inserting new blog...");
        System.out.println(response.toString());
    }

    public static void deleteBlogRequest(BlogServiceBlockingStub blogClient) {
        System.out.println("Deleting blog...");
        DeleteBlogResponse deleteBlogResponse = blogClient.deleteBlog(DeleteBlogRequest.newBuilder()
                .setBlogId(getNextBlogId(blogClient))
                .build());
        System.out.println(deleteBlogResponse.getBlogId());
    }

    private static String getNextBlogId(BlogServiceBlockingStub blogClient) {
        return blogClient.findAllBlog(
                        FindAllBlogRequest.newBuilder().build()
                )
                .next()
                .getBlog()
                .getId();
    }

}
