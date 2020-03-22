package com.kingdee.eas.custom.settleaccount.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.settleaccount.util.CheckResultInfo;
import com.kingdee.eas.custom.settleaccount.util.ProblemDetailInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;


public class settleAccountFacadeControllerBean extends AbstractsettleAccountFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.settleaccount.app.settleAccountFacadeControllerBean");
   
    
    
    /**
     *食品公司： 其他出库单实际成本为0校验
     */
    @Override
	protected CheckResultInfo _otherIssueACost0Check(Context ctx,
			String companyID, String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select distinct oi.fnumber, case oie.FActualCost when 0 then 'notpass' else 'pass' end fcondition ");
		sql.append(" from T_IM_OtherIssueBill  oi inner join T_IM_OtherIssueBillEntry oie on oi.fid=oie.fparentid");
		sql.append(" where 1=1");
		sql.append(" and oi.FControlUnitID='"+companyID+"'");
		sql.append(" and oi.fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and oi.fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by oi.fnumber");
		
		//执行校验
		String checkItem="其他出库单实际成本为0校验";
		String billType="其他出库单";
		String billProblem="其他出库单实际成本为0";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}


	/**
     * 食品公司：其他出库单成本中心校验
     */
    @Override
	protected CheckResultInfo _otherIssueCCenterNot1Check(Context ctx,
			String companyID, String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber, case FCostCenterOrgUnitID when 'at4AAAAAB93M567U' then 'pass' else 'notpass' end fcondition");
		sql.append(" from T_IM_OtherIssueBill");
		sql.append(" where 1=1");
		sql.append(" and FControlUnitID='"+companyID+"'");
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
		
		//执行校验
		String checkItem="其他出库单成本中心校验";
		String billType="其他出库单";
		String billProblem="其他出库单成本中心不是生产一部";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}


	/**
     * 食品公司：领料出库单据非审核状态校验
     */
    @Override
	protected CheckResultInfo _materialReqNotAuditCheck(Context ctx,
			String companyID, String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber,case fbasestatus when 4 then 'pass' else 'notpass' end fcondition");
		sql.append(" from T_IM_MaterialReqBill");
		sql.append(" where 1=1");
		sql.append(" and FControlUnitID='"+companyID+"'");
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
		
		//执行校验
		String checkItem="领料出库单据非审核状态校验";
		String billType="领料出库单";
		String billProblem="领料出库单据为非审核状态";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}


	/**
     * 食品公司：领料出库中成本中心和返工校验
     */
    @Override
	protected CheckResultInfo _materialReqCCReWorkCheck(Context ctx,
			String companyID, String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select distinct mrb.fnumber,");
		sql.append(" case when (mrb.FCostCenterOrgUnitID='at4AAAAbegjM567U' and mrbe.FIsReWork=0)");
		sql.append(" or(mrb.FCostCenterOrgUnitID!='at4AAAAbegjM567U' and mrbe.FIsReWork=1)");
		sql.append(" then 'notpass' else 'pass' end fcondition");
		sql.append(" from T_IM_MaterialReqBill mrb inner join T_IM_MaterialReqBillEntry mrbe on mrb.fid=mrbe.fparentid");
		sql.append(" where 1=1");
		sql.append(" and mrb.FControlUnitID='"+companyID+"'");
		sql.append(" and mrb.fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and mrb.fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by mrb.fnumber");
		
		//执行校验
		String checkItem="领料出库中成本中心和返工校验";
		String billType="领料出库单";
		String billProblem="成本中心是生产三部返工未打勾或成本中心不是生产三部返工打勾";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}


	/**
     * 销售出库单未生成应收单校验
     */
    @Override
	protected CheckResultInfo _saleIssueBillNoOtherBillCheck(Context ctx,
			String companyID, String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select distinct sb.fnumber,case sbe.FWrittenOffQty when 0 then 'notpass' else 'pass' end fcondition ");
		sql.append(" from T_IM_SaleIssueBill sb inner join T_IM_SaleIssueEntry sbe on sb.fid=sbe.fparentid");
		sql.append(" where 1=1");
		sql.append(" and sb.FControlUnitID='"+companyID+"'");
		sql.append(" and sb.fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and sb.fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by sb.fnumber");
		
		//执行校验
		String checkItem="销售出库单未生成应收单校验";
		String billType="销售出库单";
		String billProblem="销售出库单未生成应收单";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}


	/**
     * 销售订单未关闭状态校验
     */
    @Override
	protected CheckResultInfo _saleOrderNotCloseCheck(Context ctx,
			String companyID, String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber,case fbasestatus when 7 then 'pass' else 'notpass' end fcondition");
		sql.append(" from T_SD_SaleOrder");
		sql.append(" where 1=1");
		sql.append(" and FControlUnitID='"+companyID+"'");
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
		
		//执行校验
		String checkItem="销售订单未关闭状态校验";
		String billType="销售订单";
		String billProblem="销售订单未关闭";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}


	/**
     * 采购入库单实际成本为0校验
     */
    @Override
	protected CheckResultInfo _purInWarehsACost0Check(Context ctx,
			String companyID, String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select pb.fnumber,case pbe.FActualCost when 0 then 'notpass' else 'pass' end  fcondition");
		sql.append(" from T_IM_PurInWarehsBill pb inner join T_IM_PurInWarehsEntry pbe on pb.fid=pbe.fparentid");
		sql.append(" where 1=1");
		sql.append(" and pb.FControlUnitID='"+companyID+"'");
		sql.append(" and pb.fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and pb.fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by pb.fnumber");
		
		//执行校验
		String checkItem="采购入库单实际成本为0校验";
		String billType="采购入库单";
		String billProblem="采购入库单实际成本为0";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}


	/**
     * 低值易耗品生成凭证校验
     */
    @Override
	protected CheckResultInfo _LCMCurCardCheck(Context ctx, String companyID,
			String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber ,case FFiVouchered when 0 then 'notpass' else 'pass' end  fcondition");
		sql.append(" from T_LCM_LCMCurCard");
		sql.append(" where 1=1");
		sql.append(" and FCompanyID='"+companyID+"'");
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
		
    	//执行凭证校验
		String checkItem="低值易耗品生成凭证校验";
		String billType="低值易耗品";
		String billProblem="低值易耗品未生成凭证";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}

	/**
     * 固定资产生成凭证校验
     */
    @Override
	protected CheckResultInfo _faCurCardCheck(Context ctx, String companyID,
			String periodID) throws BOSException {
    	PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber ,case FFiVouchered when 0 then 'notpass' else 'pass' end  fcondition from T_FA_FaCurCard");
		sql.append(" where 1=1");
		sql.append(" and FCompanyID='"+companyID+"'");
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
		
    	//执行凭证校验
		String checkItem="固定资产生成凭证校验";
		String billType="固定资产";
		String billProblem="固定资产未生成凭证";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	}

	/**
     * 采购入库单生成凭证校验
     */
    @Override
	protected CheckResultInfo _purInWarehsBillCheck(Context ctx,
			String companyID, String periodID) throws BOSException {
		
		PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber ,case FFiVouchered when 0 then 'notpass' else 'pass' end  fcondition from T_IM_PurInWarehsBill");
		sql.append(" where 1=1");
		sql.append(" and FControlUnitID='"+companyID+"'");//过滤控制单元
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
    	
    	//执行凭证校验
		String checkItem="采购入库单生成凭证校验";
		String billType="采购入库单";
		String billProblem="采购入库单未生成凭证";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	
	}

	/**
	 * 付款单生成凭证校验
	 */
	@Override
	protected CheckResultInfo _paymentBillCheck(Context ctx, String companyID,
			String periodID) throws BOSException {

		PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber ,case FFiVouchered when 0 then 'notpass' else 'pass' end  fcondition from T_CAS_PaymentBill");
		sql.append(" where 1=1");
		sql.append(" and FCompanyID='"+companyID+"'");
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
		
    	//执行凭证校验
		String checkItem="付款单生成凭证校验";
		String billType="付款单";
		String billProblem="付款单未生成凭证";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	
	}
    
    /**
     * 收款单生成凭证校验
     */
	@Override
	protected CheckResultInfo _receivingBillCheck(Context ctx,
			String companyID, String periodID) throws BOSException {

		PeriodInfo periodInfo = null ;
		try {
			periodInfo=PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
		} catch (EASBizException e1) {
			e1.printStackTrace();
			throw new BOSException("获取会计期间失败");
		}
		String beginDate=periodInfo.getString("beginDate");
		String endDate=periodInfo.getString("endDate").substring(0,10);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fnumber ,case FFiVouchered when 0 then 'notpass' else 'pass' end  fcondition from T_CAS_ReceivingBill");
		sql.append(" where 1=1");
		sql.append(" and FCompanyID='"+companyID+"'");
		sql.append(" and fbizdate>=to_date('"+beginDate+"')");
		sql.append(" and fbizdate<=to_date('"+endDate+"')");
		sql.append(" order by fnumber");
		
    	//执行凭证校验
		String checkItem="收款单生成凭证校验";
		String billType="收款单";
		String billProblem="收款单未生成凭证";
		CheckResultInfo resultInfo = commonBillCheck(ctx, checkItem, billType, billProblem, sql.toString());
		
		return resultInfo;
	
	}
	
	/**
	 * 校验公共方法
	 * @param ctx
	 * @param checkItem 校验项目
	 * @param billType 单据类型
	 * @param billProblem 单据问题
	 * @param sql 查询语句
	 * @return CheckResultInfo
	 * @throws BOSException
	 */
	public CheckResultInfo commonBillCheck(Context ctx,String checkItem,String billType,String billProblem,String sql) throws BOSException{
		
		CheckResultInfo resultInfo = new CheckResultInfo(checkItem);
		List<ProblemDetailInfo> problemdetailList = new ArrayList<ProblemDetailInfo>();
		IRowSet rs=DbUtil.executeQuery(ctx, sql);
		int passCount=0;
		int notPassCount=0;
		try {
			while(rs.next()){
				if(rs.getString("fcondition").equals("pass")){
					passCount++;
				}else{
					notPassCount++;
					ProblemDetailInfo problemDetailInfo=new ProblemDetailInfo();
					String fnumber=rs.getString("fnumber");
					problemDetailInfo.setBillNumber(fnumber);
					problemDetailInfo.setBillProblem(billProblem);
					problemDetailInfo.setBillType(billType);
					problemdetailList.add(problemDetailInfo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resultInfo.setSuccess(true);
		resultInfo.setReturnsObjs(problemdetailList);
		resultInfo.setCheckItem(checkItem+" ("+passCount+"/"+(passCount+notPassCount)+")");
		if(problemdetailList.size()==0){
			//校验没有错误
			resultInfo.setCheckResult("通过 ");
		}else{
			//校验出现错误
			resultInfo.setCheckResult("未通过");
		}
		return resultInfo;
	}
}