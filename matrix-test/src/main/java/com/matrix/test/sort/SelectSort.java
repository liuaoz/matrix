package com.matrix.test.sort;

import java.util.Arrays;

/**
 * 功能：select sort
 * @author matrix
 * @date 2015年12月1日
 * @since 
 */
public class SelectSort {
	

	private long[] arr;
	private int nElems;

	public SelectSort(int max) {
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
	
	public void selectSort(){
		long min = arr[0];
		int k=0;
		for(int i = 0;i<nElems-1;i++){
			for(int j =0;j<nElems-1;j++){
				if(arr[j]<min){
					k=j;
					min=arr[j];
				}
			}
			swap(k,i);
		}
	}
	
	public static void main(String[] args) {
		SelectSort ss = new SelectSort(6);
		ss.insert(4);
		ss.insert(3);
		ss.insert(10);
		ss.insert(8);
		ss.insert(1);
		ss.insert(6);
		ss.selectSort();
		System.out.println(Arrays.toString(ss.arr));
	}

}
