package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCmChangeInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCmChangeInfo()
    {
        this("id");
    }
    protected AbstractCmChangeInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.signwasthetable.CmChangeEntryCollection());
    }
    /**
     * Object: 合同变更查看 's 分录 property 
     */
    public com.kingdee.eas.custom.signwasthetable.CmChangeEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.signwasthetable.CmChangeEntryCollection)get("entrys");
    }
    /**
     * Object:合同变更查看's 是否生成凭证property 
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
     * Object:合同变更查看's 当前版本property 
     */
    public String getVersion()
    {
        return getString("Version");
    }
    public void setVersion(String item)
    {
        setString("Version", item);
    }
    /**
     * Object:合同变更查看's 上一版本property 
     */
    public String getPreVersion()
    {
        return getString("preVersion");
    }
    public void setPreVersion(String item)
    {
        setString("preVersion", item);
    }
    /**
     * Object:合同变更查看's 查看日期property 
     */
    public java.util.Date getViewDate()
    {
        return getDate("ViewDate");
    }
    public void setViewDate(java.util.Date item)
    {
        setDate("ViewDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D82D25C4");
    }
}