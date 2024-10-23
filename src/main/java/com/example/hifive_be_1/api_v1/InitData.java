package com.example.hifive_be_1.api_v1;

import com.example.hifive_be_1.api_v1.member.Member;
import com.example.hifive_be_1.api_v1.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            Member member = new Member();
            member.setKakaoUserId(""+i);
            memberRepository.save(member);
        }
    }
}