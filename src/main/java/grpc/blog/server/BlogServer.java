package grpc.blog.server;

import grpc.blog.service.BlogServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class BlogServer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Port is required!");
            return;
        }
        startServerAtPort(Integer.parseInt(args[0])).run();
    }

    public static Runnable startServerAtPort(int port) {
        return () -> {
            Server server = ServerBuilder.forPort(port)
                    .addService(new BlogServiceImpl())
                    .addService(ProtoReflectionService.newInstance())
                    .build();

            System.out.println("Server started at port: " + port);

            try {
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Runtime.getRuntime().addShutdownHook(new Thread(
                () -> {
                    System.out.println("Received Shutdown Request");
                    server.shutdown();
                    System.out.println("Successfully stopped the Greeting Server");
                }
            ));

            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
