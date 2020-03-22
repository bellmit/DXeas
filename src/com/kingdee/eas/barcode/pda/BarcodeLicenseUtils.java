/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.kingdee.eas.barcode.pda;

import com.kingdee.bos.Context;
import com.kingdee.bos.util.EASResource;
import com.kingdee.eas.barcode.scm.BarcodeWSException;
import com.kingdee.eas.base.license.LicenseException;
import com.kingdee.eas.base.license.LicenseUserInfo;
import com.kingdee.eas.base.license.agent.LicenseSrvAgent;
import com.kingdee.util.NumericExceptionSubItem;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;

public class BarcodeLicenseUtils {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.barcode.pda.BarcodeLicenseUtils");

	public static void requestLicenseOrReleaseLicense(Context ctx,
			boolean flag, String sessionId) throws LicenseException,
			BarcodeWSException {
		LicenseSrvAgent lAgent = new LicenseSrvAgent();
		if (flag) {
			LicenseUserInfo paramLicenseUserInfo = new LicenseUserInfo();
			paramLicenseUserInfo.setSessionID(sessionId);
//			paramLicenseUserInfo.setUserCompany("PDA");
			paramLicenseUserInfo.setUserCompany("4");
			paramLicenseUserInfo.setUserID(ctx.getCaller().toString());
			paramLicenseUserInfo.setUserIP(ctx.getClientHostIP());
			paramLicenseUserInfo.setUserLoginAis(ctx.getUserName());

			paramLicenseUserInfo.setUserLoginTime(getTime());
			System.out.println("BARCODE_PDA");
//			int licenselcFlag = lAgent.requestLicenseByUserAndSubSystem(
//					paramLicenseUserInfo, "BARCODE_PDA");
			int licenselcFlag = lAgent.requestLicenseByUserAndSubSystem(
					paramLicenseUserInfo, "IM");
			switch (licenselcFlag) {
			case 4:
				throw new BarcodeWSException(new NumericExceptionSubItem("",
						EASResource.getString(
								"com.kingdee.eas.framework.FrameWorkResource",
								"Error_License_Invalid")));
			case 2:
				throw new BarcodeWSException(new NumericExceptionSubItem("",
						EASResource.getString(
								"com.kingdee.eas.framework.FrameWorkResource",
								"Error_License_NO_SURPLUS")));
			}
		} else {
//			lAgent.releaseLicenseBySessionIDAndSubSystem(sessionId,
//					"BARCODE_PDA");
			lAgent.releaseLicenseBySessionIDAndSubSystem(sessionId,
			"IM");
		}
	}

	private static Timestamp getTime() {
		Date date = new Date();
		long time = date.getTime();
		Calendar d = Calendar.getInstance();
		d.setTime(new Timestamp(time));
		d.set(14, 0);
		Timestamp createtime = new Timestamp(d.getTime().getTime());
		return createtime;
	}
}