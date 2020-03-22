package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalaryVoucherEntryCmpItemInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSalaryVoucherEntryCmpItemInfo()
    {
        this("id");
    }
    protected AbstractSalaryVoucherEntryCmpItemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: н����Ŀ 's null property 
     */
    public com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryInfo getParent1()
    {
        return (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: н����Ŀ 's н����Ŀ���� property 
     */
    public com.kingdee.eas.custom.salaryvoucher.CmpItemInfo getCmpItemNum()
    {
        return (com.kingdee.eas.custom.salaryvoucher.CmpItemInfo)get("cmpItemNum");
    }
    public void setCmpItemNum(com.kingdee.eas.custom.salaryvoucher.CmpItemInfo item)
    {
        put("cmpItemNum", item);
    }
    /**
     * Object:н����Ŀ's н����Ŀ����property 
     */
    public String getCmpItemName()
    {
        return getString("cmpItemName");
    }
    public void setCmpItemName(String item)
    {
        setString("cmpItemName", item);
    }
    /**
     * Object:н����Ŀ's н����Ŀ�����ֶ�property 
     */
    public String getCmpItemCode()
    {
        return getString("cmpItemCode");
    }
    public void setCmpItemCode(String item)
    {
        setString("cmpItemCode", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("00F648DC");
    }
}