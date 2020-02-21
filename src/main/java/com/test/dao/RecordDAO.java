package com.test.dao;
import java.util.List;

import com.test.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.RecordRowMapper;
@Transactional
@Repository
public class RecordDAO implements IRecordDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public Record getRecordById(int recordId) {
		String sql = "SELECT id, name, type FROM records WHERE id = ?";
		RowMapper<Record> rowMapper = new BeanPropertyRowMapper<Record>(Record.class);
		Record record = jdbcTemplate.queryForObject(sql, rowMapper, recordId);
		return record;
	}
	@Override
	public List<Record> getAllRecords() {
		String sql = "SELECT id, name, type FROM records";
        //RowMapper<Record> rowMapper = new BeanPropertyRowMapper<Record>(Record.class);
		RowMapper<Record> rowMapper = new RecordRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	


}
