package grpc.blog.service;

import com.proto.blog.SemaphoreRequest;
import com.proto.blog.SemaphoreResponse;
import com.proto.blog.SemaphoreServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.Semaphore;

public class SemaphoreServiceImpl extends SemaphoreServiceGrpc.SemaphoreServiceImplBase {
    private static final Semaphore deletionSemaphore = new Semaphore(1);
    private static final Semaphore insertionSemaphore = new Semaphore(1);
    private static final Semaphore searchSemaphore = new Semaphore(1);

    @Override
    public void acquire(SemaphoreRequest request, StreamObserver<SemaphoreResponse> responseObserver) {
        try {
            switch (request.getType()) {
                case 0:
                    System.out.println("Semaphore insert acquire(). Permits: " + insertionSemaphore.availablePermits());
                    insertionSemaphore.acquire();
                    break;
                case 1:
                    System.out.println("Semaphore delete acquire(). Permits: " + deletionSemaphore.availablePermits());
                    deletionSemaphore.acquire();
                    break;
                case 2:
                    System.out.println("Semaphore delete acquire(). Permits: " + searchSemaphore.availablePermits());
                    searchSemaphore.acquire();
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        responseObserver.onNext(SemaphoreResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void release(SemaphoreRequest request, StreamObserver<SemaphoreResponse> responseObserver) {
        switch (request.getType()) {
            case 0:
                System.out.println("Semaphore insert release(). Permits: " + insertionSemaphore.availablePermits());
                insertionSemaphore.release();
                break;
            case 1:
                System.out.println("Semaphore delete release(). Permits: " + deletionSemaphore.availablePermits());
                deletionSemaphore.release();
                break;
            case 2:
                System.out.println("Semaphore search release(). Permits: " + searchSemaphore.availablePermits());
                searchSemaphore.release();
                break;
        }
        responseObserver.onNext(SemaphoreResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void permits(SemaphoreRequest request, StreamObserver<SemaphoreResponse> responseObserver) {
        SemaphoreResponse permits = null;
        switch (request.getType()) {
            case 0:
                System.out.println("Semaphore insert availablePermits(). Permits: " + insertionSemaphore.availablePermits());
                permits = SemaphoreResponse.newBuilder().setPermits(insertionSemaphore.availablePermits()).build();
                break;
            case 1:
                System.out.println("Semaphore delete availablePermits(). Permits: " + deletionSemaphore.availablePermits());
                permits = SemaphoreResponse.newBuilder().setPermits(deletionSemaphore.availablePermits()).build();
                break;
            case 2:
                System.out.println("Semaphore search availablePermits(). Permits: " + searchSemaphore.availablePermits());
                permits = SemaphoreResponse.newBuilder().setPermits(searchSemaphore.availablePermits()).build();
                break;
        }
        responseObserver.onNext(permits);
        responseObserver.onCompleted();
    }

}
