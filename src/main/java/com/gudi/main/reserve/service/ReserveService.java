package com.gudi.main.reserve.service;

import com.gudi.main.dtoAll.BoardDTO;
import com.gudi.main.reserve.dao.ReserveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReserveService {
    @Autowired
    ReserveMapper mapper;
    public BoardDTO test() {

       BoardDTO dto = mapper.test();

        return dto;
    }
}
