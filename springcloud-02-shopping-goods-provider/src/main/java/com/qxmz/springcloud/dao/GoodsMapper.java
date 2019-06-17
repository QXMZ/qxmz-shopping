package com.qxmz.springcloud.dao;

import com.qxmz.springcloud.entity.Goods;
import java.util.List;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer goodsId);

	int insert(Goods record);

	Goods selectByPrimaryKey(Integer goodsId);

	List<Goods> selectAll();

	int updateByPrimaryKey(Goods record);

	/**
	 * ��ѯgoods����������������Ʒ��Ϣ
	 * 
	 * @param goods ��ѯ����
	 * @return �ɹ�����java.util.list��ʵ����ʧ�ܷ���null
	 */
	public abstract List<Goods> select(Goods goods);

	/**
	 * ���������޸�goods����ָ��goods_id����Ʒ��Ϣ
	 * 
	 * @param goods �޸ĵ���Ʒ��Ϣ
	 * @return �ɹ����ش���0��������
	 */
	public abstract Integer updateGoodsById(Goods goods);
	
	/**
	 * ��ѯ����ǰʮ����Ʒ��Ϣ
	 * 
	 * @return �ɹ�����java.util.List���͵�ʵ����ʧ�ܷ���null
	 */
	public abstract List<Goods> selectGroup();
}