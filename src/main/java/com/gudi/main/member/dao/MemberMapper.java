package com.gudi.main.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

public interface MemberMapper {

    @Select("SELECT id FROM member WHERE id=#{id}")
    String idCheck(String id);

    @Insert("INSERT INTO member (id,pw,nickname,email,admin,delCheck) values (#{id},#{pw},#{nickName},#{email},'N','N')")
    int join(HashMap<String, String> map);

    @Select("SELECT pw FROM member WHERE id=#{id} AND delCheck='N'")
    String login(String inputId);
}
