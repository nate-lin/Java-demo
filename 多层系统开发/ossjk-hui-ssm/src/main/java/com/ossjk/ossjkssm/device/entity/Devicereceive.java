package com.ossjk.ossjkssm.device.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ossjk.core.base.entity.BaseEntity;

public class Devicereceive extends BaseEntity{

    private Integer did;	//设备id

    private String code;	//单据号

    private int recipients;		//领用人
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date receivedate;	//领取时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date returndate;	//归还日期

    private Short status;	//状态 1-领用、2-归还

    private String rcremarks;	//领用备注

    private String rtremarks;	//归还备注
    
    private String rname;
    private String dcode;
    private String dname;
    private String brand;
    private String model;
    
    public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getDcode() {
		return dcode;
	}

	public void setDcode(String dcode) {
		this.dcode = dcode;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public int getRecipients() {
		return recipients;
	}

	public void setRecipients(int recipients) {
		this.recipients = recipients;
	}

	public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRcremarks() {
        return rcremarks;
    }

    public void setRcremarks(String rcremarks) {
        this.rcremarks = rcremarks == null ? null : rcremarks.trim();
    }

    public String getRtremarks() {
        return rtremarks;
    }

    public void setRtremarks(String rtremarks) {
        this.rtremarks = rtremarks == null ? null : rtremarks.trim();
    }
}