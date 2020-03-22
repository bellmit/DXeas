package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractResidueSetTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractResidueSetTreeInfo()
    {
        this("id");
    }
    protected AbstractResidueSetTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 残留时间设置组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.breed.ResidueSetTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.ResidueSetTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.ResidueSetTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("84CC62EF");
    }
}