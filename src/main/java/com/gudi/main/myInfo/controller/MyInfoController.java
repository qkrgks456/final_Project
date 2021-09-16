package com.gudi.main.myInfo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/myInfo")
public class MyInfoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
 
    /*
    @RequestMapping(value = "/memberUpdate")
    public String myInfo() {
      	logger.info("회원정보 수정페이지");
        return "member/myInfo/information/memberUpdate";
    }  
    */
  
//    @RequestMapping(value = "/memberUpdate/{contentId}")
    @RequestMapping(value = "/memberUpdate")
	public String myInfo(Model model, /* @PathVariable String contentId, */ HttpSession session) {
		HashMap<String, Object> map/* =Service.myinfoservice(contentId, session) */;
        model.addAttribute("map");
        return "member/myInfo/information/memberUpdate";
    }
    
    @RequestMapping(value = "/memberDrop")
    public String memberDrop() {
        return "member/myInfo/information/memberDrop";
    }
    @RequestMapping(value = "/campingClear")
    public String campingClear() {
        return "member/myInfo/list/campingClear";
    }
    @RequestMapping(value = "/campingTalk")
    public String campingTalk() {
        return "member/myInfo/list/campingTalk";
    }
    @RequestMapping(value = "/comment")
    public String comment() {
        return "member/myInfo/list/comment";
    }
    @RequestMapping(value = "/wantToGo")
    public String wantToGo() {
        return "member/myInfo/list/wantToGo";
    }
    @RequestMapping(value = "/reserveCheck")
    public String reserveCheck() {
        return "member/myInfo/reserve/reserveCheck";
    }
    @RequestMapping(value = "/reserveCancel")
    public String reserveCancel() {
        return "member/myInfo/reserve/reserveCancel";
    }
}
