package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBabyCostObjectInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHatchBabyCostObjectInfo()
    {
        this("id");
    }
    protected AbstractHatchBabyCostObjectInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectEntryCollection());
    }
    /**
     * Object: 苗种成本对象 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectEntryCollection)get("Entry");
    }
    /**
     * Object: 苗种成本对象 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getFarmersTree()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("farmersTree");
    }
    public void setFarmersTree(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("farmersTree", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3D507851");
    }
}