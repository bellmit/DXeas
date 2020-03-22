package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarriageFormatTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCarriageFormatTreeInfo()
    {
        this("id");
    }
    protected AbstractCarriageFormatTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 车厢组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarriageFormatTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basedata.CarriageFormatTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("50CE9415");
    }
}