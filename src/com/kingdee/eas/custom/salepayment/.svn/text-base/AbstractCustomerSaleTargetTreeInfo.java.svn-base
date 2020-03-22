package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerSaleTargetTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCustomerSaleTargetTreeInfo()
    {
        this("id");
    }
    protected AbstractCustomerSaleTargetTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客户销售指标组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salepayment.CustomerSaleTargetTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.CustomerSaleTargetTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.CustomerSaleTargetTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B1067E8");
    }
}