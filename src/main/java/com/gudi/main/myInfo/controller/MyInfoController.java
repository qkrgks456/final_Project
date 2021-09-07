package com.gudi.main.myInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/myInfo")
public class MyInfoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/memberUpdate")
    public String myInfo() {
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
