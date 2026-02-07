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
        // 상세 화면용 더미 데이터
        model.addAttribute("studyId", id);
        model.addAttribute("title", "더미 스터디 제목 " + id);
        model.addAttribute("content", "이것은 리더가 시킨 상세 페이지 더미 내용입니다.");
        return "study/detail"; // templates/study/detail.html 파일을 찾음
    }
}