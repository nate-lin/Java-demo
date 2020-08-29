package com.ossjk.ossjkssm.device.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ossjk.core.base.service.impl.BaseServiceImpl;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Devicereceive;
import com.ossjk.ossjkssm.device.entity.Devicesout;
import com.ossjk.ossjkssm.device.mapper.DevicereceiveMapper;
import com.ossjk.ossjkssm.device.service.DevicereceiveService;

@Service
public class DevicereceiveServiceImpl extends BaseServiceImpl<DevicereceiveMapper, Devicereceive> implements DevicereceiveService{

	@Override
	public Page<Devicereceive> selectPage(Page page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		page.toPage(new PageInfo(baseMapper.selectAllplus()));
		return page;
	}

	@Override
	public Devicereceive selectByMaxId() {
		// TODO Auto-generated method stub
		return baseMapper.selectByMaxId();
	}

	@Override
	public int batchDelete(Integer[] ids) {
		// TODO Auto-generated method stub
		return baseMapper.batchDelete(ids);
	}
	@Override
	public List<Devicereceive> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
