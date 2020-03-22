package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractLayEggPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.util.Date getPlanDate()
    {
        return getDate("planDate");
    }
    public void setPlanDate(java.util.Date item)
    {
        setDate("planDate", item);
    }
    /**
     * Object:��¼'s ����property 
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
     * Object:��¼'s ������property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object:��¼'s ��ĸ��ֻ��property 
     */
    public int getHenQty()
    {
        return getInt("henQty");
    }
    public void setHenQty(int item)
    {
        setInt("henQty", item);
    }
    /**
     * Object:��¼'s ������(%)property 
     */
    public java.math.BigDecimal getLayingRate()
    {
        return getBigDecimal("layingRate");
    }
    public void setLayingRate(java.math.BigDecimal item)
    {
        setBigDecimal("layingRate", item);
    }
    /**
     * Object:��¼'s �ϸ���property 
     */
    public java.math.BigDecimal getUpRate()
    {
        return getBigDecimal("upRate");
    }
    public void setUpRate(java.math.BigDecimal item)
    {
        setBigDecimal("upRate", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public int getLayEggQty()
    {
        return getInt("layEggQty");
    }
    public void setLayEggQty(int item)
    {
        setInt("layEggQty", item);
    }
    /**
     * Object:��¼'s �ϸ��ֵ���property 
     */
    public int getUpEggQty()
    {
        return getInt("upEggQty");
    }
    public void setUpEggQty(int item)
    {
        setInt("upEggQty", item);
    }
    /**
     * Object:��¼'s ���ε�property 
     */
    public int getFreakEggQty()
    {
        return getInt("freakEggQty");
    }
    public void setFreakEggQty(int item)
    {
        setInt("freakEggQty", item);
    }
    /**
     * Object:��¼'s ˫�Ƶ�property 
     */
    public int getDoubleYolkEggQty()
    {
        return getInt("doubleYolkEggQty");
    }
    public void setDoubleYolkEggQty(int item)
    {
        setInt("doubleYolkEggQty", item);
    }
    /**
     * Object:��¼'s �Ƶ�property 
     */
    public int getBrokenEggQty()
    {
        return getInt("brokenEggQty");
    }
    public void setBrokenEggQty(int item)
    {
        setInt("brokenEggQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5C8F0BDB");
    }
}