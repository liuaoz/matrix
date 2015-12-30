package com.matrix.test.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义一个Student类，属性name,no,score 现在将若干student对象放入list 。请统计出每个班级的总分和平均分
 * 面向对象+分解存储
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月19日
 * 
 */
public class Map004 {
	
	public static List<Student> exam(){
		
		List<Student> list  = new ArrayList<>();
		
		list.add(new Student("a","1",5.0));
		list.add(new Student("b","1",6.0));
		list.add(new Student("c","1",3.0));
		list.add(new Student("d","2",4.0));
		list.add(new Student("e","2",7.0));
		list.add(new Student("f","1",5.0));
		list.add(new Student("g","1",5.0));
		
		return list;
		
	}
	
	/**
	 * 统计分析
	 * 1、面向对象
	 * 2、分拣存储
	 * @param list
	 * @return
	 */
	public static Map<String,ClassRoom> count(List<Student> list){
		
		 Map<String,ClassRoom> map =new  HashMap<String,ClassRoom>();
		 for(Student stu:list){
			 String no = stu.getNo();
			 ClassRoom cr = map.get(no);
			 List<Student> list2 = new ArrayList<Student>();
			 if(null == cr){
				 ClassRoom cr2 = new ClassRoom(no);
				 list2.add(stu);
				 cr2.setStus(list2);
				 cr2.setTotal(stu.getScore());
				 map.put(stu.getNo(), cr2);
			 }else{
				 list2.add(stu);
				 cr.setStus(list2);
				 
			 }
			 
		 }
		 return map;
		
	}
	
	

}
