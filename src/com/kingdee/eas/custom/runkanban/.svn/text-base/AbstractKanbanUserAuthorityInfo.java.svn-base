package com.kingdee.eas.custom.runkanban;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractKanbanUserAuthorityInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractKanbanUserAuthorityInfo()
    {
        this("id");
    }
    protected AbstractKanbanUserAuthorityInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.runkanban.KanbanUserAuthorityEntryCollection());
    }
    /**
     * Object: 经营看板用户权限 's 分录 property 
     */
    public com.kingdee.eas.custom.runkanban.KanbanUserAuthorityEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.runkanban.KanbanUserAuthorityEntryCollection)get("entrys");
    }
    /**
     * Object:经营看板用户权限's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 经营看板用户权限 's 用户 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getName()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("name");
    }
    public void setName(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("name", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("552FA0F0");
    }
}