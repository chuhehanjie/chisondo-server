package com.chisondo.server.modules.device.service.impl;

import com.chisondo.server.common.http.CommonReq;
import com.chisondo.server.common.http.CommonResp;
import com.chisondo.server.common.utils.Keys;
import com.chisondo.server.modules.device.dto.resp.DevSettingInfoResp;
import com.chisondo.server.modules.device.service.ActivedDeviceInfoService;
import com.chisondo.server.modules.device.service.DeviceQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("deviceQueryService")
public class DeviceQueryServiceImpl implements DeviceQueryService {
	@Autowired
	private ActivedDeviceInfoService deviceInfoService;
	
	@Override
	public CommonResp queryDevSettingInfo(String deviceId) {
		/*说明	设置内置茶谱参数
		接口描述	返回洗茶按钮参数 烧水按钮参数 内置茶谱参数，是否静音等。
		请求示例
				参数列表
		key	value	参数类型	必选	备注
		action	qrydevparm	固定	Y	查询内置参数信息状态
		deviceID	898398492	可变	Y	需操作的设备ID
				响应参数
		key	value	参数类型	必选	备注
		retn	可变	Integer	Y	返回码：200表示正常，其它为异常
		desc	可变	String	Y	返回描述：返回码对应的文字说明，如：
		200-请求成功
		201-参数格式错误
		202-鉴权失败
。。。。等等，可扩展
		action	qrydevparmok 	固定	Y	请求传入的action+ok
		deviceID	898398492	可变	Y	被操作的设备ID
		msg	--	{}	Y
		state	数值	0 1 2 3	Y	状态值，可扩展
		stateinfo	数值	0 1 2 3…	Y	对应状态值的说明，如：
		0-	操作成功，非0为操作失败
		1-	其它异常错误
		volflag	1	1 2 		1-开启提示声 2-关闭提示音
		gmsflag	1	1 2		1-优先2G网络（默认）  2-优先Wi-Fi网络
		washteamsg	--	{}	Y
		temperature	数值	60-100	Y	设定的温度，需大于60度小于100度。
		soak	数值	0-600	Y	0 - 不浸泡，1~600  沏茶时间(单位:秒)
		waterlevel	固定数值	8档次	Y	取值为：150 200 250 300 350 400 450 550  8个档次 (单位：毫升ml)
		boilwatermsg	--	{}	Y
		temperature	数值	60-100	Y	设定的温度，需大于60度小于100度。
		soak	数值	0-600	Y	0 - 不浸泡，1~600  沏茶时间(单位:秒)
		waterlevel	固定数值	8档次	Y	取值为：150 200 250 300 350 400 450 550  8个档次 (单位：毫升ml)
		chapumsg	--	{}	Y
		index	数值	1-10	Y	面板位置
		chapuid	数值	1	Y	茶谱ID
		chapuname	茶谱名称		Y
		maketimes	总泡数		Y
		teaparm	--	{}	Y
		temperature	数值	60-100	Y	设定的温度，需大于60度小于100度。
		soak	数值	0-600	Y	0 - 不浸泡，1~600  沏茶时间(单位:秒)
		waterlevel	固定数值	8档次	Y	取值为：150 200 250 300 350 400 450 550  8个档次 (单位：毫升ml)
*/
		DevSettingInfoResp devSettingResp = new DevSettingInfoResp();
		return CommonResp.ok(devSettingResp);
	}

	@Override
	public CommonResp queryHisConnectDevOfUser(String userMobile) {
		/*List<DeviceInfoRespDTO> devInfoList = this.activedDeviceInfoDao.queryHisConnectDevOfUserByPhone(userMobile);
		DevQueryRespDTO devQueryResp = new DevQueryRespDTO(devInfoList);
		return CommonResp.ok(devQueryResp);*/
		return CommonResp.ok();
	}

	@Override
	public CommonResp queryMakeTeaRecordsOfDev(CommonReq req) {
		String deviceId = (String) req.getAttrByKey(Keys.DEVICE_ID);
		/*retn	Y	Integer	返回码
		desc	Y	String	返回描述
		count	Y	Integer	记录条数
		rows	N	Array	泡茶信息
		makeId	Y	Integer	记录编号
		phoneNum	Y	String	用户手机号码
		userName	N	String	用户昵称	可为空可为微信昵称
		userImg	N	String	用户图像	可为空可为微信图像
		startTime	Y	String	启动时间
		endTime	Y	String	结束时间
		makeType	Y	Integer	沏茶类型	0-普通沏茶；1-茶谱沏茶；2-洗茶；3-烧水
		makeMode	Y	Integer	沏茶方式	0-手机终端操作；1-设备面板操作
		下面这一部分字段，只有在使用茶谱沏茶时才有返回
		chapuId	Y	int	茶谱ID
		chapuName	Y	String	茶谱名称
		chapuIndex	Y	Integer	执行的是第几泡
		chapuImage	N	String	茶谱图像	可为空
		下面这一部分字段，只有在非茶谱沏茶时才返回
		teaSortId	N	Integer	茶类ID
		teaSortName	N	String	茶类名称
		temperature	Y	Integer	温度
		waterlevel	Y	Integer	出水量
		soak	Y	Integer	沏茶时间*/
		return CommonResp.ok();
	}
}
