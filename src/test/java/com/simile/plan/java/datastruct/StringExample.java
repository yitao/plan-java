package com.simile.plan.java.datastruct;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2021/09/06
 */
public class StringExample {

	@Test
	public void valueOfCase() {
		String a = String.valueOf("张三");
		String b = String.valueOf("张三");
		String c = new String("张三");
		String d = new String("张三");
		System.out.println(a == b);
		System.out.println(c == d);
		System.out.println(String.format("a=%s,b=%s", a, b));
		System.out.println(String.format("c=%s,d=%s", c, d));
	}
}
