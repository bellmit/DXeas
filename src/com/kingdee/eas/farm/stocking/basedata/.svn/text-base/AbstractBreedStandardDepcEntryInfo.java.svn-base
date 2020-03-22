package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedStandardDepcEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedStandardDepcEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedStandardDepcEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 折旧标准 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:折旧标准's 周龄property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:折旧标准's 折旧率property 
     */
    public java.math.BigDecimal getDepreciationRate()
    {
        return getBigDecimal("depreciationRate");
    }
    public void setDepreciationRate(java.math.BigDecimal item)
    {
        setBigDecimal("depreciationRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7268D5DE");
    }
}