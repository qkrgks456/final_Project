package com.gudi.main.myInfo.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.MemberDTO;

@Mapper
public interface MyInfoMapper {

	/*
	@Select("SELECT ID,PW,EMAIL FROM member WHERE ID=?")
	ArrayList<MemberDTO> memberupdate();
	*/
	
	@Select("SELECT ID,PW,EMAIL FROM member WHERE ID=?")
	ArrayList<MemberDTO> myInfo();
}
