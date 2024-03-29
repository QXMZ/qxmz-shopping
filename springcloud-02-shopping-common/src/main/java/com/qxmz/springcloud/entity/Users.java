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
 * users表对应的实体类:用于封装users表中一行用户信息
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
	 * 用户编号
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	/**
	 * 用户姓名
	 */
	@Column(name = "user_name")
	private String userName;
	
	/**
	 * 身份证号
	 */
	@Column(name = "user_number")
	private String userNumber;
	
	/**
	 * 用户密码
	 */
	@Column(name = "user_password")
	private String userPassword;
	
	/**
	 * 用户性别（0为男，1为女）
	 */
	@Column(name = "user_sex")
	private Integer userSex;
	
	/**
	 * 联系电话
	 */
	@Column(name = "user_phone")
	private String userPhone;
	
	/**
	 * 收货地址
	 */
	@Column(name = "user_site")
	private String userSite;
	
	/**
	 * 出生日期
	 */
	@Column(name = "user_birthday")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date userBirthday;
	
	/**
	 * 电子邮箱
	 */
	@Column(name = "user_email")
	private String userEmail;
	
	/**
	 *头像
	 */
	@Column(name = "user_hphoto")
	private String userHphoto;
	
	/**
	 *权限编号（1为超级管理员，2为普通管理员，3为普通用户，4为VIP用户）
	 */
	@Column(name = "jdiction_id")
	private Integer jdictionId;
	
	/**
	 * 用户状态（0为可用，1为禁用）
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
