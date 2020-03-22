package com.kingdee.eas.custom.eas2temp.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFacade;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.custom.eas2temp.comm.TempUtils;
import com.kingdee.eas.mm.basedata.BomCollection;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.IBom;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * BOM导出
 * 
 * @author chuanyin
 * +
 */
public class ExportBOM implements IExport2Temp {

	
	public String export2TempByID(Context ctx, String companyID, String billID) throws EASBizException {
		Connection conn = null;
		Boolean isSuccess = false;
		String msg = null;
		BomInfo bomInfo = null;
		BomEntryInfo bomEntryInfo;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.MUYANGSYSTEM_VALUE);// 获得中控系统连接
			if (conn == null) {
				throw new Exception("请确认中控系统参数设置正确");
			}
			
			conn.setAutoCommit(false);
			// 执行插入的预编译方法
			PreparedStatement ptm = null;
			try {

				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("material.*"));
				slor.add(new SelectorItemInfo("entrys.*"));
				slor.add(new SelectorItemInfo("entrys.material.*"));
				IBom ips = null;
				if(ctx!=null){
					ips=BomFactory.getLocalInstance(ctx);
				}else{
					ips=BomFactory.getRemoteInstance();
				}
				
				bomInfo = ips.getBomInfo(new ObjectUuidPK(billID), slor);
				String companyNum=bomInfo.getStorageOrgUnit().getNumber();
				
				//conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.MUYANGSYSTEM_VALUE);// 获得車間2连接
				if (conn == null) {
					throw new Exception("请确认连接参数设置正确");
				}
				conn.setAutoCommit(false);
				// 执行插入的预编译方法
				
				//int materialID=TempUtils.returnTempMaterialID(ctx, conn, bomInfo.getMaterial(),"成品");//父项物料编码
				String userName="";
				if(ctx==null) {
					userName=SysContext.getSysContext().getCurrentUserInfo().getName();
				}else{
					userName=ContextUtil.getCurrentUserInfo(ctx).getName();
				}
				
				//String tempBomID=TempUtils.returnTempBOMID(conn, billID);
				String tempBomID=TempUtils.returnTempBOMID(conn, bomInfo.getNumber());
				//如果bom已经导入过
				if(tempBomID.equals("")) {
					//插入表头
					ptm=conn.prepareStatement(getInsertHeadSql());
					System.out.println("++++++++add+++++++");
				}else {
					//删掉分录
					ptm=conn.prepareStatement("delete from t_bomEntry where recipeNum='"+tempBomID+"'");
					ptm.execute();
					conn.commit();
					ptm.close();
					//更新表头
					ptm=conn.prepareStatement(getUpdateHeadSql(tempBomID));
					System.out.println("++++++++update+++++++");
				}
				
				
				
