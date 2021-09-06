package com.gudi.main.member.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/kakao")
public class KakaoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 카카오 로그인 폼으로 이동
    @RequestMapping(value = "/loginForm")
    public String loginForm() throws Exception {
        {
            String reqUrl =
                    "redirect:https://kauth.kakao.com/oauth/authorize"
                            + "?client_id=510dfee7db026dbcc8df7b0a51993201"
                            + "&redirect_uri=http://localhost:8090/final_Project/kakao/callback"
                            + "&response_type=code";
            logger.info(reqUrl);
            return reqUrl;
        }
    }

    // 카카오 code 받아서 토큰 만들기
    @RequestMapping(value = "/callback")
    public String callback(@RequestParam String code, Model model) throws Exception {
        System.out.println("code" + code);
        // 요 라이브러리 추천 받음
        RestTemplate restTemplate = new RestTemplate();
        // 헤더 생성
        HttpHeaders headers = new HttpHeaders();
        // 헤더에 속성값 넣어주기
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        // 저 params 에다가 카카오 공식 개발 파라미터 삽입하기
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "510dfee7db026dbcc8df7b0a51993201");
        params.add("redirect_uri", "http://localhost:8090/final_Project/kakao/callback");
        params.add("code", code);
        // 헤더랑 파라미터 담은녀석
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
        // response 받기
        ResponseEntity<String> response = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        // json 형태로 만들어버리기
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(response.getBody().toString());
        JSONObject jsonObject = (JSONObject) obj;
        // 엑세스 토큰 획득 기모띠
        String access_token = (String)jsonObject.get("access_token");
        return "redirect:/kakao/memberInfo/"+access_token;
    }
    // 로그인한 회원정보 받아오기
    @RequestMapping(value = "/memberInfo/{access_token}")
    public String memberInfo(@PathVariable String access_token,HttpSession session) throws Exception {
        System.out.println(access_token);
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
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        // json 형태로 만들어버리기
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(response.getBody().toString());
        JSONObject jsonObject = (JSONObject) obj;
        // 회원정보 획득 기모띠
        System.out.println(jsonObject.get("kakao_account"));
        // 이 사이에 DB에 있는지 확인해서 없으면 넣어주고 있으면 통과
        // 회원 아이디 숫자로 되어있음
        session.setAttribute("loginId",jsonObject.get("id"));
        session.setAttribute("access_token",access_token);
        return "main";
    }
}
