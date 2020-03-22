package com.kingdee.eas.wlhlcomm.function;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTobeUpdateBillsInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTobeUpdateBillsInfo()
    {
        this("id");
    }
    protected AbstractTobeUpdateBillsInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsEntryCollection());
        put("PersonEntrys", new com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsPersonEntryCollection());
    }
    /**
     * Object: 更新单据设置 's 字段信息 property 
     */
    public com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsEntryCollection getEntrys()
    {
        return (com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsEntryCollection)get("entrys");
    }
    /**
     * Object:更新单据设置's 是否生成凭证property 
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
     * Object:更新单据设置's 单据名称property 
     */
    public String getBillName()
    {
        return getString("billName");
    }
    public void setBillName(String item)
    {
        setString("billName", item);
    }
    /**
     * Object: 更新单据设置 's 更新用户 property 
     */
    public com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsPersonEntryCollection getPersonEntrys()
    {
        return (com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsPersonEntryCollection)get("PersonEntrys");
    }
    /**
     * Object:更新单据设置's 需更新原因property 
     */
    public String getUpdateReason()
    {
        return getString("updateReason");
    }
    public void setUpdateReason(String item)
    {
        setString("updateReason", item);
    }
    /**
     * Object:更新单据设置's 业务板块property 
     */
    public String getBusiType()
    {
        return getString("busiType");
    }
    public void setBusiType(String item)
    {
        setString("busiType", item);
    }
    /**
     * Object:更新单据设置's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("85129626");
    }
}