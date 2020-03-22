package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSzCountPositionSetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSzCountPositionSetInfo()
    {
        this("id");
    }
    protected AbstractSzCountPositionSetInfo(String pkField)
    {
        super(pkField);
        put("MaterialEntry", new com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryCollection());
        put("OperatorEntry", new com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryCollection());
    }
    /**
     * Object: ������λ 's ��� property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: ������λ 's ����Ա��¼ property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryCollection getOperatorEntry()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryCollection)get("OperatorEntry");
    }
    /**
     * Object: ������λ 's ��Ʒ�б� property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryCollection getMaterialEntry()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryCollection)get("MaterialEntry");
    }
    /**
     * Object: ������λ 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:������λ's ��λѡ��property 
     */
    public com.kingdee.eas.custom.szcount.szCountSet getCountset()
    {
        return com.kingdee.eas.custom.szcount.szCountSet.getEnum(getString("countset"));
    }
    public void setCountset(com.kingdee.eas.custom.szcount.szCountSet item)
    {
		if (item != null) {
        setString("countset", item.getValue());
		}
    }
    /**
     * Object:������λ's ��λ״̬property 
     */
    public com.kingdee.eas.custom.szcount.szcanorcancel getBaseStatus()
    {
        return com.kingdee.eas.custom.szcount.szcanorcancel.getEnum(getString("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.szcount.szcanorcancel item)
    {
		if (item != null) {
        setString("baseStatus", item.getValue());
		}
    }
    /**
     * Object: ������λ 's ��˾ property 
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
     * Object:������λ's �Ƿ��Զ�������ⵥproperty 
     */
    public boolean isIsManufacture()
    {
        return getBoolean("isManufacture");
    }
    public void setIsManufacture(boolean item)
    {
        setBoolean("isManufacture", item);
    }
    /**
     * Object:������λ's �Ƿ��Ǳ���Ʒ����Աproperty 
     */
    public boolean isIsIceFrish()
    {
        return getBoolean("isIceFrish");
    }
    public void setIsIceFrish(boolean item)
    {
        setBoolean("isIceFrish", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("382C2B1C");
    }
}