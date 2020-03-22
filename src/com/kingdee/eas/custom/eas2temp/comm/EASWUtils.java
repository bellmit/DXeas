package com.kingdee.eas.custom.eas2temp.comm;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.ICostObject;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitCollection;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.service.OrgCommonUtils;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.eas2temp.BarMaterialRelFactory;
import com.kingdee.eas.custom.eas2temp.BarMaterialRelInfo;
import com.kingdee.eas.custom.eas2temp.BillDeafultSettingCollection;
import com.kingdee.eas.custom.eas2temp.BillDeafultSettingFactory;
import com.kingdee.eas.custom.eas2temp.BillDeafultSettingInfo;
import com.kingdee.eas.custom.eas2temp.IBarMaterialRel;
import com.kingdee.eas.custom.eas2temp.IBillDeafultSetting;
import com.kingdee.eas.custom.eas2temp.databaseVersion;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.util.StringUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class EASWUtils {
	public final static String Temp_EASRecord_tableName = "CT_EAS_importBillRecord";// Temp����eas��¼��
	// ����eas��
	public final static String EAS_TempRecord_tableName = "CT_EAS_exportBillRecord";// eas����temp��¼��
	// ����eas��


	/**
	 * ���ݹ�˾�����ȡ��˾id
	 * 
	 * @param ctx
	 * @param companyNum
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static String getCompanyIDByNumber(Context ctx, String companyNum) throws EASBizException, BOSException {
		String result = null;
		if (!StringUtils.isBlank(companyNum)) {
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("number", companyNum, CompareType.EQUALS));
			ev.setFilter(filter);
			StorageOrgUnitCollection col = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitCollection(ev);
			if (col != null && col.size() > 0) {
				result = col.get(0).getString("id");
			}
		}
		return result;
	}

	/**
	 * �õ� temp �м��������Ϣ
	 * 
	 * @param ctx
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws BOSException
	 */
	public static Connection getTempConnection(Context ctx, String companyID, int targetSystem) throws Exception {
		Connection conn = null;
		String url = "", dbIP = "", dbName = "", dbPort = "", userName = "", password = "";
		int dbVersion;
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");
		sql.append(" from CT_EAS_DataBaseSetting ");// �����м��������Ϣ
		sql.append(" where CFCompanyIDID='").append(companyID).append("'");
		sql.append(" and CFTargetSystem = ").append(targetSystem);
		// ͬһ��Ŀ��ϵͳֻ����һ������
		IRowSet rs = null;
		if (ctx != null)
			rs = DbUtil.executeQuery(ctx, sql.toString());// new Object[] {
		else
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();

		if (rs != null && rs.next()) {
			dbIP = rs.getString("CFDbIP");
			dbPort = rs.getString("CFDbPort");
			dbName = rs.getString("CFDbName");
			userName = rs.getString("CFUserName");
			password = rs.getString("CFPassword");
			dbVersion = rs.getInt("CFDatabaseVersion");

			if (dbVersion == databaseVersion.SQLSERVER2000_VALUE) {
				Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
				url = "jdbc:microsoft:sqlserver://" + dbIP + ":" + dbPort + ";DatabaseName=" + dbName + ";SelectMethod=Cursor;";// SqlServer2000���ݿ�
				System.out.println("2000");
			} else {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				url = "jdbc:sqlserver://" + dbIP + ":" + dbPort + ";DatabaseName=" + dbName + ";"; // sqlserver2005���ݿ�
				System.out.println("2005+");
			}
			DriverManager.setLoginTimeout(20);
			conn = DriverManager.getConnection(url, userName, password);

		}

		rs.close();
		return conn;
	}
	/**
	 * �õ� temp �м��������Ϣ
	 * 
	 * @param ctx
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws BOSException
	 */
	public static Connection getTempConnection1(Context ctx, String companyID, int targetSystem) throws Exception {
		Connection conn = null;
		String url = "", dbIP = "", dbName = "", dbPort = "", userName = "", password = "";
		int dbVersion;
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");
		sql.append(" from CT_EAS_DataBaseSetting ");// �����м��������Ϣ
		sql.append(" where CFCompanyIDID='").append(companyID).append("'");
		sql.append(" and CFTargetSystem = ").append(targetSystem);
		// ͬһ��Ŀ��ϵͳֻ����һ������
		IRowSet rs = null;
		if (ctx != null)
			rs = DbUtil.executeQuery(ctx, sql.toString());// new Object[] {
		else
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();

		if (rs != null && rs.next()) {
			dbIP = rs.getString("CFDbIP");
			dbPort = rs.getString("CFDbPort");
			dbName = rs.getString("CFDbName");
			userName = rs.getString("CFUserName");
			password = rs.getString("CFPassword");
			dbVersion = rs.getInt("CFDatabaseVersion");

			if (dbVersion == databaseVersion.SQLSERVER2000_VALUE) {
				Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
				url = "jdbc:microsoft:sqlserver://" + dbIP + ":" + dbPort + ";DatabaseName=" + dbName + ";SelectMethod=Cursor;";// SqlServer2000���ݿ�
			} else {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				url = "jdbc:sqlserver://" + dbIP + ":" + dbPort + ";DatabaseName=" + dbName + ";"; // sqlserver2005���ݿ�
			}
			DriverManager.setLoginTimeout(20);
			conn = DriverManager.getConnection(url, userName, password);

		}

		rs.close();
		return conn;
	}

	/**
	 * ��鵥���Ƿ��Ѿ�����
	 * 
	 * @param ctx
	 * @param bosType
	 * @param billID
	 * @return
	 * @throws SQLException
	 * @throws BOSException
	 */
	public static boolean checkHasExported(Context ctx, String bosType, String billID) throws SQLException, BOSException {
		Boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append(" select 1");
		sql.append(" from ").append(EAS_TempRecord_tableName);// Eas������¼��
		sql.append(" where FBillID=? ");
		sql.append(" and FBosType=? ");
		ResultSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[] { billID, bosType });
		if (rs.next()) {
			result = true;
		}
		rs.close();
		return result;
	}

	/**
	 * �ж��Ƿ��Ѿ�����
	 * @param ctx
	 * @param tempBillId
	 * @return
	 * @throws SQLException
	 * @throws BOSException
	 */
	public static boolean checkHasImported(Context ctx, int tempBillId,String billType) throws SQLException, BOSException {
		Boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append(" select 1 from ").append(Temp_EASRecord_tableName);
		sql.append(" where ftempBillID='").append(tempBillId).append("'");
		sql.append(" and FBillType='").append(billType).append("'");
		ResultSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
		} catch (Exception e) {
			throw new BOSException(e);
		}
		if (rs.next()) {
			result = true;
		}
		rs.close();
		return result;

	}
	/**
	 * �ж��Ƿ��Ѿ��������϶�Ӧ��ϵ
	 * @param ctx
	 * @param easMaterialID
	 * @param storageUnitOrgID
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 */
	public static boolean checkHasMaterialRel(Context ctx,String easMaterialID,String storageUnitOrgID)  {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append(" select 1 from CT_EAS_BarMaterialRel where CFEasMaterialID='").append(easMaterialID).append("'");
		sql.append(" and CFStorageOrgUnitID='").append(storageUnitOrgID).append("'");
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				return true;
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * ����Ƿ��Ѿ�������temp�м��
	 * 
	 * @param ctx
	 * @param companyID
	 * @param number
	 * @return
	 * @throws SQLException
	 * @throws BOSException
	 */
	public static HashSet<String> getHasExportedIDs(Context ctx, String bosType) throws SQLException, BOSException {
		HashSet<String> set = new HashSet<String>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select FBillID");
		sql.append(" from ").append(EAS_TempRecord_tableName);
		sql.append(" where FBosType=?");
		ResultSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[] { bosType });
		while (rs.next()) {
			set.add(rs.getString("FBillID"));
		}
		rs.close();
		return set;
	}

	/**
	 * ����EAS���ݵ�����¼
	 * 
	 * @param ctx
	 * @param billType
	 *            ��������
	 * @param bosType
	 * @param billID
	 *            ����id
	 * @param billNumber
	 * @throws BOSException
	 */
	public static void insertHasExported(Context ctx, String billType, String bosType, String billID, String billNumber)
			throws BOSException {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(EAS_TempRecord_tableName).append("(");
		sql.append(" FOrgUnitID,FbillType,FBosType,FBillId,FBillNumber,FDate,FUserID");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,?,? ");
		sql.append(" )");
		DbUtil.execute(ctx, sql.toString(), new Object[] { ContextUtil.getCurrentOrgUnit(ctx).getId().toString(), billType,
				bosType, billID, billNumber, new java.sql.Timestamp(new java.util.Date().getTime()),
				ContextUtil.getCurrentUserInfo(ctx).getId().toString() });
	}

	/**
	 *����eas���ݼ�¼
	 * 
	 * @param ctx
	 * @param tempBillID
	 * @throws BOSException
	 */
	public static void insertHasImported(Context ctx,ArrayList<String> tempBillIDList,String billType) throws BOSException {
		for (String tempBillID : tempBillIDList) {
			StringBuffer sql = new StringBuffer();
			sql.append(" insert into ").append(Temp_EASRecord_tableName).append(" (");
			sql.append(" FTempBillID,FOrgUnitID,FUserID,FDate,FBillType");
			sql.append(" )values(");
			sql.append(" ?,?,?,?,? ");
			sql.append(")");
			DbUtil.execute(ctx, sql.toString(), new Object[] { tempBillID, ContextUtil.getCurrentOrgUnit(ctx).getId().toString(),
					ContextUtil.getCurrentUserInfo(ctx).getId().toString(),
					new java.sql.Timestamp(new java.util.Date().getTime()),billType });
		}
	}

	/**
	 * ����bareas���϶�Ӧ��ϵ
	 * 
	 * @param ctx
	 * @param easMaterialInfo
	 * @param storageOrgUnitInfo
	 * @return
	 * @throws BOSException
	 */
	public static String insertBarEASRel(Context ctx, MaterialInfo easMaterialInfo, StorageOrgUnitInfo storageOrgUnitInfo)
			throws BOSException {

		BarMaterialRelInfo relInfo = new BarMaterialRelInfo();
		String barMaterialNum = getBarMaterialNum(easMaterialInfo.getNumber());
		relInfo.setBarMaterialNum(barMaterialNum);
		relInfo.setEasMaterial(easMaterialInfo);
		relInfo.setEasMaterialName(easMaterialInfo.getName());
		relInfo.setStorageOrgUnit(storageOrgUnitInfo);
		try {
			IBarMaterialRel ibr = BarMaterialRelFactory.getLocalInstance(ctx);
			IObjectPK ipk = ibr.addnew(relInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOSException(e);
		}
		return barMaterialNum;
	}

	/**ͨ��eas��barmaterialnum���bar��materialnum
	 * 
	 * @param easMaterialnumber
	 * @return barMaterialNumber
	 */
	public static String getBarMaterialNum(String easMaterialnumber) {
		// TODO Auto-generated method stub
		String s = easMaterialnumber;
		s = s.replace("-", "");
		if (s.length() > 9) {
			// ����9λ��ȥ��9λ
			s = s.substring(s.length() - 9, s.length());
		}
		Long l = Long.parseLong(s);
		s = String.valueOf(l);
		return s;
	}

	/**
	 * ���Ĭ�ϲ������
	 * @param ctx
	 * @param materialID
	 * @param controlunitid
	 * @return
	 * @throws SQLException
	 */
	public static int getDefaultcfzl(Context ctx,String materialID,String controlunitid) throws SQLException{
		StringBuffer sql=new StringBuffer();
		sql.append(" select cfeachqty from T_BD_MaterialInventory");
		sql.append(" where FMaterialID='").append(materialID).append("'");
		sql.append(" and fcontrolunitid='").append(controlunitid).append("'");
		try {
			ResultSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				return rs.getInt("cfeachqty");
			}
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return 1000;
	}
	
	
	
	
	/**
	 * �õ���һ��
	 * 
	 * @param nowDate
	 * @return
	 */
	public static Date getNextDay(Date nowDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * �õ������ӿ�
	 * 
	 * @throws ClassNotFoundException
	 */
	public static EntityObjectInfo getEntityObjectInfo(String bosType) {
		IMetaDataLoader loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
		if (eo == null) {
			return null;
		}
		return eo;
	}

	/**
	 * �õ������ӿ�
	 * 
	 * @throws ClassNotFoundException
	 */
	public static ICoreBillBase getIInstance(Context ctx, String bosType) throws ClassNotFoundException {
		try {
			EntityObjectInfo eo = getEntityObjectInfo(bosType);
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBillBase iCoreBase = (ICoreBillBase) mtd.invoke(cls, new Object[] { ctx });
			return iCoreBase;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �õ������ӿ�
	 * 
	 * @throws ClassNotFoundException
	 */
	public static ICoreBase getIInstance2(String bosType) throws ClassNotFoundException {
		try {
			EntityObjectInfo eo = getEntityObjectInfo(bosType);
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getRemoteInstance");
			ICoreBase iCoreBase = (ICoreBase) mtd.invoke(cls);
			return iCoreBase;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ɹ�������
	 * 
	 * @throws BOSException
	 */
	public static CoreBaseInfo createToDestBill(Context ctx, CoreBillBaseCollection col, String orderBillBosType)
			throws BOSException {
		IObjectValue destBillInfo = null;
		ICoreBase iInstace = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		try {
			iInstace = getIInstance(ctx, orderBillBosType);
			btp = BTPManagerFactory.getLocalInstance(ctx);
			result = btp.transform(col, orderBillBosType);
			destBillInfo = result.getBills().getObject(0);

			iInstace.save((CoreBaseInfo) destBillInfo);
			btp.submitRelations(result.getBOTRelationCollection());
			return (CoreBaseInfo) destBillInfo;
		} catch (Exception e1) {
			throw new BOSException(e1.getMessage());
		}
	}

	/**
	 * ������־
	 * 
	 * @param ctx
	 * @param bosType
	 * @param isSuccess
	 * @param msg
	 * @throws BOSException
	 */
	public static void insertLogs(Context ctx, LogBean logBean) throws BOSException {
		
			if (logBean.getMsg() != null && logBean.getMsg().length() > 500) {
				logBean.setMsg(logBean.getMsg().substring(0, 499));
			}
			String result = "notSuccess";
			if (logBean.isSuccess) {
				result = "success";
			}
			StringBuffer sql = new StringBuffer();
			sql.append(" insert into CT_EAS_Logs (");
			sql.append(" FOrgUnitID,FBosType,FBillID,FTempID,FDirection,FIsSuccess,FMsg,FDate,FUserID");
			sql.append(" )values(");
			sql.append(" ?,?,?,?,?,?,?,?,?");
			sql.append(" )");
			String companyID = ContextUtil.getCurrentStorageUnit(ctx).getString("id");// �����֯
			
			
			DbUtil.execute(ctx, sql.toString(), new Object[] {logBean.getOrgUnitID(), logBean.getBosType(), logBean.getEasBillID(), logBean.getTempBillID(), logBean.getDirection(), result, logBean.getMsg(),
					new java.sql.Timestamp(new java.util.Date().getTime()),
					ContextUtil.getCurrentUserInfo(ctx).getId().toString() });
		
	}

	/**
	 * ���ݿ����֯ ������ID��ȡ ����Ĭ�ϲֿ�
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static WarehouseInfo getDefaultByMaterial(Context ctx, String storageOrgUnitID, String materialID)
			throws BOSException, EASBizException {
		try {
			IMaterialInventory is = null;
			if (ctx != null)
				is = MaterialInventoryFactory.getLocalInstance(ctx);
			else
				is = MaterialInventoryFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("material.id", materialID, CompareType.EQUALS));
			ev.setFilter(filter);
			MaterialInventoryCollection col = is.getMaterialInventoryCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("defaultWarehouse.*"));
				MaterialInventoryInfo info = is.getMaterialInventoryInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info.getDefaultWarehouse();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ݿ����֯ ������ID��ȡ Ĭ�ϲֿ�
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static Boolean getIsUseBatchByMaterial(Context ctx, String storageOrgUnitID, String materialID) throws BOSException,
			EASBizException {
		try {
			IMaterialInventory is = null;
			if (ctx != null)
				is = MaterialInventoryFactory.getLocalInstance(ctx);
			else
				is = MaterialInventoryFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("material.id", materialID, CompareType.EQUALS));
			ev.setFilter(filter);
			MaterialInventoryCollection col = is.getMaterialInventoryCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add("*");
				slr.add(new SelectorItemInfo("defaultWarehouse.*"));
				MaterialInventoryInfo info = is.getMaterialInventoryInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info.isIsLotNumber();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	
	/**
	 * ���ݿ����֯ ������ID��ȡ Ĭ�ϻػ��ϲֿ�
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static WarehouseInfo getBackDefaultByMaterial(Context ctx, String storageOrgUnitID, String materialID)
			throws BOSException, EASBizException {
		try {
			IBillDeafultSetting is = null;
			if (ctx != null)
				is = BillDeafultSettingFactory.getLocalInstance(ctx);
			else
				is = BillDeafultSettingFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			ev.setFilter(filter);
			BillDeafultSettingCollection col = is.getBillDeafultSettingCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("backWareHouse.*"));
				BillDeafultSettingInfo info = is.getBillDeafultSettingInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info.getBackWarehouse();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ͨ�������֯id��������õ����ϳ��� Ĭ�����ϲֿ�
	 * @param ctx
	 * @param storageorgunit
	 * @return
	 */
	public static WarehouseInfo getDefaultLLWareHouse(Context ctx,String storageOrgUnitID){
		try {
			IBillDeafultSetting is = null;
			if (ctx != null)
				is = BillDeafultSettingFactory.getLocalInstance(ctx);
			else
				is = BillDeafultSettingFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			ev.setFilter(filter);
			BillDeafultSettingCollection col = is.getBillDeafultSettingCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("llwarehouse.*"));
				BillDeafultSettingInfo info = is.getBillDeafultSettingInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info.getLLWarehouse();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * ͨ�������֯id��������õĲɹ���� Ĭ��ԭ�ϲֿ�
	 * @param ctx
	 * @param storageorgunit
	 * @return
	 */
	public static WarehouseInfo getDefaultYLWareHouse(Context ctx,String storageOrgUnitID){
		try {
			IBillDeafultSetting is = null;
			if (ctx != null)
				is = BillDeafultSettingFactory.getLocalInstance(ctx);
			else
				is = BillDeafultSettingFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			ev.setFilter(filter);
			BillDeafultSettingCollection col = is.getBillDeafultSettingCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("ylwarehouse.*"));
				BillDeafultSettingInfo info = is.getBillDeafultSettingInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info.getYLWarehouse();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ͨ�������֯id��������õ�������� Ĭ�ϳ�Ʒ�ֿ�
	 * @param ctx
	 * @param storageorgunit
	 * @return
	 */
	public static WarehouseInfo getDefaultCPWareHouse(Context ctx,String storageOrgUnitID){
		try {
			IBillDeafultSetting is = null;
			if (ctx != null)
				is = BillDeafultSettingFactory.getLocalInstance(ctx);
			else
				is = BillDeafultSettingFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			ev.setFilter(filter);
			BillDeafultSettingCollection col = is.getBillDeafultSettingCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("cpwarehouse.*"));
				BillDeafultSettingInfo info = is.getBillDeafultSettingInfo(new ObjectUuidPK(col.get(0).getString("id")), slr);
				return info.getCPWarehouse();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ���ݿ����֯ ��ȡĬ�ϵĳɱ����� ���� �������
	 * 
	 * @param ctx
	 * @param storageOrgUnitID
	 * @param materialID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static CostCenterOrgUnitInfo getMaterialReqDefaultCostCenter(Context ctx, String storageOrgUnitID)
			throws BOSException, EASBizException {
		try {
			IBillDeafultSetting is = null;
			if (ctx != null)
				is = BillDeafultSettingFactory.getLocalInstance(ctx);
			else
				is = BillDeafultSettingFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			ev.setFilter(filter);
			BillDeafultSettingCollection col = is.getBillDeafultSettingCollection(ev);
			if (col != null && col.size() > 0) {
				SelectorItemCollection slr = new SelectorItemCollection();
				slr.add(new SelectorItemInfo("*"));
				slr.add(new SelectorItemInfo("costCenterUnitOrg.*"));
				BillDeafultSettingInfo info = is.getBillDeafultSettingInfo(new ObjectUuidPK(col.get(0).getString("id")),slr);
				return info.getCostCenterUnitOrg();

			} else {
				return (CostCenterOrgUnitInfo) OrgCommonUtils.getOrgUnitInfo(ctx, storageOrgUnitID, OrgType.CostCenter, null);// ��ǰ�ĳɱ�����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ָ�� �������� ���õ����Ƶ�������
	 * 
	 * @param ctx
	 * @param srcBOSType
	 * @return
	 * @throws BOSException
	 * @throws BOTPException
	 */
	public static Map<String, EntityObjectInfo> getDestBostype(Context ctx, String srcBOSType) throws BOSException, BOTPException {

		HashMap<String, EntityObjectInfo> destEOI = new HashMap<String, EntityObjectInfo>();
		// ��̨��� �����ɵ�Ŀ�굥������
		IBOTMapping iBOTMapping = BOTMappingFactory.getLocalInstance(ctx);

		String targetTypeAndAliasString = iBOTMapping.getTargetBillTypeList(srcBOSType);
		if (StringUtils.isNotBlank(targetTypeAndAliasString)) {
			String[] targetTypeAndAlias = StringUtil.split(targetTypeAndAliasString, "|");

			String targetBillTypeString = targetTypeAndAlias[0];
			String targetAliasString = targetTypeAndAlias[1];

			String[] targetAlias = StringUtil.split(targetAliasString, ",");
			String[] targetBillType = StringUtil.split(targetBillTypeString, ",");
			// ���ѭ�� ���Ŀ�굥��eoi��result
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			for (int i = 0; i < targetBillType.length; i++) {
				String targetType = targetBillType[i];
				EntityObjectInfo tempObj = loader.getEntity(BOSObjectType.create(targetType));
				destEOI.put(targetType, tempObj);
			}

		}
		return destEOI;
	}

	/**
	 * ���ָ�� �������п��õ�botp �б�
	 * 
	 * @param ctx
	 * @param srcBillType
	 * @param targetBosType
	 * @param defineSys
	 * @param transmitContext
	 * @param srcBillIDs
	 * @param entrieNames
	 * @param entriesKeys
	 * @param botpSelectors
	 * @return
	 * @throws BOSException
	 * @throws BOTPException
	 */
	public BOTMappingCollection getAllCanUsedBots(Context ctx, String srcBillType, String[] srcBillIDs, String[] entryNames,
			List entriesKey, SelectorItemCollection botpSelectors) throws BOTPException, BOSException {
		if (botpSelectors == null) {
			botpSelectors = new SelectorItemCollection();
		}

		Map<String, EntityObjectInfo> destBosTypes = getDestBostype(ctx, srcBillType);

		BOTMappingCollection botColl = new BOTMappingCollection();

		OrgUnitInfo orgUnit = ContextUtil.getCurrentCtrlUnit(ctx);
		Map transmitContext = new HashMap();
		transmitContext.put("TRANSMITCU", orgUnit);
		// ���Ŀ�굥������ ��ö�Ӧ������ת������
		if (destBosTypes.size() > 0) {
			Set<String> keySet = destBosTypes.keySet();
			Iterator<String> keyIte = keySet.iterator();

			IBOTMapping botMapping = BOTMappingFactory.getLocalInstance(ctx);
			while (keyIte.hasNext()) {
				// Ŀ�굥��bostype
				String destBOSType = keyIte.next();

				BOTMappingCollection botMappingCols = botMapping.getMappingCollectionForSelectUseRuleFilter(srcBillType,
						destBOSType, DefineSysEnum.BTP, transmitContext, srcBillIDs, entryNames, entriesKey, botpSelectors);
				// ��ӵ��������
				botColl.addCollection(botMappingCols);
			}
		}
		// String targetBosType
		// DefineSysEnum.BTP,

		return botColl;

	}

	/**
	 * ��������id��ȡ�ɱ�����
	 * 
	 * @param ctx
	 * @param mateiralID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static CostObjectInfo getCostObjectByMaterialID(Context ctx, String companyID, String materialID) throws BOSException,
			EASBizException {
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id", companyID, CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("relatedId", materialID, CompareType.EQUALS));
		ev.setFilter(filter);
		ICostObject is = CostObjectFactory.getLocalInstance(ctx);
		ObjectBaseCollection col = is.getObjectBaseCollection(ev);
		if (col != null && col.size() > 0) {
			return is.getCostObjectInfo(new ObjectUuidPK(col.get(0).getId()));
		}
		return null;
	}

	/**
	 * ���ݿ����֯�õ�������
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static int getBzqByMaterial(Context ctx, String storageOrgUnitID, String materialID) {
		try {
			IMaterialInventory is = null;
			if (ctx != null)
				is = MaterialInventoryFactory.getLocalInstance(ctx);
			else
				is = MaterialInventoryFactory.getRemoteInstance();
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", storageOrgUnitID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("material.id", materialID, CompareType.EQUALS));
			ev.setFilter(filter);
			MaterialInventoryCollection col = is.getMaterialInventoryCollection(ev);
			if (col != null && col.size() > 0) {
				return is.getMaterialInventoryInfo(new ObjectUuidPK(col.get(0).getString("id"))).getPeriodValid();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * ͨ���������ϱ����ö�Ӧ��EAS���ϱ���
	 * 
	 * @param ctx
	 * @param barMaterialNumber
	 * @return
	 * @throws EASBizException
	 * @author yumingxu
	 */
	public static String getEASMaterialNumber(Context ctx, String barMaterialNumber) throws EASBizException {
		// TODO Auto-generated method stub
		String easMaterialNumber = "";
		StringBuffer sql = new StringBuffer();
		sql.append("select fnumber from T_BD_Material where fid=(select CFEasMaterialID from CT_EAS_BarMaterialRel where CFBarMaterialNum='");
		sql.append(barMaterialNumber);
		sql.append("'");
		sql.append(" and (FNotMainUsed=0 or FNotMainUsed is null)");//��Ҫʹ�� add@20160406 by dai ���ڶ����϶�Ӧһ�����ϵ����
		sql.append(" )");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if (rs.next()) {
				easMaterialNumber = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("006", "sqlִ���쳣" + e.getMessage()));
		}
		return easMaterialNumber;
	}

	/**
	 * ͨ��EAS����ID��ö�Ӧ���������ϱ���
	 * 
	 * @param ctx
	 * @param EASMaterialID
	 * @return
	 * @throws EASBizException
	 */
	public static String getBarMaterialNumber(Context ctx, MaterialInfo materialInfo, StorageOrgUnitInfo storageOrgUnitInfo)
			throws EASBizException {
		// TODO Auto-generated method stub
		String BarMaterialNumber = "";
		StringBuffer sql = new StringBuffer();
		sql.append(" select CFBarMaterialNum from CT_EAS_BarMaterialRel bm ");
		sql.append(" inner join T_BD_Material m on bm.CFEasMaterialID = m.fid ");
		sql.append(" where m.fnumber='");
		sql.append(materialInfo.getNumber());
		sql.append("'");
		sql.append(" and CFStorageOrgUnitID='").append(storageOrgUnitInfo.getId().toString());
		sql.append("'");

		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if (rs.next()) {
				BarMaterialNumber = rs.getString(1);
			} else {
				// ������ص���û�й�ϵ������Ҫ��insert ��ϵ
				BarMaterialNumber = EASWUtils.insertBarEASRel(ctx, materialInfo, storageOrgUnitInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("006", "ִ���쳣" + e.getMessage()));
		}

		return BarMaterialNumber;
	}

	/**
	 * bom��¼�Ƿ��뵽����ϵͳ
	 * 
	 * @param ctx
	 * @param bomEntryID
	 * @return
	 * @throws EASBizException
	 */
	public static boolean isExportToMuyang(Context ctx, String bomEntryID) throws EASBizException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select cfisexporttomuyang from t_mm_bomentry where fid='");
		sql.append(bomEntryID).append("'");
		boolean result = false;
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if (rs.next()) {
				result = rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("006", "ִ���쳣" + e.getMessage()));
		}
		return result;
	}

	/**
	 * �ж�bom��¼�����ϲ�����
	 * 
	 * @param ctx
	 * @param string
	 * @return
	 * @throws EASBizException
	 */
	public static boolean isNotExport(Context ctx, String bomEntryID) throws EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append(" select cfisnotbom from t_mm_bomentry where fid='");
		sql.append(bomEntryID).append("'");
		boolean result = false;
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if (rs.next()) {
				result = rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("006", "ִ���쳣" + e.getMessage()));
		}
		return result;
	}
}
