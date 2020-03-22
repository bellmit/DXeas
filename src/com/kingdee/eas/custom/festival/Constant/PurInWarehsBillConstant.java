package com.kingdee.eas.custom.festival.Constant;

public class PurInWarehsBillConstant {
	public static final String XMLROOTTAGNAME = "PurInWarehsBill";
	public static final String BOSTYPE = "783061E3";
	public static final String ASSOCIATEQTY = "associateQty";
	public static final String IMPUTEDCOST = "imputedCost";
	public static final String TOTALSTANDARDCOST = "totalStandardCost";
	public static final String REMARK = "remark";
	public static final String DREWBASEQTY = "drewBaseQty";
	public static final String ACTUALCOST = "actualCost";
	public static final String MODIFICATIONTIME = "modificationTime";
	public static final String SUPPLIER = "supplier";
	public static final String EXCHANGERATE = "exchangeRate";
	public static final String LASTUPDATEUSER = "lastUpdateUser";
	public static final String TOTALAMOUNT = "totalAmount";
	public static final String UNRETURNEDBASEQTY = "unReturnedBaseQty";
	public static final String ISSYSBILL = "isSysBill";
	public static final String PURORDERNUMBER = "purOrderNumber";
	public static final String COMPANYORGUNIT = "companyOrgUnit";
	public static final String PERIOD = "period";
	public static final String EXP = "exp";
	public static final String LASTUPDATETIME = "lastUpdateTime";
	public static final String TOTALMOVEQTY = "totalMoveQty";
	public static final String ISCENTRALBALANCE = "isCentralBalance";
	public static final String TOTALACTUALCOST = "totalActualCost";
	public static final String STOCKER = "stocker";
	public static final String SOURCEBILLNUMBER = "sourceBillNumber";
	public static final String YEAR = "year";
	public static final String REVERSEBASEQTY = "reverseBaseQty";
	public static final String SOURCEFUNCTION = "sourceFunction";
	public static final String LOCATION = "location";
	public static final String WAREHOUSE = "warehouse";
	public static final String COREBILLTYPE = "coreBillType";
	public static final String RETURNBASEQTY = "returnBaseQty";
	public static final String SOURCEBILLENTRYSEQ = "sourceBillEntrySeq";
	public static final String DREWQTY = "drewQty";
	public static final String TRANSACTIONTYPE = "transactionType";
	public static final String WRITTENOFFBASEQTY = "writtenOffBaseQty";
	public static final String RECEIVEAMOUNT = "receiveAmount";
	public static final String ISPRESENT = "isPresent";
	public static final String LOCALPRICE = "localPrice";
	public static final String TAX = "tax";
	public static final String LOT = "lot";
	public static final String MATERIAL = "material";
	public static final String QTY = "qty";
	public static final String TOTALQTY = "totalQty";
	public static final String BIZDATE = "bizDate";
	public static final String SOURCEBILLID = "sourceBillId";
	public static final String PURCHASEGROUP = "purchaseGroup";
	public static final String UNWRITEOFFBASEQTY = "unWriteOffBaseQty";
	public static final String HANDLER = "handler";
	public static final String STANDARDCOST = "standardCost";
	public static final String RETURNSQTY = "returnsQty";
	public static final String BILLTYPE = "billType";
	public static final String PURORDER = "purOrder";
	public static final String NUMBER = "number";
	public static final String CURRENCY = "currency";
	public static final String UNIT = "unit";
	public static final String PURCHASEORGUNIT = "purchaseOrgUnit";
	public static final String UNWRITEOFFAMOUNT = "unWriteOffAmount";
	public static final String PRICE = "price";
	public static final String ADMINORGUNIT = "adminOrgUnit";
	public static final String MODIFIER = "modifier";
	public static final String AUDITTIME = "auditTime";
	public static final String ASSISTUNIT = "assistUnit";
	public static final String BASEUNIT = "baseUnit";
	public static final String CREATETIME = "createTime";
	public static final String CU = "CU";
	public static final String PAYMENTTYPE = "paymentType";
	public static final String CREATOR = "creator";
	public static final String BIZTYPE = "bizType";
	public static final String TAXRATE = "taxRate";
	public static final String PURORDERENTRYSEQ = "purOrderEntrySeq";
	public static final String CONVERTMODE = "convertMode";
	public static final String BASESTATUS = "baseStatus";
	public static final String REASONCODE = "reasonCode";
	public static final String ASSISTQTY = "assistQty";
	public static final String SEQ = "seq";
	public static final String PURCHASEPERSON = "purchasePerson";
	public static final String PURORDERENTRY = "purOrderEntry";
	public static final String UNITACTUALCOST = "unitActualCost";
	public static final String AUDITOR = "auditor";
	public static final String FIVOUCHERED = "fiVouchered";
	public static final String DESCRIPTION = "description";
	public static final String MFG = "mfg";
	public static final String VOUCHER = "voucher";
	public static final String TAXPRICE = "taxPrice";
	public static final String SOURCEBILLTYPE = "sourceBillType";
	public static final String BASEQTY = "baseQty";
	public static final String ASSCOEFFICIENT = "assCoefficient";
	public static final String WRITTENOFFQTY = "writtenOffQty";
	public static final String RECEIPTAMOUNT = "receiptAmount";
	public static final String REVERSEQTY = "reverseQty";
	public static final String ISREVERSED = "isReversed";
	public static final String ASSISTPROPERTY = "assistProperty";
	public static final String LOCALTAX = "localTax";
	public static final String SOURCEBILLENTRYID = "sourceBillEntryId";
	public static final String UNITSTANDARDCOST = "unitStandardCost";
	public static final String UNWRITEOFFQTY = "unWriteOffQty";
	public static final String LOCALAMOUNT = "localAmount";
	public static final String HASEFFECTED = "hasEffected";
	public static final String STORAGEORGUNIT = "storageOrgUnit";
	public static final String ACTUALPRICE = "actualPrice";
	public static final String WRITTENOFFAMOUNT = "writtenOffAmount";
	public static final String ISINITBILL = "isInitBill";
	public static final String ORDERPRICE = "orderPrice";
	public static final String ISREQUESTTORECEIVED = "isRequestToReceived";
	public static final String AMOUNT = "amount";
	public static final String ISINTAX = "isInTax";
	public static final String ISPRICEINTAX = "isPriceInTax";
	public static final String TAXAMOUNT = "taxAmount";
	public static final String LOCALTAXAMOUNT = "localTaxAmount";
	public static final String MATERIALCOST = "materialCost";
	public static final String PURCHASECOST = "purchaseCost";
	public static final String ACTUALTAXPRICE = "actualTaxPrice";
	public static final String UNITPURCHASECOST = "unitPurchaseCost";
	private static String[] mustValidateHeadProperties = { "creator",
			"createTime", "CU", "number", "bizDate", "handler", "baseStatus",
			"bizType", "billType", "year", "period", "storageOrgUnit",
			"fiVouchered", "isReversed", "transactionType", "isInitBill",
			"isSysBill", "isCentralBalance" };

