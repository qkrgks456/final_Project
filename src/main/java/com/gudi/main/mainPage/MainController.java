package com.gudi.main.mainPage;

import com.gudi.main.util.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MainController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MainService service;
	@RequestMapping(value = "/")
	public String main(HttpSession session) {
		session.setAttribute("access_token",null);
		return "redirect:/apiCall";
	}


	@RequestMapping(value = "/apiCall")
	public String apiCall(Model model) {
		HashMap<String,Object> map = service.apiCall();
		return "main";
	}
	@RequestMapping(value = "/test")
	public String test(MultipartFile file) {
		logger.info("안녕하세요 test입니다");
		UploadUtil.fileUpload(file);
		return "main";
	}
}
