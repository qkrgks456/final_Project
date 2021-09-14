package com.gudi.main.campingInfo.parking.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.ParkingDTO;

@Mapper
public interface ParkingMapper {
	
	@Select("SELECT count(contentid) FROM campingapi")
	int test();
	
	@Select("SELECT * FROM ( " +
			"SELECT ( 6371 * acos( cos( radians( #{param1} ) ) * cos( radians( latitude) ) * cos( radians( longitude ) - radians(#{param2}) ) + sin( radians(#{param1}) ) * sin( radians(latitude) ) ) ) AS distance, LATITUDE, LONGITUDE " +
			"FROM parkingapi " +
			") DATA " +
			"WHERE DATA.distance < 15")
	ArrayList<ParkingDTO> getZapyo(String wido, String kyongdo);




	
	
	
	
}
