package com.kingdee.eas.custom.settlebill.app;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.custom.settlebill.ISettleBill;
import com.kingdee.eas.custom.settlebill.RewardAndPunishProjectInfo;
import com.kingdee.eas.custom.settlebill.SettleBillAssEntryCollection;
import com.kingdee.eas.custom.settlebill.SettleBillAssEntryInfo;
import com.kingdee.eas.custom.settlebill.SettleBillCollection;
import com.kingdee.eas.custom.settlebill.SettleBillEntryCollection;
import com.kingdee.eas.custom.settlebill.SettleBillEntryInfo;
import com.kingdee.eas.custom.settlebill.SettleBillFactory;
import com.kingdee.eas.custom.settlebill.SettleBillInfo;
import com.kingdee.eas.custom.settlebill.SettleBillOtherEntryCollection;
import com.kingdee.eas.custom.settlebill.SettleBillOtherEntryInfo;
import com.kingdee.eas.custom.settlebill.SettleBillRewardPunishCollection;
import com.kingdee.eas.custom.settlebill.SettleBillRewardPunishInfo;
import com.kingdee.eas.custom.settlebill.SettleBillSubsidyCollection;
import com.kingdee.eas.custom.settlebill.SettleBillSubsidyInfo;
import com.kingdee.eas.custom.settlebill.billStatus;
import com.kingdee.eas.fi.ar.app.webservice.util.BillProertiesConvertor;
import com.kingdee.eas.fi.ar.app.webservice.util.BillPropertiesReader;
import com.kingdee.eas.fi.ar.app.webservice.util.WrongArgumentException;
import com.kingdee.eas.ma.bg.BgDaHelper;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.io.IOException;
import java.lang.String;
import java.math.BigDecimal;

