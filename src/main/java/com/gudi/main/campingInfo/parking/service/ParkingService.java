package com.gudi.main.campingInfo.parking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudi.main.campingInfo.parking.dao.ParkingMapper;

@Service
public class ParkingService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ParkingMapper dao;
	
	public void test() {
		
		int test = dao.test();
		logger.info("dao연결 테스트입니다:: "+test);
	}
}
