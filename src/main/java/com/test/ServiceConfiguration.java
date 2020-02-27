package com.test;

import com.test.dao.IRecordDAO;
import com.test.dao.RecordDaoCsv;
import com.test.flight.ArrowFlightServer;
import org.apache.arrow.flight.Location;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {


    @Bean(name = "recordDaoCsv")
    public IRecordDAO recordDAO() {
        return new RecordDaoCsv();
    }

    @Bean
    public ArrowFlightServer flightServer(){
        final BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE);
        return new ArrowFlightServer(allocator, Location.forGrpcInsecure("localhost", 31337));

    }




}
