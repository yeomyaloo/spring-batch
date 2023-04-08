package com.spring.batch.practice.springbatchpractice.listener;
import com.spring.batch.practice.springbatchpractice.domain.Person;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 배치 마지막 부분으로 작업이 완료됐을 떄 알림을 보내는 리스너입니다.
 * */
@Component
@RequiredArgsConstructor
public class JobCompletionNotificationListener implements JobExecutionListener {


    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);


    private final JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("JOB FINISHED");
            jdbcTemplate.query("SELECT first_name, last_name FROM people", (rs, row) -> new Person(
                    rs.getString(1),
                    rs.getString(2))).forEach(person -> log.info("found < {{}} in the database", person));
        }
    }
}
