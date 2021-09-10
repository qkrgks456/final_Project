package com.gudi.main.reserve.dao;

import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.dtoAll.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ReserveMapper {
    @Select("SELECT * FROM campingApi WHERE contentId = #{param1}")
    CampingDTO campingDetail(String contentId);

    @Select("SELECT * FROM cm WHERE division = 'camping' AND divisionNum = #{param1} ORDER BY cmNum DESC" +
            " OFFSET #{param2} ROWS FETCH FIRST 8 ROWS ONLY")
    ArrayList<CommentDTO> reserveCommentList(String contentId, int page);

    @Select("SELECT COUNT(cmNum) FROM cm WHERE division = 'camping' AND divisionNum = #{param1}")
    int reserveTotal(String contentId);
}
