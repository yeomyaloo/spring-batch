package com.example.springbatchscheduler.member.service;


import com.example.springbatchscheduler.config.ServerConfig;
import com.example.springbatchscheduler.member.dto.BirthdayMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMemberServiceImpl implements QueryMemberService{

    private final RestTemplate restTemplate;
    private final ServerConfig serverConfig;
    private final

    @Override
    public List<BirthdayMemberResponse> findBirthdayMemberByLaterDay(String laterDay) {

        ResponseEntity<List<BirthdayMemberResponse>>
        return null;
    }
}
