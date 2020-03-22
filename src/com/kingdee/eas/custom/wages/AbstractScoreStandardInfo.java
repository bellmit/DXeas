package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractScoreStandardInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractScoreStandardInfo()
    {
        this("id");
    }
    protected AbstractScoreStandardInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��ֵ��׼'s ��ֵproperty 
     */
    public java.math.BigDecimal getScore()
    {
        return getBigDecimal("score");
    }
    public void setScore(java.math.BigDecimal item)
    {
        setBigDecimal("score", item);
    }
    /**
     * Object: ��ֵ��׼ 's ���� property 
     */
    public com.kingdee.eas.custom.wages.WageOrganizationInfo getTheGroup()
    {
        return (com.kingdee.eas.custom.wages.WageOrganizationInfo)get("theGroup");
    }
    public void setTheGroup(com.kingdee.eas.custom.wages.WageOrganizationInfo item)
    {
        put("theGroup", item);
    }
    /**
     * Object:��ֵ��׼'s ��Ч����property 
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
     * Object: ��ֵ��׼ 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:��ֵ��׼'s ����״̬property 
     */
    public com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C7C98067");
    }
}