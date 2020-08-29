package com.ossjk.ossjkssm.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.User;
import com.ossjk.ossjkssm.system.mapper.UserMapper;
import com.ossjk.ossjkssm.system.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

	@Override
	public User selectByName(String name) {
		return baseMapper.selectByName(name);
	}

	@Override
	public List<User> selectAll() {
		return baseMapper.selectAll();
	}

	@Override
	public Page<User> selectPage(Page page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllpuls()));
		return page;
	}

	@Override
	public int batchDelete(Integer[] ids) {
		return baseMapper.batchDelete(ids);
	}

}
