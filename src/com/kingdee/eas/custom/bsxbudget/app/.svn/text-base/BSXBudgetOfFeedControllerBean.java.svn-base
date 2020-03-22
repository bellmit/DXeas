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
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodFactory;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedCollection;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory;
import com.kingdee.eas.custom.bsxbudget.billStatus;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BSXBudgetOfFeedControllerBean extends AbstractBSXBudgetOfFeedControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.bsxbudget.app.BSXBudgetOfFeedControllerBean");

	@Override
	protected void _getLairageQty(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}

	/**
	 * 保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetOfFeedInfo info = (BSXBudgetOfFeedInfo)model;
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
		BSXBudgetOfFeedInfo info = (BSXBudgetOfFeedInfo)model;
//		if(isExist(ctx, info))
//			throw new EASBizException(new NumericExceptionSubItem("001","当前期间的预算单据已存在"));
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许保存新增或保存状态的单据"));
		if(info.getPriceOfWholeChicken()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","信息不完整，单据无法提交"));


		modifyBSXBudgetFood(ctx,info);
		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, model);
	}


	/**
	 * 反写  食品厂预算
	 * @param ctx 
	 * @param info
	 */
	private void modifyBSXBudgetFood(Context ctx, BSXBudgetOfFeedInfo info) {
		// TODO Auto-generated method stub
		CoreBaseCollection coll;
		try {
			coll = BSXBudgetFoodFactory.getLocalInstance(ctx).getCollection("where period='"+info.getPeriod().getId().toString()+"'");
			BSXBudgetFoodInfo budgetFoodInfo;
			if(coll.size()>0){
				budgetFoodInfo=(BSXBudgetFoodInfo)coll.get(0);

				if(budgetFoodInfo.getBillStatus().equals(billStatus.audit))
					return;

				//				if(budgetFoodInfo.getTotalWeight()==null||budgetFoodInfo.getTotalWeight().equals(BigDecimal.ZERO)){

				budgetFoodInfo.setTotalWeight(info.getTotalWeight());//毛鸡总重量

				if(budgetFoodInfo.getPricePerKG()!=null)
					budgetFoodInfo.setTotolCost(budgetFoodInfo.getPricePerKG().multiply(info.getTotalWeight()));//毛鸡收购总成本

				if(budgetFoodInfo.getYieldRate()!=null){
					budgetFoodInfo.setYield(budgetFoodInfo.getYieldRate().multiply(info.getTotalWeight()).multiply(new BigDecimal("0.01")));//毛鸡出成

					budgetFoodInfo.setExpectedRec(budgetFoodInfo.getYield());//本月预计入库量
				}

				if(budgetFoodInfo.getProductCost()!=null&&budgetFoodInfo.getTotolCost()!=null)//本月预计入库价值
					budgetFoodInfo.setPredictRecAmt(budgetFoodInfo.getTotolCost().multiply(new BigDecimal("0.87")).add(budgetFoodInfo.getProductCost()));

				if(budgetFoodInfo.getPredictRecAmt()!=null&&budgetFoodInfo.getStockAmtAtMonthBegin()!=null)//预计销售成本
					budgetFoodInfo.setExpectedSaleCost(budgetFoodInfo.getPredictRecAmt().add(budgetFoodInfo.getStockAmtAtMonthBegin()));

				if(budgetFoodInfo.getExpectedSaleCost()!=null&&budgetFoodInfo.getStockAtMonthBegin()!=null&&budgetFoodInfo.getExpectedRec()!=null){//预计单位销售成本
					BigDecimal sum = budgetFoodInfo.getStockAtMonthBegin().add(budgetFoodInfo.getExpectedRec());
					if(!BigDecimal.ZERO.equals(sum))
						budgetFoodInfo.setExpectedsalesCostPerKG(budgetFoodInfo.getExpectedSaleCost().divide(sum,6,BigDecimal.ROUND_HALF_EVEN));
				}
				if(budgetFoodInfo.getExpectedSalesRevenue()!=null&&budgetFoodInfo.getExpectedSaleCost()!=null)//销售毛利
					budgetFoodInfo.setSaleProfit(budgetFoodInfo.getExpectedSalesRevenue().subtract(budgetFoodInfo.getExpectedSaleCost()));
				if(budgetFoodInfo.getExpectedSalesRevenue()!=null&&budgetFoodInfo.getExpectedSaleCost()!=null&&budgetFoodInfo.getManageFee()!=null&&budgetFoodInfo.getFIFee()!=null&&budgetFoodInfo.getSaleFee()!=null){//利润
					BigDecimal sub = budgetFoodInfo.getExpectedSalesRevenue().subtract(budgetFoodInfo.getExpectedSaleCost()).subtract(budgetFoodInfo.getManageFee()).subtract(budgetFoodInfo.getFIFee()).subtract(budgetFoodInfo.getSaleFee());
					budgetFoodInfo.setCompanyProfit(sub);
				}

				BSXBudgetFoodFactory.getLocalInstance(ctx).save(budgetFoodInfo);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * 重复性检验
	 * @param ctx
	 * @param info
	 * @return
	 */
	protected boolean isExist(Context ctx,BSXBudgetOfFeedInfo info){
		String str = "";
		if(info!=null&&info.getPeriod()!=null)
			str="select * from T_BSX_BSXBudgetOfFeed where FPeriodID='"+info.getPeriod().getId().toString()+"'";
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

	/**
	 * 审核
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BSXBudgetOfFeedInfo info = (BSXBudgetOfFeedInfo)model;
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
	throws BOSException , EASBizException{
		// TODO Auto-generated method stub
		BSXBudgetOfFeedInfo info = (BSXBudgetOfFeedInfo)model;
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
		BSXBudgetOfFeedInfo info = BSXBudgetOfFeedFactory.getLocalInstance(ctx).getBSXBudgetOfFeedInfo(pk);
		if(!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许删除"));
		super._delete(ctx, pk);
	}
}