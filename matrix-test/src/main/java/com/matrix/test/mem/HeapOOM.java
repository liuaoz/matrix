package com.matrix.test.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:\Java\dump (default path is root of the project)  
 * 
 * @author matrix
 * @date 2015Äê11ÔÂ8ÈÕ
 * 
 */
public class HeapOOM {

	static class OOMObject {

	}

	public static void main(String[] args) {

		List<OOMObject> list = new ArrayList<OOMObject>();

		while (true) {
			System.out.println("add....");
			list.add(new OOMObject());
		}

	}
/*
	java.lang.OutOfMemoryError: Java heap space
	Dumping heap to java_pid2576.hprof ...
	Heap dump file created [29805332 bytes in 0.825 secs]
	Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		at java.util.Arrays.copyOf(Arrays.java:2245)
		at java.util.Arrays.copyOf(Arrays.java:2219)
		at java.util.ArrayList.grow(ArrayList.java:242)
		at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:216)
		at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:208)
		at java.util.ArrayList.add(ArrayList.java:440)
		at com.matrix.test.mem.HeapOOM.main(HeapOOM.java:25)
*/
}
