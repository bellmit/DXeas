package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWgtDisRateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWgtDisRateEntryInfo()
    {
        this("id");
    }
    protected AbstractWgtDisRateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.custom.taihe.weight.WgtDisRateInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.weight.WgtDisRateInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.weight.WgtDisRateInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 称重项目 property 
     */
    public com.kingdee.eas.custom.taihe.weight.WgtItemInfo getWgtItem()
    {
        return (com.kingdee.eas.custom.taihe.weight.WgtItemInfo)get("wgtItem");
    }
    public void setWgtItem(com.kingdee.eas.custom.taihe.weight.WgtItemInfo item)
    {
        put("wgtItem", item);
    }
    /**
     * Object:分录's 折算胴体系数property 
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
        return new BOSObjectType("004B2352");
    }
}