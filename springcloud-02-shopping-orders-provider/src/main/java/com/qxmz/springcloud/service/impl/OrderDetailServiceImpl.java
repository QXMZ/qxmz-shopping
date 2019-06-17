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
 * ������ϸģ��ģ�Ͳ��ʵ���࣬����ʵ�ֶ�����ϸģ��ķ���
 * @author qxmz
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Override
	public PageInfo<OrderDetail> selectByOrderId(Integer orderId, Integer pageNumber) {
		//����ÿҳ��ҳ��Ϣ
		PageHelper.startPage(pageNumber + 1,6);
		//��ѯָ��������ŵĶ�����ϸ��Ϣ
		List<OrderDetail> list = this.orderDetailMapper.selectByOrderId(orderId);
		//���ط�ҳ��Ϣ
		return new PageInfo<>(list);
	}

	
}
