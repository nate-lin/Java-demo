package com.ossjk.ossjkssm.system.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.system.entity.Role;
import com.ossjk.ossjkssm.system.mapper.RoleMapper;
import com.ossjk.ossjkssm.system.service.RoleService;

@Service
public class RoleServiceImp extends BaseServiceImpl<RoleMapper, Role> implements RoleService {

	
	@Override
	public Page<Role> selectAll(Page page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAll()));
		return page;
	}

	@Override
	public int batchDelete(Integer[] ids) {
		// TODO Auto-generated method stub
		return baseMapper.batchDelete(ids);
	}

	@Override
	public List<Role> selectAll() {
		// TODO Auto-generated method stub
		return baseMapper.selectAll();
	}

	
	
	
	
	
	
}
