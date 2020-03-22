package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassRateDisRateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarcassRateDisRateEntryInfo()
    {
        this("id");
    }
    protected AbstractCarcassRateDisRateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 折扣系数分录 's null property 
     */
    public com.kingdee.eas.custom.settlebill.CarcassRateInfo getParent()
    {
        return (com.kingdee.eas.custom.settlebill.CarcassRateInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.settlebill.CarcassRateInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:折扣系数分录's 称重类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getWgtType()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("wgtType"));
    }
    public void setWgtType(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("wgtType", item.getValue());
		}
    }
    /**
     * Object:折扣系数分录's 折算系数property 
     */
    public java.math.BigDecimal getDisRate()
    {
        return getBigDecimal("disRate");
    }
    public void setDisRate(java.math.BigDecimal item)
    {
        setBigDecimal("disRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D745E9A5");
    }
}