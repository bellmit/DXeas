package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCSendFodderStandardEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCSendFodderStandardEntryInfo()
    {
        this("id");
    }
    protected AbstractCCSendFodderStandardEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 送料计划 's null property 
     */
    public com.kingdee.eas.farm.breed.business.CCSendFodderStandardInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.business.CCSendFodderStandardInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.business.CCSendFodderStandardInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 送料计划 's 饲料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:送料计划's 日龄property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:送料计划's 送料车次(每料塔)property 
     */
    public int getSendCount()
    {
        return getInt("SendCount");
    }
    public void setSendCount(int item)
    {
        setInt("SendCount", item);
    }
    /**
     * Object:送料计划's 送料量(吨)property 
     */
    public java.math.BigDecimal getSendQty()
    {
        return getBigDecimal("sendQty");
    }
    public void setSendQty(java.math.BigDecimal item)
    {
        setBigDecimal("sendQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9D690D49");
    }
}