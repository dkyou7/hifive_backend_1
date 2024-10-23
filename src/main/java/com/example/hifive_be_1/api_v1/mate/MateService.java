package com.example.hifive_be_1.api_v1.mate;

import com.example.hifive_be_1.api_v1.member.Member;
import com.example.hifive_be_1.api_v1.member.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Service
@Transactional
@RequiredArgsConstructor
public class MateService {
    private final MateRepository mateRepository;
    private final MemberRepository memberRepository;

    /**
     * QR 생성 로직
     * @param user_id QR 생성자
     */
    public void createQr(String user_id){
        Member member = memberRepository.findById(Long.valueOf(user_id)).get();

        MemberMate memberMate = new MemberMate();
        memberMate.setMemberFrom(member);
        memberMate.setCreatedDate(LocalDateTime.now());
        mateRepository.save(memberMate);
    }

    /**
     * 인증 첫번째 단계.
     */
    public String authFirst(String mateId, String userTo){
        MemberMate memberMate = mateRepository.findById(Long.valueOf(mateId)).get();
        LocalDateTime createdDate = memberMate.getCreatedDate().plusMinutes(10);

        // 현재 시각과 차이가 많이 난다면 제외
        // 10분 내로 인증이 되었는가
        if(createdDate.isAfter(LocalDateTime.now())){
            memberMate.setUpdatedDate(LocalDateTime.now());
            memberMate.setSuccess(true);
            memberMate.getMemberFrom().setMateCount(memberMate.getMemberFrom().getMateCount()+1);
            memberMate.setMemberTo(userTo);
            return "success";
        }
        memberMate.setUpdatedDate(LocalDateTime.now());
        memberMate.setSuccess(false);
        return "fail";
    }
}
