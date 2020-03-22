package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBatchTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractStockingBatchTreeInfo()
    {
        this("id");
    }
    protected AbstractStockingBatchTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 批次信息组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.StockingBatchTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("62F0CF1B");
    }
}