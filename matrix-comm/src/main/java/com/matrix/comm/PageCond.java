package com.matrix.comm;

/**
 * 功能：分页类信息
 * 
 * @author matrix
 * @date 2015年9月22日
 * @since 1.0
 */
public class PageCond {

	/**
	 * 表示查询结果的总条数。缺省统计
	 */
	private int count;

	/**
	 * 查询结果集中的起始位置。缺省为0
	 */
	private int start;

	/**
	 * 表示每页显示数据的条数。缺省为10
	 */
	private int limit;
	/**
	 * 表示结果集的结束位置。值为start+limit
	 */
	private int end;

	public PageCond() {
		super();
		this.start = 0;
		this.limit = 10;
		this.count = 0;
		this.end = this.start + this.limit;
	}

	/**
	 * 使用起始位置和每页条数为分页条件构造对象
	 * 
	 * @param start
	 *            {@link #start}
	 * @param limit
	 *            {@link #limit}
	 */
	public PageCond(int start, int limit) {
		super();
		this.start = start;
		this.limit = limit;
	}

	/**
	 * @return {@link #count}
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            {@link #count}
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return {@link #start}
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            {@link #start}
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return {@link #limit}
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            {@link #limit}
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return {@link #end}
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            {@link #end}
	 */
	public void setEnd(int end) {
		this.end = end;
	}

}
