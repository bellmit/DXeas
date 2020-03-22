package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBorrowDayRateTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBorrowDayRateTreeInfo()
    {
        this("id");
    }
    protected AbstractBorrowDayRateTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 借款项目日利率组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9E3B19C3");
    }
}