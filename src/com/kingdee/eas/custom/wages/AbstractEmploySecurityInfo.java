package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEmploySecurityInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEmploySecurityInfo()
    {
        this("id");
    }
    protected AbstractEmploySecurityInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.EmploySecurityEntryCollection());
    }
    /**
     * Object: 员工社保福利 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.EmploySecurityEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.EmploySecurityEntryCollection)get("entrys");
    }
    /**
     * Object:员工社保福利's 是否生成凭证property 
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
     * Object:员工社保福利's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object:员工社保福利's 单据名称property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9D8420F6");
    }
}