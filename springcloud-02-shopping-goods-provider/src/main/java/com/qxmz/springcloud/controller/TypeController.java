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
 * һ�������������Ŀ�����
 * @author qxmz
 *
 */
@RestController
@RequestMapping("type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	/**
	 * ��ѯ����һ�������Ϣ
	 * @return
	 */
	@RequestMapping(value="/selectAll")
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();
		
		try {
			//����service��Ӧ�ķ�����ѯ����һ��������Ϣ������ò�ѯ���
			List<Class1> list = this.typeService.selectAllClass1();
			//�����ѯ�ɹ�
			if(list != null && list.size() > 0) {
				//���ý��״̬���Ϊ0
				rv.setCode(0);
				//����map����
				Map<String,Object> map =new HashMap<>();
				//����ѯ�������map������
				map.put("class1List", list);
				//��map���ϴ���resulevalue������
				rv.setDataMap(map);
				//����resultvalue����
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	
	/**
	 * ����һ������Ų�ѯ��Ӧ���������Ϣ
	 * @param class1Id
	 * @return
	 */
	@RequestMapping(value="/selectById")
	public ResultValue selectById(@RequestParam("class1Id") Integer class1Id) {
		ResultValue rv = new ResultValue();
		
		try {
			//����service��Ӧ�ķ�����ѯ����һ��������Ϣ������ò�ѯ���
			List<Class2> list = this.typeService.selectClass2ByClass1Id(class1Id);
			//�����ѯ�ɹ�
			if(list !=null && list.size() > 0) {
				//���ý��״̬���Ϊ0
				rv.setCode(0);
				//����map����
				Map<String,Object> map = new HashMap<>();
				//����ѯ�������map������
				map.put("class2List", list);
				//��map���ϴ���resulevalue������
				rv.setDataMap(map);
				//����resultvalue����
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
}
