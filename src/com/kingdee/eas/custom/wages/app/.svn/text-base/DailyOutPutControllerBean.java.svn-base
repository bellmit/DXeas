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
import com.kingdee.eas.custom.wages.DailyOutPutCollection;
import com.kingdee.eas.custom.wages.DailyOutPutEntryCollection;
import com.kingdee.eas.custom.wages.DailyOutPutEntryInfo;
import com.kingdee.eas.custom.wages.DailyOutPutFactory;
import com.kingdee.eas.custom.wages.EmploySecurityFactory;
import com.kingdee.eas.custom.wages.EmploySecurityInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wages.DailyOutPutInfo;
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

public class DailyOutPutControllerBean extends AbstractDailyOutPutControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.app.DailyOutPutControllerBean");
    HashMap<String, String> map = new HashMap<String, String>();
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DailyOutPutInfo info = (DailyOutPutInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		DailyOutPutInfo info = (DailyOutPutInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		DailyOutPutInfo info = (DailyOutPutInfo) model;
		_salaryCount(ctx,model);
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
		DailyOutPutInfo info = (DailyOutPutInfo) model;
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
		DailyOutPutInfo info = DailyOutPutFactory.getLocalInstance(ctx).getDailyOutPutInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}


    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 计算日工资方法
	 * 产品系数*产量+补助和+加班工资
	 */
	@Override
	protected void _salaryCount(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		DailyOutPutInfo info = (DailyOutPutInfo) model;
		DailyOutPutEntryCollection infoec = info.getEntrys();
		DailyOutPutEntryInfo infoe;
		IRowSet rs = getExeQueryRowSet(ctx, model);
		try {
			while (rs.next()) {
				map.put("温差补贴", rs.getString("CFTemAllowance"));
				map.put("夜班补贴", rs.getString("CFNightAllowance"));
				map.put("加班补贴小时", rs.getString("CFOverTimeH"));
				map.put("加班补贴天", rs.getString("CFOverTimeD"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0;i<info.getEntrys().size();i++){
			infoe =  infoec.get(i);
			if(infoe.isIsAbsenteeism()||infoe.isIsLeave()){
				infoe.setDaywages(new BigDecimal("0"));
				String upsql = "update CT_WAG_DailyOutPutEntry set CFDaywages = '0' where fid = '"+infoe.getId()+"'";
				// 执行更新
				DbUtil.execute(ctx, upsql);
			}else{
				BigDecimal Meteunit = new BigDecimal(infoe.getProductratio().toString());
				BigDecimal Mnumber= new BigDecimal(infoe.getMnumber().toString());
				BigDecimal wages = Meteunit.multiply(Mnumber);
				if(infoe.isIsTemp()){
					wages = wages.add(new BigDecimal(map.get("温差补贴")));
				}
				if(infoe.isIsNight()){
					wages = wages.add(new BigDecimal(map.get("夜班补贴")));
				}
				if(infoe.getOvertime()!=null){
					BigDecimal oh = new BigDecimal(infoe.getOvertime().toString());
					oh = oh.multiply(new BigDecimal(map.get("加班补贴小时")));
					wages = wages.add(oh);
				}
				if(infoe.getOverday()!=null){
					BigDecimal od = new BigDecimal(infoe.getOverday().toString());
					od = od.multiply(new BigDecimal(map.get("加班补贴天")));
					wages = wages.add(od);
				}
				infoe.setDaywages(wages);
//				String upsql = "update CT_WAG_DailyOutPutEntry set CFDaywages = '"+wages+"' where fid = '"+infoe.getId()+"'";
//				// 执行更新
//				DbUtil.execute(ctx, upsql);
				
			}	
			try {
				super._update(ctx, new ObjectUuidPK(info.getId()), info);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		super._salaryCount(ctx, model);
	}
	 /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 更新班组数据
	 */
    private IRowSet getExeQueryRowSet(Context ctx,IObjectValue model) throws BOSException {
    	DailyOutPutInfo info = (DailyOutPutInfo) model;
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("Select").append(sp);
		sql.append("t3.CFTemAllowance,t3.CFNightAllowance,t3.CFOverTimeH,t3.CFOverTimeD").append(sp);
		sql.append("from CT_WAG_BasicPostEntry t1").append(sp);
		sql.append("inner join CT_WAG_BasicPost t2 on t2.Fid = t1.FParentID").append(sp);
		sql.append("inner join CT_WAG_WageOrganization  t3 on t3.Fid = t2.CFTheGroupID").append(sp);
		sql.append("inner join T_BD_Person t4 on t4.Fid = t1.CFPersonID").append(sp);
		sql.append("where t3.Fid = '"+info.getWageOrganization().getId().toString()+"'").append(sp);
		System.out.println(sql.toString());
//		Object[] args = {info.getWageOrganization().getId()};
		IRowSet rs = DbUtil.executeQuery(ctx,sql.toString());
		return rs;
    }
}