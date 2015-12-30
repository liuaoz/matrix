package com.matrix.test.map;

/**
 * 自定义实现map的功能
 * 
 * @author matrix
 *
 * @date 2015年11月9日
 * 
 */
public class Map001 {

	Entry[] arr = new Entry[990];

	int size;

	public void put(Object key, Object value) {
		Entry entry = new Entry(key, value);
		for (int i = 0; i < this.size; i++) {
			if(this.arr[i].key.equals(key)){
				this.arr[i].value=value;
				return;
			}
		}
		arr[size++] = entry;
	}

	public Object get(Object key) {
		for (int i = 0; i < this.size; i++) {
			if (arr[i].key.equals(key)) {
				return arr[i].value;
			}
		}
		return null;
	}

	public boolean containsKey(Object obj) {
		for (int i = 0; i < this.size; i++) {
			if (arr[i].key.equals(obj)) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public int size() {
		return this.size;
	}

	public Object remove(Object obj) {
		for (int i = 0; i < this.size; i++) {
			if (arr[i].key.equals(obj)) {
				Object v = arr[i].value;
				for (; i < size - 1; i++) {
					arr[i].key = arr[i + 1].key;
					arr[i].value = arr[i + 1].value;
				}
				size--;
				return v;
			}
		}
		return null;
	}

	public boolean containsValue(Object obj) {
		for (int i = 0; i < this.size; i++) {
			if (arr[i].value.equals(obj)) {
				return true;
			}

		}
		return false;
	}

	public void putAll(Map001 map) {
		for (int i = this.size - 1, j = 0; j < map.size; i++, j++) {
			Entry e = map.arr[j];
			arr[i].key = e.key;
			arr[i].value = e.value;
			size++;
		}
	}

	public void clear() {

	}

	public static void main(String[] args) {
		Map001 map = new Map001();
		map.put("aa", "a");
		map.put("aa", "a");
		map.put("bb", "b");

		System.out.println(map.get("aa").hashCode());

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
}
