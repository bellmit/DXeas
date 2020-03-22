package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleBillEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础资料分录 's 单据头 property 
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
     * Object:基础资料分录's 单据类型property 
     */
    public String getBillType()
    {
        return getString("billType");
    }
    public void setBillType(String item)
    {
        setString("billType", item);
    }
    /**
     * Object:基础资料分录's 单据号property 
     */
    public String getBillNum()
    {
        return getString("billNum");
    }
    public void setBillNum(String item)
    {
        setString("billNum", item);
    }
    /**
     * Object:基础资料分录's 单据日期property 
     */
    public java.util.Date getBillDate()
    {
        return getDate("billDate");
    }
    public void setBillDate(java.util.Date item)
    {
        setDate("billDate", item);
    }
    /**
     * Object:基础资料分录's 生物资产property 
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
     * Object:基础资料分录's 级别property 
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
     * Object:基础资料分录's 数量property 
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
     * Object:基础资料分录's 重量property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
    }
    /**
     * Object:基础资料分录's 称重类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getWeightType()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("weightType"));
    }
    public void setWeightType(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("weightType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6D70278F");
    }
}