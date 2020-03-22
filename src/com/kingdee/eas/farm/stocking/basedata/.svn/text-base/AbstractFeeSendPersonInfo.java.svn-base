package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeeSendPersonInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFeeSendPersonInfo()
    {
        this("id");
    }
    protected AbstractFeeSendPersonInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 送料人 's 员工 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:送料人's 状态property 
     */
    public com.kingdee.eas.farm.hatch.billStatus getBillStatus()
    {
        return com.kingdee.eas.farm.hatch.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.farm.hatch.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B2617972");
    }
}