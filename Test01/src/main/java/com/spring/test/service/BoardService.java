package com.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.dao.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;  

}
