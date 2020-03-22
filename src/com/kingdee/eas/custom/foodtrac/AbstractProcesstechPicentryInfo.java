package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProcesstechPicentryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProcesstechPicentryInfo()
    {
        this("id");
    }
    protected AbstractProcesstechPicentryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: Í¼Æ¬·ÖÂ¼ 's null property 
     */
    public com.kingdee.eas.custom.foodtrac.ProcesstechInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.ProcesstechInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.ProcesstechInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:Í¼Æ¬·ÖÂ¼'s Í¼Æ¬Ãû³Æproperty 
     */
    public String getPicname()
    {
        return getString("picname");
    }
    public void setPicname(String item)
    {
        setString("picname", item);
    }
    /**
     * Object:Í¼Æ¬·ÖÂ¼'s Í¼Æ¬Â·¾¶property 
     */
    public String getPicpath()
    {
        return getString("picpath");
    }
    public void setPicpath(String item)
    {
        setString("picpath", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A4F3A4E8");
    }
}