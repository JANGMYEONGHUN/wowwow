package com.spring.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private TestService service;
	
	private static final int COUNT_PER_GROUP = 10;//페이지 당 글수(1~10,2~10)
	private static final int PAGE_PER_GROUP =5;// 그룹당 페이지수 (12345>678910)	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(defaultValue = "1")int currentPage,Model model) {
		logger.info("home 메소드 실행GET");
		
		logger.info("curretPage:{} ",currentPage);
		
		int totalRecordsCount = service.getTotalCount();//유동적인거라 메소드하나만듬.
		logger.info("totalRecordsCount:{} ", totalRecordsCount);
		PageNavigator navi = new PageNavigator(COUNT_PER_GROUP,PAGE_PER_GROUP,currentPage,totalRecordsCount);
		model.addAttribute("navi",navi);
		
		ArrayList<HashMap<String,Object>> boardList = service.getBoardList(
				navi.getStartRecord(),COUNT_PER_GROUP);
		logger.info("boardList:{} ",boardList);
		model.addAttribute("boardList",boardList);
		
		return "home";
	}
	
}
