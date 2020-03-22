package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchPlanLayEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchPlanLayEggEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchPlanLayEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 产蛋信息分录 's null property 
     */
    public com.kingdee.eas.farm.hatch.BatchPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BatchPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BatchPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 产蛋信息分录 's 产蛋场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getSrcLayEggOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("srcLayEggOrgUnit");
    }
    public void setSrcLayEggOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("srcLayEggOrgUnit", item);
    }
    /**
     * Object:产蛋信息分录's 送蛋日期property 
     */
    public java.util.Date getSrcDate()
    {
        return getDate("srcDate");
    }
    public void setSrcDate(java.util.Date item)
    {
        setDate("srcDate", item);
    }
    /**
     * Object:产蛋信息分录's 来源蛋数property 
     */
    public int getEggs()
    {
        return getInt("eggs");
    }
    public void setEggs(int item)
    {
        setInt("eggs", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C24F26BC");
    }
}