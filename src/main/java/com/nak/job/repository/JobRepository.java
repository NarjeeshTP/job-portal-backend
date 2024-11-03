package com.nak.job.repository;

import com.nak.job.model.Job;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {

    @Aggregation(pipeline = {
            "{ '$search': { 'index': 'default', 'text': { 'query': ?0, 'path': { 'wildcard': '*' } } } }",
            "{ '$limit': 10 }"
    })
    List<Job> searchJobs(String query);
}
