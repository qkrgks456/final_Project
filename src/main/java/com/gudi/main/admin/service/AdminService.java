package com.gudi.main.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudi.main.admin.dao.AdminMapper;
import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.CommentDTO;
import com.gudi.main.dtoAll.CommentReportDTO;
import com.gudi.main.dtoAll.MemberDTO;
import com.gudi.main.dtoAll.ReserveDTO;

@Service
public class AdminService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired AdminMapper dao;
	ArrayList<MemberDTO> list = null;
	HashMap<String , Object> map = null;
	ArrayList<ReserveDTO> list2 = null;
	ArrayList<BoardDTO> list3 = null;
	ArrayList<CommentDTO> list4 = null;
	
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
		list2 = new ArrayList<ReserveDTO>();
		map = new HashMap<String , Object>();
		list2 = dao.memberReserve();
		map.put("list",list2);
		logger.info("예약자 수: " + list2.size());
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
		list3 = new ArrayList<BoardDTO>();
		map = new HashMap<String , Object>();
		list3 = dao.boardList();
		map.put("list",list3);
		return map;
	}

	public HashMap<String, Object> commentList() {
		logger.info("댓글 조회 서비스");
		list4 = new ArrayList<CommentDTO>();
		map = new HashMap<String , Object>();
		list4 = dao.commentList();
		logger.info("댓글 갯수: "+list4.size());
		map.put("list",list4);
		return map;
	}

	public HashMap<String, Object> reportCommentList() {
		logger.info("신고댓글 조회 서비스");
		ArrayList<CommentReportDTO> list5 = new ArrayList<CommentReportDTO>();
		map = new HashMap<String , Object>();
		list5 = dao.reportCommentList();
		map.put("list",list5);
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
		list3 = new ArrayList<BoardDTO>();
		map = new HashMap<String , Object>();
		switch(selectType){
		case "title":
			list3= dao.boardListSearchBytitle(boardListSearch);
			break;
	
		case "id":
			list3= dao.boardListSearchById(boardListSearch);
			break;
		}
		map.put("list",list3);
		logger.info("검색한 게시글 수: " + list3.size());
		return map;
	}

	public HashMap<String, Object> commentListSearch(String selectType, String commentListSearch) {
		logger.info("댓글 리스트 검색 서비스");
		list4 = new ArrayList<CommentDTO>();
		map = new HashMap<String , Object>();
		switch(selectType){
		case "content":
			list4= dao.commentListSearchByContent(commentListSearch);
			break;

		case "id":
			list4= dao.commentListSearchById(commentListSearch);
			break;
		}
		map.put("list",list4);
		logger.info("돌아온값: " + list4.size());
		return map;
	}

	public String memberInfoBlackDel(String id) {
		logger.info("멤버 블랙리스트 제거 서비스");
		logger.info("id: "+id+ "블랙리스트 제거 서비스");
		int success=dao.memberInfoBlackDel(id);
		if(success!=0) {
			logger.info("해제1 성공");
		}
		success=dao.memberInfoBlackDel2(id);
		if(success!=0) {
			logger.info("해제2 성공");
		}
		return null;
	}

	public String memberInfoBlackInsert(String id, String reason) {
		logger.info("블랙리스트 추가 서비스");
		logger.info("id: "+id+ "블랙리스트 추가 서비스");
		int success= dao.memberInfoBlackInsert(id);
		if(success!=0) {
			logger.info("추가1 성공");
		}
		success = dao.memberInfoBlackInsert2(id, reason);
		if(success!=0) {
			logger.info("추가2 성공");
		}
		return null;
	}

	public BoardDTO boardListDetailInfo(String boardNum, String division) {
		logger.info("게시물 상세보기 서비스");
		BoardDTO detail = new BoardDTO();
		map = new HashMap<String , Object>();
		detail=dao.boardListDetailInfo(boardNum,division);
		return detail;
	}

	public void boardListBlack(String boardNum, String division) {
		logger.info("게시글 블랙리스트 추가 서비스");
		int success=0;
		switch(division) {
		case "1":
			success = dao.boardListBlackDivision1(boardNum);
			break;
		case "2":
			success = dao.boardListBlackDivision2(boardNum);
			break;
		case "3":
			success = dao.boardListBlackDivision3(boardNum);
			break;
		case "4":
			success = dao.boardListBlackDivision4(boardNum);
			break;
			
		}
		if(success!=0) {
		logger.info("추가성공");
		}
		
	}

	public void boardListUnBlack(String boardNum, String division) {
		logger.info("게시글 블랙리스트 해제 서비스");
		int success=0;
		switch(division) {
		case "1":
			success = dao.boardListUnBlackDivision1(boardNum);
			break;
		case "2":
			success = dao.boardListUnBlackDivision2(boardNum);
			break;
		case "3":
			success = dao.boardListUnBlackDivision3(boardNum);
			break;
		case "4":
			success = dao.boardListUnBlackDivision4(boardNum);
			break;
			
		}
		if(success!=0) {
			logger.info("해제 성공");
			}
		
	}

	public CommentDTO cmDetail(String cmNum) {
		logger.info("댓글 상세보기 서비스");
		CommentDTO detail = new CommentDTO();
		detail = dao.cmDetail(cmNum);
		return detail;
	}

	
	
	
}
