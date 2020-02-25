package com.test.client;

import com.test.entity.Record;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientUtil {

	public void getAllRecordsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/v1/records";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Record[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Record[].class);
        Record[] records = responseEntity.getBody();
        for(Record record : records) {
              System.out.println("Id:"+ record.getRecordId()+", Title:"+ record.getRecordName()
                      +", Category: "+ record.getRecordType());
        }
    }



    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getRecordByIdDemo();
    	util.getAllRecordsDemo();
    }    
}
