package com.example.springbatchscheduler.member.job;

import com.example.springbatchscheduler.config.ServerConfig;
import com.example.springbatchscheduler.member.dto.MemberIdResponseDto;
import com.example.springbatchscheduler.member.service.QueryMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
public class BirthdayCouponStep {

    private final QueryMemberService queryMemberService;
    private final RestTemplate restTemplate;
    private final ServerConfig serverConfig;

    private final StepBuilder stepBuilder;
    @Bean
    public ListItemReader<MemberIdResponseDto> listItemReader(@Value("#{jobParameters['laterDay']}") String laterDay){

        List<MemberIdResponseDto> birthdayMemberByLaterDay = queryMemberService.findBirthdayMemberByLaterDay(laterDay);

        if (birthdayMemberByLaterDay.isEmpty()){
            log.info("birthday member is not exist");
            return null;
        }

        //TODO: 여기에 이제 쿠폰 발급 관련 서비스 로직처리
        return null;

    }
}
