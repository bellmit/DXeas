package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalesPriceInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSalesPriceInfo()
    {
        this("id");
    }
    protected AbstractSalesPriceInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.stockprice.SalesPriceEntryCollection());
    }
    /**
     * Object: 销售价格 's 分录 property 
     */
    public com.kingdee.eas.custom.stockprice.SalesPriceEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.stockprice.SalesPriceEntryCollection)get("entrys");
    }
    /**
     * Object:销售价格's 是否生成凭证property 
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
     * Object: 销售价格 's 管理单元 property 
     */
    public com.kingdee.eas.basedata.org.CtrlUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CtrlUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CtrlUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:销售价格's 审核时间property 
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
        return new BOSObjectType("AFF94C0D");
    }
}