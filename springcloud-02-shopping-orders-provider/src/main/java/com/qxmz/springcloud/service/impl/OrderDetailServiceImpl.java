package com.qxmz.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxmz.springcloud.dao.OrderDetailMapper;
import com.qxmz.springcloud.entity.OrderDetail;
import com.qxmz.springcloud.service.OrderDetailService;

/**
 * 订单明细模块模型层的实现类，用于实现订单明细模块的方法
 * @author qxmz
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Override
	public PageInfo<OrderDetail> selectByOrderId(Integer orderId, Integer pageNumber) {
		//设置每页分页信息
		PageHelper.startPage(pageNumber + 1,6);
		//查询指定订单编号的订单明细信息
		List<OrderDetail> list = this.orderDetailMapper.selectByOrderId(orderId);
		//返回分页信息
		return new PageInfo<>(list);
	}

	
}
