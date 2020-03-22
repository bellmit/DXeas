package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonFarmerRangeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPersonFarmerRangeEntryInfo()
    {
        this("id");
    }
    protected AbstractPersonFarmerRangeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖户 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 养殖户 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:养殖户's 养殖户名称property 
     */
    public String getFarmerName()
    {
        return getString("farmerName");
    }
    public void setFarmerName(String item)
    {
        setString("farmerName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C0C5EA8F");
    }
}