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
 * 订单模块模型层的实现类，用于实现订单模块方法
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
			//订单信息两端加%
			orders.getUser().setUserName("%" + orders.getUser().getUserName() + "%");
		}
		//设置每页分页信息
		PageHelper.startPage(pageNumber + 1,PageUtils.PAGE_ROW_COUNT);
		//查询满足条件的翻页信息
		List<Orders> list = this.ordersMapper.selectOrders(orders);
		//返回分页信息
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
