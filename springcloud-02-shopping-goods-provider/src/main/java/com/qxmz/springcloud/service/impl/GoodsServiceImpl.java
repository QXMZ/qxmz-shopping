package com.qxmz.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxmz.springcloud.common.PageUtils;
import com.qxmz.springcloud.dao.GoodsMapper;
import com.qxmz.springcloud.entity.Goods;
import com.qxmz.springcloud.service.GoodsService;

/**
 * ��Ʒģ�Ͳ��ʵ���࣬����ʵ����Ʒģ��ķ���
 * @author qxmz
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Transactional
	@Override
	public Integer insert(Goods goods) {
		return this.goodsMapper.insert(goods);
	}

	@Override
	public PageInfo<Goods> select(Goods goods, Integer pageNumber) {
		//��Ʒ��Ϣ���˼�%
		goods.setGoodsName("%" + goods.getGoodsName() + "%");
		//����ÿҳ��ҳ��Ϣ
		PageHelper.startPage(pageNumber + 1,PageUtils.PAGE_ROW_COUNT);
		//��ѯ���������ķ�ҳ��Ϣ
		List<Goods> list = this.goodsMapper.select(goods);
		//���ط�ҳ��Ϣ
		return new PageInfo<>(list);
	}

	@Transactional
	@Override
	public Integer updateGoodsById(Goods goods) {
		return this.goodsMapper.updateGoodsById(goods);
	}

	@Transactional
	@Override
	public Integer update(Goods goods) {
		return this.goodsMapper.updateByPrimaryKey(goods);
	}

	@Override
	public List<Goods> selectGroup() {
		return this.goodsMapper.selectGroup();
	}


}
