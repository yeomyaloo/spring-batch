package com.example.springbatchscheduler.member.service;


import com.example.springbatchscheduler.config.ServerConfig;
import com.example.springbatchscheduler.member.dto.MemberIdResponseDto;
import com.example.springbatchscheduler.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class QueryMemberServiceImpl implements QueryMemberService{

    private final RestTemplate restTemplate;
    private final ServerConfig serverConfig;
    private final static String PATH = "/api/service/members";

    @Override
    public List<MemberIdResponseDto> findBirthdayMemberByLaterDay(String laterDay) {

        String uri = UriComponentsBuilder.fromHttpUrl(serverConfig.getApiServerUrl() + PATH + "/birthday").queryParam("laterDay",laterDay).encode().toUriString();

        ResponseEntity<ResponseEntity<List<MemberIdResponseDto>>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseEntity<List<MemberIdResponseDto>>>() {
        });

        return Objects.requireNonNull(response.getBody().getBody());
    }

    @Override
    public List<MemberIdResponseDto> findSleeperAccountMembers(MemberRequestDto requestDto) {

        String uri = UriComponentsBuilder.fromHttpUrl(serverConfig.getApiServerUrl() + PATH + "/sleeperAccount").encode().toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MemberIdResponseDto> httpEntity = new HttpEntity(headers);

        ResponseEntity<List<MemberIdResponseDto>> response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, new ParameterizedTypeReference<List<MemberIdResponseDto>>() {
        });
        return Objects.requireNonNull(response.getBody());
    }


}
