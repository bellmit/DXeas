package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleStandardTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSettleStandardTreeInfo()
    {
        this("id");
    }
    protected AbstractSettleStandardTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算指标组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettleStandardTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettleStandardTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.SettleStandardTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CEB655F7");
    }
}