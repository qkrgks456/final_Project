package com.gudi.main.mainPage;

import com.gudi.main.util.ApiUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MainApiData {
    @Autowired
    MainMapper mapper;

    // 매달 1일 오전3시 api 최신화된 데이터 인서트 시켜준다 빈약한 데이터 필터까지
    @Scheduled(cron = "0 0 3 1 * ?")
    public void apiInsert() {
        // url 선언
        String url = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList";
        // params 선언
        String params = "ServiceKey=YRc1yhIuj%2BSEq19P4LqBXRmFAtACpby0jiZKx%2BpSOyMnQ%2B5EX18dxJ%2BheYZ%2B4Ls%2FhYTVS6%2BFqoIZDjj2XmsmRg%3D%3D" +
                "&MobileOS=ETC&MobileApp=final_project&_type=json&pageNo=1&numOfRows=1";

        // urls 어레이리스트에 담기
        ArrayList<String> urls = new ArrayList<String>();
        urls.add(url);

        // 헤더값 담기
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json");

        String result = ApiUtil.sendSeverMsg(urls, headers, params, "get");
        // 해체쇼
        JSONObject jsonObject1 = ApiUtil.jsonStringToJson(result);
        JSONObject jsonObject2 = ApiUtil.jsonStringToJson(jsonObject1.get("response"));
        JSONObject jsonObject3 = ApiUtil.jsonStringToJson(jsonObject2.get("body"));
        int totalCount = (Integer) jsonObject3.get("totalCount");

        // url 선언
        url = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList";
        // params 선언
        params = "ServiceKey=YRc1yhIuj%2BSEq19P4LqBXRmFAtACpby0jiZKx%2BpSOyMnQ%2B5EX18dxJ%2BheYZ%2B4Ls%2FhYTVS6%2BFqoIZDjj2XmsmRg%3D%3D" +
                "&MobileOS=ETC&MobileApp=final_project&_type=json&pageNo=1&numOfRows=" + totalCount;

        // urls 어레이리스트에 담기
        urls = new ArrayList<String>();
        urls.add(url);
        // 헤더값 담기
        headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json");

        result = ApiUtil.sendSeverMsg(urls, headers, params, "get");
        // 해체쇼
        jsonObject1 = ApiUtil.jsonStringToJson(result);
        jsonObject2 = ApiUtil.jsonStringToJson(jsonObject1.get("response"));
        jsonObject3 = ApiUtil.jsonStringToJson(jsonObject2.get("body"));
        JSONObject jsonObject4 = ApiUtil.jsonStringToJson(jsonObject3.get("items"));
        // 배열화
        ArrayList<HashMap<String, Object>> hashMapArrayList = ApiUtil.jsonArray(jsonObject4.get("item"));
        System.out.println(hashMapArrayList.size());
        if (hashMapArrayList.size() == totalCount) {
            mapper.apiDelete();
            Connection con = null;
            PreparedStatement pstmt = null;

            String sql = "Insert Into campingApi(contentId , lineIntro , facltNm, intro, featureNm, induty, " +
                    "lctCl, addr1,mapX,mapY, tel, homepage, resveUrl, gnrlSiteCo, autoSiteCo, glampSiteCo, caravSiteCo, indvdlCaravSiteCo," +
                    "siteBottomCl1, siteBottomCl2, siteBottomCl3, siteBottomCl4, siteBottomCl5," +
                    "animalCmgCl, eqpmnLendCl, themaEnvrnCl, toiletCo, swrmCo," +
                    "brazierCl,glampInnerFclty,caravInnerFclty,firstImageUrl,sbrsCl,sbrsEtc," +
                    "posblFcltyCl,posblFcltyEtc,operPdCl,operDeCl,facltDivNm)" +
                    "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                Class.forName("net.sf.log4jdbc.DriverSpy");
                con = DriverManager.getConnection("jdbc:log4jdbc:oracle:thin:@61.78.121.242:1521:xe", "C##Modakbul_2", "pass");
                con.setAutoCommit(false);
                pstmt = con.prepareStatement(sql);
                for (int i = 0; i < hashMapArrayList.size(); i++) {
                    pstmt.setInt(1, (Integer) hashMapArrayList.get(i).get("contentId"));
                    pstmt.setString(2, (String) hashMapArrayList.get(i).get("lineIntro"));
                    pstmt.setString(3, (String) hashMapArrayList.get(i).get("facltNm"));
                    pstmt.setString(4, (String) hashMapArrayList.get(i).get("intro"));
                    pstmt.setString(5, (String) hashMapArrayList.get(i).get("featureNm"));
                    pstmt.setString(6, (String) hashMapArrayList.get(i).get("induty"));
                    pstmt.setString(7, (String) hashMapArrayList.get(i).get("lctCl"));
                    pstmt.setString(8, (String) hashMapArrayList.get(i).get("addr1"));
                    if (hashMapArrayList.get(i).get("mapX") != null) {
                        pstmt.setString(9, hashMapArrayList.get(i).get("mapX").toString());
                        pstmt.setString(10, hashMapArrayList.get(i).get("mapY").toString());
                    } else {
                        pstmt.setString(9, (String) hashMapArrayList.get(i).get("mapX"));
                        pstmt.setString(10, (String) hashMapArrayList.get(i).get("mapY"));
                    }
                    pstmt.setString(11, (String) hashMapArrayList.get(i).get("tel"));
                    pstmt.setString(12, (String) hashMapArrayList.get(i).get("homepage"));
                    pstmt.setString(13, (String) hashMapArrayList.get(i).get("resveUrl"));
                    pstmt.setString(14, hashMapArrayList.get(i).get("gnrlSiteCo").toString());
                    pstmt.setString(15, hashMapArrayList.get(i).get("autoSiteCo").toString());
                    pstmt.setString(16, hashMapArrayList.get(i).get("glampSiteCo").toString());
                    pstmt.setString(17, hashMapArrayList.get(i).get("caravSiteCo").toString());
                    pstmt.setString(18, hashMapArrayList.get(i).get("indvdlCaravSiteCo").toString());
                    pstmt.setString(19, hashMapArrayList.get(i).get("siteBottomCl1").toString());
                    pstmt.setString(20, hashMapArrayList.get(i).get("siteBottomCl2").toString());
                    pstmt.setString(21, hashMapArrayList.get(i).get("siteBottomCl3").toString());
                    pstmt.setString(22, hashMapArrayList.get(i).get("siteBottomCl4").toString());
                    pstmt.setString(23, hashMapArrayList.get(i).get("siteBottomCl5").toString());
                    pstmt.setString(24, (String) hashMapArrayList.get(i).get("animalCmgCl"));
                    pstmt.setString(25, (String) hashMapArrayList.get(i).get("eqpmnLendCl"));
                    pstmt.setString(26, (String) hashMapArrayList.get(i).get("themaEnvrnCl"));
                    pstmt.setString(27, hashMapArrayList.get(i).get("toiletCo").toString());
                    pstmt.setString(28, hashMapArrayList.get(i).get("swrmCo").toString());
                    pstmt.setString(29, (String) hashMapArrayList.get(i).get("brazierCl"));
                    pstmt.setString(30, (String) hashMapArrayList.get(i).get("glampInnerFclty"));
                    pstmt.setString(31, (String) hashMapArrayList.get(i).get("caravInnerFclty"));
                    pstmt.setString(32, (String) hashMapArrayList.get(i).get("firstImageUrl"));
                    pstmt.setString(33, (String) hashMapArrayList.get(i).get("sbrsCl"));
                    pstmt.setString(34, (String) hashMapArrayList.get(i).get("sbrsEtc"));
                    pstmt.setString(35, (String) hashMapArrayList.get(i).get("posblFcltyCl"));
                    pstmt.setString(36, (String) hashMapArrayList.get(i).get("posblFcltyEtc"));
                    pstmt.setString(37, (String) hashMapArrayList.get(i).get("operPdCl"));
                    pstmt.setString(38, (String) hashMapArrayList.get(i).get("operDeCl"));
                    pstmt.setString(39, (String) hashMapArrayList.get(i).get("facltDivNm"));
                    pstmt.executeUpdate();
                }
                // 커밋
                con.commit();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (pstmt != null) try {
                    pstmt.close();
                    pstmt = null;
                } catch (SQLException ex) {
                }
                if (con != null) try {
                    con.close();
                    con = null;
                } catch (SQLException ex) {
                }
            }
            mapper.apiFilter();
        }
    }
}
