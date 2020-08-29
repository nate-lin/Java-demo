package com.ossjk.ossjkssm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ossjk.core.base.controller.BaseController;
import com.ossjk.core.vo.AjaxReturn;
import com.ossjk.core.vo.Page;
import com.ossjk.ossjkssm.common.Constant;
import com.ossjk.ossjkssm.system.entity.User;
import com.ossjk.ossjkssm.system.service.OrganizationService;
import com.ossjk.ossjkssm.system.service.RoleService;
import com.ossjk.ossjkssm.system.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private RoleService roleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(Page page, ModelMap map) {
		map.put("page", userService.selectPage(page));
		return "system/user/list";
	}

	/**
	 * 去增加
	 */
	@RequestMapping("/toInsert")
	public String toInsert(ModelMap map) {
		map.put("organizations", organizationService.selectAll());
		map.put("roles", roleService.selectAll());
		return "system/user/edit";
	}

	/**
	 * 去更新
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap map) {
		map.put("record", userService.selectByPrimaryKey(id));
		map.put("organizations", organizationService.selectAll());
		map.put("roles", roleService.selectAll());
		return "system/user/edit";
	}

	/**
	 * 增加
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(User user) {
		if (userService.insert(user) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}

	/**
	 * 更新
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Object update(User user) {
		if (userService.updateByPrimaryKey(user) > 0) {
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

		if (userService.deleteByPrimaryKey(id) > 0) {
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
		if (userService.batchDelete(ids) > 0) {
			return new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS);
		} else {
			return new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR);
		}
	}
}
