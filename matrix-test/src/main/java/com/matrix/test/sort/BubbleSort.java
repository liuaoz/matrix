package com.matrix.test.sort;

import java.util.Arrays;

/**
 * 功能：bubble sort
 * 
 * @author matrix
 * @date 2015年12月1日
 * @since
 */
public class BubbleSort {

	private long[] arr;
	private int nElems;

	public BubbleSort(int max) {
		arr = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int j=0;j<nElems;j++)
			System.out.println(arr[j]+" ");
	}
	
	private void swap(int one,int two){
		long tmp = arr[one];
		arr[one]=arr[two];
		arr[two]=tmp;
	}
	
	public void bubbleSort(){
		int out,in;
		for(out=0;out<nElems-1;out++){
			for(in=0;in<nElems-out-1;in++){
				if(arr[in]>arr[in+1]){
					swap(in,in+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort(6);
		bs.insert(4);
		bs.insert(3);
		bs.insert(10);
		bs.insert(8);
		bs.insert(1);
		bs.insert(6);
		bs.bubbleSort();
		System.out.println(Arrays.toString(bs.arr));
	}

}
