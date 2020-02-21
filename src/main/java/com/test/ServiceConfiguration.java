package com.test;

import com.test.dao.IRecordDAO;
import com.test.dao.RecordDaoCsv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {


    @Bean(name = "recordDaoCsv")
    public IRecordDAO recordDAO() {
        return new RecordDaoCsv();
    }




}
