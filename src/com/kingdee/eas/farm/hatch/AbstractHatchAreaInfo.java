package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchAreaInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHatchAreaInfo()
    {
        this("id");
    }
    protected AbstractHatchAreaInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 入孵区域 's 孵化场 property 
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
        return new BOSObjectType("BC16AA9F");
    }
}