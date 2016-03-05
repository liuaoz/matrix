package com.matrix.biz.extract.hanxin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.biz.extract.hanxin.AbstractHxService;
import com.matrix.dao.extract.hanxin.HanXinDaoImpl;
import com.matrix.entry.extract.hanxin.HanxinNameCidEntry;

/**
 * 功能：翰鑫姓名身份证认证实现类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年2月27日
 */
@Service("hxNameCidCheckBizImpl")
public class HxNameCidCheckBizImpl extends AbstractHxService {

	@Resource(name = "hanXinDaoImpl")
	private HanXinDaoImpl hanxinDaoImpl;

	public HanxinNameCidEntry getNameCidEntryByCid() {
		return hanxinDaoImpl.selectByCidName();
	}

}
