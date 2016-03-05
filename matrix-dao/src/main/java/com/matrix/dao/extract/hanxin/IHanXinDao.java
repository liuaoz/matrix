package com.matrix.dao.extract.hanxin;

import com.matrix.entry.extract.hanxin.HanxinNameCidEntry;

/**
 * 功能：韩鑫数据接口dao层接口类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月5日
 */
public interface IHanXinDao {
	
	/**
	 * 根据身份证和姓名查询
	 * @return
	 */
	HanxinNameCidEntry selectByCidName();

}
