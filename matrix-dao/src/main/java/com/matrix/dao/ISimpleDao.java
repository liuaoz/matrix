package com.matrix.dao;

import com.matrix.entry.BaseEntry;

/**
 * 功能：
 * 
 * @author matrix
 * @date 2015年9月20日
 * @since
 */
public interface ISimpleDao {
	/**
	 * 根据实体主键删除数据
	 * 
	 * @param <E>
	 *            实体类型
	 * 
	 * @param entryID
	 *            实体主键
	 * @param entryClass
	 *            实体类型信息
	 * @return 是否成功删除
	 */
	<E extends BaseEntry> boolean deleteByEntryID(final long entryID, final Class<E> entryClass);

	/**
	 * 新增数据
	 * 
	 * @param entry
	 *            数据实体
	 * @return 主键
	 */
	long insert(final BaseEntry entry);

	/**
	 * 带主键，新增数据
	 * 
	 * @param entry
	 *            数据实体
	 * @return 主键
	 */
	long insertWithPK(final BaseEntry entry);

	/**
	 * 使用线索查询信息
	 * 
	 * @param <E>
	 *            实体类型
	 * 
	 * @param entryID
	 *            实体主键
	 * @param entryClass
	 *            实体类型信息
	 * @return 对应的实体数据
	 */
	<E extends BaseEntry> E queryByEntryID(final long entryID, final Class<E> entryClass);

	/**
	 * 使用主键更新信息
	 * 
	 * @param tobeUpdate
	 *            待更新的数据，含主键
	 * @return 是否更新成功
	 */
	boolean update(final BaseEntry tobeUpdate);

}