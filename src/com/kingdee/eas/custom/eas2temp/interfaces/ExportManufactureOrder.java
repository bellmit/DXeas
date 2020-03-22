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
 * ���������������������񵥣�
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
				throw new Exception("��ȷ������ϵͳ���Ӳ���������ȷ");
			}
			if(connMuyang==null)
			{
				throw new Exception("��ȷ��������ϵͳ�Ӳ���������ȷ");
			}
			conn.setAutoCommit(false);
			connMuyang.setAutoCommit(false);
			
			String billType = "��������";
			IManufactureOrder ips = ManufactureOrderFactory
					.getLocalInstance(ctx);
			// ִ�в����Ԥ���뷽��
			PreparedStatement ptm = null;
			PreparedStatement ptmMY=null;
			try {
				isSuccess = true;
				msg = null;

				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("material.*"));
				// ����id���˻������������Ϣ
				manufactureOrderInfo = ips.getManufactureOrderInfo(
						new ObjectUuidPK(billID), slor);

				// ������������
				
				// ���ò���
				// ��ȡ���϶�Ӧ����
				StorageOrgUnitInfo storageOrgUnitInfo = manufactureOrderInfo
						.getStorageOrgUnit();
				String barMaterialNum = EASWUtils.getBarMaterialNumber(ctx,
						manufactureOrderInfo.getMaterial(), storageOrgUnitInfo);// ���ϱ���
				//����ϵͳ����
				ptm = conn.prepareStatement(getInsertHeadSql());
				ptm.setString(1, manufactureOrderInfo.getNumber());// ���ϵ�����
				/*-------2016��8��4�գ�ҵ�������޸�Ϊ������ڿ�ʼ-----------*/
				//ptm.setDate(2, (Date) manufactureOrderInfo.getBizDate());// ��������
				//2016��8��6��10:26:08���ʱ��ȥ��ʱ�䣬ֻ��������
				Timestamp pldate = manufactureOrderInfo.getAuditTime();
				ptm.setDate(2, new Date(pldate.getYear(),pldate.getMonth(),pldate.getDate()));// ��������
				//tm.setDate(2, new Date(manufactureOrderInfo.getAuditTime().getTime()));// ��������
				/*-------2016��8��4�գ�ҵ�������޸�Ϊ������ڽ���-----------*/
				ptm.setString(3, manufactureOrderInfo.getBomNum());// �䷽���
				ptm.setBigDecimal(4, manufactureOrderInfo.getQty());// ������
				ptm.setInt(5, 1);// �����߱��
				ptm.setString(6, barMaterialNum);// ��Ӧ��Ʒ���
				ptm.setString(7, "");// ��ע
				int defaultcfzl = 1000;
				if (EASWUtils.getDefaultcfzl(ctx, manufactureOrderInfo
						.getMaterial().getId().toString(), manufactureOrderInfo
						.getCU().getId().toString()) != 0) {
					defaultcfzl = EASWUtils.getDefaultcfzl(ctx,
							manufactureOrderInfo.getMaterial().getId()
									.toString(), manufactureOrderInfo.getCU()
									.getId().toString());
				}
				ptm.setInt(8, defaultcfzl);// Ĭ�ϲ������
				ptm.execute();
				
				try {
					//����ϵͳ����
					ptmMY=connMuyang.prepareStatement(getMYInsertHeadSql());
					ptmMY.setString(1,manufactureOrderInfo.getNumber());//��������number
					/*-------2016��8��4�գ�ҵ�������޸�Ϊ������ڿ�ʼ-----------*/
					//ptmMY.setDate(2, (Date) manufactureOrderInfo.getBizDate());//ҵ������
					//2016��8��6��10:26:08���ʱ��ȥ��ʱ�䣬ֻ��������
					ptmMY.setDate(2,  new Date(pldate.getYear(),pldate.getMonth(),pldate.getDate()) );//ҵ������
					/*-------2016��8��4�գ�ҵ�������޸�Ϊ������ڽ���-----------*/
					ptmMY.setString(3, manufactureOrderInfo.getBomNum());//bomnumber
					ptmMY.setString(4, barMaterialNum);//��Ӧ��Ʒ���
					ptmMY.setBigDecimal(5, manufactureOrderInfo.getQty());
					ptmMY.execute();
				} catch (Exception e) {
					// TODO: handle exception
					//throw new EASBizException(new NumericExceptionSubItem("001",e.getMessage()));
				}

				conn.commit();// �����ύcommit
				connMuyang.commit();//�����ύ
				// ��eas�в��뵼����¼
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
				EASWUtils.insertLogs(ctx, logBean);// ������־
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
		} finally {// ���ն�Ҫ�ر����ݿ�����
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



	// ��������û�з�¼
	public String getTempEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTempHeadTable() {
		// TODO Auto-generated method stub
		return "sc_pfjh";
	}
	//���������м��
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

	// �����м���ͷ
	public String getMYTempHeadTable() {
		return "bomOrders";
	}

	// ��������м��sql
	public String getMYInsertHeadSql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getMYTempHeadTable()).append("(");
		sql.append(" number,date,bomNum,productnumber,qty");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?)");
		return sql.toString();
	}
	
	/**
	 * ������ã�����ɾ�������м�����������
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
					throw new Exception("��ȷ�����Ӳ���������ȷ");
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
				EASWUtils.insertLogs(ctx, logBean);// ������־
				throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
			} finally {// ���ն�Ҫ�ر����ݿ�����
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
	 * ������ã�����ɾ�������м�����������
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
					throw new Exception("��ȷ�����Ӳ���������ȷ");
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
				EASWUtils.insertLogs(ctx, logBean);// ������־
				throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
			} finally {// ���ն�Ҫ�ر����ݿ�����
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
	 * dep���ã�ִ�е���������������
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
		System.out.println("---------------���������������-------------------");
	}
	
	//δʹ�ô˷���
	public String export2Temp(Context ctx, String companyID, String beginDate,
			String endDate) throws EASBizException {
		Connection conn = null;

		try {
			conn = EASWUtils.getTempConnection(ctx, companyID,
					TargetSystem.BARSYSTEM_VALUE);
			if (conn == null) {
				throw new Exception("��ȷ�����Ӳ���������ȷ");
			}
			conn.setAutoCommit(false);

			IManufactureOrder ips = ManufactureOrderFactory
					.getLocalInstance(ctx);
			// ʵ����ʾ��Ϣ
			EntityViewInfo ev = new EntityViewInfo();
			// ������������
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(
					new FilterItemInfo("CU.id", companyID, CompareType.EQUALS));
			filter.getFilterItems().add(
					new FilterItemInfo("baseStatus",
							BillBaseStatusEnum.AUDITED_VALUE,
							CompareType.EQUALS));
			if (StringUtils.isBlank(beginDate) && StringUtils.isBlank(endDate)) {
				// �����ʼ���ںͽ������ڶ�Ϊ�գ���Ϊ�������˵��ã�Ĭ��Ϊ��ǰҵ�����ڡ�
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
			// ��������ڼ�����е� -������������
			ManufactureOrderCollection coll = ips
					.getManufactureOrderCollection(ev);
			if (coll == null || coll.size() <= 0) {
				// �鲻������
				return null;
			}
			// ִ�в����Ԥ���뷽��
			PreparedStatement ptm = null;
			Boolean isSuccess = false;
			String msg = null;
			String billID = null;
			String billType = "��������";
			ManufactureOrderInfo manufactureOrderInfo = null;
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("material.*"));
			// ������õ��������� ���� ������뵽�м����
			for (int index = 0; index < coll.size(); index++) {
				try {
					// ����id���˻������������Ϣ
					manufactureOrderInfo = ips.getManufactureOrderInfo(
							new ObjectUuidPK(coll.get(index).getString("id")),
							slor);
					billID = manufactureOrderInfo.getString("id");
					isSuccess = true;
					msg = null;
					// �Ѿ������ĵ��ݲ����ظ�����
					if (EASWUtils.checkHasExported(ctx, manufactureOrderInfo
							.getBOSType().toString(), manufactureOrderInfo
							.getId().toString())) {
						continue;
					}
					// ��ȡ���϶�Ӧ����
					StorageOrgUnitInfo storageOrgUnitInfo = manufactureOrderInfo
							.getStorageOrgUnit();
					String barMaterialNum = EASWUtils.getBarMaterialNumber(ctx,
							manufactureOrderInfo.getMaterial(),
							storageOrgUnitInfo);// ���ϱ���
					// ������������
					ptm = conn.prepareStatement(getInsertHeadSql());
					// ���ò���
					ptm.setString(1, manufactureOrderInfo.getNumber());// ���ϵ�����
					ptm.setDate(2, (Date) manufactureOrderInfo.getBizDate());// ��������
					ptm.setString(3, manufactureOrderInfo.getBomNum());// �䷽���
					ptm.setBigDecimal(4, manufactureOrderInfo.getQty());// ������
					ptm.setInt(5, 1);// �����߱��
					ptm.setString(6, barMaterialNum);// ��Ӧ��Ʒ���
					ptm.setString(7, manufactureOrderInfo.getRemark());// ��ע
					int defaultcfzl = 1000;
					if (EASWUtils.getDefaultcfzl(ctx, manufactureOrderInfo
							.getMaterial().getId().toString(),
							manufactureOrderInfo.getCU().getId().toString()) != 0) {
						defaultcfzl = EASWUtils.getDefaultcfzl(ctx,
								manufactureOrderInfo.getMaterial().getId()
										.toString(), manufactureOrderInfo
										.getCU().getId().toString());
					}
					ptm.setInt(8, defaultcfzl);// Ĭ�ϲ������
					ptm.execute();

					// ��eas�в��뵼����¼
					EASWUtils.insertHasExported(ctx, billType,
							manufactureOrderInfo.getBOSType().toString(),
							manufactureOrderInfo.getId().toString(),
							manufactureOrderInfo.getNumber());
					conn.commit();// �ύcommit
					// �������
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
					EASWUtils.insertLogs(ctx, logBean);// ������־
				}
			}
			if (ptm != null) {
				ptm.close();
			}
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e
					.getMessage()));
		} finally {// ���ն�Ҫ�ر����ݿ�����
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
