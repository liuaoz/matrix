package com.matrix.test.iterator;

import java.util.Iterator;

/**
 * 迭代器 （类售票員收票）一个容器可以创建多个迭代器   匿名内部类实现
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月17日
 * 
 * 理解迭代器原理
 * 
 */
public class ListIterator04 {
	
	private String[] element ={"a","b","c"};
	
	private int size = element.length;
	
	public Iterator iterator(){
		return new Iterator(){
			
			private int coursor = -1;

			public boolean hasNext(){
				return coursor+1<ListIterator04.this.size;
			}
			
			public String next(){
				coursor++;
				return element[coursor];
			}
			
			public void remove(){
				//移動數組元素
				System.arraycopy(element, coursor+1, element, coursor, ListIterator04.this.size-(coursor+1));
				ListIterator04.this.size--;
				this.coursor--;
			}
			
		};
	}
	
	public Iterator iterator2(){
		
		class Itr implements Iterator{
			private int coursor = -1;

			public boolean hasNext(){
				return coursor+1<ListIterator04.this.size;
			}
			
			public String next(){
				coursor++;
				return element[coursor];
			}
			
			public void remove(){
				//移動數組元素
				System.arraycopy(element, coursor+1, element, coursor, ListIterator04.this.size-(coursor+1));
				ListIterator04.this.size--;
				this.coursor--;
			}
		}
		
		return new Itr();
	}
	
	public static void main(String[] args) {
		ListIterator04 list = new ListIterator04();
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}
