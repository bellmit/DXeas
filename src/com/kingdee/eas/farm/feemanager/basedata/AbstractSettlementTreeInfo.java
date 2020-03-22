package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlementTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSettlementTreeInfo()
    {
        this("id");
    }
    protected AbstractSettlementTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.SettlementTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.SettlementTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basedata.SettlementTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6B65AF13");
    }
}