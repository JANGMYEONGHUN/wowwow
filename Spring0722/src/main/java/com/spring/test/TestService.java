package com.spring.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TestService {
	
	@Autowired
	private TestDAO dao;
	
	public ArrayList<HashMap<String, Object>> getBoardList(int startRecord,int countPerPage) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startRecord", startRecord);
		map.put("countPerPage", countPerPage);
		return dao.getBoardList(map);
	}

	public int getTotalCount() {

		return  dao.getTotalCount();
	}

}
