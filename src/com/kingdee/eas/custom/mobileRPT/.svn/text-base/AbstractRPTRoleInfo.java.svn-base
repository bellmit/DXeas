package com.kingdee.eas.custom.mobileRPT;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRPTRoleInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractRPTRoleInfo()
    {
        this("id");
    }
    protected AbstractRPTRoleInfo(String pkField)
    {
        super(pkField);
        put("RoleEntry", new com.kingdee.eas.custom.mobileRPT.RPTRoleRoleEntryCollection());
    }
    /**
     * Object:报表权限's 报表名称property 
     */
    public com.kingdee.eas.custom.mobileRPT.client.RPTNameEnum getRptName()
    {
        return com.kingdee.eas.custom.mobileRPT.client.RPTNameEnum.getEnum(getString("rptName"));
    }
    public void setRptName(com.kingdee.eas.custom.mobileRPT.client.RPTNameEnum item)
    {
		if (item != null) {
        setString("rptName", item.getValue());
		}
    }
    /**
     * Object: 报表权限 's 权限分录 property 
     */
    public com.kingdee.eas.custom.mobileRPT.RPTRoleRoleEntryCollection getRoleEntry()
    {
        return (com.kingdee.eas.custom.mobileRPT.RPTRoleRoleEntryCollection)get("RoleEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("77C90EAD");
    }
}