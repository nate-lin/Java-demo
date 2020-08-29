package com.ossjk.ossjkssm.device.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Device;
import com.ossjk.ossjkssm.device.mapper.DeviceMapper;
import com.ossjk.ossjkssm.device.service.DeviceService;

@Service
public class DeviceServiceImp extends BaseServiceImpl<DeviceMapper, Device> implements DeviceService{

	@Override
	public Page<Device> selectPage(Page page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllplus()));
		return page;
	}

	@Override
	public Device selectCode() {
		// TODO Auto-generated method stub
		return baseMapper.selectCode();
	}

	@Override
	public int batchDelete(Integer[] ids) {
		// TODO Auto-generated method stub
		return baseMapper.batchDelete(ids);
	}

	@Override
	public List<Device> selectType() {
		// TODO Auto-generated method stub
		return baseMapper.selectType();
	}

}
