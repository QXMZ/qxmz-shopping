package com.qxmz.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class1���Ӧ��ʵ����
 * 
 * @author qxmz
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class1 {
	/**
	 * ���һ���
	 */
    private Integer class1Id;

    /**
	 * ���һ����
	 */
    private String class1Name;

    /**
	 * ���
	 */
    private Integer class1Num;

    /**
	 *��ע
	 */
    private String remark;

}