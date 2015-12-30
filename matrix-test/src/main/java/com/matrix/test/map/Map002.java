package com.matrix.test.map;

/**
 * map 由数据实现map
 *
 * @author matrix
 *
 * @date 2015年11月11日
 * 
 */
public class Map002 {

	Entry arr[] = new Entry[999];

	int size;

	public void put(Object key, Object value) {
		Entry entry = new Entry(key, value);
		int a = key.hashCode() % 999;
		if (arr[a] == null) {

		} else {

		}
		arr[a] = entry;
		size++;
	}

	public Object get(Object key) {
		int a = key.hashCode() % 999;
		return arr[a].value;
	}

	public static void main(String[] args) {
		Map002 map = new Map002();
		map.put("aa", "a");
		map.put("bb", "b");

		System.out.println(map.size);
		System.out.println(map.get("aa"));

	}

	class Entry {
		Object key;
		Object value;

		public Entry(Object key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Entry() {
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
	}

	class LinkList {

	}
}
