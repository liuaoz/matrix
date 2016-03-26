package com.matrix.biz.extract.hanxin;

import java.util.List;

import com.matrix.biz.extract.AbstractDataSource;
import com.matrix.bo.extract.hanxin.HanxinBaseBo;

/**
 * 功能：数据源-韩鑫父类
 * 
 * @author matrix
 * @version 1.0
 * @date 2016年2月27日
 */
public class AbstractHxService extends AbstractDataSource<HanxinBaseBo> {

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
	public Object getDataFromLocal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HanxinBaseBo> getDataFromRemote() {
		// TODO Auto-generated method stub
		return null;
	}

}
