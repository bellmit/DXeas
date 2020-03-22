package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractThirdpartycheckPicentryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractThirdpartycheckPicentryInfo()
    {
        this("id");
    }
    protected AbstractThirdpartycheckPicentryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: Í¼Æ¬·ÖÂ¼ 's null property 
     */
    public com.kingdee.eas.custom.foodtrac.ThirdpartycheckInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.ThirdpartycheckInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.ThirdpartycheckInfo item)
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
        return new BOSObjectType("0188A46C");
    }
}