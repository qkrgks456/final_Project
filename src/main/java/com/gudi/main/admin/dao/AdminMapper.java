package com.gudi.main.admin.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.CommentDTO;
import com.gudi.main.dtoAll.CommentReportDTO;
import com.gudi.main.dtoAll.MemberDTO;
import com.gudi.main.dtoAll.ReserveDTO;

@Mapper
public interface AdminMapper {
	
	@Select("Select * from member where admin != '0'")
	ArrayList<MemberDTO> adminList();
	
	@Select("Select * from member where admin='0'")
	ArrayList<MemberDTO> adminInsertList();
	
	@Select("Select r.id, r.reserveName,r.manCount, r.contentId, r.reserveDate from reserve r")
	ArrayList<ReserveDTO> memberReserve();

	@Select("Select * from member where admin='N'")
	ArrayList<MemberDTO> memberInfo();
	
	@Select("Select *from member where nickName LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> memberInfoSearchByNickName(String memberInfoSearch);
	
	@Select("Select *from member where email LIKE '%'||#{insertSearch}||'%' ")
	ArrayList<MemberDTO> memberInfoSearchByEmail(String memberInfoSearch);

	@Select("Select *from member where id LIKE '%'||#{insertSearch}||'%'")
	ArrayList<MemberDTO> memberInfoSearchById(String memberInfoSearch);

	@Update("update member SET admin='Y' where id =#{id} ")
	void adminInsert(String id);
	
	@Select("Select *from member where nickName LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByNicknameWithAdmin(String insertSearch);
	
	@Select("Select *from member where email LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByEmailWithAdmin(String insertSearch);

	@Select("Select *from member where id LIKE '%'||#{insertSearch}||'%' AND admin = '0'")
	ArrayList<MemberDTO> insertSearchByIdWithAdmin(String insertSearch);
	
	@Update("update member SET admin='0' where id =#{id} ")
	int adminDelete(String id);
	
	@Select("select division,boardNum,id,title, delcheck from noticeBoard UNION all"+
			" select division,boardNum,id, title, cast('delcheck' as nvarchar2(100)) from questionBoard UNION all" + 
			" select division,boardNum,id,title, delcheck from freeBoard UNION all" + 
			" select division,boardNum,id,title, cast('delcheck' as nvarchar2(100)) from reviewBoard")
	ArrayList<BoardDTO> boardList();

	@Select("Select * from cm")
	ArrayList<CommentDTO> commentList();
	
	@Select("Select * from cmReport")
	ArrayList<CommentReportDTO> reportCommentList();

	//게시글 조회 검색
	//게시글 조인
	@Select("select division,boardNum, id,title, delcheck from noticeBoard where title LIKE '%'||#{insertSearch}||'%'"+ 
			" UNION all"+
			" select division,boardNum,id, title, cast('delcheck' as nvarchar2(100)) from questionBoard where title LIKE '%'||#{insertSearch}||'%'"+ 
			" UNION all" + 
			" select division,boardNum,id,title, delcheck from freeBoard where title LIKE '%'||#{insertSearch}||'%'"+ 
			" UNION all" + 
			" select division,boardNum,id,title, cast('delcheck' as nvarchar2(100)) from reviewBoard where title LIKE '%'||#{insertSearch}||'%'")
	ArrayList<BoardDTO> boardListSearchBytitle(String boardListSearch);

	@Select("select division,boardNum,id,title, delcheck from noticeBoard where id LIKE '%'||#{insertSearch}||'%'"+ 
			" UNION all"+
			" select division,boardNum,id, title, cast('delcheck' as nvarchar2(100)) from questionBoard where id LIKE '%'||#{insertSearch}||'%'"+ 
			" UNION all" + 
			" select division,boardNum,id,title, delcheck from freeBoard where id LIKE '%'||#{insertSearch}||'%'"+ 
			" UNION all" + 
			" select division,boardNum,id,title, cast('delcheck' as nvarchar2(100)) from reviewBoard where id LIKE '%'||#{insertSearch}||'%'")
	ArrayList<BoardDTO> boardListSearchById(String boardListSearch);
	
	//일반 댓글조회 검색
	//댓글, 멤버 조인
	@Select("Select *from cm where content LIKE '%'||#{insertSearch}||'%'")
	ArrayList<CommentDTO> commentListSearchByContent(String commentListSearch);
	
	
	@Select("Select *from cm where id LIKE '%'||#{insertSearch}||'%'")
	ArrayList<CommentDTO> commentListSearchById(String commentListSearch);
	
	@Update("update member SET DELCHECK='N' where id =#{id} ")
	int memberInfoBlackDel(String id);
	
	@Update("update black SET status='N' where id =#{id} ")
	int memberInfoBlackDel2(String id);
	/*
	 * //@Update("update member SET DELCHECK='Y' where id =#{param1} ")
	 * 
	 * @Update("insert into black values(BLACK_SEQ.nextval,#{param1},#{param2},sysdate,'Y')"
	 * ) int memberInfoBlackInsert(String id, String reason);
	 */
	
	@Update("update member SET DELCHECK='Y' where id =#{id}")
	int memberInfoBlackInsert(String id);

	@Update("insert into black values(BLACK_SEQ.nextval,#{param1},#{param2},sysdate,'Y')")
	int memberInfoBlackInsert2(String id, String reason);

	@Select("select division,boardNum,id,title,content, delcheck from noticeBoard where boardNum = #{param1} and division=#{param2}"+ 
			" UNION all"+
			" select division,boardNum,id, title,content, cast('delcheck' as nvarchar2(100)) from questionBoard where boardNum = #{param1} and division=#{param2}"+ 
			" UNION all" + 
			" select division,boardNum,id,title,content, delcheck from freeBoard where boardNum = #{param1} and division=#{param2}"+ 
			" UNION all" + 
			" select division,boardNum,id,title,content, cast('delcheck' as nvarchar2(100)) from reviewBoard where boardNum = #{param1} and division=#{param2}")
	BoardDTO boardListDetailInfo(String boardNum, String division);

	
	@Update("update noticeBoard SET DELCHECK='Y' where boardNum =#{boardNum}")
	int boardListBlackDivision1(String boardNum);

	@Update("update questionBoard SET DELCHECK='Y' where boardNum =#{boardNum}")
	int boardListBlackDivision2(String boardNum);

	@Update("update freeBoard SET DELCHECK='Y' where boardNum =#{boardNum}")
	int boardListBlackDivision3(String boardNum);

	@Update("update reviewBoard SET DELCHECK='Y' where boardNum =#{boardNum}")
	int boardListBlackDivision4(String boardNum);
	
	//해제
	@Update("update noticeBoard SET DELCHECK='N' where boardNum =#{boardNum}")
	int boardListUnBlackDivision1(String boardNum);

	@Update("update questionBoard SET DELCHECK='N' where boardNum =#{boardNum}")
	int boardListUnBlackDivision2(String boardNum);

	@Update("update freeBoard SET DELCHECK='N' where boardNum =#{boardNum}")
	int boardListUnBlackDivision3(String boardNum);

	@Update("update reviewBoard SET DELCHECK='N' where boardNum =#{boardNum}")
	int boardListUnBlackDivision4(String boardNum);

	@Select("select * from cm where cmNum=#{cmNum}")
	CommentDTO cmDetail(String cmNum);

	
	
}
