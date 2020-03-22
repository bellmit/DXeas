package com.kingdee.eas.custom.bsxbudget.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo;
import com.kingdee.eas.custom.bsxbudget.billStatus;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BSXBudgetGroupControllerBean extends AbstractBSXBudgetGroupControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.bsxbudget.app.BSXBudgetGroupControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException{
		// TODO Auto-generated method stub
		BSXBudgetGroupInfo info = (BSXBudgetGroupInfo)model;
		if(!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许审核"));
		
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		Date date = new Date();
		info.setAuditor(user);
		info.setAuditTime(date);

		info.setBillStatus(billStatus.audit);
		super._save(ctx, model);
	}


	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetGroupInfo info = (BSXBudgetGroupInfo)model;
		if(!info.getBillStatus().equals(billStatus.audit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许反审核"));
		
		info.setAuditor(null);
		info.setAuditTime(null);

		info.setBillStatus(billStatus.save);
		super._save(ctx, model);
	}
	
	/**
	 * 保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetGroupInfo info = (BSXBudgetGroupInfo)model;
//		if(isExist(ctx, info))
//			throw new EASBizException(new NumericExceptionSubItem("001","当前期间的预算单据已存在"));
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许保存新增或保存状态的单据"));
//		modifyBSXBudgetFood(ctx,info);
		return super._save(ctx, model);
	}

	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetGroupInfo info = (BSXBudgetGroupInfo)model;
//		if(isExist(ctx, info))
//			throw new EASBizException(new NumericExceptionSubItem("001","当前期间的预算单据已存在"));
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许保存新增或保存状态的单据"));


		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, model);
	}
	
	/**
	 * 重复性检验
	 * @param ctx
	 * @param info
	 * @return
	 */
	protected boolean isExist(Context ctx,BSXBudgetGroupInfo info){
		String str = "";
		if(info!=null&&info.getPeriod()!=null)
			str="select * from T_BSX_BSXBudgetGroup where FPeriodID='"+info.getPeriod().getId().toString()+"'";
		if(info.getId()!=null)
			str+=" and fid<>'"+info.getId().toString()+"'";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, str);
			if(rs.size()>0)
				return true;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
}