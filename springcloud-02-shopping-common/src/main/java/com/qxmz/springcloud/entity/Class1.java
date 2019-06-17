package com.qxmz.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class1表对应的实体类
 * 
 * @author qxmz
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class1 {
	/**
	 * 类别一编号
	 */
    private Integer class1Id;

    /**
	 * 类别一名称
	 */
    private String class1Name;

    /**
	 * 序号
	 */
    private Integer class1Num;

    /**
	 *备注
	 */
    private String remark;

}