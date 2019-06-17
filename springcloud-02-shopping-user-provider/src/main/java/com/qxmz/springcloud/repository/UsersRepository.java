package com.qxmz.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qxmz.springcloud.entity.Users;

/**
 * �־û��㣬�����users����в����ķ���
 * 
 * @author qxmz
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users> {

	/**
	 * �ж��û���½�Ƿ�ɹ�
	 * 
	 * @param userId
	 * @param userPassword
	 * @param jdictionId
	 * @return �ɹ����ص�¼�û���������Ϣ��ʧ�ܷ���null
	 */
	@Query("select new com.qxmz.springcloud.entity.Users(u.userId,u.userName,u.userNumber,u.userPassword,u.userSex,u.userPhone,u.userSite,u.userBirthday,u.userEmail,u.userHphoto,u.jdictionId,u.userStatus)"
			+ " from com.qxmz.springcloud.entity.Users u where u.userId=:userId and u.userPassword=:userPassword and u.jdictionId=:jdictionId")
	public abstract Users login(@Param("userId") Integer userId, @Param("userPassword") String userPassword,
			@Param("jdictionId") Integer jdictionId);
	
	/**
	 * �޸�users����ָ����ŵ��û�״̬
	 * @param userId �û����
	 * @param userStatus  �û�״̬
	 * @return �޸ĳɹ��󷵻ش���0�����������򷵻�0
	 */
	@Modifying
	@Query("update Users set userStatus=:userStatus where userId=:userId")
	public abstract Integer updateStatus(@Param("userId") Integer userId,@Param("userStatus") Integer userStatus);
	
	/**
	 * �޸�users����ָ��user_id���û���Ϣ
	 * @param users  �޸ĵ��û���Ϣ
	 * @return �޸ĳɹ��󷵻ش���0�����������򷵻�С�ڵ���0������
	 */
	@Modifying
	@Query("update Users u set u.userNumber=:#{#users.userNumber},u.userSex=:#{#users.userSex},u.userPhone=:#{#users.userPhone},u.userBirthday=:#{#users.userBirthday}," 
			+ "u.userEmail=:#{#users.userEmail},u.userSite=:#{#users.userSite} where u.userId=:#{#users.userId}")
	public abstract Integer update(@Param("users") Users users);
	
	/**
	 * �޸�users����ָ��user_id���û�ͷ��
	 * @param users  �޸ĵ��û���Ϣ
	 * @return �޸ĳɹ��󷵻ش���0�����������򷵻�С�ڵ���0������
	 */
	@Modifying
	@Query("update Users u set u.userHphoto=:#{#users.userHphoto} where u.userId=:#{#users.userId}")
	public abstract Integer updateImage(@Param("users") Users users);
	
	/**
	 * �޸�users����ָ��user_id���û�����
	 * @param users  �޸ĵ��û���Ϣ
	 * @return �޸ĳɹ��󷵻ش���0�����������򷵻�С�ڵ���0������
	 */
	@Modifying
	@Query("update Users u set u.userPassword=:#{#users.userPassword} where u.userId=:#{#users.userId}")
	public abstract Integer updatePwd(@Param("users") Users users);
	
	/**
	 * �޸�users����ָ��user_id���û��ǳ�
	 * @param users  �޸ĵ��û���Ϣ
	 * @return �޸ĳɹ��󷵻ش���0�����������򷵻�С�ڵ���0������
	 */
	@Modifying
	@Query("update Users u set u.userName=:#{#users.userName} where u.userId=:#{#users.userId}")
	public abstract Integer updateName(@Param("users") Users users);
	
}
