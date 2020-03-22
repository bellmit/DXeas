package com.kingdee.eas.custom.eas2temp.interfaces;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.mm.mo.IManufactureOrder;
import com.kingdee.eas.mm.mo.ManufactureOrderCollection;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.rptclient.newrpt.util.MsgBox;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 导出生产订单（生产任务单）
 * 
 * @author yin
 * 
 */
public class ExportManufactureOrder implements IExport2Temp {

	
	public String export2TempByID(Context ctx, String companyID, String billID)
			throws EASBizException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Connection connMuyang = null;
		Boolean isSuccess = false;
		String msg = null;
		ManufactureOrderInfo manufactureOrderInfo = null;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID,
					TargetSystem.BARSYSTEM_VALUE);
			connMuyang=EASWUtils.getTempConnection(ctx, companyID, TargetSystem.MUYANGSYSTEM_VALUE);
			
			if (conn == null) {
				throw new Exception("请确认条码系统连接参数设置正确");
			}
			if(connMuyang==null)
			{
				throw new Exception("请确认连牧羊系统接参数设置正确");
			}
			conn.setAutoCommit(false);
			connMuyang.setAutoCommit(false);
			
			String billType = "生产订单";
			IManufactureOrder ips = ManufactureOrderFactory
					.getLocalInstance(ctx);
			// 执行插入的预编译方法
			PreparedStatement ptm = null;
			PreparedStatement ptmMY=null;
			try {
				isSuccess = true;
				msg = null;

				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("material.*"));
				// 根据id过滤获得生产订单信息
				manufactureOrderInfo = ips.getManufactureOrderInfo(
						new ObjectUuidPK(billID), slor);

				// 插入生产订单
				
				// 设置参数
				// 获取物料对应编码
				StorageOrgUnitInfo storageOrgUnitInfo = manufactureOrderInfo
						.getStorageOrgUnit();
				String barMaterialNum = EASWUtils.getBarMaterialNumber(ctx,
						manufactureOrderInfo.getMaterial(), storageOrgUnitInfo);// 物料编码
				//条码系统插入
				ptm = conn.prepareStatement(getInsertHeadSql());
				ptm.setString(1, manufactureOrderInfo.getNumber());// 配料单单号
				/*-------2016年8月4日，业务日期修改为审核日期开始-----------*/
				//ptm.setDate(2, (Date) manufactureOrderInfo.getBizDate());// 配料日期
				//2016年8月6日10:26:08审核时间去掉时间，只保留日期
				Timestamp pldate = manufactureOrderInfo.getAuditTime();
				ptm.setDate(2, new Date(pldate.getYear(),pldate.getMonth(),pldate.getDate()));// 配料日期
				//tm.setDate(2, new Date(manufactureOrderInfo.getAuditTime().getTime()));// 配料日期
				/*-------2016年8月4日，业务日期修改为审核日期结束-----------*/
				ptm.setString(3, manufactureOrderInfo.getBomNum());// 配方编号
				ptm.setBigDecimal(4, manufactureOrderInfo.getQty());// 配料量
				ptm.setInt(5, 1);// 生产线编号
				ptm.setString(6, barMaterialNum);// 对应成品编号
				ptm.setString(7, "");// 备注
				int defaultcfzl = 1000;
				if (EASWUtils.getDefaultcfzl(ctx, manufactureOrderInfo
						.getMaterial().getId().toString(), manufactureOrderInfo
						.getCU().getId().toString()) != 0) {
					defaultcfzl = EASWUtils.getDefaultcfzl(ctx,
							manufactureOrderInfo.getMaterial().getId()
									.toString(), manufactureOrderInfo.getCU()
									.getId().toString());
				}
				ptm.setInt(8, defaultcfzl);// 默认拆分数量
				ptm.execute();
				
				try {
					//牧羊系统插入
					ptmMY=connMuyang.prepareStatement(getMYInsertHeadSql());
					ptmMY.setString(1,manufactureOrderInfo.getNumber());//生产订单number
					/*-------2016年8月4日，业务日期修改为审核日期开始-----------*/
					//ptmMY.setDate(2, (Date) manufactureOrderInfo.getBizDate());//业务日期
					//2016年8月6日10:26:08审核时间去掉时间，只保留日期
					ptmMY.setDate(2,  new Date(pldate.getYear(),pldate.getMonth(),pldate.getDate()) );//业务日期
					/*-------2016年8月4日，业务日期修改为审核日期结束-----------*/
					ptmMY.setString(3, manufactureOrderInfo.getBomNum());//bomnumber
					ptmMY.setString(4, barMaterialNum);//对应成品编号
					ptmMY.setBigDecimal(5, manufactureOrderInfo.getQty());
					ptmMY.execute();
				} catch (Exception e) {
					// TODO: handle exception
					//throw new EASBizException(new NumericExceptionSubItem("001",e.getMessage()));
				}

				conn.commit();// 条码提交commit
				connMuyang.commit();//牧羊提交
				// 在eas中插入导出记录
				EASWUtils.insertHasExported(ctx, billType, manufactureOrderInfo
						.getBOSType().toString(), manufactureOrderInfo.getId()
						.toString(), manufactureOrderInfo.getNumber());
			} catch (Exception e) {
				isSuccess = false;
				msg = e.getMessage();
				try {
					if (conn != null && !conn.isClosed()) {
						conn.rollback();
					}
					if (connMuyang != null && !connMuyang.isClosed()) {
						connMuyang.rollback();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				throw new BOSException(e.getMessage());
			} finally {
				LogBean logBean = new LogBean();
				logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx)
						.getId().toString());
				logBean
						.setBosType(manufactureOrderInfo.getBOSType()
								.toString());
				logBean.setEasBillID(billID);
				logBean.setDirection(LogBean.Direction_Export);
				logBean.setSuccess(isSuccess);
				logBean.setMsg(msg);
				EASWUtils.insertLogs(ctx, logBean);// 插入日志
			}
			if (ptm != null) {
				ptm.close();
			}
			if(ptmMY!=null){
				ptmMY.close();
			}
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e
					.getMessage()));
		} finally {// 最终都要关闭数据库连接
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (connMuyang != null && !connMuyang.isClosed()) {
					connMuyang.close();
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



	// 生产订单没有分录
	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "sc_pfjh";
	}
	//导入条码中间库
	public String getInsertHeadSql() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getTempHeadTable()).append(" ( ");
		sql.append(" pldh,plrq,pfph,pll,scx,dycpbh,bz,eachQty ");
		sql.append(") values(");
		sql.append(" ?,?,?,");
		sql.append(" ?,?,?,?,?");
		sql.append(" )");
		return sql.toString();
	}

	// 牧羊中间库表头
	public String getMYTempHeadTable() {
		return "bomOrders";
	}

	// 牧羊插入中间库sql
	public String getMYInsertHeadSql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getMYTempHeadTable()).append("(");
		sql.append(" number,date,bomNum,productnumber,qty");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?)");
		return sql.toString();
	}
	
	/**
	 * 反审核用，条码删除导入中间库的生产订单
	 * 
	 * @param ctx
	 * @param companyID
	 * @param billNumber
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void deletescpfjh(Context ctx, Object obj) throws EASBizException,
			BOSException {
		Connection conn = null;
		ObjectUuidPK a = new ObjectUuidPK();
		IObjectPK pk = (IObjectPK) obj;
		SelectorItemCollection slr=new SelectorItemCollection();
		slr.add(new SelectorItemInfo("*"));
		slr.add(new SelectorItemInfo("CU.*"));
		ManufactureOrderInfo info = ManufactureOrderFactory.getLocalInstance(
				ctx).getManufactureOrderInfo(pk,slr);
		if (info.getCU().getNumber().equals("07")) {
			try {
				conn = EASWUtils.getTempConnection(ctx, info.getCU().getId()
						.toString(), TargetSystem.BARSYSTEM_VALUE);
				if (conn == null) {
					throw new Exception("请确认连接参数设置正确");
				}
				conn.setAutoCommit(false);
				StringBuffer sql = new StringBuffer();
				sql.append(" delete from sc_pfjh where pldh='").append(
						info.getNumber()).append("'");
				PreparedStatement ptm = conn.prepareStatement(sql.toString());
				ptm.execute();
				conn.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				LogBean logBean = new LogBean();
				logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx)
						.getId().toString());
				logBean
						.setBosType("");
				logBean.setEasBillID("");
				logBean.setDirection("deleteTMscpfjh");
				logBean.setSuccess(false);
				logBean.setMsg(e.getMessage());
				EASWUtils.insertLogs(ctx, logBean);// 插入日志
				throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
			} finally {// 最终都要关闭数据库连接
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 反审核用，牧羊删除导入中间库的生产订单
	 * 
	 * @param ctx
	 * @param companyID
	 * @param billNumber
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void deletescpfjhMY(Context ctx, Object obj) throws EASBizException,
			BOSException {
		Connection conn = null;
	
		IObjectPK pk = (IObjectPK) obj;
		SelectorItemCollection slr=new SelectorItemCollection();
		slr.add(new SelectorItemInfo("*"));
		slr.add(new SelectorItemInfo("CU.*"));
		ManufactureOrderInfo info = ManufactureOrderFactory.getLocalInstance(
				ctx).getManufactureOrderInfo(pk,slr);
		if (info.getCU().getNumber().equals("07")) {
			try {
				conn = EASWUtils.getTempConnection(ctx, info.getCU().getId()
						.toString(), TargetSystem.MUYANGSYSTEM_VALUE);
				if (conn == null) {
					throw new Exception("请确认连接参数设置正确");
				}
				conn.setAutoCommit(false);
				StringBuffer sql = new StringBuffer();
				sql.append(" delete from bomOrders where number='").append(
						info.getNumber()).append("'");
				PreparedStatement ptm = conn.prepareStatement(sql.toString());
				ptm.execute();
				conn.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				LogBean logBean = new LogBean();
				logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx)
						.getId().toString());
				logBean
						.setBosType("");
				logBean.setEasBillID("");
				logBean.setDirection("deleteMYbomOrders");
				logBean.setSuccess(false);
				logBean.setMsg(e.getMessage());
				EASWUtils.insertLogs(ctx, logBean);// 插入日志
				throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
			} finally {// 最终都要关闭数据库连接
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * dep调用，执行导出生产订单操作
	 */
	public void executeExport(Context ctx,String billID) throws EASBizException, BOSException{
		System.out.println("--------------------"+billID+"--------------");
		SelectorItemCollection slr=new SelectorItemCollection();
		slr.add(new SelectorItemInfo("*"));
		slr.add(new SelectorItemInfo("CU.*"));
		ManufactureOrderInfo info = ManufactureOrderFactory.getLocalInstance(
				ctx).getManufactureOrderInfo(new ObjectUuidPK(billID),slr);
		if (info.getCU().getNumber().equals("07")) {
			export2TempByID(ctx, info.getCU().getId().toString(), billID);
		}
		System.out.println("---------------导出生产订单完成-------------------");
	}
	
	//未使用此方法
	public String export2Temp(Context ctx, String companyID, String beginDate,
			String endDate) throws EASBizException {
		Connection conn = null;

		try {
			conn = EASWUtils.getTempConnection(ctx, companyID,
					TargetSystem.BARSYSTEM_VALUE);
			if (conn == null) {
				throw new Exception("请确认连接参数设置正确");
			}
			conn.setAutoCommit(false);

			IManufactureOrder ips = ManufactureOrderFactory
					.getLocalInstance(ctx);
			// 实体显示信息
			EntityViewInfo ev = new EntityViewInfo();
			// 过滤条件设置
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(
					new FilterItemInfo("CU.id", companyID, CompareType.EQUALS));
			filter.getFilterItems().add(
					new FilterItemInfo("baseStatus",
							BillBaseStatusEnum.AUDITED_VALUE,
							CompareType.EQUALS));
			if (StringUtils.isBlank(beginDate) && StringUtils.isBlank(endDate)) {
				// 如果开始日期和结束日期都为空，则为服务器端调用，默认为当前业务日期。
				filter.getFilterItems().add(
						new FilterItemInfo("auditTime", new java.util.Date(),
								CompareType.EQUALS));
			} else {
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(
						new FilterItemInfo("auditTime", format.parse(beginDate
								+ " 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(
						new FilterItemInfo("auditTime", format.parse(endDate
								+ " 23:59:59"), CompareType.LESS_EQUALS));
			}
			ev.setFilter(filter);
			// SorterItemCollection sorter = new SorterItemCollection();
			// sorter.add(new SorterItemInfo("bizDate"));
			// 获得日期期间的所有的 -生产订单集合
			ManufactureOrderCollection coll = ips
					.getManufactureOrderCollection(ev);
			if (coll == null || coll.size() <= 0) {
				// 查不到数据
				return null;
			}
			// 执行插入的预编译方法
			PreparedStatement ptm = null;
			Boolean isSuccess = false;
			String msg = null;
			String billID = null;
			String billType = "生产订单";
			ManufactureOrderInfo manufactureOrderInfo = null;
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("material.*"));
			// 遍历获得的生产订单 集合 逐个导入到中间库中
			for (int index = 0; index < coll.size(); index++) {
				try {
					// 根据id过滤获得生产订单信息
					manufactureOrderInfo = ips.getManufactureOrderInfo(
							new ObjectUuidPK(coll.get(index).getString("id")),
							slor);
					billID = manufactureOrderInfo.getString("id");
					isSuccess = true;
					msg = null;
					// 已经导出的单据不能重复导出
					if (EASWUtils.checkHasExported(ctx, manufactureOrderInfo
							.getBOSType().toString(), manufactureOrderInfo
							.getId().toString())) {
						continue;
					}
					// 获取物料对应编码
					StorageOrgUnitInfo storageOrgUnitInfo = manufactureOrderInfo
							.getStorageOrgUnit();
					String barMaterialNum = EASWUtils.getBarMaterialNumber(ctx,
							manufactureOrderInfo.getMaterial(),
							storageOrgUnitInfo);// 物料编码
					// 插入生产订单
					ptm = conn.prepareStatement(getInsertHeadSql());
					// 设置参数
					ptm.setString(1, manufactureOrderInfo.getNumber());// 配料单单号
					ptm.setDate(2, (Date) manufactureOrderInfo.getBizDate());// 配料日期
					ptm.setString(3, manufactureOrderInfo.getBomNum());// 配方编号
					ptm.setBigDecimal(4, manufactureOrderInfo.getQty());// 配料量
					ptm.setInt(5, 1);// 生产线编号
					ptm.setString(6, barMaterialNum);// 对应成品编号
					ptm.setString(7, manufactureOrderInfo.getRemark());// 备注
					int defaultcfzl = 1000;
					if (EASWUtils.getDefaultcfzl(ctx, manufactureOrderInfo
							.getMaterial().getId().toString(),
							manufactureOrderInfo.getCU().getId().toString()) != 0) {
						defaultcfzl = EASWUtils.getDefaultcfzl(ctx,
								manufactureOrderInfo.getMaterial().getId()
										.toString(), manufactureOrderInfo
										.getCU().getId().toString());
					}
					ptm.setInt(8, defaultcfzl);// 默认拆分数量
					ptm.execute();

					// 在eas中插入导出记录
					EASWUtils.insertHasExported(ctx, billType,
							manufactureOrderInfo.getBOSType().toString(),
							manufactureOrderInfo.getId().toString(),
							manufactureOrderInfo.getNumber());
					conn.commit();// 提交commit
					// 插入完成
				} catch (Exception e) {
					isSuccess = false;
					msg = e.getMessage();
					try {
						if (conn != null && !conn.isClosed()) {
							conn.rollback();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					throw new EASBizException(new NumericExceptionSubItem(
							"001", e.getMessage()));
				} finally {
					LogBean logBean = new LogBean();
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx)
							.getId().toString());
					logBean.setBosType(manufactureOrderInfo.getBOSType()
							.toString());
					logBean.setEasBillID(billID);
					logBean.setDirection(LogBean.Direction_Export);
					logBean.setSuccess(isSuccess);
					logBean.setMsg(msg);
					EASWUtils.insertLogs(ctx, logBean);// 插入日志
				}
			}
			if (ptm != null) {
				ptm.close();
			}
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e
					.getMessage()));
		} finally {// 最终都要关闭数据库连接
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


}
