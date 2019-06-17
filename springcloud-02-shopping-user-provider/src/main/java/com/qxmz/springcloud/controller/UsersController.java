package com.qxmz.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qxmz.springcloud.common.PageUtils;
import com.qxmz.springcloud.entity.Users;
import com.qxmz.springcloud.service.UsersService;
import com.qxmz.springcloud.vo.ResultValue;

/**
 * ���Ʋ㣬������ͼ������ݣ�������ģ�Ͳ����Ӧ�����������ݷ��ص���ͼ��ֻ�ܹ�
 * @author qxmz
 *
 */
@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	/**
	 * �û���Ϣ
	 * @param userId  �û����
	 * @param userPassword  �û�����
	 * @param jdictionId  Ȩ�ޱ��
	 * @return
	 */
	@RequestMapping(value="/login")
	public ResultValue login(@RequestParam("userId") Integer userId,@RequestParam("userPassword") String userPassword,@RequestParam("jdictionId") Integer jdictionId ) {
		ResultValue rv = new ResultValue();
		
		try {
			Users login = this.usersService.login(userId, userPassword, jdictionId);
			if(login != null) {
				rv.setCode(0);
				
				Map<String,Object> map = new HashMap<>();
				map.put("loginUser",login);
				rv.setDataMap(map);
				
				return rv;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("��¼��Ϣ����ȷ�����������룡����");
		return rv;
	}
	
	@RequestMapping(value="/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue(); 
		try {
			Users insert = this.usersService.insert(users);
			if(insert != null) {
				rv.setCode(0);
				rv.setMessage("�û�¼��ɹ�");
				return rv;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û�¼��ʧ��");
		return rv;
	}
	
	/**
	 * ��ѯ�����������û���Ϣ
	 * @return
	 */
	@RequestMapping(value="/select")
	public ResultValue select(Users users,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		
		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			//��÷�ҳ������
			List<Users> list = page.getContent();
			//�ж��Ƿ��ѯ������
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				
				Map<String,Object> map = new HashMap<>();
				//����ҳ���������ӵ�map��
				map.put("userList", list);
				
				PageUtils pageUtils = new PageUtils((int)page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				//����ҳ��Ϣ���ӵ�map��
				map.put("pageUtils", pageUtils);
				//��map���ӵ�ResultValue������
				rv.setDataMap(map);
				
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value="/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId,@RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer status = this.usersService.updateStatus(userId, userStatus);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("�û�״̬�޸ĳɹ�������");
				return rv;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("�û�״̬�޸�ʧ�ܣ�����");
		return rv;
	}
	
	@RequestMapping(value="/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();
		try {
			//����service�еķ���������ò�ѯ�Ľ��
			Users users = this.usersService.selectById(userId);
			//����ɹ�
				if(users != null) {
					//���ý����״̬Ϊ0
					rv.setCode(0);
					//����map���ϱ����ѯ���
					Map<String,Object> map = new HashMap<>();
					//����ѯ������浽map������
					map.put("users",users);
					//��map�������ӵ�Resultvalue������
					rv.setDataMap(map);
					//����Resultvalue����
					return rv;
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("����û���Ϣʧ��");
		return rv;
	}
	
	@RequestMapping(value="/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			//����service�еķ�����������޸��Ƿ�ɹ�
			Integer update = this.usersService.update(users);
			//����ɹ�
			if(update > 0) {
				//���ý��״̬Ϊ0
				rv.setCode(0);
				rv.setMessage("�޸��û���Ϣ�ɹ�");
				//����ResultValue����
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("�޸��û���Ϣʧ��");
		return rv;
	}
	
	@RequestMapping(value="/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			//����service�еķ�����������޸��Ƿ�ɹ�
			Integer updates = this.usersService.updateMessage(users);
			//����ɹ�
			if(updates > 0) {
				//���ý��״̬Ϊ0
				rv.setCode(0);
				rv.setMessage("�޸��û���Ϣ�ɹ�");
				//����ResultValue����
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("�޸��û���Ϣʧ��");
		return rv;
	}
}