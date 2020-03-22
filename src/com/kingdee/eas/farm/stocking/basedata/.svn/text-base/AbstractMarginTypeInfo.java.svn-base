package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMarginTypeInfo()
    {
        this("id");
    }
    protected AbstractMarginTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保证金类型 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.MarginTypeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.MarginTypeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.MarginTypeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:保证金类型's 内容property 
     */
    public String getContext()
    {
        return getString("context");
    }
    public void setContext(String item)
    {
        setString("context", item);
    }
    /**
     * Object:保证金类型's 基本状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 保证金类型 's 财务组织 property 
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
        return new BOSObjectType("AEE5CC19");
    }
}