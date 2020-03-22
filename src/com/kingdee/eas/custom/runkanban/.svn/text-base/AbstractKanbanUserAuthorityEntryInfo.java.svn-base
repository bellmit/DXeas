package com.kingdee.eas.custom.runkanban;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractKanbanUserAuthorityEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractKanbanUserAuthorityEntryInfo()
    {
        this("id");
    }
    protected AbstractKanbanUserAuthorityEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.runkanban.KanbanUserAuthorityInfo getParent()
    {
        return (com.kingdee.eas.custom.runkanban.KanbanUserAuthorityInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.runkanban.KanbanUserAuthorityInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 权限名称 property 
     */
    public com.kingdee.eas.custom.runkanban.KanbanAuthroityInfo getAuthorityName()
    {
        return (com.kingdee.eas.custom.runkanban.KanbanAuthroityInfo)get("AuthorityName");
    }
    public void setAuthorityName(com.kingdee.eas.custom.runkanban.KanbanAuthroityInfo item)
    {
        put("AuthorityName", item);
    }
    /**
     * Object:分录's 权限描述property 
     */
    public String getAuthorityDesc()
    {
        return getString("AuthorityDesc");
    }
    public void setAuthorityDesc(String item)
    {
        setString("AuthorityDesc", item);
    }
    /**
     * Object:分录's 权限编码property 
     */
    public String getAuthoritynumber()
    {
        return getString("authoritynumber");
    }
    public void setAuthoritynumber(String item)
    {
        setString("authoritynumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("351F8D62");
    }
}