package com.gudi.main.reserve.service;

import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.dtoAll.CampingDTO;
import com.gudi.main.reserve.dao.ReserveMapper;
import com.gudi.main.util.ApiUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ReserveService {
    @Autowired
    ReserveMapper mapper;

    public HashMap<String, Object> campingDetail(String contentId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // 디테일 정보 가져오기
        CampingDTO dto = mapper.campingDetail(contentId);

        // 이미지 가져오기(3개만)
        // url 선언
        String url = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/imageList";
        // params 선언
        String params = "ServiceKey=YRc1yhIuj%2BSEq19P4LqBXRmFAtACpby0jiZKx%2BpSOyMnQ%2B5EX18dxJ%2BheYZ%2B4Ls%2FhYTVS6%2BFqoIZDjj2XmsmRg%3D%3D" +
                "&MobileOS=ETC&MobileApp=final_project&_type=json&contentId=" + contentId;

        // urls 어레이리스트에 담기
        ArrayList<String> urls = new ArrayList<String>();
        urls.add(url);

        // 헤더값 담기
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json");
        // 결과 json 반환
        String result = ApiUtil.sendSeverMsg(urls, headers, params, "get");
        // 해체쇼
        JSONObject jsonObject1 = ApiUtil.jsonStringToJson(result);
        JSONObject jsonObject2 = ApiUtil.jsonStringToJson(jsonObject1.get("response"));
        JSONObject jsonObject3 = ApiUtil.jsonStringToJson(jsonObject2.get("body"));
        JSONObject jsonObject4 = ApiUtil.jsonStringToJson(jsonObject3.get("items"));
        // 배열화
        ArrayList<HashMap<String, Object>> hashMapArrayList = ApiUtil.jsonArray(jsonObject4.get("item"));
        ArrayList<String> imgArr = new ArrayList<String>();
        System.out.println(hashMapArrayList.size());
        if (hashMapArrayList.size() >= 3) {
            for (int i = 0; i < 3; i++) {
               imgArr.add((String)hashMapArrayList.get(i).get("imageUrl"));
            }
        }
        map.put("imgArr",imgArr);
        map.put("dto", dto);
        return map;
    }
}
