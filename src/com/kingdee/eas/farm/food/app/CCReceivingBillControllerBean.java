package com.kingdee.eas.farm.food.app;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.param.ParamItemInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.BizDirectionEnum;
import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.RecIssueTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.TransactionInvUpdateTypeCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CCLeaveBillFactory;
import com.kingdee.eas.farm.breed.business.CCLeaveBillInfo;
import com.kingdee.eas.farm.breed.business.ICCLeaveBill;
import com.kingdee.eas.farm.food.CCReceivingBillFactory;
import com.kingdee.eas.farm.food.CCReceivingBillInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.mm.common.ParameterUtil;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.DischargeTypeEnum;
import com.kingdee.eas.scm.im.inv.IInvBillBase;
import com.kingdee.eas.scm.im.inv.InvBillBaseEntryInfo;
import com.kingdee.eas.scm.im.inv.InvBillBaseInfo;
import com.kingdee.eas.scm.im.inv.InvCommonUtils;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillFactory;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class CCReceivingBillControllerBean extends AbstractCCReceivingBillControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.farm.food.app.CCReceivingBillControllerBean");

	private static final String ManufactureRecBillBosType = "FA1292B4";// new
																		// ManufactureRecBillInfo
																		// ().
																		// getBOSType
																		// ();//
																		// ������ⵥBOSTYPE
	private static final String purInwareBillBosType = "783061E3";// new
																	// PurInWarehsBillInfo
																	// ().
																	// getBOSType
																	// ()//
																	// �ɹ���ⵥBOSTYPE
	private static final String saleIssueBillBosType = "CC3E933B";// new
																	// SaleIssueBillInfo
																	// ().
																	// getBOSType
																	// ()//
																	// ���۳��ⵥBOSTYPE
	private CoreBaseCollection destCol;
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		CCReceivingBillInfo info = (CCReceivingBillInfo) model;
		// ��ֹ�ظ���� ���ύ�����
		if (!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			return;
		}
		destCol=new CoreBaseCollection();
		try {
			this.createToInvBill(ctx, info, purInwareBillBosType);
			this.createToInvBill(ctx, info, ManufactureRecBillBosType);
			this.createToInvBill(ctx, info, saleIssueBillBosType);
			reWriteCCLeaveBill(ctx, info,BillBaseStatusEnum.FINISH);//��д��Ʒ��������
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			deleteBTPBills(ctx, destCol);
			throw new BOSException(ex);
		}
		logger.info("trans ok");
	}
	/**
	 * ��д��Ʒ��������
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reWriteCCLeaveBill(Context ctx,CCReceivingBillInfo info,BillBaseStatusEnum status) throws BOSException, EASBizException {
		ICCLeaveBill cclinstance = CCLeaveBillFactory.getLocalInstance(ctx);
		for(int index=0;index<info.getEntrys().size();index++) {
			CCLeaveBillInfo cclInfo = info.getEntrys().get(index).getCCLeaveBill();
			if(cclInfo==null) 
				continue;
			cclInfo.setBillStatus(status);
//			cclinstance.update(new ObjectUuidPK(cclInfo.getId()),cclInfo);
			String upSql  = "update CT_FM_CCLeaveBill set CFBillStatus =? where fid=?";
		    
			Object[] args = {status.getValue(),info.getId().toString()};
			DbUtil.execute(ctx, upSql,args);
//			String sql = "update ";
			
		}
	}
	
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CCReceivingBillInfo info = (CCReceivingBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CCReceivingBillInfo info = (CCReceivingBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		CCReceivingBillInfo info = (CCReceivingBillInfo) model;
		// ����ֹ�ظ����
		if (!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			reWriteCCLeaveBill(ctx, info,BillBaseStatusEnum.AUDITED);//��д��Ʒ��������
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CCReceivingBillInfo info = CCReceivingBillFactory.getLocalInstance(ctx).getCCReceivingBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ˣ���ֹɾ��"));
		}
		super._delete(ctx, pk);
	}

	/**
	 * ���ɳ���ⵥ
	 * 
	 * @throws BOSException
	 */
	private void createToInvBill(Context ctx, CCReceivingBillInfo info, String orderBillBosType) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType��Ŀ�굥��BOS����
		IInvBillBase iInstace = null;// ���ҵ�񵥾ݶ���ӿ�
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(orderBillBosType));
			if (eo == null) {
				return;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBase iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
			iInstace = (IInvBillBase) iCoreBase;
			// SaleIssueBillFactory.getLocalInstance(ctx).audit(IObjectPK)
			// Method submitMtd=iCoreBase.getClass().getMethod("submit", new
			// Class[]{com.kingdee.eas.framework.CoreBillBaseInfo.class});
			// Method auditMtd=iCoreBase.getClass().getMethod("audit", new
			// Class[]{com.kingdee.bos.dao.IObjectPK.class});
			// Method unAuditMtd=iCoreBase.getClass().getMethod("unAudit", new
			// Class[]{com.kingdee.bos.dao.IObjectPK.class});
			// ************************************

			// ����BOTP�ӿ��Զ����ɵ���--��ⵥ
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [ע��]��ȡBTP�ı��ؽӿ�
			result = btp.transform(info, orderBillBosType);
			// [ע��] result��Ϊת���ɹ�����Ŀ�굥��
			// objectValue��Դ���ݵ�ֵ����
			destBillInfo = result.getBills().getObject(0);

			destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// Ŀ�굥��Id

			/*
			 * String number = null; while (true) { number = getAutoNumber(ctx,
			 * companyID, destBillInfo); if (!checkNumberIsExist(ctx, companyID,
			 * number, "t_im_saleIssuebill")) { break; } } ((SaleIssueBillInfo)
			 * destBillInfo).setNumber(number); iInstace.save(destPK,
			 * (CoreBaseInfo) destBillInfo);
			 */
			// [ע��] ���浥�ݵĹ���ϵͳ
			try {// �ύ �����
				
				if(((InvBillBaseInfo) destBillInfo).getTransactionType()!=null) {
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
						// InvBillBaseEntryInfo d =
						// (InvBillBaseEntryInfo)sd.getObject(i);
						((InvBillBaseEntryInfo) sd.getObject(i)).setInvUpdateType(updateType);
					}
					RecIssueTypeInfo riType = ((InvBillBaseInfo)destBillInfo).getTransactionType().getRiType();
					if(riType.getBizDirection()==null) {
						((InvBillBaseInfo)destBillInfo).getTransactionType().getRiType().setBizDirection(BizDirectionEnum.normal);
					};
				}
				destCol.add((CoreBaseInfo) destBillInfo);
				/*************************************wgj edit TODO ***************************************/
				//iInstace.save((CoreBaseInfo) destBillInfo);
				// ���Ŀ�굥��ʱ�ɹ���ⵥ ������ ��ط�ʽΪ  ����ϵͳ������õķ�ʽ TODO ��ѯ��Ӧϵͳ����
				// ��¼�Ȳ𵥡�����  ��Ҫ���ݲɹ��� �༭�����ύǰ���� ���� TODO
				DischargeTypeEnum disTypeEnum = null;
				if(destBillInfo != null && destBillInfo instanceof PurInWarehsBillInfo){
					PurInWarehsBillInfo purInfo = (PurInWarehsBillInfo) destBillInfo;
					StorageOrgUnitInfo stoOrgInfo = purInfo.getStorageOrgUnit();
					if(stoOrgInfo != null){
						ParamItemInfo piinfo = ParameterUtil.getParamItemByCodeAndOrg(ctx, "SCM_CAL_001", stoOrgInfo.getId().toString());
						if(piinfo != null){
							String paramValue = piinfo.getValue();
							disTypeEnum = DischargeTypeEnum.getEnum(Integer.valueOf(paramValue));
							purInfo.setDischargeType(DischargeTypeEnum.getEnum(Integer.valueOf(paramValue)));
						}
					}
				}
				
				if(destBillInfo != null && destBillInfo instanceof PurInWarehsBillInfo){
					
					IObjectPK pk = PurInWarehsBillFactory.getLocalInstance(ctx).submit((CoreBaseInfo)destBillInfo);
					if(pk != null && disTypeEnum != null){
						String sql = "update T_IM_PurInWarehsBill set FDischargeType =? where fid=?";
						Object[] args = {disTypeEnum.getValue(),pk.toString()};
						DbUtil.execute(ctx, sql, args);
					}
					
				}else{
					iInstace.submit((CoreBaseInfo) destBillInfo);
				}
				
				/******************************wgj edit TODO********************************************/
				destBillInfo=iInstace.getValue(destPK);//���¼��ص���  ����״̬������
				if (destBillInfo.get("baseStatus").equals(BillBaseStatusEnum.SUBMITED.getValue()))
					iInstace.audit(destPK);
				btp.submitRelations(result.getBOTRelationCollection());
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {// botp ʧ�� ɾ������
			try {
				if (((InvBillBaseInfo) destBillInfo).getBaseStatus().equals(
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
	 * ɾ��BOTP�Ѿ����ɵĵ���
	 * @param ctx
	 * @param col
	 */
	private void deleteBTPBills(Context ctx,CoreBaseCollection col) {
		IInvBillBase iInstace = null;// ���ҵ�񵥾ݶ���ӿ�			
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
		InvBillBaseInfo info;
		ObjectUuidPK pk;
		for(int index=0;index<col.size();index++) {
			try{
				info=(InvBillBaseInfo) col.get(index);
				pk=new ObjectUuidPK(info.getId());
				EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(info.getBOSType().toString()));
				if (eo == null) {
					return;
				}
				Class cls = Class.forName(eo.getBusinessImplFactory());
				Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
				iInstace = (IInvBillBase) mtd.invoke(cls, new Object[] { ctx });
				info=iInstace.getInvBillBaseInfo(pk);
				if(info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
					iInstace.unAudit(pk);
				}
				iInstace.delete(pk);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
}