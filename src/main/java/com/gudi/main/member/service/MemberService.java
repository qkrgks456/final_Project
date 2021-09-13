package com.gudi.main.member.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gudi.main.member.dao.MemberMapper;
import com.gudi.main.dtoAll.MemberDTO;

@Service
public class MemberService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    

	@Autowired MemberMapper dao;
	

	public void join(MemberDTO dto) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String enc_pass = encoder.encode(dto.getPw());
		dto.setPw(enc_pass);		
	}



}
