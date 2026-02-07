package com.example.studygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Arrays;

@Controller
public class StudyController {

    // 1. 스터디 목록 화면 (GET /study)
    @GetMapping("/study")
    public String list(Model model) {
        // 리더 미션: 우선 더미 데이터로 화면 완성하기
        model.addAttribute("studies", Arrays.asList("일본어 스터디", "자바 스프링 스터디", "리액트 기초"));
        return "study/list"; // templates/study/list.html 파일을 찾음
    }

    // 2. 스터디 상세 화면 (GET /study/{id})
    @GetMapping("/study/{id}")
    public String detail(@PathVariable Long id, Model model) {
        // 1. 클릭한 스터디 번호를 화면에 전달
        model.addAttribute("studyId", id);

        // 2. 번호에 따라 다른 제목이 나오도록 임시 설정 (나중엔 DB에서 가져올 거예요)
        String title = (id == 1) ? "일본어 기초 회화" : "스프링 부트 입문";
        model.addAttribute("title", title);
        model.addAttribute("content", "이 스터디는 " + title + "를 공부하는 모임입니다. 열공해요!");

        return "study/detail"; // templates/study/detail.html 파일을 보여줌
    }
}