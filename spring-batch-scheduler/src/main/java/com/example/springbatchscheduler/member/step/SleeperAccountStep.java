package com.example.springbatchscheduler.member.step;

import com.example.springbatchscheduler.member.dto.MemberIdResponseDto;
import com.example.springbatchscheduler.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@RequiredArgsConstructor
@Slf4j
@Configuration
public class SleeperAccountStep {


    private final SleeperAccountItem item;

    private JobRepository jobRepository;
    private PlatformTransactionManager transactionManager;

    private final static int CHUNK_SIZE = 100;

    @Bean
    public Step changeSleeperStatusStep(){
        return new StepBuilder("changeSleeperStatusStep", jobRepository)
                .<MemberIdResponseDto, MemberRequestDto>chunk(CHUNK_SIZE)
                .reader(item.sleeperAccountReader())
                .processor(item.sleeperAccountProcessor())
                .writer(item.sleeperAccountWriter())
                .faultTolerant()
                .retry(NullPointerException.class)
                .retryLimit(5)
                .build();
    }


}
