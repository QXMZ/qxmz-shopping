package com.qxmz.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order_Detail��Ӧ��ʵ���࣬���ڷ�װһ�ж�����Ϣ
 * 
 * @author qxmz
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = -1335999616400441752L;

	/**
	 * ������ϸ���
	 */
	private Integer orderDetailId;

	/**
	 * �������
	 */
	private Integer orderId;

	/**
	 * ��Ʒ���
	 */
	private Integer goodsId;

	/**
	 * ��Ʒ����
	 */
	private String goodsName;

	/**
	 * �ɽ���
	 */
	private Double transactionPrice;

	/**
	 * �ɽ�����
	 */
	private Integer transactionCount;

}