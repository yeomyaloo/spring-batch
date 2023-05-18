package com.example.springbatchapiserver.member.controller;


import com.example.springbatchapiserver.member.domain.dto.BirthdayMemberResponse;
import com.example.springbatchapiserver.member.service.QueryMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class QueryMemberRestController {

    private final QueryMemberService queryMemberService;

    @GetMapping("/birthday")
    public ResponseEntity<List<BirthdayMemberResponse>> getBirthdayMember(@RequestParam(name = "laterDay") String laterDay){
        List<BirthdayMemberResponse> responses = queryMemberService.getBirthdayMemberByLaterDay(laterDay);

        return ResponseEntity.ok(responses);

    }
}
