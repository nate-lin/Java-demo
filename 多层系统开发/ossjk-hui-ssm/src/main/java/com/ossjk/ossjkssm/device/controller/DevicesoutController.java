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
import com.ossjk.ossjkssm.device.entity.Devicerepair;
import com.ossjk.ossjkssm.device.entity.Devicesout;
import com.ossjk.ossjkssm.device.service.DeviceService;
import com.ossjk.ossjkssm.device.service.DevicesoutService;
import com.ossjk.ossjkssm.system.service.UserService;
@Controller
@RequestMapping("/device/devicesout")

public class DevicesoutController extends BaseController{
	
	@Autowired
	private DevicesoutService devicesoutService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private UserService userService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(Page page, ModelMap map) {
		map.put("page", devicesoutService.selectPage(page));
		return "device/devicesout/list";
	}
	
	
	/**
	 * 去增加
	 */
	@RequestMapping("/toInsert")
	public String toInsert(ModelMap map) {
		map.put("devices", deviceService.selectType());
		map.put("users", userService.selectAll());
		return "device/devicesout/edit";
	}
	
	
	/**
	 * 增加
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Devicesout devicesout) {
		devicesout.setStatus((short) 1);
		devicesout.setCrtm(new Date());
		devicesout.setMdtm(new Date());
		if (devicesoutService.insertSelective(devicesout) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	
	
	/**
	 * 去审批
	 */
	@RequestMapping("/toOut")
	public String toOut(Integer id, ModelMap map) {
		map.put("devices", deviceService.selectType());
		map.put("users", userService.selectAll());
		map.put("record", devicesoutService.selectByPrimaryKey(id));
		return "device/devicesout/out";
	}
	
	
	/**
	 * 审批
	 */
	@RequestMapping("/out")
	@ResponseBody
	public Object out(Devicesout devicesout) {
		devicesout.setMdtm(new Date());
		if (devicesoutService.updateByPrimaryKeySelective(devicesout) > 0) {
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
			map.put("record", devicesoutService.selectByPrimaryKey(id));
			return "device/devicesout/edit";
		}
		/**
		 * 去更新
		 */
		@RequestMapping("/toUpdateB")
		public String toUpdateB(Integer id, ModelMap map) {
			map.put("devices", deviceService.selectType());
			map.put("users", userService.selectAll());
			map.put("record", devicesoutService.selectByPrimaryKey(id));
			return "device/devicesout/out";
		}
		
		/**
		 * 更新
		 */
		@RequestMapping("/update")
		@ResponseBody
		public Object update(Devicesout devicesout) {
			//devicesout.setStatus((short) 2);//状态改成归还状态
			devicesout.setMdtm(new Date());
			if (devicesoutService.updateByPrimaryKeySelective(devicesout) > 0) {
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
			if (devicesoutService.deleteByPrimaryKey(id) > 0) {
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
			if (devicesoutService.batchDelete(ids) > 0) {
				return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
			} else {
				return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
			}
}
		}
