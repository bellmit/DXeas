/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.kingdee.eas.base.license.app;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.base.license.LicenseBaseInfo;
import com.kingdee.eas.base.license.LicenseException;
import com.kingdee.eas.base.license.LicenseUserInfo;
import com.kingdee.eas.base.license.agent.LicenseSrvAgent;
import com.kingdee.util.Base64Encoder;
import com.kingdee.util.DateTimeUtils;
import com.kingdee.util.StringUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class LicenseCtrlFacadeControllerBean extends
		AbstractLicenseCtrlFacadeControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.base.license.app.LicenseCtrlFacadeControllerBean");

	protected int _requestLicense(Context paramContext, String paramString1,
			String paramString2) throws BOSException {
		int i = 0;
		try {
			LicenseSrvAgent localLicenseSrvAgent = new LicenseSrvAgent();
			JSONObject localJSONObject = JSONObject.parseObject(paramString1);
			LicenseUserInfo localLicenseUserInfo = (LicenseUserInfo) JSONObject
					.toJavaObject(localJSONObject, LicenseUserInfo.class);
			i = localLicenseSrvAgent.requestLicense(localLicenseUserInfo,
					paramString2);
		} catch (LicenseException localLicenseException) {
			logger.error(localLicenseException.getMessage(),
							localLicenseException);
		}
		return 1;
//		return i;
	}

	protected int _requestLicenseByUserAndSubSystem(Context paramContext,
			String paramString1, String paramString2) throws BOSException {
		int i = 0;
		try {
			LicenseSrvAgent localLicenseSrvAgent = new LicenseSrvAgent();
			JSONObject localJSONObject = JSONObject.parseObject(paramString1);
			LicenseUserInfo localLicenseUserInfo = (LicenseUserInfo) JSONObject
					.toJavaObject(localJSONObject, LicenseUserInfo.class);
			i = localLicenseSrvAgent.requestLicenseByUserAndSubSystem(
					localLicenseUserInfo, paramString2);
		} catch (LicenseException localLicenseException) {
			logger
					.error(localLicenseException.getMessage(),
							localLicenseException);
		}
		
		return 1;
//		return i;
	}

	protected void _releaseLicenseBySessionIDAndSubSystem(Context paramContext,
			String paramString1, String paramString2) throws BOSException {
		try {
			LicenseSrvAgent localLicenseSrvAgent = new LicenseSrvAgent();
			localLicenseSrvAgent.releaseLicenseBySessionIDAndSubSystem(
					paramString1, paramString2);
		} catch (LicenseException localLicenseException) {
			logger
					.error(localLicenseException.getMessage(),
							localLicenseException);
		}
	}

	protected void _releaseLicense(Context paramContext, String paramString1,
			String paramString2) throws BOSException {
		try {
			LicenseSrvAgent localLicenseSrvAgent = new LicenseSrvAgent();
			localLicenseSrvAgent.releaseLicense(paramString1, paramString2);
		} catch (LicenseException localLicenseException) {
			logger
					.error(localLicenseException.getMessage(),
							localLicenseException);
		}
	}

	protected String _getLicenseInfo(Context paramContext) throws BOSException {
		String str1 = "";
		HashMap localHashMap = new HashMap();
		LicenseBaseInfo localLicenseBaseInfo = null;
		try {
			LicenseSrvAgent localLicenseSrvAgent = new LicenseSrvAgent();
			localLicenseBaseInfo = localLicenseSrvAgent.getLicenseBaseInfo();
			localHashMap.put("productId", "S3S001S001");
			
			System.out.println("kevin_gj_wang :license ");
			
			localHashMap.put("productVersion", localLicenseBaseInfo
					.getVersion());
			localHashMap.put("identityCode", localLicenseBaseInfo
					.getLicenseID());
			localHashMap.put("productNo", localLicenseSrvAgent.getProductNo());
			String str3 = "";
			if (localLicenseBaseInfo.getServiceDate() != null)
				str3 = DateTimeUtils.format(localLicenseBaseInfo
						.getServiceDate(), "yyyy-MM-dd");
			localHashMap.put("serviceEndDate", str3);
		} catch (Exception localException1) {
			logger
					.error(localException1.getMessage(), localException1);
		}
		String str2 = "";
		try {
			if (!(StringUtils.isEmpty(localLicenseBaseInfo.getLicenseTo())))
				str2 = new String(
						Base64Encoder.base64ToByteArray(localLicenseBaseInfo
								.getLicenseTo()), "GBK");
		} catch (Exception localException2) {
			logger
					.error(localException2.getMessage(), localException2);
		}
		localHashMap.put("companyName", str2);
		str1 = JSONObject.toJSONString(localHashMap);
		logger
				.error("licenseInfo:" + str1);
		
		System.out.println("kevin_gj_wang :license ");
		System.out.println(str1);
		return str1;
	}
}