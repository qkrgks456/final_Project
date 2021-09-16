package com.gudi.main.myInfo.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.dtoAll.MemberDTO;
import com.gudi.main.myInfo.dao.MyInfoMapper;

@Service
public class MyInfoService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MyInfoMapper dao;
	ArrayList<MemberDTO> list = null;
	HashMap<String , Object> map = null;
	
	public HashMap<String, Object> myInfo() {
		logger.info("회원 조회 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		list = dao.myInfo();
		map.put("list",list);
		return map;
	}
}
