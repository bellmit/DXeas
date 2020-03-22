package com.kingdee.eas.custom.festival.Constant;

public class ManuFactureConstant {



	public static final String BOSTYPE = "FA1292B4";
	public static final String XMLROOTTAGNAME = "ManufactureRecBill";
	public static final String REVERSEBASEQTY = "reverseBaseQty";
	public static final String ASSISTPROPERTY = "assistProperty";
	public static final String SEQ = "seq";
	public static final String AUDITOR = "auditor";
	public static final String WAREHOUSE = "warehouse";
	public static final String CREATETIME = "createTime";
	public static final String DESCRIPTION = "description";
	public static final String TOTALACTUALCOST = "totalActualCost";
	public static final String ASSISTQTY = "assistQty";
	public static final String HANDLER = "handler";
	public static final String BILLTYPE = "billType";
	public static final String PERIOD = "period";
	public static final String ISINITBILL = "isInitBill";
	public static final String ADMINORGUNIT = "adminOrgUnit";
	public static final String SOURCEBILLID = "sourceBillId";
	public static final String UNIT = "unit";
	public static final String STORAGEORGUNIT = "storageOrgUnit";
	public static final String UNITSTANDARDCOST = "unitStandardCost";
	public static final String FIVOUCHERED = "fiVouchered";
	public static final String CU = "CU";
	public static final String MODIFIER = "modifier";
	public static final String BASESTATUS = "baseStatus";
	public static final String QTY = "qty";
	public static final String LASTUPDATETIME = "lastUpdateTime";
	public static final String SOURCEBILLNUMBER = "sourceBillNumber";
	public static final String SOURCEBILLENTRYSEQ = "sourceBillEntrySeq";
	public static final String LOCATION = "location";
	public static final String STOCKER = "stocker";
	public static final String AUDITTIME = "auditTime";
	public static final String ISREVERSED = "isReversed";
	public static final String BASEUNIT = "baseUnit";
	public static final String EXP = "exp";
	public static final String BIZDATE = "bizDate";
	public static final String YEAR = "year";
	public static final String MFG = "mfg";
	public static final String VOUCHER = "voucher";
	public static final String RETURNSQTY = "returnsQty";
	public static final String REVERSEQTY = "reverseQty";
	public static final String ASSISTUNIT = "assistUnit";
	public static final String MANUBILLENTRYID = "manuBillEntryID";
	public static final String LOT = "lot";
	public static final String BIZTYPE = "bizType";
	public static final String REASONCODE = "reasonCode";
	public static final String NUMBER = "number";
	public static final String BASEQTY = "baseQty";
	public static final String COMPANYORGUNIT = "companyOrgUnit";
	public static final String TRANSACTIONTYPE = "transactionType";
	public static final String RETURNBASEQTY = "returnBaseQty";
	public static final String MODIFICATIONTIME = "modificationTime";
	public static final String UNITACTUALCOST = "unitActualCost";
	public static final String HASEFFECTED = "hasEffected";
	public static final String AMOUNT = "amount";
	public static final String STANDARDCOST = "standardCost";
	public static final String PRICE = "price";
	public static final String ASSOCIATEQTY = "associateQty";
	public static final String TOTALQTY = "totalQty";
	public static final String SOURCEBILLENTRYID = "sourceBillEntryId";
	public static final String MATERIAL = "material";
	public static final String SOURCEFUNCTION = "sourceFunction";
	public static final String TOTALAMOUNT = "totalAmount";
	public static final String TOTALSTANDARDCOST = "totalStandardCost";
	public static final String CREATOR = "creator";
	public static final String MANUBILLID = "manuBillID";
	public static final String SOURCEBILLTYPE = "sourceBillType";
	public static final String ACTUALCOST = "actualCost";
	public static final String REMARK = "remark";
	public static final String ISPRESENT = "isPresent";
	public static final String ASSCOEFFICIENT = "assCoefficient";
	public static final String LASTUPDATEUSER = "lastUpdateUser";
	public static final String COSTCENTERORGUNIT = "costCenterOrgUnit";
	public static final String INVUPDATETYPE = "invUpdateType";
	private static String[] NOTCUFILTERPROPERTIES = { "transactionType", "billType" };


