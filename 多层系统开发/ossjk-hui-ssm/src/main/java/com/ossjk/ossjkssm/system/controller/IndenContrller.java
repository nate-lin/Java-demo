package com.ossjk.ossjkssm.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ossjk.core.base.controller.BaseController;
import com.ossjk.core.util.CommonUtil;
import com.ossjk.ossjkssm.common.Constant;
import com.ossjk.ossjkssm.system.entity.User;
import com.ossjk.ossjkssm.system.service.UserService;

@Controller
@RequestMapping("/system")
public class IndenContrller extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 去主页
	 * 
	 * @return
	 */
	@RequestMapping("/toIndex")
	public String toIndex() {
		return "index";
	}

	/**
	 * 去桌面
	 * 
	 * @return
	 */
	@RequestMapping("/toDesktop")
	public String toDesktop() {
		return "desktop";
	}

	/**
	 * 去登录
	 * 
	 * 
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		System.out.println("12313");
		return "login";
	}

	/**
	 * 登出
	 * 
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Constant.SESSION_USER_KEY);
		return "redirect:/system/toLogin.do";
	}

	/**
	 * 登出
	 * 
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/login")
	public String login(String name, String pwd, ModelMap map, HttpSession session) {
		User user = userService.selectByName(name);
		if (!CommonUtil.isBlank(user)) {
			if (CommonUtil.isEquals(user.getPwd(), pwd)) {
				session.setAttribute(Constant.SESSION_USER_KEY, user);
				return "redirect:/system/toIndex.do";
			} else {
				map.put("msg", "密码不对");
			}
		} else {
			map.put("msg", "用户不存在");
		}
		return "login";
	}
	
	@RequestMapping("/toError")
	public String toError() {
		return "500";
	}
}
