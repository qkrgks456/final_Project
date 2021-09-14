package com.gudi.main.campingInfo.parking.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.dtoAll.ParkingDTO;

@Mapper
public interface ParkingMapper {
	
	@Select("SELECT count(contentid) FROM campingapi")
	int test();
	
	@Select("SELECT * FROM ( " +
			"SELECT ( 6371 * acos( cos( radians( #{param1} ) ) * cos( radians( latitude) ) * cos( radians( longitude ) - radians(#{param2}) ) + sin( radians(#{param1}) ) * sin( radians(latitude) ) ) ) AS distance, PRKPLCESE, LNMADR, PRKCMPRT, PARKINGCHRGEINFO, OPERDAY, INSTITUTIONNM, PHONENUMBER, PRKPLCENM, RDNMADR, LATITUDE, LONGITUDE " +
			"FROM parkingapi " +
			") DATA " +
			"WHERE DATA.distance < 8")
	ArrayList<ParkingDTO> getZapyo(String wido, String kyongdo);

	@Select("SELECT * FROM parkingapi WHERE prkplcenm = #{param1}")
	ParkingDTO freeParkDetail(String prkplcenm);

	@Select("SELECT * FROM ( " +
			"SELECT ( 6371 * acos( cos( radians( #{param1} ) ) * cos( radians( latitude) ) * cos( radians( longitude ) - radians(#{param2}) ) + sin( radians(#{param1}) ) * sin( radians(latitude) ) ) ) AS distance, contentid, facltNm, addr1, mapX, mapY, tel, lctcl, hompage " +
			"FROM campingapi " +
			") DATA " +
			"WHERE DATA.distance < 8")
	ArrayList<CampingDTO> payZapyo(String wido, String kyongdo);




	
	
	
	
}
