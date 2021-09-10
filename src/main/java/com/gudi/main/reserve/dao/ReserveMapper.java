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

}
