package com.example.hifive_be_1.api_v1.mate;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mate")
@RequiredArgsConstructor
public class MateController {

    private final MateService mateService;

    /**
     * QR 코드 내용 DB 저장
     *
     * @param userid
     */
    @GetMapping("createQr")
    public void createQr(@RequestParam(name = "user_id") String userid) {
        mateService.createQr(userid);
    }

    /**
     * 큐알 스캐너의 활동
     * QR 코드 내용 DB 저장
     *
     * @param mateid
     * @param userTo 상대방 userId
     */
    @GetMapping("authFirst")
    public String authFirst(
            @RequestParam(name = "mate_id") String mateid,
            @RequestParam(name = "user_to") String userTo) {
        return mateService.authFirst(mateid, userTo);
    }
}
