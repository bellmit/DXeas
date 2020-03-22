package com.kingdee.eas.custom.eas2wincos.comm;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.org.StorageOrgUnitCollection;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class EASWUtils {
	public final static String WinCos_EASRecord_tableName="t_eas_importBillRecord";//wincos导入eas记录表 存于中间库中
	public final static String EAS_WinCosRecord_tableName="t_wincos_exportBillRecord";//eas导入win记录表 存于eas中
	public final static String Direction_Export="export";
	public final static String Direction_Import="import";
	/**
	 * 根据公司编码获取公司id
	 * @param ctx
	 * @param companyNum
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static String getCompanyIDByNumber(Context ctx,String companyNum) throws EASBizException, BOSException {
		String result=null;
		if(!StringUtils.isBlank(companyNum)){
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("number",companyNum,CompareType.EQUALS));
			ev.setFilter(filter);
			StorageOrgUnitCollection col = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitCollection(ev);
			if(col!=null&&col.size()>0) {
				result=col.get(0).getString("id");
			}
		}
		return result;
	}
	
	/**
	 * 得到 wincos 中间库连接信息
	 * @param ctx
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws BOSException 
	 */
	public static Connection getWinCosConnection(Context ctx,String companyID) throws Exception {
		String dbIP="",dbName="",dbPort="",userName="",password="";
		StringBuffer sql=new StringBuffer();
		sql.append(" select * ");
		sql.append(" from CT_EAS_DataBaseSetting ");
		sql.append(" where CFCompanyIDID=?");
		IRowSet rs=null;
		if(ctx!=null)
			rs=DbUtil.executeQuery(ctx, sql.toString(), new Object[]{companyID}); 
		else
			System.out.println("not exist");
		if(rs!=null&&rs.next()) {
			dbIP=rs.getString("CFDbIP");
			dbPort=rs.getString("CFDbPort");
			dbName=rs.getString("CFDbName");
			userName=rs.getString("CFUserName");
			password=rs.getString("CFPassword");;
		}else{
			return null;
		}
		rs.close();
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		String url="jdbc:sqlserver://"+dbIP+":"+dbPort+";DatabaseName="+dbName;  //mydb为数据库  
		Connection conn = DriverManager.getConnection(url,userName,password);
		return conn;
	}
	/**
	 * 检查是否已经导出到wincos
	 * 
	 * @param ctx
	 * @param companyID
	 * @param number
	 * @return
	 * @throws SQLException
	 * @throws BOSException 
	 */
	public static boolean checkHasExported(Context ctx, String bosType, String billID,String entryID) throws SQLException, BOSException {
		Boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append(" select FUserID");
		sql.append(" from ").append(EAS_WinCosRecord_tableName);
		sql.append(" where FBillID=? and FEntryID=?");
		sql.append(" and FBosType=?");
		ResultSet rs = DbUtil.executeQuery(ctx, sql.toString(),new Object[]{billID,entryID,bosType});
		if (rs.next()) {
			result = true;
		}
		rs.close();
		return result;
	}
	
	/**
	 * 检查是否已经导出到wincos
	 * 
	 * @param ctx
	 * @param companyID
	 * @param number
	 * @return
	 * @throws SQLException
	 * @throws BOSException 
	 */
	public static HashSet<String> getHasExportedIDs(Context ctx, String bosType)		throws SQLException, BOSException {
		HashSet<String> set=new HashSet<String>();
		StringBuffer sql = new StringBuffer();
		sql.append(" select FBillID");
		sql.append(" from ").append(EAS_WinCosRecord_tableName);
		sql.append(" where FBosType=?");
		ResultSet rs = DbUtil.executeQuery(ctx, sql.toString(),new Object[]{bosType});
		while (rs.next()) {
			set.add(rs.getString("FBillID"));
		}
		rs.close();
		return set;
	}
	
	/**
	 * 插入EAS单据导出记录
	 * @param ctx
	 * @param bosType
	 * @param billID
	 * @param entryID
	 * @throws BOSException 
	 */
	public static void insertHasExported(Context ctx,String bosType,String billID,String entryID) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into").append(EAS_WinCosRecord_tableName).append("(");
		sql.append(" FBosType,FBillID,FEntryID,FDate,FUserID");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?");
		sql.append(" )");
		DbUtil.execute(ctx, sql.toString(),new Object[]{bosType,billID,entryID,new java.util.Date(),ContextUtil.getCurrentUserInfo(ctx).getId().toString()});
 	}
	
	/**
	 * 插入导入记录
	 * @param ctx
	 * @param easBillID
	 * @param winCosBillNum
	 * @throws SQLException 
	 */
	protected void updateImportRecord(Connection conn,String easBillID,ArrayList<String> winCosBillList) throws SQLException {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(WinCos_EASRecord_tableName).append(" (");
		sql.append(" FEasBillID,FWinCosBillID,FWinCosBillNum,FDate");
		sql.append(" )values(");
		sql.append(" ?,?,?,?");
		sql.append(" )");
		PreparedStatement ptm = conn.prepareStatement(sql.toString());
		java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
		for(String number:winCosBillList) {
			ptm.setString(1, easBillID);
			ptm.setInt(2,0 );
			ptm.setString(3, number);
			ptm.setDate(4, date);
			ptm.execute();
		}
	}
	
	/**
	 * 得到下一天
	 * @param nowDate
	 * @return
	 */
	public static Date getNextDay(Date nowDate) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(nowDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	/**
	 * 得到工厂接口
	 * @throws ClassNotFoundException 
	 */
	public static EntityObjectInfo getEntityObjectInfo(String bosType)  {
			IMetaDataLoader loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
			if (eo == null) {
				return null;
			}
			return eo;
		}
	/**
	 * 得到工厂接口
	 * @throws ClassNotFoundException 
	 */
	public static ICoreBillBase getIInstance(String bosType) throws ClassNotFoundException {
		try {
			EntityObjectInfo eo =getEntityObjectInfo(bosType);
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBillBase iCoreBase = (ICoreBillBase) mtd.invoke(cls);
			return iCoreBase;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到工厂接口
	 * @throws ClassNotFoundException 
	 */
	public static ICoreBase getIInstance2(String bosType) throws ClassNotFoundException {
		try {
			EntityObjectInfo eo =getEntityObjectInfo(bosType);
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBase iCoreBase = (ICoreBase) mtd.invoke(cls);
			return iCoreBase;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 生成关联单据
	 * 
	 * @throws BOSException
	 */
	public static String createToDestBill(Context ctx, CoreBillBaseCollection col, String orderBillBosType) throws BOSException {
		IObjectValue destBillInfo = null; 
		ICoreBase iInstace = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		try {
			iInstace=getIInstance(orderBillBosType);
			btp = BTPManagerFactory.getLocalInstance(ctx);
			result = btp.transform(col, orderBillBosType);
			destBillInfo = result.getBills().getObject(0);
			try {// 
				iInstace.save((CoreBaseInfo) destBillInfo);
				btp.submitRelations(result.getBOTRelationCollection());
				return destBillInfo.getString("id");
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {
			throw new BOSException(e1.getMessage());
		}
	}
	/**
	 * 插入日志
	 * @param ctx
	 * @param bosType
	 * @param isSuccess
	 * @param msg
	 * @throws BOSException 
	 */
	public static void insertLogs(Context ctx,String bosType,String easBillID,int winCosID,String direction,boolean isSuccess,String msg) throws BOSException {
		if(msg!=null&&msg.length()>500) {
			msg=msg.substring(0, 490);
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into t_wincos_importLogs (");
		sql.append(" FBosType,FBillID,FWinCosID,FDirection,FIsSuccess,FMsg,FDate,FUserID");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,?,?,?");
		sql.append(" )");
		DbUtil.execute(ctx, sql.toString(),new Object[]{bosType,easBillID,winCosID,direction,isSuccess,msg,new java.sql.Timestamp(new java.util.Date().getTime()),ContextUtil.getCurrentUserInfo(ctx).getId().toString()});
	}
	
}
