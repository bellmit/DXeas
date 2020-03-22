package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignBDInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSignBDInfo()
    {
        this("id");
    }
    protected AbstractSignBDInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:«©≥ ¿‡–Õ's √Ë ˆproperty 
     */
    public String getDescriptionS()
    {
        return getString("descriptionS");
    }
    public void setDescriptionS(String item)
    {
        setString("descriptionS", item);
    }
    /**
     * Object:«©≥ ¿‡–Õ's ◊¥Ã¨property 
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
        return new BOSObjectType("5D6FB649");
    }
}