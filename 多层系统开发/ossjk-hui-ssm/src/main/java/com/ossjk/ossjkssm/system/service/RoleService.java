package com.ossjk.ossjkssm.system.service;


import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.Role;

public interface RoleService extends BaseService<Role>{

	Page<Role> selectAll(Page page);
	
	int batchDelete(Integer[] ids);
	
	List<Role> selectAll();
	
}
