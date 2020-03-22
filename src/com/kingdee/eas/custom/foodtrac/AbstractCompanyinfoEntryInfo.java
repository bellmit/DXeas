package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyinfoEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCompanyinfoEntryInfo()
    {
        this("id");
    }
    protected AbstractCompanyinfoEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.foodtrac.CompanyinfoInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.CompanyinfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.CompanyinfoInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("826D774C");
    }
}