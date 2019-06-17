package com.qxmz.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qxmz.springcloud.entity.Class1;
import com.qxmz.springcloud.entity.Class2;
import com.qxmz.springcloud.service.TypeService;
import com.qxmz.springcloud.vo.ResultValue;

/**
 * 一级类别与二级类别的控制器
 * @author qxmz
 *
 */
@RestController
@RequestMapping("type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	/**
	 * 查询所有一级类别信息
	 * @return
	 */
	@RequestMapping(value="/selectAll")
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();
		
		try {
			//调用service相应的方法查询所有一级类别的信息，并获得查询结果
			List<Class1> list = this.typeService.selectAllClass1();
			//如果查询成功
			if(list != null && list.size() > 0) {
				//设置结果状态标记为0
				rv.setCode(0);
				//创建map集合
				Map<String,Object> map =new HashMap<>();
				//将查询结果存入map集合中
				map.put("class1List", list);
				//将map集合存入resulevalue对象中
				rv.setDataMap(map);
				//返回resultvalue对象
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	
	/**
	 * 根据一级类别编号查询相应二级类别信息
	 * @param class1Id
	 * @return
	 */
	@RequestMapping(value="/selectById")
	public ResultValue selectById(@RequestParam("class1Id") Integer class1Id) {
		ResultValue rv = new ResultValue();
		
		try {
			//调用service相应的方法查询所有一级类别的信息，并获得查询结果
			List<Class2> list = this.typeService.selectClass2ByClass1Id(class1Id);
			//如果查询成功
			if(list !=null && list.size() > 0) {
				//设置结果状态标记为0
				rv.setCode(0);
				//创建map集合
				Map<String,Object> map = new HashMap<>();
				//将查询结果存入map集合中
				map.put("class2List", list);
				//将map集合存入resulevalue对象中
				rv.setDataMap(map);
				//返回resultvalue对象
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
}
