package com.matrix.entry.extract.hanxin;

/**
 * 功能：韩鑫(姓名+身份证)实体类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月5日
 */
public class HanxinNameCidEntry extends HanxinBaseEntry {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 身份证
	 */
	private String cid;
	
	/**
	 * 状态
	 */
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
