package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettlePolicyRangeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggSettlePolicyRangeEntryInfo()
    {
        this("id");
    }
    protected AbstractEggSettlePolicyRangeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 作用范围 's null property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 作用范围 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: 作用范围 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C2D9F12D");
    }
}