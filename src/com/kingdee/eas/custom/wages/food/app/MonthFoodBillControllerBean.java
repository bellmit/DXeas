package com.kingdee.eas.custom.wages.food.app;

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
import com.kingdee.eas.custom.wages.food.MonthFoodBillCollection;
import com.kingdee.eas.custom.wages.food.MonthFoodBillEntryCollection;
import com.kingdee.eas.custom.wages.food.MonthFoodBillEntryInfo;
import com.kingdee.eas.custom.wages.food.MonthFoodBillFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wages.food.MonthFoodBillInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthFoodBillControllerBean extends AbstractMonthFoodBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.food.app.MonthFoodBillControllerBean");
    HashMap<String, String> map = new HashMap<String, String>();
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MonthFoodBillInfo info = (MonthFoodBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MonthFoodBillInfo info = (MonthFoodBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		MonthFoodBillInfo info = (MonthFoodBillInfo) model;
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
		MonthFoodBillInfo info = (MonthFoodBillInfo) model;
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
		MonthFoodBillInfo info = MonthFoodBillFactory.getLocalInstance(ctx).getMonthFoodBillInfo(pk);
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
		
		MonthFoodBillInfo info = (MonthFoodBillInfo) model;
		MonthFoodBillEntryCollection infoec = info.getEntrys();
		MonthFoodBillEntryInfo infoe;
		if (info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
		for(int i = 0;i<info.getEntrys().size();i++){
			infoe =  infoec.get(i);
			//应发工资 = 基本考勤+岗位考勤+岗位补贴+本月计发考核(有考核指标的部门才有)+满勤+节假日补助+加班+嘉奖+质量奖罚+通报奖罚+健康证报销+产量工资
			BigDecimal wagespay = new BigDecimal("0");
			
			wagespay = wagespay.add(new BigDecimal(infoe.getBasicattendance().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getPostattendance().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getSubsidywages().toString()));
			//本月计发考核
			wagespay = wagespay.add(new BigDecimal(infoe.getByjfkh().toString()));
			
			BigDecimal overwork = new BigDecimal(infoe.getOvertimeD().toString());
			overwork = overwork.multiply(new BigDecimal(infoe.getOverday().toString()));
			infoe.setOverdayamount(overwork);
			wagespay = wagespay.add(overwork);
			wagespay = wagespay.add(new BigDecimal(infoe.getFullworkwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getJjrbz().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getAwards().toString()));
			wagespay = wagespay.subtract(new BigDecimal(infoe.getQualitydebit().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getNotificationwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getRepairmonth().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getJgzbx().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getStandardAward().toString()));
			infoe.setWagespay(wagespay);
			//应税所得
			BigDecimal taxbleincome = wagespay;
			taxbleincome = taxbleincome.subtract(new BigDecimal(infoe.getSocialsecurity().toString()));
			infoe.setTaxableincome(taxbleincome);
			//实发工资
			BigDecimal payroll = taxbleincome;
			payroll = payroll.subtract(new BigDecimal(infoe.getDeductedloss().toString()));
			payroll = payroll.subtract(new BigDecimal(infoe.getPersontax().toString()));
			infoe.setPayroll(payroll);
			//扣除意外险实发
			BigDecimal DeAccident = payroll;
			DeAccident = DeAccident.subtract(new BigDecimal(infoe.getAccidentinsurance().toString()));
			infoe.setDeAccident(DeAccident);
			//不含健康证实发
			BigDecimal bhjkzsf = payroll;
			bhjkzsf = bhjkzsf.subtract(new BigDecimal(infoe.getJgzbx().toString()));
			infoe.setBhjkzsf(bhjkzsf);
//			try {
//				super._update(ctx, new ObjectUuidPK(info.getId()), info);
//			} catch (EASBizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		}else{
			try {
				throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + "只能在保存状态下计算！"));
			} catch (BillBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    	MonthFoodBillInfo info = (MonthFoodBillInfo) model;
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