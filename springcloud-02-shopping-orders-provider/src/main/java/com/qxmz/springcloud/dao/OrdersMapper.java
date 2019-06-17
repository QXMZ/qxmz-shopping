package com.qxmz.springcloud.dao;

import com.qxmz.springcloud.entity.Orders;
import java.util.List;

public interface OrdersMapper {
	int deleteByPrimaryKey(Integer orderId);

	int insert(Orders record);

	Orders selectByPrimaryKey(Integer orderId);

	List<Orders> selectAll();

	int updateByPrimaryKey(Orders record);

	/**
	 * ��ѯorders�������������Ķ�����Ϣ
	 * 
	 * @param orders ��ѯ����
	 * @return �ɹ�����java.util.List��ʵ�������򷵻�null
	 */
	public abstract List<Orders> selectOrders(Orders orders);

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