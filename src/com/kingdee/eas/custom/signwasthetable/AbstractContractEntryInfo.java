package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractContractEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractContractEntryInfo()
    {
        this("id");
    }
    protected AbstractContractEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.ContractInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0F1267B6");
    }
}