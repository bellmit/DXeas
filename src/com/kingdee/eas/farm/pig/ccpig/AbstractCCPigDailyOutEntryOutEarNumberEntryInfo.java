package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigDailyOutEntryOutEarNumberEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigDailyOutEntryOutEarNumberEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigDailyOutEntryOutEarNumberEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 出栏耳标明细 's null property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:出栏耳标明细's 耳标property 
     */
    public String getPigNumber()
    {
        return getString("pigNumber");
    }
    public void setPigNumber(String item)
    {
        setString("pigNumber", item);
    }
    /**
     * Object:出栏耳标明细's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("579202F2");
    }
}