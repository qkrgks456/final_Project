package com.gudi.main.campingServiceCenter.noticeBoard.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.BoardDTO;

@Mapper
public interface NoticeMapper {
	@Select("SELECT * FROM noticeboard ORDER BY boardnum DESC")
	ArrayList<BoardDTO> list();

}
