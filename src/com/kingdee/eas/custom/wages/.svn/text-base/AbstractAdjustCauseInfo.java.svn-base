package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAdjustCauseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAdjustCauseInfo()
    {
        this("id");
    }
    protected AbstractAdjustCauseInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:奖罚事由's 业务日期property 
     */
    public java.util.Date getBizdate()
    {
        return getDate("bizdate");
    }
    public void setBizdate(java.util.Date item)
    {
        setDate("bizdate", item);
    }
    /**
     * Object: 奖罚事由 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E5317D12");
    }
}