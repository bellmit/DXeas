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
     * Object: �����۲� 's null property 
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
     * Object:�����۲�'s �۲�����property 
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
     * Object:�����۲�'s ���property 
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
     * Object: �����۲� 's �۲����� property 
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