public class SettleBillFacdeControllerBean extends AbstractSettleBillFacdeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.settlebill.app.SettleBillFacdeControllerBean");
	private FilterItemInfo cuFilter=null;
	protected String[] _importData(Context ctx, String xmlData)throws BOSException
	{

		BillPropertiesReader helper = null;
		try {
			helper = new BillPropertiesReader(xmlData, "SettleBill");
		} catch (WrongArgumentException e) {
			logger.debug("wrong bill type");
			return new String[] { "N", e.getTypeNumber(), "other", "wrong bill type" };
		}
		catch (SAXException e) {
			logger.debug(e.getMessage());
			return new String[] { "N", "1007", "other", e.getMessage() };
		}
		catch (IOException e)
		{
			logger.debug(e.getMessage());
			return new String[] { "N", "1006", "other", e.getMessage() };
		}

		Map head = helper.getHeadProperties("billHead");
		List entries = helper.getEntriesProperties("//billEntries/entry");
		List slaughterRecords = helper.getEntriesProperties("//slaughterRecords/SlaughterRecord");
		List otherEntrys = helper.getEntriesProperties("//otherEntrys/OtherEntry");
		List rewardPunishEntrys = helper.getEntriesProperties("//rewardPunishEntrys/RewardPunishEntry");
		List subsidyEntrys = helper.getEntriesProperties("//subsidyEntrys/SubsidyEntry");

		SettleBillInfo info = new SettleBillInfo();
		try {
			if (head == null) {
				return new String[] { "N", "1011", "other", "No head!" };
			}
			String result = setHead(info, head, ctx);
			if(result!=null)
				return new String[] { result};
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":head field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "head", e.getField() };
		}

		/*-------------------------------------分录一-----------------------------------**/
		try
		{
			if (entries.size() == 0) {
				return new String[] { "N", "1009", "other", "no entries" };
			}
			setEntries(info, entries, ctx);
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":entry field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "entry", e.getField() };
		}
		/*-------------------------------------分录2-----------------------------------**/
		try
		{
			setSlaughterRecordEntry(info, slaughterRecords, ctx);
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":plan field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "plan", e.getField() };
		}
		/*-------------------------------------分录3-----------------------------------**/
		try
		{
			setOtherEntry(info, otherEntrys, ctx);
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":plan field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "plan", e.getField() };
		}
		/*-------------------------------------分录4-----------------------------------**/
		try
		{
			setRewardAndPunishEntry(info, rewardPunishEntrys, ctx);
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":plan field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "plan", e.getField() };
		}
		/*-------------------------------------分录5-----------------------------------**/
		try
		{
			setSubsidyEntry(info, subsidyEntrys, ctx);
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":plan field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "plan", e.getField() };
		}
		/*-------------------------------------分录加载结束-----------------------------------**/

		//		IExtendsOtherBillFacade extdOtherBill = ExtendsOtherBillFacadeFactory.getLocalInstance(ctx);
		//
		//		extdOtherBill.submit(info, xmlData);

		ISettleBill iOtherBill = SettleBillFactory.getLocalInstance(ctx);
		try {
			iOtherBill.save(info);
		} catch (Exception e) {
			logger.error("AROtherBill save : " + e.getMessage());
			return new String[] { "N", "1006", "other", "error occur when saving bill" };
		}

		return new String[] { "Y" };
	}

	private String setHead(SettleBillInfo info, Map head, Context ctx)
	throws BOSException, WrongArgumentException
	{
		verifyFieldNotNull("CU", head.get("CU"));
		CtrlUnitInfo cu = (CtrlUnitInfo)BillProertiesConvertor.getValueObject(head.get("CU"), CtrlUnitInfo.class, null, ctx);

		info.setCU(cu);
		verifyFieldNotNull("CU", cu);
		if ("yes".equals(head.get("CUNeed"))) {
			this.cuFilter = new FilterItemInfo("CU.id", cu.getId(), CompareType.EQUALS);
		}

		info.setBillStatus(billStatus.SAVE);

		verifyFieldNotNull("creator", head.get("creator"));
		UserInfo userInfo = (UserInfo)BillProertiesConvertor.getValueObject(head.get("creator"), UserInfo.class, this.cuFilter, ctx);

		verifyFieldNotNull("creator", userInfo);
		info.setCreator(userInfo);

		verifyFieldFormat("createTime", head.get("createTime"), "date");
		Timestamp createTime = BillProertiesConvertor.getTimestamp((String)head.get("createTime"));

		info.setCreateTime(createTime);

		UserInfo lastUpdater = (UserInfo)BillProertiesConvertor.getValueObject(head.get("lastUpdateUser"), UserInfo.class, this.cuFilter, ctx);

		info.setLastUpdateUser(lastUpdater);

		if (!(isNull(head.get("lastUpdateTime")))) {
			verifyFieldFormat("lastUpdateTime", head.get("lastUpdateTime"), "date");
		}
		Timestamp lastUpdateTime = BillProertiesConvertor.getTimestamp((String)head.get("lastUpdateTime"));

		info.setLastUpdateTime(lastUpdateTime);

		verifyFieldNotNull("number", head.get("number"));
		info.setNumber((String)head.get("number"));
		SettleBillCollection coll = SettleBillFactory.getLocalInstance(ctx).getSettleBillCollection("where number='"+info.getNumber()+"'");
		if(coll.size()>0)
			return "存在重复的编码";

		verifyFieldFormat("bizDate", head.get("bizDate"), "date");
		Timestamp bizDate = BillProertiesConvertor.getTimestamp((String)head.get("bizDate"));

		info.setBizDate(bizDate);

		UserInfo handler = (UserInfo)BillProertiesConvertor.getValueObject(head.get("handler"), UserInfo.class, this.cuFilter, ctx);

		info.setHandler(handler);

		String description = (String)head.get("descption");
		if(description!=null&&description.indexOf("可空")<0)
			info.setDescription(description);


		CompanyOrgUnitInfo accountUnit = (CompanyOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("accountUnit"), CompanyOrgUnitInfo.class, this.cuFilter, ctx);
		info.setAccountUnit(accountUnit);


		CompanyOrgUnitInfo department = (CompanyOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("department"), CompanyOrgUnitInfo.class, this.cuFilter, ctx);
		info.setDepartment(department);

		String farm = (String)head.get("farm");
		if(farm!=null&&farm.indexOf("可空")<0)
			info.setFarm(farm);

		AdminOrgUnitInfo farmer = (AdminOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("farmer"), AdminOrgUnitInfo.class, this.cuFilter, ctx);
		info.setFarmer(farmer);

		String flot = (String)head.get("flot");
		if(flot!=null&&flot.indexOf("可空")<0)
			info.setFlot(flot);

		String policy = (String)head.get("policy");
		if(policy!=null&&policy.indexOf("可空")<0)
			info.setPolicy(policy);

		PersonInfo operator = (PersonInfo)BillProertiesConvertor.getValueObject(head.get("operator"), PersonInfo.class, this.cuFilter, ctx);
		info.setOperator(operator);

		String agent = (String)head.get("agent");
		if(agent!=null&&agent.indexOf("可空")<0)
			info.setAgent(agent);

		if (!(isNull(head.get("amount")))){
			verifyFieldFormat("amount", head.get("amount"), "bigdecimal");
			info.setAmount(BillProertiesConvertor.getBigDecimal((String)head.get("amount")));
		}else
			info.setAmount(BigDecimal.ZERO);

		String slaughterPlace = (String)head.get("slaughterPlace");
		info.setSlaughterPlace(slaughterPlace);

		if (!(isNull(head.get("depositAmt")))){
			verifyFieldFormat("depositAmt", head.get("depositAmt"), "bigdecimal");
			info.setDepositAmt(BillProertiesConvertor.getBigDecimal((String)head.get("depositAmt")));
		}else
			info.setDepositAmt(BigDecimal.ZERO);

		if (!(isNull(head.get("feedToMeat")))){
			verifyFieldFormat("feedToMeat", head.get("feedToMeat"), "bigdecimal");
			info.setFeedToMeat(BillProertiesConvertor.getBigDecimal((String)head.get("feedToMeat")));
		}else
			info.setFeedToMeat(BigDecimal.ZERO);

		if (!(isNull(head.get("survivalRate")))){
			verifyFieldFormat("survivalRate", head.get("survivalRate"), "bigdecimal");
			info.setSurvivalRate(BillProertiesConvertor.getBigDecimal((String)head.get("survivalRate")));
		}else
			info.setSurvivalRate(BigDecimal.ZERO);

		if (!(isNull(head.get("medicineUsage")))){
			verifyFieldFormat("medicineUsage", head.get("medicineUsage"), "bigdecimal");
			info.setMedicineUsage(BillProertiesConvertor.getBigDecimal((String)head.get("medicineUsage")));
		}else
			info.setMedicineUsage(BigDecimal.ZERO);

		if (!(isNull(head.get("disinfectant")))){
			verifyFieldFormat("disinfectant", head.get("disinfectant"), "bigdecimal");
			info.setDisinfectant(BillProertiesConvertor.getBigDecimal((String)head.get("disinfectant")));
		}else
			info.setDisinfectant(BigDecimal.ZERO);

		if (!(isNull(head.get("feedingAmt")))){
			verifyFieldFormat("feedingAmt", head.get("feedingAmt"), "bigdecimal");
			info.setFeedingAmt(BillProertiesConvertor.getBigDecimal((String)head.get("feedingAmt")));
		}else
			info.setFeedingAmt(BigDecimal.ZERO);

		if (!(isNull(head.get("medicineAmt")))){
			verifyFieldFormat("medicineAmt", head.get("medicineAmt"), "bigdecimal");
			info.setMedicineAmt(BillProertiesConvertor.getBigDecimal((String)head.get("medicineAmt")));
		}else
			info.setMedicineAmt(BigDecimal.ZERO);

		if (!(isNull(head.get("otherAmt")))){
			verifyFieldFormat("otherAmt", head.get("otherAmt"), "bigdecimal");
			info.setOtherAmt(BillProertiesConvertor.getBigDecimal((String)head.get("otherAmt")));
		}else
			info.setOtherAmt(BigDecimal.ZERO);

		if (!(isNull(head.get("unitWeight")))){
			verifyFieldFormat("unitWeight", head.get("unitWeight"), "bigdecimal");
			info.setUnitWeight(BillProertiesConvertor.getBigDecimal((String)head.get("unitWeight")));
		}else
			info.setUnitWeight(BigDecimal.ZERO);

		if (!(isNull(head.get("dayAge")))){
			verifyFieldFormat("dayAge", head.get("dayAge"), "int");
			info.setDayAge(BillProertiesConvertor.getInt(((String)head.get("dayAge"))));
		}

		if (!(isNull(head.get("totalAmt")))){
			verifyFieldFormat("totalAmt", head.get("totalAmt"), "bigdecimal");
			info.setTotalAmt(BillProertiesConvertor.getBigDecimal((String)head.get("totalAmt")));
		}else
			info.setTotalAmt(BigDecimal.ZERO);

		if (!(isNull(head.get("unitAmt")))){
			verifyFieldFormat("unitAmt", head.get("unitAmt"), "bigdecimal");
			info.setUnitAmt(BillProertiesConvertor.getBigDecimal((String)head.get("unitAmt")));
		}else
			info.setUnitAmt(BigDecimal.ZERO);

		if (!(isNull(head.get("rebackCostAmt")))){
			verifyFieldFormat("rebackCostAmt", head.get("rebackCostAmt"), "bigdecimal");
			info.setRebackCostAmt(BillProertiesConvertor.getBigDecimal((String)head.get("rebackCostAmt")));
		}else
			info.setRebackCostAmt(BigDecimal.ZERO);

		if (!(isNull(head.get("rebackCostPrice")))){
			verifyFieldFormat("rebackCostPrice", head.get("rebackCostPrice"), "bigdecimal");
			info.setRebackCostPrice(BillProertiesConvertor.getBigDecimal((String)head.get("rebackCostPrice")));
		}else
			info.setRebackCostPrice(BigDecimal.ZERO);

		if (!(isNull(head.get("grossDuckSalePrice")))){
			verifyFieldFormat("grossDuckSalePrice", head.get("grossDuckSalePrice"), "bigdecimal");
			info.setGrossDuckSalePrice(BillProertiesConvertor.getBigDecimal((String)head.get("grossDuckSalePrice")));
		}
		else
			info.setGrossDuckSalePrice(BigDecimal.ZERO);

		if (!(isNull(head.get("costPerByKG")))){
			verifyFieldFormat("costPerByKG", head.get("costPerByKG"), "bigdecimal");
			info.setCostPerByKG(BillProertiesConvertor.getBigDecimal((String)head.get("costPerByKG")));
		}else
			info.setCostPerByKG(BigDecimal.ZERO);

		if (!(isNull(head.get("unitEatQty")))){
			verifyFieldFormat("unitEatQty", head.get("unitEatQty"), "bigdecimal");
			info.setUnitEatQty(BillProertiesConvertor.getBigDecimal((String)head.get("unitEatQty")));
		}else
			info.setUnitEatQty(BigDecimal.ZERO);

		if (!(isNull(head.get("yieldRate")))){
			verifyFieldFormat("yieldRate", head.get("yieldRate"), "bigdecimal");
			info.setYieldRate(BillProertiesConvertor.getBigDecimal((String)head.get("yieldRate")));
		}else
			info.setYieldRate(BigDecimal.ZERO);

		if (!(isNull(head.get("chickAmt")))){
			verifyFieldFormat("chickAmt", head.get("chickAmt"), "bigdecimal");
			info.setChickAmt(BillProertiesConvertor.getBigDecimal((String)head.get("chickAmt")));
		}else
			info.setChickAmt(BigDecimal.ZERO);


		String remark = (String)head.get("remark");
		if(remark!=null&&remark.indexOf("可空")<0)
			info.setRemark(remark);


		return null;


	}
	/**
	 * 记载分录一
	 * @param info
	 * @param entries
	 * @param ctx
	 * @throws BOSException
	 * @throws WrongArgumentException
	 */
	private void setEntries(SettleBillInfo info, List entries, Context ctx)	throws BOSException, WrongArgumentException	{
		SettleBillEntryCollection collection = info.getEntrys();
		Iterator entryIterator = entries.iterator();
		SettleBillEntryInfo entryInfo = null;
		while (entryIterator.hasNext()) {
			Map entry = (Map)entryIterator.next();
			entryInfo = getEntryInfo(entry,  ctx);
			collection.add(entryInfo);
		}
	}
	private SettleBillEntryInfo getEntryInfo(Map entry,  Context ctx)throws BOSException, WrongArgumentException{
		SettleBillEntryInfo entryInfo = new SettleBillEntryInfo();

		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String)entry.get("seq")));

		String billType = (String)entry.get("billType");
		if(billType!=null&&billType.indexOf("可空")<0)
			entryInfo.setBillType(billType);

		String billNum = (String)entry.get("billNum");
		if(billNum!=null&&billNum.indexOf("可空")<0)
			entryInfo.setBillNum(billNum);

		String biologicalAssets = (String)entry.get("biologicalAssets");
		entryInfo.setBiologicalAssets(biologicalAssets);

		verifyFieldFormat("billDate", entry.get("billDate"), "date");
		Timestamp bizDate = BillProertiesConvertor.getTimestamp((String)entry.get("billDate"));
		entryInfo.setBillDate(bizDate);

		String level = (String)entry.get("level");
		if(level!=null&&level.indexOf("可空")<0)
			entryInfo.setLevel(level);

		if (!(isNull(entry.get("quantity")))){
			verifyFieldFormat("quantity", entry.get("quantity"), "bigdecimal");
			entryInfo.setQuantity(BillProertiesConvertor.getBigDecimal((String)entry.get("quantity")));
		}else
			entryInfo.setQuantity(BigDecimal.ZERO);

		if (!(isNull(entry.get("weight")))){
			verifyFieldFormat("weight", entry.get("weight"), "bigdecimal");
			entryInfo.setWeight(BillProertiesConvertor.getBigDecimal((String)entry.get("weight")));
		}else
			entryInfo.setWeight(BigDecimal.ZERO);
		return entryInfo;
	}

	/**
	 * 加载分录二
	 * @param info
	 * @param receivePlans
	 * @throws WrongArgumentException
	 * @throws BOSException 
	 */
	private void setSlaughterRecordEntry(SettleBillInfo info, List receivePlans, Context ctx)throws WrongArgumentException, BOSException{
		SettleBillAssEntryCollection planCollection = info.getAssEntrys();
		Iterator it = receivePlans.iterator();
		Map receivePlanEntry = null;
		while (it.hasNext()) {
			receivePlanEntry = (Map)it.next();
			SettleBillAssEntryInfo planInfo = getSlaughterRecordEntry(receivePlanEntry,ctx); 
			planCollection.add(planInfo);
		}
	}
	private SettleBillAssEntryInfo getSlaughterRecordEntry(Map entry,  Context ctx)throws BOSException, WrongArgumentException{
		SettleBillAssEntryInfo entryInfo = new SettleBillAssEntryInfo();

		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String)entry.get("seq")));

		String slaughterRecord = (String)entry.get("slaughterRecord");
		entryInfo.setSlaughterRecord(slaughterRecord);

		String level = (String)entry.get("level");
		if(level!=null&&level.indexOf("可空")<0)
			entryInfo.setLevel(level);

		String biologicalAssets = (String)entry.get("biologicalAssets");
		entryInfo.setBiologicalAssets(biologicalAssets);

		if (!(isNull(entry.get("quantity")))){
			verifyFieldFormat("quantity", entry.get("quantity"), "bigdecimal");
			entryInfo.setQuantity(BillProertiesConvertor.getBigDecimal((String)entry.get("quantity")));
		}else
			entryInfo.setQuantity(BigDecimal.ZERO);

		if (!(isNull(entry.get("weight")))){
			verifyFieldFormat("weight", entry.get("weight"), "bigdecimal");
			entryInfo.setWeight(BillProertiesConvertor.getBigDecimal((String)entry.get("weight")));
		}else
			entryInfo.setWeight(BigDecimal.ZERO);

		return entryInfo;
	}

	/**
	 * 加载分录三
	 * @param info
	 * @param receivePlans
	 * @throws WrongArgumentException
	 * @throws BOSException 
	 */
	private void setOtherEntry(SettleBillInfo info, List receivePlans, Context ctx)throws WrongArgumentException, BOSException{
		SettleBillOtherEntryCollection entryColl = info.getOtherEntrys();
		Iterator it = receivePlans.iterator();
		Map receivePlanEntry = null;
		while (it.hasNext()) {
			receivePlanEntry = (Map)it.next();
			SettleBillOtherEntryInfo planInfo = getOtherEntryInfo(receivePlanEntry,ctx); 
			entryColl.add(planInfo);
		}
	}
	private SettleBillOtherEntryInfo getOtherEntryInfo(Map entry,  Context ctx)throws BOSException, WrongArgumentException{
		SettleBillOtherEntryInfo entryInfo = new SettleBillOtherEntryInfo();

		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String)entry.get("seq")));


		if (!(isNull(entry.get("Amount")))){
			verifyFieldFormat("Amount", entry.get("Amount"), "bigdecimal");
			entryInfo.setAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("Amount")));
		}else
			entryInfo.setAmount(BigDecimal.ZERO);

		if (!(isNull(entry.get("Price")))){
			verifyFieldFormat("Price", entry.get("Price"), "bigdecimal");
			entryInfo.setPrice(BillProertiesConvertor.getBigDecimal((String)entry.get("Price")));
		}else
			entryInfo.setPrice(BigDecimal.ZERO);

		if (!(isNull(entry.get("Weight")))){
			verifyFieldFormat("Weight", entry.get("Weight"), "bigdecimal");
			entryInfo.setWeight(BillProertiesConvertor.getBigDecimal((String)entry.get("Weight")));
		}else
			entryInfo.setWeight(BigDecimal.ZERO);

		MaterialInfo biologicalAssests = (MaterialInfo)BillProertiesConvertor.getValueObject(entry.get("biologicalAssests"), MaterialInfo.class, this.cuFilter, ctx);
		entryInfo.setBiologicalAssests(biologicalAssests);

		if (!(isNull(entry.get("Quantity")))){
			verifyFieldFormat("Quantity", entry.get("Quantity"), "int");
			entryInfo.setQuantity(BillProertiesConvertor.getInt(((String)entry.get("Quantity"))));
		}

		return entryInfo;
	}

	/**
	 * 加载分录四
	 * @param info
	 * @param receivePlans
	 * @throws WrongArgumentException
	 * @throws BOSException 
	 */
	private void setRewardAndPunishEntry(SettleBillInfo info, List receivePlans, Context ctx)throws WrongArgumentException, BOSException{
		SettleBillRewardPunishCollection planCollection = info.getRewardPunish();
		Iterator it = receivePlans.iterator();
		Map receivePlanEntry = null;
		while (it.hasNext()) {
			receivePlanEntry = (Map)it.next();
			SettleBillRewardPunishInfo planInfo = getRewardPunishEntry(receivePlanEntry,ctx); 
			planCollection.add(planInfo);
		}
	}
	private SettleBillRewardPunishInfo getRewardPunishEntry(Map entry,  Context ctx)throws BOSException, WrongArgumentException{
		SettleBillRewardPunishInfo entryInfo = new SettleBillRewardPunishInfo();

		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String)entry.get("seq")));

		RewardAndPunishProjectInfo rewardPunishItem = (RewardAndPunishProjectInfo)BillProertiesConvertor.getValueObject(entry.get("rewardPunishItem"), RewardAndPunishProjectInfo.class, this.cuFilter, ctx);
		entryInfo.setRewardPunishItem(rewardPunishItem);


		String remark = (String)entry.get("remark");
		if(remark!=null&&remark.indexOf("可空")<0)
			entryInfo.setRemark(remark);


		if (!(isNull(entry.get("price")))){
			verifyFieldFormat("price", entry.get("price"), "bigdecimal");
			entryInfo.setPrice(BillProertiesConvertor.getBigDecimal((String)entry.get("price")));
		}else
			entryInfo.setPrice(BigDecimal.ZERO);

		if (!(isNull(entry.get("amount")))){
			verifyFieldFormat("amount", entry.get("amount"), "bigdecimal");
			entryInfo.setAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("amount")));
		}else
			entryInfo.setAmount(BigDecimal.ZERO);

		if (!(isNull(entry.get("quantity")))){
			verifyFieldFormat("quantity", entry.get("quantity"), "bigdecimal");
			entryInfo.setQuantity(BillProertiesConvertor.getBigDecimal((String)entry.get("quantity")));
		}else
			entryInfo.setQuantity(BigDecimal.ZERO);
		return entryInfo;
	}

	/**
	 * 加载分录五
	 * @param info
	 * @param receivePlans
	 * @throws WrongArgumentException
	 * @throws BOSException 
	 */
	private void setSubsidyEntry(SettleBillInfo info, List receivePlans, Context ctx)throws WrongArgumentException, BOSException{
		SettleBillSubsidyCollection planCollection = info.getSubsidy();
		Iterator it = receivePlans.iterator();
		Map receivePlanEntry = null;
		while (it.hasNext()) {
			receivePlanEntry = (Map)it.next();
			SettleBillSubsidyInfo planInfo = getSubsidyEntry(receivePlanEntry,ctx); 
			planCollection.add(planInfo);
		}
	}
	private SettleBillSubsidyInfo getSubsidyEntry(Map entry,  Context ctx)throws BOSException, WrongArgumentException{
		SettleBillSubsidyInfo entryInfo = new SettleBillSubsidyInfo();

		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String)entry.get("seq")));

		String remark = (String)entry.get("remark");
		if(remark!=null&&remark.indexOf("可空")<0)
			entryInfo.setRemark(remark);

		String cusComplainType = (String)entry.get("cusComplainType");
		entryInfo.setCusComplainType(cusComplainType);

		String billNum = (String)entry.get("billNum");
		if(billNum!=null&&billNum.indexOf("可空")<0)
			entryInfo.setBillNum(billNum);


		if (!(isNull(entry.get("amount")))){
			verifyFieldFormat("amount", entry.get("amount"), "bigdecimal");
			entryInfo.setAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("amount")));
		}else
			entryInfo.setAmount(BigDecimal.ZERO);
		return entryInfo;
	}

	private void verifyFieldFormat(String name, Object value, String dataType)
	throws WrongArgumentException
	{
		verifyFieldNotNull(name, value);
		if (dataType.equals("int")) {
			String intString = (String)value;
			if (!(Pattern.matches("[+|-]?\\d+", intString))) {
				throw new WrongArgumentException(name, "1002");
			}
		}
		else if (dataType.equals("bigdecimal")) {
			String bigDecimalStirng = (String)value;
			if (!(Pattern.matches("[-|+]?\\d+(.\\d+)?(e[-|+]\\d+)?", bigDecimalStirng)))
			{
				throw new WrongArgumentException(name, "1004");
			}
		}
		else if (dataType.equals("date")) {
			String dateString = (String)value;
			if (!(Pattern.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", dateString)))
			{
				throw new WrongArgumentException(name, "1001");
			}
		} else {
			if ((!(dataType.equals("bool"))) || 
					(value.equals("true")) || (value.equals("false"))) return;
			throw new WrongArgumentException(name, "1003");
		}
	}
	private void verifyFieldNotNull(String name, Object value)
	throws WrongArgumentException
	{
		if (isNull(value))
			throw new WrongArgumentException(name, "1005");
	}
	private boolean isNull(Object o)
	{
		if (o == null)
			return true;
		if (o instanceof String)
			return o.equals("");
		return false;
	}


	/**
	 * 结算单苗料药成本的获取
	 */
	@Override
	protected HashMap<String, BigDecimal[]> _getCostAmtOfMLY(Context ctx, CompanyOrgUnitInfo company, String lot, AdminOrgUnitInfo adminOrgUnitInfo)
	throws BOSException {
		// TODO Auto-generated method stub
		StringBuffer sb=getStringBuffer(company,lot,adminOrgUnitInfo);
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		HashMap<String, BigDecimal[]> result=new HashMap<String, BigDecimal[]>();
		try {
			while(rs.next()){
				BigDecimal[] bigdecimalValue={ rs.getBigDecimal("actualCost"),rs.getBigDecimal("baseQty")};
				result.put(rs.getString("costItem"),bigdecimalValue);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private StringBuffer getStringBuffer(CompanyOrgUnitInfo company, String lot, AdminOrgUnitInfo adminOrgUnitInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp="\r\n";
		sb.append("/*dialect*/select * from ");
		sb.append("(select ").append(sp);
		sb.append(" N'鸭苗成本'                                   costItem,").append(sp);
		sb.append(" nvl(sum(t2.FActualCost),0)                   actualCost,").append(sp);
		sb.append(" nvl(sum(t2.FBaseQty),0)                       baseQty").append(sp);
		sb.append(" from").append(sp);
		sb.append("T_IM_MaterialReqBill                          t1").append(sp);
		sb.append("inner join T_IM_MaterialReqBillEntry          t2 on t1.FID=t2.FParentID").append(sp);
		sb.append("      and t1.FControlUnitID='").append(company.getId().toString()).append("'").append(sp);
		sb.append("      and t1.FAdminOrgUnitID='").append(adminOrgUnitInfo.getId().toString()).append("'").append(sp);
		sb.append("inner join T_BD_Material                      t3 on t3.FID=t2.FMaterialID").append(sp);
		sb.append("      and t2.CFQyLot='").append(lot).append("'").append(sp);
		sb.append("inner join T_BD_MaterialGroup                 t4 on t4.FID=t3.FMaterialGroupID and t4.FLongNumber like '02!0203%'").append(sp);
		sb.append("").append(sp);
		sb.append("group by N'鸭苗成本'").append(sp);
		sb.append(")").append(sp);
		sb.append("").append(sp);
		sb.append("union all").append(sp);
		sb.append("").append(sp);
		sb.append("(").append(sp);
		sb.append("select ").append(sp);
		sb.append(" N'饲料成本'                                   costItem,").append(sp);
		sb.append(" nvl(sum(t2.FActualCost),0)                   actualCost,").append(sp);
		sb.append(" nvl(sum(t2.FBaseQty),0)                      baseQty").append(sp);
		sb.append(" from").append(sp);
		sb.append("T_IM_MaterialReqBill                          t1").append(sp);
		sb.append("inner join T_IM_MaterialReqBillEntry          t2 on t1.FID=t2.FParentID").append(sp);
		sb.append("      and t1.FControlUnitID='").append(company.getId().toString()).append("'").append(sp);
		sb.append("      and t1.FAdminOrgUnitID='").append(adminOrgUnitInfo.getId().toString()).append("'").append(sp);
		sb.append("inner join T_BD_Material                      t3 on t3.FID=t2.FMaterialID").append(sp);
		sb.append("      and t2.CFQyLot='").append(lot).append("'").append(sp);
		sb.append("inner join T_BD_MaterialGroup                 t4 on t4.FID=t3.FMaterialGroupID and t4.FLongNumber like '02!0201!%'").append(sp);
		sb.append("").append(sp);
		sb.append("group by N'饲料成本'").append(sp);
		sb.append(")").append(sp);
		sb.append("").append(sp);
		sb.append("union all").append(sp);
		sb.append("").append(sp);
		sb.append("select * from (").append(sp);
		sb.append("select ").append(sp);
		sb.append(" N'药品成本'                                   costItem,").append(sp);
		sb.append(" nvl(sum(t2.FActualCost),0)                    actualCost,").append(sp);
		sb.append(" nvl(sum(t2.FBaseQty),0)                             baseQty").append(sp);
		sb.append(" from").append(sp);
		sb.append("T_IM_MaterialReqBill                          t1").append(sp);
		sb.append("inner join T_IM_MaterialReqBillEntry          t2 on t1.FID=t2.FParentID").append(sp);
		sb.append("      and t1.FControlUnitID='").append(company.getId().toString()).append("'").append(sp);
		sb.append("      and t1.FAdminOrgUnitID='").append(adminOrgUnitInfo.getId().toString()).append("'").append(sp);
		sb.append("inner join T_BD_Material                      t3 on t3.FID=t2.FMaterialID").append(sp);
		sb.append("      and t2.CFQyLot='").append(lot).append("'").append(sp);
		sb.append("inner join T_BD_MaterialGroup                 t4 on t4.FID=t3.FMaterialGroupID and t4.FLongNumber like '01!0103%'").append(sp);
		sb.append("").append(sp);
		sb.append("group by N'药品成本'").append(sp);
		sb.append(")").append(sp);
		return sb;
	}
}