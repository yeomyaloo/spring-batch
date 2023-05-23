package com.example.springbatchscheduler.member.job;


import com.example.springbatchscheduler.member.dto.MemberIdResponseDto;
import com.example.springbatchscheduler.member.dto.MemberRequestDto;
import com.example.springbatchscheduler.member.dto.MemberSleeperAccountRequest;
import com.example.springbatchscheduler.member.service.QueryMemberService;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Objects;

/**
 * 최근 1년간 로그인 흔적이 없는 회원을 휴먼 회원 처리하는 job입ㄴ다
 * */

@RequiredArgsConstructor
@Slf4j
public class SleeperAccountStep {

    private final JobBuilder jobBuilder;
    private final StepBuilder stepBuilder;
    private final EntityManagerFactory entityManagerFactory;
    private final static int CHUNK_SIZE = 100;

    private final QueryMemberService queryMemberService;

    private List<MemberSleeperAccountRequest> requestList;


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


    @Bean
    public ItemProcessor<MemberIdResponseDto, MemberSleeperAccountRequest> sleeperAccountProcessor(){
        return item -> {
            //TODO : 해당 클래스명 변경하기
            MemberSleeperAccountRequest request = new MemberSleeperAccountRequest(item.getMemberId());
            this.requestList.forEach(
                    member -> {
                        request.getMemberId();
                    }
            );
            return request;
        };

    }

    //TODO: 중간 가공 PROCESSOR, WRITER작업 완료하기, 가져온 회원 PK로 회원 데이터 변경하기 isSleeperAccount -> true로 만들기
    @Bean
    public ItemWriter<MemberIdResponseDto> sleeperAccountWriter(){
        return item -> {


        }

    }

    private void changeSleeperAccount(MemberRequestDto dto) {


        return Objects.requireNonNull(queryMemberService.findSleeperAccountMembers(dto));

    }



}
