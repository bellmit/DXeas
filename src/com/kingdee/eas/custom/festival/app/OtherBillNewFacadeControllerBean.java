package com.kingdee.eas.custom.festival.app;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.framework.DynamicObjectFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.AccountBankInfo;
import com.kingdee.eas.basedata.assistant.CashDiscountInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PaymentTypeInfo;
import com.kingdee.eas.basedata.assistant.SettlementTypeInfo;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.AsstAttrValueInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.ProfitCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.common.DiscountModeEnum;
import com.kingdee.eas.basedata.scm.common.ExpenseItemInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.cp.bc.ExpenseTypeInfo;
import com.kingdee.eas.fi.ap.VerificateBillTypeEnum;
import com.kingdee.eas.fi.ar.ArPrintBillEntryInfo;
import com.kingdee.eas.fi.ar.ArPrintBillInfo;
import com.kingdee.eas.fi.ar.BillStatusEnum;
import com.kingdee.eas.fi.ar.IOtherBill;
import com.kingdee.eas.fi.ar.OtherBillCollection;
import com.kingdee.eas.fi.ar.OtherBillFactory;
import com.kingdee.eas.fi.ar.OtherBillInfo;
import com.kingdee.eas.fi.ar.OtherBillPlanCollection;
import com.kingdee.eas.fi.ar.OtherBillPlanInfo;
import com.kingdee.eas.fi.ar.OtherBillTypeEnum;
import com.kingdee.eas.fi.ar.OtherBillentryCollection;
import com.kingdee.eas.fi.ar.OtherBillentryInfo;
import com.kingdee.eas.fi.ar.app.webservice.util.BillProertiesConvertor;
import com.kingdee.eas.fi.ar.app.webservice.util.BillPropertiesReader;
import com.kingdee.eas.fi.ar.app.webservice.util.WrongArgumentException;
import com.kingdee.eas.fi.cas.ReceivingBillCollection;
import com.kingdee.eas.fi.cas.ReceivingBillFactory;
import com.kingdee.eas.scm.customize.arap.ExtendsOtherBillFacadeFactory;
import com.kingdee.eas.scm.customize.arap.IExtendsOtherBillFacade;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.StringUtils;

import java.io.IOException;
import java.lang.String;

