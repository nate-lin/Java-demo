package com.ossjk.ossjkssm.device.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Devicetype;
import com.ossjk.ossjkssm.device.mapper.DevicetypeMapper;
import com.ossjk.ossjkssm.device.service.DevicetypeService;

@Service
public class DevicetypeServiceImpl extends BaseServiceImpl<DevicetypeMapper, Devicetype> implements DevicetypeService{

	@Override
	public List<Devicetype> selectAll() {
		// TODO Auto-generated method stub
		return baseMapper.selectAll();
	}

	@Override
	public Page<Devicetype> selectPage(Page page) {
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

}
