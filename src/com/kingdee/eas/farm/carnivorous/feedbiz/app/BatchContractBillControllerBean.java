package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill;

import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationFactory;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationInfo;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.codingrule.CodingRuleFactory;
import com.kingdee.eas.base.codingrule.CodingRuleInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRule;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.CORelatedType;
import com.kingdee.eas.basedata.assistant.CalculateModeEnum;
import com.kingdee.eas.basedata.assistant.CostObjectEntryInfo;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.scm.im.inv.InvException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BatchContractBillControllerBean extends AbstractBatchContractBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillControllerBean");
	private SimpleDateFormat sdfNum=new SimpleDateFormat("yyyyMMdd");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		try {
			BatchContractBillInfo info = (BatchContractBillInfo) model;
			if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
				throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));

			//			if(StockingComm.checkIsHasSameContract(ctx, info.getFarmer().getId().toString(), info.getFarm().getId().toString(), info.getBizDate(), true)){
			//				throw new EASBizException(new NumericExceptionSubItem("001","存在已审核的同一养殖户/场且同一日期的批次合同,操作失败!"));	
			//			}
			Boolean hasUnSettledBatch = StockingComm.isHasUnSettledBatch(ctx, info.getFarmer().getId().toString(), info.getFarm().getId().toString(), info.getId().toString());
			SettlePolicyInfo policy = SettlePolicyFactory.getLocalInstance(ctx).getSettlePolicyInfo(new ObjectUuidPK(info.getSettlementPolicy().getId()));
			boolean isForbidUnSettle = UIRuleUtil.getBooleanValue(policy.isIsForbidUnSettle());
			if(isForbidUnSettle){
				if(hasUnSettledBatch){
					throw new EASBizException(new NumericExceptionSubItem("001","该养殖户/场存在未结算的批次合同,操作失败!"));
				}
			}
			//校验该养殖场是否存在未结算的批次，存在的话不允许审核新的批次合同
			//			try{
			//			cheakBatchSettled(ctx,info);
			//			}catch(Exception e1){
			//				throw new EASBizException(new NumericExceptionSubItem("001",e1.getMessage()));
			//			}


			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			setNumber(ctx, info, true);


			//生成成本对象
			if(info.getCostObject() == null){
				createCostObject(ctx,info);
			}
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
			updateFarmerMarginForAudit(ctx, info);

			//调用转换规则自动生成雏苗领用单
			cteateBreedBill(ctx,info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}
	/**
	 * 校验该养殖场是否存在未结算的批次，存在的话不允许审核新的批次合同
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private void cheakBatchSettled(Context ctx, BatchContractBillInfo info) throws BOSException, SQLException {
		// TODO Auto-generated method stub
		String s1 = "/*dialect*/ select t1.fid billid from T_FM_BatchContractBill t1" +
		" where (t1.CFIsRecSettled = 0 or t1.CFIsRecSettled is null) and t1.FBillStatus in (4,7)" +
		" and t1.FFarmID = '"+info.getFarm().getId()+"'";
		IRowSet r1 = DbUtil.executeQuery(ctx, s1);
		String billid = null;
		if(r1.next()){
			billid = UIRuleUtil.getString(r1.getString("billid"));
			if(UIRuleUtil.isNotNull(billid)){
				throw new BOSException("养殖场存在未结算的批次，不允许审核新的批次合同！");
				//        		MsgBox.showWarning("养殖场存在未结算的批次，不允许审核新的批次合同！");
				//        		SysUtil.abort();
			}
		}




	}

	/**
	 * 生成成本对象
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void createCostObject(Context ctx, BatchContractBillInfo info) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		// 创建育成成本对象
		BreedDataInfo bInfo = null;
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add(new SelectorItemInfo("*"));
		slor.add(new SelectorItemInfo("material.*"));
		slor.add(new SelectorItemInfo("bridMaterial.*"));
		slor.add(new SelectorItemInfo("Entry.*"));
		slor.add(new SelectorItemInfo("Entry.material.*"));
		slor.add(new SelectorItemInfo("farm.*"));
		BaseSysSettingInfo sysSetting = null;
		FarmInfo farmInfo = null;
		String dateCode=sdfNum.format(info.getBizDate());
		if(info.getBreedData() != null){
			sysSetting = com.kingdee.eas.farm.stocking.common.StockingComm.getSysSetting(ctx, info.getCompany().getString("id"));
			bInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(info.getBreedData().getId()),slor);
			farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()),slor);
		}else{
			throw new BOSException("品种信息不能为空！");
		}

		CoreBaseCollection cols=new CoreBaseCollection();
		CostObjectGroupInfo costObjectGroup;
		CostObjectInfo cInfo = new CostObjectInfo();
		cInfo.setCompany(info.getCompany());
		if(UIRuleUtil.isNotNull(info.getHouse())){
			FarmHouseEntryInfo  houseInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(info.getHouse().getId()));
			cInfo.setNumber("SPD"+"-"+farmInfo.getName()+"-"+houseInfo.getName()+"-"+dateCode);
			cInfo.setBatchNumber(info.getNumber());
			cInfo.setName("SPD"+"-"+farmInfo.getName()+"-"+houseInfo.getName()+"-"+dateCode);
		}else{
			cInfo.setNumber("SPD"+"-"+farmInfo.getName()+"-"+dateCode);
			cInfo.setBatchNumber(info.getNumber());
			cInfo.setName("SPD"+"-"+farmInfo.getName()+"-"+dateCode);
		}
		cInfo.setCalculateMode(CalculateModeEnum.BYBATCH);// 计算方法
		cInfo.setRelatedType(CORelatedType.Product);//关联类型
		cInfo.setRelatedId(bInfo.getWeedoutMaterial().getId());// 物料id

		cInfo.setRelatedNumber(bInfo.getWeedoutMaterial().getNumber());
		cInfo.setRelatedName(bInfo.getWeedoutMaterial().getName());
		cInfo.setStdProductID(bInfo.getWeedoutMaterial());// 关联物料
		cInfo.setGroup(bInfo.getWeedoutMaterial().getMaterialGroup());

		costObjectGroup=null;
		MaterialInfo matInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(bInfo.getWeedoutMaterial().getId()));
		if(matInfo.getMaterialGroup()!=null) {
			costObjectGroup=getCostObjectGroupByMaterialGroupID(ctx, info.getCompany().getString("id"), matInfo.getMaterialGroup().getString("id"));
		}
		if(costObjectGroup==null) {
			costObjectGroup=sysSetting.getCostGroup();
		}
		cInfo.setCostObjectGroup(costObjectGroup);// 成本对象分组
		CostObjectEntryInfo ceInfo = new CostObjectEntryInfo();
		ceInfo.setIsMainProduct(true);
		ceInfo.setQuotiety(BigDecimal.ONE);
		ceInfo.setRelatedID(bInfo.getWeedoutMaterial().getId());
		ceInfo.setRelatedNumber(bInfo.getWeedoutMaterial().getNumber());
		ceInfo.setRelatedName(bInfo.getWeedoutMaterial().getName());
		cInfo.getEntries().add(ceInfo);
		cols.add(cInfo);
		info.setCostObject(cInfo);

		if(cols.size()>0) {
			CostObjectFactory.getLocalInstance(ctx).addnew(cols);
		}

	}

	/**
	 * 通过物料分组获取成本对象分组
	 * @param ctx
	 * @param companyID
	 * @param materialGroupID
	 * @return 
	 */
	private CostObjectGroupInfo getCostObjectGroupByMaterialGroupID(Context ctx,String companyID,String materialGroupID) {
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid")
			.append(" from t_bd_costObjectGroup ")
			.append(" where FSourceID='").append(materialGroupID).append("'")
			;
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				return CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 调用转换规则自动生成雏苗领用单
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void cteateBreedBill(Context ctx, BatchContractBillInfo info) throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		CoreBillBaseCollection coreBillBaseColl = new CoreBillBaseCollection();

		//转换规则取   采购入库单  -- 销售出库单
		String botpName = "pcht-ccly";

		//批次合同
		IBatchContractBill iSaleOrder = BatchContractBillFactory.getLocalInstance(ctx);
		IBOTMapping iMapping    = BOTMappingFactory.getLocalInstance(ctx);

		//获取btp的本地接口
		IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);

		//获取采购入库单的所有信息----源单据
		SelectorItemCollection slor = new SelectorItemCollection();
		slor.add("*");
		slor.add("SaleOrgUnit.*");
		BatchContractBillInfo saleOrderInfo = iSaleOrder.getBatchContractBillInfo(new ObjectUuidPK(info.getId()),slor );

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
					//根据编码规则生成编码
					BreedSeedReceiveBillInfo breedInfo = BreedSeedReceiveBillFactory.getLocalInstance(ctx).getBreedSeedReceiveBillInfo(new ObjectUuidPK(destBillInfo.getId()));
					ICodingRule codingRule = CodingRuleFactory.getLocalInstance(ctx);
					ICodingRuleManager codingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
					CodingRuleInfo codingInfo = codingRule.getCodingRuleInfo("where id='51qyNKr3TV+is/8acnF97PimVMM='");//编码规则id
					String codeRuleMgr = codingRuleManager.getNumber(breedInfo,codingInfo);
					System.out.println(codeRuleMgr);
					String s1 = "/*dialect*/ update T_FM_BreedSeedReceiveBill set fnumber = '"+codeRuleMgr+"' where fid = '"+breedInfo.getId()+"'";
					com.kingdee.eas.util.app.DbUtil.execute(ctx, s1.toString());

				}

			}

		}






	}



	private void setNumber(Context ctx, BatchContractBillInfo info,Boolean isAudit) {
		// TODO Auto-generated method stub
		try {
			FarmerInfo farmer=FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(info.getFarmer().getId()));
			String farmerName =farmer.getName();
			FarmInfo farm=FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
			//			String farmCode=farm.getMnemonicCode();
			String farmCode=farm.getName();
			String dateCode=sdfNum.format(info.getBizDate());

			String newNum = null;
			if(farmCode != null){
				newNum= farmCode+"-"+dateCode;
			}
			if(isAudit){
				//编码规则加上棚舍
				if(UIRuleUtil.isNotNull(info.getHouse())){
					FarmHouseEntryInfo  houseInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(info.getHouse().getId()));
					newNum = farmCode+"-"+houseInfo.getName()+"-"+dateCode;
					info.setNumber(newNum);
				}else{
					info.setNumber(newNum);
				}
			}else{
				info.setNumber(null);
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	//更新养殖户保证金
	private void updateFarmerMarginForAudit(Context ctx, BatchContractBillInfo info) {
		// TODO Auto-generated method stub
		BigDecimal usedMargin = info.getUsedMargin()==null?BigDecimal.ZERO:info.getUsedMargin();
		String sql="update CT_FM_Farmer set cfoccupymargin=isnull(cfoccupymargin,0) +("+usedMargin+"),cfenableMargin=isnull(cfenableMargin,0)-("+usedMargin+") where fid='"+info.getFarmer().getId().toString()+"'";
		try {
			DbUtil.execute(ctx, sql);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	private void updateFarmerMarginForUnAudit(Context ctx, BatchContractBillInfo info) {
		// TODO Auto-generated method stub
		BigDecimal usedMargin = info.getUsedMargin()==null?BigDecimal.ZERO:info.getUsedMargin();
		String sql="update CT_FM_Farmer set cfoccupymargin=isnull(cfoccupymargin,0) -("+usedMargin+"),cfenableMargin=isnull(cfenableMargin,0)+("+usedMargin+") where fid='"+info.getFarmer().getId().toString()+"'";
		try {
			DbUtil.execute(ctx, sql);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException,EASBizException{
		try {
			BatchContractBillInfo info = (BatchContractBillInfo) model;

			//			StringBuffer sql=new StringBuffer();
			//			sql.append(" select '批次'||':'||fnumber fname from t_fm_Batch where FBatchContractID='").append(info.getString("id")).append("'")
			//			.append(" union all")
			//			.append(" select '种苗领用'||':'||fnumber fname from T_FM_BreedSeedReceiveBill where FBatchContractID='").append(info.getString("id")).append("'")
			//			.append(" union all")
			//			.append(" select '饲料领用'||':'||fnumber fname from T_FM_FodderReception where CFBatchContractID='").append(info.getString("id")).append("'")
			//			.append(" union all")
			//			.append(" select '药品处方'||':'||fnumber fname from T_FM_DrugReceiveBill where FBatchContractID='").append(info.getString("id")).append("'")
			//			.append(" union all")
			//			.append(" select '保证金解锁单'||':'||t2.fnumber fname from CT_FM_MarginUnlockBillEntry t1  inner join CT_FM_MarginUnlockBill t2 on t2.fid=t1.fparentid where CFBatchContractID='"+info.getId().toString()+"' ")
			//			.append(" union all")
			//			.append(" select '毛鸡回收订单'||':'||fnumber fname from CT_FM_ChickenRecBill where CFBatchContractID='"+info.getId().toString()+"' ");
			//			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			//			if(rs.next()) {
			//				throw new Exception("合同已经被\""+rs.getString("fname")+"\"引用，禁止反审核！");
			//			}
			if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
				throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			setNumber(ctx, info, false);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
			updateFarmerMarginForUnAudit(ctx, info);
		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
	}



	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BatchContractBillInfo info = (BatchContractBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		//		if(StockingComm.checkIsHasSameContract(ctx, info.getFarmer().getId().toString(), info.getFarm().getId().toString(), info.getBizDate(), true)){
		//			throw new EASBizException(new NumericExceptionSubItem("001","存在已审核的同一养殖户/场且同一日期的批次合同,操作失败!"));	
		//		}
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		BatchContractBillInfo info = (BatchContractBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		//		if(StockingComm.checkIsHasSameContract(ctx, info.getFarmer().getId().toString(), info.getFarm().getId().toString(), info.getBizDate(), true)){
		//			throw new EASBizException(new NumericExceptionSubItem("001","存在已审核的同一养殖户/场且同一日期的批次合同,操作失败!"));	
		//		}
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		BatchContractBillInfo info = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.cancel)||info.getBillStatus().equals(BillBaseStatusEnum.DELETED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据处于审核.作废或禁用状态，禁止删除！"));
		}

		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","当前单据尚在工作流执行过程,不能执行该操作"));
		}

		//		StringBuffer sqlBuf = new StringBuffer();
		//		sqlBuf.append(" select fid from T_FM_BreedSeedReceiveBill where FBatchContractID='"+info.getId().toString()+"' ")
		//		.append(" union all ")
		//		.append(" select fid from CT_FM_MarginUnlockBillEntry where CFBatchContractID='"+info.getId().toString()+"' ")
		//		.append(" union all ")
		//		.append(" select fid from T_FM_FodderReception where CFBatchContractID='"+info.getId().toString()+"' ")
		//		.append(" union all ")
		//		.append(" select fid from T_FM_DrugReceiveBill where FBatchContractID='"+info.getId().toString()+"' ")
		//		.append(" union all ")
		//		.append(" select fid from CT_FM_ChickenRecBill where CFBatchContractID='"+info.getId().toString()+"' ");
		//		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sqlBuf.toString()).executeSQL();
		//		if(rs.size()>0){
		//			throw new EASBizException(new NumericExceptionSubItem("001","该批次合同已被其他单据引用,不能删除！"));
		//		}

		StringBuffer sql=new StringBuffer();
		sql.append(" select '批次'||':'||fnumber fname from t_fm_Batch where FBatchContractID='").append(info.getString("id")).append("'")
		.append(" union all")
		.append(" select '种苗领用'||':'||fnumber fname from T_FM_BreedSeedReceiveBill where FBatchContractID='").append(info.getString("id")).append("'")
		.append(" union all")
		.append(" select '饲料领用'||':'||fnumber fname from T_FM_FodderReception where CFBatchContractID='").append(info.getString("id")).append("'")
		.append(" union all")
		.append(" select '药品处方'||':'||fnumber fname from T_FM_DrugReceiveBill where FBatchContractID='").append(info.getString("id")).append("'")
		.append(" union all")
		.append(" select '保证金解锁单'||':'||t2.fnumber fname from CT_FM_MarginUnlockBillEntry t1  inner join CT_FM_MarginUnlockBill t2 on t2.fid=t1.fparentid where CFBatchContractID='"+info.getId().toString()+"' ")
		.append(" union all")
		.append(" select '毛鸡回收订单'||':'||fnumber fname from CT_FM_ChickenRecBill where CFBatchContractID='"+info.getId().toString()+"' ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()) {
				//				throw new Exception("合同已经被\""+rs.getString("fname")+"\"引用，禁止反审核！");
				throw new EASBizException(new NumericExceptionSubItem("001","合同已经被\""+rs.getString("fname")+"\"引用，禁止反审核！"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001",e.getMessage()));
		}





		super._delete(ctx, pk);
	}

	//禁用
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		BatchContractBillInfo info = (BatchContractBillInfo) model;
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有保存的单据才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.cancel);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	//启用
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		BatchContractBillInfo info = (BatchContractBillInfo) model;
		if(info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.cancel))
			throw new EASBizException(new NumericExceptionSubItem("001","只有禁用的单子才可以执行此操作!"));
		//		if(StockingComm.checkIsHasSameContract(ctx, info.getFarmer().getId().toString(), info.getFarm().getId().toString(), info.getBizDate(), true)){
		//			throw new EASBizException(new NumericExceptionSubItem("001","存在已审核的同一养殖户/场且同一日期的批次合同,操作失败!"));	
		//		}
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected void _revoke(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		BatchContractBillInfo info = (BatchContractBillInfo) model;
		beforeRevoke(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.DELETED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	private void beforeRevoke(Context ctx,BatchContractBillInfo info) throws EASBizException {
		if(!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作!"));
		}
		try {
			String sql="select fid from T_FM_BreedSeedReceiveBill where FBatchContractID='"+info.getId().toString()+"'";
			IRowSet rs = DbUtil.executeQuery(ctx, sql);
			if(rs.size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","该批次已有领苗记录,请删除对应记录后重试"));
			}			
			if(UIRuleUtil.getBigDecimal(info.getUsedMargin()).compareTo(UIRuleUtil.getBigDecimal(info.getUnlockMargin()))!=0){
				throw new EASBizException(new NumericExceptionSubItem("001","该批次合同保证金占用余额不为0,操作失败"));
			}

			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" select sum(t2.FReceiveQty) qty from T_FM_FodderReception  t1 ")
			.append(" inner join T_FM_FodderReceptionEntry t2 on t1.fid=t2.fparentid ")
			.append(" where t1.CFBatchContractID='"+info.getId().toString()+"' ");
			rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			if(rs.next()){
				if(UIRuleUtil.getBigDecimal(rs.getBigDecimal("qty")).signum()!=0){
					throw new EASBizException(new NumericExceptionSubItem("001","该批次对应饲料领用合计不为0,操作失败"));
				}
			}

			sqlBuf = new StringBuffer();
			sqlBuf.append(" select sum(t2.FReceiveQty) qty from T_FM_DrugReceiveBill  t1 ")
			.append(" inner join T_FM_DrugReceiveBillEntry t2 on t1.fid=t2.fparentid ")
			.append(" where t1.FBatchContractID='"+info.getId().toString()+"' ");
			rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			if(rs.next()){
				if(UIRuleUtil.getBigDecimal(rs.getBigDecimal("qty")).signum()!=0){
					throw new EASBizException(new NumericExceptionSubItem("001","该批次对应药品领用合计不为0,操作失败"));
				}
			}

			sql="select fid from CT_FM_ChickenRecBill where CFBatchContractID='"+info.getId().toString()+"'";
			rs = DbUtil.executeQuery(ctx, sql);
			if(rs.size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","该批次已有回收订单记录,请删除对应记录后重试"));
			}	
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void _changeIsFeedBig(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		BatchContractBillInfo info = (BatchContractBillInfo) model;
		info.setIsFeedBig(!info.isIsFeedBig());
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	protected void _isTemplate(Context ctx, IObjectValue model)throws BOSException
	{

	}

	@Override
	protected void _isInit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
}