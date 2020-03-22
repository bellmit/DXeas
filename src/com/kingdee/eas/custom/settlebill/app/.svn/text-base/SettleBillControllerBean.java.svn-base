package com.kingdee.eas.custom.settlebill.app;

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
import com.kingdee.eas.base.form.ide.designer.action.ShowEmbedActionDesignerUI.BillStatus;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.custom.settlebill.SettleBillCollection;
import com.kingdee.eas.custom.settlebill.SettleBillFactory;
import com.kingdee.eas.custom.settlebill.SettleBillInfo;
import com.kingdee.eas.custom.settlebill.billStatus;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettleBillControllerBean extends AbstractSettleBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.settlebill.app.SettleBillControllerBean");


	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleBillInfo info = SettleBillFactory.getLocalInstance(ctx).getSettleBillInfo(new ObjectUuidPK(pk.toString()));
		if(info.getBillStatus().equals(billStatus.SAVE)||info.getBillStatus().equals(billStatus.SUBMIT)){
			super._delete(ctx, pk);
		}else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不能删除"));
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleBillInfo info = (SettleBillInfo)model;
		if(info.getBillStatus().equals(billStatus.SAVE)||info.getBillStatus().equals(billStatus.SUBMIT)){
			info.setBillStatus(billStatus.SAVE);
		}else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不能保存"));
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleBillInfo info = (SettleBillInfo)model;
		if(info.getBillStatus().equals(billStatus.SAVE)||info.getBillStatus().equals(billStatus.SUBMIT)){
			info.setBillStatus(billStatus.SUBMIT);
		}else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不能提交"));
		return super._submit(ctx, model);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleBillInfo info = (SettleBillInfo)model;
		if(info.getBillStatus().equals(billStatus.SUBMIT)){
			info.setBillStatus(billStatus.AUDIT);
			info.setAuditor((UserInfo)ctx.get(SysContextConstant.USERINFO));
			super._save(ctx, model);
		}else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不能审核"));
		}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleBillInfo info = (SettleBillInfo)model;
		if(info.getBillStatus().equals(billStatus.AUDIT)){
			info.setBillStatus(billStatus.SAVE);
			super._save(ctx, model);
			info.setAuditor(null);
		}else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不能反审核"));
		}

	@Override
	protected void _checkVoucher(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
	}
