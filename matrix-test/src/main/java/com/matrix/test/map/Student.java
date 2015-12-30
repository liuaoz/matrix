package com.matrix.test.map;

/**
 *
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月19日
 * 
 */
public class Student {

	private String name;
	
	private String no;
	
	private double score;
	
	private ClassRoom cr ;

	public Student(String name, String no, double score, ClassRoom cr) {
		super();
		this.name = name;
		this.no = no;
		this.score = score;
		this.cr = cr;
	}
	
	

	public Student(String name, String no, double score) {
		super();
		this.name = name;
		this.no = no;
		this.score = score;
	}



	public void setCr(ClassRoom cr) {
		this.cr = cr;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public ClassRoom getCr() {
		return cr;
	}
	
	
}
