package com.kingdee.eas.custom.wages.farm.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.HashMap;

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

import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.wages.MonthlysalarybillEntryCollection;
import com.kingdee.eas.custom.wages.MonthlysalarybillEntryInfo;
import com.kingdee.eas.custom.wages.MonthlysalarybillFactory;
import com.kingdee.eas.custom.wages.MonthlysalarybillInfo;
import com.kingdee.eas.custom.wages.getWorkmonthFacadeFactory;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmEntryCollection;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmEntryInfo;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmFactory;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthBillFarmControllerBean extends AbstractMonthBillFarmControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.farm.app.MonthBillFarmControllerBean");
    HashMap<String, String> map = new HashMap<String, String>();
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MonthBillFarmInfo info = (MonthBillFarmInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MonthBillFarmInfo info = (MonthBillFarmInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		MonthBillFarmInfo info = (MonthBillFarmInfo) model;
		// 禁止重复审核 非提交不审核
//		if (!info.getStatus().equals(BillBaseStatusEnum.SUBMITED)) {
//			return;
//		}
		try {
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			//info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.kingdee.eas.farm.food.stocount.app.AbstractPcakCountControllerBean#_unaudit(com.kingdee.bos.Context, com.kingdee.bos.dao.IObjectValue)
	 */
	@Override
	protected void _unaudit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		MonthBillFarmInfo info = (MonthBillFarmInfo) model;
		// 反禁止重复审核
//		if (!info.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
//			return;
//		}
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			 //info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MonthBillFarmInfo info = MonthBillFarmFactory.getLocalInstance(ctx).getMonthBillFarmInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}

	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取本季度所有需要发放工资的人员信息
	 */
	@Override
	protected void _getPerson(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		super._getPerson(ctx, model);
	}
	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 计算月工资
	 * 应税所得=应发工资-代扣社保
	 * 实发工资=应税所得-代扣个税-代扣损失-代扣意外险
	 * 实发工资（不含招聘奖励，健康证报销）=实发工资-招聘奖励-健康证报销
	 */
	@Override
	protected void _wagecalculation(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
		MonthBillFarmInfo info = (MonthBillFarmInfo) model;
		MonthBillFarmEntryCollection infoec = info.getEntrys();
		MonthBillFarmEntryInfo infoe;
		if (info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
		for(int i = 0;i<info.getEntrys().size();i++){
			infoe =  infoec.get(i);
			//应发工资 = 基本工资+考勤工资+岗位工资(部分)+计件工资（车队）+无事故奖励（车队）+日综合评比考核-日综合评比考核扣除部分
			//+岗位工资+工龄工资+考核工资+月补助+年节补助+工时工资（维修）+押金（部分）+批次奖励（部分）
			BigDecimal payamount = infoe.getBasicwages();
			payamount = payamount.add(infoe.getCheckworkwages());
			payamount = payamount.add(infoe.getPostwages());
			payamount = payamount.add(infoe.getJjgz());
			payamount = payamount.add(infoe.getWsgjl());
			payamount = payamount.add(infoe.getDailyevaluation());
			payamount = payamount.subtract(infoe.getDailevadeduction());
			payamount = payamount.add(infoe.getPostwages());
			payamount = payamount.add(infoe.getAgewages());
			payamount = payamount.add(infoe.getAssessmentwages());
			payamount = payamount.add(infoe.getMonthSubsidy());
			payamount = payamount.add(infoe.getYj());
			payamount = payamount.add(infoe.getHolidayallow());
			payamount = payamount.add(infoe.getTimewages());
			payamount = payamount.add(infoe.getBatchamount());
			//附表内容
			payamount = payamount.add(infoe.getNotificationwages());
			payamount = payamount.subtract(infoe.getQualitydebit());
			payamount = payamount.add(infoe.getRecruitwages());
			payamount = payamount.add(infoe.getRepairmonth());
			payamount = payamount.add(infoe.getSocialsecurity());
			payamount = payamount.add(infoe.getAdjustAmount());
			payamount = payamount.add(infoe.getSubsidywages());
			infoe.setWagespay(payamount);
			//应税所得
			BigDecimal txwages = payamount;
			txwages = txwages.subtract(infoe.getSocialsecurity());
			infoe.setTaxableincome(txwages);
			//实发工资
			BigDecimal payroll = txwages;
			String dkgs = txwages.toString();
			//dkgs = getWorkmonthFacadeFactory.getLocalInstance(ctx).getdkgs(dkgs.toString());
			infoe.setPersontax(new BigDecimal(dkgs));
			payroll = payroll.subtract(new BigDecimal(dkgs));
			payroll = payroll.subtract(infoe.getAccidentinsurance());
			payroll = payroll.subtract(infoe.getDeductedloss()).setScale(0, BigDecimal.ROUND_HALF_UP);
			infoe.setPayroll(payroll);
			try {
				super._update(ctx, new ObjectUuidPK(info.getId()), info);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}else{
			try {
				throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + "只能在保存状态下计算！"));
			} catch (BillBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		super._wagecalculation(ctx, model);
	}

	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 更新班组数据
	 */
    private IRowSet getExeQueryRowSet(Context ctx,IObjectValue model) throws BOSException {
    	MonthBillFarmInfo info = (MonthBillFarmInfo) model;
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("Select").append(sp);
		sql.append("t3.CFTemAllowance,t3.CFNightAllowance,t3.CFOverTimeH,t3.CFOverTimeD").append(sp);
		sql.append("from CT_WAG_BasicPostEntry t1").append(sp);
		sql.append("inner join CT_WAG_BasicPost t2 on t2.Fid = t1.FParentID").append(sp);
		sql.append("inner join CT_WAG_WageOrganization  t3 on t3.Fid = t2.CFTheGroupID").append(sp);
		sql.append("inner join T_BD_Person t4 on t4.Fid = t1.CFPersonID").append(sp);
		sql.append("where t3.Fid = ''").append(sp);
		System.out.println(sql.toString());
//		Object[] args = {info.getWageOrganization().getId()};
		IRowSet rs = DbUtil.executeQuery(ctx,sql.toString());
		return rs;
    }
}