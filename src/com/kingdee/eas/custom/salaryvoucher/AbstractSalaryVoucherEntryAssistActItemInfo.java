package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalaryVoucherEntryAssistActItemInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSalaryVoucherEntryAssistActItemInfo()
    {
        this("id");
    }
    protected AbstractSalaryVoucherEntryAssistActItemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 核算项目 's null property 
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
     * Object:核算项目's 核算项目编码property 
     */
    public String getAssistActItemNum()
    {
        return getString("assistActItemNum");
    }
    public void setAssistActItemNum(String item)
    {
        setString("assistActItemNum", item);
    }
    /**
     * Object:核算项目's 核算项目名称property 
     */
    public String getAssistActItemName()
    {
        return getString("assistActItemName");
    }
    public void setAssistActItemName(String item)
    {
        setString("assistActItemName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D9CBA13F");
    }
}