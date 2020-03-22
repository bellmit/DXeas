package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassRateDisEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarcassRateDisEntryInfo()
    {
        this("id");
    }
    protected AbstractCarcassRateDisEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 折扣率 's null property 
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
     * Object:折扣率's 称重项目property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getWgtItem()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("wgtItem"));
    }
    public void setWgtItem(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("wgtItem", item.getValue());
		}
    }
    /**
     * Object:折扣率's 折扣率property 
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
        return new BOSObjectType("C1002C25");
    }
}