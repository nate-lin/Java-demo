package com.ossjk.ossjkssm.system.mapper;

import java.io.Serializable;
import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.system.entity.User;

public interface UserMapper extends BaseMapper<User> {

	User selectByName(String name);

	List<User> selectAll();

	List<User> selectAllpuls();
	
	
	int batchDelete(Integer[] ids);
	
	
}