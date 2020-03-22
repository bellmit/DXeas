package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchHouseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHatchHouseInfo()
    {
        this("id");
    }
    protected AbstractHatchHouseInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 上孵厅 's 组别 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.hatch.HatchHouseTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 上孵厅 's 入孵区域 property 
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
     * Object: 上孵厅 's 孵化厂 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchFactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchFactory", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C7202F4E");
    }
}