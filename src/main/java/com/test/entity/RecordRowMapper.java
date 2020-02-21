package com.test.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RecordRowMapper implements RowMapper<Record> {

	@Override
	public Record mapRow(ResultSet row, int rowNum) throws SQLException {
		Record record = new Record();
		record.setRecordId(row.getInt("id"));
		record.setRecordName(row.getString("name"));
		record.setRecordType(row.getString("type"));
		return record;
	}

}
