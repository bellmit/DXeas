/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.kingdee.eas.base.license.agent;

import com.kingdee.bos.framework.DeployInfoManagerFactory;
import com.kingdee.bos.framework.IDeployInfoManager;
import com.kingdee.bos.framework.config.ORMServiceLocationInfo;
import com.kingdee.bos.orm.IORMModel;
import com.kingdee.bos.rpcwrapper.RPCEngineFactory;
import com.kingdee.eas.base.license.ILicenseSrv;
import com.kingdee.eas.base.license.LicenseException;
import com.kingdee.eas.base.license.server.ormrpc.LicenseSrv;

public class LicenseSrvFactory {
	private static final String logger = "license";

	public static ILicenseSrv getInstance() throws LicenseException {
		IDeployInfoManager localIDeployInfoManager = DeployInfoManagerFactory
				.getDeployInfoManager();
		ORMServiceLocationInfo localORMServiceLocationInfo = localIDeployInfoManager
				.getORMServiceLocationInfo("license");
		try {
			if (localORMServiceLocationInfo == null)
				return new LicenseSrv();
			if ((localORMServiceLocationInfo.getServiceURL() == null)
					|| (localORMServiceLocationInfo.getServiceURL().length() == 0))
				return new LicenseSrv();
			String str = localORMServiceLocationInfo.getServiceURL().trim();
			if ((str == null) || (str.length() == 0))
				return new LicenseSrv();
			IORMModel localIORMModel = RPCEngineFactory
					.getEngine(str)
					.createObject(
							"com.kingdee.eas.base.license.server.ormrpc.LicenseSrv",
							ILicenseSrv.class);
			if (localIORMModel == null)
				throw new LicenseException(
						"Can not find Class 'com.kingdee.eas.base.license.server.ormrpc.LicenseSrv',Please make sure this class is in you CLASSPATH");
			return ((ILicenseSrv) localIORMModel);
		} catch (Exception localException) {
			throw new LicenseException(localException);
		}
	}
}