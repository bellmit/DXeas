package com.kingdee.eas.farm.carnivorous.basebiz.app;

import mondrian.rolap.BitKey.Big;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.farm.stocking.common.StockingComm;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaiginBillControllerBean extends AbstractMaiginBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basebiz.app.MaiginBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		MaiginBillInfo info = MaiginBillFactory.getLocalInstance(ctx).getMaiginBillInfo(new ObjectUuidPK(((MaiginBillInfo) model).getId().toString()));
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		BigDecimal actualKConFeedSub = UIRuleUtil.getBigDecimal(info.getActualKConFeedSub());
		BigDecimal actualKOtherAmt = UIRuleUtil.getBigDecimal(info.getActualKOtherAmt());
		BigDecimal actualKPolicySub = UIRuleUtil.getBigDecimal(info.getActualKPolicySub());
		BigDecimal actualKPunishAmt = UIRuleUtil.getBigDecimal(info.getActualKPunishAmt());
		BigDecimal payAmount = UIRuleUtil.getBigDecimal(info.getPayAmount());
		BigDecimal actualPay = payAmount.subtract(actualKConFeedSub).subtract(actualKOtherAmt).subtract(actualKPolicySub).subtract(actualKPunishAmt);
		info.setActualPayAmt(actualPay);

		updateFarmerMarginForAudit(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//更新养殖场保证金总金额字段 = 该养殖场收保证金类型的金额 - 退保证金类型的金额
		if(info.getFarm() != null){
			updateFarmInfo(ctx,info);
		}
	}

	/**
	 * 更新养殖场保证金总金额字段 = 该养殖场收保证金类型的金额 - 退保证金类型的金额
	 * @param ctx
	 * @param info
	 */
	private void updateFarmInfo(Context ctx, MaiginBillInfo info) {
		// TODO Auto-generated method stub

		String s1 = "/*dialect*/ select sum(t2.parAmt) parAmt, sum(t2.rePayAmt) rePayAmt" +
		" from( select sum(nvl(t1.CFPayAmount,0)) parAmt,0 rePayAmt from " +
		" CT_FM_MaiginBill t1 where t1.CFBizType = 1 and t1.CFBillStatus in(4,7)" +
		" and t1.CFFarmID = '"+info.getFarm().getId()+"' " +
		" union all  select 0 parAmt,sum(nvl(t1.CFPayAmount,0)) rePayAmt from " +
		" CT_FM_MaiginBill t1 where t1.CFBizType = 2 and t1.CFBillStatus in(4,7)" +
		" and t1.CFFarmID = '"+info.getFarm().getId()+"') t2";

		try {
			//收保证金
			BigDecimal parAmt = BigDecimal.ZERO;
			//退保证金
			BigDecimal rePayAmt = BigDecimal.ZERO;
			BigDecimal marginAmt = BigDecimal.ZERO;
			IRowSet r1 = DbUtil.executeQuery(ctx,s1);
			if(r1.next()){
				parAmt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("parAmt"));
				rePayAmt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("rePayAmt"));
				marginAmt = parAmt.subtract(rePayAmt);
				String s2 = "/*dialect*/ update CT_FM_Farm set CFMarginAmt = "+marginAmt+"  where fid = '"+info.getFarm().getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	private void updateFarmerMarginForAudit(Context ctx, MaiginBillInfo info) {
		BigDecimal payAmount = info.getPayAmount()==null?BigDecimal.ZERO:info.getPayAmount();
		String op=null;
		if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.returnBack){
			op="-";
		}else if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
			op="+";
		}
//			if(op!=null){
//				String sql="update CT_FM_Farmer set cftotalMargin=isnull(cftotalMargin,0)"+op+"("+payAmount+"),cfenableMargin=isnull(cfenableMargin,0)"+op+"("+payAmount+") where fid='"+info.getFarmer().getId().toString()+"'";
//				DbUtil.execute(ctx, sql);	
//			}

	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		MaiginBillInfo info = MaiginBillFactory.getLocalInstance(ctx).getMaiginBillInfo(new ObjectUuidPK(((MaiginBillInfo) model).getId().toString()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		updateFarmerMarginForUnAudit(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//更新养殖场保证金总金额字段 = 该养殖场收保证金类型的金额 - 退保证金类型的金额
		if(info.getFarm() != null){
			updateFarmInfo(ctx,info);
		}
	}

	private void updateFarmerMarginForUnAudit(Context ctx, MaiginBillInfo info) {
		// TODO Auto-generated method stub
		BigDecimal payAmount = info.getPayAmount()==null?BigDecimal.ZERO:info.getPayAmount();
		String op=null;
		if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.returnBack){
			op="+";
		}else if(info.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
			op="-";
		}
//			if(op!=null){
//				String sql="update CT_FM_Farmer set cftotalMargin=isnull(cftotalMargin,0)"+op+"("+payAmount+"),cfenableMargin=isnull(cfenableMargin,0)"+op+"("+payAmount+") where fid='"+info.getFarmer().getId().toString()+"'";
//				DbUtil.execute(ctx, sql);	
//			}	
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MaiginBillInfo info = (MaiginBillInfo) model;

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MaiginBillInfo info = (MaiginBillInfo) model;

		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MaiginBillInfo info = MaiginBillFactory.getLocalInstance(ctx).getMaiginBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","当前单据尚在工作流执行过程,不能执行该操作"));
		}

		super._delete(ctx, pk);
	}
}