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
	 * ��ѯclass1����ָ��class1_id�Ķ��������Ϣ
	 * 
	 * @param class1Id
	 * @return �ɹ�����java.util.list����ʵ����ʧ�ܷ���null
	 */
	public abstract List<Class2> selectByClass1Id(Integer class1Id);
}