package com.ossjk.ossjkssm.device.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Device;
import com.ossjk.ossjkssm.device.entity.Devicerepair;
import com.ossjk.ossjkssm.device.mapper.DevicerepairMapper;
import com.ossjk.ossjkssm.device.service.DevicerepairService;

@Service
public class DevicerepairServiceImpl extends BaseServiceImpl<DevicerepairMapper, Devicerepair> implements DevicerepairService{

	@Override
	public Page<Devicerepair> selectPage(Page page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllPlus()));
		return page;
	}

	@Override
	public int batchDelete(Integer[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Devicerepair selectByMaxId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Devicerepair> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
