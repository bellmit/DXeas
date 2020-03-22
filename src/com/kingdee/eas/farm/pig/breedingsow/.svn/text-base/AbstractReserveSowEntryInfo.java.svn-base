package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractReserveSowEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractReserveSowEntryInfo()
    {
        this("id");
    }
    protected AbstractReserveSowEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.ReserveSowInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ReserveSowInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.ReserveSowInfo item)
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
     * Object: 分录 's 品种 property 
     */
    public com.kingdee.eas.farm.pig.PigTypeInfo getPigType()
    {
        return (com.kingdee.eas.farm.pig.PigTypeInfo)get("pigType");
    }
    public void setPigType(com.kingdee.eas.farm.pig.PigTypeInfo item)
    {
        put("pigType", item);
    }
    /**
     * Object: 分录 's 当前栏位 property 
     */
    public com.kingdee.eas.farm.pig.PigFieldInfo getPigFields()
    {
        return (com.kingdee.eas.farm.pig.PigFieldInfo)get("pigFields");
    }
    public void setPigFields(com.kingdee.eas.farm.pig.PigFieldInfo item)
    {
        put("pigFields", item);
    }
    /**
     * Object:分录's 日龄property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("04783C32");
    }
}