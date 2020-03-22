package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCarTreeInfo()
    {
        this("id");
    }
    protected AbstractCarTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 车辆组别 's 父节点 property 
     */
    public com.kingdee.eas.publicdata.CarTreeInfo getParent()
    {
        return (com.kingdee.eas.publicdata.CarTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.publicdata.CarTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("ECBEA84F");
    }
}