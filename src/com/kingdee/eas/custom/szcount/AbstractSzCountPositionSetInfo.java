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
     * Object: 计数岗位 's 组别 property 
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
     * Object: 计数岗位 's 操作员分录 property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryCollection getOperatorEntry()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryCollection)get("OperatorEntry");
    }
    /**
     * Object: 计数岗位 's 产品列表 property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryCollection getMaterialEntry()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryCollection)get("MaterialEntry");
    }
    /**
     * Object: 计数岗位 's 部门 property 
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
     * Object:计数岗位's 岗位选择property 
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
     * Object:计数岗位's 岗位状态property 
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
     * Object: 计数岗位 's 公司 property 
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
     * Object:计数岗位's 是否自动生成入库单property 
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
     * Object:计数岗位's 是否是冰鲜品计数员property 
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