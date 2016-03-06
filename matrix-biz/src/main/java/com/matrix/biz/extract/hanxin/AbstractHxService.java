package com.matrix.biz.extract.hanxin;

import com.matrix.biz.extract.AbstractService;

/**
 * 功能：数据源-韩鑫父类
 * 
 * @author matrix
 * @version 1.0
 * @date 2016年2月27日
 */
public class AbstractHxService extends AbstractService {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFetchFromRemote() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <E> E getDataFromLocal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <E> E getDataFromRemote() {
		// TODO Auto-generated method stub
		return null;
	}

}
