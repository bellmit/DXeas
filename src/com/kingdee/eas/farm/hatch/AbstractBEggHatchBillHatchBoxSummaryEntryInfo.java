package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggHatchBillHatchBoxSummaryEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggHatchBillHatchBoxSummaryEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggHatchBillHatchBoxSummaryEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 孵化箱汇总 's null property 
     */
    public com.kingdee.eas.farm.hatch.BEggHatchBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BEggHatchBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BEggHatchBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 孵化箱汇总 's 孵化箱 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getIncubator()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("incubator");
    }
    public void setIncubator(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("incubator", item);
    }
    /**
     * Object: 孵化箱汇总 's 上孵厅 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseInfo getHatchHouse()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseInfo)get("hatchHouse");
    }
    public void setHatchHouse(com.kingdee.eas.farm.hatch.HatchHouseInfo item)
    {
        put("hatchHouse", item);
    }
    /**
     * Object:孵化箱汇总's 上孵数量property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("63FBCEAD");
    }
}