	private static String[] mustValidateHeadProperties = { "CU", "number", "bizDate", "storageOrgUnit", "transactionType" };




	private static String[] headBooleanProperties = { "hasEffected", "fiVouchered", "isReversed", "isInitBill" };



	private static String[] headintProperties = { "baseStatus", "year", "period" };

	private static String[] headDecimalProperties = { "totalQty", "totalAmount", "totalStandardCost", "totalActualCost" };

	private static String[] headTimeStampProperties = { "createTime", "lastUpdateTime", "auditTime", "modificationTime" };

	private static String[] headDatetProperties = { "bizDate" };

	private static String[] headStrProperties = { "number", "description", "sourceBillId", "sourceFunction" };

	private static String[] headLinkProperties = { "creator", "lastUpdateUser", "CU", "handler", "auditor", "bizType", "sourceBillType", "billType", "modifier", "storageOrgUnit", "adminOrgUnit", "stocker", "voucher", "transactionType", "costCenterOrgUnit" };




	private static String[] mustValidateEntryProperties = { "seq", "material", "unit", "baseUnit", "baseStatus", "storageOrgUnit", "companyOrgUnit", "warehouse", "stocker", "qty", "baseQty" ,"invUpdateType"};







	private static String[] entryBooleanProperties = { "isPresent" };



	private static String[] entryintProperties = { "baseStatus", "seq", "sourceBillEntrySeq" };

	private static String[] entryDecimalProperties = { "assCoefficient", "associateQty", "qty", "assistQty", "baseQty", "reverseQty", "returnsQty", "price", "amount", "unitStandardCost", "standardCost", "unitActualCost", "actualCost", "reverseBaseQty", "returnBaseQty" };


	private static String[] entryDatetProperties = { "mfg", "exp" };

	private static String[] entryStrProperties = { "sourceBillId", "sourceBillNumber", "sourceBillEntryId", "remark", "lot", "manuBillEntryID", "manuBillID" ,"qylot"};



	private static String[] entryLinkProperties = { "material", "assistProperty", "unit", "sourceBillType", "baseUnit", "assistUnit", "reasonCode", "storageOrgUnit", "companyOrgUnit", "warehouse", "location", "stocker","invUpdateType","costCenterOrgUnit","costObject" };


	public static String[] getNOTCUFILTERPROPERTIES()
	{
		return NOTCUFILTERPROPERTIES;
	}




	public static String[] getMustValidateHeadProperties()
	{
		return mustValidateHeadProperties;
	}




	public static String[] getHeadBooleanProperties()
	{
		return headBooleanProperties;
	}




	public static String[] getHeadintProperties()
	{
		return headintProperties;
	}




	public static String[] getHeadDecimalProperties()
	{
		return headDecimalProperties;
	}




	public static String[] getHeadTimeStampProperties()
	{
		return headTimeStampProperties;
	}




	public static String[] getHeadDatetProperties()
	{
		return headDatetProperties;
	}




	public static String[] getHeadStrProperties()
	{
		return headStrProperties;
	}




	public static String[] getHeadLinkProperties()
	{
		return headLinkProperties;
	}




	public static String[] getMustValidateEntryProperties()
	{
		return mustValidateEntryProperties;
	}




	public static String[] getEntryBooleanProperties()
	{
		return entryBooleanProperties;
	}




	public static String[] getEntryintProperties()
	{
		return entryintProperties;
	}




	public static String[] getEntryDecimalProperties()
	{
		return entryDecimalProperties;
	}




	public static String[] getEntryDatetProperties()
	{
		return entryDatetProperties;
	}




	public static String[] getEntryStrProperties()
	{
		return entryStrProperties;
	}




	public static String[] getEntryLinkProperties()
	{
		return entryLinkProperties;
	}



}
