package com.test.service;

import java.util.List;

import com.test.entity.Record;

public interface IRecordService {
     List<Record> getAllArticles();
     Record getArticleById(int articleId);
}
