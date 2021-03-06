package com.show.admin.scetc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.pojo.Bootstrap;
import com.show.admin.scetc.service.VideoService;
import com.show.admin.scetc.utils.XyfJsonResult;

@Controller
@RequestMapping("")
public class IndexController extends BasicController {


	/**
	 * 返回主頁
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {

		// 从request中获取用户的基本信息
		ModelAndView modelAndView = new ModelAndView("thymeleaf/index");
		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
		if (adminUser == null) {
			return new ModelAndView("thymeleaf/login");
		}
		//取出各种数据并渲染到首页上
		//访问量
		//视频
		//用户
		//活跃用户(一个月之内发布过短视频的用户)
		
		
		// 将数据渲染到页面上
		modelAndView.addObject("adminUser", adminUser);
		return modelAndView;
	}

	@RequestMapping("/")
	public ModelAndView show(HttpServletRequest request) {

		// 从request中获取用户的基本信息
		ModelAndView modelAndView = new ModelAndView("thymeleaf/index");
		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
		if (adminUser == null) {
			return new ModelAndView("thymeleaf/login");

		}
		// 将数据渲染到页面上
		modelAndView.addObject("adminUser", adminUser);
		return modelAndView;
	}

	/**
	 * 主页初始化代码
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public XyfJsonResult init() {

		return XyfJsonResult.ok();
	}

	// 500 错误页面
	@RequestMapping("/500")
	public String errorPage() {
		return "thymeleaf/500";
	}

	// 404 页面
	@RequestMapping("/404")
	public String notFoundPage() {
		return "thymeleaf/404";
	}

}
