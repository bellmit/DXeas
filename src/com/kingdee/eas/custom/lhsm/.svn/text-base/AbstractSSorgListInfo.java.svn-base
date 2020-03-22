package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSSorgListInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSSorgListInfo()
    {
        this("id");
    }
    protected AbstractSSorgListInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 公司维护 's 组织名称 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getOrgid()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("orgid");
    }
    public void setOrgid(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("orgid", item);
    }
    /**
     * Object:公司维护's 销售员所在组织property 
     */
    public boolean isStatus()
    {
        return getBoolean("status");
    }
    public void setStatus(boolean item)
    {
        setBoolean("status", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("87FB5695");
    }
}