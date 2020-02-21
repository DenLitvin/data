package com.test.controller;
import java.io.File;
import java.util.List;

import com.test.entity.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.service.IRecordService;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/v1")
public class RecordController {
    Logger logger = LoggerFactory.getLogger(RecordController.class);

	@Autowired
	private IRecordService recordService;

//	@GetMapping("records/{id}")
//	public ResponseEntity<Record> getArticleById(@PathVariable("id") Integer id) {
//		Record record = recordService.getArticleById(id);
//		return new ResponseEntity<Record>(record, HttpStatus.OK);
//	}

    @RequestMapping(value="/records", produces={"application/json"})
	public ResponseEntity<List<Record>> getRecordsinJson() {
		List<Record> list = recordService.getAllArticles();
		return new ResponseEntity<List<Record>>(list, HttpStatus.OK);
	}

    @GetMapping(value = "/records", produces={"text/csv"} )
    public ResponseEntity getRecordsCsv() {
        logger.info("returning csv formatted data");
        try {
            File file = new ClassPathResource("data.csv").getFile();

            return ResponseEntity.ok()
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("text/csv"))
                    .body(new FileSystemResource(file));

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


} 