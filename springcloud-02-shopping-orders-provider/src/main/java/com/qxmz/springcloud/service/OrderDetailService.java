package com.qxmz.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.qxmz.springcloud.entity.OrderDetail;

/**
 * ������ϸģ̬���ģ�Ͳ㣬���ڶ��嶩����ϸģ��ķ���
 * @author qxmz
 *
 */
public interface OrderDetailService {

	/**
	 * ��ѯָ��������ŵĶ�����ϸ��Ϣ����ҳ���ܣ�
	 * @param orderId �������
	 * @param pageNumber ҳ��
	 * @return �ɹ�����com.github.pagehelper.PageInfo<OrderDetail>���͵�ʵ��
	 */
	public abstract PageInfo<OrderDetail> selectByOrderId(Integer orderId,Integer pageNumber);
}
