package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceFactory;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow;
import com.kingdee.eas.farm.carnivorous.basedata.isBorrow;

import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerBorrowControllerBean extends AbstractFarmerBorrowControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerBorrowControllerBean");


	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;		
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;	
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}


	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);

		this._update(ctx, new ObjectUuidPK(info.getId()), info);
		
		//反写养殖户基础资料的 借款页签--借款总额
		reWriteBorrow(ctx,info,true);
		
		
	}

	/**
	 * 反写养殖户基础资料的 借款页签--借款总额
	 * @param ctx
	 * @param info
	 * @param b 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reWriteBorrow(Context ctx, FarmerBorrowInfo info, boolean isAudit) throws EASBizException, BOSException {
		// TODO Auto-generated method stub

		//获取养殖户
		FarmerInfo farmerInfo = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(info.getFarmer().getId()));
		//养殖户资料的 借款总金额
		BigDecimal farmBorrow = UIRuleUtil.getBigDecimal(farmerInfo.getBorrowAmount());
        //借款单--金额字段
		BigDecimal borAmount = UIRuleUtil.getBigDecimal(info.getAmount());
		//实际反写金额
		BigDecimal actualAmuont = BigDecimal.ZERO;
		//判断审核与否
		if(isAudit){//审核操作
			if(info.getIsBorrow().equals(isBorrow.borrow)){//判断业务类型--如果是借款
				actualAmuont = farmBorrow.add(borAmount);
				String s1 = "/*dialect*/ update  CT_FM_Farmer set cfborrowamount = "+actualAmuont+" where fid = '"+farmerInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
			}else{//如果是还款
				actualAmuont = farmBorrow.subtract(borAmount);
				String s1 = "/*dialect*/ update  CT_FM_Farmer set cfborrowamount = "+actualAmuont+" where fid = '"+farmerInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
			}
		}else{//反审核操作
			if(info.getIsBorrow().equals(isBorrow.borrow)){//判断业务类型--如果是借款
				actualAmuont = farmBorrow.subtract(borAmount);
				String s1 = "/*dialect*/ update  CT_FM_Farmer set cfborrowamount = "+actualAmuont+" where fid = '"+farmerInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
			}else{//如果是还款
				actualAmuont = farmBorrow.add(borAmount);
				String s1 = "/*dialect*/ update  CT_FM_Farmer set cfborrowamount = "+actualAmuont+" where fid = '"+farmerInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
			}
		}





	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		//反写养殖户基础资料的 借款页签--借款总额
		reWriteBorrow(ctx,info,false);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerBorrowInfo info = FarmerBorrowFactory.getLocalInstance(ctx).getFarmerBorrowInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}
		super._delete(ctx, pk);
	}

	/**
	 * 调用转换规则生成凭证
	 */
	@Override
	protected void _voucher(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		super._voucher(ctx, model);
		try {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		CoreBillBaseCollection coreBillBaseColl = new CoreBillBaseCollection();

		//转换规则取   采购入库单  -- 销售出库单
		String botpName = "INM-131-v1.0-wyr";

		//采购入库单
		IFarmerBorrow iSaleOrder =FarmerBorrowFactory.getLocalInstance(ctx);

		IBOTMapping iMapping    = BOTMappingFactory.getLocalInstance(ctx);

		//获取btp的本地接口
		IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);

		//获取采购入库单的所有信息----源单据
		SelectorItemCollection slor = new SelectorItemCollection();
		slor.add("*");
		slor.add("SaleOrgUnit.*");
		FarmerBorrowInfo saleOrderInfo = null;

			saleOrderInfo = iSaleOrder.getFarmerBorrowInfo(new ObjectUuidPK(info.getId()),slor );


		IRowSet rs = null;
		if(!saleOrderInfo.getBaseStatus().equals(FarmBaseStatusEnum.approve)){
			//获取  目标单据的id
//			coreBillBaseColl.add(saleOrderInfo);
		}

		if(coreBillBaseColl.size() > 0){
			//根据 单据转换规则  获取   单据转换规则的实体--获得所设置的单据转换规则
			BOTMappingInfo botMappingInfo = iMapping.getBOTMappingInfo("where name='" + botpName + "'");
			if(botMappingInfo.getExtRule().isIsEffected()){
				//transformResult 为转换成功后自动生成的目标单据（coreBillBaseColl--源单据，botMappingInfo--单据转换规则）
				BTPTransformResult transformResult = iBTPManager.transform(coreBillBaseColl, botMappingInfo);
				//获取转换之后的目标单据
				IObjectCollection bills = transformResult.getBills();
				BOTRelationCollection botRelationCols = transformResult.getBOTRelationCollection();
				for (int i = 0; i < bills.size(); i++) {
					CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) bills.getObject(i);
					iBTPManager.submitRelations(destBillInfo, botRelationCols);
				}
			}

		}
		
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	
	
}