package grpc.blog.server;

import grpc.blog.service.BlogServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class BlogServer {

    public static void main(String[] args) {
        String[] ports = args[0].split(",");
        List<Runnable> servers = asList(
                startServerAtPort(Integer.parseInt(ports[0])),
                startServerAtPort(Integer.parseInt(ports[1])),
                startServerAtPort(Integer.parseInt(ports[2]))
        );

        servers.parallelStream().forEach(Runnable::run);
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
