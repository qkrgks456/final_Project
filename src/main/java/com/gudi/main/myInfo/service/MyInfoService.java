package com.gudi.main.myInfo.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.gudi.main.dtoAll.ReserveDTO;
import com.gudi.main.myInfo.dto.MyInfoDTO;
import com.gudi.main.util.HansolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.dtoAll.MemberDTO;
import com.gudi.main.myInfo.dao.MyInfoMapper;

@Service
public class MyInfoService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MyInfoMapper dao;

    public MemberDTO myInfoData(String loginId) {
        MemberDTO dto = dao.myInfoData(loginId);
        return dto;
    }

    public void infoUpdate(String nickName, String loginId) {
        dao.infoUpdate(loginId,nickName);
    }

    public String pwCheck(String loginId) {
        return dao.pwCheck(loginId);
    }

    public void pwUpdate(String pwChange, String loginId) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String enc_pass = encoder.encode(pwChange);
        dao.pwUpdate(enc_pass,loginId);
    }

    public void memberDropReal(String loginId) {
        dao.memberDropReal(loginId);
    }

    public HashMap<String, Object> reserveList(String loginId, int page) {
        int start = 0;
        if (page != 1) {
            start = (page - 1) * 8;
        }
        int total = dao.reserveTotal(loginId);
        HashMap<String,Object> map = HansolUtil.pagination(page,15,total);

        ArrayList<MyInfoDTO> list = dao.reserveList(loginId,start);
        map.put("list",list);
        return map;
    }
}
