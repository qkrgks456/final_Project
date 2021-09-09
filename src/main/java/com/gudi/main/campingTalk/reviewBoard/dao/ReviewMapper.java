package com.gudi.main.campingTalk.reviewBoard.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.BoardDTO;

@Mapper
public interface ReviewMapper {

	@Insert("INSERT INTO")
	int write();

	@Select("SELECT * FROM noticeBoard WHERE BoardNum = 1")
	BoardDTO test();
}
