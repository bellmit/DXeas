package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;

import java_cup.internal_error;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

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
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ChickenRecBillControllerBean extends AbstractChickenRecBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.ChickenRecBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		//点击审核自动生成结算单
		createSettle(ctx,info);
		
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

/**
 * 点击审核自动生成结算单
 * @param ctx
 * @param info
 */
	private void createSettle(Context ctx, ChickenRecBillInfo info) {
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
				String botpName = "mjhs-mjjsd";

				//屠宰单
				IChickenRecBill iSaleOrder = ChickenRecBillFactory.getLocalInstance(ctx);
				IBOTMapping iMapping    = BOTMappingFactory.getLocalInstance(ctx);

				//获取btp的本地接口
				IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);
				//获取采购入库单的所有信息----源单据
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add("*");
				slor.add("SaleOrgUnit.*");
				ChickenRecBillInfo saleOrderInfo = iSaleOrder.getChickenRecBillInfo(new ObjectUuidPK(info.getId()),slor );
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
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));

		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))


			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		ChickenRecBillInfo info = (ChickenRecBillInfo) model;

		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))

			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));

		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		_audit(ctx, info);
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChickenRecBillInfo info = ChickenRecBillFactory.getLocalInstance(ctx).getChickenRecBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}

	@Override
	//根据排序与数量生成派车单
	protected void _manageCarSeq(Context ctx, IObjectValue model, Map map)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		Boolean isHasCCarsendBill=false;
		int seq= map.get("seq")==null?0:(Integer)map.get("seq");
		int qty= map.get("qty")==null?0:(Integer)map.get("qty");
		ChickenRecBillInfo cInfo = (ChickenRecBillInfo) model;
		String destBillType=null;
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
		OrgUnitInfo orgInfo=cInfo.getFICompany();
		destBillType=new CCarSendBillInfo().getBOSType().toString();
		BOTMappingCollection btpCols;
		btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, cInfo.getBOSType().toString(),destBillType,new String[]{cInfo.getString("id")},new String[]{}, new ArrayList<String>(), null);
		if(btpCols.size()!=1){
			throw new EASBizException(new NumericExceptionSubItem("001","回收订单下推派车单的转换规则未配置,或当前单据不符合转换规则的过滤条件,或配置了多个符合条件的转换规则,请联系相关人员核对规则."));
		}
		CCarSendBillInfo ccarInfo  = (CCarSendBillInfo)btpIS.createToOrderBill(ctx, cInfo, destBillType, btpCols.get(0));
		try {
			String orgUnitID=ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
			if(iCodingRuleManager.isExist(ccarInfo, orgUnitID)){
				if(iCodingRuleManager.isUseIntermitNumber(ccarInfo, orgUnitID)){
					//编码规则不允许断号 --> 获取断号编码
					ccarInfo.setNumber(iCodingRuleManager.getNonbreakNumber(ccarInfo,orgUnitID));
				}else{
					ccarInfo.setNumber(iCodingRuleManager.getNumber(ccarInfo,orgUnitID));
				}
				ccarInfo.setDeliverQty(qty);
				ccarInfo.setSeq(seq);
				CCarSendBillFactory.getLocalInstance(ctx).save(ccarInfo);
//				cInfo.setIsHasPaiChe(true);
				ChickenRecBillFactory.getLocalInstance(ctx).update(new ObjectUuidPK(cInfo.getId()), cInfo);
				isHasCCarsendBill=true;
			}
		} catch (BOTPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isHasCCarsendBill=false;
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isHasCCarsendBill=false;
		} 
	}
}