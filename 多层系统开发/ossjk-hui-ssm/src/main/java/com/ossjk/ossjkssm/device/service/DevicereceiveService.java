package com.ossjk.ossjkssm.device.service;

import java.util.List;

import com.ossjk.core.base.service.BaseService;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.device.entity.Device;
import com.ossjk.ossjkssm.device.entity.Devicereceive;

public interface DevicereceiveService extends BaseService<Devicereceive>{

	
	Page<Devicereceive> selectPage(Page page);
	
	Devicereceive selectByMaxId();

	List<Devicereceive> selectAll();

	int batchDelete(Integer[] ids);
}
