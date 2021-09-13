package com.gudi.main.admin.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.MemberDTO;

@Mapper
public interface AdminMapper {
	
	@Select("Select * from member where admin != '0'")
	ArrayList<MemberDTO> adminList();
	
	@Select("Select * from member where admin='0'")
	ArrayList<MemberDTO> adminInsert();
	
	@Select("Select r.id, r.reserveName, m.email, r.manCount, r. from reserve r left outer join member m on r.id = m.id")
	ArrayList<MemberDTO> memberReserve();

	@Select("Select * from member")
	ArrayList<MemberDTO> memberInfo();
}
