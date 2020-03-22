package com.kingdee.eas.custom.eas2temp.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFacade;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroup;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.IBom;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 物料导出
 * 
 * @author yumingxu
 * 2019.01
 * 
 */
public class ExportMaterial implements IExport2Temp {

	public String export2Temp(Context ctx, String companyNum, String beginDate,
			String endDate) throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String export2TempByID(Context ctx, String companyNum, String billID)
			throws EASBizException {
		// TODO Auto-generated method stub
		Connection conn = null;
		//Connection connMuyang = null;
		Boolean isSuccess = false;
 		String msg = null;
		BomInfo bomInfo = null;
		BomEntryInfo bomEntryInfo;
		String sql = getMaterial();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql);
			while(rs.next()){
			try {
				conn = EASWUtils.getTempConnection1(ctx, companyNum, TargetSystem.MUYANGSYSTEM_VALUE);// 获得中控系统连接
				conn.setAutoCommit(false);
				// 执行插入的预编译方法
				PreparedStatement ptm = null;
				try {
					IMaterial im = MaterialFactory.getLocalInstance(ctx);
					billID = rs.getString("fid");
					MaterialInfo material = im.getMaterialInfo(new ObjectUuidPK(rs.getString("fid")));
					MaterialGroupInfo mg =  MaterialGroupFactory.getLocalInstance(ctx).getMaterialGroupInfo(new ObjectUuidPK(material.getMaterialGroup().getId().toString()));
					Date date = new Date();
					java.sql.Date date1=new java.sql.Date(date.getTime()); 
					isSuccess = true;
					// 插入一条物料数据
					ptm = conn.prepareStatement(getInsertHeadSql());
					ptm.setString(1, material.getNumber());// 物料编码
					ptm.setString(2, material.getName());// 物料名称
					ptm.setString(3, mg.getName());// 物料类型
					ptm.setDate(4,date1);//创建时间
					ptm.setString(5,((UserInfo) ctx.get(SysContextConstant.USERINFO)).getName());// 创建人
					ptm.execute();
					conn.commit();
					String upsql = "update T_BD_Material set cfisinbom = 1  where fid = '"+billID+"'";
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
			}
		} catch (BOSException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    //中控物料update sql
	public String getInsertHeadSql() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getTempHeadTable()).append(" ( ");
		sql.append(" number,name,type,createTime,creator");// 
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?");
		sql.append(" )");
		return sql.toString();
	}

	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "t_material";
	}
	public String getMaterial() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select t1.fid fid  from T_BD_Material t1 ");
		sql.append("inner join T_BD_MaterialGroup t2 on t2.FID = t1.FMaterialGroupID ");
		sql.append("where (t2.FNumber like '0201%' or t2.FNumber like '0101%')");
		//sql.append("and t1.FNumber = '0202003' ");
		sql.append("and (t1.CFIsInBom is null or t1.CFIsInBom =0) ");
		return sql.toString();
	}
	


}
