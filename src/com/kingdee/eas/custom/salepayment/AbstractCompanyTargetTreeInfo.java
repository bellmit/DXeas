package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyTargetTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCompanyTargetTreeInfo()
    {
        this("id");
    }
    protected AbstractCompanyTargetTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 公司指标组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyTargetTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyTargetTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.CompanyTargetTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AF4D80B8");
    }
}