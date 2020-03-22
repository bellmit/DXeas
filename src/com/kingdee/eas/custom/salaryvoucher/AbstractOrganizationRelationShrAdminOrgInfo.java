package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOrganizationRelationShrAdminOrgInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOrganizationRelationShrAdminOrgInfo()
    {
        this("id");
    }
    protected AbstractOrganizationRelationShrAdminOrgInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: shr行政组织 's null property 
     */
    public com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo getParent()
    {
        return (com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:shr行政组织's shr组织编码property 
     */
    public String getShrAdminOrg()
    {
        return getString("shrAdminOrg");
    }
    public void setShrAdminOrg(String item)
    {
        setString("shrAdminOrg", item);
    }
    /**
     * Object:shr行政组织's shr组织名称property 
     */
    public String getShrAdminOrgName()
    {
        return getString("shrAdminOrgName");
    }
    public void setShrAdminOrgName(String item)
    {
        setString("shrAdminOrgName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2671B4F4");
    }
}