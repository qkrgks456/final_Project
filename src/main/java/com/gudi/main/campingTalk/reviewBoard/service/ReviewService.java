package com.gudi.main.campingTalk.reviewBoard.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gudi.main.campingTalk.reviewBoard.dao.ReviewMapper;
import com.gudi.main.util.UploadUtil;

@Service
public class ReviewService {
	
	@Autowired ReviewMapper dao;

	public void reviewWrite(HashMap<String, String> prams, MultipartFile file) {
		
		HashMap<String, String> map = UploadUtil.fileUpload(file);
		
		map.get("oriFileName");
		map.get("newFileName");
		
	}
	

}
