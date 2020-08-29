package com.ossjk.ossjkssm.system.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.ossjk.core.base.entity.BaseEntity;

public class User extends BaseEntity {

	private Integer rid;	//角色id

	private Integer ogid;	//组织机构id

	private String name;	//姓名

	private String pwd;	  //密码

	private BigDecimal sex; 	//性别 1-男、2-女

	private String birth;	//生日

	private String phone;	//手机

	private String email;	//邮件

	private String logintime;	//登录时间

	private String loginip;	  //登录ip

	private String rname;	//
	
	private String oname;	//
	
	
	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getOgid() {
		return ogid;
	}

	public void setOgid(Integer ogid) {
		this.ogid = ogid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	public BigDecimal getSex() {
		return sex;
	}

	public void setSex(BigDecimal sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth == null ? null : birth.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime == null ? null : logintime.trim();
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip == null ? null : loginip.trim();
	}

}