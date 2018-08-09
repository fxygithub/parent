package com.fxy.app;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

public class ApplicationApp {
	public static void main(String[] args) {
		Map<String ,Object> topicTable = new HashMap<>();//主题表单，从前端上传过来的
		topicTable.put("name","符幸云");
		topicTable.put("address","海南商品街");
		topicTable.put("phone","海南商品街");
		topicTable.put("decline","2018.07.20-2018.07.22");
		topicTable.put("decline1","2018.07.20");
		topicTable.put("decline2","2018.07.22");


		Map<String,String> twoItem = new HashMap<>();//经营许可浪潮事项name，拼接key
		twoItem.put("twoName","name");//浪潮key-主题key
		twoItem.put("twoAddress","address");//浪潮key-主题key
		twoItem.put("twoPhone","phone");//浪潮key-主题key
		System.out.print("1.");
		getlastTalbe(topicTable,twoItem);

		Map<String,String> oneItem = new HashMap<>();//新办浪潮事项name，拼接key
		oneItem.put("oneName","name");
		oneItem.put("oneAddress","address");
		oneItem.put("oneDecline","decline");
		oneItem.put("oneDecline1","decline1");
		oneItem.put("oneDecline2","decline2");
		System.out.print("2.");
		getlastTalbe(topicTable,oneItem);

		List<Map<String,String>> items  = new ArrayList<>();//存放事项映射表,即选择了两个事项之后
		items.add(oneItem);
		items.add(twoItem);
		getlastTalbeByFxy(items);

	}

	//2.给前台的name集合（参数是多个事项映射表的集合）
	public static void getlastTalbeByFxy(List<Map<String,String>> items){//给前台传过去的数据
		List<String> showKey = new ArrayList<>();//前端要显示的字段,最后就放jsonObject
		for (int i=0;i<items.size();i++){//遍历选择的事项字段，去重之后给前台
			for(String key: items.get(i).keySet()){//遍历事项映射表，拿出要显示的key
				if(!showKey.contains(items.get(i).get(key))){
					showKey.add(items.get(i).get(key));//把key添加到list去前台显示
				}
			}
		}
		System.out.println("给前台的数据key："+showKey.toString());
	}
	//1.整理给浪潮的数据整理（参数前台数据，和一个事项映射表）
	public static void getlastTalbe(Map<String,Object> topicTable,Map<String,String> itemMapping){
		Map<String,Object> lastTalbe = new HashMap<>();
		for (String key:itemMapping.keySet()){//遍历事项映射表
			String paramKey = itemMapping.get(key);//主题key
			lastTalbe.put(key,topicTable.get(paramKey));//事项key，前台值
		}
		System.out.println("最后提交的表单："+lastTalbe.toString());
	}

}
