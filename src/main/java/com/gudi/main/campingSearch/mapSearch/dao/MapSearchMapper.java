package com.gudi.main.campingSearch.mapSearch.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.CampingDTO;


@Mapper
public interface MapSearchMapper {
    
	@Select("SELECT * FROM (SELECT  ROW_NUMBER() OVER ( ORDER BY contentid desc) rnum, contentId,facltNm,addr1,mapX,mapY,tel,firstImageUrl FROM campingapi where tel IS NOT NULL) WHERE rnum BETWEEN #{param1} AND #{param2}" )
	ArrayList<CampingDTO> list(int start, int end);

	@Select("SELECT count(rnum) FROM (SELECT  ROW_NUMBER() OVER ( ORDER BY contentid desc) rnum FROM campingapi where tel IS NOT NULL)")
	int allCount();
}
