package com.kingdee.eas.weighbridge.comm;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.TransactionInvUpdateTypeCollection;
import com.kingdee.eas.common.EASBizException;
//import com.kingdee.eas.farm.feedfactory.ILocalPurMATPriceEntry;
//import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceEntryFactory;
//import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceEntryInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.scm.common.AbstractSCMBillEntryBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.ISCMBillBase;
import com.kingdee.eas.scm.im.inv.IInvBillBase;
import com.kingdee.eas.scm.im.inv.InvBillBaseEntryInfo;
import com.kingdee.eas.scm.im.inv.InvBillBaseInfo;
import com.kingdee.eas.scm.im.inv.InvCommonUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.weighbridge.IWeighLog;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBaseType;
import com.kingdee.eas.weighbridge.WeighBillType;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.WeighLogFactory;
import com.kingdee.eas.weighbridge.WeighLogInfo;
import com.kingdee.eas.weighbridge.client.InStorageBillPlatformUI;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class WeighbridgeCommUtils {
	private static final Logger logger = CoreUIObject.getLogger(WeighbridgeCommUtils.class);
	
	// ���ι����� ��̼��ʱ��
	public static int shortestMinutesBetweenTwoWeigh = 10;
	/**
	 * �Աȵ���״̬
	 * @param nowStatus
	 * @param orderStatus
	 * @return
	 */
	public static Boolean checkBillStatus(WeighBaseStatus nowStatus,WeighBaseStatus orderStatus) {
		if(nowStatus.equals(orderStatus)) {
			return true;
		}
		return false;
	}
	/**
	 * ���ɹ�Ӧ������
	 * 
	 * @throws BOSException
	 */
	public static void createToSCMBill(Context ctx, CoreBillBaseInfo info, String orderBillBosType) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType��Ŀ�굥��BOS����
		ISCMBillBase iInstace = null;// ���ҵ�񵥾ݶ���ӿ�
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			//loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(orderBillBosType));
			if (eo == null) {
				return;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBase iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
			iInstace = (ISCMBillBase) iCoreBase;

			// ����BOTP�ӿ��Զ����ɵ���--��ⵥ
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [ע��]��ȡBTP�ı��ؽӿ�
			result = btp.transform(info, orderBillBosType);
			// [ע��] result��Ϊת���ɹ�����Ŀ�굥��
			// objectValue��Դ���ݵ�ֵ����
			destBillInfo = result.getBills().getObject(0);

			destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// Ŀ�굥��Id

			// [ע��] ���浥�ݵĹ���ϵͳ
			try {// �ύ �����
				if(((InvBillBaseInfo) destBillInfo).getTransactionType()!=null) {
					if(iInstace instanceof IInvBillBase) {//��浥�ݸ��� ��������
						FilterInfo filterInfo = new FilterInfo();
						filterInfo.getFilterItems().add(
								new FilterItemInfo("transactionType.id", ((InvBillBaseInfo) destBillInfo).getTransactionType()
										.getId().toString(), CompareType.EQUALS));
						String prefix = "invUpdateType.";
						filterInfo.getFilterItems().add(
								new FilterItemInfo(prefix + "status", Integer.valueOf(1), CompareType.EQUALS));
						EntityViewInfo ev = new EntityViewInfo();
						// filterInfo.mergeFilter(buildInvUpdateTypeFilterInfo(entry,
						// isF7), "AND");
						filterInfo.setMaskString("#0 AND #1");
						ev.setFilter(filterInfo);
		
						TransactionInvUpdateTypeCollection updateTypeCol = InvCommonUtils.getTransactionInvUpdateTypeCol(ctx,
								ev);
						InvUpdateTypeInfo updateType = null;
						if (updateTypeCol != null && updateTypeCol.size() > 0) {
							updateType = updateTypeCol.get(0).getInvUpdateType();
						}
						for (int i = 0; i < ((AbstractObjectCollection) destBillInfo.get("entry")).size(); i++) {
							AbstractObjectCollection sd = (AbstractObjectCollection) destBillInfo.get("entry");
							((InvBillBaseEntryInfo) sd.getObject(i)).setInvUpdateType(updateType);
						}
					}
				}
				// iInstace.save((CoreBaseInfo) destBillInfo);
				iInstace.submit((CoreBaseInfo) destBillInfo);
				if (destBillInfo.get("baseStatus").equals(BillBaseStatusEnum.SUBMITED))
					iInstace.audit(destPK);
				btp.submitRelations(result.getBOTRelationCollection());
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {// botp ʧ�� ɾ������
			try {
				if (((AbstractSCMBillEntryBaseInfo) destBillInfo).getBaseStatus().equals(
						com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED))
					iInstace.unAudit(destPK);// �����
				iInstace.delete(destPK);// ɾ��
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			try {
				if (destBillInfo != null)
					btp.removeAllRelation((CoreBillBaseInfo) destBillInfo);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			throw new BOSException(e1.getMessage());
		}
	}
	/**
	 * ����Ƿ�������ε���
	 * @param ctx
	 * @param pk
	 * @param coreBillInfo
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static void isExitBTPBill(Context ctx, IObjectPK pk, CoreBillBaseInfo coreBillInfo) throws BOSException,
			EASBizException {
		IBTPManager iBTPManager;
		if(ctx!=null)
			iBTPManager= BTPManagerFactory.getLocalInstance(ctx);
		else 
			iBTPManager= BTPManagerFactory.getRemoteInstance();
		if (!(iBTPManager.ifHaveDestBills(pk.toString()))) {
			try {
				if (coreBillInfo instanceof CoreBillBaseInfo) {
					iBTPManager.removeAllSRCRelation(coreBillInfo);
				}
			} catch (BTPException ex) {
				throw new BTPException(BTPException.RELATIONDELETEERROR, ex);
			}

		} else {
			throw new BillBaseException(new NumericExceptionSubItem("001","���ݴ������ε���"));
		}
	}
	/**
	 * ������֯ί�й�ϵ�õ� ��ί����֯ID
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	//��=-1,������֯=0,������֯=1,������֯=2,�ɹ���֯=3,�����֯=4,�ɱ�����=5,��������=6,�ϲ���Χ=8,����Ԫ=10,HR��֯=16,������֯=24,�ʼ���֯=32
	public static  String  getOrgIDByRelation(String fromOrgID,int fromType,int toType) throws BOSException, SQLException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select t1.FToUnitID");
		sql.append(" from T_ORG_UnitRelation t1");
		sql.append(" inner join T_ORG_TypeRelation t2 on t2.fid=t1.FTypeRelationID");
		sql.append(" where t2.FToType=? and t2.FFromType=?");
		sql.append(" and t2.FExistReverseDelegate=0");
		sql.append(" and t1.FFromUnitID=?");
		IRowSet rs=CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql.toString(),new Object[]{toType,fromType,fromOrgID});
		while(rs.next()) {
			return rs.getString("FToUnitID");
		}
		rs.close();
		return "testID";
	}
	
	/**
	 * ��ȡInstance
	 * 
	 * @param ctx
	 * @param eo
	 * @return
	 */
	public static ICoreBase getBizInstance(Context ctx, String bosType) {
		ICoreBase iCoreBase = null;
		try {
			EntityObjectInfo eo = getEntityObjectInfo(ctx, bosType);
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = null;
			if (ctx != null) {
				mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
				iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
			} else {
				mtd = cls.getMethod("getRemoteInstance");
				iCoreBase = (ICoreBase) mtd.invoke(cls);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return iCoreBase;
	}

	public static EntityObjectInfo getEntityObjectInfo(Context ctx, String bostype) {
		IMetaDataLoader loader = null;
		;
		if (ctx != null) {
			loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		} else {
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
		}
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bostype));
		if (eo != null)
			return eo;
		else
			return null;
	}
	/**
	 * ��ȡ�ѹ�������
	 * @param billID
	 * @param entryID
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 */
	public static BigDecimal getWeighQty(String billID,String entryID) throws BOSException, SQLException {
		BigDecimal value=BigDecimal.ZERO;
		StringBuffer sql=new StringBuffer();
		sql.append(" select isnull(sum(CFWeighQty),0) fqty");
		sql.append(" from ").append(InStorageBillPlatformUI.billDetailTable);
		sql.append(" where CFSourceBillID=? and CFSourceEntryID=?");
		IRowSet rs=CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql.toString(),new Object[]{billID,entryID});
		if(rs.next()) {
			value=rs.getBigDecimal("fqty");
		}
		rs.close();
		return value;
	}
	
	
	/**
	 * �ж�ָ��������ʱ���Ƿ���ڼ����������
	 * ����ҵ��ʵ�ʣ�ֻ��Ҫ�Ƚ� Ƥë  ��  ëƤ  �Լ�ë�����Ƥ��ʱ�� ���Ƿ����ʮ����
	 * @param weightTime
	 * @param WeightTime2
	 * @param weightTimeGross
	 * @param minutes
	 * @return
	 */
	public static boolean isWeightTimeTooShort(Date weighTime,Date weighTime2,Date weighTimeGross, int minutes){
		
		// Ƥë��ëƤ ����ƤëƤ����ĵڶ��ι���
		if(weighTime != null  && weighTimeGross != null) {
			 long time1 = weighTime.getTime();  
             long time2 = weighTimeGross.getTime();  
             long diff ;  
             if(time1<time2) {  
                 diff = time2 - time1;  
             } else {  
                 diff = time1 - time2;  
             }  
             long  days = diff / (1000 * 60 ); 
             if(days <= minutes){
            	 return true;
             }
		}
		// ƤëƤ����� �Ƚ����һ�ι���
		if(weighTime2 != null && weighTimeGross != null){
			 long time1 = weighTime2.getTime();  
             long time2 = weighTimeGross.getTime();  
             long diff ;  
             if(time1<time2) {  
                 diff = time2 - time1;  
             } else {  
                 diff = time1 - time2;  
             }  
             long  days = diff / (1000 * 60 ); 
             if(days <= minutes){
            	 return true;
             }
		}
			
		return false;
	}
	
	
	/**
	 * ���������־����
	 * @param ctx
	 * @param logInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static void addWeighLog(Context ctx, WeighLogInfo logInfo) throws BOSException, EASBizException{
		IWeighLog weighLog = null;
		if(ctx != null){
			weighLog = WeighLogFactory.getLocalInstance(ctx);
		}else{
			weighLog = WeighLogFactory.getRemoteInstance();
		}
		
		
		// ����loginfo
		weighLog.addnew(logInfo);
	}
	
	//��������/��˾ ��ȡ�����չ����۷�¼
//	public static LocalPurMATPriceEntryInfo getLocalPurPrice(Context ctx,String companyID,String materialID) {
//		try {	
//			ILocalPurMATPriceEntry iLocalPurMATPriceEntry=null;
//			SelectorItemCollection slor=new SelectorItemCollection();
//			slor.add("*");
//			slor.add("supplier.*");
//			if(ctx==null){
//				iLocalPurMATPriceEntry = LocalPurMATPriceEntryFactory.getRemoteInstance();
//			}else{
//				iLocalPurMATPriceEntry = LocalPurMATPriceEntryFactory.getLocalInstance(ctx);
//			}
//			StringBuffer sqlBuf = new StringBuffer();
//			sqlBuf.append(" /*dialect*/ ")
//			.append(" select  t2.fid fid ")
//			.append(" from CT_FM_LocalPurMATPrice t1 ")
//			.append(" inner join CT_FM_LocalPurMATPriceEntry t2 on t2.fparentid=t1.fid ")
//			.append(" where t1.CFCompanyID='"+companyID+"' ")
//			.append(" and t1.FBASESTATUS=2 ")
//			.append(" and t2.CFMaterialID='"+materialID+"' ")
//			.append(" order by t1.CFBEGINDATE desc");
//			//			.append(" and to_char(sysdate,'yyyy-mm-dd')>= to_char(t1.CFBEGINDATE,'yyyy-mm-dd') ")
//			//			.append(" and to_char(sysdate,'yyyy-mm-dd')<= to_char(t1.CFENDDATE,'yyyy-mm-dd') ");
//			IRowSet rs=null;
//			if(ctx==null){
//				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
//			}else{
//				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
//			}
//			if(rs.next()){
//				String fid=rs.getString("fid");
//				LocalPurMATPriceEntryInfo entryInfo = iLocalPurMATPriceEntry.getLocalPurMATPriceEntryInfo(new ObjectUuidPK(fid),slor);
//				return entryInfo;
//			}
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	
	public static WeighBaseType getWeighType(Object object, String macAddress,
			WeighBillType ckWeightBill, WeighBizType selectedItem) {
		// TODO Auto-generated method stub
		return null;
	}
}
