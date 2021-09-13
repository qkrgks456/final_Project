package com.gudi.main.campingInfo.campingRecipe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudi.main.campingInfo.campingRecipe.dao.RecipeMapper;

@Service
public class RecipeService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired RecipeMapper dao;
	public void test () {		
		int a=dao.test();
		logger.info("f:"+a);
	}
}
