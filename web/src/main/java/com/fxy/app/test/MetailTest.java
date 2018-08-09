package com.fxy.app.test;


import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class MetailTest {
	public static void main(String[] args) {
		MetailTest test = new MetailTest();
		String str = test.generateUniqueKey();
		System.out.println("Unique ID : " + test.generateUniqueKey());
		Assert.hasLength(null,"长度不够");
		Assert.notNull(null,"出错了");
		}

	public String generateUniqueKey(){
		String id = UUID.randomUUID().toString();
		return id;

	}

}
