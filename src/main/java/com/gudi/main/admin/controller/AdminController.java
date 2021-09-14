package com.gudi.main.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;

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
    
    @RequestMapping(value = "/memberInfoAjax",method = RequestMethod.GET)
    public HashMap<String, Object> memberInfoAjax() {
    	logger.info("회원정보 조회Ajax");
        return adminService.memberInfo();
    }
    
    @RequestMapping(value = "/memberInfoBlackList")
    public String memberInfoBlackList() {
    	logger.info("회원 블랙리스트 추가/제거 조회");
        return "admin/list/memberInfoBlackList";
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
    @RequestMapping(value = "/comment")
    public String comment(Model model) {
        return "admin/comment/comment";
    }
    @RequestMapping(value = "/reportComment")
    public String reportComment(Model model) {
        return "admin/comment/reportComment";
    }


}
