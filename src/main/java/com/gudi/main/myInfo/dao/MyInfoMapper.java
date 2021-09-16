package com.gudi.main.myInfo.dao;

import java.util.ArrayList;

import com.gudi.main.dtoAll.ReserveDTO;
import com.gudi.main.myInfo.dto.MyInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.MemberDTO;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MyInfoMapper {

    @Select("SELECT * FROM member WHERE id=#{param1}")
    MemberDTO myInfoData(String loginId);

    @Update("UPDATE member SET nickName=#{param2} WHERE id=#{param1}")
    void infoUpdate(String loginId, String nickName);

    @Select("SELECT pw FROM member WHERE id=#{param1}")
    String pwCheck(String loginId);

    @Update("UPDATE member SET pw = #{param1} WHERE id =#{param2}")
    void pwUpdate(String enc_pass, String loginId);

    @Update("UPDATE member SET delCheck = 'Y' WHERE id = #{param1}")
    void memberDropReal(String loginId);

    @Select("SELECT r.reserveNum,c.facltNm,r.manCount,r.carNum,r.reserveDate FROM " +
            "campingApi c RIGHT OUTER JOIN reserve r ON c.contentId = r.contentId " +
            "WHERE r.id = #{param1} ORDER BY r.reserveNum DESC OFFSET #{param2} ROWS FETCH FIRST 15 ROWS ONLY")
    ArrayList<MyInfoDTO> reserveList(String loginId, int start);

    @Select("SELECT COUNT(reserveNum) FROM reserve WHERE id=#{param1}")
    int reserveTotal(String loginId);
}
