package com.ossjk.ossjkssm.device.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.device.entity.Devicetype;

public interface DevicetypeMapper extends BaseMapper<Devicetype> {

  List<Devicetype> selectAll();
 
  int batchDelete(Integer[] ids);
	
}