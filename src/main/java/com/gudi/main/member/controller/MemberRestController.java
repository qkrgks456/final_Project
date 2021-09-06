package com.gudi.main.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
public class MemberRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


}
