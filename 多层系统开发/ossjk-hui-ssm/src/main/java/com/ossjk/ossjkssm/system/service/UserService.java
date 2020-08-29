package com.ossjk.ossjkssm.system.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.User;

public interface UserService extends BaseService<User> {

	User selectByName(String name);

	List<User> selectAll();

	Page<User> selectPage(Page page);

	int batchDelete(Integer[] ids);

}
