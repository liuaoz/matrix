package com.matrix.test.collectionsort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月22日
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = { 9,1,2,4,6};
		sort(arr);
	}

	public static void sort1(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = tmp;
				}
			}
		}
	}

	/**减少每趟的次数(即-j 操作)
	 * @param arr
	 */
	public static void sort2(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = tmp;
				}
			}
		}
	}
	
	/**
	 * 最终版本（对于已经排序好的数据，不需要重复比较）(9,1,2,4,6)
	 * @param arr
	 */
	public static void sort(int[] arr){
		for (int j = 0; j < arr.length - 1; j++) {
			System.out.println("第"+j+"趟");
			boolean sorted = true;
			for (int i = 0; i < arr.length - 1 - j; i++) {
				System.out.print("第"+i+"次");
				sorted = true;
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = tmp;
					sorted = false;
				}
				System.out.println(Arrays.toString(arr));
				if(sorted){
					break;
				}
			}
			if(sorted){
				break;
			}
		}
		
	}

}
