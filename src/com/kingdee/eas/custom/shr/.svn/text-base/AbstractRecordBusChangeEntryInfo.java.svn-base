package com.kingdee.eas.custom.shr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRecordBusChangeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRecordBusChangeEntryInfo()
    {
        this("id");
    }
    protected AbstractRecordBusChangeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.shr.RecordBusChangeInfo getParent()
    {
        return (com.kingdee.eas.custom.shr.RecordBusChangeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.shr.RecordBusChangeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 员工编码property 
     */
    public String getNumber()
    {
        return getString("Number");
    }
    public void setNumber(String item)
    {
        setString("Number", item);
    }
    /**
     * Object:分录's 姓名property 
     */
    public String getName()
    {
        return getString("Name");
    }
    public void setName(String item)
    {
        setString("Name", item);
    }
    /**
     * Object:分录's 修改前车号property 
     */
    public String getPreBus()
    {
        return getString("preBus");
    }
    public void setPreBus(String item)
    {
        setString("preBus", item);
    }
    /**
     * Object:分录's 修改后车号property 
     */
    public String getAfterBus()
    {
        return getString("afterBus");
    }
    public void setAfterBus(String item)
    {
        setString("afterBus", item);
    }
    /**
     * Object:分录's 修改前站点property 
     */
    public String getPreStop()
    {
        return getString("preStop");
    }
    public void setPreStop(String item)
    {
        setString("preStop", item);
    }
    /**
     * Object:分录's 修改后站点property 
     */
    public String getAfterStop()
    {
        return getString("afterStop");
    }
    public void setAfterStop(String item)
    {
        setString("afterStop", item);
    }
    /**
     * Object: 分录 's 操作人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    /**
     * Object:分录's 修改时间property 
     */
    public String getTime()
    {
        return getString("Time");
    }
    public void setTime(String item)
    {
        setString("Time", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("08A4C489");
    }
}