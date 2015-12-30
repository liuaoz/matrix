package com.matrix.test.array;

/**
 * 功能：
 * @author matrix
 * @date 2015年11月30日
 * @since 
 */
public class LowArray {

	private long[] a;
	
	public LowArray(int size){
		a = new long[size];
	}
	
	public void setElem(int index,long value){
		a[index]=value;
	}
	
	public long getElem(int index){
		return a[index];
	}
	
}
