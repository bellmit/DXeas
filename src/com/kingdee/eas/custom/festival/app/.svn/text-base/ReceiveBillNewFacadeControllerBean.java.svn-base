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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.AccountBankInfo;
import com.kingdee.eas.basedata.assistant.BankFactory;
import com.kingdee.eas.basedata.assistant.BankInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.IBank;
import com.kingdee.eas.basedata.assistant.ProjectInfo;
import com.kingdee.eas.basedata.assistant.SettlementTypeInfo;
import com.kingdee.eas.basedata.master.account.AccountViewFactory;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.master.account.IAccountView;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnit;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.ProfitCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.ar.ArPrintBillEntryInfo;
import com.kingdee.eas.fi.ar.ArPrintBillInfo;
import com.kingdee.eas.fi.ar.app.webservice.util.BillProertiesConvertor;
import com.kingdee.eas.fi.ar.app.webservice.util.BillPropertiesReader;
import com.kingdee.eas.fi.ar.app.webservice.util.WrongArgumentException;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.fi.cas.BizTypeEnum;
import com.kingdee.eas.fi.cas.FeeTypeInfo;
import com.kingdee.eas.fi.cas.IReceivingBill;
import com.kingdee.eas.fi.cas.ReceivingBillCollection;
import com.kingdee.eas.fi.cas.ReceivingBillEntryCollection;
import com.kingdee.eas.fi.cas.ReceivingBillEntryInfo;
import com.kingdee.eas.fi.cas.ReceivingBillFactory;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.fi.cas.ReceivingBillTypeInfo;
import com.kingdee.eas.fi.cas.SettlementStatusEnum;
import com.kingdee.eas.fi.cas.SourceTypeEnum;
import com.kingdee.eas.fi.cas.VcStatusEnum;
import com.kingdee.eas.fm.fs.InnerAccountInfo;
import com.kingdee.eas.fm.fs.SettBizTypeEnum;
import com.kingdee.eas.fm.nt.ReceiptBillInfo;
import com.kingdee.eas.ma.crbg.ReceiveBill;
import com.kingdee.eas.scm.customize.arap.ExtendsReceiveBillFacadeFactory;
import com.kingdee.eas.scm.customize.arap.IExtendsReceiveBillFacade;
import com.kingdee.eas.scm.im.inv.SaleIssueBillCollection;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.ws.ImportException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

import java.io.IOException;
import java.lang.String;