				isSuccess = true;
				// 插入一条单据
				// 中控系统的插入
				// 这里插入表头
				StorageOrgUnitInfo storageOrgUnitInfo=bomInfo.getStorageOrgUnit();
				MaterialInfo minfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(bomInfo.getMaterial().getId().toString()));
				//String barMaterialNum=EASWUtils.getBarMaterialNumber(ctx, bomInfo.getMaterial(),storageOrgUnitInfo);//父项物料编码
				MeasureUnitInfo measinfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(bomInfo.getUnit().getId().toString())); 
				Date date = new Date();
				java.sql.Date date1=new java.sql.Date(date.getTime()); 
				//ptm = conn.prepareStatement(getInsertHeadSql());
				//ptm.setString(1, bomInfo.getId().toString());// 配方识别码
				ptm.setString(1, bomInfo.getNumber());// 配方识别码
				ptm.setString(2, minfo.getNumber());// 产品编号
				ptm.setString(3, bomInfo.getNumber());// 配方号
				ptm.setString(4, bomInfo.getName());//配方名
				ptm.setString(5, "V1.0");// 配方版本
				ptm.setString(6, measinfo.getName());//计量单位
				ptm.setBigDecimal(7,bomInfo.getProductQty() );//配方数量
				ptm.setBigDecimal(8,bomInfo.getProductBaseQty());//配方基数
				ptm.setDate(9,date1);//创建时间
				ptm.setString(10,bomInfo.getCreator().getName());// 创建人

				
				ptm.execute();
				ptm.close();
				String upsql = "update T_MM_Bom set cfisimbom = 1  where fid = '"+billID+"'";
				DbUtil.execute(ctx,upsql);	
				System.out.println("####################"+bomInfo.getName()+"已成功导出");
						 
				ArrayList<String> list=new ArrayList<String>();
				//String tempMaterialNum;
				// 这里导入分录
				int entryCount=bomInfo.getEntrys().size();
				BigDecimal RGCLqty = BigDecimal.ZERO;
				for (int j = 0; j < entryCount-1; j++) {
					bomEntryInfo = bomInfo.getEntrys().get(j);
					
					if(EASWUtils.isNotExport(ctx,bomEntryInfo.getId().toString())){
						continue;
					}
					//tempMaterialNum=EASWUtils.getBarMaterialNumber(ctx ,bomEntryInfo.getMaterial(),storageOrgUnitInfo);
					//list.add(tempMaterialNum);
					MaterialInfo minfoe = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(bomEntryInfo.getMaterial().getId().toString()));

					
					MeasureUnitInfo measinfoe = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(bomEntryInfo.getUnit().getId().toString())); 

					ptm = conn.prepareStatement(getInsertEntrySql());// 插入表体
					
					
					//ptm.setString(1, bomInfo.getId().toString());// 配方识别码
					ptm.setString(1, bomInfo.getNumber());// 配方识别码
					ptm.setString(2, minfoe.getNumber());// 原料编码
					ptm.setString(3, measinfoe.getName() );//计量单位
					BigDecimal rel = new BigDecimal(1000);
					BigDecimal pb = (bomEntryInfo.getConsumeFixQty().multiply(rel)).divide(bomInfo.getProductQty(),4,BigDecimal.ROUND_HALF_UP);
					ptm.setBigDecimal(4, bomEntryInfo.getConsumeFixQty());// 原料数量
					ptm.setBoolean(5, bomEntryInfo.getBoolean("iswt"));// 是否外投						
					ptm.execute();
					ptm.close();
					}	
				conn.commit();
				// 在eas中插入导出记录
				//EASWUtils.insertHasExported(ctx, "BOM", bomInfo.getBOSType().toString(), bomInfo.getId().toString(), bomInfo
						//.getNumber());
			} catch (Exception ee) {
				isSuccess = false;
				msg = ee.getMessage();
				
				try {
					if (conn != null && !conn.isClosed()) {
						conn.rollback();
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				throw new EASBizException(new NumericExceptionSubItem("001", ee.getMessage()));
			} finally {
				LogBean logBean=new LogBean();
				logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
				logBean.setBosType(bomInfo.getBOSType().toString());
				logBean.setEasBillID(billID);
				logBean.setDirection(LogBean.Direction_Export);
				logBean.setSuccess(isSuccess);
				logBean.setMsg(msg);
				//EASWUtils.insertLogs(ctx, logBean);// 插入日志
			}
			if (ptm != null){
				ptm.close();
			}
			
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	private String getBsmc(Context ctx,String bomentryID ,String colname) throws SQLException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select bsmc.FNumber,bsmc.CFBsmccode from t_mm_bomEntry be");
		sql.append(" inner join CT_CUS_Bsmc bsmc on be.CFBsmcID=bsmc.fid");
		sql.append(" where be.fid='").append(bomentryID);
		sql.append("'");
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
		if(rs.next()){
			return rs.getString(colname);
		}} catch (BOSException e) {
			e.printStackTrace();
		}
		return null;
		
	}
 
	

	// 中控系统bom表名
	public String getTempHeadTable() {
		return "t_bom";
	}

	// 中控系统中间库分录表名
	public String getTempEntryTable() {
		return "t_bomEntry";
	}

	// 中控系统bomsql
	public String getInsertHeadSql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getTempHeadTable()).append(" ( ");
		sql.append(" recipeNum,productNum,number,name,version,unit,productQty,recipeBase,createTime,creator");// 配方编号,配方名称（也可为产品名称）,对应产品编号, 备注
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,?,?,?,?,?");
		sql.append(" )");
		return sql.toString();
	}

	// 中控系统分录sql
	public String getInsertEntrySql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getTempEntryTable()).append(" (");
		sql.append(" recipeNum,materialnumber,unit,materialQty,outmaterial ");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,? ");
		sql.append(" )");
		return sql.toString();
	}
	
	// 插入bomsql
	public String getUpdateHeadSql(String bomID) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update ").append(getTempHeadTable()).append("  ")
		.append(" set recipeNum=?,productNum=?,number=?,name=?,version=?,unit=?,")
		.append(" productQty=?,recipeBase=?,createTime=?,creator=?")
		.append(" ")
		.append(" where recipeNum='").append(bomID).append("'");
		return sql.toString();
	}
	// 更新分录sql
	private String getUpdateEntrySql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" update  ").append(getTempEntryTable()).append(" set ");
		sql.append(" recipeNum=?,materialnumber=?,unit=?,unit=?,materialQty=?,");
		sql.append(" outmaterial=?");
		return sql.toString();
	}
	
	



	
	public String getBosType() {
		return null;
	}
	
	//未使用此方法
	public String export2Temp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		return null;
	}


}
