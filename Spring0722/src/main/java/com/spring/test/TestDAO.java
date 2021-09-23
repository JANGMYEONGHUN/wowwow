package com.spring.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class TestDAO {
	
	@Autowired
	private SqlSession session;
	
	
	public ArrayList<HashMap<String, Object>> getBoardList(HashMap<String,Integer> map){
		ArrayList<HashMap<String, Object>> result = null;
		TestMapper mapper = null;
		
		try {
			mapper = session.getMapper(TestMapper.class);
			result = mapper.getBoardList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public int getTotalCount() {
		int result = 0;
		TestMapper mapper = null;
		
		try {
			mapper = session.getMapper(TestMapper.class);
			result = mapper.getTotalCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
