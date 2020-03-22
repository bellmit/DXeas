package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBatchTreeInfo()
    {
        this("id");
    }
    protected AbstractBatchTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 批次信息组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BatchTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("93763696");
    }
}