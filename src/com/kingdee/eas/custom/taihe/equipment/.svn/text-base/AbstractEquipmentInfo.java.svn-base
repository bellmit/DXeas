package com.kingdee.eas.custom.taihe.equipment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEquipmentInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEquipmentInfo()
    {
        this("id");
    }
    protected AbstractEquipmentInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 设备信息 's 组别 property 
     */
    public com.kingdee.eas.custom.taihe.equipment.EquipmentTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.taihe.equipment.EquipmentTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.taihe.equipment.EquipmentTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 设备信息 's 公司 property 
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
     * Object: 设备信息 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("70CF4F34");
    }
}