	private static String[] headBooleanProperties = { "hasEffected",
			"fiVouchered", "isReversed", "isInitBill", "isSysBill",
			"isCentralBalance", "isInTax", "isPriceInTax" };

	private static String[] headintProperties = { "baseStatus", "convertMode",
			"year", "period" };

	private static String[] headDecimalProperties = { "totalQty",
			"totalAmount", "totalStandardCost", "totalActualCost",
			"receiptAmount", "exchangeRate" };

	private static String[] headTimeStampProperties = { "createTime",
			"lastUpdateTime", "auditTime", "modificationTime" };

	private static String[] headDatetProperties = { "bizDate" };

	private static String[] headStrProperties = { "number", "description",
			"sourceBillId", "sourceFunction" };

	private static String[] NOTCUFILTERPROPERTIES = { "transactionType",
			"billType", "currency", "bizType", "supplier" };

	private static String[] headLinkProperties = { "creator", "lastUpdateUser",
			"CU", "handler", "auditor", "bizType", "sourceBillType",
			"billType", "modifier", "storageOrgUnit", "adminOrgUnit",
			"stocker", "voucher", "transactionType", "supplier", "currency",
			"paymentType" };

	private static String[] mustValidateEntryProperties = { "seq", "material",
			"unit", "baseStatus", "baseUnit", "storageOrgUnit",
			"companyOrgUnit", "warehouse", "qty", "baseQty", "isPresent",
			"isRequestToReceived" ,"invUpdateType"};

