package com.gudi.main.campingSearch.tagSearch.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.CampingDTO;

@Mapper
public interface TagSearchMapper {
	

	@Select("SELECT * FROM campingApi ORDER BY contentId DESC OFFSET #{param1} ROWS FETCH FIRST 10 ROWS ONLY")
	ArrayList<CampingDTO> lists(int page);
	
	@Select("SELECT COUNT(contentId) FROM campingApi")
	int total();
	
}
