package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchBillEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 孵化箱编码 property 
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
     * Object:分录's 孵化箱名称property 
     */
    public String getIncubatorName()
    {
        return getString("incubatorName");
    }
    public void setIncubatorName(String item)
    {
        setString("incubatorName", item);
    }
    /**
     * Object:分录's 上孵蛋数property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object: 分录 's 鸡苗批次编码 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getBabyChickBatch()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("babyChickBatch");
    }
    public void setBabyChickBatch(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("babyChickBatch", item);
    }
    /**
     * Object:分录's 鸡苗批次名称property 
     */
    public String getBabyChickBatchName()
    {
        return getString("babyChickBatchName");
    }
    public void setBabyChickBatchName(String item)
    {
        setString("babyChickBatchName", item);
    }
    /**
     * Object:分录's 上孵时间property 
     */
    public java.sql.Time getHatchTime()
    {
        return getTime("hatchTime");
    }
    public void setHatchTime(java.sql.Time item)
    {
        setTime("hatchTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FF4101D9");
    }
}