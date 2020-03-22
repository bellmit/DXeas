package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPersonTypeInfo()
    {
        this("id");
    }
    protected AbstractPersonTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:人员类别's 描述property 
     */
    public String getDescriptions()
    {
        return getString("descriptions");
    }
    public void setDescriptions(String item)
    {
        setString("descriptions", item);
    }
    /**
     * Object:人员类别's 单据状态property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.applicationofsocialsecurity.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.applicationofsocialsecurity.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4EDEACCE");
    }
}