package com.ossjk.ossjkssm.device.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ossjk.core.base.controller.BaseController;
import com.ossjk.core.vo.AjaxReturn;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.common.Constant;
import com.ossjk.ossjkssm.common.CreadNum;
import com.ossjk.ossjkssm.device.entity.Devicereceive;
import com.ossjk.ossjkssm.device.entity.Devicerepair;
import com.ossjk.ossjkssm.device.service.DeviceService;
import com.ossjk.ossjkssm.device.service.DevicerepairService;
import com.ossjk.ossjkssm.system.service.UserService;

@Controller
@RequestMapping("/device/devicerepair")
public class DevicerepairController extends BaseController{

	@Autowired
	private DevicerepairService devicerepairService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private UserService userService;
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(Page page, ModelMap map) {
		map.put("page", devicerepairService.selectPage(page));
		return "device/devicerepair/list";
	}
	/**
	 * 去增加
	 */
	@RequestMapping("/toInsert")
	public String toInsert(ModelMap map) {
		map.put("devices", deviceService.selectType());
		map.put("users", userService.selectAll());
		return "device/devicerepair/edit";
	}
	
	
	/**
	 * 增加
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Devicerepair devicerepair) {
		//状态是报修状态
		devicerepair.setStatus((short) 1);
		devicerepair.setCrtm(new Date());
		devicerepair.setMdtm(new Date());
		if (devicerepairService.insertSelective(devicerepair) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	/**
	 * 去报修
	 */
	@RequestMapping("/toRepair")
	public String toRepair(Integer id, ModelMap map) {
		map.put("devices", deviceService.selectType());
		map.put("users", userService.selectAll());
		map.put("record", devicerepairService.selectByPrimaryKey(id));
		return "device/devicerepair/back";
	}
	
	
	/**
	 * 报修
	 */
	@RequestMapping("/repair")
	@ResponseBody
	public Object repair(Devicerepair devicerepair) {
		//System.out.println("=================="+devicereceive.getRecipients());
		devicerepair.setStatus((short) 2);//状态改成归还状态
		devicerepair.setMdtm(new Date());
		if (devicerepairService.updateByPrimaryKeySelective(devicerepair) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	

		/**
		 * 去更新
		 */
		@RequestMapping("/toUpdateA")
		public String toUpdateA(Integer id, ModelMap map) {
			map.put("devices", deviceService.selectType());
			map.put("users", userService.selectAll());
			map.put("record", devicerepairService.selectByPrimaryKey(id));
			return "device/devicerepair/edit";
		}
		/**
		 * 去更新
		 */
		@RequestMapping("/toUpdateB")
		public String toUpdateB(Integer id, ModelMap map) {
			map.put("devices", deviceService.selectType());
			map.put("users", userService.selectAll());
			map.put("record", devicerepairService.selectByPrimaryKey(id));
			return "device/devicerepair/back";
		}
		
		/**
		 * 更新
		 */
		@RequestMapping("/update")
		@ResponseBody
		public Object update(Devicerepair devicerepair) {
			//devicerepair.setStatus((short) 2);//状态改成归还状态
			devicerepair.setMdtm(new Date());
			if (devicerepairService.updateByPrimaryKeySelective(devicerepair) > 0) {
				return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
			} else {
				return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
			}
		
		}
		/**
		 * 删除
		 */
		@RequestMapping("/delete")
		@ResponseBody
		public Object delete(Integer id) {
			if (devicerepairService.deleteByPrimaryKey(id) > 0) {
				return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
			} else {
				return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
			}
		}
		/**
		 * 批量删除
		 */
		@RequestMapping("/batchDelete")
		@ResponseBody
		public Object batchDelete(Integer[] ids) {
			if (devicerepairService.batchDelete(ids) > 0) {
				return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
			} else {
				return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
			}
		}
}
