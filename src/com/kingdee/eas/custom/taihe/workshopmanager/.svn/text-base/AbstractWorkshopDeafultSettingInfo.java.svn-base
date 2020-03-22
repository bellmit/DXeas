package com.kingdee.eas.custom.taihe.workshopmanager;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkshopDeafultSettingInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractWorkshopDeafultSettingInfo()
    {
        this("id");
    }
    protected AbstractWorkshopDeafultSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:车间管理基础设置's 允许超出订单比例property 
     */
    public java.math.BigDecimal getBeyondRate()
    {
        return getBigDecimal("beyondRate");
    }
    public void setBeyondRate(java.math.BigDecimal item)
    {
        setBigDecimal("beyondRate", item);
    }
    /**
     * Object: 车间管理基础设置 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F00325C2");
    }
}