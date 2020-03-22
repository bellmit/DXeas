package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedDataTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBreedDataTreeInfo()
    {
        this("id");
    }
    protected AbstractBreedDataTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 品种资料组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BreedDataTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("88C4AC4B");
    }
}