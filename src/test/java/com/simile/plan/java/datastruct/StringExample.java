package com.simile.plan.java.datastruct;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2021/09/06
 */
public class StringExample {
    protected static final String WITH_AND_OR_DELIMITER = "((?<= and )|(?<= or ))";

    @Test
    public void rep() {
        String expr = "CURRENT.work_float<13.23 or CURRENT.work_float>=21.45";
//        String expr = "CURRENT.work_float>=21.45";
        String[] exprArray = expr.split(WITH_AND_OR_DELIMITER);
        for (String s : exprArray) {
            System.out.println("----");
            System.out.println(s);
        }

    }

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

	@Test
	public void testReplace(){
		String a = "{{{sss}}}}}";
		System.out.println(a.replace("}}","} }"));
		System.out.println(a.replaceAll("}}","} }"));
		System.out.println(a.replaceAll("\\}\\}","} }"));
		System.out.println(a.replaceAll("}}","} } "));
	}

    @Test
    public void name() {
//	    String table = "xx.xx";
	    String table = "xx444.222";
        if (table.contains(".")) {
            table = table.substring(table.lastIndexOf(".") + 1);
        }
        System.out.println(table);
    }
}
