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
     * Object: ��Ӫ�����û�Ȩ�� 's ��¼ property 
     */
    public com.kingdee.eas.custom.runkanban.KanbanUserAuthorityEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.runkanban.KanbanUserAuthorityEntryCollection)get("entrys");
    }
    /**
     * Object:��Ӫ�����û�Ȩ��'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ӫ�����û�Ȩ�� 's �û� property 
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