package com.qxmz.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qxmz.springcloud.entity.Goods;

/**
 * ��Ʒģ�Ͳ�Ľӿڣ����ڶ�����Ʒģ��ķ���
 * 
 * @author qxmz
 *
 */
public interface GoodsService {

	/**
	 * ����µ���Ʒ��Ϣ
	 * 
	 * @param goods �µ���Ʒ��Ϣ
	 * @return �ɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer insert(Goods goods);

	/**
	 * ��ѯ������������Ʒ��Ϣ����ҳ���ܣ�
	 * 
	 * @param goods ��ѯ����
	 * @return �ɹ�����com.github.pagehelper.PageInfo��ʵ����ʧ�ܷ���null
	 */
	public abstract PageInfo<Goods> select(Goods goods, Integer PageNumber);

	/**
	 * ���������޸�goods����ָ��goods_id����Ʒ��Ϣ
	 * 
	 * @param goods �޸ĵ���Ʒ��Ϣ
	 * @return �ɹ����ش���0�����������򷵻�С�ڵ���0������
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * �޸�ָ����ŵĵ���Ʒ��Ϣ
	 * 
	 * @param goods �޸ĵ���Ʒ��Ϣ
	 * @return �ɹ����ش���0�����������򷵻�С�ڵ���0������
	 */
	public abstract Integer update(Goods goods);

	/**
	 * ��ѯ����ǰʮ����Ʒ��Ϣ
	 * 
	 * @return �ɹ�����java.util.List���͵�ʵ����ʧ�ܷ���null
	 */
	public abstract List<Goods> selectGroup();
}
