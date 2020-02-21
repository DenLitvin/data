package com.test.dao;
import java.util.List;
import com.test.entity.Record;

public interface IRecordDAO {
    List<Record> getAllRecords();
    Record getRecordById(int recordId);
}
 