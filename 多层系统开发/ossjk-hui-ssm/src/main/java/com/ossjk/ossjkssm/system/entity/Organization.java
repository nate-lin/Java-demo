package com.ossjk.ossjkssm.system.entity;

import com.ossjk.core.base.entity.BaseEntity;

public class Organization extends BaseEntity {

    private String name;	//名字

    private String remarks; 	//备注

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

}