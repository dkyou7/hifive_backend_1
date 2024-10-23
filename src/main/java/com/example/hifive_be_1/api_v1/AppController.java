package com.example.hifive_be_1.api_v1;

import com.example.hifive_be_1.api_v1.member.Member;
import com.example.hifive_be_1.api_v1.member.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apiV1")
@RequiredArgsConstructor
public class AppController {

    private final MemberService memberService;

    @GetMapping("memberList")
    public List<Member> mate(){
        List<Member> findAllMember = memberService.findAll();
        return findAllMember;
    }
}
