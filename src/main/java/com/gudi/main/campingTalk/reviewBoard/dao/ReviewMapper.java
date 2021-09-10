package com.gudi.main.campingTalk.reviewBoard.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.PhotoDTO;

@Mapper
public interface ReviewMapper {
	
	@Insert("INSERT INTO photo(photonum, id, division, newfilename, orifilename, divisionnum) VALUES (photo_seq.NEXTVAL, 'test', 'review', #{param1}, #{param2}, 'review_'||#{param3})")
	void reviewPhoto(String neww, String ori, String boardNum);
	
	//나중에 세션에서 아이디 받아와서 넣어야함
	@Insert("INSERT INTO reviewboard(boardnum, id, title, content) VALUES (reviewboard_seq.NEXTVAL, 'test', #{title}, #{content})")
	@SelectKey(statement = {"SELECT reviewboard_seq.CURRVAL FROM DUAL"}, keyProperty = "boardnum",resultType = int.class, before = false)
	int reviewWrite(HashMap<String, String> params);
	
	@Select("SELECT * FROM reviewboard WHERE boardNum = #{param1}")
	BoardDTO reviewDetail(int boardNum);

	@Select("SELECT * FROM photo WHERE divisionnum = #{divi}")
	PhotoDTO callPhoto(String divi);

	@Update("UPDATE reviewboard SET delcheck = 'y' WHERE boardnum = #{boardNum}")
	int reviewDel(int boardNum);

	@Select("SELECT * FROM reviewboard WHERE delcheck = 'n'")
	ArrayList<BoardDTO> reviewList();

	@Update("UPDATE reviewboard SET title = #{param1}, content = #{param2} WHERE boardnum = #{param3}")
	int reviewUpdate(String title, String content, int boardNum);
	
	@Update("UPDATE photo SET newfilename = #{param1}, orifilename = #{param2} WHERE divisionnum = 'review_'||#{param3}")
	void reviewPhotoUpdate(String neww, String ori, int boardNum);


	
	
}
