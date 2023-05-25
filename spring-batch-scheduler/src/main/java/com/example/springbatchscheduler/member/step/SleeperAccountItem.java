package com.example.springbatchscheduler.member.step;


import com.example.springbatchscheduler.member.dto.MemberIdResponseDto;
import com.example.springbatchscheduler.member.dto.MemberRequestDto;
import com.example.springbatchscheduler.member.service.QueryMemberService;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 최근 1년간 로그인 흔적이 없는 회원을 휴먼 회원 처리하는 item(reader, processor, writer) 입니다.
 *
 * */

@RequiredArgsConstructor
@Slf4j
@Configuration
public class SleeperAccountItem {

    private final JobBuilder jobBuilder;
    private final StepBuilder stepBuilder;
    private final EntityManagerFactory entityManagerFactory;
    private final static int CHUNK_SIZE = 100;

    private final QueryMemberService queryMemberService;
    private List<MemberRequestDto> requestDto = new ArrayList<>();

    /**
     * jpaCursorItemReader를 사용한 휴먼 회원을 찾아올 때 사용하는 itemReader입니다.
     *
     * @return 휴먼 회원 목록
     * */
    @Bean
    public JpaCursorItemReader<MemberIdResponseDto> sleeperAccountReader(){
        String query = "SELECT mh.member_id From member_login history as mh" +
                "where login_time >= DATE_ADD(NOW(), INTERVAL -12 MONTH";

        return new JpaCursorItemReaderBuilder<MemberIdResponseDto>()
                .name("sleeperAccountItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString(query)
                .build();
    }


    /**
     * 휴먼 회원 목록을 Response dto로 받아와서 휴먼회원으로 변경하는 요청에 사용할 request dto로 변환
     *
     * @return 휴먼 회원 변경에 사용하는 response dto로 변환 processor
     * */

    @Bean
    public ItemProcessor<MemberIdResponseDto, MemberRequestDto> sleeperAccountProcessor(){
        return item -> {
            MemberRequestDto memberRequestDto = new MemberRequestDto(item.getMemberId());
            this.requestDto.forEach(sleeper -> {
                requestDto.add(memberRequestDto);
            });
            return memberRequestDto;
        };
        
    }
    @Bean
    public ItemWriter<MemberRequestDto> sleeperAccountWriter(){
        return item ->{
            Objects.requireNonNull(queryMemberService.findSleeperAccountMembers((List<MemberRequestDto>) item));
        };

    }

    @Bean



}
