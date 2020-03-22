package com.kingdee.eas.custom.eas2temp.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.ISaleIssueBill;
import com.kingdee.eas.scm.im.inv.SaleIssueBillCollection;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.im.inv.SaleIssueEntryInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 销售出库单导出
 * 
 * @author yin
 * 
 */
public class ExportSaleIssue implements IExport2Temp {
	public String export2TempByID(Context ctx, String companyID, String billID) throws EASBizException {
		Connection conn = null;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.BARSYSTEM_VALUE);
			if (conn == null) {
				throw new Exception("请确认连接参数设置正确！");
			}
			conn.setAutoCommit(false);// 不自动提交
			Boolean isSuccess = false;
			String msg = null;
			String billType="销售出库单";
			SaleIssueBillInfo saleIssueBillInfo = null;// 销售出库单info
			SaleIssueEntryInfo saleIssueEntryInfo;// 销售出库单分录info
			ISaleIssueBill ips = SaleIssueBillFactory.getLocalInstance(ctx);// 获得销售出库单的借口调用对象
			PreparedStatement ptm = null;
			try {
				int billHeadID = 0;
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("customer.*"));
				slor.add(new SelectorItemInfo("material.*"));
				slor.add(new SelectorItemInfo("entry.*"));
				slor.add(new SelectorItemInfo("entry.material.*"));
				saleIssueBillInfo = ips.getSaleIssueBillInfo(new ObjectUuidPK(billID), slor);// 获得销售出库单info
				isSuccess = true;
				msg = null;

				// 这里插入单据头
				ptm = conn.prepareStatement(getInsertHeadSql());

				ptm.setString(1, saleIssueBillInfo.getNumber());// 发运单号（ERP)
				ptm.setString(2, saleIssueBillInfo.getCustomer().getNumber());// 客户ID
				ptm.setString(3, saleIssueBillInfo.getCustomer().getName());//客户name
				ptm.setDate(4, (Date) saleIssueBillInfo.getBizDate());// 开票日期
				ptm.setString(5, "");// 承运人
				ptm.setString(6, "");// 备注
				ptm.execute();

