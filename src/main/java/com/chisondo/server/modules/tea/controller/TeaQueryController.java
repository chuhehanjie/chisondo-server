package com.chisondo.server.modules.tea.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.chisondo.server.modules.tea.service.TeamanUserService;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;




/**
 * 茶类信息查询 controller
 * @author ding.zhong
 * @email 258321511@qq.com
 * @since Mar 12.19
 */
@RestController
@RequestMapping("/api/rest/chapu")
public class TeaQueryController {
	@Autowired
	private TeamanUserService teamanUserService;
	
	/**
	 * 查询所有茶类信息
	 */
	@PostMapping("/getsorts")
	public CommonResp queryAllTeaSort(@RequestBody CommonReq req){

	    return new CommonResp();
	}

}
