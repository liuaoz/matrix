package com.matrix.biz.extract;

import java.util.List;

import com.matrix.bo.BaseBo;

/**
 * 功能：数据源取数抽象类，控制取数流程
 * 
 * @author matrix
 * @version 1.0
 * @date 2016年3月1日
 */
public abstract class AbstractDataSource<T extends BaseBo> {

	/**
	 * 初始化状态
	 */
	public abstract void init();

	/**
	 * 是否到上游取数
	 * 
	 * @return
	 */
	public abstract boolean isFetchFromRemote();

	/**
	 * 从本地库取数
	 * 
	 * @return
	 */
	public abstract Object getDataFromLocal();

	/**
	 * 本地是否有满足条件的数据
	 * 
	 * @return false:从上游取数 true:表示本地有数据
	 */
	public abstract boolean isPass();

	/**
	 * 从数据源取数
	 * 
	 * @return
	 */
	public abstract List<T> getDataFromRemote();

	/**
	 * 获取数据
	 */
	public void deal() {
		init();
		if (isFetchFromRemote()) {
			if (!isPass()) {
				getDataFromRemote();
			} else {
				getDataFromLocal();
			}
		} else {
			getDataFromLocal();
		}

	}

}
