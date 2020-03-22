package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBabyCostObjectEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchBabyCostObjectEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchBabyCostObjectEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getFarmerTree()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("farmerTree");
    }
    public void setFarmerTree(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("farmerTree", item);
    }
    /**
     * Object:分录's 鸭苗类型property 
     */
    public String getChildDuck()
    {
        return getString("childDuck");
    }
    public void setChildDuck(String item)
    {
        setString("childDuck", item);
    }
    /**
     * Object: 分录 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object: 分录 's 成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E8732AA1");
    }
}