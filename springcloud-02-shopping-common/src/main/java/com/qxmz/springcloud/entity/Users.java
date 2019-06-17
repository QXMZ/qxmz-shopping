package com.qxmz.springcloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * users���Ӧ��ʵ����:���ڷ�װusers����һ���û���Ϣ
 * @author qxmz
 *
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements java.io.Serializable{

	private static final long serialVersionUID = 6799652195657111136L;
	
	/**
	 * �û����
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	/**
	 * �û�����
	 */
	@Column(name = "user_name")
	private String userName;
	
	/**
	 * ���֤��
	 */
	@Column(name = "user_number")
	private String userNumber;
	
	/**
	 * �û�����
	 */
	@Column(name = "user_password")
	private String userPassword;
	
	/**
	 * �û��Ա�0Ϊ�У�1ΪŮ��
	 */
	@Column(name = "user_sex")
	private Integer userSex;
	
	/**
	 * ��ϵ�绰
	 */
	@Column(name = "user_phone")
	private String userPhone;
	
	/**
	 * �ջ���ַ
	 */
	@Column(name = "user_site")
	private String userSite;
	
	/**
	 * ��������
	 */
	@Column(name = "user_birthday")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date userBirthday;
	
	/**
	 * ��������
	 */
	@Column(name = "user_email")
	private String userEmail;
	
	/**
	 *ͷ��
	 */
	@Column(name = "user_hphoto")
	private String userHphoto;
	
	/**
	 *Ȩ�ޱ�ţ�1Ϊ��������Ա��2Ϊ��ͨ����Ա��3Ϊ��ͨ�û���4ΪVIP�û���
	 */
	@Column(name = "jdiction_id")
	private Integer jdictionId;
	
	/**
	 * �û�״̬��0Ϊ���ã�1Ϊ���ã�
	 */
	@Column(name = "user_status")
	private Integer userStatus;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSite() {
		return userSite;
	}

	public void setUserSite(String userSite) {
		this.userSite = userSite;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserHphoto() {
		return userHphoto;
	}

	public void setUserHphoto(String userHphoto) {
		this.userHphoto = userHphoto;
	}

	public Integer getJdictionId() {
		return jdictionId;
	}

	public void setJdictionId(Integer jdictionId) {
		this.jdictionId = jdictionId;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
	

}
