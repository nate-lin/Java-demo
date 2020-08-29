package com.ossjk.ossjkssm.device.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Device;

public interface DeviceService extends BaseService<Device>{

	Page<Device> selectPage(Page page);
	
	Device selectCode();
	
	int batchDelete(Integer[] ids);
	
	List<Device> selectType();
	
	
}
