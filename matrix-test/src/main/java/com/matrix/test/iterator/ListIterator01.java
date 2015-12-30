package com.matrix.test.iterator;

/**
 * 迭代器 （类售票員收票）
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月17日
 * 
 * 理解迭代器原理
 * 
 */
public class ListIterator01 {
	
	private String[] element ={"a","b","c"};
	
	private int size = element.length;
	
	private int coursor = -1;
	
	public boolean hasNext(){
		return coursor+1<size;
	}
	
	public String next(){
		coursor++;
		return element[coursor];
	}
	
	public void remove(){
		//移動數組元素
		System.arraycopy(element, coursor+1, element, coursor, this.size-(coursor+1));
		this.size--;
		this.coursor--;
	}
	
	public static void main(String[] args) {
		ListIterator01 list = new ListIterator01();
		
		while(list.hasNext()){
			System.out.println(list.next());
		}
		
		ListIterator01 list2 = new ListIterator01();
		while(list2.hasNext()){
			System.out.println(list2.next());
		}
	}

}
