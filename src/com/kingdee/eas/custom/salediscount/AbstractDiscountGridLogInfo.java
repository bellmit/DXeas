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
     * Object: ���ü�����־ 's ��¼ property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountGridLogEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountGridLogEntryCollection)get("entrys");
    }
    /**
     * Object:���ü�����־'s �Ƿ�����ƾ֤property 
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
     * Object:���ü�����־'s �������property 
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
     * Object: ���ü�����־ 's ���۶��� property 
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
     * Object:���ü�����־'s �ͻ�IDproperty 
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
     * Object:���ü�����־'s �ϼ��ͻ�IDproperty 
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
     * Object: ���ü�����־ 's �����˻����뵥 property 
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
     * Object:���ü�����־'s �˻�property 
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