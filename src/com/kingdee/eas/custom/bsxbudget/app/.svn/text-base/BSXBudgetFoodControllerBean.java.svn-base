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
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodFactory;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo;
import com.kingdee.eas.custom.bsxbudget.billStatus;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BSXBudgetFoodControllerBean extends AbstractBSXBudgetFoodControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.bsxbudget.app.BSXBudgetFoodControllerBean");

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetFoodInfo info = (BSXBudgetFoodInfo)model;
//		if(isExist(ctx, info))
//			throw new EASBizException(new NumericExceptionSubItem("001","当前期间的预算单据已存在"));
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		//		modifyBSXBudgetOfFeed(ctx,info);
		return super._save(ctx, model);
	}

	/**
	 * 修改养殖场预算数据
	 * @param ctx
	 * @param info
	 */
	private void modifyBSXBudgetOfFeed(Context ctx, BSXBudgetFoodInfo info) {
		// TODO Auto-generated method stub
		if(info.getPeriod()==null||info.getPricePerKG()==null)
			return;
		try {
			CoreBaseCollection coll = BSXBudgetOfFeedFactory.getLocalInstance(ctx).getCollection("where period='"+info.getPeriod().getId().toString()+"'");
			if(coll.size()==0)
				return;
			BSXBudgetOfFeedInfo feedInfo = (BSXBudgetOfFeedInfo)coll.get(0);
			if(feedInfo.getBillStatus().equals(billStatus.audit)||feedInfo.getBillStatus().equals(billStatus.submit))
				return;

			feedInfo.setPriceOfWholeChicken(info.getPricePerKG());//毛鸡收购价格


			if(feedInfo.getTotalWeight()!=null&&feedInfo.getPriceOfWholeChicken()!=null)//预计毛鸡收入
				feedInfo.setRevenueOfChickens(feedInfo.getTotalWeight().multiply(feedInfo.getPriceOfWholeChicken()));

			if(feedInfo.getRevenueOfChickens()!=null&&feedInfo.getRevenueOfOthers()!=null)//预计总收入
				feedInfo.setPredictedTotalRevenue(feedInfo.getRevenueOfChickens().add(feedInfo.getRevenueOfOthers()));

			if(feedInfo.getPredictedTotalRevenue()!=null&&feedInfo.getPredictedTotalCost()!=null)//利润
				feedInfo.setPredictedProfit(feedInfo.getPredictedTotalRevenue().subtract(feedInfo.getPredictedTotalCost()));

			BSXBudgetOfFeedFactory.getLocalInstance(ctx).save(feedInfo);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetFoodInfo info = (BSXBudgetFoodInfo)model;
//		if(isExist(ctx, info))
//			throw new EASBizException(new NumericExceptionSubItem("001","当前期间的预算单据已存在"));
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));
		if(info.getTotalWeight()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","单据信息不完整，不允许提交，可能是因为养殖场预算未填写"));
		info.setBillStatus(billStatus.submit);
		//		modifyBSXBudgetOfFeed(ctx,info);
		return super._submit(ctx, model);
	}

	/**
	 * 重复性检验
	 * @param ctx
	 * @param info
	 * @return
	 */
	protected boolean isExist(Context ctx,BSXBudgetFoodInfo info){
		String str = "";
		if(info!=null&&info.getPeriod()!=null)
			str="select * from T_BSX_BSXBudgetFood where FPeriodID='"+info.getPeriod().getId().toString()+"'";
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

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetFoodInfo info = (BSXBudgetFoodInfo)model;
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
		BSXBudgetFoodInfo info = (BSXBudgetFoodInfo)model;
		if(!info.getBillStatus().equals(billStatus.audit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许反审核"));

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
		BSXBudgetFoodInfo info = BSXBudgetFoodFactory.getLocalInstance(ctx).getBSXBudgetFoodInfo(pk);
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许删除"));
		super._delete(ctx, pk);
	}
}