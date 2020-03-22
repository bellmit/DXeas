package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSignTypeInfo()
    {
        this("id");
    }
    protected AbstractSignTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 签呈类别 's 组别 property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.signwasthetable.SignTypeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 签呈类别 's 行政组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrgUnit");
    }
    public void setAdminOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrgUnit", item);
    }
    /**
     * Object: 签呈类别 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrgUnit");
    }
    public void setStoOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrgUnit", item);
    }
    /**
     * Object: 签呈类别 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFIOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FIOrgUnit");
    }
    public void setFIOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FIOrgUnit", item);
    }
    /**
     * Object:签呈类别's 描述property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:签呈类别's 单据状态property 
     */
    public com.kingdee.eas.custom.signwasthetable.UsedStatus getBillStatus()
    {
        return com.kingdee.eas.custom.signwasthetable.UsedStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.signwasthetable.UsedStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C0644BA1");
    }
}