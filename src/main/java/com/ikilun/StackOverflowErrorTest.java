package com.ikilun;

public class StackOverflowErrorTest {
	//递归过深，递归没有出口
	private static void test(){
		test();
	}
	public static void main(String[] args) {
		test();
	}
}
