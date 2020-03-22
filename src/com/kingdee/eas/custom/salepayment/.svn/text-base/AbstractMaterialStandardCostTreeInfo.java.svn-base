package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialStandardCostTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractMaterialStandardCostTreeInfo()
    {
        this("id");
    }
    protected AbstractMaterialStandardCostTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 标准成本组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.salepayment.MaterialStandardCostTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.MaterialStandardCostTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.MaterialStandardCostTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("808B8D23");
    }
}