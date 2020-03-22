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
																		// 生产入库单BOSTYPE
	private static final String purInwareBillBosType = "783061E3";// new
																	// PurInWarehsBillInfo
																	// ().
																	// getBOSType
																	// ()//
																	// 采购入库单BOSTYPE
	private static final String saleIssueBillBosType = "CC3E933B";// new
																	// SaleIssueBillInfo
																	// ().
																	// getBOSType
																	// ()//
																	// 销售出库单BOSTYPE
	private CoreBaseCollection destCol;
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		CCReceivingBillInfo info = (CCReceivingBillInfo) model;
		// 禁止重复审核 非提交不审核
		if (!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			return;
		}
		destCol=new CoreBaseCollection();
		try {
			this.createToInvBill(ctx, info, purInwareBillBosType);
			this.createToInvBill(ctx, info, ManufactureRecBillBosType);
			this.createToInvBill(ctx, info, saleIssueBillBosType);
			reWriteCCLeaveBill(ctx, info,BillBaseStatusEnum.FINISH);//反写商品鸡出场单
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
	 * 反写商品鸡出场单
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
		// 反禁止重复审核
		if (!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			reWriteCCLeaveBill(ctx, info,BillBaseStatusEnum.AUDITED);//反写商品鸡出场单
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
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}

	/**
	 * 生成出入库单
	 * 
	 * @throws BOSException
	 */
	private void createToInvBill(Context ctx, CCReceivingBillInfo info, String orderBillBosType) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		IInvBillBase iInstace = null;// 库存业务单据对象接口
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

			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			result = btp.transform(info, orderBillBosType);
			// [注释] result：为转换成功生的目标单据
			// objectValue：源单据的值对象
			destBillInfo = result.getBills().getObject(0);

			destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// 目标单据Id

			/*
			 * String number = null; while (true) { number = getAutoNumber(ctx,
			 * companyID, destBillInfo); if (!checkNumberIsExist(ctx, companyID,
			 * number, "t_im_saleIssuebill")) { break; } } ((SaleIssueBillInfo)
			 * destBillInfo).setNumber(number); iInstace.save(destPK,
			 * (CoreBaseInfo) destBillInfo);
			 */
			// [注释] 保存单据的关联系统
			try {// 提交 和审核
				
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
				// 如果目标单据时采购入库单 则设置 冲回方式为  根据系统参数获得的方式 TODO 查询对应系统参数
				// 分录先拆单。。。  需要根据采购入 编辑界面提交前操作 整理 TODO
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
				destBillInfo=iInstace.getValue(destPK);//重新加载单据  单据状态不更新
				if (destBillInfo.get("baseStatus").equals(BillBaseStatusEnum.SUBMITED.getValue()))
					iInstace.audit(destPK);
				btp.submitRelations(result.getBOTRelationCollection());
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {// botp 失败 删除单据
			try {
				if (((InvBillBaseInfo) destBillInfo).getBaseStatus().equals(
						com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED))
					iInstace.unAudit(destPK);// 反审核
				iInstace.delete(destPK);// 删除
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
	 * 删除BOTP已经生成的单据
	 * @param ctx
	 * @param col
	 */
	private void deleteBTPBills(Context ctx,CoreBaseCollection col) {
		IInvBillBase iInstace = null;// 库存业务单据对象接口			
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