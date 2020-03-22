package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.workflow.ProcessInstInfo;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class DrugReceiveBillControllerBean extends AbstractDrugReceiveBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.DrugReceiveBillControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		DrugReceiveBillInfo info = DrugReceiveBillFactory.getLocalInstance(ctx).getDrugReceiveBillInfo(new ObjectUuidPK(((DrugReceiveBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);

		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		//审核前校验是否在工作流中如果在工作流中不允许审核
		checkWorkProcess(ctx,info);


		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//生成供应链单据
		//		createToSCMBill(ctx, info);
		calcDrugAmount(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	/**
	 * 审核前校验是否在工作流中如果在工作流中不允许审核
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void checkWorkProcess(Context ctx, DrugReceiveBillInfo info) throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		IEnactmentService service = null;
		if(ctx == null) {
			service = EnactmentServiceFactory.createRemoteEnactService();
		} else {
			service = EnactmentServiceFactory.createEnactService(ctx);
		} 
		ProcessInstInfo processInstInfo = null;
		ProcessInstInfo procInsts[] = service.getProcessInstanceByHoldedObjectId(info.getId().toString());
		int i = 0;
		for(int n = procInsts.length; i < n; i++)
			if(procInsts[i].getState().startsWith("open.running")){
				processInstInfo = procInsts[i];
			}
		if(processInstInfo != null) {
			throw new EASBizException(new NumericExceptionSubItem("001","只单据已经在工作流中，禁止审核！"));
		}
	}

	/**
	 * 计算开药金额
	 * @param info 
	 * @param ctx 
	 */
	private void calcDrugAmount(Context ctx, DrugReceiveBillInfo info) {
		// TODO Auto-generated method stub

		if(info.getBatchContract() != null){
			BatchContractBillInfo batchcontractInfo = info.getBatchContract();
			String s1 = "/*dialect*/ select t4.CFMaxSingleDrug maxDrug,sum(t2.CFAmount) amount from T_FM_DrugReceiveBill t1" +
			" inner join T_FM_DrugReceiveBillEntry t2 on t2.fparentid = t1.fid" +
			" inner join T_FM_BatchContractBill t3 on t3.fid=t1.FBatchContractID" +
			" inner join T_FM_SettlePolicy t4 on t4.fid = t3.FSettlementPolicyI"+
			" where t1.FBatchContractID = '"+batchcontractInfo.getId()+"' and t1.FBillStatus in (4,7)  group by t4.CFMaxSingleDrug";
			try {
				IRowSet r1 = DbUtil.executeQuery(ctx, s1.toString());
				//已开药总金额
				BigDecimal amount = BigDecimal.ZERO;
				if(r1.next()){
					amount = UIRuleUtil.getBigDecimal(r1.getBigDecimal("amount"));
				}

				String s2 = "/*dialect*/ select t4.CFMaxSingleDrug maxDrug  from  T_FM_BatchContractBill t3  inner join T_FM_SettlePolicy t4 on t4.fid = t3.FSettlementPolicyI where t3.fid = '"+batchcontractInfo.getId()+"'";
				IRowSet r2 = DbUtil.executeQuery(ctx, s2.toString());
				//最高单只药品
				BigDecimal maxDrug = BigDecimal.ZERO;
				if(r2.next()){
					maxDrug = UIRuleUtil.getBigDecimal(r2.getBigDecimal("maxDrug"));
				}


				//最高开药金额
				BigDecimal hignDrugAmount = maxDrug.multiply(UIRuleUtil.getBigDecimal(info.getInQty()));
				info.setHasDrugAmount(amount);
				info.setHignDrugAmount(hignDrugAmount);
				//已开药单只金额
				if(UIRuleUtil.getBigDecimal(info.getInQty()).compareTo(BigDecimal.ZERO) >0){
					info.setHasOneDrug(amount.divide(info.getInQty(),2,RoundingMode.HALF_UP));
				}else{
					info.setHasOneDrug(BigDecimal.ZERO);
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
	/**
	 * 生成供应链单据
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void createToSCMBill(Context ctx,DrugReceiveBillInfo info) throws BOSException, EASBizException {
		String destBillType=null;
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getCompany();
		//然后生成领料出库
		destBillType=BotpCommUtils.MaterialReq_BOSTYPE;
		BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		for(int index=0;index<btpCols.size();index++) {
			btpIS.createToOrderBill(ctx, info,destBillType, btpCols.get(index));
			info.setIsHasMaterial(true);
		}
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		DrugReceiveBillInfo info = DrugReceiveBillFactory.getLocalInstance(ctx).getDrugReceiveBillInfo(new ObjectUuidPK(((DrugReceiveBillInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));

		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		if(info.isIsFromTiaoYao()){
			throw new EASBizException(new NumericExceptionSubItem("001","从药品调整单生成的药品处方单不允许执行此操作"));
		}
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		calcDrugAmount(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DrugReceiveBillInfo info = (DrugReceiveBillInfo) model;
		if(info.getBillStatus().getValue()!=-1&&info.getBillStatus().getValue()!=0&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getBatchContract().getId().toString());
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		DrugReceiveBillInfo info = (DrugReceiveBillInfo) model;
		if(info.getBillStatus().getValue()!=-1&&info.getBillStatus().getValue()!=0&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getBatchContract().getId().toString());
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DrugReceiveBillInfo info = DrugReceiveBillFactory.getLocalInstance(ctx).getDrugReceiveBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核或关闭，禁止删除！"));
		}
		super._delete(ctx, pk);
	}

	@Override
	protected void _close(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		DrugReceiveBillInfo info = DrugReceiveBillFactory.getLocalInstance(ctx).getDrugReceiveBillInfo(new ObjectUuidPK(((DrugReceiveBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.CLOSED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unClose(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		DrugReceiveBillInfo info = DrugReceiveBillFactory.getLocalInstance(ctx).getDrugReceiveBillInfo(new ObjectUuidPK(((DrugReceiveBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有关闭的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	private void checkIsSettled(Context ctx,DrugReceiveBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		Boolean isHasSettled = StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString());
		if(isHasSettled){
			throw new EASBizException(new NumericExceptionSubItem("001","该批次已完全回收结算,操作失败!"));
		}
	}

	private void checkIsGuanZhang(Context ctx,DrugReceiveBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		boolean isGuanZhang=false;
		String companyID = info.getCompany().getId().toString();
		PeriodInfo period=DateUtilsComm.getPeriodInfoByDate(ctx,info.getBizDate());
		String periodID=period==null?"":period.getId().toString();
		try {
			isGuanZhang= CKCloseAccountFacadeFactory.getLocalInstance(ctx).checkIsClosed(companyID, periodID);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isGuanZhang){
			throw new EASBizException(new NumericExceptionSubItem("001","业务日期对应期间内该公司已执行了关账操作,当前操作失败!"));
		}
	}

	@Override
	protected void _chkVoucherAll(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}
	@Override
	protected void _chkVoucherFlag(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}
}