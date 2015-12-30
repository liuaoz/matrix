package com.matrix.test.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 迭代器 （类售票員收票）一个容器可以创建多个迭代器 匿名内部类实现
 * 
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月17日
 * 
 *       理解迭代器原理
 * 
 */
public class ListIterator05 implements Iterable<Object> {

	private String[] element = new String[5];

	private int size = 0;

	public void add(String s) {
		if (size == element.length) {
			element = Arrays.copyOf(element, size * 2 + 5);
		}
		element[size++] = s;
	}

	public Iterator iterator() {
		return new Iterator() {

			private int coursor = -1;

			public boolean hasNext() {
				return coursor + 1 < ListIterator05.this.size;
			}

			public String next() {
				coursor++;
				return element[coursor];
			}

			public void remove() {
				// 移動數組元素
				System.arraycopy(element, coursor + 1, element, coursor, ListIterator05.this.size - (coursor + 1));
				ListIterator05.this.size--;
				this.coursor--;
			}

		};
	}

	public static void main(String[] args) {
		ListIterator05 list = new ListIterator05();
		list.add("aa");
		list.add("aa");
		list.add("aa");
		list.add("aa");
		list.add("aa");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// foreach
		for (Object s : list) {
			System.out.println(s);

		}
	}

}
