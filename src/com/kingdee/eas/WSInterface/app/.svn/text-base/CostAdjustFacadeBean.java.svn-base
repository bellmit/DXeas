package com.kingdee.eas.WSInterface.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import bsh.This;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.framework.DynamicObjectFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.AccountBankInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
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
import com.kingdee.eas.fi.ar.ArPrintBillEntryInfo;
import com.kingdee.eas.fi.ar.ArPrintBillInfo;
import com.kingdee.eas.fi.ar.app.webservice.util.BillProertiesConvertor;
import com.kingdee.eas.fi.ar.app.webservice.util.BillPropertiesReader;
import com.kingdee.eas.fi.ar.app.webservice.util.WrongArgumentException;
import com.kingdee.eas.fi.cas.ReceivingBillEntryInfo;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.fi.cas.VcStatusEnum;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.scm.cal.CalculateKindEnum;
import com.kingdee.eas.scm.cal.CostAdjustBillCollection;
import com.kingdee.eas.scm.cal.CostAdjustBillEntryCollection;
import com.kingdee.eas.scm.cal.CostAdjustBillEntryInfo;
import com.kingdee.eas.scm.cal.CostAdjustBillFactory;
import com.kingdee.eas.scm.cal.CostAdjustBillInfo;
import com.kingdee.eas.scm.cal.ICostAdjustBill;
import com.kingdee.eas.scm.cal.IssueTypeEnum;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.customize.arap.ExtendsReceiveBillFacadeFactory;
import com.kingdee.eas.scm.customize.arap.IExtendsReceiveBillFacade;
import com.kingdee.util.StringUtils;

/**
 * 成本调整单bean
 * 
 * @author DAD
 * 
 */
public class CostAdjustFacadeBean {
	
	protected String[] submit(Context ctx, String xmlData) throws BOSException {
		Map head;
		List entries;
		CostAdjustBillInfo info;
		cuFilter = null;
		BillPropertiesReader builder = null;
		try {
			builder = new BillPropertiesReader(xmlData, "CostAdjust");
		} catch (WrongArgumentException e) {
			logger.debug("wrong bill type");
			return (new String[] { "N", e.getTypeNumber(), "other", "wrong bill type" });
		} catch (SAXException e) {
			logger.debug(e.getMessage());
			return (new String[] { "N", "1006", "other", e.getMessage() });
		} catch (IOException e) {
			logger.debug(e.getMessage());
			return (new String[] { "N", "1006", "other", e.getMessage() });
		}
		head = builder.getHeadProperties("billHead");
		entries = builder.getEntriesProperties("..billEntries.entry");
		info = new CostAdjustBillInfo();
		if (head == null)
			return (new String[] { "N", "1011", "other", "No head!" });
		try {
			setHead(info, head, ctx);
		} catch (WrongArgumentException e) {
			logger.debug((new StringBuilder()).append(e.getTypeNumber()).append(":head field ").append(e.getField())
					.append(" error").toString());
			return (new String[] { "N", e.getTypeNumber(), "head", e.getField() });
		}
		if (entries.size() == 0)
			return (new String[] { "N", "1009", "other", "no entries" });
		try {
			setEntries(info, entries, ctx);
		} catch (WrongArgumentException e) {
			logger.debug((new StringBuilder()).append(e.getTypeNumber()).append(":entry field ").append(e.getField())
					.append(" error").toString());
			return (new String[] { "N", e.getTypeNumber(), "entry", e.getField() });
		}
		try {
			IExtendsReceiveBillFacade extendFacade = ExtendsReceiveBillFacadeFactory.getLocalInstance(ctx);
			extendFacade.submit(info, xmlData);
		} catch (BOSException e) {
		}
		ICostAdjustBill iCostAdjustBill= CostAdjustBillFactory.getLocalInstance(ctx);
		try {
			iCostAdjustBill.save(info);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return (new String[] { "N", "1006", "other", "error occur when saving bill" });
		}
		return (new String[] { "Y" });
	}

