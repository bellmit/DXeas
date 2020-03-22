package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountGridLogInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDiscountGridLogInfo()
    {
        this("id");
    }
    protected AbstractDiscountGridLogInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.salediscount.DiscountGridLogEntryCollection());
    }
    /**
     * Object: 折让计算日志 's 分录 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountGridLogEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountGridLogEntryCollection)get("entrys");
    }
    /**
     * Object:折让计算日志's 是否生成凭证property 
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
     * Object:折让计算日志's 订单编号property 
     */
    public String getOrderNumber()
    {
        return getString("orderNumber");
    }
    public void setOrderNumber(String item)
    {
        setString("orderNumber", item);
    }
    /**
     * Object: 折让计算日志 's 销售订单 property 
     */
    public com.kingdee.eas.scm.sd.sale.SaleOrderInfo getSaleOrder()
    {
        return (com.kingdee.eas.scm.sd.sale.SaleOrderInfo)get("saleOrder");
    }
    public void setSaleOrder(com.kingdee.eas.scm.sd.sale.SaleOrderInfo item)
    {
        put("saleOrder", item);
    }
    /**
     * Object:折让计算日志's 客户IDproperty 
     */
    public String getCustomerID()
    {
        return getString("customerID");
    }
    public void setCustomerID(String item)
    {
        setString("customerID", item);
    }
    /**
     * Object:折让计算日志's 上级客户IDproperty 
     */
    public String getParentCustomerID()
    {
        return getString("parentCustomerID");
    }
    public void setParentCustomerID(String item)
    {
        setString("parentCustomerID", item);
    }
    /**
     * Object: 折让计算日志 's 销售退货申请单 property 
     */
    public com.kingdee.eas.scm.sd.sale.SaleReturnsInfo getSaleReturns()
    {
        return (com.kingdee.eas.scm.sd.sale.SaleReturnsInfo)get("saleReturns");
    }
    public void setSaleReturns(com.kingdee.eas.scm.sd.sale.SaleReturnsInfo item)
    {
        put("saleReturns", item);
    }
    /**
     * Object:折让计算日志's 退货property 
     */
    public boolean isIsSaleReturns()
    {
        return getBoolean("isSaleReturns");
    }
    public void setIsSaleReturns(boolean item)
    {
        setBoolean("isSaleReturns", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("886C3F42");
    }
}