package com.qxmz.springcloud.service;

import java.util.List;

import com.qxmz.springcloud.entity.Class1;
import com.qxmz.springcloud.entity.Class2;

/**
 * ���ڶ���һ�����Ͷ������ģ��ķ���
 * 
 * @author qxmz
 *
 */
public interface TypeService {

	/**
	 * ��ѯ����һ��������Ϣ
	 * 
	 * @return �ɹ�����java.util.list���͵�ʵ�������򷵻�null
	 */
	public abstract List<Class1> selectAllClass1();

	/**
	 * ����һ������Ų�ѯ��Ӧ�Ķ��������Ϣ
	 * 
	 * @param class1Id һ�������
	 * @return �ɹ�����java.util.list���͵�ʵ�������򷵻�null
	 */
	public abstract List<Class2> selectClass2ByClass1Id(Integer class1Id);

}
