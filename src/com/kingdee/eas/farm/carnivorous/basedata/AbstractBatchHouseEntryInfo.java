package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchHouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchHouseEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 棚舍信息 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 棚舍信息 's 棚舍 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:棚舍信息's 入雏日期property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:棚舍信息's 入栏日期property 
     */
    public java.util.Date getRlDate()
    {
        return getDate("rlDate");
    }
    public void setRlDate(java.util.Date item)
    {
        setDate("rlDate", item);
    }
    /**
     * Object:棚舍信息's 上苗数量property 
     */
    public java.math.BigDecimal getMaleQty()
    {
        return getBigDecimal("maleQty");
    }
    public void setMaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("maleQty", item);
    }
    /**
     * Object:棚舍信息's 母禽数量property 
     */
    public java.math.BigDecimal getFemaleQty()
    {
        return getBigDecimal("femaleQty");
    }
    public void setFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleQty", item);
    }
    /**
     * Object:棚舍信息's 是否完全出栏property 
     */
    public boolean isIsAllOut()
    {
        return getBoolean("isAllOut");
    }
    public void setIsAllOut(boolean item)
    {
        setBoolean("isAllOut", item);
    }
    /**
     * Object:棚舍信息's 转正日期property 
     */
    public java.util.Date getFormalDate()
    {
        return getDate("formalDate");
    }
    public void setFormalDate(java.util.Date item)
    {
        setDate("formalDate", item);
    }
    /**
     * Object:棚舍信息's 完全出栏日期property 
     */
    public java.util.Date getAllOutDate()
    {
        return getDate("allOutDate");
    }
    public void setAllOutDate(java.util.Date item)
    {
        setDate("allOutDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("15216E2A");
    }
}