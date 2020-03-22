package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 养殖场分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:养殖场分录's 栋舍号property 
     */
    public String getMemoryCode()
    {
        return getString("memoryCode");
    }
    public void setMemoryCode(String item)
    {
        setString("memoryCode", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3E0B37D7");
    }
}