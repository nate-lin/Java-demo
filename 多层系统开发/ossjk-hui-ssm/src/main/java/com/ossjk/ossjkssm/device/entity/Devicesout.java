package com.ossjk.ossjkssm.device.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ossjk.core.base.entity.BaseEntity;

public class Devicesout extends BaseEntity{
	
	private Integer did;	//设备id
	
	private Integer outter;	//报废人
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date outdate;	//报废日期
	
	private String remarks;	//备注
	
	private Short status;	//状态 1-申请、2-准许、3-拒绝
	
	private Integer approver;	//审批人
	
	private String approvalremarks;	//审批意见
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date approvaldate;	//审批日期
	
	private String oname;
	private String aname;
	private String code;
	private String tname;
	private String brand;
	private String model;
	
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getOutter() {
		return outter;
	}
	public void setOutter(Integer outter) {
		this.outter = outter;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks==null ? null:remarks.trim();
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Integer getApprover() {
		return approver;
	}
	public void setApprover(Integer approver) {
		this.approver = approver;
	}
	public String getApprovalremarks() {
		return approvalremarks;
	}
	public void setApprovalremarks(String approvalremarks) {
		this.approvalremarks = approvalremarks==null ? null:approvalremarks.trim();;
	}
	public Date getApprovaldate() {
		return approvaldate;
	}
	public void setApprovaldate(Date approvaldate) {
		this.approvaldate = approvaldate;
	}
	
}
