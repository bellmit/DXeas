package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchingBoxInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHatchingBoxInfo()
    {
        this("id");
    }
    protected AbstractHatchingBoxInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 出雏箱 's 组别 property 
     */
    public com.kingdee.eas.farm.hatch.HatchingBoxTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.hatch.HatchingBoxTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.hatch.HatchingBoxTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:出雏箱's 最大出雏量property 
     */
    public int getMaxQty()
    {
        return getInt("maxQty");
    }
    public void setMaxQty(int item)
    {
        setInt("maxQty", item);
    }
    /**
     * Object: 出雏箱 's 入孵区域 property 
     */
    public com.kingdee.eas.farm.hatch.HatchAreaInfo getHatchArea()
    {
        return (com.kingdee.eas.farm.hatch.HatchAreaInfo)get("hatchArea");
    }
    public void setHatchArea(com.kingdee.eas.farm.hatch.HatchAreaInfo item)
    {
        put("hatchArea", item);
    }
    /**
     * Object: 出雏箱 's 孵化场 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchFactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object: 出雏箱 's 孵化厅 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseInfo getHatchHouse()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseInfo)get("hatchHouse");
    }
    public void setHatchHouse(com.kingdee.eas.farm.hatch.HatchHouseInfo item)
    {
        put("hatchHouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("55207BFB");
    }
}