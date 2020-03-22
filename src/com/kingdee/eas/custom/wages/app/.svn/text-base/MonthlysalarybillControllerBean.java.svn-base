package com.kingdee.eas.custom.wages.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
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
import com.kingdee.eas.custom.wages.DailyOutPutEntryCollection;
import com.kingdee.eas.custom.wages.DailyOutPutEntryInfo;
import com.kingdee.eas.custom.wages.DailyOutPutInfo;
import com.kingdee.eas.custom.wages.EmploySecurityFactory;
import com.kingdee.eas.custom.wages.EmploySecurityInfo;
import com.kingdee.eas.custom.wages.MonthlysalarybillCollection;
import com.kingdee.eas.custom.wages.MonthlysalarybillEntryCollection;
import com.kingdee.eas.custom.wages.MonthlysalarybillEntryInfo;
import com.kingdee.eas.custom.wages.MonthlysalarybillFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.custom.wages.MonthlysalarybillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthlysalarybillControllerBean extends AbstractMonthlysalarybillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.app.MonthlysalarybillControllerBean");
    HashMap<String, String> map = new HashMap<String, String>();
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MonthlysalarybillInfo info = (MonthlysalarybillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MonthlysalarybillInfo info = (MonthlysalarybillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		MonthlysalarybillInfo info = (MonthlysalarybillInfo) model;
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
		MonthlysalarybillInfo info = (MonthlysalarybillInfo) model;
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
		MonthlysalarybillInfo info = MonthlysalarybillFactory.getLocalInstance(ctx).getMonthlysalarybillInfo(pk);
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
		
		MonthlysalarybillInfo info = (MonthlysalarybillInfo) model;
		MonthlysalarybillEntryCollection infoec = info.getEntrys();
		MonthlysalarybillEntryInfo infoe;
		if (info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
		for(int i = 0;i<info.getEntrys().size();i++){
			infoe =  infoec.get(i);
			//应发工资 = 产量工资+基本工资+考勤工资+岗位工资+满勤工资+考核工资+加班工资+日加班+温差补贴+夜班补贴+公司补贴+招聘奖励-品控扣款+通报奖罚+补上月+健康证报销
			BigDecimal wagespay = new BigDecimal("0");
			wagespay = wagespay.add(new BigDecimal(infoe.getYieldwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getFullworkwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getAssessmentwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getBasicwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getCheckworkwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getOvertimeH().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getOvertimeD().toString()));
			//wagespay = wagespay.add(new BigDecimal(infoe.getTemwages().toString()));
			//wagespay = wagespay.add(new BigDecimal(infoe.getNightwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getSubsidywages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getRecruitwages().toString()));
			wagespay = wagespay.subtract(new BigDecimal(infoe.getQualitydebit().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getNotificationwages().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getRepairmonth().toString()));
			wagespay = wagespay.add(new BigDecimal(infoe.getJgzbx().toString()));
			infoe.setWagespay(wagespay);
			//应税所得
			BigDecimal taxbleincome = wagespay;
			taxbleincome = taxbleincome.subtract(new BigDecimal(infoe.getSocialsecurity().toString()));
			infoe.setTaxableincome(taxbleincome);
			//实发工资
			BigDecimal payroll = taxbleincome;
			payroll = payroll.subtract(new BigDecimal(infoe.getDeductedloss().toString()));
			payroll = payroll.subtract(new BigDecimal(infoe.getAccidentinsurance().toString()));
			payroll = payroll.subtract(new BigDecimal(infoe.getPersontax().toString()));
			infoe.setPayroll(payroll);
			//实发工资（不含招聘奖励，健康证报销）
			BigDecimal payrollPart = payroll;
			payrollPart = payrollPart.subtract(new BigDecimal(infoe.getJgzbx().toString()));
			payrollPart = payrollPart.subtract(new BigDecimal(infoe.getRecruitwages().toString()));
			infoe.setPayrollPart(payrollPart);
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
    	MonthlysalarybillInfo info = (MonthlysalarybillInfo) model;
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