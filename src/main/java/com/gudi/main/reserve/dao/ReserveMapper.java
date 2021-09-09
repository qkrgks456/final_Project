package com.gudi.main.reserve.dao;

import com.gudi.main.dtoAll.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ReserveMapper {
    @Select("SELECT * FROM noticeBoard WHERE BoardNum = 1")
    BoardDTO test();
}
