package com.kingdee.eas.custom.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlDynamicBillUtils;
import com.kingdee.eas.custom.workflow.app.WSWorkFlowDADFacadeControllerBean;
import com.kingdee.eas.scm.im.inv.IPurInWarehsBill;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillEntryInfo;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillFactory;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillEntryInfo;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillCollection;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillFactory;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillInfo;
import com.kingdee.eas.scm.im.inv.PurInWarehsEntryInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class testFacadeControllerBean extends AbstracttestFacadeControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.app.testFacadeControllerBean");

	@Override
	protected Object _getTest(Context ctx, Object params) throws BOSException {
//		String jsonStr=LoadingBillFacadeFactory.getLocalInstance(ctx).downloadData("{\"billNumber\":\"SO-4-201712-0524\"}");
//		String jsonStr=
//		"{\"customerName\":\"临沂泰荷公司\",\"customerNum\":\"000001\",\"billNumber\":\"SO-11-201711-0003\",\"billID\":\"E3sAAAABmijEikI6\",\"entrys\":[{\"materialName\":\"鲜M翅根\",\"model\":\"10*1\",\"unitName\":\"公斤（千克）\",\"materialID\":\"E3sAAAAAs/FECefw\",\"qty\":\"99\",\"materialNum\":\"01-000011\",\"entrySeq\":\"1\",\"entryID\":\"E3sAAAABmimIiCpY\"},{\"materialName\":\"鲜M翅根\",\"model\":\"10*1\",\"unitName\":\"公斤（千克）\",\"materialID\":\"E3sAAAAAs/FECefw\",\"qty\":\"88\",\"materialNum\":\"01-000011\",\"entrySeq\":\"2\",\"entryID\":\"E3sAAAAB1MOIiCpY\"}],\"bizDate\":\"2017-11-01\"}";
//		LoadingBillFacadeFactory.getLocalInstance(ctx).uploadData(jsonStr);
//		String jsonStr="{\"userNum\":\"user\",\"beginDate\":\"2017-11-01\",\"endDate\":\"2017-11-30\",\"isNeedSum\":\"true\"}";
//		String jsonStr="{\"saleOrderID\":\"E3sAAAAC9d3EikI6\"}";
//		try {
//			jsonStr=LoadingBillFacadeFactory.getLocalInstance(ctx).create2SaleIssure(jsonStr);
//		} catch (EASBizException e) {
//			e.printStackTrace();
//		}
		String jsonStr="success";
		/*try {
			JSONObject json=new JSONObject();
			json.put("number", "test171224");
			json.put("bizDate", "2017-12-24");
			json.put("billStatus", "2");
			json.put("company", "11");
			JSONArray ja=new JSONArray();
			JSONObject jo=new JSONObject();
			jo.put("material", "E3sAAAAAtUFECefw");
			ja.add(jo);
			json.put("Entry", ja);
			new WSWorkFlowDADFacadeControllerBean().uploadDataByBosType(ctx, "BEDBE401", json.toString());
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr=e.getMessage();
		}*/
		try {
			jsonStr=new WlhlDynamicBillUtils().getDataByID(ctx, "E3sAAAAOEsr9+vd1",null);
		} catch (EASBizException e) {
			jsonStr=e.getMessage();
		}
		return jsonStr;
	}

	public final static String WinCos_PurInwarehs_TableName = "ERPRawMaterialReceival";// 采购入库单table
	public final static String WinCos_MaterialReq_TableName = "ERPProdReportConsumption";// 领料出库单table
	public final static String WinCos_ProductIn_TableName = "ERPProdReportFinished";//生产入库单table
	public final static String WinCos_EASRecord_tableName="t_eas_importBillRecord";//wincos导入eas记录表 存于中间库中
	/**
	 * 导出单据到wincos
	 */
	protected String _exportBill(Context ctx, int opType,String jsonStr) throws BOSException {
		// TODO Auto-generated method stub
		/*if (StringUtils.isBlank(jsonStr)) {
			return null;
		}
		try {
			JSONObject jo = new JSONObject(jsonStr);
			if (jo.isNull("billType")) {// 单据类型为空

			}
			int billType = 0;
			switch (billType) {
			case 1:
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}*/
		return "成功";
	}

	/**
	 * 得到单据列表
	 * @param ctx
	 * @param companyID
	 * @return
	 */
	protected ArrayList<String> getPurInwarrehouseEntryIDsList(Context  ctx,String companyID) {
		StringBuffer sql=new StringBuffer();
		sql.append(" select * from ");
		return null;
	}
	
	/*
	 * 8 导出采购入库单
	 */
	protected void exportPurInwarehouseBill(Context ctx, String companyID) throws BOSException, EASBizException {
		Connection conn = null;
		try {
			IPurInWarehsBill ips = PurInWarehsBillFactory.getLocalInstance(ctx);
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("CU.id", companyID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("bizDate", new java.util.Date(), CompareType.EQUALS));
			// filter.getFilterItems().add(new
			// FilterItemInfo("CU.id",companyID,CompareType.EQUALS));
			ev.setFilter(filter);
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("bizDate"));
			ev.setSorter(sorter);
			PurInWarehsBillCollection coll = ips.getPurInWarehsBillCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return;
			}
			conn= getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			conn.setAutoCommit(false);
			//执行插入的预编译方法
			PreparedStatement ptm = conn.prepareStatement(getInsertPurInwarhsBillStr());
			PurInWarehsBillInfo purInfo;
			PurInWarehsEntryInfo purEntryInfo;
			
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("entry"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			
			for (int index = 0; index < coll.size(); index++) {
				purInfo = ips.getPurInWarehsBillInfo(new ObjectUuidPK(coll.get(index).getString("id")),slor);
				// 已经导入不再重新导入
				for(int j=0;j<purInfo.getEntry().size();j++) {
					purEntryInfo=purInfo.getEntry().get(j);
					if (checkHasExported(conn, WinCos_PurInwarehs_TableName, purInfo.getId().toString(),purEntryInfo.getId().toString())) {
						continue;
					}
					ptm.setString(1, purEntryInfo.getMaterial().getNumber());
					ptm.setString(2, purEntryInfo.getMaterial().getName());
					ptm.setString(3, purEntryInfo.getLot());
					ptm.setDate(4, null);
					ptm.setInt(5, 0);
					ptm.setBigDecimal(6, purEntryInfo.getQty());
					ptm.setBigDecimal(7, purEntryInfo.getBaseQty());
					ptm.setString(8, purInfo.getSupplier().getNumber());
					ptm.setString(9, purInfo.getSupplier().getName());
					ptm.setInt(10, 0);
					ptm.setBoolean(11, false);
					ptm.setString(12,purInfo.getId().toString()); 
					ptm.setString(13, purEntryInfo.getId().toString());
					ptm.execute();
					conn.commit();
				}
			}
			ptm.close();
		} catch (Exception e) {
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		}
		finally{
			try {
				if(conn!=null&&!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 执行插入入库过榜单
	 * @param conn
	 * @throws Exception 
	 */
	private String getInsertPurInwarhsBillStr() {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(WinCos_PurInwarehs_TableName).append(" (");
		sql.append(" ProductIdent,ProductName,LotIdent,ProductBestBeforeDate,PackingType,");
		sql.append(" PackSize,WeightTarget,SupplierIdent,SupplierName,State,");
		sql.append(" Location,AppString02,AppString03");
		sql.append(" )values( ");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?");
		sql.append(" )");
		return sql.toString();
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
		sql.append(" from ");
		sql.append(" where FCompanyID=?");
		IRowSet rs=DbUtil.executeQuery(ctx, sql.toString(), new Object[]{companyID});
		if(rs.next()) {
			dbIP=rs.getString("");
			dbName=rs.getString("");
			dbPort=rs.getString("");
		}else{
			return null;
		}
		rs.close();
		
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();  
		String url="jdbc:microsoft:sqlserver://"+dbIP+":"+dbPort+";DatabaseName="+dbName;  //mydb为数据库  
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
	 */
	protected static boolean checkHasExported(Connection conn, String tableName, String billID,String entryID)
			throws SQLException {
		Boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append(" select OID");
		sql.append(" from ").append(tableName);
		sql.append(" where AppString02='").append(billID).append("',");
		sql.append(" and AppString03='").append(entryID).append("',");
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql.toString());
		if (rs.next()) {
			result = true;
		}
		rs.close();
		stm.close();
		return result;
	}

	/**
	 * 导入单据到EAS
	 */
	protected String _importBill(Context ctx, String jsonStr) throws BOSException {
		// TODO Auto-generated method stub
		/*if (StringUtils.isBlank(jsonStr)) {
			return null;
		}
		try {
			JSONObject jo = new JSONObject(jsonStr);
			if (jo.isNull("billType")) {// 单据类型为空

			}
			int billType = 0;
			switch (billType) {
			case 1:
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}*/
		return "成功";
	}
	/**
	 * 导入领料出库单
	 * @param ctx
	 * @param companyID
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected void importMaterialReqBill(Context ctx, String companyID) throws BOSException, EASBizException {
		Connection conn = null;
		try {
			conn= getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
			Date nowDate=new java.util.Date();
			String nowBeginDateStr=fmt.format(nowDate);
			String nowEndDateStr=fmt.format(getNextDay(nowDate));
			
			StringBuffer sql=new StringBuffer();
			sql.append(" select ");
			sql.append(" OID,ProdReport,");
			sql.append(" ProcessOrde-rIdent,JobIdent,ProductIdent,LotIdent,WeightActu-alConsumed,");
			sql.append(" LocationID");
			sql.append(" from").append(WinCos_MaterialReq_TableName);
			sql.append(" where 1=1 ");
			sql.append(" and CreationDate>='").append(nowBeginDateStr).append(" 00:00:00");
			sql.append(" and CreationDate<='").append(nowEndDateStr).append(" 00:00:00");
			sql.append(" and ( AppString03 is  null or AppString03='')");
			/*sql.append(" and ProcessOrde-rIdent not in(");//在中间库新增导入记录表
			sql.append(" select distinct FWinCosBillNum from ").append(WinCos_EASRecord_tableName);
			sql.append(" where FWinCosBillType=1");
			sql.append(" )");*/
			sql.append(" order by ProcessOrde-rIdent asc");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			ArrayList<String> winCosBillNumList=new ArrayList<String>();
			MaterialReqBillInfo info=null;
			String materialNum;
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);		
			MaterialCollection mColl;
			MaterialInfo mInfo;
			EntityViewInfo ev;
			FilterInfo filter;
			while(rs.next()) {
				winCosBillNumList.add(rs.getString("ProcessOrde-rIdent"));
				if(info==null) {
					info=new MaterialReqBillInfo();
					info.setBizDate(new java.util.Date());
					
				}
				MaterialReqBillEntryInfo entryInfo=new MaterialReqBillEntryInfo();
				materialNum=rs.getString("ProductIdent");
				ev=new EntityViewInfo();
				filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("number",materialNum,CompareType.EQUALS));
				ev.setFilter(filter);
				mColl=ims.getMaterialCollection(ev);//根据物料编码获取物料
				if(mColl!=null&&mColl.size()>0) {
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(mColl.get(0).getString("id")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setBaseUnit(mInfo.getBaseUnit());
				}
				entryInfo.setLot(rs.getString("LotIdent"));
				entryInfo.setQty(rs.getBigDecimal("WeightActu-alConsumed"));
				entryInfo.setWarehouse(null);//仓库 
				info.getEntry().add(entryInfo);
			}
			rs.close();
			if(info!=null) {
				IObjectPK pk = MaterialReqBillFactory.getLocalInstance(ctx).addnew(info);
				try {//反写出错则删除单据
					reWriteImportBillStatus(conn, WinCos_MaterialReq_TableName, pk.toString(), winCosBillNumList);//反写单据导入状态
				}catch(Exception e) {
					if(pk!=null) {
						MaterialReqBillFactory.getLocalInstance(ctx).delete(pk);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		}
		finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	 * 反写导入状态
	 * @param conn
	 * @param easBillID
	 * @param winCosBillNum
	 * @throws SQLException 
	 */
	protected void reWriteImportBillStatus(Connection conn,String tableName,String easBillID,ArrayList<String> winCosBillNum) throws SQLException {
		String billNumbers="";
		for(String number:winCosBillNum) {
			if(billNumbers.length()>0) {
				billNumbers+=",";
			}
			billNumbers=billNumbers+"'"+number+"'";
		}
		if(StringUtils.isBlank(billNumbers)) {
			return;
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update ").append(tableName);
		sql.append(" set AppString03='").append(easBillID).append("'");
		sql.append(" where ProcessOrde-rIdent in (").append(billNumbers).append(")");
		Statement stm = conn.createStatement();
		stm.execute(sql.toString());
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
	 * 导入生产入库单
	 * @param ctx
	 * @param companyID
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected void importProductInBill(Context ctx, String companyID) throws BOSException, EASBizException {
		Connection conn = null;
		try {
			conn= getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
			Date nowDate=new java.util.Date();
			String nowBeginDateStr=fmt.format(nowDate);
			String nowEndDateStr=fmt.format(getNextDay(nowDate));
			
			StringBuffer sql=new StringBuffer();
			sql.append(" select ");
			sql.append(" OID,ProdReport,");
			sql.append(" ProcessOrde-rIdent,JobIdent,ProductIdent,LotIdent,WeightActu-alConsumed,");
			sql.append(" LocationID");
			sql.append(" from").append(WinCos_MaterialReq_TableName);
			sql.append(" where 1=1 ");
			sql.append(" and CreationDate>='").append(nowBeginDateStr).append(" 00:00:00");
			sql.append(" and CreationDate<='").append(nowEndDateStr).append(" 00:00:00");
			sql.append(" and ( AppString03 is  null or AppString03='')");
			/*sql.append(" and ProcessOrde-rIdent not in(");//在中间库新增导入记录表
			sql.append(" select distinct FWinCosBillNum from ").append(WinCos_EASRecord_tableName);
			sql.append(" where FWinCosBillType=1");
			sql.append(" )");*/
			sql.append(" order by ProcessOrde-rIdent asc");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			ArrayList<String> winCosBillNumList=new ArrayList<String>();
			ManufactureRecBillInfo info=null;
			String materialNum;
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);		
			MaterialCollection mColl;
			MaterialInfo mInfo;
			EntityViewInfo ev;
			FilterInfo filter;
			while(rs.next()) {
				winCosBillNumList.add(rs.getString("ProcessOrde-rIdent"));
				if(info==null) {
					info=new ManufactureRecBillInfo();
					info.setBizDate(new java.util.Date());
					
				}
				ManufactureRecBillEntryInfo entryInfo=new ManufactureRecBillEntryInfo();
				materialNum=rs.getString("ProductIdent");
				ev=new EntityViewInfo();
				filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("number",materialNum,CompareType.EQUALS));
				ev.setFilter(filter);
				mColl=ims.getMaterialCollection(ev);//根据物料编码获取物料
				if(mColl!=null&&mColl.size()>0) {
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(mColl.get(0).getString("id")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setBaseUnit(mInfo.getBaseUnit());
				}
				entryInfo.setLot(rs.getString("LotIdent"));
				entryInfo.setQty(rs.getBigDecimal("WeightActu-alConsumed"));
				entryInfo.setWarehouse(null);//仓库 
				info.getEntry().add(entryInfo);
			}
			rs.close();
			if(info!=null) {
				IObjectPK pk = ManufactureRecBillFactory.getLocalInstance(ctx).addnew(info);
				try {//反写出错则删除单据
					reWriteImportBillStatus(conn, WinCos_MaterialReq_TableName, pk.toString(), winCosBillNumList);//反写单据导入状态
				}catch(Exception e) {
					if(pk!=null) {
						ManufactureRecBillFactory.getLocalInstance(ctx).delete(pk);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		}
		finally {
			try {
				if(conn!=null&&!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}