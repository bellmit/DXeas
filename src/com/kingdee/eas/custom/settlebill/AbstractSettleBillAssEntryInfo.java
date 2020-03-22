package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleBillAssEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleBillAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 辅助资料分录 's null property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillInfo getParent()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.settlebill.SettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:辅助资料分录's 屠宰记录property 
     */
    public String getSlaughterRecord()
    {
        return getString("slaughterRecord");
    }
    public void setSlaughterRecord(String item)
    {
        setString("slaughterRecord", item);
    }
    /**
     * Object:辅助资料分录's 生物资产property 
     */
    public String getBiologicalAssets()
    {
        return getString("biologicalAssets");
    }
    public void setBiologicalAssets(String item)
    {
        setString("biologicalAssets", item);
    }
    /**
     * Object:辅助资料分录's 级别property 
     */
    public String getLevel()
    {
        return getString("level");
    }
    public void setLevel(String item)
    {
        setString("level", item);
    }
    /**
     * Object:辅助资料分录's 数量property 
     */
    public java.math.BigDecimal getQuantity()
    {
        return getBigDecimal("quantity");
    }
    public void setQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("quantity", item);
    }
    /**
     * Object:辅助资料分录's 重量property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D353B634");
    }
}