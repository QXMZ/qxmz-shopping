package com.qxmz.springcloud.dao;

import com.qxmz.springcloud.entity.Class2;
import java.util.List;

public interface Class2Mapper {
	int deleteByPrimaryKey(Integer class2Id);

	int insert(Class2 record);

	Class2 selectByPrimaryKey(Integer class2Id);

	List<Class2> selectAll();

	int updateByPrimaryKey(Class2 record);

	/**
	 * 查询class1表中指定class1_id的二级类别信息
	 * 
	 * @param class1Id
	 * @return 成功返回java.util.list类型实例，失败返回null
	 */
	public abstract List<Class2> selectByClass1Id(Integer class1Id);
}