package com.example.springbatchapiserver.member.controller;


import com.example.springbatchapiserver.member.domain.dto.BirthdayMemberResponse;
import com.example.springbatchapiserver.member.domain.dto.MemberRequestDto;
import com.example.springbatchapiserver.member.domain.dto.MemberResponseDto;
import com.example.springbatchapiserver.member.domain.entity.Member;
import com.example.springbatchapiserver.member.service.QueryMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service/members")
@RequiredArgsConstructor
public class QueryMemberRestController {

    private final QueryMemberService queryMemberService;

    @GetMapping("/birthday")
    public ResponseEntity<List<BirthdayMemberResponse>> getBirthdayMembers(@RequestParam(name = "laterDay") String laterDay){
        List<BirthdayMemberResponse> responses = queryMemberService.findBirthdayMemberByLaterDay(laterDay);

        return ResponseEntity.ok(responses);

    }

    @PutMapping("/sleeperAccount")
    public ResponseEntity<List<MemberResponseDto>> getSleeperAccountMembers(MemberRequestDto request){
        List<MemberResponseDto> sleeperAccountMember = queryMemberService.findSleeperAccountMember(request);

        return ResponseEntity.ok(sleeperAccountMember);

    }
}
