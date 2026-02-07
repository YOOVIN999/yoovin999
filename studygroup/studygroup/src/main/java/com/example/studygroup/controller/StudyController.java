package com.example.studygroup.controller; // 1. 패키지 경로 선언

// 2. 필요한 도구들(import) 불러오기
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Arrays;
import java.util.List;

@Controller // 이제 인텔리제이가 이 'Controller'가 뭔지 알게 됩니다.
public class StudyController {

    @GetMapping("/study")
    public String list(Model model) {
        // 4개의 고유한 스터디 제목 목록
        List<String> studies = Arrays.asList(
                "프로그래밍 공부하는 사람들 모임",
                "일본어 기초 회화 스터디",
                "토익 900점 목표 달성방",
                "포토샵/일러스트 실무 과외"
        );
        model.addAttribute("studies", studies);
        return "study/list";
    }

    @GetMapping("/study/{id}")
    public String detail(@PathVariable int id, Model model) {
        String title;
        String content;

        // ID에 따른 개별 데이터 분기 (데모용)
        switch (id) {
            case 1:
                title = "프로그래밍 공부하는 사람들 모임";
                content = "자바와 스프링 부트를 함께 공부하며 백엔드 개발자로 성장할 분들을 모십니다. 매주 토요일 강남역에서 모여요.";
                break;
            case 2:
                title = "일본어 기초 회화 스터디";
                content = "JLPT N3 수준의 회화를 목표로 합니다. 원어민 선생님과 함께 실생활 표현 위주로 학습합니다.";
                break;
            case 3:
                title = "토익 900점 목표 달성방";
                content = "단기간에 고득점이 필요한 취준생들을 위한 빡센 스터디입니다. 매일 단어 시험과 LC/RC 풀이를 진행합니다.";
                break;
            case 4:
                title = "포토샵/일러스트 실무 과외";
                content = "디자인 비전공자도 가능! 실무에서 바로 써먹는 툴 사용법과 레이아웃 구성법을 공유합니다.";
                break;
            default:
                title = "알 수 없는 스터디";
                content = "정보를 찾을 수 없습니다.";
                break;
        }

        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("studyId", id);
        return "study/detail";
    }
}