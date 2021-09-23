package com.spring.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.test.service.BoardService;



@Controller
@RequestMapping("/board")
public class SpringController {

	
	private static final Logger logger = LoggerFactory.getLogger(SpringController.class);

	@Autowired
	BoardService service;

}
