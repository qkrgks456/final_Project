package com.gudi.main.campingInfo.campingTip.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gudi.main.campingInfo.campingTip.dao.TipMapper;

@Service
public class TipService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired TipMapper mapper;
	
	public HashMap<String, Object> tipApi(int page, String search)  {
        String clientId = "t_xaPvX2tbyw7jAnrUXq"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "HAa1m6DIeN"; //애플리케이션 클라이언트 시크릿값"

        String text = null;
        try {
            text = URLEncoder.encode(search, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
        
        int display=10;
        //start 검색 시작 수
        //display 스타트부터 검색수
        if (page != 1) {
            page = (page - 1) * display;
        }
        
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // json 결과
        // String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);

        System.out.println(responseBody);
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        if(!responseBody.contains("Fail")) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				 map = mapper.readValue(responseBody, new TypeReference<HashMap<String, Object>>(){});
			} catch (Exception e) {
				e.printStackTrace();
			} 			
		}		
		map.put("blogApi", responseBody);
		
		ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) map.get("data");
		
		return map;
    }

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

	
}
