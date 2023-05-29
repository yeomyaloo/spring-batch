package com.example.springbatchscheduler.member.config.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SleeperAccountScheduler {

    private final JobLauncher jobLauncher;

    private final Job job;

    @Scheduled()
    public void sleeperAccountRun(){


    }
}