	private void setHead(CostAdjustBillInfo info, Map head, Context ctx) throws WrongArgumentException, BOSException {
		verifyFieldNotNull("CU", head.get("CU"));
		CtrlUnitInfo cu = (CtrlUnitInfo) BillProertiesConvertor.getValueObject(head.get("CU"),
				com.kingdee.eas.basedata.org.CtrlUnitInfo.class, null, ctx);
		info.setCU(cu);
		verifyFieldNotNull("CU", cu);
		if ("yes".equals(head.get("CUNeed")))
			cuFilter = new FilterItemInfo("CU.id", cu.getId(), CompareType.EQUALS);
		info.setBaseStatus(BillBaseStatusEnum.SUBMITED);
		verifyFieldNotNull("creator", head.get("creator"));
		UserInfo creator = (UserInfo) BillProertiesConvertor.getValueObject(head.get("creator"),
				com.kingdee.eas.base.permission.UserInfo.class, null, ctx);
		verifyFieldNotNull("creator", creator);
		info.setCreator(creator);
		verifyFieldFormat("createtime", head.get("createtime"), "date");
		java.sql.Timestamp createTime = BillProertiesConvertor.getTimestamp((String) head.get("createtime"));
		info.setCreateTime(createTime);
		UserInfo lastUpdater = (UserInfo) BillProertiesConvertor.getValueObject(head.get("lastupdateuser"),
				com.kingdee.eas.base.permission.UserInfo.class, cuFilter, ctx);
		info.setLastUpdateUser(lastUpdater);
		if (!isNull(head.get("lastupdatetime")))
			verifyFieldFormat("lastupdatetime", head.get("lastupdatetime"), "date");
		java.sql.Timestamp lastUpdateTime = BillProertiesConvertor.getTimestamp((String) head.get("lastupdatetime"));
		info.setLastUpdateTime(lastUpdateTime);
		verifyFieldNotNull("number", head.get("number"));
		info.setNumber((String) head.get("number"));
		verifyFieldFormat("bizdate", head.get("bizdate"), "date");
		java.sql.Timestamp bizDate = BillProertiesConvertor.getTimestamp((String) head.get("bizdate"));
		info.setBizDate(bizDate);
		UserInfo handler = (UserInfo) BillProertiesConvertor.getValueObject(head.get("handler"),
				com.kingdee.eas.base.permission.UserInfo.class, cuFilter, ctx);
		info.setHandler(handler);
		info.setDescription((String) head.get("description"));
		boolean hasEffected = BillProertiesConvertor.getBool((String) head.get("haseffected"));
		info.setHasEffected(hasEffected);
		UserInfo auditor = (UserInfo) BillProertiesConvertor.getValueObject(head.get("auditor"),
				com.kingdee.eas.base.permission.UserInfo.class, cuFilter, ctx);
		info.setAuditor(auditor);
		
		info.setSourceBillId((String) head.get("sourcebillid"));
		info.setSourceFunction((String) head.get("sourcefunction"));
		
		if (isNull(head.get("customer"))&&isNull(head.get("supplier")))
			throw new WrongArgumentException("cutomer or supplier", "1005");
		//verifyFieldNotNull("customer", head.get("customer"));
		CustomerInfo cusInfo = (CustomerInfo) BillProertiesConvertor.getValueObject(head.get("customer"),CustomerInfo.class, null, ctx);
		info.setCustomer(cusInfo);
		
		//verifyFieldNotNull("supplier", head.get("supplier"));
		SupplierInfo supInfo = (SupplierInfo) BillProertiesConvertor.getValueObject(head.get("supplier"),SupplierInfo.class, null, ctx);
		info.setSupplier(supInfo);
		
		verifyFieldNotNull("bizType", head.get("bizType"));
		info.setCalculateKind(head.get("bizType").toString().trim()=="1"?CalculateKindEnum.INPUT_WAREHOUSE:CalculateKindEnum.OUTPUT_WAREHOUSE);
		
		verifyFieldNotNull("storageOrgUnit", head.get("storageOrgUnit"));
		StorageOrgUnitInfo storageInfo = (StorageOrgUnitInfo) BillProertiesConvertor.getValueObject(head.get("storageOrgUnit"),StorageOrgUnitInfo.class, null, ctx);
		info.setStorageOrgUnit(storageInfo);
		
		info.setIssueType(IssueTypeEnum.NULL);
		
		verifyFieldNotNull("adminOrgUnit", head.get("adminOrgUnit"));
		AdminOrgUnitInfo adminInfo = (AdminOrgUnitInfo) BillProertiesConvertor.getValueObject(head.get("adminOrgUnit"),AdminOrgUnitInfo.class, null, ctx);
		info.setAdminOrgUnit(adminInfo);
		
		verifyFieldNotNull("costCenterOrgUnit", head.get("costCenterOrgUnit"));
		CostCenterOrgUnitInfo costInfo = (CostCenterOrgUnitInfo) BillProertiesConvertor.getValueObject(head.get("costCenterOrgUnit"),CostCenterOrgUnitInfo.class, null, ctx);
		info.setCostCenterOrgUnit(costInfo);
		
	}

	private void setEntries(CostAdjustBillInfo info, List entries, Context ctx) throws WrongArgumentException,
			BOSException {
		CostAdjustBillEntryCollection entryCollection=  (CostAdjustBillEntryCollection) info.getEntries();
		CostAdjustBillEntryInfo entryInfo;
		for (Iterator it = entries.listIterator(); it.hasNext(); entryCollection.add(entryInfo)) {
			Map entry = (Map) it.next();
			entryInfo = getEntryInfo(entry, ctx);
		}
	}