public class OtherBillNewFacadeControllerBean extends AbstractOtherBillNewFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.festival.app.OtherBillNewFacadeControllerBean");

	private static final String SUCCESS = "Y";
	private static final String FAILED = "N";
	private static final String BILLHEAD = "head";
	private static final String BILLENTRIS = "entry";
	private static final String BILLPLAN = "plan";
	private static final String OTHER = "other";
	private static final String BILLTYPE = "OtherBill";
	private static final String ENTRYXPATH = "//billEntries/entry";
	private static final String RECEIVEPLANXPATH = "//receivePlans/ReceivePlan";
	private FilterItemInfo cuFilter;


	protected String[] _submit(Context ctx, String xmlData)
	throws BOSException
	{
		this.cuFilter = null;

		BillPropertiesReader helper = null;
		try {
			helper = new BillPropertiesReader(xmlData, "OtherBill");
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
		List receivePlans = helper.getEntriesProperties("//receivePlans/ReceivePlan");

		OtherBillInfo info = new OtherBillInfo();
		try {
			if (head == null) {
				return new String[] { "N", "1011", "other", "No head!" };
			}
			setHead(info, head, ctx);
			if(!StringUtils.isEmpty(info.getNumber())){
				OtherBillCollection coll = OtherBillFactory.getLocalInstance(ctx).getOtherBillCollection("where number='"+info.getNumber()+"'");
				if(coll.size()>0){
					return new String[] {"N","number","head","±‡¬Î÷ÿ∏¥"};
				}
			}
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":head field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "head", e.getField() };
		}
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
		try
		{
			if (receivePlans.size() == 0) {
				return new String[] { "N", "1010", "other", "no receive plans" };
			}

			setReceivePlans(info, receivePlans);
		} catch (WrongArgumentException e) {
			logger.debug(e.getTypeNumber() + ":plan field " + e.getField() + " error");

			return new String[] { "N", e.getTypeNumber(), "plan", e.getField() };
		}

		IExtendsOtherBillFacade extdOtherBill = ExtendsOtherBillFacadeFactory.getLocalInstance(ctx);

		extdOtherBill.submit(info, xmlData);

		IOtherBill iOtherBill = OtherBillFactory.getLocalInstance(ctx);
		try {
			iOtherBill.save(info);
		} catch (Exception e) {
			logger.error("AROtherBill save : " + e.getMessage());
			return new String[] { "N", "1006", "other", "error occur when saving bill" };
		}


		String number = (String)head.get("number");
		if(info.getId()!=null){
			String str="update T_AR_OtherBill set Fnumber='"+number+"' where FID='"+info.getId().toString()+"'";
			DbUtil.execute(ctx, str);
		}


		return new String[] { "Y" };
	}

	private void setHead(OtherBillInfo info, Map head, Context ctx)
	throws BOSException, WrongArgumentException
	{
		verifyFieldNotNull("CU", head.get("CU"));
		CtrlUnitInfo cu = (CtrlUnitInfo)BillProertiesConvertor.getValueObject(head.get("CU"), CtrlUnitInfo.class, null, ctx);

		info.setCU(cu);
		verifyFieldNotNull("CU", cu);
		if ("yes".equals(head.get("CUNeed"))) {
			this.cuFilter = new FilterItemInfo("CU.id", cu.getId(), CompareType.EQUALS);
		}

		info.setBillStatus(BillStatusEnum.SAVE);

		verifyFieldNotNull("creator", head.get("creator"));
		UserInfo userInfo = (UserInfo)BillProertiesConvertor.getValueObject(head.get("creator"), UserInfo.class, this.cuFilter, ctx);


		verifyFieldNotNull("creator", userInfo);
		info.setCreator(userInfo);


		if(head.get("dealCompany")!=null){
			CompanyOrgUnitInfo dealCompany = (CompanyOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("dealCompany"), CompanyOrgUnitInfo.class, this.cuFilter, ctx);
			if(dealCompany!=null)
				info.put("dealcompany", dealCompany);
		}

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

		verifyFieldFormat("bizDate", head.get("bizDate"), "date");
		Timestamp bizDate = BillProertiesConvertor.getTimestamp((String)head.get("bizDate"));

		info.setBizDate(bizDate);

		UserInfo handler = (UserInfo)BillProertiesConvertor.getValueObject(head.get("handler"), UserInfo.class, this.cuFilter, ctx);

		info.setHandler(handler);

		String description = (String)head.get("descption");
		info.setDescription(description);

		boolean hasEffected = BillProertiesConvertor.getBool((String)head.get("hasEffected"));

		info.setHasEffected(hasEffected);

		info.setSourceBillId((String)head.get("sourceBillId"));

		info.setSourceFunction((String)head.get("sourceFunction"));

		verifyFieldNotNull("company", head.get("company"));
		CompanyOrgUnitInfo comInfo = (CompanyOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("company"), CompanyOrgUnitInfo.class, this.cuFilter, ctx);

		verifyFieldNotNull("company", comInfo);
		info.setCompany(comInfo);

		info.setBillDate(info.getBizDate());

		verifyFieldNotNull("asstActType", head.get("asstActType"));
		AsstActTypeInfo asstActTypeInfo = (AsstActTypeInfo)BillProertiesConvertor.getValueObject(head.get("asstActType"), AsstActTypeInfo.class, null, ctx);

		verifyFieldNotNull("asstActType", asstActTypeInfo);
		info.setAsstActType(asstActTypeInfo);

		setAsstActor(ctx, info, head, asstActTypeInfo);

		verifyFieldNotNull("currency", head.get("currency"));
		CurrencyInfo curInfo = (CurrencyInfo)BillProertiesConvertor.getValueObject(head.get("currency"), CurrencyInfo.class, this.cuFilter, ctx);

		verifyFieldNotNull("currency", curInfo);
		info.setCurrency(curInfo);

		AdminOrgUnitInfo aouInfo = (AdminOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("adminOrgUnit"), AdminOrgUnitInfo.class, this.cuFilter, ctx);

		info.setAdminOrgUnit(aouInfo);

		PersonInfo person = (PersonInfo)BillProertiesConvertor.getValueObject(head.get("person"), PersonInfo.class, this.cuFilter, ctx);

		info.setPerson(person);

		verifyFieldFormat("exchangeRate", head.get("exchangeRate"), "bigdecimal");

		info.setExchangeRate(BillProertiesConvertor.getBigDecimal((String)head.get("exchangeRate")));

		SettlementTypeInfo settleType = (SettlementTypeInfo)BillProertiesConvertor.getValueObject(head.get("settleType"), SettlementTypeInfo.class, null, ctx);

		info.setSettleType(settleType);

		verifyFieldFormat("amount", head.get("amount"), "bigdecimal");
		info.setAmount(BillProertiesConvertor.getBigDecimal((String)head.get("amount")));

		verifyFieldFormat("amountLocal", head.get("amountLocal"), "bigdecimal");
		info.setAmountLocal(BillProertiesConvertor.getBigDecimal((String)head.get("amountLocal")));

		info.setAbstractName((String)head.get("abstractName"));

		if (!(isNull(head.get("verifyAmount")))) {
			verifyFieldFormat("verifyAmount", head.get("verifyAmount"), "bigdecimal");
		}
		info.setVerifyAmount(BillProertiesConvertor.getBigDecimal((String)head.get("verifyAmount")));

		if (!(isNull(head.get("verifyAmountLocal")))) {
			verifyFieldFormat("verifyAmountLocal", head.get("verifyAmountLocal"), "bigdecimal");
		}
		info.setVerifyAmountLocal(BillProertiesConvertor.getBigDecimal((String)head.get("verifyAmountLocal")));

		verifyFieldFormat("unVerifyAmount", head.get("unVerifyAmount"), "bigdecimal");

		info.setUnVerifyAmount(BillProertiesConvertor.getBigDecimal((String)head.get("unVerifyAmount")));

		verifyFieldFormat("unVerifyAmountLocal", head.get("unVerifyAmountLocal"), "bigdecimal");

		info.setUnVerifyAmountLocal(BillProertiesConvertor.getBigDecimal((String)head.get("unVerifyAmountLocal")));

		info.setFiVouchered(false);

		verifyFieldFormat("sourceBillType", head.get("sourceBillType"), "int");
		VerificateBillTypeEnum sourceBillType = VerificateBillTypeEnum.getEnum(BillProertiesConvertor.getInt((String)head.get("sourceBillType")));

		verifyFieldNotNull("sourceBillType", sourceBillType);
		info.setSourceBillType(sourceBillType);

		CashDiscountInfo cashDiscount = (CashDiscountInfo)BillProertiesConvertor.getValueObject(head.get("cashDiscount"), CashDiscountInfo.class, this.cuFilter, ctx);

		info.setCashDiscount(cashDiscount);

		if (!(isNull(head.get("isReversed"))))
			verifyFieldFormat("isReversed", head.get("isReversed"), "bool");
		info.setIsReversed(BillProertiesConvertor.getBool((String)head.get("isReversed")));

		if (!(isNull(head.get("isReverseBill")))) {
			verifyFieldFormat("isReverseBill", head.get("isReverseBill"), "bool");
		}
		info.setIsReverseBill(BillProertiesConvertor.getBool((String)head.get("isReverseBill")));

		UserInfo accountant = (UserInfo)BillProertiesConvertor.getValueObject(head.get("accountant"), UserInfo.class, this.cuFilter, ctx);

		info.setAccountant(accountant);

		if (!(isNull(head.get("isTransBill"))))
			verifyFieldFormat("isTransBill", head.get("isTransBill"), "bool");
		boolean isTransBill = BillProertiesConvertor.getBool((String)head.get("isTransBill"));

		info.setIsTransBill(isTransBill);

		if (!(isNull(head.get("isImportBill"))))
			verifyFieldFormat("isImportBill", head.get("isImportBill"), "bool");
		boolean isImportBill = BillProertiesConvertor.getBool((String)head.get("isImportBill"));

		info.setIsImportBill(isImportBill);

		verifyFieldNotNull("bizType", head.get("bizType"));
		BizTypeInfo bizType = (BizTypeInfo)BillProertiesConvertor.getValueObject(head.get("bizType"), BizTypeInfo.class, null, ctx);

		verifyFieldNotNull("bizType", bizType);
		info.setBizType(bizType);

		verifyFieldNotNull("paymentType", head.get("paymentType"));
		PaymentTypeInfo paymentTypeInfo = (PaymentTypeInfo)BillProertiesConvertor.getValueObject(head.get("paymentType"), PaymentTypeInfo.class, null, ctx);

		verifyFieldNotNull("paymentType", paymentTypeInfo);
		info.setPaymentType(paymentTypeInfo);

		verifyFieldFormat("lastExhangeRate", head.get("lastExhangeRate"), "bigdecimal");

		info.setLastExhangeRate(BillProertiesConvertor.getBigDecimal((String)head.get("lastExhangeRate")));

		verifyFieldFormat("totalAmount", head.get("totalAmount"), "bigdecimal");
		info.setTotalAmount(BillProertiesConvertor.getBigDecimal((String)head.get("totalAmount")));

		if (!(isNull(head.get("totalTax"))))
			verifyFieldFormat("totalTax", head.get("totalTax"), "bigdecimal");
		info.setTotalTax(BillProertiesConvertor.getBigDecimal((String)head.get("totalTax")));

		verifyFieldFormat("totalTaxAmount", head.get("totalTaxAmount"), "bigdecimal");

		info.setTotalTax(BillProertiesConvertor.getBigDecimal((String)head.get("totalTaxAmount")));

		if (!(isNull(head.get("isExchanged"))))
			verifyFieldFormat("isExchanged", head.get("isExchanged"), "bool");
		info.setIsExchanged(BillProertiesConvertor.getBool((String)head.get("isExchanged")));

		if (!(isNull(head.get("isInitializeBill")))) {
			verifyFieldFormat("isInitializeBill", head.get("isInitializeBill"), "bool");
		}
		info.setIsInitializeBill(BillProertiesConvertor.getBool((String)head.get("isInitializeBill")));

		verifyFieldFormat("redBlueType", head.get("redBlueType"), "bool");
		info.setRedBlueType(BillProertiesConvertor.getBool((String)head.get("redBlueType")));

		if (!(isNull(head.get("year"))))
			verifyFieldFormat("year", head.get("year"), "int");
		info.setYear(BillProertiesConvertor.getInt((String)head.get("year")));

		if (!(isNull(head.get("period"))))
			verifyFieldFormat("period", head.get("period"), "int");
		info.setPeriod(BillProertiesConvertor.getInt((String)head.get("period")));

		if (!(isNull(head.get("isSCMBill"))))
			verifyFieldFormat("isSCMBill", head.get("isSCMBill"), "bool");
		info.setIsSCMBill(BillProertiesConvertor.getBool((String)head.get("isSCMBill")));

		SaleOrgUnitInfo saleOrg = (SaleOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("saleOrg"), SaleOrgUnitInfo.class, this.cuFilter, ctx);

		info.setSaleOrg(saleOrg);

		if (!(isNull(head.get("totalBadAmount")))) {
			verifyFieldFormat("totalBadAmount", head.get("totalBadAmount"), "bigdecimal");
		}
		info.setTotalBadAmount(BillProertiesConvertor.getBigDecimal((String)head.get("totalBadAmount")));

		if (!(isNull(head.get("totalBadAmountLocal")))) {
			verifyFieldFormat("totalBadAmountLocal", head.get("totalBadAmountLocal"), "bigdecimal");
		}
		info.setTotalBadAmountLocal(BillProertiesConvertor.getBigDecimal((String)head.get("totalBadAmountLocal")));

		verifyFieldFormat("billType", head.get("billType"), "int");
		OtherBillTypeEnum otherBillType = OtherBillTypeEnum.getEnum(BillProertiesConvertor.getInt((String)head.get("billType")));

		verifyFieldNotNull("billType", otherBillType);
		info.setBillType(otherBillType);

		SaleGroupInfo saleGroup = (SaleGroupInfo)BillProertiesConvertor.getValueObject(head.get("saleGroup"), SaleGroupInfo.class, this.cuFilter, ctx);

		info.setSaleGroup(saleGroup);
	}

	private void setAsstActor(Context ctx, OtherBillInfo info, Map head, AsstActTypeInfo asstActTypeInfo)
	throws BOSException, WrongArgumentException
	{
		verifyFieldNotNull("asstActNumber", head.get("asstActNumber"));
		info.setAsstActNumber((String)head.get("asstActNumber"));

		EntityViewInfo evInfo = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number", head.get("asstActNumber"), CompareType.EQUALS));

		if (this.cuFilter != null)
			filter.getFilterItems().add(this.cuFilter);
		evInfo.setFilter(filter);

		if (asstActTypeInfo == null) {
			return;
		}

		String relationDataObject = asstActTypeInfo.getRealtionDataObject();

		BOSObjectType bosType = null;

		if (StringUtils.isEmpty(relationDataObject)) {
			return;
		}

		boolean fCust = relationDataObject.equalsIgnoreCase("T_BD_Customer");
		boolean fSupp = relationDataObject.equalsIgnoreCase("T_BD_Supplier");
		boolean fMaterial = relationDataObject.equalsIgnoreCase("T_BD_Material");

		if (relationDataObject.equalsIgnoreCase("T_BD_AccountBanks")) {
			bosType = new AccountBankInfo().getBOSType();
		}
		else if (fCust) {
			bosType = new CustomerInfo().getBOSType();
		}
		else if (fSupp) {
			bosType = new SupplierInfo().getBOSType();
		}
		else if (fMaterial) {
			bosType = new MaterialInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_BD_Person")) {
			bosType = new PersonInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_ORG_Company")) {
			bosType = new CompanyOrgUnitInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_ORG_CostCenter")) {
			bosType = new CostCenterOrgUnitInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_ORG_Admin")) {
			bosType = new AdminOrgUnitInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_ORG_Purchase")) {
			bosType = new PurchaseOrgUnitInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_ORG_Storage")) {
			bosType = new StorageOrgUnitInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_ORG_Sale")) {
			bosType = new SaleOrgUnitInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_ORG_ProfitCenter")) {
			bosType = new ProfitCenterOrgUnitInfo().getBOSType();
		}
		else if (relationDataObject.equalsIgnoreCase("T_BD_GeneralAsstActType")) {
			bosType = new GeneralAsstActTypeInfo().getBOSType();
		}

		try
		{
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add(new SelectorItemInfo("id"));
			sic.add(new SelectorItemInfo("number"));
			sic.add(new SelectorItemInfo("name"));

			IObjectCollection objValCol = DynamicObjectFactory.getLocalInstance(ctx).getCollection(bosType, evInfo);

			if ((objValCol != null) && (objValCol.getObject(0) != null)) {
				IObjectValue objVal = objValCol.getObject(0);

				info.setAsstActID(objVal.getString("id"));
				info.setAsstActName(objVal.getString("name"), ctx.getLocale());
				info.setAsstActNumber(objVal.getString("number"));
			}
		} catch (BOSException e) {
			throw new WrongArgumentException("asstActNumber", "1005");
		}
	}

	private void setEntries(OtherBillInfo info, List entries, Context ctx)
	throws BOSException, WrongArgumentException
	{
		OtherBillentryCollection collection = info.getEntry();
		Iterator entryIterator = entries.iterator();
		OtherBillTypeEnum billType = info.getBillType();
		boolean isInvoice = billType.equals(OtherBillTypeEnum.InvoiceBill);
		OtherBillentryInfo entryInfo = null;
		while (entryIterator.hasNext()) {
			Map entry = (Map)entryIterator.next();
			entryInfo = getEntryInfo(entry, isInvoice, ctx);
			collection.add(entryInfo);
		}
	}

	private OtherBillentryInfo getEntryInfo(Map entry, boolean isInvoice, Context ctx)
	throws BOSException, WrongArgumentException
	{
		OtherBillentryInfo entryInfo = new OtherBillentryInfo();

		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String)entry.get("seq")));

		if (isInvoice)
		{
			verifyFieldNotNull("material", entry.get("material"));
			MaterialInfo mInfo = (MaterialInfo)BillProertiesConvertor.getValueObject(entry.get("material"), MaterialInfo.class, this.cuFilter, ctx);

			verifyFieldNotNull("material", mInfo);
			entryInfo.setMaterial(mInfo);
			entryInfo.setMeasureUnit(mInfo.getBaseUnit());
		}
		else {
			verifyFieldNotNull("expenseItem", entry.get("expenseItem"));
//			ExpenseItemInfo eInfo = (ExpenseItemInfo)BillProertiesConvertor.getValueObject(entry.get("expenseItem"), ExpenseItemInfo.class, this.cuFilter, ctx);
			ExpenseTypeInfo eInfo = (ExpenseTypeInfo)BillProertiesConvertor.getValueObject(entry.get("expenseItem"), ExpenseItemInfo.class, this.cuFilter, ctx);

			verifyFieldNotNull("expenseItem", eInfo);
			entryInfo.setExpenseItem(eInfo);
		}

		StorageOrgUnitInfo storageOrgInfo = (StorageOrgUnitInfo)BillProertiesConvertor.getValueObject(entry.get("recSendOrgUnit"), StorageOrgUnitInfo.class, this.cuFilter, ctx);

		entryInfo.setRecSendOrgUnit(storageOrgInfo);
		entryInfo.setRecSendOrgUnit(storageOrgInfo);

		verifyFieldNotNull("measureUnit", entry.get("measureUnit"));
		MeasureUnitInfo measureUnit = (MeasureUnitInfo)BillProertiesConvertor.getValueObject(entry.get("measureUnit"), MeasureUnitInfo.class, this.cuFilter, ctx);

		verifyFieldNotNull("measureUnit", measureUnit);
		entryInfo.setMeasureUnit(measureUnit);

		if(entry.get("orderCustomer")!=null){
			CustomerInfo orderCustomerInfo = (CustomerInfo)BillProertiesConvertor.getValueObject(entry.get("orderCustomer"),CustomerInfo.class,this.cuFilter,ctx);
			if(orderCustomerInfo!=null){
				entryInfo.setOrderCustomer(orderCustomerInfo);
				entryInfo.setOrdCustNumber(orderCustomerInfo.getNumber());
				entryInfo.setOrdCustName(orderCustomerInfo.getName());
				entryInfo.setRecAsstActID(orderCustomerInfo.getId().toString());
				entryInfo.setRecAsstActNumber(orderCustomerInfo.getNumber());
				entryInfo.setRecAsstActName(orderCustomerInfo.getName());
			}
		}

		if(entry.get("serviceCustomer")!=null){
			CustomerInfo serviceCustomerInfo = (CustomerInfo)BillProertiesConvertor.getValueObject(entry.get("serviceCustomer"),CustomerInfo.class,this.cuFilter,ctx);
			if(serviceCustomerInfo!=null){
				entryInfo.setServiceCustomer(serviceCustomerInfo);
				entryInfo.setSerCustName(serviceCustomerInfo.getName());
				entryInfo.setSerCustNumber(serviceCustomerInfo.getNumber());
			}
		}


		if(entry.get("recAsstActType")!=null){
			AsstActTypeInfo recAssActTypeInfo = (AsstActTypeInfo)BillProertiesConvertor.getValueObject(entry.get("recAsstActType"),AsstActTypeInfo.class,this.cuFilter,ctx);
			if(recAssActTypeInfo!=null)
				entryInfo.setRecAsstActType(recAssActTypeInfo);
		}

		AsstAttrValueInfo asstAttrValueInfo = (AsstAttrValueInfo)BillProertiesConvertor.getValueObject(entry.get("assistProperty"), AsstAttrValueInfo.class, this.cuFilter, ctx);

		entryInfo.setAssistProperty(asstAttrValueInfo);

		AccountViewInfo accountInfo = (AccountViewInfo)BillProertiesConvertor.getValueObject(entry.get("account"), AccountViewInfo.class, this.cuFilter, ctx);

		entryInfo.setAccount(accountInfo);

		verifyFieldFormat("recievePayAmount", entry.get("recievePayAmount"), "bigdecimal");

		entryInfo.setRecievePayAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("recievePayAmount")));

		verifyFieldFormat("recievePayAmountLocal", entry.get("recievePayAmountLocal"), "bigdecimal");

		entryInfo.setRecievePayAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("recievePayAmountLocal")));

		if (!(isNull(entry.get("verifyAmount")))) {
			verifyFieldFormat("verifyAmount", entry.get("verifyAmount"), "bigdecimal");
		}
		entryInfo.setVerifyAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("verifyAmount")));

		if (!(isNull(entry.get("verifyAmountLocal")))) {
			verifyFieldFormat("verifyAmountLocal", entry.get("verifyAmountLocal"), "bigdecimal");
		}
		entryInfo.setVerifyAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("verifyAmountLocal")));

		verifyFieldFormat("unVerifyAmount", entry.get("unVerifyAmount"), "bigdecimal");

		entryInfo.setUnVerifyAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("unVerifyAmount")));

		verifyFieldFormat("unVerifyAmountLocal", entry.get("unVerifyAmountLocal"), "bigdecimal");

		entryInfo.setUnVerifyAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("unVerifyAmountLocal")));

		if (!(isNull(entry.get("lockVerifyAmt")))) {
			verifyFieldFormat("lockVerifyAmt", entry.get("lockVerifyAmt"), "bigdecimal");
		}
		entryInfo.setLockVerifyAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("lockVerifyAmt")));

		if (!(isNull(entry.get("lockVerifyAmtLocal")))) {
			verifyFieldFormat("lockVerifyAmtLocal", entry.get("lockVerifyAmtLocal"), "bigdecimal");
		}
		entryInfo.setLockVerifyAmtLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("lockVerifyAmtLocal")));

		verifyFieldFormat("lockUnVerifyAmt", entry.get("lockUnVerifyAmt"), "bigdecimal");

		entryInfo.setLockUnVerifyAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("lockUnVerifyAmt")));

		verifyFieldFormat("lockUnVerifyAmtLocal", entry.get("lockUnVerifyAmtLocal"), "bigdecimal");

		entryInfo.setLockUnVerifyAmtLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("lockUnVerifyAmtLocal")));

		entryInfo.setRemark((String)entry.get("remark"));

		verifyFieldFormat("quantity", entry.get("quantity"), "bigdecimal");
		entryInfo.setQuantity(BillProertiesConvertor.getBigDecimal((String)entry.get("quantity")));

		verifyFieldFormat("price", entry.get("price"), "bigdecimal");
		entryInfo.setPrice(BillProertiesConvertor.getBigDecimal((String)entry.get("price")));

		if (!(isNull(entry.get("taxPrice"))))
			verifyFieldFormat("taxPrice", entry.get("taxPrice"), "bigdecimal");
		entryInfo.setTaxPrice(BillProertiesConvertor.getBigDecimal((String)entry.get("taxPrice")));

		verifyFieldFormat("actualPrice", entry.get("actualPrice"), "bigdecimal");
		entryInfo.setActualPrice(BillProertiesConvertor.getBigDecimal((String)entry.get("actualPrice")));

		if (!(isNull(entry.get("discountRate")))) {
			verifyFieldFormat("discountRate", entry.get("discountRate"), "bigdecimal");
		}
		entryInfo.setDiscountRate(BillProertiesConvertor.getBigDecimal((String)entry.get("discountRate")));

		if (!(isNull(entry.get("discountAmount")))) {
			verifyFieldFormat("discountAmount", entry.get("discountAmount"), "bigdecimal");
		}
		entryInfo.setDiscountAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("discountAmount")));

		if (!(isNull(entry.get("discountAmountLocal")))) {
			verifyFieldFormat("discountAmountLocal", entry.get("discountAmountLocal"), "bigdecimal");
		}
		entryInfo.setDiscountAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("discountAmountLocal")));

		if (!(isNull(entry.get("taxRate"))))
			verifyFieldFormat("taxRate", entry.get("taxRate"), "bigdecimal");
		entryInfo.setTaxRate(BillProertiesConvertor.getBigDecimal((String)entry.get("taxRate")));

		if (!(isNull(entry.get("taxAmount"))))
			verifyFieldFormat("taxAmount", entry.get("taxAmount"), "bigdecimal");
		entryInfo.setTaxAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("taxAmount")));

		if (!(isNull(entry.get("taxAmountLocal")))) {
			verifyFieldFormat("taxAmountLocal", entry.get("taxAmountLocal"), "bigdecimal");
		}
		entryInfo.setTaxAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("taxAmountLocal")));

		entryInfo.setSourceBillId((String)entry.get("sourceBillId"));

		entryInfo.setSourceBillEntryId((String)entry.get("sourceBillEntryId"));

		verifyFieldFormat("amount", entry.get("amount"), "bigdecimal");
		entryInfo.setAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("amount")));

		verifyFieldFormat("amountLocal", entry.get("amountLocal"), "bigdecimal");
		entryInfo.setAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("amountLocal")));

		entryInfo.setSourceBillAsstActID((String)entry.get("sourceBillAsstActID"));

		if (!(isNull(entry.get("hisUnVerifyAmount")))) {
			verifyFieldFormat("hisUnVerifyAmount", entry.get("hisUnVerifyAmount"), "bigdecimal");
		}
		entryInfo.setHisUnVerifyAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("hisUnVerifyAmount")));

		if (!(isNull(entry.get("hisUnVerifyAmountLocal")))) {
			verifyFieldFormat("hisUnVerifyAmountLocal", entry.get("hisUnVerifyAmountLocal"), "bigdecimal");
		}
		entryInfo.setHisUnVerifyAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("hisUnVerifyAmountLocal")));

		BillTypeInfo billTypeInfo = (BillTypeInfo)BillProertiesConvertor.getValueObject(entry.get("coreBillType"), BillTypeInfo.class, this.cuFilter, ctx);

		entryInfo.setCoreBillType(billTypeInfo);

		entryInfo.setCoreBillId((String)entry.get("coreBillId"));

		entryInfo.setCoreBillEntryId((String)entry.get("coreBillEntryId"));

		entryInfo.setCoreBillNumber((String)entry.get("coreBillNumber"));

		if (!(isNull(entry.get("coreBillEntrySeq")))) {
			entryInfo.setCoreBillEntrySeq(BillProertiesConvertor.getInt((String)entry.get("coreBillEntrySeq")));
		}

		entryInfo.setTrackNumber((String)entry.get("trackNumber"));

		MeasureUnitInfo muInfo = (MeasureUnitInfo)BillProertiesConvertor.getValueObject(entry.get("assistUnit"), MeasureUnitInfo.class, this.cuFilter, ctx);

		entryInfo.setAssistUnit(muInfo);

		if (!(isNull(entry.get("assistQty"))))
			verifyFieldFormat("assistQty", entry.get("assistQty"), "bigdecimal");
		entryInfo.setAssistQty(BillProertiesConvertor.getBigDecimal((String)entry.get("assistQty")));

		AccountViewInfo oppAccountInfo = (AccountViewInfo)BillProertiesConvertor.getValueObject(entry.get("oppAccount"), AccountViewInfo.class, this.cuFilter, ctx);

		entryInfo.setOppAccount(oppAccountInfo);

		DiscountModeEnum dmEnum = DiscountModeEnum.getEnum(BillProertiesConvertor.getInt((String)entry.get("discountType")));

		if (dmEnum != null) {
			entryInfo.setDiscountType(dmEnum);
		}
		if (!(isNull(entry.get("wittenOffBaseQty")))) {
			verifyFieldFormat("wittenOffBaseQty", entry.get("wittenOffBaseQty"), "bigdecimal");
		}
		entryInfo.setWittenOffBaseQty(BillProertiesConvertor.getBigDecimal((String)entry.get("wittenOffBaseQty")));

		if (!(isNull(entry.get("localWrittenOffAmount")))) {
			verifyFieldFormat("localWrittenOffAmount", entry.get("localWrittenOffAmount"), "bigdecimal");
		}
		entryInfo.setLocalWrittenOffAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("localWrittenOffAmount")));

		verifyFieldFormat("unwriteOffBaseQty", entry.get("unwriteOffBaseQty"), "bigdecimal");

		entryInfo.setUnwriteOffBaseQty(BillProertiesConvertor.getBigDecimal((String)entry.get("unwriteOffBaseQty")));

		verifyFieldFormat("localUnwriteOffAmount", entry.get("localUnwriteOffAmount"), "bigdecimal");

		entryInfo.setLocalUnwriteOffAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("localUnwriteOffAmount")));

		if (!(isNull(entry.get("invoicedBaseQty")))) {
			verifyFieldFormat("invoicedBaseQty", entry.get("invoicedBaseQty"), "bigdecimal");
		}
		entryInfo.setInvoicedBaseQty(BillProertiesConvertor.getBigDecimal((String)entry.get("invoicedBaseQty")));

		if (!(isNull(entry.get("invoicedAmt")))) {
			verifyFieldFormat("invoicedAmt", entry.get("invoicedAmt"), "bigdecimal");
		}
		entryInfo.setInvoicedAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("invoicedAmt")));

		if (!(isNull(entry.get("isInvoiced"))))
			verifyFieldFormat("isInvoiced", entry.get("isInvoiced"), "bool");
		entryInfo.setIsInvoiced(BillProertiesConvertor.getBool((String)entry.get("isInvoiced")));

		MeasureUnitInfo measureUnitInfo = (MeasureUnitInfo)BillProertiesConvertor.getValueObject(entry.get("baseUnit"), MeasureUnitInfo.class, this.cuFilter, ctx);

		entryInfo.setMeasureUnit(measureUnitInfo);

		if (!(isNull(entry.get("baseQty"))))
			verifyFieldFormat("baseQty", entry.get("baseQty"), "bigdecimal");
		entryInfo.setBaseQty(BillProertiesConvertor.getBigDecimal((String)entry.get("baseQty")));

		verifyFieldFormat("realPrice", entry.get("realPrice"), "bigdecimal");
		entryInfo.setRealPrice(BillProertiesConvertor.getBigDecimal((String)entry.get("realPrice")));

		if (!(isNull(entry.get("badAmount"))))
			verifyFieldFormat("badAmount", entry.get("badAmount"), "bigdecimal");
		entryInfo.setBadAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("badAmount")));

		if (!(isNull(entry.get("badAmountLocal")))) {
			verifyFieldFormat("badAmountLocal", entry.get("badAmountLocal"), "bigdecimal");
		}
		entryInfo.setBadAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("badAmountLocal")));

		if (!(isNull(entry.get("preparedBadAmount")))) {
			verifyFieldFormat("preparedBadAmount", entry.get("preparedBadAmount"), "bigdecimal");
		}
		entryInfo.setPreparedBadAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("preparedBadAmount")));

		if (!(isNull(entry.get("preparedBadAmountLocal")))) {
			verifyFieldFormat("preparedBadAmountLocal", entry.get("preparedBadAmountLocal"), "bigdecimal");
		}
		entryInfo.setPreparedBadAmountLocal(BillProertiesConvertor.getBigDecimal((String)entry.get("preparedBadAmountLocal")));

		ArPrintBillInfo arPrintBillInfo = (ArPrintBillInfo)BillProertiesConvertor.getValueObject(entry.get("arPrintBill"), ArPrintBillInfo.class, this.cuFilter, ctx);

		entryInfo.setArPrintBill(arPrintBillInfo);

		ArPrintBillEntryInfo arPrintBillEntryInfo = (ArPrintBillEntryInfo)BillProertiesConvertor.getValueObject(entry.get("arPrintBillEntry"), ArPrintBillEntryInfo.class, this.cuFilter, ctx);

		entryInfo.setArPrintBillEntry(arPrintBillEntryInfo);
		return entryInfo;
	}

	private void setReceivePlans(OtherBillInfo info, List receivePlans)
	throws WrongArgumentException
	{
		OtherBillPlanCollection planCollection = info.getRecievePlan();
		Iterator it = receivePlans.iterator();
		Map receivePlanEntry = null;
		while (it.hasNext()) {
			receivePlanEntry = (Map)it.next();
			OtherBillPlanInfo planInfo = getOtherBillPlanEntry(receivePlanEntry);
			planCollection.add(planInfo);
		}
	}

	private OtherBillPlanInfo getOtherBillPlanEntry(Map plan)
	throws WrongArgumentException
	{
		OtherBillPlanInfo planInfo = new OtherBillPlanInfo();

		verifyFieldFormat("seq", plan.get("seq"), "int");
		planInfo.setSeq(BillProertiesConvertor.getInt((String)plan.get("seq")));

		verifyFieldFormat("receivePayDate", plan.get("receivePayDate"), "date");
		planInfo.setRecievePayDate(BillProertiesConvertor.getTimestamp((String)plan.get("receivePayDate")));

		verifyFieldFormat("receivePayAmount", plan.get("receivePayAmount"), "bigdecimal");

		planInfo.setRecievePayAmount(BillProertiesConvertor.getBigDecimal((String)plan.get("receivePayAmount")));

		verifyFieldFormat("receivePayAmountLocal", plan.get("receivePayAmountLocal"), "bigdecimal");

		planInfo.setRecievePayAmountLocal(BillProertiesConvertor.getBigDecimal((String)plan.get("receivePayAmountLocal")));

		if (!(isNull(plan.get("verifyAmout")))) {
			verifyFieldFormat("verifyAmout", plan.get("verifyAmout"), "bigdecimal");
		}
		planInfo.setVerifyAmount(BillProertiesConvertor.getBigDecimal((String)plan.get("verifyAmout")));

		if (!(isNull(plan.get("verifyAmoutLocal")))) {
			verifyFieldFormat("verifyAmoutLocal", plan.get("verifyAmoutLocal"), "bigdecimal");
		}
		planInfo.setVerifyAmountLocal(BillProertiesConvertor.getBigDecimal((String)plan.get("verifyAmoutLocal")));

		planInfo.setRemark((String)plan.get("remark"));
		return planInfo;
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

}