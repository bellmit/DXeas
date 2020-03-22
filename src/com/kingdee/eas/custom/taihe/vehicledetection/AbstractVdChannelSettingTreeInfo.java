package com.kingdee.eas.custom.taihe.vehicledetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVdChannelSettingTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractVdChannelSettingTreeInfo()
    {
        this("id");
    }
    protected AbstractVdChannelSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 通道设置组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.vehicledetection.VdChannelSettingTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8BD9248E");
    }
}