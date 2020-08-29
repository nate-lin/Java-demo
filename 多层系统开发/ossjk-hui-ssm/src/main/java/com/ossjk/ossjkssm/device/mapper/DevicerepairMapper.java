package com.ossjk.ossjkssm.device.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.device.entity.Devicerepair;

public interface DevicerepairMapper extends BaseMapper<Devicerepair> {

	
	List<Devicerepair> selectAll();
	
	List<Devicerepair> selectAllPlus();
	
	
}