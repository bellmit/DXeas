package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSlaughterPlanEntrySchedulingInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSlaughterPlanEntrySchedulingInfo()
    {
        this("id");
    }
    protected AbstractSlaughterPlanEntrySchedulingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 休班计划 's null property 
     */
    public com.kingdee.eas.farm.food.SlaughterPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.food.SlaughterPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.SlaughterPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:休班计划's 日期property 
     */
    public java.util.Date getSchedulingDate()
    {
        return getDate("schedulingDate");
    }
    public void setSchedulingDate(java.util.Date item)
    {
        setDate("schedulingDate", item);
    }
    /**
     * Object:休班计划's 宰杀舍数property 
     */
    public int getSchedulingHenHouseQty()
    {
        return getInt("schedulingHenHouseQty");
    }
    public void setSchedulingHenHouseQty(int item)
    {
        setInt("schedulingHenHouseQty", item);
    }
    /**
     * Object:休班计划's 是否休班property 
     */
    public boolean isIsOffDuty()
    {
        return getBoolean("isOffDuty");
    }
    public void setIsOffDuty(boolean item)
    {
        setBoolean("isOffDuty", item);
    }
    /**
     * Object:休班计划's 日宰杀量property 
     */
    public java.math.BigDecimal getSlaughterQty()
    {
        return getBigDecimal("slaughterQty");
    }
    public void setSlaughterQty(java.math.BigDecimal item)
    {
        setBigDecimal("slaughterQty", item);
    }
    /**
     * Object:休班计划's 宰杀详情property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:休班计划's 已锁定舍数property 
     */
    public int getLockedHenHouse()
    {
        return getInt("lockedHenHouse");
    }
    public void setLockedHenHouse(int item)
    {
        setInt("lockedHenHouse", item);
    }
    /**
     * Object:休班计划's 已排序舍数property 
     */
    public int getHadSortHenHouseQty()
    {
        return getInt("hadSortHenHouseQty");
    }
    public void setHadSortHenHouseQty(int item)
    {
        setInt("hadSortHenHouseQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1934CC74");
    }
}