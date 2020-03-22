package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonFarmerRelationEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPersonFarmerRelationEntryInfo()
    {
        this("id");
    }
    protected AbstractPersonFarmerRelationEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖户 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 养殖户 's 养户编码 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:养殖户's 养户名称property 
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
        return new BOSObjectType("B776016D");
    }
}