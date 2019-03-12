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
 * 设备控制 controller
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
@RestController
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

	/**
	 * 绑定沏茶器（添加设备）
	 * @param req
	 * @return
	 */
	@RequestMapping("/api/rest/connectDevice")
	public CommonResp bindDevice(@RequestBody CommonReq req) {
		/*输入参数	是否必填	参数类型	说明	备注
		deviceId	Y	String	设备ID
		phoneNum	Y	String	手机号码	设备绑定的手机号码
		companyId	Y	int	所属企业id	0-泉笙道，1-湘丰集团，2-静硒园,345….,默认-1，表示还没有绑定企业，第一次时修改，不为-1时，不允许再修改
		longitude	Y	String	经度	手机定位
		latitude	Y	String	维度
		province	Y	String	省
		city	Y	String	市
		district	Y	String	区
		detaddress	Y	String	详细地址
		passwd	Y	String	设备密码	需md5加密，默认密码（123456）
		响应参数
		输出参数	是否必填	参数类型	说明	备注
		retn	Y	Integer	返回码
		desc	Y	String	返回描述
		errCode	N	Integer	错误标识	连接失败原因：1-设备不存在；2-设备离线；3-设备已被其他用户占用；4-密码错误
		以下内容在添加（绑定）成功时才返回
		deviceId	Y	Integer	设备ID
		deviceName	Y	String	设备名称
		companyId	Y	int	所属企业id
		companyName	Y	int	所属企业名称	,0-泉笙道，1-湘丰集团，2-静硒园,345….,默认 0泉笙道
		deviceDesc	Y	String	设备描述*/

		return new CommonResp();
	}
	

}
