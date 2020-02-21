package com.test.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.test.entity.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Repository
public class RecordDaoCsv implements IRecordDAO {
    Logger logger = LoggerFactory.getLogger(RecordDaoCsv.class);
    @Override
    public List<Record> getAllRecords() {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource("data.csv").getFile();
            MappingIterator<Record> readValues =
                    mapper.reader(Record.class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return Collections.emptyList();
        }
    }



    @Override
    public Record getRecordById(int recordId) {
        return null;
    }

}
