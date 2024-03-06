package com.java.controller;

import com.java.entity.Job;
import com.java.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<Object> findAllJobs() {
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @PostMapping
    public ResponseEntity<Object> addJob(@RequestBody Job job) {
        jobService.addJob(job);
        return ResponseEntity.ok("Job added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findJob(@PathVariable Long id) {
        Job job = jobService.findJob(id);
        if (job == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No job found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(job);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeJob(@PathVariable Long id) {
        boolean removeJob = jobService.removeJob(id);
        if(removeJob){
            return ResponseEntity.ok("Job " + id + " deleted successfully");
        } else {
            return ResponseEntity.ok("No job found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean updateJob = jobService.updateJob(id, job);
        if(updateJob){
            return ResponseEntity.ok("Job " + id + " updated successfully");
        } else {
            return ResponseEntity.ok("No job found");
        }
    }

}
