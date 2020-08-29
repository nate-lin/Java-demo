package com.ossjk.ossjkssm.device.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Device;
import com.ossjk.ossjkssm.device.entity.Devicereceive;
import com.ossjk.ossjkssm.device.entity.Devicerepair;

public interface DevicerepairService extends BaseService<Devicerepair>{

	Page<Devicerepair> selectPage(Page page);

	int batchDelete(Integer[] ids);

	Devicerepair selectByMaxId();

	List<Devicerepair> selectAll();
	
	
	

	
	
	
	
}
