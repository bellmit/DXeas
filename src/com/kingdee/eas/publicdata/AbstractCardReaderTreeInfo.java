package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCardReaderTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCardReaderTreeInfo()
    {
        this("id");
    }
    protected AbstractCardReaderTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 刷卡器设置组别 's 父节点 property 
     */
    public com.kingdee.eas.publicdata.CardReaderTreeInfo getParent()
    {
        return (com.kingdee.eas.publicdata.CardReaderTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.publicdata.CardReaderTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("37C080D4");
    }
}