package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCSendFodderStandardTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCCSendFodderStandardTreeInfo()
    {
        this("id");
    }
    protected AbstractCCSendFodderStandardTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 商品鸡料塔送料规范组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1DE0F7E7");
    }
}