				// 这里循环插入每条分录
				ptm = conn.prepareStatement(getInsertEntrySql());
				for (int j = 0; j < saleIssueBillInfo.getEntry().size(); j++) {
					saleIssueEntryInfo = saleIssueBillInfo.getEntry().get(j);

					// 设置要插入的值
					//获取物料对应编码
					StorageOrgUnitInfo storageOrgUnitInfo=saleIssueBillInfo.getStorageOrgUnit();
					String barMaterialNum=EASWUtils.getBarMaterialNumber(ctx, saleIssueEntryInfo.getMaterial(),storageOrgUnitInfo);//物料编码
					
					ptm.setInt(1, billHeadID);// 主表id
					ptm.setString(2, saleIssueBillInfo.getNumber());// 发运单号
					ptm.setString(3, barMaterialNum);// 产品id对应物料编码
					ptm.setBigDecimal(4, saleIssueEntryInfo.getQty());// KG
					ptm.setBigDecimal(5, BigDecimal.ZERO);// 件数
					ptm.setString(6, saleIssueEntryInfo.getWarehouse().getNumber());// 仓库id
					ptm.setString(7, saleIssueEntryInfo.getRemark());// 备注
					ptm.execute();// 一条分录插入完成
				}
				conn.commit();
				// 在eas中插入导出记录
				EASWUtils.insertHasExported(ctx, billType, saleIssueBillInfo.getBOSType().toString(), saleIssueBillInfo
						.getId().toString(), saleIssueBillInfo.getNumber());
				// 导出销售出库单完成
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
				throw new BOSException(e.getMessage());
			} finally {
				LogBean logBean=new LogBean();
				logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
				logBean.setBosType(saleIssueBillInfo.getBOSType().toString());
				logBean.setEasBillID(billID);
				logBean.setDirection(LogBean.Direction_Export);
				logBean.setSuccess(isSuccess);
				logBean.setMsg(msg);
				EASWUtils.insertLogs(ctx, logBean);// 插入日志
			}

			if (ptm != null) {
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
		StringBuffer sql = new StringBuffer();

		// 主表ID ,发运单号(ERP) ,产品ID ,KG ,件数 ,仓库ID（用友为必填）, 备注
		sql.append(" insert into ").append(getTempEntryTable()).append(" ( ");
		sql.append(" main_id,fyd_id,cp_id,sl,js,Stock_id,Bz ");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,?,? ");
		sql.append(" )");
		return sql.toString();
	}

	public String getInsertHeadSql() {
		StringBuffer sql = new StringBuffer();

		// 发运单号(ERP),客户ID,开票日期,承运人ID,备注

		sql.append(" insert into ").append(getTempHeadTable()).append(" ( ");
		sql.append(" FYD_ID,Client_id,client_name,KP_DATE,CYR_ID,bz ");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,? ");
		sql.append(" )");
		return sql.toString();
	}

	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return "FYD_FB";
	}

	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "FYD_ZB";
	}
	/*
	 * dep调用，执行导出销售出库单操作
	 */
	public void executeExport(Context ctx,String billID) throws EASBizException, BOSException{
		System.out.println("--------------------"+billID+"--------------");
		SelectorItemCollection slr=new SelectorItemCollection();
		slr.add(new SelectorItemInfo("*"));
		slr.add(new SelectorItemInfo("CU.*"));
		SaleIssueBillInfo info = SaleIssueBillFactory.getLocalInstance(
				ctx).getSaleIssueBillInfo(new ObjectUuidPK(billID),slr);
		if (info.getCU().getNumber().equals("07")) {
			export2TempByID(ctx, info.getCU().getId().toString(), billID);
		}
		System.out.println("---------------导出销售出库单完成-------------------");
	}
	
	//未使用此方法
	public String export2Temp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.BARSYSTEM_VALUE);
			if (conn == null) {
				throw new Exception("请确认连接参数设置正确！");
			}

			conn.setAutoCommit(false);// 不自动提交

			ISaleIssueBill ips = SaleIssueBillFactory.getLocalInstance(ctx);// 获得销售出库单的借口调用对象
			EntityViewInfo ev = new EntityViewInfo();// 获得实体对象
			FilterInfo filter = new FilterInfo();// 获得过滤信息对象
			// 设置过滤信息
			filter.getFilterItems().add(new FilterItemInfo("CU.id", companyID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("baseStatus", BillBaseStatusEnum.AUDITED_VALUE, CompareType.EQUALS));
			if (StringUtils.isBlank(beginDate) && StringUtils.isBlank(endDate)) {
				// 如果开始日期和结束日期都为空，则为服务器端调用，默认为当前业务日期
				filter.getFilterItems().add(new FilterItemInfo("auditTime", new java.util.Date(), CompareType.EQUALS));
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(
						new FilterItemInfo("auditTime", format.parse(beginDate + " 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(
						new FilterItemInfo("auditTime", format.parse(endDate + " 23:59:59"), CompareType.LESS_EQUALS));
			}
			filter.getFilterItems().add(new FilterItemInfo("isSysBill", 0, CompareType.EQUALS));
			ev.setFilter(filter);// 实体对象设置过滤条件
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("bizDate"));
			ev.setSorter(sorter);
			SaleIssueBillCollection coll = ips.getSaleIssueBillCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return null;
			}

			// 执行插入的预编译方法
			PreparedStatement ptm = null;
			Boolean isSuccess = false;
			String msg = null;
			String billID = null;
			int billHeadID = 0;
			String billType="销售出库单";
			SaleIssueBillInfo saleIssueBillInfo = null;// 销售出库单info
			SaleIssueEntryInfo saleIssueEntryInfo;// 销售出库单分录info
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));

			slor.add(new SelectorItemInfo("material.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("customer.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			// 这里插入单据
			for (int index = 0; index < coll.size(); index++) {

				try {
					saleIssueBillInfo = ips.getSaleIssueBillInfo(new ObjectUuidPK(coll.get(index).getString("id")), slor);// 获得销售出库单info
					isSuccess = true;
					msg = null;
					billID = saleIssueBillInfo.getId().toString();

					// 已经导出的单据不能重复导出
					if (EASWUtils.checkHasExported(ctx, saleIssueBillInfo.getBOSType().toString(), saleIssueBillInfo.getId()
							.toString())) {
						continue;
					}
					// 这里插入单据头 FYD_ID,Client_id,client_name,KP_DATE,CYR_ID,bz
					ptm = conn.prepareStatement(getInsertHeadSql());
					ptm.setString(1, saleIssueBillInfo.getNumber());// 发运单号（ERP)
					ptm.setString(2, saleIssueBillInfo.getCustomer().getNumber());// 客户ID
					ptm.setString(3, saleIssueBillInfo.getCustomer().getName());//客户名称
					ptm.setDate(4, (Date) saleIssueBillInfo.getBizDate());// 开票日期
					ptm.setString(5, "");// 承运人
					ptm.setString(6, "");// 备注
					ptm.execute();

					// 这里循环插入每条分录
					ptm = conn.prepareStatement(getInsertEntrySql());
					for (int j = 0; j < saleIssueBillInfo.getEntry().size(); j++) {
						saleIssueEntryInfo = saleIssueBillInfo.getEntry().get(j);

						// 设置要插入的值
						//获取物料对应编码
						StorageOrgUnitInfo storageOrgUnitInfo=saleIssueBillInfo.getStorageOrgUnit();
						String barMaterialNum=EASWUtils.getBarMaterialNumber(ctx, saleIssueEntryInfo.getMaterial(),storageOrgUnitInfo);//物料编码
						
						ptm.setInt(1, billHeadID);// 主表id
						ptm.setString(2, saleIssueBillInfo.getNumber());// 发运单号
						ptm.setString(3, barMaterialNum);// 产品id对应物料编码
						ptm.setBigDecimal(4, saleIssueEntryInfo.getQty());// KG
						ptm.setBigDecimal(5, BigDecimal.ZERO);// 件数
						ptm.setString(6, saleIssueEntryInfo.getWarehouse().getNumber());// 仓库id
						ptm.setString(7,saleIssueEntryInfo.getRemark());// 备注
						ptm.execute();// 一条分录插入完成
					}

					// 在eas中插入导出记录
					EASWUtils.insertHasExported(ctx, billType, saleIssueBillInfo.getBOSType().toString(),
							saleIssueBillInfo.getId().toString(), saleIssueBillInfo.getNumber());
					conn.commit();
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
					throw new BOSException(ee.getMessage());
				} finally {
					LogBean logBean=new LogBean();
					logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
					logBean.setBosType(saleIssueBillInfo.getBOSType().toString());
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
	

}
