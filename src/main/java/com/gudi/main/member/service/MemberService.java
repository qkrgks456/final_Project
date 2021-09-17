package com.gudi.main.member.service;

import java.util.ArrayList;
import java.util.HashMap;

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
    

	@Autowired MemberMapper mapper;
	

	public int join(HashMap<String,String> map ) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String enc_pass = encoder.encode(map.get("pw"));
		map.put("pw",enc_pass);
		return mapper.join(map);
	}


    public String idCheck(String id) {
		return mapper.idCheck(id);
    }

	public String login(String inputId) {
		return mapper.login(inputId);
	}


	public String idfind(HashMap<String, String> params) {
		String id = mapper.idfind(params);
		return id;
	}


	public void passfind(HashMap<String, String> params) {
		mapper.passfind(params);
		
	}
}
