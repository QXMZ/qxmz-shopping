package com.qxmz.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qxmz.springcloud.entity.Goods;

/**
 * 商品模型层的接口，用于定义商品模块的方法
 * 
 * @author qxmz
 *
 */
public interface GoodsService {

	/**
	 * 添加新的商品信息
	 * 
	 * @param goods 新的商品信息
	 * @return 成功返回大于0的整数，否则返回0
	 */
	public abstract Integer insert(Goods goods);

	/**
	 * 查询满足条件的商品信息（分页功能）
	 * 
	 * @param goods 查询条件
	 * @return 成功返回com.github.pagehelper.PageInfo的实例，失败返回null
	 */
	public abstract PageInfo<Goods> select(Goods goods, Integer PageNumber);

	/**
	 * 根据条件修改goods表中指定goods_id的商品信息
	 * 
	 * @param goods 修改的商品信息
	 * @return 成功返回大于0的整数，否则返回小于等于0的整数
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * 修改指定编号的的商品信息
	 * 
	 * @param goods 修改的商品信息
	 * @return 成功返回大于0的整数，否则返回小于等于0的整数
	 */
	public abstract Integer update(Goods goods);

	/**
	 * 查询销量前十的商品信息
	 * 
	 * @return 成功返回java.util.List类型的实例，失败返回null
	 */
	public abstract List<Goods> selectGroup();
}
