package com.kingdee.eas.custom.signwasthetable.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
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
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.OverPayEntryCollection;
import com.kingdee.eas.custom.signwasthetable.OverPayInfo;
import com.kingdee.eas.custom.signwasthetable.OverPayCollection;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OverPayControllerBean extends AbstractOverPayControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.OverPayControllerBean");

	/**
	 *查看原始（合同）单据
	 */
	@Override
	protected void _viewSrcBill(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}

	/**
	 *审核
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {/*
		// TODO Auto-generated method stub
		OverPayInfo info = (OverPayInfo)model;
		//获得来源单据（合同）的info
		String id = info.getContractSrcId();
		ContractInfo cInfo=null;
		ContractPaymentCollection cpEntry=null;
		OverPayEntryCollection overPayEntrys = info.getEntrys();
		try {
			cInfo = ContractFactory.getLocalInstance(ctx).getContractInfo(new ObjectUuidPK(id));
			cpEntry=cInfo.getPayment();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//根据超额付款的单据内容修改原来的合同签呈（修改的内容包括  最大可付款金额，未申请付款金额，未申请付款金额本位币）
		for(int i=0;i<overPayEntrys.size();i++)
		{
			BigDecimal oldValue = (BigDecimal)cpEntry.get(i).getOverAmt();//原合同分录的值
			BigDecimal newValue = (BigDecimal)overPayEntrys.get(i).getOverAmt();//将要赋的新值
			if(oldValue.compareTo(newValue)!=0)//两者不相等则进行修改
			{
				cpEntry.get(i).setOverAmt((BigDecimal)overPayEntrys.get(i).getOverAmt());
				BigDecimal req = BigDecimal.ZERO;				
				if(cpEntry.get(i).getRequiredPayAmount()!=null)//如果已申请付款金额不为空，则对应的修改未申请付款金额
					req=cpEntry.get(i).getRequiredPayAmount();
				cpEntry.get(i).setUnRequiredAmt((BigDecimal)cpEntry.get(i).getOverAmt().subtract(req));
				if(cInfo.getExchangeRate()!=null)
					cpEntry.get(i).setUnReqAmtLocal(cpEntry.get(i).getUnRequiredAmt().multiply(cInfo.getExchangeRate()));			
			}
		}
		try {
			ContractFactory.getLocalInstance(ctx).save(cInfo);//保存修改
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		info.setBillStatus(billStatus.Audit);
		try {
			super._save(ctx, info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/}
    /**
     * 保存
     */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super._save(ctx, model);
	}
	/**
     * 提交
     */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		OverPayInfo info = (OverPayInfo)model;
		info.setBillStatus(billStatus.submit);
		super._save(ctx, info);
		return super._submit(ctx, info);
	}

	/**
	 * @operation
	 *
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub



	}
}