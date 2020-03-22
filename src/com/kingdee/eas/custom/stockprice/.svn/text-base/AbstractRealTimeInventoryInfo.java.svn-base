package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRealTimeInventoryInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractRealTimeInventoryInfo()
    {
        this("id");
    }
    protected AbstractRealTimeInventoryInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.stockprice.RealTimeInventoryEntryCollection());
    }
    /**
     * Object: 即时库存 's 分录 property 
     */
    public com.kingdee.eas.custom.stockprice.RealTimeInventoryEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.stockprice.RealTimeInventoryEntryCollection)get("entrys");
    }
    /**
     * Object:即时库存's 是否生成凭证property 
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
     * Object: 即时库存 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrgUnit");
    }
    public void setStoOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrgUnit", item);
    }
    /**
     * Object:即时库存's 审核日期property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8D7BB9A1");
    }
}