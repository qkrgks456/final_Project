package com.gudi.main.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.gudi.main.member.service.MemberService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired MemberService service;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    // 로그인 폼으로
    @RequestMapping(value = "/loginForm")
    public String loginForm(Model model) {
        return "member/login/loginForm";
    }
    // 동의 폼으로
    @RequestMapping(value = "/agreeForm")
    public String agreeForm(Model model) {
        return "member/join/agreeForm";
    }
    // 회원가입 폼으로
    @RequestMapping(value = "/joinForm")
    public String joinForm(Model model) {
        return "member/join/joinForm";
    }
    // 회원가입 /member/join
    @RequestMapping(value = "/join")
    public String join(Model model,String id) {
    	logger.info(id);
        return null;
    }

    @RequestMapping(value = "/login")
    public String login(HttpSession session, @RequestParam String InputId,@RequestParam String InputPass) {
    
        return "main";
    }

    // 이거 내비두셈
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception {
        session.removeAttribute("loginId");
        String access_token = (String) session.getAttribute("access_token");
        System.out.println(access_token);
        if(access_token != null){
            // 요 라이브러리 추천 받음
            RestTemplate restTemplate = new RestTemplate();
            // 헤더 생성
            HttpHeaders headers = new HttpHeaders();
            // 헤더에 속성값 넣어주기
            headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            headers.add("Authorization","Bearer "+access_token);
            // 헤더랑 파라미터 담은녀석
            HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(headers);
            // response 받기
            ResponseEntity<String> response = restTemplate.exchange(
                    "https://kapi.kakao.com/v1/user/logout",
                    HttpMethod.POST,
                    kakaoTokenRequest,
                    String.class
            );
            System.out.println("카카오 로그아웃 성공 여부"+response.getBody().toString());
            session.removeAttribute("access_token");
        }
        return "main";
    }


}
