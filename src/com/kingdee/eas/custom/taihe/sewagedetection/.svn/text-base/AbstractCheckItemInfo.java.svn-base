package com.kingdee.eas.custom.taihe.sewagedetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckItemInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractCheckItemInfo()
    {
        this("id");
    }
    protected AbstractCheckItemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:检测项目's 指标上限property 
     */
    public java.math.BigDecimal getUpperLimit()
    {
        return getBigDecimal("upperLimit");
    }
    public void setUpperLimit(java.math.BigDecimal item)
    {
        setBigDecimal("upperLimit", item);
    }
    /**
     * Object:检测项目's 内部指标property 
     */
    public java.math.BigDecimal getInIndex()
    {
        return getBigDecimal("inIndex");
    }
    public void setInIndex(java.math.BigDecimal item)
    {
        setBigDecimal("inIndex", item);
    }
    /**
     * Object: 检测项目 's 公司 property 
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
        return new BOSObjectType("AAE6C09E");
    }
}