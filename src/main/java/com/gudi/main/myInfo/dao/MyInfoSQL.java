package com.gudi.main.myInfo.dao;

import org.apache.ibatis.jdbc.SQL;

public class MyInfoSQL {

    public String boardCheck(String loginId, int start, String division) {

        return new SQL() {{
            SELECT("*");
            switch (division) {
                case "review":
                    FROM("reviewBoard");
                    WHERE("id = #{param1}");
                    ORDER_BY("cmNum DESC");
                    JOIN("");
                case "free":
                    FROM("freeBoard");
                    WHERE("id = #{param1}");
                    ORDER_BY("cmNum DESC");
                case "question":
                    FROM("questionBoard");
                    WHERE("id = #{param1}");
                    ORDER_BY("cmNum DESC");
                case "notice":
                    FROM("noticeBoard");
                    WHERE("id = #{param1}");
                    ORDER_BY("cmNum DESC");
                case "camping":
                    FROM("campingBoard");
                    WHERE("id = #{param1}");
                    ORDER_BY("cmNum DESC");
                case "parking":
                    FROM("parking");
                    WHERE("id = #{param1}");
                    ORDER_BY("cmNum DESC");
                    break;
            }
        }}.toString() + "OFFSET #{param2} ROWS FETCH FIRST 15 ROWS ONLY";

    }
}
