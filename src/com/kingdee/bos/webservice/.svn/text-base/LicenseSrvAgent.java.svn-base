/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.kingdee.bos.webservice;

import com.kingdee.bos.AbstractBOSObject;
import com.kingdee.bos.Context;
import com.kingdee.bos.ResponseInvocationHandler;
import com.kingdee.bos.framework.ejb.EJBFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.license.EditionTypeEnum;
import com.kingdee.eas.base.license.ILicenseSrv;
import com.kingdee.eas.base.license.ILicenseSrvAgent;
import com.kingdee.eas.base.license.LicenseBaseInfo;
import com.kingdee.eas.base.license.LicenseException;
import com.kingdee.eas.base.license.LicenseProduction;
import com.kingdee.eas.base.license.LicenseServerInfo;
import com.kingdee.eas.base.license.LicenseTakeDetailInfo;
import com.kingdee.eas.base.license.LicenseUsageInfo;
import com.kingdee.eas.base.license.LicenseUserInfo;
import com.kingdee.eas.base.license.ModuleLicenseInfo;
import com.kingdee.eas.base.license.agent.LicenseSrvFactory;
import com.kingdee.eas.base.license.expirecheck.LicenseGonnaExpiredConfigInfo;
import com.kingdee.eas.base.license.file.LicenseCloudRequestInfo;
import com.kingdee.eas.base.license.file.LicenseFileErrorException;
import com.kingdee.eas.base.license.file.LicenseValidateInfo;
import com.kingdee.eas.base.license.file.config.LicenseConfig;
import com.kingdee.eas.base.license.file.config.LicenseFileConfigInfo;
import com.kingdee.eas.base.license.util.LicenseUtils;
import com.kingdee.util.db.SQLUtils;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class LicenseSrvAgent extends AbstractBOSObject implements
		ILicenseSrvAgent {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.base.license.agent.LicenseSrvAgent");
	ILicenseSrv licenseSrv;

	public static ILicenseSrvAgent getLocalInstance() throws LicenseException {
		try {
			Object localObject = new LicenseSrvAgent();
			localObject = (ILicenseSrvAgent) Proxy.newProxyInstance(Thread
					.currentThread().getContextClassLoader(),
					new Class[] { ILicenseSrvAgent.class },
					new ResponseInvocationHandler(ILicenseSrvAgent.class,
							localObject));
			return (ILicenseSrvAgent) localObject;
		} catch (Exception localException) {
			throw new LicenseException(localException);
		}
	}

	public LicenseSrvAgent() throws LicenseException {
		super.registerInterface(ILicenseSrvAgent.class, this);
		this.licenseSrv = LicenseSrvFactory.getInstance();
	}

	public LicenseSrvAgent(Context paramContext) throws LicenseException {
		super.registerInterface(ILicenseSrvAgent.class, this);
		this.licenseSrv = LicenseSrvFactory.getInstance();
	}

	public int licenseCheck(String paramString) throws LicenseException {
		return this.licenseSrv.licenseCheck(paramString);
	}

	public void distory() {
		this.licenseSrv.distory();
	}

	public boolean isLicenseTaker(String paramString1, String paramString2) {
		return this.licenseSrv.isLicenseTaker(paramString1, paramString2);
	}

	public BOSObjectType getType() {
		return new BOSObjectType("LICE");
	}

	public int requestLicense(LicenseUserInfo paramLicenseUserInfo,
			String paramString) throws LicenseException {
		return this.licenseSrv
				.requestLicense(paramLicenseUserInfo, paramString);
	}

	public int requestLicenseOnInvalid(LicenseUserInfo paramLicenseUserInfo,
			String paramString) throws LicenseException {
		return this.licenseSrv.requestLicenseOnInvalid(paramLicenseUserInfo,
				paramString);
	}

	public int requestLicenseByUserAndSubSystem(
			LicenseUserInfo paramLicenseUserInfo, String paramString)
			throws LicenseException {
		return this.licenseSrv.requestLicenseByUserAndSubSystem(
				paramLicenseUserInfo, paramString);
	}

	public int reqeustLicenseByModuleAndUIName(
			LicenseUserInfo paramLicenseUserInfo, String paramString1,
			String paramString2) throws LicenseException {
		return this.licenseSrv.reqeustLicenseByModuleAndUIName(
				paramLicenseUserInfo, paramString1, paramString2);
	}

	public void releaseLicenseBySessionIDAndSubSystem(String paramString1,
			String paramString2) throws LicenseException {
		System.out.print("方法：releaseLicenseBySessionIDAndSubSystem param :" + paramString1 + " param2:"+ paramString2);
		this.licenseSrv.releaseLicenseBySessionIDAndSubSystem(paramString1,
				paramString2);
	}

	public void releaseLicenseByModuleAndUIName(String paramString1,
			String paramString2, String paramString3) throws LicenseException {
		this.licenseSrv.releaseLicenseByModuleAndUIName(paramString1,
				paramString2, paramString3);
	}

	public Map getLicenseClientCacheBaseInfo(String paramString)
			throws LicenseException {
		return this.licenseSrv.getLicenseClientCacheBaseInfo(paramString);
	}

	public void releaseLicense(String paramString1, String paramString2)
			throws LicenseException {
		this.licenseSrv.releaseLicense(paramString1, paramString2);
	}

	public void releaseLicenseBySessionID(String paramString)
			throws LicenseException {
		this.licenseSrv.releaseLicenseBySessionID(paramString);
	}

	public LicenseUsageInfo[] getLicenseUsageInfo(String paramString)
			throws LicenseException {
		return this.licenseSrv.getLicenseUsageInfo(paramString);
	}

	public LicenseTakeDetailInfo[] getLicenseTakeDetailInfo(
			String paramString1, String paramString2) throws LicenseException {
		return this.licenseSrv.getLicenseTakeDetailInfo(paramString1,
				paramString2);
	}

	public LicenseBaseInfo getLicenseBaseInfo() throws LicenseException {
		return this.licenseSrv.getLicenseBaseInfo();
	}

	public ModuleLicenseInfo[] getModuleLicenseInfo() throws LicenseException {
		return this.licenseSrv.getModuleLicenseInfo();
	}

	public LicenseServerInfo getServerInfo() throws LicenseException {
		return this.licenseSrv.getServerInfo();
	}

	public void releaseLicenseByUserIDAndModuleName(String paramString1,
			String paramString2) throws LicenseException {
		System.out.print("方法：releaseLicenseByUserIDAndModuleName param :" + paramString1 + " param2:"+ paramString2);
		this.licenseSrv.releaseLicenseByUserIDAndModuleName(paramString1,
				paramString2);
	}

	public void setReleaseCount(int paramInt) throws LicenseException {
		this.licenseSrv.setReleaseCount(paramInt);
	}

	public int getReleaseCount() throws LicenseException {
		return this.licenseSrv.getReleaseCount();
	}

	public void releaselicenseBySessionIDAndModuleName(String paramString1,
			String paramString2) throws LicenseException {
		System.out.print("方法：releaselicenseBySessionIDAndModuleName param :" + paramString1 + " param2:"+ paramString2);
		this.licenseSrv.releaselicenseBySessionIDAndModuleName(paramString1,
				paramString2);
	}

	public void reportActiveOperation(String paramString1, String paramString2)
			throws LicenseException {
		this.licenseSrv.reportActiveOperation(paramString1, paramString2);
	}

	public void reportActiveModuleOperation(String paramString1,
			String paramString2) throws LicenseException {
		this.licenseSrv.reportActiveModuleOperation(paramString1, paramString2);
	}

	public int getOrgLimitationNumber() throws LicenseException {
		return this.licenseSrv.getOrgLimitationNumber();
	}

	public boolean isDefaultTrialPeriod(String paramString)
			throws LicenseException {
		System.out.print("方法：isDefaultTrialPeriod param :" + paramString);
		return true;
//		String str = "select c.fperiodyear,c.fperiodnumber,d.fperiodyear,d.fperiodnumber,fcompanyid from t_bd_systemstatusctrol a inner join t_bd_systemstatus b on a.fsystemstatusid=b.fid inner join t_bd_period c on c.fid=a.fcurrentperiodid inner join t_bd_period d on d.fid=a.fstartperiodid where fcompanyid= ? and fname=6";
//		Connection localConnection = null;
//		PreparedStatement localPreparedStatement = null;
//		ResultSet localResultSet = null;
//		try {
//			localConnection = getConnection();
//			localPreparedStatement = localConnection.prepareStatement(str);
//			localPreparedStatement.setString(1, paramString);
//			localResultSet = localPreparedStatement.executeQuery();
//			if (localResultSet.next()) {
//				int i = localResultSet.getInt(1);
//				int j = localResultSet.getInt(2);
//				int k = localResultSet.getInt(3);
//				int l = localResultSet.getInt(4);
//				if (i < k) {
//					i1 = 0;
//					return i1;
//				}
//				j = (i - k) * 12 + j;
//				if (j - l >= 3) {
//					LicenseUtils
//							.debugLogger(
//									logger,
//									"超过试用期");
//					i1 = 0;
//					return i1;
//				}
//				LicenseUtils
//						.debugLogger(
//								logger,
//								"试用期中");
//				int i1 = 1;
//				return i1;
//			}
//			int i = 1;
//			return i;
//		} catch (SQLException localSQLException) {
//		} finally {
//			SQLUtils.cleanup(localResultSet);
//			SQLUtils.cleanup(localPreparedStatement);
//			SQLUtils.cleanup(localConnection);
//		}
	}

	private Connection getConnection()
			throws SQLException {
		return EJBFactory.getConnection(getContext());
	}

	public boolean isOpenModule(String paramString) {
		return this.licenseSrv.isOpenModule(paramString);
	}

	public String[] getOpenModules() {
		return this.licenseSrv.getOpenModules();
	}

	public boolean isDemoVersion() throws LicenseException {
		return this.licenseSrv.isDemoVersion();
	}

	public String getIndustryName() throws LicenseException {
		return this.licenseSrv.getIndustryName();
	}

	public LicenseConfig getLicenseConfig() {
		return this.licenseSrv.getLicenseConfig();
	}

	public boolean isEasPackage(String paramString) {
		return this.licenseSrv.isEasPackage(paramString);
	}

	public void importLicenseFile(
			LicenseFileConfigInfo paramLicenseFileConfigInfo)
			throws LicenseException, LicenseFileErrorException {
		this.licenseSrv.importLicenseFile(paramLicenseFileConfigInfo);
	}

	public void removeLicenseFile(
			LicenseFileConfigInfo paramLicenseFileConfigInfo)
			throws LicenseException, LicenseFileErrorException {
		this.licenseSrv.removeLicenseFile(paramLicenseFileConfigInfo);
	}

	public void refreshPackageConfig() throws Exception {
		this.licenseSrv.refreshPackageConfig();
	}

	public String getModuleByPackage(String paramString)
			throws LicenseException {
		return this.licenseSrv.getModuleByPackage(paramString);
	}

	public String getSubSystemNameByPackage(String paramString)
			throws LicenseException {
		return this.licenseSrv.getSubSystemNameByPackage(paramString);
	}

	public String getGenuineNo() throws LicenseException {
		return this.licenseSrv.getGenuineNo();
	}

	public String getProductNo() throws LicenseException {
		return this.licenseSrv.getProductNo();
	}

	public List getCurrentPVRecord() throws LicenseException {
		return this.licenseSrv.getCurrentPVRecord();
	}

	public List getPVRecordList() throws LicenseException {
		return this.licenseSrv.getPVRecordList();
	}

	public boolean isPVRecordEnabled() {
		return this.licenseSrv.isPVRecordEnabled();
	}

	public LicenseGonnaExpiredConfigInfo getLicenseGonnaExpiredConfigInfo()
			throws LicenseException {
		return this.licenseSrv.getLicenseGonnaExpiredConfigInfo();
	}

	public void setLicenseGonnaExpiredConfigInfo(
			LicenseGonnaExpiredConfigInfo paramLicenseGonnaExpiredConfigInfo)
			throws LicenseException {
		this.licenseSrv
				.setLicenseGonnaExpiredConfigInfo(paramLicenseGonnaExpiredConfigInfo);
	}

	public void handleSessionIDChange(String paramString1, String paramString2)
			throws LicenseException {
		this.licenseSrv.handleSessionIDChange(paramString1, paramString2);
	}

	public LicenseProduction getLicenseProduction() throws LicenseException {
		return this.licenseSrv.getLicenseProduction();
	}

	public EditionTypeEnum getEditionType() throws LicenseException {
		return this.licenseSrv.getEditionType();
	}

	public String getFunctionModuleNameByClassName(String paramString)
			throws LicenseException {
		return this.licenseSrv.getFunctionModuleNameByClassName(paramString);
	}

	public int judgeHaveFunction(String paramString) {
		return this.licenseSrv.judgeHaveFunction(paramString);
	}

	public LicenseCloudRequestInfo generateRequestInfo(
			String[] paramArrayOfString) {
		return this.licenseSrv.generateRequestInfo(paramArrayOfString);
	}

	public LicenseValidateInfo getLicenseValidateInfo() {
		return this.licenseSrv.getLicenseValidateInfo();
	}

	public boolean updateLicenseValidate(String paramString)
			throws LicenseException {
		return this.licenseSrv.updateLicenseValidate(paramString);
	}

	public boolean isNeedRevalidate(String paramString) {
		return this.licenseSrv.isNeedRevalidate(paramString);
	}

	public boolean updateLatestCheckDate(String paramString) {
		return this.licenseSrv.updateLatestCheckDate(paramString);
	}

	@Override
	public List getValidModuleLicenses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getValidModuleLicensesWhithoutFunc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLoadSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPiratedSoftware() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean licenseFileIsImported() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAllModuleNameByClassName(String arg0)
			throws LicenseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getControlPolicy() throws LicenseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRegister() throws LicenseException {
		// TODO Auto-generated method stub
		return false;
	}
}