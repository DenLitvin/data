package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.dao.IRecordDAO;
import com.test.entity.Record;
@Service
public class RecordService implements IRecordService {
	@Autowired
	@Qualifier("recordDaoCsv")
	private IRecordDAO recordDAO;
	@Override
	public Record getArticleById(int articleId) {
		Record obj = recordDAO.getRecordById(articleId);
		return obj;
	}	
	@Override
	public List<Record> getAllArticles(){
		return recordDAO.getAllRecords();
	}

}
