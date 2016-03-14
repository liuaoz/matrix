package datastructurealgorithm.chapter06;

public class Triangle {

	public static void main(String[] args) {
		long[] arr = { 1, 3, 4, 6, 7, 9, 14, 25, 30, 33, 40, 60 };
		find(15, arr);

	}

	public static void print(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static int find(long searchKey, long[] arr) {
		int size = arr.length;
		int down = 0;
		int up = size - 1;
		int middle;
		while (true) {
			middle = (down + up) / 2;
			if (middle > up || middle < down) {
				System.out.println("找不到匹配的数据：" + searchKey);
				break;
			}
			if (arr[middle] == searchKey) {
				System.out.println("要查找的数据：" + searchKey + "所在的位置为:" + middle);
				return middle;
			} else if (arr[middle] > searchKey) {
				up = middle - 1;
			} else if (arr[middle] < searchKey) {
				down = middle + 1;
			} else {
				System.out.println("找不到匹配的数据：" + searchKey);
				break;
			}
		}
		return -1;
	}

}
