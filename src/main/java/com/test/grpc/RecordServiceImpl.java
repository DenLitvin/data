package com.test.grpc;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GRpcService
public class RecordServiceImpl extends RecordServiceGrpc.RecordServiceImplBase {

    Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);

    public void getRecords(com.test.grpc.RecordRequest request,
                           io.grpc.stub.StreamObserver<com.test.grpc.RecordResponse> responseObserver) {
        logger.info(request.toString());
        String record = new StringBuilder()
                .append("test ")
                .toString();
        RecordResponse response = RecordResponse.newBuilder().setRecord(record).build();
        logger.debug(response.toString());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
