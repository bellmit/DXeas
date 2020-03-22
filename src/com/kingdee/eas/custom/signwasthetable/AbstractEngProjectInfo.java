package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEngProjectInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEngProjectInfo()
    {
        this("id");
    }
    protected AbstractEngProjectInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 工程项目 's 组别 property 
     */
    public com.kingdee.eas.custom.signwasthetable.EngProjectTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.signwasthetable.EngProjectTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.signwasthetable.EngProjectTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:工程项目's 备注property 
     */
    public String getBIMUDF0003()
    {
        return getString("BIMUDF0003");
    }
    public void setBIMUDF0003(String item)
    {
        setString("BIMUDF0003", item);
    }
    /**
     * Object:工程项目's 状态property 
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
        return new BOSObjectType("C178BAE5");
    }
}