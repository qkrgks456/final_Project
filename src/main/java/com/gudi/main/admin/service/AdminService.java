package com.gudi.main.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudi.main.admin.dao.AdminMapper;
import com.gudi.main.dtoAll.MemberDTO;

@Service
public class AdminService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired AdminMapper dao;
	ArrayList<MemberDTO> list = null;
	HashMap<String , Object> map = null;
	
	public HashMap<String, Object> adminSearch() {
		logger.info("관리자 조회 서비스");
		map = new HashMap<String , Object>();
		list = new ArrayList<MemberDTO>();
		list = dao.adminList();
		map.put("list", list);
		logger.info("서비스 받아온 후");
		return map;
	}

	public HashMap<String, Object> adminInsertList() {
		logger.info("관리자 임명 리스트 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		
		list = dao.adminInsertList();
		map.put("list",list);
		
		return map;
	}

	public HashMap<String, Object> memberReserve() {
		logger.info("예약자 조회 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		list = dao.memberReserve();
		map.put("list",list);
		logger.info("예약자 수: " + list.size());
		return map;
	}

	public HashMap<String, Object> memberInfo() {
		logger.info("회원 조회 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		list = dao.memberInfo();
		map.put("list",list);
		return map;
	}

	public String adminInsert(String id) {
		logger.info("관리자 임명 서비스");
		dao.adminInsert(id);
		return null;
	}

	public HashMap<String, Object> insertSearch(String selectType, String insertSearch) {
		logger.info("관리자 임명 검색 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		switch(selectType){
		case "nickName":
			list= dao.insertSearchByNickname(insertSearch);
			break;
		case "email":
			list= dao.insertSearchByEmail(insertSearch);
			break;
		case "id":
			list= dao.insertSearchById(insertSearch);
			break;
		}
		// 이름 list= dao.insertSearchByNickname(insertSearch);
		//아이디
		//이메일
		map.put("list",list);
		logger.info("돌아온값: " + list.size());
		return map;
	}

	public int adminDelete(String id) {
		int success = dao.adminDelete(id);
		return success;
	}

	
	
	
}
