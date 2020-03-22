package com.kingdee.eas.custom.eas2temp.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.mo.IManufactureOrder;
import com.kingdee.eas.mm.mo.ManufactureOrder;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 生产订单导出
 * 
 * @author yumingxu
 * 2019.01
 * 
 */
public class ExportProduct implements IExport2Temp {

	public String export2Temp(Context ctx, String companyNum, String beginDate,
			String endDate) throws EASBizException {
		return null;
	}

	public String export2TempByID(Context ctx, String companyNum, String billID)
			throws EASBizException {
		// TODO Auto-generated method stub
		Connection conn = null;
		//Connection connMuyang = null;
		Boolean isSuccess = false;
		String msg = null;
			
		try {
		conn = EASWUtils.getTempConnection(ctx, companyNum, TargetSystem.MUYANGSYSTEM_VALUE);// 获得中控系统连接
		conn.setAutoCommit(false);
		// 执行插入的预编译方法
		PreparedStatement ptm = null;
		try {
			IManufactureOrder imo = ManufactureOrderFactory.getLocalInstance(ctx);
			ManufactureOrderInfo iminfo = imo.getManufactureOrderInfo(new ObjectUuidPK(billID));
			IMaterial im = MaterialFactory.getLocalInstance(ctx);
			
			MaterialInfo material = im.getMaterialInfo(new ObjectUuidPK(iminfo.getMaterial().getId().toString()));
			//MaterialGroupInfo mg =  MaterialGroupFactory.getLocalInstance(ctx).getMaterialGroupInfo(new ObjectUuidPK(material.getMaterialGroup().getId().toString()));
			Date date = new Date();
			java.sql.Date date1=new java.sql.Date(date.getTime()); 
			java.sql.Date date2=new java.sql.Date(iminfo.getPlanBeginDate().getTime()); 
			BomInfo bomInfo = BomFactory.getLocalInstance(ctx).getBomInfo(new ObjectUuidPK(iminfo.getBomID().toString()));
			MeasureUnitInfo measinfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(iminfo.getBaseUnit().getId().toString())); 

			isSuccess = true;
			// 插入一条物料数据
			ptm = conn.prepareStatement(getInsertHeadSql());
			ptm.setString(1, iminfo.getNumber());// 订单号
			ptm.setDate(2,date2);//计划日期
			ptm.setString(3, material.getNumber());// 物料编码
			ptm.setString(4, measinfo.getName());//计量单位
			ptm.setBigDecimal(5, iminfo.getQty());//产品数量
			ptm.setString(6, bomInfo.getNumber());//BOM编号
			ptm.setString(7, "V1.0");//BOM版本
			ptm.setString(8, "01");//BOM版本
			ptm.setDate(9,date1);//创建时间
			ptm.setString(10,((UserInfo) ctx.get(SysContextConstant.USERINFO)).getName());// 创建人
//			ptm.setString(11, ContextUtil.getCurrentCtrlUnit(ctx).getNumber());//车间编码
//			ptm.setString(12, ContextUtil.getCurrentCtrlUnit(ctx).getNumber());//公司编码
			
			ptm.execute();
			conn.commit();
			String upsql = "update T_MM_ManufactureOrder set cfisimbom = 1  where fid = '"+billID+"'";
			DbUtil.execute(ctx,upsql);	
			System.out.println("####################"+material.getName()+"已成功导出");
			
			
			// 在eas中插入导出记录
//					EASWUtils.insertHasExported(ctx, "BOM", bomInfo.getBOSType().toString(), bomInfo.getId().toString(), bomInfo
//							.getNumber());
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
			//logBean.setBosType(bomInfo.getBOSType().toString());
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

	public String getBosType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInsertEntrySql() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInsertHeadSql() {
		// TODO Auto-generated method stub
		
		
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getTempHeadTable()).append(" ( ");
		sql.append(" number,planDate,productNum,unit,productQty,recipeNum,recipeVer,statu,createTime,creator");// 
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,?,?,?,?,?");
		sql.append(" )");
		return sql.toString();
	}

	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "t_tasks";
	}

}
