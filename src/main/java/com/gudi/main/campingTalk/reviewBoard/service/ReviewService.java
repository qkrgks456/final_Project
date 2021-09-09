package com.gudi.main.campingTalk.reviewBoard.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudi.main.campingTalk.reviewBoard.dao.ReviewMapper;
import com.gudi.main.dtoAll.BoardDTO;

@Service
public class ReviewService {
	
	@Autowired ReviewMapper dao;
	

}
