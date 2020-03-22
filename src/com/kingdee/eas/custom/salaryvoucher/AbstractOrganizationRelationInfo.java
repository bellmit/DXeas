package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOrganizationRelationInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractOrganizationRelationInfo()
    {
        this("id");
    }
    protected AbstractOrganizationRelationInfo(String pkField)
    {
        super(pkField);
        put("ShrAdminOrg", new com.kingdee.eas.custom.salaryvoucher.OrganizationRelationShrAdminOrgCollection());
    }
    /**
     * Object: EAS与SHR组织对应 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrg()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrg");
    }
    public void setCompanyOrg(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrg", item);
    }
    /**
     * Object: EAS与SHR组织对应 's EAS组织编码 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrg");
    }
    public void setAdminOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrg", item);
    }
    /**
     * Object:EAS与SHR组织对应's EAS组织名称property 
     */
    public String getAdminOrgName()
    {
        return getString("adminOrgName");
    }
    public void setAdminOrgName(String item)
    {
        setString("adminOrgName", item);
    }
    /**
     * Object: EAS与SHR组织对应 's shr行政组织 property 
     */
    public com.kingdee.eas.custom.salaryvoucher.OrganizationRelationShrAdminOrgCollection getShrAdminOrg()
    {
        return (com.kingdee.eas.custom.salaryvoucher.OrganizationRelationShrAdminOrgCollection)get("ShrAdminOrg");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D616851E");
    }
}