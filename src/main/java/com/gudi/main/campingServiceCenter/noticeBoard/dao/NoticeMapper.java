package com.gudi.main.campingServiceCenter.noticeBoard.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.BoardDTO;

@Mapper
public interface NoticeMapper {
	
	@Select("SELECT boardnum,id, title, content,  boardhit, dates FROM (SELECT  ROW_NUMBER() OVER ( ORDER BY boardnum desc) rnum, boardnum,id, title, content,  boardhit, dates,  delcheck  FROM  noticeboard where delcheck = 'N') WHERE rnum BETWEEN #{param1} AND #{param2}")
	ArrayList<BoardDTO> list(int start, int end);

	@Select("select count(boardnum) from (SELECT  ROW_NUMBER() OVER ( ORDER BY boardnum desc)  rnum, boardnum, id, title, content,  boardhit, dates, delcheck  FROM  noticeboard where delcheck = 'N')")
	int allCount();

}
