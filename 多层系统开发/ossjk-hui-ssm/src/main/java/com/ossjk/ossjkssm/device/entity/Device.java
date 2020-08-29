package com.ossjk.ossjkssm.device.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ossjk.core.base.entity.BaseEntity;

public class Device extends BaseEntity {
   
    private Integer ogid;	//组织机构id

    private Integer dtid;	//设备类型id

    private String code;	//设备流水号

    private BigDecimal residual;	//净残值

    private BigDecimal original;	//原值

    private Short status;	//状态 1-入库、2-出库中、3-出库、4-领用、5-报修
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date proddate;	//生产日期

    private Integer creator;	//登记人
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;	//登记时间

    private Integer buyer;	//购买人
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bugdate;	//购买日期

    private String sno;		//序列号

    private String  oname;	//
    private String  dname;	//
    private String  brand;	//
    private String  cname;	//
    private String  bname;	//
    private String  model;	//
    
    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getOgid() {
        return ogid;
    }

    public void setOgid(Integer ogid) {
        this.ogid = ogid;
    }

    public Integer getDtid() {
        return dtid;
    }

    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getResidual() {
        return residual;
    }

    public void setResidual(BigDecimal residual) {
        this.residual = residual;
    }

    public BigDecimal getOriginal() {
        return original;
    }

    public void setOriginal(BigDecimal original) {
        this.original = original;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getProddate() {
        return proddate;
    }

    public void setProddate(Date proddate) {
        this.proddate = proddate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public Date getBugdate() {
        return bugdate;
    }

    public void setBugdate(Date bugdate) {
        this.bugdate = bugdate;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }
}