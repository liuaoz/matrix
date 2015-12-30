package com.matrix.test.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author matrix
 *
 * @date 2015��11��8��
 * 
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
	
	/*
	 1.7û�г����쳣
	 
	 */
}
