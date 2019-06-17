package com.qxmz.springcloud.service;

import org.springframework.data.domain.Page;

import com.qxmz.springcloud.entity.Users;

/**
 * ģ�Ͳ�Ľӿڣ����ڶ����û�ģ��ķ���
 * @author qxmz
 *
 */
public interface UsersService {

	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * @param userId       �û����
	 * @param userPassword �û�����
	 * @param jdictionId   Ȩ�ޱ��
	 * @return �ɹ����ص�¼�û���������Ϣ��ʧ�ܷ���null
	 */
	public abstract Users login(Integer userId,String userPassword,Integer jdictionId);
	
	/**
	 * ����µ��û���Ϣ
	 * @param user  �µ��û���Ϣ
	 * @return ��ӳɹ�����com.qxmz.springcloud.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users insert(Users users);
	
	/**
	 * ��ѯ�����������û���Ϣ
	 * @param users  ��ѯ����
	 * @param pageNumber  ��ѯҳ��
	 * @return  �ɹ�����org.springframework.data.domain.Page���͵�ʵ��
	 */
	public abstract Page<Users> select(Users users,Integer pageNumber);
	
	/**
	 * �޸�users����ָ����ŵ��û�״̬
	 * @param userId   �û����
	 * @param userStatus �û�״̬
	 * @return �޸ĳɹ��󷵻ش���0�����������򷵻�0
	 */
	public abstract Integer updateStatus(Integer userId,Integer userStatus);
	
	/**
	 * ��ѯָ����ŵ��û���Ϣ
	 * @param userId
	 * @return  �ɹ�����com.qxmz.springcloud.entity.Users��ʵ�������򷵻�null
	 */
	public abstract Users selectById(Integer userId);
	
	/**
	 * �޸�ָ����ŵ��û���Ϣ
	 * @param users
	 * @return �ɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer update(Users users);
	
	/**
	 * ���ݲ����޸�ָ������û���ͷ�����룬����
	 * @param users �޸ĵ��û���Ϣ
	 * @return �ɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer updateMessage(Users users);
}
