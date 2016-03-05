package com.matrix.dao.extract.hanxin;

import org.springframework.stereotype.Repository;

import com.matrix.dao.impl.BaseDaoImpl;
import com.matrix.entry.extract.hanxin.HanxinNameCidEntry;

/**
 * 功能：韩鑫接口操作dao层实现类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月5日
 */
@Repository("hanXinDaoImpl")
public class HanXinDaoImpl extends BaseDaoImpl implements IHanXinDao {

	@Override
	public HanxinNameCidEntry selectByCidName() {
		return (HanxinNameCidEntry) this
				.queryForObjectBySql("com.matrix.entry.extract.hanxin.HanxinNameCidEntry.selectById", 1);
	}

}
