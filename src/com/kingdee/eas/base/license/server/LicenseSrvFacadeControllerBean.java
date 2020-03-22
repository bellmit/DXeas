/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.kingdee.eas.base.license.server;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.base.license.ILicenseSrv;
import com.kingdee.eas.base.license.LicenseException;
import com.kingdee.eas.base.license.LicenseUsageInfo;
import com.kingdee.eas.base.license.agent.LicenseSrvFactory;
import com.kingdee.util.StringUtils;
import org.apache.log4j.Logger;

public class LicenseSrvFacadeControllerBean extends
		AbstractLicenseSrvFacadeControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.base.license.server.LicenseSrvFacadeControllerBean");

	protected int _getLicenseMaxNum(Context paramContext, String paramString)
			throws BOSException {
		try {
			if (!(StringUtils.isEmpty(paramString))) {
				LicenseUsageInfo[] arrayOfLicenseUsageInfo = LicenseSrvFactory
						.getInstance().getLicenseUsageInfo(paramString);
				if ((arrayOfLicenseUsageInfo != null)
						&& (arrayOfLicenseUsageInfo.length > 0))
					return 1;
//					return arrayOfLicenseUsageInfo[0].getMaxLicenseNum();
			}
		} catch (LicenseException localLicenseException) {
			throw new BOSException(localLicenseException);
		}
		logger.info("moduleName is :" + paramString);
		System.out.println("moduleName is :" + paramString);
		return 1;
//		return 0;
	}
}