package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSowRentoutBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSowRentoutBillEntryInfo()
    {
        this("id");
    }
    protected AbstractSowRentoutBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowRentoutBillInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowRentoutBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.SowRentoutBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 性状property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    /**
     * Object: 分录 's 母猪 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowInfo getSow()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowInfo)get("sow");
    }
    public void setSow(com.kingdee.eas.farm.pig.breedingsow.SowInfo item)
    {
        put("sow", item);
    }
    /**
     * Object:分录's 周龄property 
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
     * Object:分录's 耳标property 
     */
    public String getEarTag()
    {
        return getString("earTag");
    }
    public void setEarTag(String item)
    {
        setString("earTag", item);
    }
    /**
     * Object:分录's 耳缺property 
     */
    public String getEarGap()
    {
        return getString("earGap");
    }
    public void setEarGap(String item)
    {
        setString("earGap", item);
    }
    /**
     * Object:分录's 免疫耳标property 
     */
    public String getImmuneTag()
    {
        return getString("immuneTag");
    }
    public void setImmuneTag(String item)
    {
        setString("immuneTag", item);
    }
    /**
     * Object:分录's 品种property 
     */
    public String getPigType()
    {
        return getString("pigType");
    }
    public void setPigType(String item)
    {
        setString("pigType", item);
    }
    /**
     * Object:分录's 品系property 
     */
    public String getStrain()
    {
        return getString("strain");
    }
    public void setStrain(String item)
    {
        setString("strain", item);
    }
    /**
     * Object:分录's 胎次property 
     */
    public int getFetusNum()
    {
        return getInt("fetusNum");
    }
    public void setFetusNum(int item)
    {
        setInt("fetusNum", item);
    }
    /**
     * Object:分录's 情期property 
     */
    public int getHeatNum()
    {
        return getInt("heatNum");
    }
    public void setHeatNum(int item)
    {
        setInt("heatNum", item);
    }
    /**
     * Object: 分录 's 仔猪品种 property 
     */
    public com.kingdee.eas.farm.pig.PigTypeInfo getBabyType()
    {
        return (com.kingdee.eas.farm.pig.PigTypeInfo)get("babyType");
    }
    public void setBabyType(com.kingdee.eas.farm.pig.PigTypeInfo item)
    {
        put("babyType", item);
    }
    /**
     * Object:分录's 预计产仔日期property 
     */
    public java.util.Date getToBornDate()
    {
        return getDate("toBornDate");
    }
    public void setToBornDate(java.util.Date item)
    {
        setDate("toBornDate", item);
    }
    /**
     * Object:分录's 预计回收日期property 
     */
    public java.util.Date getToBeReturnDate()
    {
        return getDate("toBeReturnDate");
    }
    public void setToBeReturnDate(java.util.Date item)
    {
        setDate("toBeReturnDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B3298EB0");
    }
}