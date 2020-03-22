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
 * ���۳��ⵥ����
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
				throw new Exception("��ȷ�����Ӳ���������ȷ��");
			}
			conn.setAutoCommit(false);// ���Զ��ύ
			Boolean isSuccess = false;
			String msg = null;
			String billType="���۳��ⵥ";
			SaleIssueBillInfo saleIssueBillInfo = null;// ���۳��ⵥinfo
			SaleIssueEntryInfo saleIssueEntryInfo;// ���۳��ⵥ��¼info
			ISaleIssueBill ips = SaleIssueBillFactory.getLocalInstance(ctx);// ������۳��ⵥ�Ľ�ڵ��ö���
			PreparedStatement ptm = null;
			try {
				int billHeadID = 0;
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("customer.*"));
				slor.add(new SelectorItemInfo("material.*"));
				slor.add(new SelectorItemInfo("entry.*"));
				slor.add(new SelectorItemInfo("entry.material.*"));
				saleIssueBillInfo = ips.getSaleIssueBillInfo(new ObjectUuidPK(billID), slor);// ������۳��ⵥinfo
				isSuccess = true;
				msg = null;

				// ������뵥��ͷ
				ptm = conn.prepareStatement(getInsertHeadSql());

				ptm.setString(1, saleIssueBillInfo.getNumber());// ���˵��ţ�ERP)
				ptm.setString(2, saleIssueBillInfo.getCustomer().getNumber());// �ͻ�ID
				ptm.setString(3, saleIssueBillInfo.getCustomer().getName());//�ͻ�name
				ptm.setDate(4, (Date) saleIssueBillInfo.getBizDate());// ��Ʊ����
				ptm.setString(5, "");// ������
				ptm.setString(6, "");// ��ע
				ptm.execute();

				// ����ѭ������ÿ����¼
				ptm = conn.prepareStatement(getInsertEntrySql());
				for (int j = 0; j < saleIssueBillInfo.getEntry().size(); j++) {
					saleIssueEntryInfo = saleIssueBillInfo.getEntry().get(j);

					// ����Ҫ�����ֵ
					//��ȡ���϶�Ӧ����
					StorageOrgUnitInfo storageOrgUnitInfo=saleIssueBillInfo.getStorageOrgUnit();
					String barMaterialNum=EASWUtils.getBarMaterialNumber(ctx, saleIssueEntryInfo.getMaterial(),storageOrgUnitInfo);//���ϱ���
					
					ptm.setInt(1, billHeadID);// ����id
					ptm.setString(2, saleIssueBillInfo.getNumber());// ���˵���
					ptm.setString(3, barMaterialNum);// ��Ʒid��Ӧ���ϱ���
					ptm.setBigDecimal(4, saleIssueEntryInfo.getQty());// KG
					ptm.setBigDecimal(5, BigDecimal.ZERO);// ����
					ptm.setString(6, saleIssueEntryInfo.getWarehouse().getNumber());// �ֿ�id
					ptm.setString(7, saleIssueEntryInfo.getRemark());// ��ע
					ptm.execute();// һ����¼�������
				}
				conn.commit();
				// ��eas�в��뵼����¼
				EASWUtils.insertHasExported(ctx, billType, saleIssueBillInfo.getBOSType().toString(), saleIssueBillInfo
						.getId().toString(), saleIssueBillInfo.getNumber());
				// �������۳��ⵥ���
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
				EASWUtils.insertLogs(ctx, logBean);// ������־
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

		// ����ID ,���˵���(ERP) ,��ƷID ,KG ,���� ,�ֿ�ID������Ϊ���, ��ע
		sql.append(" insert into ").append(getTempEntryTable()).append(" ( ");
		sql.append(" main_id,fyd_id,cp_id,sl,js,Stock_id,Bz ");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,?,? ");
		sql.append(" )");
		return sql.toString();
	}

	public String getInsertHeadSql() {
		StringBuffer sql = new StringBuffer();

		// ���˵���(ERP),�ͻ�ID,��Ʊ����,������ID,��ע

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
	 * dep���ã�ִ�е������۳��ⵥ����
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
		System.out.println("---------------�������۳��ⵥ���-------------------");
	}
	
	//δʹ�ô˷���
	public String export2Temp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.BARSYSTEM_VALUE);
			if (conn == null) {
				throw new Exception("��ȷ�����Ӳ���������ȷ��");
			}

			conn.setAutoCommit(false);// ���Զ��ύ

			ISaleIssueBill ips = SaleIssueBillFactory.getLocalInstance(ctx);// ������۳��ⵥ�Ľ�ڵ��ö���
			EntityViewInfo ev = new EntityViewInfo();// ���ʵ�����
			FilterInfo filter = new FilterInfo();// ��ù�����Ϣ����
			// ���ù�����Ϣ
			filter.getFilterItems().add(new FilterItemInfo("CU.id", companyID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("baseStatus", BillBaseStatusEnum.AUDITED_VALUE, CompareType.EQUALS));
			if (StringUtils.isBlank(beginDate) && StringUtils.isBlank(endDate)) {
				// �����ʼ���ںͽ������ڶ�Ϊ�գ���Ϊ�������˵��ã�Ĭ��Ϊ��ǰҵ������
				filter.getFilterItems().add(new FilterItemInfo("auditTime", new java.util.Date(), CompareType.EQUALS));
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(
						new FilterItemInfo("auditTime", format.parse(beginDate + " 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(
						new FilterItemInfo("auditTime", format.parse(endDate + " 23:59:59"), CompareType.LESS_EQUALS));
			}
			filter.getFilterItems().add(new FilterItemInfo("isSysBill", 0, CompareType.EQUALS));
			ev.setFilter(filter);// ʵ��������ù�������
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("bizDate"));
			ev.setSorter(sorter);
			SaleIssueBillCollection coll = ips.getSaleIssueBillCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return null;
			}

			// ִ�в����Ԥ���뷽��
			PreparedStatement ptm = null;
			Boolean isSuccess = false;
			String msg = null;
			String billID = null;
			int billHeadID = 0;
			String billType="���۳��ⵥ";
			SaleIssueBillInfo saleIssueBillInfo = null;// ���۳��ⵥinfo
			SaleIssueEntryInfo saleIssueEntryInfo;// ���۳��ⵥ��¼info
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));

			slor.add(new SelectorItemInfo("material.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("customer.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			// ������뵥��
			for (int index = 0; index < coll.size(); index++) {

				try {
					saleIssueBillInfo = ips.getSaleIssueBillInfo(new ObjectUuidPK(coll.get(index).getString("id")), slor);// ������۳��ⵥinfo
					isSuccess = true;
					msg = null;
					billID = saleIssueBillInfo.getId().toString();

					// �Ѿ������ĵ��ݲ����ظ�����
					if (EASWUtils.checkHasExported(ctx, saleIssueBillInfo.getBOSType().toString(), saleIssueBillInfo.getId()
							.toString())) {
						continue;
					}
					// ������뵥��ͷ FYD_ID,Client_id,client_name,KP_DATE,CYR_ID,bz
					ptm = conn.prepareStatement(getInsertHeadSql());
					ptm.setString(1, saleIssueBillInfo.getNumber());// ���˵��ţ�ERP)
					ptm.setString(2, saleIssueBillInfo.getCustomer().getNumber());// �ͻ�ID
					ptm.setString(3, saleIssueBillInfo.getCustomer().getName());//�ͻ�����
					ptm.setDate(4, (Date) saleIssueBillInfo.getBizDate());// ��Ʊ����
					ptm.setString(5, "");// ������
					ptm.setString(6, "");// ��ע
					ptm.execute();

					// ����ѭ������ÿ����¼
					ptm = conn.prepareStatement(getInsertEntrySql());
					for (int j = 0; j < saleIssueBillInfo.getEntry().size(); j++) {
						saleIssueEntryInfo = saleIssueBillInfo.getEntry().get(j);

						// ����Ҫ�����ֵ
						//��ȡ���϶�Ӧ����
						StorageOrgUnitInfo storageOrgUnitInfo=saleIssueBillInfo.getStorageOrgUnit();
						String barMaterialNum=EASWUtils.getBarMaterialNumber(ctx, saleIssueEntryInfo.getMaterial(),storageOrgUnitInfo);//���ϱ���
						
						ptm.setInt(1, billHeadID);// ����id
						ptm.setString(2, saleIssueBillInfo.getNumber());// ���˵���
						ptm.setString(3, barMaterialNum);// ��Ʒid��Ӧ���ϱ���
						ptm.setBigDecimal(4, saleIssueEntryInfo.getQty());// KG
						ptm.setBigDecimal(5, BigDecimal.ZERO);// ����
						ptm.setString(6, saleIssueEntryInfo.getWarehouse().getNumber());// �ֿ�id
						ptm.setString(7,saleIssueEntryInfo.getRemark());// ��ע
						ptm.execute();// һ����¼�������
					}

					// ��eas�в��뵼����¼
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
					EASWUtils.insertLogs(ctx, logBean);// ������־
					
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
