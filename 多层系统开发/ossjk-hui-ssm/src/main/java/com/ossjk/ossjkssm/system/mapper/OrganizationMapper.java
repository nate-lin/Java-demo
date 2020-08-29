package com.ossjk.ossjkssm.system.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.Organization;

public interface OrganizationMapper extends BaseMapper<Organization> {
 
	List<Organization> selectAll();
	
	int batchDelete(Integer[] ids);
}