package com.test.client;

import com.test.grpc.RecordRequest;
import com.test.grpc.RecordResponse;
import com.test.grpc.RecordServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrpcTest {

    @Test
    public void test() {

        ManagedChannel channel=ManagedChannelBuilder.forAddress("localhost",7565).usePlaintext().build();
        RecordServiceGrpc.RecordServiceBlockingStub stub=RecordServiceGrpc.newBlockingStub(channel);

        RecordRequest request = RecordRequest.newBuilder().build();

        RecordResponse response = stub.getRecords(request);
        System.out.println(response.getRecord());
    }

}
