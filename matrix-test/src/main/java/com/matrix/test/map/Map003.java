package com.matrix.test.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 分拣存储 统计一个字符串中某个单词出现的次数（this is a cat and that is a mice and where is the food
 * ?）
 * 
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月18日
 * 
 */
public class Map003 {

	public static void main(String[] args) {
		String s = "this is a cat and that is a mice and where is the food ?";
		String[] arr = s.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : arr) {
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}

		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		Map<String, Letter> map2 = new HashMap<String, Letter>();

		for (String str : arr) {
			if (!map2.containsKey(str)) {
				map2.put(str, new Letter(str));
			} else {
				Letter letter = map2.get(str);
				letter.setCount(letter.getCount() + 1);
				map2.put(str, letter);
			}
		}

	}
}
