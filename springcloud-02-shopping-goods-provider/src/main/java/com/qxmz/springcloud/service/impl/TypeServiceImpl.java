package com.qxmz.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxmz.springcloud.dao.Class1Mapper;
import com.qxmz.springcloud.dao.Class2Mapper;
import com.qxmz.springcloud.entity.Class1;
import com.qxmz.springcloud.entity.Class2;
import com.qxmz.springcloud.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private Class1Mapper class1Mapper;
	
	@Autowired
	private Class2Mapper class2Mapper;
	
	@Override
	public List<Class1> selectAllClass1() {
		return this.class1Mapper.selectAll();
	}

	@Override
	public List<Class2> selectClass2ByClass1Id(Integer class1Id) {
		return this.class2Mapper.selectByClass1Id(class1Id);
	}

}
