package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalaryVoucherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSalaryVoucherEntryInfo()
    {
        this("id");
    }
    protected AbstractSalaryVoucherEntryInfo(String pkField)
    {
        super(pkField);
        put("CmpItem", new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItemCollection());
        put("AssistActItem", new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryAssistActItemCollection());
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo getParent()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s �������property 
     */
    public com.kingdee.eas.fi.gr.cslrpt.DebitOrCreditEnum getDebitOrCredit()
    {
        return com.kingdee.eas.fi.gr.cslrpt.DebitOrCreditEnum.getEnum(getInt("debitOrCredit"));
    }
    public void setDebitOrCredit(com.kingdee.eas.fi.gr.cslrpt.DebitOrCreditEnum item)
    {
		if (item != null) {
        setInt("debitOrCredit", item.getValue());
		}
    }
    /**
     * Object:��¼'s ժҪproperty 
     */
    public String getAbstactInfo()
    {
        return getString("abstactInfo");
    }
    public void setAbstactInfo(String item)
    {
        setString("abstactInfo", item);
    }
    /**
     * Object: ��¼ 's н����Ŀ property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItemCollection getCmpItem()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItemCollection)get("CmpItem");
    }
    /**
     * Object: ��¼ 's ������Ŀ property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryAssistActItemCollection getAssistActItem()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryAssistActItemCollection)get("AssistActItem");
    }
    /**
     * Object: ��¼ 's ��ƿ�Ŀ property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getAccounting()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("Accounting");
    }
    public void setAccounting(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("Accounting", item);
    }
    /**
     * Object: ��¼ 's н�귽�� property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo getScaleScheme()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo)get("scaleScheme");
    }
    public void setScaleScheme(com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo item)
    {
        put("scaleScheme", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("69C849DD");
    }
}