public class ReceiveBillNewFacadeControllerBean extends AbstractReceiveBillNewFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.festival.app.ReceiveBillNewFacadeControllerBean");

	private static final long serialVersionUID = -5021536429854210236L;
	private FilterItemInfo cuFilter;




















	protected String[] _submit(Context ctx, String xmlData)
	throws BOSException
	{
		this.cuFilter = null;


		BillPropertiesReader builder = null;
		try {
			builder = new BillPropertiesReader(xmlData, "ReceivingBill");
		} catch (WrongArgumentException e) {
			logger.debug("wrong bill type");
			return new String[] { "N", e.getTypeNumber(), "other", "wrong bill type" };
		}
		catch (SAXException e) {
			logger.debug(e.getMessage());
			return new String[] { "N", "1006", "other", e.getMessage() };
		}
		catch (IOException e)
		{
			logger.debug(e.getMessage());
			return new String[] { "N", "1006", "other", e.getMessage() };

		}

		Map head = builder.getHeadProperties("billHead");
		List entries = builder.getEntriesProperties("//billEntries/entry");


		ReceivingBillInfo info = new ReceivingBillInfo();
		try {
			if (head == null) {
				return new String[] { "N", "1011", "other", "No head!" };
			}
			setHead(info, head, ctx);
			if(!StringUtils.isEmpty(info.getNumber())){
				ReceivingBillCollection coll = ReceivingBillFactory.getLocalInstance(ctx).getReceivingBillCollection("where number='"+info.getNumber()+"'");
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
			IExtendsReceiveBillFacade extendFacade = ExtendsReceiveBillFacadeFactory.getLocalInstance(ctx);

			extendFacade.submit(info, xmlData);
		}
		catch (BOSException e)
		{
		}

		IReceivingBill iReceivingBill = ReceivingBillFactory.getLocalInstance(ctx);
		try
		{
			iReceivingBill.save(info);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return new String[] { "N", "1006", "other", "error occur when saving bill" };



		}

		return new String[] { "Y" };
	}















	private void setHead(ReceivingBillInfo info, Map head, Context ctx)
	throws WrongArgumentException, BOSException
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
		UserInfo creator = (UserInfo)BillProertiesConvertor.getValueObject(head.get("creator"), UserInfo.class, null, ctx);

		verifyFieldNotNull("creator", creator);
		info.setCreator(creator);

		verifyFieldFormat("createtime", head.get("createtime"), "date");
		Timestamp createTime = BillProertiesConvertor.getTimestamp((String)head.get("createtime"));

		info.setCreateTime(createTime);

		UserInfo lastUpdater = (UserInfo)BillProertiesConvertor.getValueObject(head.get("lastupdateuser"), UserInfo.class, (FilterItemInfo) this.cuFilter, ctx);


		info.setLastUpdateUser(lastUpdater);

		if (!(isNull(head.get("lastupdatetime")))) {
			verifyFieldFormat("lastupdatetime", head.get("lastupdatetime"), "date");
		}
		Timestamp lastUpdateTime = BillProertiesConvertor.getTimestamp((String)head.get("lastupdatetime"));

		info.setLastUpdateTime(lastUpdateTime);

		verifyFieldNotNull("number", head.get("number"));
		info.setNumber((String)head.get("number"));


		verifyFieldFormat("bizdate", head.get("bizdate"), "date");
		Timestamp bizDate = BillProertiesConvertor.getTimestamp((String)head.get("bizdate"));

		info.setBizDate(bizDate);

		UserInfo handler = (UserInfo)BillProertiesConvertor.getValueObject(head.get("handler"), UserInfo.class, (FilterItemInfo) this.cuFilter, ctx);

		info.setHandler(handler);

		info.setDescription((String)head.get("description"));

		boolean hasEffected = BillProertiesConvertor.getBool((String)head.get("haseffected"));

		info.setHasEffected(hasEffected);

		UserInfo auditor = (UserInfo)BillProertiesConvertor.getValueObject(head.get("auditor"), UserInfo.class, this.cuFilter, ctx);

		info.setAuditor(auditor);

		info.setSourceBillId((String)head.get("sourcebillid"));

		info.setSourceFunction((String)head.get("sourcefunction"));

		verifyFieldNotNull("company", head.get("company"));
		CompanyOrgUnitInfo comInfo = (CompanyOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("company"), CompanyOrgUnitInfo.class, this.cuFilter, ctx);


		verifyFieldNotNull("company", comInfo);
		info.setCompany(comInfo);

		verifyFieldFormat("sourcesystype", head.get("sourcesystype"), "int");
		SourceTypeEnum sourcesystype = SourceTypeEnum.getEnum(BillProertiesConvertor.getInt((String)head.get("sourcesystype")));


		verifyFieldNotNull("sourcesystype", sourcesystype);
		info.setSourceSysType(sourcesystype);

		verifyFieldFormat("sourcetype", head.get("sourcetype"), "int");
		SourceTypeEnum sourceType = SourceTypeEnum.getEnum(BillProertiesConvertor.getInt((String)head.get("sourcetype")));


		verifyFieldNotNull("sourcetype", sourceType);
		info.setSourceType(sourceType);

		verifyFieldNotNull("currency", head.get("currency"));
		CurrencyInfo currency = (CurrencyInfo)BillProertiesConvertor.getValueObject(head.get("currency"), CurrencyInfo.class, null, ctx);


		verifyFieldNotNull("currency", currency);
		info.setCurrency(currency);

		if(head.get("costCenter")!=null){
			CostCenterOrgUnitInfo costCenter = (CostCenterOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("costCenter"), CostCenterOrgUnitInfo.class, null, ctx);

			if(costCenter!=null)
				info.setCostCenter(costCenter);
		}

		verifyFieldFormat("exchangerate", head.get("exchangerate"), "bigdecimal");

		info.setExchangeRate(BillProertiesConvertor.getBigDecimal((String)head.get("exchangerate")));


		if (!(isNull(head.get("isexchanged"))))
			verifyFieldFormat("isexchanged", head.get("isexchanged"), "bool");
		info.setIsExchanged(BillProertiesConvertor.getBool((String)head.get("isexchanged")));


		if (!(isNull(head.get("lastexhangerate")))) {
			verifyFieldFormat("lastexhangerate", head.get("lastexhangerate"), "bigdecimal");
		}
		info.setLastExhangeRate(BillProertiesConvertor.getBigDecimal((String)head.get("lastexhangerate")));


		SettlementTypeInfo settlementType = (SettlementTypeInfo)BillProertiesConvertor.getValueObject(head.get("settlementtype"), SettlementTypeInfo.class, null, ctx);


		info.setSettlementType(settlementType);

		info.setSettlementNumber((String)head.get("settlementnumber"));

		AccountViewInfo oppAccount = (AccountViewInfo)BillProertiesConvertor.getValueObject(head.get("oppaccount"), AccountViewInfo.class, this.cuFilter, ctx);


		info.setOppAccount(oppAccount);

		if (!(isNull(head.get("iscommitsettle")))) {
			verifyFieldFormat("iscommitsettle", head.get("iscommitsettle"), "bool");
		}
		info.setIsCommitSettle(BillProertiesConvertor.getBool((String)head.get("iscommitsettle")));


		if (!(isNull(head.get("settlebiztype"))))
			verifyFieldFormat("settlebiztype", head.get("settlebiztype"), "int");
		SettBizTypeEnum settlebiztype = SettBizTypeEnum.getEnum(BillProertiesConvertor.getInt((String)head.get("settlebiztype")));


		if (settlebiztype != null) {
			info.setSettleBizType(settlebiztype);
		}
		if (!(isNull(head.get("auditdate"))))
			verifyFieldFormat("auditdate", head.get("auditdate"), "date");
		info.setAuditDate(BillProertiesConvertor.getTimestamp((String)head.get("auditdate")));


		UserInfo cashier = (UserInfo)BillProertiesConvertor.getValueObject(head.get("cashier"), UserInfo.class, this.cuFilter, ctx);

		info.setCashier(cashier);

		UserInfo accountant = (UserInfo)BillProertiesConvertor.getValueObject(head.get("accountant"), UserInfo.class, this.cuFilter, ctx);

		info.setAccountant(accountant);

		if (!(isNull(head.get("isinitializebill")))) {
			verifyFieldFormat("isinitializebill", head.get("isinitializebill"), "bool");
		}
		info.setIsInitializeBill(BillProertiesConvertor.getBool((String)head.get("isinitializebill")));


		info.setFiVouchered(false);

		if (!(isNull(head.get("settlementstatus")))) {
			verifyFieldFormat("settlementstatus", head.get("settlementstatus"), "int");
		}
		SettlementStatusEnum settlementstatus = SettlementStatusEnum.getEnum(BillProertiesConvertor.getInt((String)head.get("settlementstatus")));


		if (settlementstatus != null) {
			info.setSettlementStatus(settlementstatus);
		}
		verifyFieldFormat("fundtype", head.get("fundtype"), "int");
		BizTypeEnum fundtype = BizTypeEnum.getEnum(BillProertiesConvertor.getInt((String)head.get("fundtype")));

		verifyFieldNotNull("fundtype", fundtype);
		info.setFundType(fundtype);

		if (!(isNull(head.get("isimport"))))
			verifyFieldFormat("isimport", head.get("isimport"), "bool");
		info.setIsImport(BillProertiesConvertor.getBool((String)head.get("isimport")));


		if (!(isNull(head.get("amount"))))
			verifyFieldFormat("amount", head.get("amount"), "bigdecimal");
		info.setAmount(BillProertiesConvertor.getBigDecimal((String)head.get("amount")));


		if (!(isNull(head.get("localamt"))))
			verifyFieldFormat("localamt", head.get("localamt"), "bigdecimal");
		info.setLocalAmt(BillProertiesConvertor.getBigDecimal((String)head.get("localamt")));


		AdminOrgUnitInfo adminOrgUnit = (AdminOrgUnitInfo)BillProertiesConvertor.getValueObject(head.get("adminorgunit"), AdminOrgUnitInfo.class, null, ctx);


		info.setAdminOrgUnit(adminOrgUnit);

		PersonInfo person = (PersonInfo)BillProertiesConvertor.getValueObject(head.get("person"), PersonInfo.class, null, ctx);

		info.setPerson(person);

		if (!(isNull(head.get("accessoryamt"))))
			verifyFieldFormat("accessoryamt", head.get("accessoryamt"), "int");
		info.setAccessoryAmt(BillProertiesConvertor.getInt((String)head.get("accessoryamt")));


		info.setConceit((String)head.get("conceit"));

		info.setSummary((String)head.get("summary"));



		info.setContractNo((String)head.get("contractno"));

		if (!(isNull(head.get("dayaccount")))) {
			verifyFieldFormat("dayaccount", head.get("dayaccount"), "bigdecimal");
		}
		info.setDayaccount(BillProertiesConvertor.getBigDecimal((String)head.get("dayaccount")));


		info.setCapitalAmount((String)head.get("capitalamount"));













		info.setContractBillId((String)head.get("contractbillid"));

		FeeTypeInfo feeType = (FeeTypeInfo)BillProertiesConvertor.getValueObject(head.get("feetype"), FeeTypeInfo.class, null, ctx);

		info.setFeeType(feeType);

		ProjectInfo project = (ProjectInfo)BillProertiesConvertor.getValueObject(head.get("project"), ProjectInfo.class, this.cuFilter, ctx);


		info.setProject(project);

		PersonInfo projectManager = (PersonInfo)BillProertiesConvertor.getValueObject(head.get("projectmanager"), PersonInfo.class, this.cuFilter, ctx);


		info.setProjectManager(projectManager);


		ReceivingBillTypeInfo recType = (ReceivingBillTypeInfo)BillProertiesConvertor.getValueObject(head.get("rectype"), ReceivingBillTypeInfo.class, null, ctx);

		verifyFieldNotNull("rectype", recType);
		info.setRecBillType(recType);

		if (!(isNull(head.get("actrecamt"))))
			verifyFieldFormat("actrecamt", head.get("actrecamt"), "bigdecimla");
		info.setActRecAmt(BillProertiesConvertor.getBigDecimal((String)head.get("actrecamt")));


		if (!(isNull(head.get("actrecamtvc")))) {
			verifyFieldFormat("actrecamtvc", head.get("actrecamtvc"), "bigdecimla");
		}
		info.setActRecAmtVc(BillProertiesConvertor.getBigDecimal((String)head.get("actrecamtvc")));


		if (!(isNull(head.get("actreclocamt")))) {
			verifyFieldFormat("actreclocamt", head.get("actreclocamt"), "bigdecimla");
		}
		info.setActRecLocAmt(BillProertiesConvertor.getBigDecimal((String)head.get("actreclocamt")));


		if (!(isNull(head.get("actreclocamtvc")))) {
			verifyFieldFormat("actreclocamtvc", head.get("actreclocamtvc"), "bigdecimla");
		}
		info.setActRecAmtVc(BillProertiesConvertor.getBigDecimal((String)head.get("actreclocamtvc")));




		FilterItemInfo companyQueryFilter = new FilterItemInfo("company.id", info.getCompany().getId(), CompareType.EQUALS);
		AccountBankInfo payeeaccountbank = (AccountBankInfo)BillProertiesConvertor.getValueObject(head.get("payeeaccountbank"), AccountBankInfo.class, companyQueryFilter, ctx);


		info.setPayeeAccountBank(payeeaccountbank);


		BankInfo payeeBank = (BankInfo)BillProertiesConvertor.getValueObject(head.get("payeebank"), BankInfo.class, null, ctx);

		if (payeeBank != null) {
			info.setPayeeBank(payeeBank);
		} else if ((payeeaccountbank != null) && (payeeaccountbank.getBank() != null) && (payeeaccountbank.getBank().getId() != null)) {
			String bankId = payeeaccountbank.getBank().getId().toString();
			IBank iBank = null;
			if (ctx != null)
				iBank = BankFactory.getLocalInstance(ctx);
			else
				iBank = BankFactory.getRemoteInstance();
			try
			{
				payeeBank = iBank.getBankInfo(new ObjectUuidPK(bankId));
			}
			catch (EASBizException e) {
				logger.error(e);
			}
			info.setPayeeBank(payeeBank);

		}

		AccountViewInfo payeeaccount = (AccountViewInfo)BillProertiesConvertor.getValueObject(head.get("payeeaccount"), AccountViewInfo.class, new FilterItemInfo("CU.id", info.getCU().getId(), CompareType.EQUALS), ctx);



		if (payeeaccount != null) {
			info.setPayeeAccount(payeeaccount);
		} else if ((payeeaccountbank != null) && (payeeaccountbank.getAccount() != null) && (payeeaccountbank.getAccount().getId() != null)) {
			String accountId = payeeaccountbank.getAccount().getId().toString();
			IAccountView iAccountView = null;
			if (ctx != null)
				iAccountView = AccountViewFactory.getLocalInstance(ctx);
			else
				iAccountView = AccountViewFactory.getRemoteInstance();
			try
			{
				payeeaccount = iAccountView.getAccountViewInfo(new ObjectUuidPK(accountId));
			}
			catch (EASBizException e) {
				logger.error(e);
			}
			info.setPayeeAccount(payeeaccount);

		}

		verifyFieldNotNull("payertype", head.get("payertype"));
		AsstActTypeInfo payertype = (AsstActTypeInfo)BillProertiesConvertor.getValueObject(head.get("payertype"), AsstActTypeInfo.class, null, ctx);


		verifyFieldNotNull("payertype", payertype);
		info.setPayerType(payertype);

		setAsstActor(ctx, info, head, payertype);

		info.setPayerBank((String)head.get("payerbank"));

		info.setPayerAccountBank((String)head.get("payeraccountbank"));

		info.setRecDate(info.getBizDate());

		if (!(isNull(head.get("isrelatereceipt")))) {
			verifyFieldFormat("isrelatereceipt", head.get("isrelatereceipt"), "bool");
		}
		info.setIsRelateReceipt(BillProertiesConvertor.getBool((String)head.get("isrelatereceipt")));


		ReceiptBillInfo receipt = (ReceiptBillInfo)BillProertiesConvertor.getValueObject(head.get("receipt"), ReceiptBillInfo.class, this.cuFilter, ctx);


		info.setReceipt(receipt);

		InnerAccountInfo oppinneracct = (InnerAccountInfo)BillProertiesConvertor.getValueObject(head.get("oppinneracct"), InnerAccountInfo.class, this.cuFilter, ctx);


		info.setOppInnerAcct(oppinneracct);
	}














	private void setAsstActor(Context ctx, ReceivingBillInfo info, Map head, AsstActTypeInfo asstActTypeInfo)
	throws BOSException, WrongArgumentException
	{
		verifyFieldNotNull("payernumber", head.get("payernumber"));
		info.setPayerNumber((String)head.get("payernumber"));







		EntityViewInfo evInfo = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number", head.get("payernumber"), CompareType.EQUALS));




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

				info.setPayerID(objVal.getString("id"));
				info.setPayerName(objVal.getString("name"));
				info.setPayerNumber(objVal.getString("number"));
			}
		} catch (BOSException e) {
			throw new WrongArgumentException("payernumber", "1005");
		}
	}
















	private void setEntries(ReceivingBillInfo info, List entries, Context ctx)
	throws WrongArgumentException, BOSException
	{
		ReceivingBillEntryCollection entryCollection = info.getEntries();
		Iterator it = entries.listIterator();
		while (it.hasNext()) {
			Map entry = (Map)it.next();
			ReceivingBillEntryInfo entryInfo = getEntryInfo(entry, ctx);
			entryInfo.setRecBillType(info.getRecBillType());
			entryCollection.add(entryInfo);
		}
	}











	private ReceivingBillEntryInfo getEntryInfo(Map entry, Context ctx)
	throws WrongArgumentException, BOSException
	{
		ReceivingBillEntryInfo entryInfo = new ReceivingBillEntryInfo();

		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String)entry.get("seq")));


		verifyFieldFormat("amount", entry.get("amount"), "bigdecimal");
		entryInfo.setAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("amount")));


		if (!(isNull(entry.get("amountvc"))))
			verifyFieldFormat("amountvc", entry.get("amountvc"), "bigdecimal");
		entryInfo.setAmountVc(BillProertiesConvertor.getBigDecimal((String)entry.get("amountvc")));


		verifyFieldFormat("localamt", entry.get("localamt"), "bigdecimal");
		entryInfo.setLocalAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("localamt")));


		if (!(isNull(entry.get("localamtvc")))) {
			verifyFieldFormat("localamtvc", entry.get("localamtvc"), "bigdecimal");
		}
		entryInfo.setLocalAmtVc(BillProertiesConvertor.getBigDecimal((String)entry.get("localamtvc")));


		if (!(isNull(entry.get("unvcamount")))) {
			verifyFieldFormat("unvcamount", entry.get("unvcamount"), "bigdecimal");
		}
		entryInfo.setUnVcAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("unvcamount")));


		if (!(isNull(entry.get("unvclocamount")))) {
			verifyFieldFormat("unvclocamount", entry.get("unvclocamount"), "bigdecimal");
		}
		entryInfo.setHisUnVcLocAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("unvclocamount")));


		if (!(isNull(entry.get("unverifyexgrateloc")))) {
			verifyFieldFormat("unverifyexgrateloc", entry.get("unverifyexgrateloc"), "bigdecimal");
		}
		entryInfo.setUnVerifyExgRateLoc(BillProertiesConvertor.getBigDecimal((String)entry.get("unverifyexgrateloc")));


		if (!(isNull(entry.get("rebate"))))
			verifyFieldFormat("rebate", entry.get("rebate"), "bigdecimal");
		entryInfo.setRebate(BillProertiesConvertor.getBigDecimal((String)entry.get("rebate")));


		if (!(isNull(entry.get("rebateamtvc")))) {
			verifyFieldFormat("rebateamtvc", entry.get("rebateamtvc"), "bigdecimal");
		}
		entryInfo.setRebateAmtVc(BillProertiesConvertor.getBigDecimal((String)entry.get("rebateamtvc")));


		if (!(isNull(entry.get("rebatelocamt")))) {
			verifyFieldFormat("rebatelocamt", entry.get("rebatelocamt"), "bigdecimal");
		}
		entryInfo.setRebateLocAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("rebatelocamt")));


		if (!(isNull(entry.get("rebatelocamtvc")))) {
			verifyFieldFormat("rebatelocamtvc", entry.get("rebatelocamtvc"), "bigdecimal");
		}
		entryInfo.setRebateLocAmtVc(BillProertiesConvertor.getBigDecimal((String)entry.get("rebatelocamtvc")));


		verifyFieldFormat("actualamt", entry.get("actualamt"), "bigdecimal");
		entryInfo.setActualAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("actualamt")));


		if (!(isNull(entry.get("actualamtvc")))) {
			verifyFieldFormat("actualamtvc", entry.get("actualamtvc"), "bigdecimal");
		}
		entryInfo.setActualAmtVc(BillProertiesConvertor.getBigDecimal((String)entry.get("actualamtvc")));


		verifyFieldFormat("actuallocamt", entry.get("actuallocamt"), "bigdecimal");

		entryInfo.setActualLocAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("actuallocamt")));


		if (!(isNull(entry.get("actuallocamtvc")))) {
			verifyFieldFormat("actuallocamtvc", entry.get("actuallocamtvc"), "bigdecimal");
		}
		entryInfo.setActualLocAmtVc(BillProertiesConvertor.getBigDecimal((String)entry.get("actuallocamtvc")));


		entryInfo.setRemark((String)entry.get("remark"));

		if (!(isNull(entry.get("lockamt"))))
			verifyFieldFormat("lockamt", entry.get("lockamt"), "bigdecimal");
		entryInfo.setLockAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("lockamt")));


		if (!(isNull(entry.get("locklocamt")))) {
			verifyFieldFormat("locklocamt", entry.get("locklocamt"), "bigdecimal");
		}
		entryInfo.setLockLocAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("locklocamt")));


		if (!(isNull(entry.get("unlockamt"))))
			verifyFieldFormat("unlockamt", entry.get("unlockamt"), "bigdecimal");
		entryInfo.setUnLockAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("unlockamt")));


		if (!(isNull(entry.get("unlocklocamt")))) {
			verifyFieldFormat("unlocklocamt", entry.get("unlocklocamt"), "bigdecimal");
		}
		entryInfo.setUnLockLocAmt(BillProertiesConvertor.getBigDecimal((String)entry.get("unlocklocamt")));


		entryInfo.setSourceBillId((String)entry.get("sourcebillid"));

		entryInfo.setSourceBillEntryId((String)entry.get("sourcebillentryid"));

		if (!(isNull(entry.get("vcstatus"))))
			verifyFieldFormat("vcstatus", entry.get("vcstatus"), "int");
		VcStatusEnum vcstatus = VcStatusEnum.getEnum(BillProertiesConvertor.getInt((String)entry.get("vcstatus")));

		if (vcstatus != null) {
			entryInfo.setVcStatus(vcstatus);
		}
		if (!(isNull(entry.get("hisunvcamount")))) {
			verifyFieldFormat("hisunvcamount", entry.get("hisunvcamount"), "bigdecimal");
		}
		entryInfo.setHisUnVcAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("hisunvcamount")));


		if (!(isNull(entry.get("hisunvclocamount")))) {
			verifyFieldFormat("hisunvclocamount", entry.get("hisunvclocamount"), "bigdecimal");
		}
		entryInfo.setHisUnVcLocAmount(BillProertiesConvertor.getBigDecimal((String)entry.get("hisunvclocamount")));


		BillTypeInfo corebilltype = (BillTypeInfo)BillProertiesConvertor.getValueObject(entry.get("corebilltype"), BillTypeInfo.class, this.cuFilter, ctx);


		entryInfo.setCoreBillType(corebilltype);

		entryInfo.setCoreBillId((String)entry.get("corebillid"));

		entryInfo.setCoreBillEntryId((String)entry.get("corebillentryid"));

		entryInfo.setCoreBillNumber((String)entry.get("corebillnumber"));

		if (!(isNull(entry.get("corebillentryseq")))) {
			verifyFieldFormat("corebillentryseq", entry.get("corebillentryseq"), "int");
		}
		entryInfo.setCoreBillEntrySeq(BillProertiesConvertor.getInt((String)entry.get("corebillentryseq")));


		entryInfo.setTrackNumbet((String)entry.get("tracknumbet"));

		CurrencyInfo currency = (CurrencyInfo)BillProertiesConvertor.getValueObject(entry.get("currency"), CurrencyInfo.class, this.cuFilter, ctx);


		entryInfo.setCurrency(currency);

		if (!(isNull(entry.get("bizdate"))))
			verifyFieldFormat("bizdate", entry.get("bizdate"), "date");
		entryInfo.setBizDate(BillProertiesConvertor.getTimestamp((String)entry.get("bizdate")));


		entryInfo.setBizBillNumber((String)entry.get("bizbillnumber"));

		entryInfo.setCustomerBillNum((String)entry.get("customerbillnum"));

		entryInfo.setReceiptNumber((String)entry.get("receiptnumber"));

		ArPrintBillInfo arprintbill = (ArPrintBillInfo)BillProertiesConvertor.getValueObject(entry.get("arprintbill"), ArPrintBillInfo.class, this.cuFilter, ctx);

		if(arprintbill!=null&&arprintbill.getId()!=null)
			entryInfo.setArPrintBill(String.valueOf(arprintbill.getId()));

		ArPrintBillEntryInfo arprintbillentry = (ArPrintBillEntryInfo)BillProertiesConvertor.getValueObject(entry.get("arprintbillentry"), ArPrintBillEntryInfo.class, this.cuFilter, ctx);

		if(arprintbillentry!=null&&arprintbillentry.getId()!=null)
			entryInfo.setArPrintBillEntry(String.valueOf(arprintbillentry.getId()));
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

}