package com.kingdee.eas.dep.app;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.ISCMBillBase;
import com.kingdee.eas.scm.common.SCMBillBaseInfo;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillFactory;
import com.kingdee.eas.scm.im.inv.PurInWarehsBillInfo;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;

/**
 * 销售出库审核自动转采购入库单
 * @author Administrator
 *
 */
public class SaleIssue2PurInwarehouseAppDep {
	/**
	 * 生成采购入库单
	 * @param ctx
	 * @param model
	 */
	public static void createToPurInwarehouse(Context ctx,Object model,String botpNum) {
		try {
			String id="";
			SaleIssueBillInfo info=null;
			if(model instanceof IObjectValue) {
				id= ((IObjectValue)model).getString("id");
			}else{
			}
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("customer.*"));
			slor.add(new SelectorItemInfo("customer.internalCompany.*"));
			info=SaleIssueBillFactory.getLocalInstance(ctx).getSaleIssueBillInfo(new ObjectUuidPK(model.toString()),slor);
			//非集团内公司不执行
			if(!info.getCustomer().isIsInternalCompany()) {
				return;
			}
			
			BOTMappingInfo botmappinginfo=null;
			if(StringUtils.isNotBlank(botpNum)) {
				BOTMappingCollection cols = BOTMappingFactory.getLocalInstance(ctx).getBOTMappingCollection("where name='"+botpNum+"'");
				if(cols!=null&&cols.size()>0) {
					botmappinginfo=cols.get(0);
				}
			}
			//BotpCommUtils.getInstance(ctx).
			PurInWarehsBillInfo purInfo = (PurInWarehsBillInfo) createToSCMBill(ctx, info, "783061E3", botmappinginfo);
			ObjectUuidPK orgID=new ObjectUuidPK(info.getCustomer().getInternalCompany().getId());
			StorageOrgUnitInfo sInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(orgID);
			if(purInfo.getStorageOrgUnit()==null) {
				purInfo.setStorageOrgUnit(sInfo);
			}
			if(StringUtils.isEmpty(purInfo.getNumber())) {
				purInfo.setNumber(PurInWarehsBillFactory.getLocalInstance(ctx).getNewNumber(purInfo, orgID.toString(), null));
			}
			CompanyOrgUnitInfo cInfo=CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(orgID);
			PurchaseOrgUnitInfo pInfo=PurchaseOrgUnitFactory.getLocalInstance(ctx).getPurchaseOrgUnitInfo(orgID);
			for(int index=0;index<purInfo.getEntry().size();index++) {
				if(purInfo.getEntry().get(index).getStorageOrgUnit()==null){
					purInfo.getEntry().get(index).setStorageOrgUnit(sInfo);
				}
				if(purInfo.getEntry().get(index).getCompanyOrgUnit()==null) {
					purInfo.getEntry().get(index).setCompanyOrgUnit(cInfo);
				}
				if(purInfo.getEntry().get(index).getPurchaseOrgUnit()==null) {
					purInfo.getEntry().get(index).setPurchaseOrgUnit(pInfo);
				}
				if(purInfo.getEntry().get(index).getWarehouse()==null) {
					purInfo.getEntry().get(index).setWarehouse(EASWUtils.getDefaultByMaterial(ctx, orgID.toString(), purInfo.getEntry().get(index).getId().toString()));
				}
			}
			
			if(purInfo.getBaseStatus().equals(BillBaseStatusEnum.ADD)) {
				PurInWarehsBillFactory.getLocalInstance(ctx).addnew(purInfo);
			}
			if(purInfo.getBaseStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
				PurInWarehsBillFactory.getLocalInstance(ctx).submit(purInfo);
			}
//			if(purInfo.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)) {
//				PurInWarehsBillFactory.getLocalInstance(ctx).audit(new ObjectUuidPK(purInfo.getId()));
//			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 生成供应链单据
	 * 
	 * @throws BOSException
	 */
	private static SCMBillBaseInfo createToSCMBill(Context ctx, CoreBillBaseInfo info, String orderBillBosType,BOTMappingInfo botmappinginfo) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ISCMBillBase iInstace = null;// 库存业务单据对象接口
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(orderBillBosType));
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBillBase iCoreBase = (ICoreBillBase) mtd.invoke(cls, new Object[] { ctx });
			iInstace = (ISCMBillBase) iCoreBase;

			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			if(botmappinginfo==null)
				result = btp.transform(info, orderBillBosType);
			else 
				result = btp.transform(info, botmappinginfo);
			// [注释] result：为转换成功生的目标单据
			
			// [注释] 保存单据的关联系统
			try {// 提交 和审核

				// objectValue：源单据的值对象
				for(int index=0;index<result.getBills().size();index++) {
//					if(((SCMBillBaseInfo)destBillInfo).getEntries().size()>0) {
						destBillInfo = result.getBills().getObject(index);
						iInstace.save((CoreBaseInfo) destBillInfo);
				}
//				btp.submitRelations(result.getBOTRelationCollection());
				return (SCMBillBaseInfo) destBillInfo;
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {// botp 失败 删除单据
			try {
				if (((SCMBillBaseInfo) destBillInfo).getBaseStatus().equals(com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED))
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
	
}