	private static String[] entryBooleanProperties = { "isPresent",
			"isRequestToReceived" ,"hasSameCou"};

	private static String[] entryintProperties = { "baseStatus", "seq",
			"sourceBillEntrySeq", "purOrderEntrySeq" };

	private static String[] entryDecimalProperties = { "unitPurchaseCost",
			"actualTaxPrice", "purchaseCost", "materialCost", "assCoefficient",
			"associateQty", "qty", "assistQty", "baseQty", "reverseQty",
			"returnsQty", "price", "amount", "unitStandardCost",
			"standardCost", "unitActualCost", "actualCost", "reverseBaseQty",
			"returnBaseQty", "writtenOffQty", "writtenOffAmount",
			"unWriteOffQty", "unWriteOffAmount", "receiveAmount", "taxRate",
			"tax", "localTax", "localPrice", "localAmount", "drewQty",
			"imputedCost", "writtenOffBaseQty", "unWriteOffBaseQty",
			"unReturnedBaseQty", "orderPrice", "taxPrice", "actualPrice",
			"drewBaseQty", "totalMoveQty", "taxAmount", "localTaxAmount" };

	private static String[] entryDatetProperties = { "mfg", "exp" };

	private static String[] entryStrProperties = { "sourceBillId",
			"sourceBillNumber", "sourceBillEntryId", "remark", "lot",
			"purOrderNumber", "purOrder", "purOrderEntry" };

	private static String[] entryLinkProperties = { "material",
			"assistProperty", "unit", "sourceBillType", "baseUnit",
			"assistUnit", "reasonCode", "storageOrgUnit", "companyOrgUnit",
			"warehouse", "location", "stocker", "coreBillType",
			"purchaseOrgUnit", "purchaseGroup", "purchasePerson" ,"invUpdateType"};

	public static String[] getMustValidateHeadProperties() {
		return mustValidateHeadProperties;
	}

	public static String[] getHeadBooleanProperties() {
		return headBooleanProperties;
	}

	public static String[] getHeadintProperties() {
		return headintProperties;
	}

	public static String[] getHeadDecimalProperties() {
		return headDecimalProperties;
	}

	public static String[] getHeadTimeStampProperties() {
		return headTimeStampProperties;
	}

	public static String[] getHeadDatetProperties() {
		return headDatetProperties;
	}

	public static String[] getHeadStrProperties() {
		return headStrProperties;
	}

	public static String[] getNOTCUFILTERPROPERTIES() {
		return NOTCUFILTERPROPERTIES;
	}

	public static String[] getHeadLinkProperties() {
		return headLinkProperties;
	}

	public static String[] getMustValidateEntryProperties() {
		return mustValidateEntryProperties;
	}

	public static String[] getEntryBooleanProperties() {
		return entryBooleanProperties;
	}

	public static String[] getEntryintProperties() {
		return entryintProperties;
	}

	public static String[] getEntryDecimalProperties() {
		return entryDecimalProperties;
	}

	public static String[] getEntryDatetProperties() {
		return entryDatetProperties;
	}

	public static String[] getEntryStrProperties() {
		return entryStrProperties;
	}

	public static String[] getEntryLinkProperties() {
		return entryLinkProperties;
	}


}
