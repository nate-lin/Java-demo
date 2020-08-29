package com.ossjk.ossjkssm.device.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.device.entity.Device;

public interface DeviceMapper  extends BaseMapper<Device> {
    
	List<Device> selectAll();
	
	List<Device> selectAllplus();
	
    Device selectCode();
	
	int batchDelete(Integer[] ids);
	
	List<Device> selectType();
	
	
}