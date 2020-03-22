package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonFarmerRangeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractPersonFarmerRangeTreeInfo()
    {
        this("id");
    }
    protected AbstractPersonFarmerRangeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 技术员养户范围组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CC7059E1");
    }
}