package com.matrix.biz.extract.hanxin;

import org.springframework.security.core.userdetails.User;

import com.matrix.biz.extract.AbstractService;

/**
 * 功能：数据源-韩鑫父类
 * 
 * @author matrix
 * @version 1.0
 * @date 2016年2月27日
 */
public class AbstractHxService extends AbstractService<User> {

	@Override
	public void init() {

	}

	@Override
	public <E> E getDataFromLocal() {
		return null;
	}

	@Override
	public boolean isPass() {
		return false;
	}

	@Override
	public <E> E getDataFromRemote() {
		return null;
	}

	@Override
	public boolean isFetchFromRemote() {
		return false;
	}

}
