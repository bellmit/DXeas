package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractGrossProfitInfoRecEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractGrossProfitInfoRecEntryInfo()
    {
        this("id");
    }
    protected AbstractGrossProfitInfoRecEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���ۻؿ���ϸ 's null property 
     */
    public com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ���ۻؿ���ϸ 's �ͻ� property 
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
     * Object: ���ۻؿ���ϸ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object: ���ۻؿ���ϸ 's ������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:���ۻؿ���ϸ's �ؿ�����property 
     */
    public java.math.BigDecimal getRecQty()
    {
        return getBigDecimal("recQty");
    }
    public void setRecQty(java.math.BigDecimal item)
    {
        setBigDecimal("recQty", item);
    }
    /**
     * Object:���ۻؿ���ϸ's �ؿ���property 
     */
    public java.math.BigDecimal getRecAmount()
    {
        return getBigDecimal("recAmount");
    }
    public void setRecAmount(java.math.BigDecimal item)
    {
        setBigDecimal("recAmount", item);
    }
    /**
     * Object:���ۻؿ���ϸ's ��λ��׼�ɱ�property 
     */
    public java.math.BigDecimal getUnitCost()
    {
        return getBigDecimal("unitCost");
    }
    public void setUnitCost(java.math.BigDecimal item)
    {
        setBigDecimal("unitCost", item);
    }
    /**
     * Object:���ۻؿ���ϸ's �ܳɱ�property 
     */
    public java.math.BigDecimal getAllCost()
    {
        return getBigDecimal("allCost");
    }
    public void setAllCost(java.math.BigDecimal item)
    {
        setBigDecimal("allCost", item);
    }
    /**
     * Object:���ۻؿ���ϸ's �ؿ�ë��property 
     */
    public java.math.BigDecimal getGrossProfit()
    {
        return getBigDecimal("grossProfit");
    }
    public void setGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("grossProfit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F3A708E4");
    }
}