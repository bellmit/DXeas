package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBill;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBreedSeedReceiveBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.MaleOrFemaleEnum;
import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.app.CreateCreatCostObject;
//import com.kingdee.eas.farm.stocking.basedata.OutOrgEnum;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.IPurInWarehsBill;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BreedSeedReceiveBillControllerBean extends AbstractBreedSeedReceiveBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.BreedSeedReceiveBillControllerBean");
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfNum=new SimpleDateFormat("yyyyMMdd");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		BreedSeedReceiveBillInfo info = BreedSeedReceiveBillFactory.getLocalInstance(ctx).getBreedSeedReceiveBillInfo(new ObjectUuidPK(((BreedSeedReceiveBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		try {
			BatchInfo batchInfo;
			IBatch iss = BatchFactory.getLocalInstance(ctx);
			batchInfo=dealBatchInfo(ctx, info, true);
			//生成供应链单据
			//			createToSCMBill(ctx, info);
			iss.submit(batchInfo);
			iss.audit(batchInfo);
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date()); 
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super.save(ctx, info);

			updateContract(ctx, batchInfo,info);

			//生成供应链单据
			createBill(ctx, info);


		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
	}

	/**
	 * 生成供应链单据
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void createBill(Context ctx, BreedSeedReceiveBillInfo info){
		// TODO Auto-generated method stub

		List<String> botpList = new ArrayList<String>();
		botpList.add("cmly-scrk");
		botpList.add("cmly-llck");
		botpList.add("cmly-qtrk");
		for(int j = 0,size = botpList.size();j<size;j++){
			try {
				String botpName = botpList.get(j);
				System.out.println(botpName);
				CoreBillBaseCollection coreBillBaseColl = new CoreBillBaseCollection();
				IBreedSeedReceiveBill iSaleOrder;
				iSaleOrder = BreedSeedReceiveBillFactory.getLocalInstance(ctx);
				IBOTMapping iMapping    = BOTMappingFactory.getLocalInstance(ctx);
				IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);
				BreedSeedReceiveBillInfo saleOrderInfo = iSaleOrder.getBreedSeedReceiveBillInfo(new ObjectUuidPK(info.getId()));
				IRowSet rs = null;
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
							try{
								iBTPManager.saveRelations(destBillInfo, botRelationCols);
								//								iBTPManager.submitRelations(destBillInfo, botRelationCols);
							}catch(Exception e1){
								e1.printStackTrace();
								continue;
							}
						}
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
		}



	}


	private void checkIsGuanZhang(Context ctx,CKSettleBillInfo info) throws EASBizException {
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



	/**
	 * 创建新的批次
	 * @param ctx
	 * @param info
	 * @param isPlus
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private BatchInfo dealBatchInfo(Context ctx,BreedSeedReceiveBillInfo info,boolean isAudit) throws EASBizException, BOSException {

		IBatch iss = BatchFactory.getLocalInstance(ctx);
		BatchInfo batchInfo=null;
		//根据养殖场类型判断是否设置棚舍信息
		//获取该批次对应的养殖场
		FarmInfo farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
		if(!farmInfo.getFarmType().equals(StockingFarmTypeEnum.company)){
			BatchContractBillInfo batchContractInfo = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(info.getBatchContract().getId()));
			if(batchContractInfo.getBatch()!=null)
			{
				batchInfo=BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchContractInfo.getBatch().getId()));
			}
			if(batchInfo==null) {
				batchInfo=new BatchInfo();
				batchInfo.setId(BOSUuid.create(batchInfo.getBOSType()));
				batchInfo.setCompany(info.getCompany());
				batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
				batchInfo.setBreedData(info.getBreedData());
				batchInfo.setNumber("未正确生成编号");
				batchInfo.setName("未正确生成名称");
				batchInfo.setAuditTime(new java.util.Date());
				batchInfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
				batchInfo.setFarmer(info.getFarmer());
				batchInfo.setFarm(info.getFarm());
				batchInfo.setBatchContract(info.getBatchContract());
				batchInfo.setInDate(info.getBizDate());
			}else {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("farmer.*"));
				slor.add(new SelectorItemInfo("farm.*"));
				batchInfo=iss.getBatchInfo(new ObjectUuidPK(batchInfo.getId()),slor);
			}


			batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
			BigDecimal totalQty = BigDecimal.ZERO;
			IRowSet rs = DbUtil.executeQuery(ctx, "select sum(t2.FAllReceiveQty) FAllReceiveQty from T_FM_BreedSeedReceiveBill t1 inner join T_FM_BreedSeedReceiveBillEntry t2 on t1.FID=t2.FParentID and t1.FCompanyID=? and t1.FBillStatus in (4,7) and t1.FBatchID=? and t1.FID<>?",new String[]{info.getCompany().getString("id"),batchInfo.getString("id"),UIRuleUtil.getString(info.getString("id"))});
			try {
				if(rs.next()){
					totalQty=UIRuleUtil.getBigDecimal(rs.getBigDecimal("FAllReceiveQty"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isAudit)
				for(int i=0;i<info.getEntrys().size();i++){
					totalQty=totalQty.add(UIRuleUtil.getBigDecimal(info.getEntrys().get(i).getAllReceiveQty()));
				}
			batchInfo.setBatchQty(totalQty);
			batchInfo.setFemaleQty(totalQty);
			batchInfo.setTotalQty(totalQty);

			//保存批次
			info.setBatch(batchInfo);
		}else{
			//-------------------------------公司自养需要设置批次信息的棚舍信息

			BatchContractBillInfo batchContractInfo = BatchContractBillFactory.getLocalInstance(ctx).getBatchContractBillInfo(new ObjectUuidPK(info.getBatchContract().getId()));
			if(batchContractInfo.getBatch()!=null)
			{
				batchInfo=BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchContractInfo.getBatch().getId()));
			}

			if(batchInfo==null) {
				batchInfo=new BatchInfo();
				batchInfo.setId(BOSUuid.create(batchInfo.getBOSType()));
				batchInfo.setCompany(info.getCompany());
				batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
				batchInfo.setBreedData(info.getBreedData());
				batchInfo.setNumber("未正确生成编号");
				batchInfo.setName("未正确生成名称");
				batchInfo.setAuditTime(new java.util.Date());
				batchInfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
				batchInfo.setFarmer(info.getFarmer());
				batchInfo.setFarm(info.getFarm());
				batchInfo.setBatchContract(info.getBatchContract());
				batchInfo.setInDate(info.getBizDate());
			}else {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("farmer.*"));
				slor.add(new SelectorItemInfo("farm.*"));
				batchInfo=iss.getBatchInfo(new ObjectUuidPK(batchInfo.getId()),slor);
			}

			batchInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
			BigDecimal totalQty = BigDecimal.ZERO;
			IRowSet rs = DbUtil.executeQuery(ctx, "select sum(t2.FAllReceiveQty) FAllReceiveQty from T_FM_BreedSeedReceiveBill t1 inner join T_FM_BreedSeedReceiveBillEntry t2 on t1.FID=t2.FParentID and t1.FCompanyID=? and t1.FBillStatus in (4,7) and t1.FBatchID=? and t1.FID<>?",new String[]{info.getCompany().getString("id"),batchInfo.getString("id"),UIRuleUtil.getString(info.getString("id"))});
			try {
				if(rs.next()){
					totalQty=UIRuleUtil.getBigDecimal(rs.getBigDecimal("FAllReceiveQty"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isAudit)
				for(int i=0;i<info.getEntrys().size();i++){
					totalQty=totalQty.add(UIRuleUtil.getBigDecimal(info.getEntrys().get(i).getAllReceiveQty()));
				}
			batchInfo.setBatchQty(totalQty);
			batchInfo.setFemaleQty(totalQty);
			batchInfo.setTotalQty(totalQty);

			//批次信息添加棚舍分录
			IBatchHouseEntry iBatchHouseEntry = BatchHouseEntryFactory.getLocalInstance(ctx);
			BatchHouseEntryCollection batchEntryColl = batchInfo.getHouseEntry();

			BatchHouseEntryInfo batchHouseEntryInfo = null;
			BreedSeedReceiveBillEntryCollection entryColl = null;
			BreedSeedReceiveBillEntryInfo entryInfo = null;
			FarmHouseEntryInfo houseEntryInfo = null;
			BigDecimal maleQty = BigDecimal.ZERO;
			boolean isNewHouse = true;
			IBatch iBatch = BatchFactory.getLocalInstance(ctx);
			for(int i=0,size=info.getEntrys().size();i<size;i++){
				batchHouseEntryInfo = new BatchHouseEntryInfo();
				entryColl = info.getEntrys();
				entryInfo = entryColl.get(i);
				entryInfo = BreedSeedReceiveBillEntryFactory.getLocalInstance(ctx).getBreedSeedReceiveBillEntryInfo(new ObjectUuidPK(entryInfo.getId()));

				//如果棚舍已经存在就在原来的基础上面增加数量
				BatchHouseEntryCollection batchEntryColl2 = batchInfo.getHouseEntry();
				BatchHouseEntryInfo batchHouseEntryInfo1 = null;
				BigDecimal maleQty1  = BigDecimal.ZERO;
				for(int j=0,szie1 = batchEntryColl2.size();j<szie1;j++){
					batchHouseEntryInfo1 = batchEntryColl2.get(j);
					batchHouseEntryInfo1 = BatchHouseEntryFactory.getLocalInstance(ctx).getBatchHouseEntryInfo(new ObjectUuidPK(batchHouseEntryInfo1.getId()));
					if(batchHouseEntryInfo1.getHouse().getId().toString().equalsIgnoreCase(entryInfo.getHouse().getId().toString())){
						maleQty1 = batchHouseEntryInfo1.getMaleQty();
						String s1 = null;
						if(isAudit){
							s1 = "/*dialect*/ update CT_FM_BatchHouseEntry set CFMaleQty = "+maleQty1.add(entryInfo.getAllReceiveQty())+"  where fid ='"+batchHouseEntryInfo1.getId()+"'";
						}else{
							s1 = "/*dialect*/ update CT_FM_BatchHouseEntry set CFMaleQty = "+maleQty1.subtract(entryInfo.getAllReceiveQty())+"  where fid ='"+batchHouseEntryInfo1.getId()+"'";
						}
						com.kingdee.eas.util.app.DbUtil.execute(ctx, s1);
						isNewHouse = false;
					}
				}

				if(isNewHouse){
					//棚舍
					houseEntryInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(entryInfo.getHouse().getId()));

					//数量全都放到公禽数量里面
					maleQty = entryInfo.getAllReceiveQty();
					//设置棚舍
					batchHouseEntryInfo.setHouse(houseEntryInfo);
					//设置公禽数量
					batchHouseEntryInfo.setMaleQty(maleQty);
					//设置入雏日期
					batchHouseEntryInfo.setInDate(info.getBizDate());
					//					iBatchHouseEntry.save(batchHouseEntryInfo);
					batchEntryColl.add(batchHouseEntryInfo);

					batchInfo.getHouseEntry().addCollection(batchEntryColl);
					iBatch.save(batchInfo);
				}
			}


			//保存批次
			info.setBatch(batchInfo);
		}





		return batchInfo;
	}


	private void updateContract(Context ctx,BatchInfo batchInfo, BreedSeedReceiveBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		try {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("farmer.*"));
			slor.add(new SelectorItemInfo("farm.*"));
			batchInfo=BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchInfo.getId()),slor);

			IRowSet rsFromBreedBill = DbUtil.executeQuery(ctx,"select min(FBizDate) FBizDate from T_FM_BreedSeedReceiveBill where FBillStatus in (4,7) and FBatchID=? group by FBatchID",new Object[]{batchInfo.getId().toString()});
			//获取该批次对应的养殖场
			FarmInfo farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(batchInfo.getFarm().getId()));

			IRowSet rs= rsFromBreedBill;
			if(rs.next()){
				if(UIRuleUtil.isNotNull(rs.getDate("FBizDate"))){
					String farmerName =batchInfo.getFarmer().getName();
					//					String farmCode=batchInfo.getFarm().getMnemonicCode();
					String farmCode=batchInfo.getFarm().getName();
					String dateCode=sdfNum.format(rs.getDate("FBizDate"));

					DbUtil.execute(ctx, "update T_FM_BatchContractBill set FBatchID=? where FID=?",new Object[]{batchInfo.getId().toString(),batchInfo.getBatchContract().getId().toString()});
					DbUtil.execute(ctx, "update T_FM_BatchContractBill set FActualBreedDate={d '"+sdf.format(rs.getDate("FBizDate"))+"'},FActualFemaleQty=? where FBatchID=?",new Object[]{batchInfo.getFemaleQty(),batchInfo.getId().toString()});
					String newNum = farmCode+"-"+dateCode;
					if(farmInfo.getFarmType().equals(StockingFarmTypeEnum.company)){
						//获取分录棚舍的棚舍号
						BreedSeedReceiveBillEntryInfo entryInfo = BreedSeedReceiveBillEntryFactory.getLocalInstance(ctx).getBreedSeedReceiveBillEntryInfo(new ObjectUuidPK(info.getEntrys().get(0).getId()));		
						FarmHouseEntryInfo houseInfo = entryInfo.getHouse();
						if(houseInfo != null){
							houseInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(houseInfo.getId()));
							newNum = farmCode+"-"+dateCode+"-"+houseInfo.getNumber();
						}
					}
					DbUtil.execute(ctx, "update T_FM_Batch set FInDate={d '"+sdf.format(rs.getDate("FBizDate"))+"'},fnumber='"+newNum+"',fname_l2='"+newNum+"' where fid=?",new Object[]{batchInfo.getId().toString()});

					//雏苗领用
					DbUtil.execute(ctx, "update T_FM_BreedSeedReceiveBill set CFActualBizdate={d '"+sdf.format(rs.getDate("FBizDate"))+"'}" +
							" where FBatchID=?",new Object[]{batchInfo.getId().toString()});
					//料
					DbUtil.execute(ctx,"update T_FM_FodderReception set CFIndate = {d '"+sdf.format(rs.getDate("FBizDate"))+"'}, CFBatchQty = "+batchInfo.getFemaleQty()+" , CFBatchID='"+batchInfo.getId().toString()+"' where CFBatchContractID=?",new Object[]{batchInfo.getBatchContract().getId().toString()});			
					//药
					DbUtil.execute(ctx,"update T_FM_DrugReceiveBill set FInDate={d '"+sdf.format(rs.getDate("FBizDate"))+"'}, FInQty = "+batchInfo.getFemaleQty()+" ,FBatchID='"+batchInfo.getId().toString()+"' where FBatchContractID=?",new Object[]{batchInfo.getBatchContract().getId().toString()});
				}
			}	
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 是否存在其他的种苗领用单
	 * @param ctx
	 * @param batchID
	 * @param billID
	 * @return
	 * @throws BOSException 
	 */
	private boolean isExistOtherBill(Context ctx,String batchContratctID,String billID) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select 1 from T_FM_BreedSeedReceiveBill where fbillStatus in (4,7) and FBatchContractID='").append(batchContratctID).append("' and fid!='").append(billID).append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		if(rs.size()>0) {
			return true;
		}
		return false;
	}

	/**
	 * 生成供应链单据
	 * @param ctx
	 * @param info
	 */
	private void createToSCMBill(Context ctx,BreedSeedReceiveBillInfo info) throws BOSException {
		try {

			SystemSettingInfo sysInfo = StockingComm.getSystemSettingInfo(ctx,info.getCompany().getString("id"));
			if(!sysInfo.isIsAutoSCM()) {
				return;
			}

			String destBillType=null;
			BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCompany();
			//如果存在别的养殖公司，先有养殖公司调入，然后再领出
			for(int index=0;index<sysInfo.getStorageEntry().size();index++) {
				if(sysInfo.getStorageEntry().get(index).getOutOrgType().equals(OutOrgEnum.breedOrg)) {
					destBillType=BotpCommUtils.TransBill_BOSTYPE;
					BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
					for(index=0;index<btpCols.size();index++) {
						btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
					}
					break;
				}
			}
			//内部管理 生成领料出
			if(sysInfo.isIsInner()) {
				//然后生成生领料出
				destBillType=BotpCommUtils.MaterialReq_BOSTYPE;
			}else{//外部管理 生成销售出
				destBillType=BotpCommUtils.SaleIssueBill_BOSTYPE;
			}

			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			for(int index=0;index<btpCols.size();index++) {
				btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
			}
		}catch(Exception err) {
			throw new BOSException(err);
		}
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		BreedSeedReceiveBillInfo info = BreedSeedReceiveBillFactory.getLocalInstance(ctx).getBreedSeedReceiveBillInfo(new ObjectUuidPK(((BreedSeedReceiveBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);					
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);



		FarmInfo farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));

		//如果不是公司自养
		//		if(!farmInfo.getFarmType().equals(StockingFarmTypeEnum.company)){
		if(isExistOtherBill(ctx, info.getBatchContract().getId().toString(), info.getId().toString())){
			IBatch iss = BatchFactory.getLocalInstance(ctx);
			BatchInfo batchInfo=dealBatchInfo(ctx, info, false);
			iss.submit(batchInfo);
			iss.audit(batchInfo);
			updateContract(ctx, batchInfo,info);
		}else{
			DbUtil.execute(ctx, "delete from T_FM_Batch where fid='"+info.getBatch().getId().toString()+"'");
			DbUtil.execute(ctx, "update T_FM_BatchContractBill set FActualBreedDate=null,FActualFemaleQty=null,FBatchID=null where fid='"+info.getBatchContract().getId().toString()+"'");
			DbUtil.execute(ctx, "update T_FM_BreedSeedReceiveBill  set CFActualBizdate=null,FBatchID=null where fid='"+info.getId().toString()+"'");
		}
		//		}else{//如果是公司自养
		//			DbUtil.execute(ctx, "delete from T_FM_Batch where fid='"+info.getBatch().getId().toString()+"'");
		//			DbUtil.execute(ctx, "update T_FM_BreedSeedReceiveBill  set CFActualBizdate=null,FBatchID=null where fid='"+info.getId().toString()+"'");
		//		}
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedReceiveBillInfo info = (BreedSeedReceiveBillInfo) model;
		//    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
		if(info.getBillStatus()!=null&&!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		BreedSeedReceiveBillInfo info = (BreedSeedReceiveBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)||info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedReceiveBillInfo info = BreedSeedReceiveBillFactory.getLocalInstance(ctx).getBreedSeedReceiveBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核或关闭，禁止删除！"));
		}

		super._delete(ctx, pk);
	}

	@Override
	protected void _close(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		BreedSeedReceiveBillInfo info = BreedSeedReceiveBillFactory.getLocalInstance(ctx).getBreedSeedReceiveBillInfo(new ObjectUuidPK(((BreedSeedReceiveBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.CLOSED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unClose(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		BreedSeedReceiveBillInfo info = BreedSeedReceiveBillFactory.getLocalInstance(ctx).getBreedSeedReceiveBillInfo(new ObjectUuidPK(((BreedSeedReceiveBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有关闭的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	private void checkIsSettled(Context ctx,BreedSeedReceiveBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		//		Boolean isHasSettled = StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString());
		//		if(isHasSettled){
		//			throw new EASBizException(new NumericExceptionSubItem("001","该批次已完全回收结算,操作失败!"));
		//		}
	}

	private void checkIsGuanZhang(Context ctx,BreedSeedReceiveBillInfo info) throws EASBizException {
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
