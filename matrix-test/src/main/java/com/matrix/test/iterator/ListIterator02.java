package com.matrix.test.iterator;

import java.util.Iterator;

/**
 * 迭代器 （类售票員收票）一个容器可以创建多个迭代器 内部类实现
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月17日
 * 
 * 理解迭代器原理
 * 
 */
public class ListIterator02 {
	
	private String[] element ={"a","b","c"};
	
	private int size = element.length;
	
	public Iterator iterator(){
		return new Itr();
	}
	
	/**
	 * 內部類
	 */
	private class Itr implements Iterator{

		private int coursor = -1;
		
		public boolean hasNext(){
			return coursor+1<ListIterator02.this.size;
		}
		
		public String next(){
			coursor++;
			return element[coursor];
		}
		
		public void remove(){
			//移動數組元素
			System.arraycopy(element, coursor+1, element, coursor, ListIterator02.this.size-(coursor+1));
			ListIterator02.this.size--;
			this.coursor--;
		}
	}
	
	public static void main(String[] args) {
		ListIterator02.Itr itr = new ListIterator02().new Itr();
		System.out.println(itr.next());
		
		ListIterator02 list = new ListIterator02();
		Iterator itr2 = list.iterator();//重新创建一个迭代器，而不需要再创建一个容器
		System.out.println(itr2.next());
		
	}
	
}
