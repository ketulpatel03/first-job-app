package com.java.service;

import com.java.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    void addJob(Job job);

    boolean removeJob(Long id);

    Job findJob(Long id);

    boolean updateJob(Long id, Job job);

}
