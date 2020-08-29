package com.ossjk.ossjkssm.device.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ossjk.core.base.entity.BaseEntity;

public class Devicerepair extends BaseEntity{

    private Integer did;	//设备id

    private Integer damager;	//报修人
   
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date damagedate;	//报修时间

    private String damageremarks;	//报修备注
   
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date repairdate;	//维修时间

    private Integer repairer;	//维修人

    private String repairremarks;	//维修备注

    private Short status;	//状态 1-报修、2-维修

    private String dname;
    private String rname;
    private String code;
    private String tname;
    private String brand;
    private String model;
    
    public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
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

    public Integer getDamager() {
        return damager;
    }

    public void setDamager(Integer damager) {
        this.damager = damager;
    }

    public Date getDamagedate() {
        return damagedate;
    }

    public void setDamagedate(Date damagedate) {
        this.damagedate = damagedate;
    }

    public String getDamageremarks() {
        return damageremarks;
    }

    public void setDamageremarks(String damageremarks) {
        this.damageremarks = damageremarks == null ? null : damageremarks.trim();
    }

    public Date getRepairdate() {
        return repairdate;
    }

    public void setRepairdate(Date repairdate) {
        this.repairdate = repairdate;
    }

    public Integer getRepairer() {
        return repairer;
    }

    public void setRepairer(Integer repairer) {
        this.repairer = repairer;
    }

    public String getRepairremarks() {
        return repairremarks;
    }

    public void setRepairremarks(String repairremarks) {
        this.repairremarks = repairremarks == null ? null : repairremarks.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}