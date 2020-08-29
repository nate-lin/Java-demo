package com.ossjk.ossjkssm.system.controller;

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
import com.ossjk.ossjkssm.system.entity.Organization;
import com.ossjk.ossjkssm.system.entity.Role;
import com.ossjk.ossjkssm.system.service.OrganizationService;

@Controller
@RequestMapping("/system/organization")
public class OrganizationController extends BaseController {

	@Autowired
	private OrganizationService organizationService;
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(Page page, ModelMap map) {
		map.put("page", organizationService.selectAll(page));
		return "system/organization/list";
	}
	
	/**
	 * 去增加
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "system/organization/edit";
	}
	
	/**
	 * 增加
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Organization organization) {
	     ///把时间加进去（系统时间）
		organization.setCrtm(new Date());//创建时间
		organization.setMdtm(new Date());//修改时间
		if (organizationService.insert(organization) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	
	/**
	 * 去更新
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap map) {
		map.put("record", organizationService.selectByPrimaryKey(id));
		return "system/organization/edit";
	}
	
	
	/**
	 * 更新
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Organization organization) {
		organization.setMdtm(new Date());//修改时间
		if (organizationService.updateByPrimaryKey(organization) > 0) {
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
		if (organizationService.deleteByPrimaryKey(id) > 0) {
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
		if (organizationService.batchDelete(ids) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
	
}
