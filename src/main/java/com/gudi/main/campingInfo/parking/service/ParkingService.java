package com.gudi.main.campingInfo.parking.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gudi.main.campingInfo.parking.dao.ParkingMapper;
import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.dtoAll.ParkingDTO;
import com.gudi.main.util.HansolUtil;

@Service
public class ParkingService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ParkingMapper dao;
	

	public ArrayList<ParkingDTO> getZapyo(HashMap<String, Object> map) {
		
		String wido = (String) map.get("wido");
		String kyongdo = (String) map.get("kyongdo");
		
		System.out.println(wido + " / " + kyongdo);
		
		return dao.getZapyo(wido,kyongdo);
	}


	public ParkingDTO freeParkDetail(String prkplcenm) {
		return dao.freeParkDetail(prkplcenm);
	}


	public ArrayList<CampingDTO> payZapyo(HashMap<String, Object> map) {

		String wido = (String) map.get("wido");
		String kyongdo = (String) map.get("kyongdo");
		
		System.out.println(wido + " / " + kyongdo);
		
		return dao.payZapyo(wido,kyongdo);
		
	}

	
	/*
	public void apiCall(HashMap<String, String> params) {
		
		System.out.println("일하라고오오오오ㅗㅗ");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		String dataReq = "http://api.data.go.kr/openapi/tn_pubr_prkplce_info_api?serviceKey=vEhq3s5%2BNYg8x9IUIlZEUQBxNj%2Bm2tHa5AhL5FlmJTY%2B7LNpXIUsvzXV2NUvV7SoHcNTlR%2FZKMM99hOYgBVygA%3D%3D&pageNo=1&numOfRows=3000&type=json&prkplceSe=공영&parkingchrgeInfo=무료&prkplceType=노외";
		HttpURLConnection con = null;
		BufferedReader reader = null;
		String result = "";
		try {
			URL url = new URL(dataReq);
			con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST"); //POST OR GET
			con.setDoOutput(true);
			
			reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			
			result = reader.readLine();
				
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.disconnect();
				}
				if (reader != null) {
					reader.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		logger.info(result); //json 문자열
		
		JSONObject jsonObject1 = ApiUtil.jsonStringToJson(result);
        JSONObject jsonObject2 = ApiUtil.jsonStringToJson(jsonObject1.get("response"));
        JSONObject jsonObject3 = ApiUtil.jsonStringToJson(jsonObject2.get("body"));
        
        //배열화
        ArrayList<HashMap<String, Object>> mapp = ApiUtil.jsonArray(jsonObject3.get("items"));    
        logger.info((String) mapp.get(0).get("prkplceSe"));
        System.out.println(mapp.size());
        
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO parkingapi(PRKPLCESE,lnmadr,PRKCMPRT,PARKINGCHRGEINFO,OPERDAY,INSTITUTIONNM,PHONENUMBER,LATITUDE,LONGITUDE,prkplceNm,rdnmadr) "+
        				"VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    
        try {
            Class.forName("net.sf.log4jdbc.DriverSpy");
            conn = DriverManager.getConnection("jdbc:log4jdbc:oracle:thin:@61.78.121.242:1521:xe", "C##Modakbul_2", "pass");

            pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < mapp.size(); i++) {
            	
            	System.out.println("몇번째???:: "+i);

                pstmt.setString(1, mapp.get(i).get("prkplceSe").toString());
                pstmt.setString(2, mapp.get(i).get("lnmadr").toString());
                pstmt.setString(3, mapp.get(i).get("prkcmprt").toString());
                pstmt.setString(4, mapp.get(i).get("parkingchrgeInfo").toString());
                pstmt.setString(5, mapp.get(i).get("operDay").toString());
                pstmt.setString(6, mapp.get(i).get("institutionNm").toString());
                pstmt.setString(7, mapp.get(i).get("phoneNumber").toString());
                pstmt.setString(8, mapp.get(i).get("latitude").toString());
                pstmt.setString(9, mapp.get(i).get("longitude").toString());
                pstmt.setString(10, mapp.get(i).get("prkplceNm").toString());
                pstmt.setString(11, mapp.get(i).get("rdnmadr").toString());
                
                // Batch 실행
                pstmt.executeUpdate();
            }
            // 커밋
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) try {
                pstmt.close();
                pstmt = null;
            } catch (SQLException ex) {
            }
            if (conn != null) try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
            }
        }
	}
	*/
	
	
}
