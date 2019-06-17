package com.qxmz.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxmz.springcloud.common.PageUtils;
import com.qxmz.springcloud.dao.OrdersMapper;
import com.qxmz.springcloud.entity.Orders;
import com.qxmz.springcloud.service.OrdersService;

/**
 * ����ģ��ģ�Ͳ��ʵ���࣬����ʵ�ֶ���ģ�鷽��
 * @author April
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public PageInfo<Orders> selectOrders(Orders orders,Integer pageNumber) {
	
		if(orders.getUser() != null) {
			//������Ϣ���˼�%
			orders.getUser().setUserName("%" + orders.getUser().getUserName() + "%");
		}
		//����ÿҳ��ҳ��Ϣ
		PageHelper.startPage(pageNumber + 1,PageUtils.PAGE_ROW_COUNT);
		//��ѯ���������ķ�ҳ��Ϣ
		List<Orders> list = this.ordersMapper.selectOrders(orders);
		//���ط�ҳ��Ϣ
		return new PageInfo<>(list);
	}

	@Transactional
	@Override
	public Integer updateOrderStatus(Orders orders) {
		return this.ordersMapper.updateOrderStatus(orders);
	}

	@Override
	public List<Orders> selectGroup(Orders orders) {
		return this.ordersMapper.selectGroup(orders);
	}

	

}
