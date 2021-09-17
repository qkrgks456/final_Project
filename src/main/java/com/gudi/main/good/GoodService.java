package com.gudi.main.good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GoodService {
    @Autowired
    GoodMapper mapper;

    public HashMap<String, Object> goodData(String contentId, String loginId, String division) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        boolean result = false;
        String check = mapper.goodCheck(contentId,  division, loginId);
        if (check == null) {
            mapper.goodInsert(contentId,  division, loginId);
            result = true;
        } else {
            mapper.goodDelete(contentId,  division, loginId);
        }
        int goodCount = mapper.goodCount(contentId,  division);
        map.put("goodCheck", result);
        map.put("goodCount", goodCount);
        return map;
    }
}
