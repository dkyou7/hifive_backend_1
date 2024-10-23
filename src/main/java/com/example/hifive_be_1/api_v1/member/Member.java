package com.example.hifive_be_1.api_v1.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;    // 고유값
    private String kakaoUserId;  // 유저 아이디(카카오가 반환해주는 ID)
    private int mateCount;  // 만남 횟수
}
