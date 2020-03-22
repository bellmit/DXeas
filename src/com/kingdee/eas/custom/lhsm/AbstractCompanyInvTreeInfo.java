package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyInvTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCompanyInvTreeInfo()
    {
        this("id");
    }
    protected AbstractCompanyInvTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 公司及时库存组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.lhsm.CompanyInvTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.lhsm.CompanyInvTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.lhsm.CompanyInvTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7F4CC09F");
    }
}