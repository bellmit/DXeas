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
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;	
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}


	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ���ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","δ��׼���ϲ���ִ�д˲�����"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);

		this._update(ctx, new ObjectUuidPK(info.getId()), info);
		
		//��д��ֳ���������ϵ� ���ҳǩ--����ܶ�
		reWriteBorrow(ctx,info,true);
		
		
	}

	/**
	 * ��д��ֳ���������ϵ� ���ҳǩ--����ܶ�
	 * @param ctx
	 * @param info
	 * @param b 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reWriteBorrow(Context ctx, FarmerBorrowInfo info, boolean isAudit) throws EASBizException, BOSException {
		// TODO Auto-generated method stub

		//��ȡ��ֳ��
		FarmerInfo farmerInfo = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(info.getFarmer().getId()));
		//��ֳ�����ϵ� ����ܽ��
		BigDecimal farmBorrow = UIRuleUtil.getBigDecimal(farmerInfo.getBorrowAmount());
        //��--����ֶ�
		BigDecimal borAmount = UIRuleUtil.getBigDecimal(info.getAmount());
		//ʵ�ʷ�д���
		BigDecimal actualAmuont = BigDecimal.ZERO;
		//�ж�������
		if(isAudit){//��˲���
			if(info.getIsBorrow().equals(isBorrow.borrow)){//�ж�ҵ������--����ǽ��
				actualAmuont = farmBorrow.add(borAmount);
				String s1 = "/*dialect*/ update  CT_FM_Farmer set cfborrowamount = "+actualAmuont+" where fid = '"+farmerInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
			}else{//����ǻ���
				actualAmuont = farmBorrow.subtract(borAmount);
				String s1 = "/*dialect*/ update  CT_FM_Farmer set cfborrowamount = "+actualAmuont+" where fid = '"+farmerInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
			}
		}else{//����˲���
			if(info.getIsBorrow().equals(isBorrow.borrow)){//�ж�ҵ������--����ǽ��
				actualAmuont = farmBorrow.subtract(borAmount);
				String s1 = "/*dialect*/ update  CT_FM_Farmer set cfborrowamount = "+actualAmuont+" where fid = '"+farmerInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
			}else{//����ǻ���
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
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		//��д��ֳ���������ϵ� ���ҳǩ--����ܶ�
		reWriteBorrow(ctx,info,false);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerBorrowInfo info = FarmerBorrowFactory.getLocalInstance(ctx).getFarmerBorrowInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�Ѿ���׼����ã�����ɾ����"));
		}
		super._delete(ctx, pk);
	}

	/**
	 * ����ת����������ƾ֤
	 */
	@Override
	protected void _voucher(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		super._voucher(ctx, model);
		try {
		FarmerBorrowInfo info = (FarmerBorrowInfo ) model;
		CoreBillBaseCollection coreBillBaseColl = new CoreBillBaseCollection();

		//ת������ȡ   �ɹ���ⵥ  -- ���۳��ⵥ
		String botpName = "INM-131-v1.0-wyr";

		//�ɹ���ⵥ
		IFarmerBorrow iSaleOrder =FarmerBorrowFactory.getLocalInstance(ctx);

		IBOTMapping iMapping    = BOTMappingFactory.getLocalInstance(ctx);

		//��ȡbtp�ı��ؽӿ�
		IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);

		//��ȡ�ɹ���ⵥ��������Ϣ----Դ����
		SelectorItemCollection slor = new SelectorItemCollection();
		slor.add("*");
		slor.add("SaleOrgUnit.*");
		FarmerBorrowInfo saleOrderInfo = null;

			saleOrderInfo = iSaleOrder.getFarmerBorrowInfo(new ObjectUuidPK(info.getId()),slor );


		IRowSet rs = null;
		if(!saleOrderInfo.getBaseStatus().equals(FarmBaseStatusEnum.approve)){
			//��ȡ  Ŀ�굥�ݵ�id
//			coreBillBaseColl.add(saleOrderInfo);
		}

		if(coreBillBaseColl.size() > 0){
			//���� ����ת������  ��ȡ   ����ת�������ʵ��--��������õĵ���ת������
			BOTMappingInfo botMappingInfo = iMapping.getBOTMappingInfo("where name='" + botpName + "'");
			if(botMappingInfo.getExtRule().isIsEffected()){
				//transformResult Ϊת���ɹ����Զ����ɵ�Ŀ�굥�ݣ�coreBillBaseColl--Դ���ݣ�botMappingInfo--����ת������
				BTPTransformResult transformResult = iBTPManager.transform(coreBillBaseColl, botMappingInfo);
				//��ȡת��֮���Ŀ�굥��
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