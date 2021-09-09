package com.gudi.main.campingInfo.parking.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ParkingMapper {
	
	@Select("SELECT count(contentid) FROM campingapi")
	int test();
}
