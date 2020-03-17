package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;


@EnableMetrics
@EnableMongoRepositories("com.example.demo.repository")
@EnableElasticsearchRepositories("com.example.demo.elastic.repository")
@SpringBootApplication
public class DemoApplication implements WebMvcConfigurer  {


    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
