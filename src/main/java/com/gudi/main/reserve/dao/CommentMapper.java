package com.gudi.main.reserve.dao;

import com.gudi.main.dtoAll.CommentDTO;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM cm WHERE division = 'camping' AND divisionNum = #{param1} ORDER BY cmNum DESC" +
            " OFFSET #{param2} ROWS FETCH FIRST 8 ROWS ONLY")
    ArrayList<CommentDTO> reserveCmList(String contentId, int page);

    @Select("SELECT COUNT(cmNum) FROM cm WHERE division = 'camping' AND divisionNum = #{param1}")
    int reserveTotal(String contentId);

    @Insert(ReserveSQL.CM_INSERT)
    @SelectKey(statement = "SELECT cm_seq.CURRVAL FROM DUAL", keyProperty = "cmNum", before = false, resultType = int.class)
    int reserveCmInsert(CommentDTO dto);
}
