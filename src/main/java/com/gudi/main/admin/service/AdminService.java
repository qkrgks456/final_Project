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
			list= dao.insertSearchByNicknameWithAdmin(insertSearch);
			break;
		case "email":
			list= dao.insertSearchByEmailWithAdmin(insertSearch);
			break;
		case "id":
			list= dao.insertSearchByIdWithAdmin(insertSearch);
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

	public HashMap<String, Object> boardList() {
		logger.info("게시글 조회 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		list = dao.boardList();
		map.put("list",list);
		return map;
	}

	public HashMap<String, Object> commentList() {
		logger.info("댓글 조회 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		list = dao.commentList();
		logger.info("댓글 갯수: "+list.size());
		map.put("list",list);
		return map;
	}

	public HashMap<String, Object> reportCommentList() {
		logger.info("신고댓글 조회 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		list = dao.reportCommentList();
		map.put("list",list);
		return map;
	}

	public HashMap<String, Object> memberInfoSearch(String selectType, String memberInfoSearch) {
		logger.info("회원정보 검색 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		switch(selectType){
		case "nickName":
			list= dao.memberInfoSearchByNickName(memberInfoSearch);
			break;
		case "email":
			list= dao.memberInfoSearchByEmail(memberInfoSearch);
			break;
		case "id":
			list= dao.memberInfoSearchById(memberInfoSearch);
			break;
		}
		map.put("list",list);
		logger.info("돌아온값: " + list.size());
		return map;
	}

	public HashMap<String, Object> boardListSearch(String selectType, String boardListSearch) {
		logger.info("게시글 리스트 검색 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		switch(selectType){
		case "title":
			list= dao.boardListSearchBytitle(boardListSearch);
			break;
		case "email":
			list= dao.boardListSearchByEmail(boardListSearch);
			break;
		case "id":
			list= dao.boardListSearchById(boardListSearch);
			break;
		}
		map.put("list",list);
		logger.info("돌아온값: " + list.size());
		return map;
	}

	public HashMap<String, Object> commentListSearch(String selectType, String commentListSearch) {
		logger.info("게시글 리스트 검색 서비스");
		list = new ArrayList<MemberDTO>();
		map = new HashMap<String , Object>();
		switch(selectType){
		case "content":
			list= dao.commentListSearchByContent(commentListSearch);
			break;
		case "email":
			list= dao.commentListSearchByEmail(commentListSearch);
			break;
		case "id":
			list= dao.commentListSearchById(commentListSearch);
			break;
		}
		map.put("list",list);
		logger.info("돌아온값: " + list.size());
		return map;
	}

	
	
	
}
