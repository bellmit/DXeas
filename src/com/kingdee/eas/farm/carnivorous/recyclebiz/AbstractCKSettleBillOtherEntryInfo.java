package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillOtherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillOtherEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillOtherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 其他扣补 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:其他扣补's 扣补类型property 
     */
    public String getRpType()
    {
        return getString("rpType");
    }
    public void setRpType(String item)
    {
        setString("rpType", item);
    }
    /**
     * Object:其他扣补's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object: 其他扣补 's 扣补类型 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyInfo getSuType()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyInfo)get("suType");
    }
    public void setSuType(com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyInfo item)
    {
        put("suType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AA64BE19");
    }
}