package com.java.service;

import com.java.entity.Job;
import com.java.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

//    List<Job> jobs = new ArrayList<>();
//    Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAllJobs() {
//        return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void addJob(Job job) {
//        job.setId(nextId++);
//        jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public boolean removeJob(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getId().equals(id)) {
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }

    }

    @Override
    public Job findJob(Long id) {
//        for (Job j : jobs) {
//            if (j.getId() == id) {
//                return j;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateJob(Long id, Job jobToUpdate) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            job.setTitle(jobToUpdate.getTitle());
            job.setDescription(jobToUpdate.getDescription());
            job.setMinSalary(jobToUpdate.getMinSalary());
            job.setMaxSalary(jobToUpdate.getMaxSalary());
            job.setLocation(jobToUpdate.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}
