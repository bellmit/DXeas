package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDTextArea;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.SaleIssueBill;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

public class FodderReceptionControllerBean extends AbstractFodderReceptionControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.FodderReceptionControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		FodderReceptionInfo info = FodderReceptionFactory.getLocalInstance(ctx).getFodderReceptionInfo(new ObjectUuidPK(((FodderReceptionInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info=checkIsSanZhuang(ctx, info);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//生成供应链单据
		Boolean isHasSaleOrder=createToSCMBill(ctx, info);
		info.setIsHasSaleOrder(isHasSaleOrder);
		Boolean isHasSaleIssueBill = createToSaleIssueBill(ctx, info);
		info.setIsHasSaleIssue(isHasSaleIssueBill);

		//计算饲料数量
		calcFeedQty(ctx,info,true);

		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	/**
	 * 计算饲料数量
	 * @param ctx
	 * @param info
	 * @param b
	 */
	private void calcFeedQty(Context ctx, FodderReceptionInfo info, boolean isAudit) {
		// TODO Auto-generated method stub


		try {
			String s3 = null;
			if(info.getBizDate() != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s1 = sdf.format(new Date());
				s1 = s1.substring(11,19);
				System.out.println(s1);
				String s2 = sdf.format(info.getBizDate());
				s2 = s2.substring(0,10);
				System.out.println(s2);
				s3 = s2+" "+s1;
				System.out.println(s3);
				info.setBizDate(sdf.parse(s3));
			}

			//批次合同
			BatchContractBillInfo batchContractInfo = info.getBatchContract();
			if(batchContractInfo.getId() != null){
				batchContractInfo = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(batchContractInfo.getId()));
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//查找前中后期物料的超药比例
			if(info.getSettlePolicy() != null){

				//该批次合同雏苗数量
				BigDecimal contRactQty = batchContractInfo.getFemaleBreedQty();

				SettlePolicyInfo setInfo = (SettlePolicyInfo) info.getSettlePolicy();
				//------------------------------------------------------前期物料----------------------------------------------------------
				BigDecimal easlyRate = BigDecimal.ZERO;
				String s1 = "/*dialect*/ select distinct t2.CFOverRate overRate from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid = t1.fid" +
				" inner join T_BD_Material t3 on t3.fid = t2.FMaterialID where t3.fnumber in ('02-000851','02-001461','02-001509') " +
				" and t1.fid ='"+setInfo.getId()+"'";
				IRowSet r1 = DbUtil.executeQuery(ctx, s1);
				if(r1.next()){
					easlyRate = UIRuleUtil.getBigDecimal(r1.getBigDecimal("overRate"));
					easlyRate = easlyRate.multiply(new BigDecimal("100"));
				}

				//前期饲料领用单领用数量
				StringBuffer s11 = new StringBuffer();
				s11.append( "/*dialect*/ select sum(tt.earlyQty) earlyQty, sum(tt.earlyAuditQty) earlyAuditQty,  sum(tt.earlyUnAuditQty) earlyUnAuditQty from (  select 0 earlyQty,sum(t2.FReceiveQty) earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1");
				s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
				s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.FBillStatus in(4,7) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );

				s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
				s11.append( " union all select 0 earlyQty,0 earlyAuditQty,sum(t2.FReceiveQty) earlyUnAuditQty from T_FM_FodderReception t1" );
				s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
				s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.FBillStatus in (1,2) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );

				s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
				s11.append( " union all select sum(t2.FReceiveQty) earlyQty,0 earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1" );
				s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
				s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );

				s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"')tt");



				BigDecimal earlyQty = BigDecimal.ZERO;
				BigDecimal earlyAuditQty = BigDecimal.ZERO;
				BigDecimal earlyUnAuditQty = BigDecimal.ZERO;
				IRowSet r11 = DbUtil.executeQuery(ctx, s11.toString());
				if(r11.next()){
					earlyQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyQty"));
					earlyAuditQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyAuditQty"));
					earlyUnAuditQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyUnAuditQty"));
				}

				//前期肉仔鸡配合饲料标准用量
				info.setEarlyStand(contRactQty.multiply(easlyRate).divide(new BigDecimal("100")));
				//前期肉仔鸡配合饲料已开票数量
				info.setEarlyVou(earlyQty);
				//前期肉仔鸡配合饲料已审核数量
				info.setEarlyAudit(earlyAuditQty);
				//前期肉仔鸡配合饲料未审核数量
				info.setEarlyUnAudit(earlyUnAuditQty);
				//前期肉仔鸡配合饲料允许开票数量
				info.setEarlyAllow(contRactQty.multiply(easlyRate).divide(new BigDecimal("100")).subtract(earlyQty));

				//-------------------------------------------------中期-------------------------------------------------------------------
				BigDecimal midRate = BigDecimal.ZERO;
				String s2 = "/*dialect*/ select distinct t2.CFOverRate overRate from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid = t1.fid" +
				" inner join T_BD_Material t3 on t3.fid = t2.FMaterialID where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463')" +
				" and t1.fid ='"+setInfo.getId()+"'";
				IRowSet r2 = DbUtil.executeQuery(ctx, s2.toString());
				if(r2.next()){
					midRate = UIRuleUtil.getBigDecimal(r2.getBigDecimal("overRate"));
					midRate = midRate.multiply(new BigDecimal("100"));
				}

				//中期饲料领用单领用数量
				StringBuffer s21 = new StringBuffer();
				s21.append( "/*dialect*/ select sum(tt.earlyQty) earlyQty, sum(tt.earlyAuditQty) earlyAuditQty,  sum(tt.earlyUnAuditQty) earlyUnAuditQty from (  select 0 earlyQty,sum(t2.FReceiveQty) earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1");
				s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
				s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and  t1.FBillStatus in(4,7)  and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
				s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
				s21.append( " union all select 0 earlyQty,0 earlyAuditQty,sum(t2.FReceiveQty) earlyUnAuditQty from T_FM_FodderReception t1" );
				s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
				s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and t1.FBillStatus in (1,2) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
				s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
				s21.append( " union all select sum(t2.FReceiveQty) earlyQty,0 earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1" );
				s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
				s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
				s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"')tt");

				BigDecimal midQty = BigDecimal.ZERO;
				BigDecimal midAuditQty = BigDecimal.ZERO;
				BigDecimal midUnAuditQty = BigDecimal.ZERO;
				IRowSet r21 = DbUtil.executeQuery(ctx, s21.toString());
				if(r21.next()){
					midQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyQty"));
					midAuditQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyAuditQty"));
					midUnAuditQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyUnAuditQty"));
				}

				//中期肉仔鸡配合饲料标准用量
				info.setMidStand(contRactQty.multiply(midRate).divide(new BigDecimal("100")));
				//中期肉仔鸡配合饲料已开票数量
				info.setMidVouch(midQty);
				//中期肉仔鸡配合饲料已审核数量
				info.setMidAudit(midAuditQty);
				//中期肉仔鸡配合饲料未审核数量
				info.setMidUnAudit(midUnAuditQty);
				//中期肉仔鸡配合饲料允许开票数量
				info.setMidAllow(contRactQty.multiply(midRate).divide(new BigDecimal("100")).subtract(midQty));

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 生成销售订单
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 * @throws EASBizException 
	 */
	private Boolean createToSCMBill(Context ctx,FodderReceptionInfo info) throws BOSException, EASBizException{
		Boolean isHasSaleOrder=false;
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getCompany();
		destBillType=new SaleOrderInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		for(int index=0;index<btpCols.size();index++) {
			SaleOrderInfo saleInfo  = (SaleOrderInfo)btpIS.createToOrderBill(ctx, info, destBillType, btpCols.get(index));
			isHasSaleOrder=true;
			try {
				String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
				if(iCodingRuleManager.isExist(saleInfo, orgUnitID)){
					if(iCodingRuleManager.isUseIntermitNumber(saleInfo, orgUnitID)){
						//编码规则不允许断号 --> 获取断号编码
						saleInfo.setNumber(iCodingRuleManager.getNonbreakNumber(saleInfo,orgUnitID));
					}else{
						saleInfo.setNumber(iCodingRuleManager.getNumber(saleInfo,orgUnitID));
					}
				}
				SaleOrderFactory.getLocalInstance(ctx).submit(saleInfo);
				SaleOrderFactory.getLocalInstance(ctx).audit(new ObjectUuidPK(saleInfo.getId()),saleInfo);
			} catch (BOTPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return isHasSaleOrder;
	}

	/**
	 * 生成销售出库单
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 * @throws EASBizException 
	 */
	private Boolean createToSaleIssueBill(Context ctx,FodderReceptionInfo info) throws BOSException, EASBizException{
		Boolean isHasSaleIssueBill=false;
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getCompany();
		destBillType=new SaleIssueBillInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		for(int index=0;index<btpCols.size();index++) {
			SaleIssueBillInfo saleIssueBill  = (SaleIssueBillInfo)btpIS.createToOrderBill(ctx, info, destBillType, btpCols.get(index));
			isHasSaleIssueBill=true;
			try {
				String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
				if(iCodingRuleManager.isExist(saleIssueBill, orgUnitID)){
					if(iCodingRuleManager.isUseIntermitNumber(saleIssueBill, orgUnitID)){
						//编码规则不允许断号 --> 获取断号编码
						saleIssueBill.setNumber(iCodingRuleManager.getNonbreakNumber(saleIssueBill,orgUnitID));
					}else{
						saleIssueBill.setNumber(iCodingRuleManager.getNumber(saleIssueBill,orgUnitID));
					}
				}
				//				SaleOrderFactory.getLocalInstance(ctx).submit(saleIssueBill);
				//				SaleOrderFactory.getLocalInstance(ctx).audit(new ObjectUuidPK(saleIssueBill.getId()),saleIssueBill);
			} catch (BOTPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return isHasSaleIssueBill;
	}


	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		FodderReceptionInfo info = FodderReceptionFactory.getLocalInstance(ctx).getFodderReceptionInfo(new ObjectUuidPK(((FodderReceptionInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		if(info.isIsFromTiaoLiao()){
			throw new EASBizException(new NumericExceptionSubItem("001","从调料单生成的饲料领用单不允许执行此操作"));
		}
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//计算饲料数量
		calcFeedQty(ctx,info,false);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FodderReceptionInfo info = (FodderReceptionInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getBatchContract().getId().toString());
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}

		info=checkIsSanZhuang(ctx, info);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FodderReceptionInfo info = (FodderReceptionInfo) model;
		//		checkFeedUsageIsOverFlow(ctx,info);
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		StockingComm.checkIsOutMonth(ctx, info.getBizDate(), info.getBatchContract().getId().toString());
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		//		info=checkIsSanZhuang(ctx, info);
		//		super._save(ctx, info);
		//		_audit(ctx, info);
		//		info=FodderReceptionFactory.getLocalInstance(ctx).getFodderReceptionInfo(new ObjectUuidPK(info.getId()));
		//		try {
		//			calcFeedQty(ctx,info);
		//		} catch (SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		return super._submit(ctx, info);
	}

	private FodderReceptionInfo checkIsSanZhuang(Context ctx,FodderReceptionInfo info) {
		// TODO Auto-generated method stub
		info.setIsSanZhuang(false);
		for(int i=0;i<info.getEntrys().size();i++){
			if(info.getEntrys().get(i).getUnitQty()==null||info.getEntrys().get(i).getUnitQty().signum()==0){
				info.setIsSanZhuang(true);
				return info;
			}
		}
		return info;
	}

	/**
	 * 校验饲料用量是否超标
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private void checkFeedUsageIsOverFlow(Context ctx, FodderReceptionInfo info) throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		ArrayList<String> stdList = new ArrayList<String>();


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		BigDecimal stdUseAvg = null;
		BigDecimal overFlowRate = null;

		// 获取饲喂标准
		String str = "select t1.FOverflowStd,sum(FTotalStdUse)  stdUseAvg from T_FM_FeedStd t1 inner join T_FM_FeedStdTotalEntry t2 on t1.FID=t2.FParentID  where t1.CFCompanyID='"+info.getCompany().getString("id")+"' and t1.CFBeginDate<={ts '"+sdf.format(new Date())+" 00:00:00'} and t1.CFEndDate>={ts '"+sdf.format(new Date())+" 23:59:59'} and t1.CFBillStatus=4 group by t1.FOverflowStd";
		IRowSet rs = DbUtil.executeQuery(ctx, str);
		try {
			if(rs.next()){         
				stdUseAvg = UIRuleUtil.getBigDecimal(rs.getBigDecimal("stdUseAvg")).compareTo(BigDecimal.ZERO)==0?null:rs.getBigDecimal("stdUseAvg");
				overFlowRate = UIRuleUtil.getBigDecimal(rs.getBigDecimal("FOverflowStd")).compareTo(BigDecimal.ZERO)==0?null:rs.getBigDecimal("FOverflowStd");;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stdUseAvg == null)
			return;
		if(overFlowRate == null)
			return;



		String batchID;
		BatchInfo batchInfo;
		BigDecimal femaleQty;
		BigDecimal totalQtyStd;

		IRowSet rsAct ;
		IBatch iBatch = BatchFactory.getLocalInstance(ctx);
		for(int i=0;i<info.getEntrys().size();i++){

			batchID = info.getEntrys().get(i).getBatch().getString("id");
			if(stdList.contains(batchID))
				continue;
			stdList.add(batchID);
			batchInfo = iBatch.getBatchInfo(new ObjectUuidPK(batchID));
			femaleQty = batchInfo.getFemaleQty();
			// 查询标准用量标准
			totalQtyStd = stdUseAvg.multiply(femaleQty);

			rsAct = DbUtil.executeQuery(ctx ,"select sum(t2.FConfirmQty) FConfirmQty from T_FM_FodderReception  t1 inner join T_FM_FodderReceptionEntry t2 on t1.FID=t2.FParentID and t2.FBatchID='"+batchID+"'");
			try {
				if(rsAct.next()){
					if(totalQtyStd.multiply(BigDecimal.ONE.add(overFlowRate.divide(new BigDecimal(100),6,BigDecimal.ROUND_HALF_UP))).compareTo(UIRuleUtil.getBigDecimal(rsAct.getBigDecimal("FConfirmQty")))<0){
						throw new EASBizException(new NumericExceptionSubItem("001","第"+(i+1)+"条分录饲料用量超标"));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;

	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FodderReceptionInfo info = FodderReceptionFactory.getLocalInstance(ctx).getFodderReceptionInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核或关闭，禁止删除！"));
		}
		super._delete(ctx, pk);
	}



	@Override
	protected void _close(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		FodderReceptionInfo info = FodderReceptionFactory.getLocalInstance(ctx).getFodderReceptionInfo(new ObjectUuidPK(((FodderReceptionInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.CLOSED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unClose(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		FodderReceptionInfo info = FodderReceptionFactory.getLocalInstance(ctx).getFodderReceptionInfo(new ObjectUuidPK(((FodderReceptionInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有关闭的单子才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	private void checkIsSettled(Context ctx,FodderReceptionInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		Boolean isHasSettled = StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString());
		if(isHasSettled){
			throw new EASBizException(new NumericExceptionSubItem("001","该批次已完全回收结算,操作失败!"));
		}
	}

	private void checkIsGuanZhang(Context ctx,FodderReceptionInfo info) throws EASBizException {
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
	protected void _viewStdUse(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

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
	@Override
	protected void _batchSubmit(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}


}