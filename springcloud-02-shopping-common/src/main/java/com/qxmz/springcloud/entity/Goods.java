package com.qxmz.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * goods���Ӧ��ʵ����
 * 
 * @author qxmz
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	/**
	 * ��Ʒ���
	 */
    private Integer goodsId;

    /**
	 * ��Ʒ����
	 */
    private String goodsName;

    /**
	 * ��Ʒ�۸�
	 */
    private Double goodsPrices;

    /**
	 * ��Ʒ�ۿۼ�
	 */
    private Double goodsDiscount;

    /**
	 * ��Ʒ״̬����Ʒ״̬��0Ϊ�¼ܣ�1Ϊȱ����2Ϊ���ۣ�
	 */
    private Integer goodsStatus;

    /**
	 * ��Ʒ����
	 */
    private Integer goodsCount;

    /**
	 * �Ƿ���Ʒ��0����Ʒ��1������Ʒ
	 */
    private Integer goodsIsNew;

    /**
	 * �Ƿ�������0������1��������
	 */
    private Integer goodsIsHot;

    /**
	 * ��Ʒ����0Ϊ1�ǣ�1Ϊ2�ǣ�2Ϊ3�ǣ�3��4�ǣ�4��5�ǣ�
	 */
    private Integer goodsLevel;

    /**
	 * ��Ʒ���
	 */
    private String goodsBrief;

    /**
	 * ��Ʒ����
	 */
    private String goodsDetails;

    /**
	 * ��ƷͼƬ
	 */
    private String goodsPhoto;

    /**
	 * �������
	 */
    private Integer class2Id;
    
    /**
	 * ��ѯ��������Ʒ�۸�����
	 */
    private Double goodsPriceMin;
    
    /**
	 * ��ѯ��������Ʒ�۸�����
	 */
    private Double goodsPriceMax;
    
    /**
	 * ��ѯ�������������
	 */
    private Integer class1Id;
    
    /**
     * ��Ʒ���������ڱ���ͳ�Ʒ���Ľ��
     */
    private Integer goodsSum;

}