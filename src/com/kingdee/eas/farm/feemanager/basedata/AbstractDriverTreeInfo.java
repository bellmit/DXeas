package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDriverTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDriverTreeInfo()
    {
        this("id");
    }
    protected AbstractDriverTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 司机组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basedata.DriverTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D38E5C92");
    }
}