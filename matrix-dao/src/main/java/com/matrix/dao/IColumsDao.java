package com.matrix.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.matrix.comm.PageCond;
import com.matrix.entry.BaseEntry;

/**
 * 功能：持久层列操作接口
 * 
 * @author matrix
 * @date 2015年9月22日
 * @since 1.0
 */
public interface IColumsDao extends ISimpleDao {

	/**
	 * 使用列值进行删除，仅删除一行数据
	 * 
	 * @param classInfo
	 *            类型信息
	 * @param columnValues
	 *            列条件
	 * @param <E>
	 *            类型信息
	 * 
	 * @return 是否成功删除<code>true</code>删除一行<code>false</code>删除失败
	 * 
	 */
	<E extends BaseEntry> boolean deleteByColumns(final Class<E> classInfo, final Map<String, Object> columnValues);

	/**
	 * 按照执行列名，取得对应于columnValues值得对应列值
	 * 
	 * @param <E>
	 *            类型信息
	 * @param classInfo
	 *            类型信息
	 * @param columnValues
	 *            查询线索
	 * @param resultColumns
	 *            结果列名
	 * @return 查询获得的数据
	 */
	<E extends BaseEntry> E queryByColumns(final Class<E> classInfo, final Map<String, Object> columnValues,
			final Set<String> resultColumns);

	/**
	 * 查询对应于columnValues的对应数据实体主键列表
	 * 
	 * @param <E>
	 *            类型信息
	 * @param classInfo
	 *            类型信息
	 * @param columnValues
	 *            查询线索
	 * @param pageCond
	 *            分页条件
	 * @return 对应的数据实体主键
	 */
	<E extends BaseEntry> List<Long> queryEntryIdListByColumns(final Class<E> classInfo,
			final Map<String, Object> columnValues, final PageCond pageCond);

	/**
	 * 使用列名和值查询实体列表
	 * 
	 * @param <E>
	 *            实体类型
	 * @param classInfo
	 *            类型信息
	 * @param columnValues
	 *            列名和值映射，当值为列表时，采用in作为操作符
	 * @param pageCond
	 *            分页条件
	 * @return 对应的实体列表，如果不存在返回空列表
	 */
	<E extends BaseEntry> List<E> queryListByColumns(final Class<E> classInfo, final Map<String, Object> columnValues,
			final PageCond pageCond);

	/**
	 * 返回按照指定列名，使用列名和值查询实体列表
	 * 
	 * @param <E>
	 *            实体类型
	 * @param classInfo
	 *            类型信息
	 * @param columnValues
	 *            列名和值映射，当值为列表时，采用in作为操作符
	 * @param resultCoumnsName
	 *            指定的返回列
	 * @param pageCond
	 *            分页条件
	 * @return 对应的实体列表，如果不存在，返回空列表
	 */
	<E extends BaseEntry> List<E> queryListByColumns(final Class<E> classInfo, final Map<String, Object> columnValues,
			final Set<String> resultCoumnsName, final PageCond pageCond);

	/**
	 * 使用条件更新列值，但只更新一行，多行时返回false
	 * 
	 * @param tobeUpdate
	 *            待更新实体数据
	 * @param columnValues
	 *            更新条件
	 * @return 是否更新成功 <code>true</code>更新一行 <code>false</code>更新失败
	 */
	boolean updateByColumns(final BaseEntry tobeUpdate, final Map<String, Object> columnValues);

	/**
	 * 使用主键更新指定列的信息
	 * 
	 * @param tobeUpdate
	 *            待更新实体数据
	 * @param columnNameSet
	 *            指定列名集合
	 * @return 是否更新成功
	 */
	boolean updateColumns(final BaseEntry tobeUpdate, final Set<String> columnNameSet);

}
