package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBRelationTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractStockingBRelationTreeInfo()
    {
        this("id");
    }
    protected AbstractStockingBRelationTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种禽批次关联关系组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBRelationTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBRelationTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.StockingBRelationTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5F1948DF");
    }
}