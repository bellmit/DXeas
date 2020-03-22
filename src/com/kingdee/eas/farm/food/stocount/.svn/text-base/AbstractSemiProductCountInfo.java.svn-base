package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSemiProductCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSemiProductCountInfo()
    {
        this("id");
    }
    protected AbstractSemiProductCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.food.stocount.SemiProductCountEntryCollection());
    }
    /**
     * Object: 半成品计数单 's 分录 property 
     */
    public com.kingdee.eas.farm.food.stocount.SemiProductCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.stocount.SemiProductCountEntryCollection)get("entrys");
    }
    /**
     * Object:半成品计数单's 是否生成凭证property 
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
     * Object:半成品计数单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object: 半成品计数单 's 计数员 property 
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
     * Object: 半成品计数单 's 技术岗位 property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetInfo getSemcount()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetInfo)get("semcount");
    }
    public void setSemcount(com.kingdee.eas.farm.food.stocount.CountPositionSetInfo item)
    {
        put("semcount", item);
    }
    /**
     * Object:半成品计数单's 班次property 
     */
    public com.kingdee.eas.farm.food.stocount.Classes getClasses()
    {
        return com.kingdee.eas.farm.food.stocount.Classes.getEnum(getString("classes"));
    }
    public void setClasses(com.kingdee.eas.farm.food.stocount.Classes item)
    {
		if (item != null) {
        setString("classes", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1F4754AB");
    }
}