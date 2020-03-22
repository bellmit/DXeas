package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenRecBillButcherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractChickenRecBillButcherEntryInfo()
    {
        this("id");
    }
    protected AbstractChickenRecBillButcherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������Ϣ's ����ֻ��property 
     */
    public java.math.BigDecimal getCarcassQty()
    {
        return getBigDecimal("carcassQty");
    }
    public void setCarcassQty(java.math.BigDecimal item)
    {
        setBigDecimal("carcassQty", item);
    }
    /**
     * Object:������Ϣ's ��������(��)property 
     */
    public java.math.BigDecimal getCarcassWeight()
    {
        return getBigDecimal("carcassWeight");
    }
    public void setCarcassWeight(java.math.BigDecimal item)
    {
        setBigDecimal("carcassWeight", item);
    }
    /**
     * Object:������Ϣ's ����ë������(��)property 
     */
    public java.math.BigDecimal getReducedWeight()
    {
        return getBigDecimal("reducedWeight");
    }
    public void setReducedWeight(java.math.BigDecimal item)
    {
        setBigDecimal("reducedWeight", item);
    }
    /**
     * Object:������Ϣ's ������(%)property 
     */
    public java.math.BigDecimal getAliveRate()
    {
        return getBigDecimal("aliveRate");
    }
    public void setAliveRate(java.math.BigDecimal item)
    {
        setBigDecimal("aliveRate", item);
    }
    /**
     * Object: ������Ϣ 's ���ۿͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:������Ϣ's ����ë���۸�(Ԫ/��)property 
     */
    public java.math.BigDecimal getSaleChickPrice()
    {
        return getBigDecimal("saleChickPrice");
    }
    public void setSaleChickPrice(java.math.BigDecimal item)
    {
        setBigDecimal("saleChickPrice", item);
    }
    /**
     * Object:������Ϣ's ���۽��property 
     */
    public java.math.BigDecimal getSaleAmount()
    {
        return getBigDecimal("saleAmount");
    }
    public void setSaleAmount(java.math.BigDecimal item)
    {
        setBigDecimal("saleAmount", item);
    }
    /**
     * Object:������Ϣ's ��������(��)property 
     */
    public java.math.BigDecimal getSaleQty()
    {
        return getBigDecimal("saleQty");
    }
    public void setSaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("saleQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("65F6FF1E");
    }
}