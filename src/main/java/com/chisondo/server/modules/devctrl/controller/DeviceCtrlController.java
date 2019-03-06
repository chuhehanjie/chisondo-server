package com.chisondo.server.modules.devctrl.controller;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.core.AbstractController;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.devctrl.entity.StartTeaEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备控制
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date 2019年3月7日
 */
@RestController
@RequestMapping("/rest/startWorking")
public class DeviceCtrlController extends AbstractController {

	/**
	 * 启动或预约泡茶
	 * 设置参数并启动泡茶，或提前预约在指定的时间开始沏茶，按茶类沏茶或自己设置参数沏茶，非茶谱沏茶
	 */
	@RequestMapping("/api/rest/startWorking")
	public CommonResp list(@RequestBody CommonReq req){
		StartTeaEntity startTeaEntity = JSONObject.parseObject(req.getBizBody(), StartTeaEntity.class);
		// 请求
		/*deviceId	Y	String	设备ID
		phoneNum	Y	String	手机号码	设备绑定的手机号码
		startTime	N	String	启动时间	大于当前时间24小时内,YYYY-MM-DD HH:MM24:SS，当没有该参数时，表示立即启动
		temperature	Y	Integer	设定温度	60~100,0-停止加热
		soak	Y	Integer	设定时间（根据出汤量不同时间的最小值不同）	0~600秒,0 - 不浸泡，1~600  浸泡时间(单位:秒)
		waterlevel	Y	Integer	出水量（分8个档次）	 150 200 250 300   350 400  450 550 (单位：毫升ml)
		teaSortId	Y	Integer	茶类ID
		teaSortName	Y	String	茶类名称*/
		// 响应
		/*retn	Y	Integer	返回码
		desc	Y	String	返回描述
		reservNo	N	Integer	预约号	预约泡茶时返回预约号*/
		return new CommonResp();
	}
	

}
