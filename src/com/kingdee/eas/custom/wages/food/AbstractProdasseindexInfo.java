package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProdasseindexInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractProdasseindexInfo()
    {
        this("id");
    }
    protected AbstractProdasseindexInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.food.ProdasseindexEntryCollection());
    }
    /**
     * Object: 生产考核指标 's 岗位人员 property 
     */
    public com.kingdee.eas.custom.wages.food.ProdasseindexEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.food.ProdasseindexEntryCollection)get("Entry");
    }
    /**
     * Object:生产考核指标's 资料状态property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBaseStatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("BaseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("BaseStatus", item.getValue());
		}
    }
    /**
     * Object: 生产考核指标 's 考核负责人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getExaminPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("ExaminPerson");
    }
    public void setExaminPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("ExaminPerson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("015C8215");
    }
}