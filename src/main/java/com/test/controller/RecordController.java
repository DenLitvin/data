package com.test.controller;
import java.io.File;
import java.io.IOException;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


    @RequestMapping(value = "/records", method = RequestMethod.GET, produces="application/octet-stream")
    public void downloadFile(HttpServletResponse response,
                             HttpServletRequest request) throws IOException
    {
        byte[] pdf = new byte[]{1,2,3};

        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", "attachment; filename=foo.foo");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.getOutputStream().write(pdf);
    }


} 