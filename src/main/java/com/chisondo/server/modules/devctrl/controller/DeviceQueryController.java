package com.chisondo.server.modules.devctrl.controller;

import com.alibaba.fastjson.JSONObject;
import com.chisondo.server.common.core.AbstractController;
import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.modules.devctrl.entity.DeviceStateInfoEntity;
import com.chisondo.server.modules.devctrl.entity.StartTeaEntity;
import com.chisondo.server.modules.devctrl.service.DeviceStateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备查询 controller
 * @author ding.zhong
 * @email 258321511@qq.com
 * @date Mar 12.19
 */
@RestController
public class DeviceQueryController extends AbstractController {

	@Autowired
	private DeviceStateInfoService deviceStateInfoService;

	/**
	 * 查询设备实时状态
	 */
	@RequestMapping("/api/rest/qryDevStatus")
	public CommonResp queryDeviceStatus(@RequestBody CommonReq req){
		String deviceId = JSONObject.parseObject(req.getBizBody()).getString("deviceId");
		// TODO 直接从 redis 查询设备状态
		DeviceStateInfoEntity deviceStateInfo = this.deviceStateInfoService.queryObject(Integer.valueOf(deviceId));

		/*输入参数	是否必填	参数类型	说明	备注
		deviceId	设备ID	String	Y
		响应参数
		输出参数	是否必填	参数类型	说明	备注
		retn	返回码	Integer	Y
		desc	返回描述	Integer	Y
		connStatus	连接状态	Integer	Y	0:未连接, 非0:已有用户连接上
		onlineStatus	在线状态	Integer	Y	0不在线，1在线
		makeTemp	设定加热温度	Integer	Y	1:ON; 0:OFF; 60‐100
		temp	即时温度值	Integer	Y	25‐100
		warm	是否保温	Integer	Y	0-未保温 1-保温中
		density	浓淡指示灯状态	Integer	Y	1:浓; 2:中; 3:淡;
		waterlv	设定出水量	Integer	Y	8个档次(单位：毫升ml)
		makeDura	设定沏茶时间	Integer	Y	0 - 不浸泡，1~600  浸泡时间(单位:秒)
		reamin	剩余工作时间	Integer	Y	面板显示剩余时间
		tea	即时缺茶状态	Integer	Y	1:缺茶
		water	即时缺水状态	Integer	Y	1:缺水
		work	即时沏茶状态	Integer	Y	0:没有工作, 1: 沏茶, 2: 洗茶，3：烧水
		makeType	沏茶类型	Integer	Y	0-茶谱沏茶；1-普通沏茶；2-面板操作
		teaSortId	茶类ID	Integer	N
		teaSortName	茶类名称	String	N
		chapuId	使用的茶谱ID	Integer	Y	没有在使用茶谱返回0
		chapuName	茶谱名称	String	N
		chapuImage	茶谱图像	String	N
		chapuMakeTimes	茶谱总泡数	int	N
		index	第几泡	int	Y	>0：当前正在进行的是第几泡;-1：没有正在使用的茶谱;0：已完成茶谱最大泡数，下一步开始第1泡;999：茶谱正常结束
*/
		return new CommonResp();
	}
}
