package com.kingdee.eas.custom.wages.food.app;

import org.apache.commons.lang.StringUtils;
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
import com.kingdee.eas.custom.wages.MonthlysalarybillInfo;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureEntryCollection;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureEntryInfo;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureFactory;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureInfo;
import com.kingdee.eas.custom.wages.food.MonthFoodBillFactory;
import com.kingdee.eas.custom.wages.food.MonthFoodBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureCollection;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AssessmentMeasureControllerBean extends AbstractAssessmentMeasureControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.food.app.AssessmentMeasureControllerBean");
    HashMap<String, String> map = new HashMap<String, String>();
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	AssessmentMeasureInfo info = (AssessmentMeasureInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		AssessmentMeasureInfo info = (AssessmentMeasureInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		info = wagecalculation(ctx,model);
		return super._submit(ctx, info);
	}
	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 考核计算
	 */
	protected AssessmentMeasureInfo wagecalculation(Context ctx, IObjectValue model){
		AssessmentMeasureInfo info = (AssessmentMeasureInfo) model;
		AssessmentMeasureEntryCollection infoec = info.getEntrys();
		for(int i = 0;i<infoec.size();i++){
			BigDecimal ExceedAmount = new BigDecimal("0");
			AssessmentMeasureEntryInfo infoe = infoec.get(i);
			BigDecimal cbed = new BigDecimal("0");
			if(infoe.getAssessRates().equals("大于等于")){
				cbed = infoe.getActualAssess().subtract(infoe.getAssessValue());
				infoe.setExceedAward(cbed);
			}else if(infoe.getAssessRates().equals("小于等于")){
				cbed = infoe.getAssessValue().subtract(infoe.getActualAssess());
				infoe.setExceedAward(cbed);
			}
			if(cbed.compareTo(BigDecimal.ZERO)==1||cbed.compareTo(BigDecimal.ZERO)==0){
				//BigDecimal ExceedAmount = new BigDecimal("0");
				ExceedAmount = cbed.divide(infoe.getAssessUnit()).multiply(infoe.getUnitindex());
				infoe.setExceedAmount(ExceedAmount);
			}else{
				//BigDecimal ExceedAmount = new BigDecimal("0");
				ExceedAmount = cbed.divide(infoe.getAssessUnit()).multiply(infoe.getUnitindex());
				ExceedAmount = ExceedAmount.multiply(new BigDecimal("0.5"));
				infoe.setExceedAmount(ExceedAmount);
			}
			infoe.setAmount(getAmount(ctx,ExceedAmount,infoe));
			BigDecimal Rate = infoe.getAmount().divide(infoe.getStandardAward());
			if(Rate.compareTo(new BigDecimal("0.7"))==1||Rate.compareTo(new BigDecimal("0.7"))==0){
				infoe.setStandardAmount(infoe.getAmount());
			}else{
				infoe.setStandardAmount(infoe.getKQME().multiply(new BigDecimal("0.7")));
			}
		}
		return info;
	}
	//计算奖励金额
	protected BigDecimal getAmount(Context ctx,BigDecimal ExceedAmount,AssessmentMeasureEntryInfo infoe){
		BigDecimal Amount = new BigDecimal("0");
		if(ExceedAmount.compareTo(BigDecimal.ZERO)==1||ExceedAmount.compareTo(BigDecimal.ZERO)==0){
			Amount = ExceedAmount.add(infoe.getStandardAward());
			return Amount;
		}else{
			Amount = ExceedAmount;
			return Amount;
		}
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		AssessmentMeasureInfo info = (AssessmentMeasureInfo) model;
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
		AssessmentMeasureInfo info = (AssessmentMeasureInfo) model;
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
		AssessmentMeasureInfo info = AssessmentMeasureFactory.getLocalInstance(ctx).getAssessmentMeasureInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}
	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取考勤满额
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