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
public class ListIterator06<E> implements Iterable<E> {

	private Object[] element = new Object[5];//没有泛型数组，所以不能用E

	private int size = 0;

	public void add(E s) {
		if (size == element.length) {
			element = Arrays.copyOf(element, size * 2 + 5);
		}
		element[size++] = s;
	}

	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int coursor = -1;

			public boolean hasNext() {
				return coursor + 1 < ListIterator06.this.size;
			}

			@SuppressWarnings("unchecked")
			public E next() {
				coursor++;
				return (E) element[coursor];
			}

			public void remove() {
				// 移動數組元素
				System.arraycopy(element, coursor + 1, element, coursor, ListIterator06.this.size - (coursor + 1));
				ListIterator06.this.size--;
				this.coursor--;
			}

		};
	}

	public static void main(String[] args) {
		ListIterator06<String> list = new ListIterator06<String>();
		list.add("aa");
		list.add("aa");
		list.add("aa");
		list.add("aa");
		list.add("aa");		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		ListIterator06<Integer> list2 = new ListIterator06<Integer>();
		list2.add(1);
		list2.add(2);
		Iterator<Integer> it2 = list2.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
	}

}
