package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCmpItemInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCmpItemInfo()
    {
        this("id");
    }
    protected AbstractCmpItemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 薪酬项目 's 组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrgUnitID()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("AdminOrgUnitID");
    }
    public void setAdminOrgUnitID(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("AdminOrgUnitID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DA9E9C4A");
    }
}