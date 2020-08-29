package com.ossjk.ossjkssm.device.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Devicesout;
import com.ossjk.ossjkssm.device.mapper.DevicesoutMapper;
import com.ossjk.ossjkssm.device.service.DevicesoutService;

@Service
public class DevicesoutServiceImpl extends BaseServiceImpl<DevicesoutMapper, Devicesout> implements DevicesoutService{

	@Override
	public Page<Devicesout> selectPage(Page page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllPlus()));
		return page;
	}
	@Override
	public int batchDelete(Integer[] ids) {
		// TODO Auto-generated method stub
		return baseMapper.batchDelete(ids);
	}
	@Override
	public List<Devicesout> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
