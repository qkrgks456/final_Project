package com.gudi.main.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gudi.main.admin.service.AdminService;
import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.CommentDTO;
import com.gudi.main.dtoAll.MemberDTO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired AdminService adminService;
    
    
    @RequestMapping(value = "/authority")
    public String admin(Model model) {
        logger.info("관리자 메뉴");
        return "admin/authority/adminSearch";
    }
    
    @ResponseBody
    @RequestMapping(value = "/adminSearch", method = RequestMethod.GET)
    public HashMap<String, Object> adminSearch() {
    	logger.info("관리자 조회");
        return adminService.adminSearch();
    }
    
    @RequestMapping(value = "/adminInsert")
    public String adminInsert(){
    	logger.info("관리자 임명 jsp로");
        return "admin/authority/adminInsert";
    }
    
    @ResponseBody
    @RequestMapping(value = "/adminInsertAjax",method = RequestMethod.GET)
    public HashMap<String, Object> adminInsertAjax(){
    	logger.info("관리자 임명");
        return adminService.adminInsertList();
    }
    
    @RequestMapping(value = "/adminInsertAuthority",method = RequestMethod.GET)
    public String adminInsertAuthority(@RequestParam("id") String id){
    	logger.info("관리자 임명 버튼 클릭");
    	logger.info("임명할 id: " +id);
    	adminService.adminInsert(id);
        return "admin/authority/adminInsert";
    }
    
    @ResponseBody
    @RequestMapping(value = "/insertSearch",method = RequestMethod.GET)
    public HashMap<String, Object> insertSearch(@RequestParam("insertSearch") String insertSearch, @RequestParam("selectType") String selectType){
    	logger.info("관리자 임명 검색");
    	logger.info("셀렉터: "+selectType+", 검색내용: "+insertSearch);
        return adminService.insertSearch(selectType,insertSearch);
    }
    
    @RequestMapping(value = "/adminDeleteAuthority",method = RequestMethod.GET)
    public String adminDeleteAuthority(@RequestParam("id") String id){
    	logger.info("관리자 임명 버튼 클릭");
    	logger.info("임명할 id: " +id);
    	int success = adminService.adminDelete(id);
    	logger.info("성공여부: "+success);
        return "admin/authority/adminSearch";
    }
    //adminDeleteAuthority 권한해제
    
    @RequestMapping(value = "/memberInfo")
    public String memberInfo() {
    	logger.info("회원정보 조회");
        return "admin/list/memberInfo";
    }
    
    @ResponseBody
    @RequestMapping(value = "/memberInfoSearch",method = RequestMethod.GET)
    public HashMap<String, Object> memberInfoSearch(@RequestParam("memberInfoSearch") String memberInfoSearch, @RequestParam("selectType") String selectType){
    	logger.info("회원정보 검색");
    	logger.info("셀렉터: "+selectType+", 검색내용: "+memberInfoSearch);
        return adminService.memberInfoSearch(selectType,memberInfoSearch);
    }
    
    @ResponseBody
    @RequestMapping(value = "/memberInfoAjax",method = RequestMethod.GET)
    public HashMap<String, Object> memberInfoAjax() {
    	logger.info("회원정보 조회Ajax");
        return adminService.memberInfo();
    }
    @RequestMapping(value = "/memberInfoBlackDel")
    public String memberInfoBlackDel(@RequestParam("id") String id) {
    	logger.info("회원 블랙리스트 제거 조회");
    	logger.info("id: "+id+" 회원 블랙리스트 제거");
    	adminService.memberInfoBlackDel(id);
        return "admin/list/memberInfo";
    }
    
    @RequestMapping(value = "/memberInfoBlackList")
    public String memberInfoBlackList(@RequestParam("id") String id,@RequestParam("nickName") String nickName, Model model) {
    	logger.info("id: "+id+" 회원 블랙리스트 추가 페이지");
    	model.addAttribute("id",id);
    	model.addAttribute("nickName",nickName);
        return "admin/list/memberInfoBlackList";
    }
    
    @RequestMapping(value = "/memberInfoBlackInsert")
    public String memberInfoBlackInsert(@RequestParam("id") String id,@RequestParam("reason") String reason) {
    	logger.info("id: "+id+" 회원 블랙리스트 추가");
    	logger.info("사유: " +reason);
    	adminService.memberInfoBlackInsert(id, reason);
        return "admin/list/memberInfo";
    }
    
    
    @RequestMapping(value = "/memberReserve")
    public String memberReserve() {
    	logger.info("예약자 조회 jsp로");
        return "admin/list/memberReserve";
    }
    @ResponseBody
    @RequestMapping(value = "/memberReserveAjax",method = RequestMethod.GET)
    public HashMap<String, Object> memberReserveAjax() {
    	logger.info("예약자 조회");
        return adminService.memberReserve();
    }
    @RequestMapping(value = "/boardList")
    public String boardList(Model model) {
        return "admin/list/boardList";
    }
    @ResponseBody
    @RequestMapping(value = "/boardListAjax",method = RequestMethod.GET)
    public HashMap<String, Object> boardList() {
    	logger.info("게시글 조회 Ajax");
        return adminService.boardList();
    }
    
    @ResponseBody
    @RequestMapping(value = "/boardListSearch",method = RequestMethod.GET)
    public HashMap<String, Object> boardListSearch(@RequestParam("boardListSearch") String boardListSearch, @RequestParam("selectType") String selectType){
    	logger.info("게시글 검색");
    	logger.info("셀렉터: "+selectType+", 검색내용: "+boardListSearch);
        return adminService.boardListSearch(selectType,boardListSearch);
    }
    @RequestMapping(value = "/boardListDetailInfo",method = RequestMethod.GET)
    public String boardListDetailInfo(@RequestParam("boardNum") String boardNum,@RequestParam("division") String division,Model model){
    	logger.info("게시글 상세");
    	logger.info("게시글 번호: "+boardNum+"게시판 구분: "+division);
    	BoardDTO detail =adminService.boardListDetailInfo(boardNum,division);
    	model.addAttribute("detail", detail);
    	logger.info(detail.getId());
        return "admin/list/boardListDetail";
    }
    
    @RequestMapping(value = "/boardListBlack",method = RequestMethod.GET)
    public String boardListBlack(@RequestParam("boardNum") String boardNum,@RequestParam("division") String division){
    	logger.info("게시글 블랙리스트 추가");;
    	logger.info("게시글 번호: "+boardNum+"게시판 구분: "+division);
    	adminService.boardListBlack(boardNum,division);
        return "admin/list/boardList";
    }
    
    @RequestMapping(value = "/boardListUnBlack",method = RequestMethod.GET)
    public String boardListUnBlack(@RequestParam("boardNum") String boardNum,@RequestParam("division") String division){
    	logger.info("게시글 블랙리스트 해제");
    	logger.info("게시글 번호: "+boardNum+"게시판 구분: "+division);
    	adminService.boardListUnBlack(boardNum,division);
        return "admin/list/boardList";
    }
    
    @RequestMapping(value = "/comment")
    public String comment(Model model) {
        return "admin/comment/comment";
    }
    @RequestMapping(value = "/cmDetail")
    public String cmDetail(@RequestParam("cmNum") String cmNum,Model model) {
    	logger.info("댓글 상세보기");
    	logger.info(cmNum+"번 상세보기");
    	CommentDTO detail = adminService.cmDetail(cmNum);
    	model.addAttribute("detail", detail);
        return "admin/comment/cmDetail";
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/commentListAjax")
    public HashMap<String, Object> commentList() {
    	logger.info("댓글 조회 Ajax");
        return adminService.commentList();
    }
    
    @ResponseBody
    @RequestMapping(value = "/commentListSearch",method = RequestMethod.GET)
    public HashMap<String, Object> commentListSearch(@RequestParam("commentListSearch") String commentListSearch, @RequestParam("selectType") String selectType){
    	logger.info("일반댓글 검색");
    	logger.info("셀렉터: "+selectType+", 검색내용: "+commentListSearch);
        return adminService.commentListSearch(selectType,commentListSearch);
    }
    
    @RequestMapping(value = "/reportComment")
    public String reportComment(Model model) {
        return "admin/comment/reportComment";
    }
    
    @ResponseBody
    @RequestMapping(value = "/reportCommentAjax",method = RequestMethod.GET)
    public HashMap<String, Object> reportCommentList() {
        return adminService.reportCommentList();
    }
    
    


}
