package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettlePolicySaleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggSettlePolicySaleEntryInfo()
    {
        this("id");
    }
    protected AbstractEggSettlePolicySaleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 销售计算分录 's null property 
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
     * Object: 销售计算分录 's 结算项目 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettleItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settleItem");
    }
    public void setSettleItem(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settleItem", item);
    }
    /**
     * Object: 销售计算分录 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("33E93973");
    }
}