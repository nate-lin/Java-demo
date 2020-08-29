package com.ossjk.ossjkssm.device.entity;

import java.math.BigDecimal;

import com.ossjk.core.base.entity.BaseEntity;

public class Devicetype extends BaseEntity {

    private String name;	//名字

    private String brand;	//品牌

    private String intlcode;	//国际编号

    private String model;	//型号

    private String remarks;		//备注

    private Short asl;	 //使用年限

    private BigDecimal anrv;	//预计净残值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getIntlcode() {
        return intlcode;
    }

    public void setIntlcode(String intlcode) {
        this.intlcode = intlcode == null ? null : intlcode.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Short getAsl() {
        return asl;
    }

    public void setAsl(Short asl) {
        this.asl = asl;
    }

    public BigDecimal getAnrv() {
        return anrv;
    }

    public void setAnrv(BigDecimal anrv) {
        this.anrv = anrv;
    }

}