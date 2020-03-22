package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmersFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmersFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmersFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 养殖场分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D47C2B9D");
    }
}