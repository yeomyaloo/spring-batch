package com.example.springbatchscheduler.member.config;


import com.example.springbatchscheduler.member.step.SleeperAccountStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class MemberJobConfiguration {

    private final Step changeSleeperStatusStep;


    /**
     * 1년간 접속하지 않은 회원을 조회하여 휴먼 회원으로 변경하는 작업을 수행하는 step 수행 job입니다.
     *
     * @return step 실행 job
     * */
    @Bean
    public Job changeSleeperStatusJob(){
        return new JobBuilder("changeSleeperStatusJob")
                .start(changeSleeperStatusStep)
                .build();
    }

}
