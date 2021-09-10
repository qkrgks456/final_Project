package com.gudi.main.util;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestClass {
/*   public static void main(String args[]) {
        // TODO Auto-generated method stub
        // url 선언
        String url = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList";
        // params 선언
        String params = "ServiceKey=YRc1yhIuj%2BSEq19P4LqBXRmFAtACpby0jiZKx%2BpSOyMnQ%2B5EX18dxJ%2BheYZ%2B4Ls%2FhYTVS6%2BFqoIZDjj2XmsmRg%3D%3D" +
                "&MobileOS=ETC&MobileApp=final_project&_type=json&pageNo=1&numOfRows=1780";

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
        JSONObject jsonObject4 = ApiUtil.jsonStringToJson(jsonObject3.get("items"));
        // 배열화
        ArrayList<HashMap<String, Object>> hashMapArrayList = ApiUtil.jsonArray(jsonObject4.get("item"));
        System.out.println(hashMapArrayList.size());

        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "Insert Into campingApi(contentId , lineIntro , facltNm, intro, allar, featureNm, induty, " +
                "lctCl, addr1, addr2, insrncAt, hvofBgnde, hvofEnddle, mapX," +
                "mapY, tel, homepage, resveUrl, gnrlSiteCo, autoSiteCo, glampSiteCo, caravSiteCo, indvdlCaravSiteCo," +
                "siteBottomCl1, siteBottomCl2, siteBottomCl3, siteBottomCl4, siteBottomCl5, trlerAcmpnyAt," +
                "caravAcmpnyAt, animalCmgCl, eqpmnLendCl, themaEnvrnCl, toiletCo, swrmCo," +
                " brazierCl,glampInnerFclty,caravInnerFclty,firstImageUrl,sbrsCl,sbrsEtc," +
                "posblFcltyCl,posblFcltyEtc,operPdCl,operDeCl,facltDivNm)" +
                "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Class.forName("net.sf.log4jdbc.DriverSpy");
            con = DriverManager.getConnection("jdbc:log4jdbc:oracle:thin:@61.78.121.242:1521:xe", "C##Modakbul_2", "pass");


            pstmt = con.prepareStatement(sql);


            for (int i = 0; i < hashMapArrayList.size(); i++) {
                String addr2 = "" + hashMapArrayList.get(i).get("addr2");
                String test = null;
                if (addr2 != null) {
                    test = addr2.toString();
                }

                pstmt.setString(1, hashMapArrayList.get(i).get("contentId").toString());
                pstmt.setString(2, (String) hashMapArrayList.get(i).get("lineIntro"));
                pstmt.setString(3, (String) hashMapArrayList.get(i).get("facltNm"));
                pstmt.setString(4, (String) hashMapArrayList.get(i).get("intro"));
                pstmt.setString(5, hashMapArrayList.get(i).get("allar").toString());
                pstmt.setString(6, (String) hashMapArrayList.get(i).get("featureNm"));
                pstmt.setString(7, (String) hashMapArrayList.get(i).get("induty"));
                pstmt.setString(8, (String) hashMapArrayList.get(i).get("lctCl"));
                pstmt.setString(9, (String) hashMapArrayList.get(i).get("addr1"));
                pstmt.setString(10, test);
                pstmt.setString(11, (String) hashMapArrayList.get(i).get("insrncAt"));
                pstmt.setString(12, (String) hashMapArrayList.get(i).get("hvofBgnde"));
                pstmt.setString(13, (String) hashMapArrayList.get(i).get("hvofEnddle"));
                pstmt.setString(14, hashMapArrayList.get(i).get("mapX").toString());
                pstmt.setString(15, hashMapArrayList.get(i).get("mapY").toString());
                pstmt.setString(16, (String) hashMapArrayList.get(i).get("tel"));
                pstmt.setString(17, (String) hashMapArrayList.get(i).get("homepage"));
                pstmt.setString(18, (String) hashMapArrayList.get(i).get("resveUrl"));
                pstmt.setString(19, hashMapArrayList.get(i).get("gnrlSiteCo").toString());
                pstmt.setString(20, hashMapArrayList.get(i).get("autoSiteCo").toString());
                pstmt.setString(21, hashMapArrayList.get(i).get("glampSiteCo").toString());
                pstmt.setString(22, hashMapArrayList.get(i).get("caravSiteCo").toString());
                pstmt.setString(23, hashMapArrayList.get(i).get("indvdlCaravSiteCo").toString());
                pstmt.setString(24, hashMapArrayList.get(i).get("siteBottomCl1").toString());
                pstmt.setString(25, hashMapArrayList.get(i).get("siteBottomCl2").toString());
                pstmt.setString(26, hashMapArrayList.get(i).get("siteBottomCl3").toString());
                pstmt.setString(27, hashMapArrayList.get(i).get("siteBottomCl4").toString());
                pstmt.setString(28, hashMapArrayList.get(i).get("siteBottomCl5").toString());
                pstmt.setString(29, hashMapArrayList.get(i).get("trlerAcmpnyAt").toString());
                pstmt.setString(30, hashMapArrayList.get(i).get("caravAcmpnyAt").toString());
                pstmt.setString(31, (String) hashMapArrayList.get(i).get("animalCmgCl"));
                pstmt.setString(32, (String) hashMapArrayList.get(i).get("eqpmnLendCl"));
                pstmt.setString(33, (String) hashMapArrayList.get(i).get("themaEnvrnCl"));
                pstmt.setString(34, (String) hashMapArrayList.get(i).get("toiletCo").toString());
                pstmt.setString(35, (String) hashMapArrayList.get(i).get("swrmCo").toString());
                pstmt.setString(36, (String) hashMapArrayList.get(i).get("brazierCl"));
                pstmt.setString(37, (String) hashMapArrayList.get(i).get("glampInnerFclty"));
                pstmt.setString(38, (String) hashMapArrayList.get(i).get("caravInnerFclty"));
                pstmt.setString(39, (String) hashMapArrayList.get(i).get("firstImageUrl"));
                pstmt.setString(40, (String) hashMapArrayList.get(i).get("sbrsCl"));
                pstmt.setString(41, (String) hashMapArrayList.get(i).get("sbrsEtc"));
                pstmt.setString(42, (String) hashMapArrayList.get(i).get("posblFcltyCl"));
                pstmt.setString(43, (String) hashMapArrayList.get(i).get("posblFcltyEtc"));
                pstmt.setString(44, (String) hashMapArrayList.get(i).get("operPdCl"));
                pstmt.setString(45, (String) hashMapArrayList.get(i).get("operDeCl"));
                pstmt.setString(46, (String) hashMapArrayList.get(i).get("facltDivNm"));
                // Batch 실행
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

    }*/
}
