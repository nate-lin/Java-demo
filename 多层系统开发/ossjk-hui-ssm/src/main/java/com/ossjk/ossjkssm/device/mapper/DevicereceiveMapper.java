package com.ossjk.ossjkssm.device.mapper;

import java.util.List;

import com.ossjk.core.base.mapper.BaseMapper;
import com.ossjk.ossjkssm.device.entity.Devicereceive;

public interface DevicereceiveMapper extends BaseMapper<Devicereceive>{

   List<Devicereceive> selectAll();
	
   List<Devicereceive> selectAllplus();
  
   Devicereceive selectByMaxId();

   int batchDelete(Integer[] ids);
  
  
  
}