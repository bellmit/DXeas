package com.kingdee.eas.custom.wages.food.app;

import org.apache.commons.lang.StringUtils;
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
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.wages.food.AchievementEntryCollection;
import com.kingdee.eas.custom.wages.food.AchievementEntryInfo;
import com.kingdee.eas.custom.wages.food.AchievementFactory;
import com.kingdee.eas.custom.wages.food.AchievementInfo;
import com.kingdee.eas.custom.wages.food.MonthFoodBillFactory;
import com.kingdee.eas.custom.wages.food.MonthFoodBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wages.food.AchievementCollection;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AchievementControllerBean extends AbstractAchievementControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.food.app.AchievementControllerBean");
    HashMap<String, String> map = new HashMap<String, String>();
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		AchievementInfo info = (AchievementInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		AchievementInfo info = (AchievementInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		info = getAmount(ctx,info);
		return super._submit(ctx, info);
	}
	/*
	 *根据绩效得分计算绩效金额及绩效百分比
	 */
	protected AchievementInfo getAmount(Context ctx,AchievementInfo info){
		AchievementEntryCollection infoec = info.getEntrys();
		for(int i=0;i<infoec.size();i++){
			AchievementEntryInfo  infoe = infoec.get(i);
			BigDecimal socre = infoe.getAchievescore();
			try {
				String ratio = getExeQueryRowSet(ctx,socre.toString());
				if(StringUtils.isEmpty(ratio)){
					throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":第"+i+1+"条分录为找打合适的指标。"));
				}
				BigDecimal tage = new BigDecimal(ratio);
				tage = tage.multiply(new BigDecimal("100"));
				infoe.setAchievetage(tage.toString()+"%");
				infoe.setAchieceamount(infoe.getKhme().multiply(new BigDecimal(ratio)));
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BillBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return info;
	}
	private String getExeQueryRowSet(Context ctx,String socre) throws BOSException {
		StringBuffer sql = new StringBuffer();
		String ratio  = "";
		String sp = "\n";
		sql.append("select t2.CFPerforratio from CT_FOO_CompAssessment t1").append(sp);
		sql.append("inner join CT_FOO_CompAssessmentEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where t2.CFUplimit >= '"+socre+"'").append(sp);
		sql.append("and t2.CFDownlimit <= '"+socre+"'").append(sp);
		//System.out.println(sql.toString());
		IRowSet rs =SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
		try {
			while (rs.next()) {
				try {
					ratio = rs.getString("CFPerforratio");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ratio;
	}
	
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		AchievementInfo info = (AchievementInfo) model;
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
		AchievementInfo info = (AchievementInfo) model;
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
		AchievementInfo info = AchievementFactory.getLocalInstance(ctx).getAchievementInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}
}