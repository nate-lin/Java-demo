package com.ossjk.ossjkssm.device.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Devicesout;
import com.ossjk.ossjkssm.device.entity.Devicetype;

public interface DevicesoutService extends BaseService<Devicesout>{
	 
	List<Devicesout> selectAll();
	Page<Devicesout> selectPage(Page page);	
	int batchDelete(Integer[] ids);
}
