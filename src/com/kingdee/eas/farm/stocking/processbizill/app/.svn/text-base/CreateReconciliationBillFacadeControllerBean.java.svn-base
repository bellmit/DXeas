package com.kingdee.eas.farm.stocking.processbizill.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.ICtrlUnit;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.IStatementOfAccount;
import com.kingdee.eas.farm.stocking.processbizill.IStatementsBillEntry;
import com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountCollection;
import com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedsnewInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CreateReconciliationBillFacadeControllerBean extends AbstractCreateReconciliationBillFacadeControllerBean
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.CreateReconciliationBillFacadeControllerBean");


	/**
	 * 生成对账单
	 */
	@Override
	protected HashMap _CreateReconciliationBill(Context ctx, Map param)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) param.get("company");
		PeriodInfo period = (PeriodInfo) param.get("period");
		FarmersInfo farmers = (FarmersInfo) param.get("farmers");
		String filterStr;

		ArrayList<String> list=new ArrayList<String>();
		filterStr="where FIUnit='"+company.getString("id")+"' and Periods='"+period.getString("id")+"'";
		CoreBaseCollection coll=StatementOfAccountFactory.getLocalInstance(ctx).getCollection(filterStr);
		for(int i=0;i<coll.size();i++){
			list.add(((StatementOfAccountInfo)coll.get(i)).getFarmer().getString("id"));
		}
		//获得集合
		filterStr = "where company='"+company.getString("id")+"' and Period='"+period.getString("id")+"' and BillStatus in (4)";
		if(farmers!=null)
			filterStr+=" and Farmer='"+farmers.getString("id")+"'";
		coll = StatementsBillFactory.getLocalInstance(ctx).getCollection(filterStr);


		HashMap<String, StatementOfAccountInfo> hasCreated=new HashMap<String, StatementOfAccountInfo>();
		HashMap<String, HashMap<String,BigDecimal[]>> materialQty=new HashMap<String, HashMap<String,BigDecimal[]>>();
		StatementOfAccountInfo accountInfo;
		StatementsBillInfo statementsBillInfo;
		StatementsBillEntryInfo statementsBillEntryInfo;
		ICtrlUnit iCtrlUnit = CtrlUnitFactory.getLocalInstance(ctx);
		StatementOfAccountCollection collLast;
		IStatementsBillEntry iStatementsBillEntry = StatementsBillEntryFactory.getLocalInstance(ctx);
		StringBuffer sb = new StringBuffer();
		HashMap<String, BigDecimal[]> entryQtyMap;
		HashMap<String,Integer[]> isDesposit=new HashMap<String, Integer[]>();
		IMaterial iMaterial = MaterialFactory.getLocalInstance(ctx);
		IStatementOfAccount iStatementOfAccount = StatementOfAccountFactory.getLocalInstance(ctx);
		IStockingBatch iStockingBatch = StockingBatchFactory.getLocalInstance(ctx);
		Integer success=0;
		IObjectPK  pk;

		//逐步获取数据
		for(int i=0;i<coll.size();i++){
			//			System.out.println(i);
			statementsBillInfo = (StatementsBillInfo) coll.get(i);
			//重复性校验
			if(list.contains(statementsBillInfo.getFarmer().getString("id")))
				continue;
			if(hasCreated.containsKey(statementsBillInfo.getFarmer().getString("id"))){
				accountInfo=hasCreated.get(statementsBillInfo.getFarmer().getString("id"));
			}else{
				accountInfo=new StatementOfAccountInfo();



				accountInfo.setFarmer(statementsBillInfo.getFarmer());
				accountInfo.setFIUnit(company);
				accountInfo.setPeriods(period);
				//生活费
				accountInfo.setCostOfLivingac(getFemaleDuckLifeFee(ctx, period, company, statementsBillInfo.getFarmer()));

				for(int j=0;j<statementsBillInfo.getEntrys().size();j++){
					statementsBillEntryInfo = statementsBillInfo.getEntrys().get(j);
					statementsBillEntryInfo.getSettlementItem();
					SelectorItemCollection slr = new SelectorItemCollection();
					slr.add(new SelectorItemInfo("*"));
					slr.add(new SelectorItemInfo("settlementItem.*"));
					statementsBillEntryInfo=iStatementsBillEntry.getStatementsBillEntryInfo(new ObjectUuidPK(statementsBillEntryInfo.getString("id")), slr);
					if(statementsBillEntryInfo.getString("itemname").equals("料"))
						if(materialQty.containsKey(statementsBillInfo.getFarmer().getString("id"))){
							entryQtyMap = materialQty.get(statementsBillInfo.getFarmer().getString("id"));
							if(entryQtyMap.containsKey(statementsBillEntryInfo.getMaterial().getString("id"))){
								entryQtyMap.put(statementsBillEntryInfo.getMaterial().getString("id"),new BigDecimal[]{entryQtyMap.get(statementsBillEntryInfo.getMaterial().getString("id"))[0].add(UIRuleUtil.getBigDecimal(statementsBillEntryInfo.getQty())),entryQtyMap.get(statementsBillEntryInfo.getMaterial().getString("id"))[1].add(UIRuleUtil.getBigDecimal(statementsBillEntryInfo.getAmount()))});
							}else{
								entryQtyMap.put(statementsBillEntryInfo.getMaterial().getString("id"),new BigDecimal[]{UIRuleUtil.getBigDecimal(statementsBillEntryInfo.getQty()),UIRuleUtil.getBigDecimal(statementsBillEntryInfo.getAmount())});
							}
						}else{
							entryQtyMap=new HashMap<String, BigDecimal[]>();
							entryQtyMap.put(statementsBillEntryInfo.getMaterial().getString("id"), new BigDecimal[]{UIRuleUtil.getBigDecimal(UIRuleUtil.getBigDecimal(statementsBillEntryInfo.getQty())),UIRuleUtil.getBigDecimal(UIRuleUtil.getBigDecimal(statementsBillEntryInfo.getAmount()))});
							materialQty.put(statementsBillInfo.getFarmer().getString("id"), entryQtyMap);
						}
				}



				//占款利息//贷款利息
				accountInfo.setFundInterestac(BigDecimal.ZERO);
				accountInfo.setLoanInterestac(BigDecimal.ZERO);
				IRowSet rs = DbUtil.executeQuery(ctx, "select t1.* from T_FM_StateOfAcaountImportEntry t1 inner join T_FM_StateOfAcaountImport t2 on t2.FID=t1.FParentID and t2.FBillStatus=4 and t2.FCompanyID='"+company.getString("id")+"' and t2.FPeriodID='"+period.getString("id")+"' and t1.FFarmerID='"+statementsBillInfo.getFarmer().getString("id")+"'");
				try {
					if(rs.next()){
						accountInfo.setFundInterestac(rs.getBigDecimal("FInterestPaid"));
						accountInfo.setLoanInterestac(rs.getBigDecimal("FLoanInterest"));
						accountInfo.setDepositac(rs.getBigDecimal("FDeposit"));
						accountInfo.setDepositInterestac(rs.getBigDecimal("FDepositInterest"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//控制单元
				accountInfo.setCU(iCtrlUnit.getCtrlUnitInfo(new ObjectUuidPK(company.getId().toString())));
				//业务日期
				accountInfo.setBizDate(period.getEndDate());

				//淘汰鸭款
				accountInfo.setEliminateac(getCCDuckAmt(ctx,period,company,accountInfo.getFarmer()));
				//付蛋款
				accountInfo.setEggPayAmt(BigDecimal.ZERO);
				sb.setLength(0);
				sb.append("/*dialect*/select t7.FName_l2 farmer,round(sum(t1.FDebitFor),2) eggPayAmt from ").append("\n")
				.append("T_GL_AssistBalance          t1").append("\n")
				.append("inner join T_BD_Period      t2 on t2.FID=t1.FPeriodID").append("\n")
				.append("inner join T_ORG_Company    t3 on t3.FID=t1.FOrgUnitID").append("\n")
				.append("inner join T_BD_Currency    t4 on t4.FID=t1.FCurrencyID").append("\n")
				.append("inner join T_BD_AccountView t5 on t5.FID=t1.FAccountID").append("\n")
				.append("inner join T_BD_AssistantHG t6 on t6.FID=t1.FAssistGrpID").append("\n")
				.append("inner join T_ORG_CostCenter t7 on t7.FID=t6.FAdminOrgID").append("\n")
				.append("inner join T_FM_Farmers     t8 on t8.FCostCenterID=t7.FID").append("\n")
				.append("where t4.FNumber='BB01'").append("\n")
				.append("      and t2.FID='").append(period.getString("id")).append("'").append("\n")
				.append("      and t3.FID='").append(company.getString("id")).append("'").append("\n")
				.append("      and t5.Fnumber='2241.10.09'").append("\n")
				.append("      and t1.FBalType in (3,5)").append("\n")
				.append("      and t1.FDebitFor >0").append("\n")
				.append("      and t8.FID='").append(statementsBillInfo.getFarmer().getString("id")).append("'\n")
				.append("group by t7.FName_l2").append("\n");
				rs = DbUtil.executeQuery(ctx, sb.toString());
				try {
					if(rs.next())
						accountInfo.setEggPayAmt(rs.getBigDecimal("eggPayAmt"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("报错信息在这里:"+e.getStackTrace()[0].getLineNumber()+e.getCause().getMessage());
				}
				hasCreated.put(statementsBillInfo.getFarmer().getString("id"), accountInfo);

				//				StockingBatchInfo stockingbatchInfo;
				//				if(statementsBillInfo.getStockingBatch()!=null){
				//					SelectorItemCollection slor=new SelectorItemCollection();
				//					slor.add("*");
				//					slor.add("BatchContract.*");
				//					stockingbatchInfo=iStockingBatch.getStockingBatchInfo(new ObjectUuidPK(statementsBillInfo.getStockingBatch().getString("id")),slor);
				//					if(stockingbatchInfo.getAllOutDate()!=null&&!stockingbatchInfo.getAllOutDate().before(period.getBeginDate())&&!stockingbatchInfo.getAllOutDate().after(period.getEndDate())){
				//						isDesposit.put(statementsBillInfo.getFarmer().getString("id"), new Integer[]{DateUtilsComm.getDiffBetweenTwoDays(stockingbatchInfo.getInDate(), stockingbatchInfo.getAllOutDate()),UIRuleUtil.getInt(stockingbatchInfo.getBatchContract().getBreedQty())+UIRuleUtil.getInt(stockingbatchInfo.getBatchContract().getFemaleBreedQty())});
				//					}else{
				//						//押金
				//						accountInfo.setDepositac(BigDecimal.ZERO);
				//					}
				//				}
				//				else{
				//
				//				}
			}
			//药品
			accountInfo.setDrugac((UIRuleUtil.getBigDecimal(accountInfo.getDrugac()).add(UIRuleUtil.getBigDecimal(statementsBillInfo.getDrugAmount()))).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));
			//辅料
			accountInfo.setAccessoryac((UIRuleUtil.getBigDecimal(accountInfo.getAccessoryac()).add(UIRuleUtil.getBigDecimal(statementsBillInfo.getOtherMaterialAmount()))).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));
			//其他
			accountInfo.setOthersac((UIRuleUtil.getBigDecimal(accountInfo.getOthersac()).add(UIRuleUtil.getBigDecimal(statementsBillInfo.getOtherAmount()))).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));

			//饲料
			accountInfo.setFeedsall((UIRuleUtil.getBigDecimal(accountInfo.getFeedsall()).add(UIRuleUtil.getBigDecimal(statementsBillInfo.getFodderAmount()))).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));


			//种蛋款
			accountInfo.setHatchEggac((UIRuleUtil.getBigDecimal(accountInfo.getHatchEggac()).add(UIRuleUtil.getBigDecimal(statementsBillInfo.getAllEggAmount()))).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));
			//奖惩
			accountInfo.setFertilizationac((UIRuleUtil.getBigDecimal(accountInfo.getFertilizationac()).add(UIRuleUtil.getBigDecimal(statementsBillInfo.getAwardsAmount()))).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));
		}






		//保存
		String orgUnitID = ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		BigDecimal lastPeriodBalance;

		Iterator<Entry<String, StatementOfAccountInfo>> entries = hasCreated.entrySet().iterator();  
		while (entries.hasNext()) {  

			Entry<String, StatementOfAccountInfo> entry = entries.next();  
			accountInfo=entry.getValue();
			if(iCodingRuleManager.isExist(accountInfo, orgUnitID)){
				if(iCodingRuleManager.isUseIntermitNumber(accountInfo, orgUnitID)){
					//编码规则不允许断号 --> 获取断号编码
					accountInfo.setNumber(iCodingRuleManager.getNonbreakNumber(accountInfo,orgUnitID));
				}else{
					accountInfo.setNumber(iCodingRuleManager.getNumber(accountInfo,orgUnitID));
				}
			}

			//饲料分录
			if(materialQty.containsKey(accountInfo.getFarmer().getString("id"))){
				Iterator<Entry<String, BigDecimal[]>> qtyEntry = materialQty.get(accountInfo.getFarmer().getString("id")).entrySet().iterator();  
				while(qtyEntry.hasNext()){
					Entry<String, BigDecimal[]> entry2 = qtyEntry.next();
					MaterialInfo materialInfo = iMaterial.getMaterialInfo(new ObjectUuidPK(entry2.getKey()));
					StatementOfAccountFeedsnewInfo entryInfo=new StatementOfAccountFeedsnewInfo();
					entryInfo.setFeedsone(materialInfo);
					entryInfo.setFeedName(materialInfo.getString("name"));
					entryInfo.setFeedQty(entry2.getValue()[0]);
					entryInfo.setFeedAC(entry2.getValue()[1]);
					accountInfo.getFeedsnew().add(entryInfo);
					entryInfo.setFeedWeight(StockingComm.getUnitQty(ctx, company.getId().toString(), materialInfo.getString("ID")));
					entryInfo.setPackageNumber(entry2.getValue()[0].divide(StockingComm.getUnitQty(ctx, company.getId().toString(), materialInfo.getString("ID")),0,BigDecimal.ROUND_HALF_EVEN));
				}
			}
			//			if(isDesposit.containsKey(accountInfo.getFarmer().getString("id"))){
			//				accountInfo.setDepositInterestac(UIRuleUtil.getBigDecimal(isDesposit.get(accountInfo.getFarmer().getString("id"))[1]).multiply(UIRuleUtil.getBigDecimal(isDesposit.get(accountInfo.getFarmer().getString("id"))[0])).multiply(new BigDecimal("0.0055")));
			//			}

			//总应收
			accountInfo.setTotalARAmount(UIRuleUtil.getBigDecimal(accountInfo.getDrugac())
					.add(UIRuleUtil.getBigDecimal(accountInfo.getCostOfLivingac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getFundInterestac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getAccessoryac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getOthersac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getLoanInterestac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getFeedsall()))
					.add(accountInfo.getEggPayAmt()));
			//
			//				//总应付
			accountInfo.setTotalAPAmount(UIRuleUtil.getBigDecimal(accountInfo.getHatchEggac())
					.add(UIRuleUtil.getBigDecimal(accountInfo.getEliminateac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getFertilizationac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getDepositac()))
					.add(UIRuleUtil.getBigDecimal(accountInfo.getDepositInterestac())));


			pk = null;
			lastPeriodBalance=BigDecimal.ZERO;
			collLast = iStatementOfAccount.getStatementOfAccountCollection("where periods='"+DateUtilsComm.getUpperPeriodInfo(ctx, period).getString("id")+"' and FIUnit='"+company.getString("id")+"' and farmer='"+accountInfo.getFarmer().getString("id")+"'"); 
			if(collLast.size()>0){
				lastPeriodBalance = UIRuleUtil.getBigDecimal(collLast.get(0).getClosingBalance());
			}
			accountInfo.setBeginningBalance(lastPeriodBalance.divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));
			accountInfo.setClosingBalance((UIRuleUtil.getBigDecimal(lastPeriodBalance).add(UIRuleUtil.getBigDecimal(accountInfo.getTotalARAmount())).subtract(UIRuleUtil.getBigDecimal(accountInfo.getTotalAPAmount()))).divide(BigDecimal.ONE,2,BigDecimal.ROUND_HALF_EVEN));

			pk=iStatementOfAccount.save(accountInfo);
			if(pk!=null)
				success++;
			iStatementOfAccount.submit(accountInfo);
			resultMap.put("successQty", success);
			//			break;
		}  

		return resultMap;
	}

	/**
	 * 获取淘汰鸭款
	 * @param ctx 
	 * @param period
	 * @param company
	 * @param farmer
	 * @return
	 */
	private BigDecimal getCCDuckAmt(Context ctx, PeriodInfo period,
			CompanyOrgUnitInfo company, FarmersInfo farmer) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select sum(t4.FAmount) amt from").append("\n") 
		.append("T_AR_OtherBill               t1").append("\n") 
		.append("inner join T_BD_Period       t2  on t2.FNumber='").append(period.getString("number")).append("'").append("\n") 
		.append("inner join T_FM_Farmers      t3  on t3.FID='").append(farmer.getString("id")).append("'").append("\n") 
		.append("      and t3.FCostCenterID=t1.FAdminOrgUnitID").append("\n")
		.append("inner join T_AR_OtherBillentry t4 on t1.FID=t4.FParentID").append("\n")
		.append("inner join T_BD_Material       t5 on t5.FID=t4.FMaterialID").append("\n")
		.append("inner join T_BD_MaterialGroup  t6 on t6.FID=t5.FMaterialGroupID ").append("\n")
		.append("where t1.FBillStatus=3").append("\n") 
		.append("and  t1.FCompanyID='").append(company.getString("id")).append("'\n")
		.append("and t1.FBizDate>=t2.FBeginDate and t1.FBizDate<t2.FEndDate+1")
		.append("and t6.FLongNumber like '03!0304%'").append("\n");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				return UIRuleUtil.getBigDecimal(rs.getBigDecimal("amt"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("报错信息在这里:"+e.getStackTrace()[0].getLineNumber()+e.getCause().getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("报错信息在这里:"+e.getStackTrace()[0].getLineNumber()+e.getCause().getMessage());
		}
		return BigDecimal.ZERO;
	}


	/**
	 * 获取母鸭生活费
	 * @param ctx
	 * @param period
	 * @param company
	 * @param farmersInfo
	 * @return
	 */
	private BigDecimal getFemaleDuckLifeFee(Context ctx, PeriodInfo period,
			CompanyOrgUnitInfo company, FarmersInfo farmersInfo) {
		// TODO Auto-generated method stub
		//		String str="select sum(t1.FSettleAmt) FLifeFeeAll from T_FM_TheLFOFDE t1 inner join T_FM_TheLifeFeeOfFemaleDuck t2 on t2.FID=t1.FParentID where t2.FPeriodID='"+period.getString("id")+"' and t2.FCompanyID='"+company.getString("id")+"' and t2.FBillStatus=3 and t1.FFarmerID='"+farmersInfo.getString("id")+"'";
		String str="/*dialect*/select sum(t3.FAmount) FAmount 	from T_CAS_PaymentBill t1 inner join T_FM_Farmers t2 on t2.FCostCenterID=t1.FCostCenterID inner join T_CAS_PaymentBillEntry t3 on t1.FID=t3.FPaymentBillID where to_char(t1.FBizDate,'yyyyMM')='"+period.getString("number")+"' and t1.FCompanyID='"+company.getString("id")+"' and t1.FBillStatus in (12,15) and t2.FID='"+farmersInfo.getString("id")+"'";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, str);
			if(rs.next())
				return rs.getBigDecimal("FAmount")==null?BigDecimal.ZERO:rs.getBigDecimal("FAmount");
			else
				return BigDecimal.ZERO;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("报错信息在这里:"+e.getStackTrace()[0].getLineNumber()+e.getCause().getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch blockhatchEggac
			e.printStackTrace();
			System.out.println("报错信息在这里:"+e.getStackTrace()[0].getLineNumber()+e.getCause().getMessage());
		}
		return BigDecimal.ZERO;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected String _CarryoverSettleBill(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(param);
		ArrayList<String>	resultList=new ArrayList<String>();	

		IStatementOfAccount iStatementOfAccount = StatementOfAccountFactory.getLocalInstance(ctx);
		String orgUnitID = ContextUtil.getCurrentOrgUnit(ctx).getId().toString();
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
		StatementOfAccountInfo info;
		StatementOfAccountInfo newInfo=null;
		try {
			if(json.containsKey("list")&&json.get("list")!=null
					&&json.containsKey("period")&&json.get("period")!=null){
				JSONArray list = (JSONArray) json.get("list");
				String periodID = (String) json.get("period");
				PeriodInfo periodInfo = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
				for(int i=0;i<list.size();i++){
					info = iStatementOfAccount.getStatementOfAccountInfo(new ObjectUuidPK(list.get(i).toString()));
					newInfo = (StatementOfAccountInfo)info.clone();
					newInfo.setPeriods(periodInfo);
					newInfo.setBizDate(periodInfo.getEndDate());
					newInfo.setId(BOSUuid.create(info.getBOSType()));

					for(int j=0;j<newInfo.getFeedsnew().size();j++){
						newInfo.getFeedsnew().get(j).setId(BOSUuid.create(newInfo.getFeedsnew().get(j).getBOSType()));
					}
					
					if(iCodingRuleManager.isExist(newInfo, orgUnitID)){
						if(iCodingRuleManager.isUseIntermitNumber(newInfo, orgUnitID)){
							//编码规则不允许断号 --> 获取断号编码
							newInfo.setNumber(iCodingRuleManager.getNonbreakNumber(newInfo,orgUnitID));
						}else{
							newInfo.setNumber(iCodingRuleManager.getNumber(newInfo,orgUnitID));
						}
					}
					IObjectPK pk = iStatementOfAccount.save(newInfo);
					iStatementOfAccount.submit(newInfo);
					if(pk!=null){
						resultList.add(newInfo.getNumber());
					}
					break;
				}
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("结转对账单编码"+resultList.toString());
		return resultList.toString();
	}


}