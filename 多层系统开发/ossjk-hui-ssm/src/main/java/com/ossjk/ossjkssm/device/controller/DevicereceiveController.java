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
import com.ossjk.ossjkssm.device.entity.Devicetype;
import com.ossjk.ossjkssm.device.service.DeviceService;
import com.ossjk.ossjkssm.device.service.DevicereceiveService;
import com.ossjk.ossjkssm.system.service.UserService;
@Controller
@RequestMapping("/device/devicereceive")
public class DevicereceiveController extends BaseController{

	@Autowired
	private DevicereceiveService devicereceiveService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private UserService userService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(Page page, ModelMap map) {
		map.put("page", devicereceiveService.selectPage(page));
		return "device/devicereceive/list";
	}
	
	/**
	 * 去增加
	 */
	@RequestMapping("/toInsert")
	public String toInsert(ModelMap map) {
		map.put("devices", deviceService.selectType());
		map.put("users", userService.selectAll());
		return "device/devicereceive/edit";
	}
	
	
	/**
	 * 增加
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Devicereceive devicereceive) {
		Devicereceive dev = devicereceiveService.selectByMaxId();
		devicereceive.setCode(CreadNum.creadDJS(dev.getCode()));
		//状态是领用状态
		devicereceive.setStatus((short) 1);
		devicereceive.setCrtm(new Date());
		devicereceive.setMdtm(new Date());
		if (devicereceiveService.insert(devicereceive) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	
	
	/**
	 * 去归还
	 */
	@RequestMapping("/toBack")
	public String toBack(Integer id, ModelMap map) {
		map.put("devices", deviceService.selectType());
		map.put("users", userService.selectAll());
		map.put("record", devicereceiveService.selectByPrimaryKey(id));
		return "device/devicereceive/back";
	}
	
	
	/**
	 * 归还
	 */
	@RequestMapping("/back")
	@ResponseBody
	public Object back(Devicereceive devicereceive) {
		//System.out.println("=================="+devicereceive.getRecipients());
		devicereceive.setStatus((short) 2);//状态改成归还状态
		devicereceive.setMdtm(new Date());
		if (devicereceiveService.updateByPrimaryKeySelective(devicereceive) > 0) {
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
		map.put("record", devicereceiveService.selectByPrimaryKey(id));
		return "device/devicereceive/edit";
	}
	
	/**
	 * 去更新
	 */
	@RequestMapping("/toUpdateB")
	public String toUpdateB(Integer id, ModelMap map) {
		map.put("devices", deviceService.selectType());
		map.put("users", userService.selectAll());
		map.put("record", devicereceiveService.selectByPrimaryKey(id));
		return "device/devicereceive/back";
	}
	
	/**
	 * 更新
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Devicereceive devicereceive) {
		if (devicereceiveService.updateByPrimaryKeySelective(devicereceive) > 0) {
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
		if (devicereceiveService.deleteByPrimaryKey(id) > 0) {
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
		if (devicereceiveService.batchDelete(ids) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
}
	
}
