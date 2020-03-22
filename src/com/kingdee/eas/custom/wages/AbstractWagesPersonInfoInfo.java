package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWagesPersonInfoInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractWagesPersonInfoInfo()
    {
        this("id");
    }
    protected AbstractWagesPersonInfoInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.WagesPersonInfoEntryCollection());
    }
    /**
     * Object: 员工SHR信息备份 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.WagesPersonInfoEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.WagesPersonInfoEntryCollection)get("entrys");
    }
    /**
     * Object:员工SHR信息备份's 单据状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("607FA346");
    }
}