	private CostAdjustBillEntryInfo getEntryInfo(Map entry, Context ctx) throws WrongArgumentException, BOSException {
		CostAdjustBillEntryInfo entryInfo = new CostAdjustBillEntryInfo();
		verifyFieldFormat("seq", entry.get("seq"), "int");
		entryInfo.setSeq(BillProertiesConvertor.getInt((String) entry.get("seq")));
		verifyFieldFormat("amount", entry.get("amount"), "bigdecimal");
		entryInfo.setAmount(BillProertiesConvertor.getBigDecimal((String) entry.get("amount")));
		if (!isNull(entry.get("price")))
			verifyFieldFormat("price", entry.get("price"), "bigdecimal");
		entryInfo.setPrice(BillProertiesConvertor.getBigDecimal((String) entry.get("price")));
		verifyFieldFormat("qty", entry.get("qty"), "bigdecimal");
		entryInfo.setQty(BillProertiesConvertor.getBigDecimal((String) entry.get("qty")));
		/*if (!isNull(entry.get("localamtvc")))
			verifyFieldFormat("localamtvc", entry.get("localamtvc"), "bigdecimal");
		entryInfo.setLocalAmtVc(BillProertiesConvertor.getBigDecimal((String) entry.get("localamtvc")));*/
		verifyFieldNotNull("costObject", entry.get("costObject"));
		CostObjectInfo costInfo = (CostObjectInfo) BillProertiesConvertor.getValueObject(entry.get("costObject"),CostObjectInfo.class, null, ctx);
		entryInfo.setCostObject(costInfo);
		
		verifyFieldNotNull("material", entry.get("material"));
		MaterialInfo materialInfo = (MaterialInfo) BillProertiesConvertor.getValueObject(entry.get("material"),MaterialInfo.class, null, ctx);
		entryInfo.setMaterial(materialInfo);
		
		verifyFieldNotNull("unit", entry.get("unit"));
		MeasureUnitInfo unitInfo = (MeasureUnitInfo) BillProertiesConvertor.getValueObject(entry.get("material"),MeasureUnitInfo.class, null, ctx);
		entryInfo.setBaseUnit(unitInfo);
		
		
		
		return entryInfo;
	}

	private void verifyFieldFormat(String name, Object value, String dataType) throws WrongArgumentException {
		verifyFieldNotNull(name, value);
		if (dataType.equals("int")) {
			String intString = (String) value;
			if (!Pattern.matches("[+|-]?\\d+", intString))
				throw new WrongArgumentException(name, "1002");
		} else if (dataType.equals("bigdecimal")) {
			String bigDecimalStirng = (String) value;
			if (!Pattern.matches("[-|+]?\\d+(.\\d+)?(e[-|+]\\d+)?", bigDecimalStirng))
				throw new WrongArgumentException(name, "1004");
		} else if (dataType.equals("date")) {
			String dateString = (String) value;
			if (!Pattern.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", dateString))
				throw new WrongArgumentException(name, "1001");
		} else if (dataType.equals("bool") && !value.equals("true") && !value.equals("false"))
			throw new WrongArgumentException(name, "1003");
	}

	private void verifyFieldNotNull(String name, Object value) throws WrongArgumentException {
		if (isNull(value))
			throw new WrongArgumentException(name, "1005");
		else
			return;
	}

	public static IObjectValue getValueObject(Object propertyValue, Class z, FilterItemInfo cuFilter, Context ctx)
			throws BOSException {
		if (propertyValue == null || propertyValue.equals(""))
			return null;
		EntityViewInfo viewInfo = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		if (cuFilter != null)
			filter.getFilterItems().add(cuFilter);
		FilterItemInfo billidFilter = new FilterItemInfo("number", propertyValue, CompareType.INCLUDE);
		filter.getFilterItems().add(billidFilter);
		viewInfo.setFilter(filter);
		ICoreBase coreBase = (ICoreBase) BOSObjectFactory.createBOSObject(ctx, getBOSType(z));
		CoreBaseCollection info = coreBase.getCollection(viewInfo.toString());
		if (info != null)
			return info.get(0);
		else
			return null;
	}

	private static BOSObjectType getBOSType(Class z) {
		HashMap bosTypeMap = new HashMap();
		BOSObjectType type = (BOSObjectType) bosTypeMap.get(z.getName());
		if (type != null)
			return type;
		IObjectValue info;
		try {
			info = (IObjectValue) z.newInstance();
			bosTypeMap.put(z.getName(), info.getBOSType());
			return info.getBOSType();
		} catch (Exception e) {
			return null;
		}
	}

	private boolean isNull(Object o) {
		if (o == null)
			return true;
		if (o instanceof String)
			return o.equals("");
		else
			return false;
	}

	private static Logger logger = Logger.getLogger(This.class.toString());
	public FilterItemInfo cuFilter;
}
