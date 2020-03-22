package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsPolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractStatementsPolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractStatementsPolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StatementsPolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.StatementsPolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("92D8E0C5");
    }
}