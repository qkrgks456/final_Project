package com.gudi.main.admin.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gudi.main.dtoAll.MemberDTO;

@Mapper
public interface AdminMapper {
	
	@Select("Select * from member where admin != '0'")
	ArrayList<MemberDTO> adminList();
	
	@Select("Select * from member where admin='0'")
	ArrayList<MemberDTO> adminInsertList();
	
	@Select("Select m.id, r.reserveName, m.email, r.manCount, r.contentId, r.reserveDate from reserve r left outer join member m ON r.id = m.id")
	ArrayList<MemberDTO> memberReserve();

	@Select("Select * from member")
	ArrayList<MemberDTO> memberInfo();
	
	@Select("Select *from member where nickName LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> memberInfoSearchByNickName(String memberInfoSearch);
	
	@Select("Select *from member where email LIKE '%'||#{insertSearch}||'%' ")
	ArrayList<MemberDTO> memberInfoSearchByEmail(String memberInfoSearch);

	@Select("Select *from member where id LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> memberInfoSearchById(String memberInfoSearch);

	@Update("update member SET admin='관리자' where id =#{id} ")
	void adminInsert(String id);
	
	@Select("Select *from member where nickName LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByNicknameWithAdmin(String insertSearch);
	
	@Select("Select *from member where email LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByEmailWithAdmin(String insertSearch);

	@Select("Select *from member where id LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByIdWithAdmin(String insertSearch);
	
	@Update("update member SET admin='0' where id =#{id} ")
	int adminDelete(String id);
	
	@Select("Select * from member")
	ArrayList<MemberDTO> boardList();

	@Select("Select * from member")
	ArrayList<MemberDTO> commentList();
	
	@Select("Select * from member")
	ArrayList<MemberDTO> reportCommentList();

	//게시글 조회 검색
	//게시글 조인
	@Select("Select *from questionBoard where title LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> boardListSearchBytitle(String boardListSearch);

	@Select("Select *from member where email LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> boardListSearchByEmail(String boardListSearch);

	@Select("Select *from member where id LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> boardListSearchById(String boardListSearch);
	
	//일반 댓글조회 검색
	//댓글, 멤버 조인
	@Select("Select *from cm where content LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> commentListSearchByContent(String commentListSearch);
	
	@Select("Select *from member where email LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> commentListSearchByEmail(String commentListSearch);
	
	@Select("Select *from member where id LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> commentListSearchById(String commentListSearch);
	
}
