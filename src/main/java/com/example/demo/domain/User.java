package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="user")
@org.springframework.data.elasticsearch.annotations.Document(indexName="user")
public class User {

	@Id
	private String id;
	
	private String name;
	
	private String course;
	
	private String companyName;
	
	
}
