package com.example.hifive_be_1.api_v1.mate;

import com.example.hifive_be_1.api_v1.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class MemberMate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_mate_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberFrom;      // QR 찍는 사람

    private String memberTo;        // QR 생성한 사람

    private boolean isSuccess;  // 만남 성사 여부

    private LocalDateTime createdDate; // QR 생성 시간

    // updatedDate 찍혔을 때 10분 내로 없다면 isSuccess = false 로 하는 로직.
    private LocalDateTime updatedDate; // QR 찍힌 시간
}
