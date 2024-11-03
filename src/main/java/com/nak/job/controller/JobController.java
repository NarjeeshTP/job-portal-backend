package com.nak.job.controller;

import com.nak.job.model.Job;
import com.nak.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    // Create a new job
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        try {
            Job savedJob = jobRepository.save(job);
            return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        try {
            List<Job> jobs = jobRepository.findAll();
            if (jobs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a job by ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") String id) {
        Optional<Job> jobData = jobRepository.findById(id);
        return jobData.map(job -> new ResponseEntity<>(job, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a job by ID
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable("id") String id, @RequestBody Job jobDetails) {
        Optional<Job> jobData = jobRepository.findById(id);

        if (jobData.isPresent()) {
            Job job = jobData.get();
            job.setTitle(jobDetails.getTitle());
            job.setDescription(jobDetails.getDescription());
            job.setLocation(jobDetails.getLocation());
            job.setCompany(jobDetails.getCompany());
            job.setEmploymentType(jobDetails.getEmploymentType());
            job.setSalary(jobDetails.getSalary());
            return new ResponseEntity<>(jobRepository.save(job), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteJob(@PathVariable("id") String id) {
        try {
            jobRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all jobs
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllJobs() {
        try {
            jobRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
 // Search for jobs using MongoDB Atlas Search
    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam("query") String query) {
        try {
            List<Job> jobs = jobRepository.searchJobs(query);
            if (jobs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
