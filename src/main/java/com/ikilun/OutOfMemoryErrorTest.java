package com.ikilun;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorTest {
	//-Xms:初始堆大小 
	//-Xmx:最大堆大小 
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		while(true){
			strList.add("1");
		}
	}
}
