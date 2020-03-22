package com.kingdee.eas.farm.breed.freedplan;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedFodderPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedFodderPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedFodderPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3824A4A6");
    }
}