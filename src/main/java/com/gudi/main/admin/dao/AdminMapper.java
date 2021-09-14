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

	@Update("update member SET admin='관리자' where id =#{id} ")
	void adminInsert(String id);
	
	@Select("Select *from member where nickName LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByNickname(String insertSearch);
	
	@Select("Select *from member where email LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByEmail(String insertSearch);

	@Select("Select *from member where id LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchById(String insertSearch);
	
	@Update("update member SET admin='0' where id =#{id} ")
	int adminDelete(String id);
}
