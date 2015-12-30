package com.matrix.test.array;

public class HighArray {

	private long[] a;
	private int nElems;

	public HighArray() {
		super();
	}

	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems;) {
			if (a[j] == searchKey) {
				break;
			}
			if (j == nElems)
				return false;
			else
				return true;
		}
		return false;
	}

	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			if (value == a[j])
				break;
		if (j == nElems)
			return false;
		else {
			for (int k = j; k < nElems; k++)
				a[k] = a[k + 1];
			nElems--;
			return true;
		}
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.println(a[j] + " ");
	}

	public long binarySearch(int[] srcArray, int des) {
		int low = 0;
		int high = srcArray.length - 1;
		while ((low <= high) && (low <= srcArray.length - 1) && (high <= srcArray.length - 1)) {
			int middle = low + ((high - low) >> 1);
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}
