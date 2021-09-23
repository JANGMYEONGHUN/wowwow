package com.spring.test;

import java.util.ArrayList;
import java.util.HashMap;

public interface TestMapper {

	ArrayList<HashMap<String, Object>> getBoardList(HashMap<String,Integer> map);

	int getTotalCount();

}
