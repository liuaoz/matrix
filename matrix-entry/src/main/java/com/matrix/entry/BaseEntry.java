package com.matrix.entry;

import java.sql.Timestamp;

/**
 * 数据层抽象实体父类
 * 
 * @author matrix
 * @date 2015年9月20日
 * @since 1.0
 */
public abstract class BaseEntry {

	/**
	 * 主鍵
	 */
	private long id;

	/**
	 * 操作人
	 */
	private String userCode;

	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	/**
	 * 更新时间
	 */
	private Timestamp updateTime;

	/**
	 * 版本号
	 */
	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
