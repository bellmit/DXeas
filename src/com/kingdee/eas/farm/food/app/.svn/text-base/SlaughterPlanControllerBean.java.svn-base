package com.kingdee.eas.farm.food.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
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
import com.kingdee.eas.farm.food.SlaughterPlanInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.food.SlaughterPlanCollection;
import com.kingdee.eas.cm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SlaughterPlanControllerBean extends AbstractSlaughterPlanControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.food.app.SlaughterPlanControllerBean");

	@Override
	protected void _getSlaughterPlan(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		SlaughterPlanInfo billInfo = (SlaughterPlanInfo)model;
		billInfo.setBillStatus(com.kingdee.eas.cm.common.BillBaseStatusEnum.AUDITED);
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		Date date = new Date();
		billInfo.setAuditor(user);
		billInfo.setAuditDate(date);
		try {
			super._save(ctx, billInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void _refresh(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub
	}

	/**
	 *  保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		
		SlaughterPlanInfo info = (SlaughterPlanInfo)model;
		
		checkExist(ctx, info);
		
		
		if(!info.getBillStatus().equals(com.kingdee.eas.cm.common.BillBaseStatusEnum.ADD)&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)||info==null)
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存新增和暂存状态的单据"));
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		
		return super._save(ctx, model);
	}

	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SlaughterPlanInfo info = (SlaughterPlanInfo)model;
		
		checkExist(ctx,info);
		info.setBillStatus(com.kingdee.eas.cm.common.BillBaseStatusEnum.SUBMITED);
		super._save(ctx, info);
		return super._submit(ctx, model);
	}


	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub
		SlaughterPlanInfo info = (SlaughterPlanInfo)model;
		info.setBillStatus(com.kingdee.eas.cm.common.BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditor(null);
		info.setAuditDate(null);
		try {
			super._save(ctx, info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *检验当月的屠宰计划是否已经录入

	 */
	private void checkExist(Context ctx, SlaughterPlanInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		String sql="select * from T_FM_SlaughterPlan where  FPeriodID=? and fid<>? and FStoOrgID=?";
		String str="";
		if(info.getId()!=null)
			str=info.getId().toString();
		String[] args = {info.getPeriod().getId().toString(),str,info.getStoOrg().getId().toString()};
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","已存在当前期间的屠宰计划，请不要重复录入"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}