package com.gudi.main.reserve.service;

import com.gudi.main.dtoAll.CommentDTO;
import com.gudi.main.reserve.dao.CommentMapper;
import com.gudi.main.reserve.dao.ReserveMapper;
import com.gudi.main.util.HansolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 해당 캠핑장 댓글 가져오기
    public HashMap<String, Object> commentList(String contentId, int page) {
        int start = 0;
        if (page != 1) {
            start = (page - 1) * 8;
        }
        ArrayList<CommentDTO> commentList = commentMapper.reserveCmList(contentId, start);
        int total = commentMapper.reserveTotal(contentId);
        HashMap<String, Object> map = HansolUtil.pagination(page, 8, total);
        map.put("commentList", commentList);
        return map;
    }

    public HashMap<String, Object> reserveCmInsert(String contentId, String commentContent, String loginId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        CommentDTO dto = new CommentDTO();
        dto.setContent(commentContent);
        dto.setId(loginId);
        dto.setDivisionNum(Integer.parseInt(contentId));
        int cmNum = commentMapper.reserveCmInsert(dto);
        System.out.println(dto.getCmNum());

        return null;
    }
}
