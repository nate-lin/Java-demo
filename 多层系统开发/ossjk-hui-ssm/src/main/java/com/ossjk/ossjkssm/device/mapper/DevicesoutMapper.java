package com.ossjk.ossjkssm.device.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.device.entity.Devicesout;

public interface DevicesoutMapper extends BaseMapper<Devicesout>{
	
	List<Devicesout> selectAll();
	
	List<Devicesout> selectAllPlus();
	
	int batchDelete(Integer[] ids);
	
}
