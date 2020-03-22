package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CSlaughterBillControllerBean extends AbstractCSlaughterBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CSlaughterBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		CSlaughterBillInfo info = CSlaughterBillFactory.getLocalInstance(ctx).getCSlaughterBillInfo(new ObjectUuidPK(((CSlaughterBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		updatePreHouseWgtBill(ctx, info);
		//审核的时候自动计算字段数据
		calcData(ctx, info);


		//点击审核自动生成结算单
		createSettle(ctx,info);

		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		Boolean isHasCKFreight = createToCKFreight(ctx, info);
		info.setHasFreightBill(isHasCKFreight);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	/**
	 * 审核的时候自动计算字段数据
	 * @param ctx
	 * @param info
	 */
	private void calcData(Context ctx, CSlaughterBillInfo info) {
		// TODO Auto-generated method stub
		BigDecimal settleWeight = UIRuleUtil.getBigDecimal(info.getSettleWeight());
		BigDecimal receQty = UIRuleUtil.getBigDecimal(info.getReceQty());
		info.setAvgWeight(settleWeight.divide(receQty,3,BigDecimal.ROUND_HALF_UP));

	}

	/**
	 * 点击审核屠宰单自动生成结算单
	 * 如果这些批次合同已经存在结算单就不在生成结算单了
	 * @param ctx
	 * @param info
	 */
	private void createSettle(Context ctx, CSlaughterBillInfo info) {
		// TODO Auto-generated method stub
		try {
			BatchContractBillInfo contractInfo = info.getBatchContract();

			String s1 = "/*dialect*/ select t1.fid setBillid from CT_FM_CKSettleBill t1 where t1.CFBatchContractID = '"+contractInfo.getId()+"'";
			IRowSet r1 = DbUtil.executeQuery(ctx, s1.toString());
			String setBillid = null;
			if(r1.next()){
				setBillid = r1.getString("setBillid");
			}else{//如果该批次合同不存在结算单，就审核时自动生成结算单
				CoreBillBaseCollection coreBillBaseColl = new CoreBillBaseCollection();

				//转换规则取   采购入库单  -- 销售出库单
				String botpName = "tzd-jsd";

				//屠宰单
				ICSlaughterBill iSaleOrder = CSlaughterBillFactory.getLocalInstance(ctx);
				IBOTMapping iMapping    = BOTMappingFactory.getLocalInstance(ctx);

				//获取btp的本地接口
				IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);
				//获取采购入库单的所有信息----源单据
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add("*");
				slor.add("SaleOrgUnit.*");
				CSlaughterBillInfo saleOrderInfo = iSaleOrder.getCSlaughterBillInfo(new ObjectUuidPK(info.getId()),slor );
				coreBillBaseColl.add(saleOrderInfo);
				if(coreBillBaseColl.size() > 0){
					//根据 单据转换规则  获取   单据转换规则的实体--获得所设置的单据转换规则
					BOTMappingInfo botMappingInfo = iMapping.getBOTMappingInfo("where name='" + botpName + "'");
					if(botMappingInfo.getExtRule().isIsEffected()){
						//transformResult 为转换成功后自动生成的目标单据（coreBillBaseColl--源单据，botMappingInfo--单据转换规则）
						BTPTransformResult transformResult = iBTPManager.transform(coreBillBaseColl, botMappingInfo);
						//获取转换之后的目标单据
						IObjectCollection bills = transformResult.getBills();
						BOTRelationCollection botRelationCols = transformResult.getBOTRelationCollection();
						for (int i = 0; i < bills.size(); i++) {
							CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) bills.getObject(i);
							iBTPManager.submitRelations(destBillInfo, botRelationCols);
						}
					}

				}
			}

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		CSlaughterBillInfo info = CSlaughterBillFactory.getLocalInstance(ctx).getCSlaughterBillInfo(new ObjectUuidPK(((CSlaughterBillInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CSlaughterBillInfo info = (CSlaughterBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CSlaughterBillInfo info = (CSlaughterBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		super._update(ctx,new ObjectUuidPK( info.getId()), info);
//		_audit(ctx, info);
		info=CSlaughterBillFactory.getLocalInstance(ctx).getCSlaughterBillInfo(new ObjectUuidPK(((CSlaughterBillInfo) model).getId()));
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CSlaughterBillInfo info = CSlaughterBillFactory.getLocalInstance(ctx).getCSlaughterBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("/*dialect*/update  CT_FM_PreHouseWgtBill  t1 ")
		.append(" set  CFIsHasTuZai ='0'")
		.append(" where t1.fid in(select t3.FSrcObjectID from CT_FM_CSlaughterBill t2 inner join T_BOT_Relation t3 ")
		.append(" on t2.fid=t3.FDestObjectID and t3.FSrcEntityID='"+new PreHouseWgtBillInfo().getBOSType().toString()+"' where t2.fid='"+info.getId().toString()+"') ");
		try {
			DbUtil.execute(ctx, sqlBuf.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super._delete(ctx, pk);
	}

	private void checkIsSettled(Context ctx,CSlaughterBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		Boolean isHasSettled = StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString());
		if(isHasSettled){
			throw new EASBizException(new NumericExceptionSubItem("001","该批次已完全回收结算,操作失败!"));
		}
	}

	private void checkIsGuanZhang(Context ctx,CSlaughterBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		boolean isGuanZhang=false;
		String companyID = info.getFICompany().getId().toString();
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

	//反写棚前过磅单与毛鸡回收订单
	private void updatePreHouseWgtBill(Context ctx, CSlaughterBillInfo info) {
		// TODO Auto-generated method stub
		try {
			StringBuffer sqlBuf = new StringBuffer();	
			sqlBuf.append("/*dialect*/update  CT_FM_PreHouseWgtBill  t1 set t1.CFPreHouseQty=")
			.append(info.getPreHouseQty()).append(",t1.CFPreHouseSuttle=").append(info.getPreHouseSuttle())
			.append(",t1.CFPreHouseGross=").append(info.getPreHouseGross())
			.append(",t1.CFPreHouseTare=").append(info.getPreHouseTare())
			.append(",t1.CFRecQty=").append(info.getRecQty())
			.append(",t1.CFSettleWgt=").append(info.getSettleWgt())
			//			.append(",t1.CFRecSuttle=").append(info.getRecSuttle())
			.append(",t1.CFCompanyWgtGross=").append(info.getCompanyGross())
			.append(",t1.CFCompanyWgtTare=").append(info.getCompanyTare())
			.append(",t1.CFCompanyWgtSuttle=").append(info.getCompanySuttle())
			//			.append(",t1.CFOutSaleAmt=nvl(CFOutSalePrice,0)*").append(info.getRecSuttle()==null?BigDecimal.ZERO:info.getRecSuttle())
			.append(" where t1.fid in(select t3.FSrcObjectID from CT_FM_CSlaughterBill t2 inner join T_BOT_Relation t3 ")
			.append(" on t2.fid=t3.FDestObjectID and t3.FSrcEntityID='"+new PreHouseWgtBillInfo().getBOSType().toString()+"' where t2.fid='"+info.getId().toString()+"') ");
			DbUtil.execute(ctx, sqlBuf.toString());

			SimpleDateFormat sdfTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			StringBuffer sqlBuf2 = new StringBuffer();
			sqlBuf2.append("/*dialect*/update CT_FM_ChickenRecBill t1 set t1.CFActualAverageWgt="+info.getCAverageWgt()+",CFPreHouseQty="+info.getPreHouseSuttle()+",CFActualDeliverDate=to_date('"+sdfTime.format(info.getBizDate())+"','yyyy-MM-dd HH24:mi:ss')")
			.append(" where t1.fid in (select t5.FSrcObjectID fid from CT_FM_CSlaughterBill t2  ")
			.append(" inner join  T_BOT_Relation t3 on t3.FDestObjectID=t2.fid  ")
			.append(" inner join T_BOT_Relation t4 on t4.FDestObjectID=t3.FSrcObjectID  ")
			.append(" inner join T_BOT_Relation  t5 on t5.FDestObjectID=t4.FSrcObjectID  ")
			.append(" where t2.fid='"+info.getId().toString()+"') ");

			DbUtil.execute(ctx, sqlBuf2.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 生成毛鸡运费单
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private Boolean createToCKFreight(Context ctx,CSlaughterBillInfo info) throws BOSException, EASBizException{
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=info.getFICompany();
		destBillType=new CKFreightBillInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		if(btpCols.size()>0) {
			CKFreightBillInfo cKFInfo  = (CKFreightBillInfo)btpIS.createToOrderBill(ctx, info, destBillType, btpCols.get(0));
			try {
				String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
				if(iCodingRuleManager.isExist(cKFInfo, orgUnitID)){
					if(iCodingRuleManager.isUseIntermitNumber(cKFInfo, orgUnitID)){
						//编码规则不允许断号 --> 获取断号编码
						cKFInfo.setNumber(iCodingRuleManager.getNonbreakNumber(cKFInfo,orgUnitID));
					}else{
						cKFInfo.setNumber(iCodingRuleManager.getNumber(cKFInfo,orgUnitID));
					}
				}
				CKFreightBillFactory.getLocalInstance(ctx).save(cKFInfo);
				return true;
			} catch (BOTPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}