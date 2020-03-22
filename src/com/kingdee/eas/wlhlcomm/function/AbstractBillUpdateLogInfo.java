package com.kingdee.eas.wlhlcomm.function;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBillUpdateLogInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBillUpdateLogInfo()
    {
        this("id");
    }
    protected AbstractBillUpdateLogInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.wlhlcomm.function.BillUpdateLogEntryCollection());
    }
    /**
     * Object: 单据更新记录 's 分录 property 
     */
    public com.kingdee.eas.wlhlcomm.function.BillUpdateLogEntryCollection getEntrys()
    {
        return (com.kingdee.eas.wlhlcomm.function.BillUpdateLogEntryCollection)get("entrys");
    }
    /**
     * Object:单据更新记录's 是否生成凭证property 
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
     * Object:单据更新记录's 更新单据名称property 
     */
    public String getSourceBillName()
    {
        return getString("sourceBillName");
    }
    public void setSourceBillName(String item)
    {
        setString("sourceBillName", item);
    }
    /**
     * Object:单据更新记录's 更新单据编码property 
     */
    public String getSourceBillNumber()
    {
        return getString("sourceBillNumber");
    }
    public void setSourceBillNumber(String item)
    {
        setString("sourceBillNumber", item);
    }
    /**
     * Object:单据更新记录's 更新单据IDproperty 
     */
    public String getBillID()
    {
        return getString("billID");
    }
    public void setBillID(String item)
    {
        setString("billID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AA9B08B5");
    }
}