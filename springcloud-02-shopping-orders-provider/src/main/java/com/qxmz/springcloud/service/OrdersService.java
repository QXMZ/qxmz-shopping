package com.qxmz.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qxmz.springcloud.entity.Orders;

/**
 * ����ģ��ģ�Ͳ�Ľӿڣ����ڶ��嶩��ģ�͵ķ���
 * 
 * @author qxmz
 *
 */
public interface OrdersService {

	/**
	 * ��ѯ���������Ķ�����Ϣ(��ҳ����)
	 * 
	 * @param orders ��ѯ����
	 * @return �ɹ�����com.github.pagehelper.PageInfo<Orders>���͵�ʵ��
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders, Integer pageNumber);

	/**
	 * �޸�orders����ָ��order_id�Ķ���״̬
	 * 
	 * @param orders �޸Ķ�������Ϣ
	 * @return �ɹ����ش���0�����������򷵻�С�ڵ���0������
	 */
	public abstract Integer updateOrderStatus(Orders orders);

	/**
	 * ��ѯָ�������ڵ����۶�
	 * 
	 * @param orders ��ѯ����
	 * @return �ɹ�����java.util.List���͵�ʵ�������򷵻�null
	 */
	public abstract List<Orders> selectGroup(Orders orders);
}
