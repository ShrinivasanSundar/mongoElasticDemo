package com.example.demo.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public interface UserSearchRepository extends ElasticsearchRepository<User, String> {

}
