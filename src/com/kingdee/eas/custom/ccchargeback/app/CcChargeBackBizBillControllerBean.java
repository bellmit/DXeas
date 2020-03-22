package com.kingdee.eas.custom.ccchargeback.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

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

import com.kingdee.eas.farm.food.CCReceivingBillFactory;
import com.kingdee.eas.farm.food.CCReceivingBillInfo;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillEntryInfo;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo;
import com.kingdee.eas.custom.ccchargeback.billStatus;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillCollection;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CcChargeBackBizBillControllerBean extends AbstractCcChargeBackBizBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.ccchargeback.app.CcChargeBackBizBillControllerBean");

	/**
	 * 审核
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		//标准的审核操作
		CcChargeBackBizBillInfo info = (CcChargeBackBizBillInfo)model;
		if(!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许审核提交状态的单据"));
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		Date date = new Date();
		info.setAuditor(user);
		info.setAuditTime(date);
		info.setBillStatus(billStatus.audit);

		super._save(ctx, model);

	}



	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CcChargeBackBizBillInfo info = (CcChargeBackBizBillInfo)model;
		if(!info.getBillStatus().equals(billStatus.audit))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许反审核审核状态的单据"));
		info.setAuditor(null);
		info.setAuditTime(null);
		info.setBillStatus(billStatus.save);
		super._save(ctx, model);
	}

	/**
	 * 删除
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		CoreBaseCollection coll = CcChargeBackBizBillFactory.getLocalInstance(ctx).getCollection("where id='"+pk.toString()+"'");
		CcChargeBackBizBillInfo info=(CcChargeBackBizBillInfo) coll.get(0);
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许删除保存状态的单据"));

		super._delete(ctx, pk);
	}

	/**
	 * 保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CcChargeBackBizBillInfo info = (CcChargeBackBizBillInfo)model;
		if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		info.setBillStatus(billStatus.save);
		return super._save(ctx, model);
	}

	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CcChargeBackBizBillInfo info = (CcChargeBackBizBillInfo)model;
		if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));
		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, model);
	}
}