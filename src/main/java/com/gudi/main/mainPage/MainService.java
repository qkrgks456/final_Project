package com.gudi.main.mainPage;

import com.gudi.main.util.ApiUtil;
import com.gudi.main.util.UploadUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MainService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public HashMap<String, Object> apiCall() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        
        
        // url 선언
        String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchStay";
        // params 선언
        String params = "ServiceKey=YRc1yhIuj%2BSEq19P4LqBXRmFAtACpby0jiZKx%2BpSOyMnQ%2B5EX18dxJ%2BheYZ%2B4Ls%2FhYTVS6%2BFqoIZDjj2XmsmRg%3D%3D" +
                "&MobileOS=ETC&MobileApp=final_project&areaCode=1";
        
        // urls 어레이리스트에 담기
        ArrayList<String> urls = new ArrayList<String>();
        urls.add(url);
        
        // 헤더값 담기
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json");
        
        // 데이터 다 메서드에 넣기
        String result = ApiUtil.sendSeverMsg(urls, headers, params, "get");
        logger.info(result);
        
        JSONObject jsonobj = ApiUtil.XMLStringToJson(result);
        logger.info("바뀐형태"+jsonobj.get("response"));
     
        return map;
    }
}
