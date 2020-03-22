package com.kingdee.eas.custom.eas2wincos.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;
import com.kingdee.eas.custom.eas2wincos.comm.WinCosUtils;
import com.kingdee.eas.scm.sd.sale.ISaleOrder;
import com.kingdee.eas.scm.sd.sale.SaleOrderCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 导出销售 订单
 * @author lenovo
 *
 */
public class ExportSaleOrder implements IExport2WinCos {

	@Override
	public String export2WinCos(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			conn= EASWUtils.getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			conn.setAutoCommit(false);
			
			ISaleOrder ips = SaleOrderFactory.getLocalInstance(ctx);
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", companyID, CompareType.EQUALS));
			//filter.getFilterItems().add(new FilterItemInfo("baseStatus", BillBaseStatusEnum.AUDITED_VALUE, CompareType.EQUALS));
			if(StringUtils.isBlank(beginDate)&&StringUtils.isBlank(endDate)) {//如果开始日期和结束日期都为空  ，则为服务器端调用，默认为当前业务日期
				filter.getFilterItems().add(new FilterItemInfo("bizDate", new java.util.Date(), CompareType.EQUALS));
			}else {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(new FilterItemInfo("bizDate", format.parse(beginDate+" 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("bizDate", format.parse(endDate+" 23:59:59"), CompareType.LESS_EQUALS));
			}
			ev.setFilter(filter);
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("bizDate"));
			ev.setSorter(sorter);
			 SaleOrderCollection coll = ips.getSaleOrderCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return null;
			}
			//执行插入的预编译方法
			PreparedStatement ptm=null;
			int billHeadID=0;
			Boolean isSuccess=false;
			String msg=null;
			String billID=null;
			SaleOrderInfo	saleOrderInfo;
			SaleOrderEntryInfo saleIssueEntryInfo;
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("customer.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			slor.add(new SelectorItemInfo("entry.unit.*"));
			for (int index = 0; index < coll.size(); index++) {
				try{
					saleOrderInfo = ips.getSaleOrderInfo(new ObjectUuidPK(coll.get(index).getString("id")),slor);
					billID=saleOrderInfo.getString("id");
					isSuccess=true;
					msg=null;
					if (WinCosUtils.checkHasExported(conn, getWinCosHeadTable(), saleOrderInfo.getId().toString(),null)>0) {
						continue;
					}
					
					ptm = conn.prepareStatement(getInsertHeadSql());//插入表头
					
					ptm.setString(1, saleOrderInfo.getNumber());
					ptm.setDate(2,new java.sql.Date(saleOrderInfo.getBizDate().getTime()));
					ptm.setString(3, saleOrderInfo.getNumber());
					ptm.setString(4, "");//合同号
					ptm.setString(5, saleOrderInfo.getOrderCustomer().getNumber());
					ptm.setString(6, saleOrderInfo.getOrderCustomer().getName());
					ptm.setString(7, "");//仓库
					ptm.setInt(8, 0);
					ptm.setString(9, saleOrderInfo.getId().toString());
					ptm.setString(10, "");
					ptm.setTimestamp(11, new java.sql.Timestamp(new java.util.Date().getTime()));
					ptm.execute();
					billHeadID=WinCosUtils.checkHasExported(conn, getWinCosHeadTable(), saleOrderInfo.getId().toString(),null);//查询单据头id
					ptm = conn.prepareStatement(getInsertEntrySql());//插入表体
					// 已经导入不再重新导入
					for(int j=0;j<saleOrderInfo.getEntries().size();j++) {
						saleIssueEntryInfo=saleOrderInfo.getEntries().get(j);
						
						ptm.setInt(1, billHeadID);//单据头id
						ptm.setString(2, saleIssueEntryInfo.getMaterial().getNumber());//单据头id
						ptm.setBigDecimal(3, saleIssueEntryInfo.getQty());
						ptm.setBigDecimal(4, saleIssueEntryInfo.getQty());
						ptm.setBigDecimal(5, saleIssueEntryInfo.getBaseQty());
						ptm.setString(6,"");
						ptm.setString(7,saleOrderInfo.getId().toString()); 
						ptm.setString(8, saleIssueEntryInfo.getId().toString());
						ptm.setTimestamp(9, new java.sql.Timestamp(new java.util.Date().getTime()));
						ptm.execute();
						//在eas中插入导出记录
						//EASWUtils.insertHasExported(ctx, getBosType(), saleIssueInfo.getString("id"), null);//插入导出记录
					}
					conn.commit();
				}catch(Exception ee) {
					isSuccess=false;
					msg=ee.getMessage();
					try {
						if(conn!=null&&!conn.isClosed()) {
							conn.rollback();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				finally{ 
					EASWUtils.insertLogs(ctx, getBosType(), billID, 0, EASWUtils.Direction_Export, isSuccess, msg);//插入日志
				}
			}
			if(ptm!=null)
				ptm.close();
		} catch (Exception e) {
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
		return null;
	}
	
	@Override
	public String export2WinCosByID(Context ctx, String companyID, String billID) throws EASBizException {
		Connection conn = null;
		try {
			conn= EASWUtils.getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			conn.setAutoCommit(false);
			
			ISaleOrder ips = SaleOrderFactory.getLocalInstance(ctx);
			//执行插入的预编译方法
			PreparedStatement ptm=null;
			int billHeadID=0;
			Boolean isSuccess=false;
			String msg=null;
			SaleOrderInfo	saleOrderInfo;
			SaleOrderEntryInfo saleIssueEntryInfo;
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("customer.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			slor.add(new SelectorItemInfo("entry.unit.*"));
			try{
				saleOrderInfo = ips.getSaleOrderInfo(new ObjectUuidPK(billID),slor);
				billID=saleOrderInfo.getString("id");
				isSuccess=true;
				msg=null;
				if (WinCosUtils.checkHasExported(conn, getWinCosHeadTable(), saleOrderInfo.getId().toString(),null)>0) {
					return null;
				}
				
				ptm = conn.prepareStatement(getInsertHeadSql());//插入表头
				
				ptm.setString(1, saleOrderInfo.getNumber());
				ptm.setDate(2,new java.sql.Date(saleOrderInfo.getBizDate().getTime()));
				ptm.setString(3, saleOrderInfo.getNumber());
				ptm.setString(4, "");//合同号
				ptm.setString(5, saleOrderInfo.getOrderCustomer().getNumber());
				ptm.setString(6, saleOrderInfo.getOrderCustomer().getName());
				ptm.setString(7, "");//仓库
				ptm.setInt(8, 0);
				ptm.setString(9, saleOrderInfo.getId().toString());
				ptm.setString(10, "");
				ptm.setTimestamp(11, new java.sql.Timestamp(new java.util.Date().getTime()));
				ptm.execute();
				billHeadID=WinCosUtils.checkHasExported(conn, getWinCosHeadTable(), saleOrderInfo.getId().toString(),null);//查询单据头id
				ptm = conn.prepareStatement(getInsertEntrySql());//插入表体
				// 已经导入不再重新导入
				for(int j=0;j<saleOrderInfo.getEntries().size();j++) {
					saleIssueEntryInfo=saleOrderInfo.getEntries().get(j);
					
					ptm.setInt(1, billHeadID);//单据头id
					ptm.setString(2, saleIssueEntryInfo.getMaterial().getNumber());//单据头id
					ptm.setBigDecimal(3, saleIssueEntryInfo.getQty());
					ptm.setBigDecimal(4, saleIssueEntryInfo.getQty());
					ptm.setBigDecimal(5, saleIssueEntryInfo.getBaseQty());
					ptm.setString(6,"");
					ptm.setString(7,saleOrderInfo.getId().toString()); 
					ptm.setString(8, saleIssueEntryInfo.getId().toString());
					ptm.setTimestamp(9, new java.sql.Timestamp(new java.util.Date().getTime()));
					ptm.execute();
					//在eas中插入导出记录
					//EASWUtils.insertHasExported(ctx, getBosType(), saleIssueInfo.getString("id"), null);//插入导出记录
				}
				conn.commit();
			}catch(Exception ee) {
				isSuccess=false;
				msg=ee.getMessage();
				try {
					if(conn!=null&&!conn.isClosed()) {
						conn.rollback();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			finally{ 
				EASWUtils.insertLogs(ctx, getBosType(), billID, 0, EASWUtils.Direction_Export, isSuccess, msg);//插入日志
			}
			if(ptm!=null)
				ptm.close();
		} catch (Exception e) {
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
		return null;
	}

	@Override
	public String getInsertEntrySql() {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(getWinCosEntryTable()).append(" (");
		sql.append(" Delivery,ProductIdent,PackSize,TargetWeight,ActualWeight,");
		sql.append(" LotIdent,AppString02,AppString03,Visible,CreationDate");
		sql.append(" )values( ");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,1,?");
		sql.append(" )");
		return sql.toString();
	}

	@Override
	public String getInsertHeadSql() {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(getWinCosHeadTable()).append(" (");
		sql.append(" Ident,TargetDeliveryDate,OrderNumber,ContractNumber,CustomerIdent,");
		sql.append(" CustomerName,LocationID,State,");
		sql.append(" AppString02,AppString03,Visible,CreationDate");
		sql.append(" )values( ");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,");
		sql.append(" ?,?,1,?");
		sql.append(" )");
		return sql.toString();
	}

	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return "ERPDeliveryDetail";
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return "ERPDelivery";
	}
	@Override
	public String getBosType() {
		return "C48A423A";
	}
}
