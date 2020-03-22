package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowNewFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowNewInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowNewCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.isBorrow;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerBorrowNewControllerBean extends AbstractFarmerBorrowNewControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerBorrowNewControllerBean");


	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		FarmerBorrowNewInfo info = (FarmerBorrowNewInfo ) model;		
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		FarmerBorrowNewInfo info = (FarmerBorrowNewInfo ) model;	
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}


	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerBorrowNewInfo info = (FarmerBorrowNewInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerBorrowNewInfo info = (FarmerBorrowNewInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ���ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerBorrowNewInfo info = (FarmerBorrowNewInfo ) model;

		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","δ��׼���ϲ���ִ�д˲�����"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);

		this._update(ctx, new ObjectUuidPK(info.getId()), info);

		//��д��ֳ���������ϵ� ���ҳǩ--����ܶ�
		reWriteBorrow(ctx,info,true);
		//��д��ֳ���������Ͻ���ܶ��ֶ�
		if(info.getFarm() != null){
			reWriteFarmer(ctx,info);
		}
	}

	/**
	 * ��д��ֳ���������Ͻ���ܶ��ֶ�
	 * @param ctx
	 * @param info
	 */
	private void reWriteFarmer(Context ctx, FarmerBorrowNewInfo info) {
		// TODO Auto-generated method stub

		String s1 = "/*dialect*/ select sum(t2.borroAmt) borroAmt,sum(t2.reAmt) reAmt from (" +
		" select sum(nvl(t1.CFAmount,0)) borroAmt, 0 reAmt from CT_FM_FarmerBorrowNew t1" +
		" where t1.CFIsBorrow = 1 and t1.CFBaseStatus in(2,3) and t1.CFFarmID = '"+info.getFarm().getId()+"'" +
		" union all select 0 borroAmt,sum(nvl(t1.CFAmount,0))  reAmt from CT_FM_FarmerBorrowNew t1" +
		" where t1.CFIsBorrow = 2 and t1.CFBaseStatus in(2,3)  and t1.CFFarmID = '"+info.getFarm().getId()+"' )t2";
		try {
			//���
			BigDecimal borroAmt = BigDecimal.ZERO;
			//����
			BigDecimal reAmt = BigDecimal.ZERO;
			BigDecimal marginAmt = BigDecimal.ZERO;
			IRowSet r1 = DbUtil.executeQuery(ctx,s1);
			if(r1.next()){
				borroAmt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("borroAmt"));
				reAmt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("reAmt"));
				marginAmt = borroAmt.subtract(reAmt);
				String s2 = "/*dialect*/ update CT_FM_Farm set CFBorrowAmt = "+marginAmt+"  where fid = '"+info.getFarm().getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * ��д��ֳ���������ϵ� ���ҳǩ--����ܶ�
	 * @param ctx
	 * @param info
	 * @param b 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reWriteBorrow(Context ctx, FarmerBorrowNewInfo info, boolean isAudit) throws EASBizException, BOSException {
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
		FarmerBorrowNewInfo info = (FarmerBorrowNewInfo ) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		//��д��ֳ���������ϵ� ���ҳǩ--����ܶ�
		reWriteBorrow(ctx,info,false);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);

		//��д��ֳ���������Ͻ���ܶ��ֶ�
		if(info.getFarm() != null){
			reWriteFarmer(ctx,info);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerBorrowNewInfo info = FarmerBorrowNewFactory.getLocalInstance(ctx).getFarmerBorrowNewInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�Ѿ���׼����ã�����ɾ����"));
		}
		super._delete(ctx, pk);
	}





}