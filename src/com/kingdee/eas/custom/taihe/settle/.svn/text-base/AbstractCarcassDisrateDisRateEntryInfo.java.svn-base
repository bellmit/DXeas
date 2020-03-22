package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassDisrateDisRateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarcassDisrateDisRateEntryInfo()
    {
        this("id");
    }
    protected AbstractCarcassDisrateDisRateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 折算系数 's null property 
     */
    public com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:折算系数's 折算系数property 
     */
    public java.math.BigDecimal getDisRate()
    {
        return getBigDecimal("disRate");
    }
    public void setDisRate(java.math.BigDecimal item)
    {
        setBigDecimal("disRate", item);
    }
    /**
     * Object:折算系数's 胴体类型property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("33407B23");
    }
}