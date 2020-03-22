package com.kingdee.eas.custom.salaryvoucher;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonRelationInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPersonRelationInfo()
    {
        this("id");
    }
    protected AbstractPersonRelationInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: EAS与shr人员对应 's 财务组织 property 
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
     * Object:EAS与shr人员对应's shr人员编码property 
     */
    public String getShrPerson()
    {
        return getString("shrPerson");
    }
    public void setShrPerson(String item)
    {
        setString("shrPerson", item);
    }
    /**
     * Object:EAS与shr人员对应's shr人员姓名property 
     */
    public String getShrPersonName()
    {
        return getString("shrPersonName");
    }
    public void setShrPersonName(String item)
    {
        setString("shrPersonName", item);
    }
    /**
     * Object: EAS与shr人员对应 's 行政组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("AdminOrgUnit");
    }
    public void setAdminOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("AdminOrgUnit", item);
    }
    /**
     * Object: EAS与shr人员对应 's 员工性质 property 
     */
    public com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo getPersonNature()
    {
        return (com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo)get("personNature");
    }
    public void setPersonNature(com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo item)
    {
        put("personNature", item);
    }
    /**
     * Object:EAS与shr人员对应's 员工性质编码property 
     */
    public String getPersonNatureCode()
    {
        return getString("PersonNatureCode");
    }
    public void setPersonNatureCode(String item)
    {
        setString("PersonNatureCode", item);
    }
    /**
     * Object:EAS与shr人员对应's 员工性质名称property 
     */
    public String getPersonNatureName()
    {
        return getString("PersonNatureName");
    }
    public void setPersonNatureName(String item)
    {
        setString("PersonNatureName", item);
    }
    /**
     * Object: EAS与shr人员对应 's EAS人员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getEASperson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("EASperson");
    }
    public void setEASperson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("EASperson", item);
    }
    /**
     * Object:EAS与shr人员对应's EAS人员名称property 
     */
    public String getEASPersonName()
    {
        return getString("EASPersonName");
    }
    public void setEASPersonName(String item)
    {
        setString("EASPersonName", item);
    }
    /**
     * Object:EAS与shr人员对应's EAS人员编码property 
     */
    public String getEASPersonNum()
    {
        return getString("EASPersonNum");
    }
    public void setEASPersonNum(String item)
    {
        setString("EASPersonNum", item);
    }
    /**
     * Object:EAS与shr人员对应's 单据状态property 
     */
    public com.kingdee.eas.custom.salaryvoucher.voucherStatus getBillStatus()
    {
        return com.kingdee.eas.custom.salaryvoucher.voucherStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.salaryvoucher.voucherStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("700B7880");
    }
}