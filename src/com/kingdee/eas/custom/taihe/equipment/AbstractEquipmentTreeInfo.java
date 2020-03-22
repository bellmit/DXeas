package com.kingdee.eas.custom.taihe.equipment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEquipmentTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractEquipmentTreeInfo()
    {
        this("id");
    }
    protected AbstractEquipmentTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 设备信息组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.taihe.equipment.EquipmentTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.equipment.EquipmentTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.equipment.EquipmentTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CD947CF2");
    }
}