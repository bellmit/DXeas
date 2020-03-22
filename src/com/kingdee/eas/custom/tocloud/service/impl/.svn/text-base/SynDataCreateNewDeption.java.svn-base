package com.kingdee.eas.custom.tocloud.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDeption;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudKeyValue;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.custom.tocloud.utils.K3CloudUtil;


/**
 * 生成cloud里面新的部门
 */

public class SynDataCreateNewDeption implements ISynData{

	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub


		CloudCommonDeption newDeption = new CloudCommonDeption();
		CloudCommonF7Bean f7Bean = new CloudCommonF7Bean();

		String FDEPTID = "0";
		newDeption.setFDEPTID(FDEPTID);


		String str = "TYZQ";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(str);
		newDeption.setFCreateOrgId(f7Bean);


		String FNumber = "HYS001";
		newDeption.setFNumber(FNumber);


		String FUseOrgId = "TYZQ";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(str);
		newDeption.setFUseOrgId(f7Bean);


		
		CloudKeyValue[] kvArray = new CloudKeyValue[1];
		CloudKeyValue kv = new CloudKeyValue();
		kv.setKey("2052");
		kv.setValue("天源会议室");
		kvArray[0] = kv;
		
		newDeption.setFName(kvArray);
		
		
		

		String FHelpCode = "";
		newDeption.setFHelpCode(FHelpCode);


		String FParentID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(str);
		newDeption.setFParentID(f7Bean);

		String FFullName = "";
		newDeption.setFFullName(FFullName);

		String FEffectDate = "2019-01-15";
		newDeption.setFEffectDate(FEffectDate);

		String FLapseDate = "9999-12-31";
		newDeption.setFLapseDate(FLapseDate);


		String FDeptProperty = "DP01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FDeptProperty);
		newDeption.setFDeptProperty(f7Bean);


		String str1 = "同步新生成部门";
		newDeption.setFDescription(str1);

		String FGroup = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(str);
		newDeption.setFGroup(f7Bean);


		String FIsCopyFlush = "false";
		newDeption.setFIsCopyFlush(FIsCopyFlush);

		//将实体转化为jsonObject
		String manuString = JSONObject.toJSONString(newDeption, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data（必填）
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//新建CloudCommonBean对象
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("BD_Department");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
//		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
		
		
		
		return  K3CloudUtil.Save(JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty));
		
		
	}

}
