package com.kingdee.eas.custom.taihe.vehicledetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVcWhiteListTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractVcWhiteListTreeInfo()
    {
        this("id");
    }
    protected AbstractVcWhiteListTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 白名单组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("183A05A3");
    }
}