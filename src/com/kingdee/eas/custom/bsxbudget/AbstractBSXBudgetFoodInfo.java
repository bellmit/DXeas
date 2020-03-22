package com.kingdee.eas.custom.bsxbudget;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBSXBudgetFoodInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBSXBudgetFoodInfo()
    {
        this("id");
    }
    protected AbstractBSXBudgetFoodInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ���ʱ��property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: ʳƷ��Ԥ�� 's �ڼ� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s Ԥ������property 
     */
    public java.math.BigDecimal getExpectedSalesAmt()
    {
        return getBigDecimal("expectedSalesAmt");
    }
    public void setExpectedSalesAmt(java.math.BigDecimal item)
    {
        setBigDecimal("expectedSalesAmt", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s Ԥ�ƶ�ƽ���ۼ�property 
     */
    public java.math.BigDecimal getExpectedPricePerTon()
    {
        return getBigDecimal("expectedPricePerTon");
    }
    public void setExpectedPricePerTon(java.math.BigDecimal item)
    {
        setBigDecimal("expectedPricePerTon", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s Ԥ����������property 
     */
    public java.math.BigDecimal getExpectedSalesRevenue()
    {
        return getBigDecimal("expectedSalesRevenue");
    }
    public void setExpectedSalesRevenue(java.math.BigDecimal item)
    {
        setBigDecimal("expectedSalesRevenue", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ë���չ�����property 
     */
    public java.math.BigDecimal getTotalWeight()
    {
        return getBigDecimal("totalWeight");
    }
    public void setTotalWeight(java.math.BigDecimal item)
    {
        setBigDecimal("totalWeight", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ��λë���չ��۸�property 
     */
    public java.math.BigDecimal getPricePerKG()
    {
        return getBigDecimal("pricePerKG");
    }
    public void setPricePerKG(java.math.BigDecimal item)
    {
        setBigDecimal("pricePerKG", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ë���չ��ܳɱ�property 
     */
    public java.math.BigDecimal getTotolCost()
    {
        return getBigDecimal("totolCost");
    }
    public void setTotolCost(java.math.BigDecimal item)
    {
        setBigDecimal("totolCost", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ë��������property 
     */
    public java.math.BigDecimal getYieldRate()
    {
        return getBigDecimal("yieldRate");
    }
    public void setYieldRate(java.math.BigDecimal item)
    {
        setBigDecimal("yieldRate", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ë������property 
     */
    public java.math.BigDecimal getYield()
    {
        return getBigDecimal("yield");
    }
    public void setYield(java.math.BigDecimal item)
    {
        setBigDecimal("yield", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ��������property 
     */
    public java.math.BigDecimal getProductCost()
    {
        return getBigDecimal("productCost");
    }
    public void setProductCost(java.math.BigDecimal item)
    {
        setBigDecimal("productCost", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s �����ڳ������property 
     */
    public java.math.BigDecimal getStockAtMonthBegin()
    {
        return getBigDecimal("stockAtMonthBegin");
    }
    public void setStockAtMonthBegin(java.math.BigDecimal item)
    {
        setBigDecimal("stockAtMonthBegin", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s �����ڳ�����ܼ�ֵproperty 
     */
    public java.math.BigDecimal getStockAmtAtMonthBegin()
    {
        return getBigDecimal("stockAmtAtMonthBegin");
    }
    public void setStockAmtAtMonthBegin(java.math.BigDecimal item)
    {
        setBigDecimal("stockAmtAtMonthBegin", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ����Ԥ���������property 
     */
    public java.math.BigDecimal getExpectedRec()
    {
        return getBigDecimal("expectedRec");
    }
    public void setExpectedRec(java.math.BigDecimal item)
    {
        setBigDecimal("expectedRec", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s �������property 
     */
    public java.math.BigDecimal getManageFee()
    {
        return getBigDecimal("manageFee");
    }
    public void setManageFee(java.math.BigDecimal item)
    {
        setBigDecimal("manageFee", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s �������property 
     */
    public java.math.BigDecimal getFIFee()
    {
        return getBigDecimal("FIFee");
    }
    public void setFIFee(java.math.BigDecimal item)
    {
        setBigDecimal("FIFee", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ���۷���property 
     */
    public java.math.BigDecimal getSaleFee()
    {
        return getBigDecimal("saleFee");
    }
    public void setSaleFee(java.math.BigDecimal item)
    {
        setBigDecimal("saleFee", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ����ë��property 
     */
    public java.math.BigDecimal getSaleProfit()
    {
        return getBigDecimal("saleProfit");
    }
    public void setSaleProfit(java.math.BigDecimal item)
    {
        setBigDecimal("saleProfit", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ��˾����property 
     */
    public java.math.BigDecimal getCompanyProfit()
    {
        return getBigDecimal("companyProfit");
    }
    public void setCompanyProfit(java.math.BigDecimal item)
    {
        setBigDecimal("companyProfit", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ����Ԥ������ֵproperty 
     */
    public java.math.BigDecimal getPredictRecAmt()
    {
        return getBigDecimal("predictRecAmt");
    }
    public void setPredictRecAmt(java.math.BigDecimal item)
    {
        setBigDecimal("predictRecAmt", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s Ԥ�����۳ɱ�property 
     */
    public java.math.BigDecimal getExpectedSaleCost()
    {
        return getBigDecimal("expectedSaleCost");
    }
    public void setExpectedSaleCost(java.math.BigDecimal item)
    {
        setBigDecimal("expectedSaleCost", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s Ԥ�Ƶ�λ���۳ɱ�property 
     */
    public java.math.BigDecimal getExpectedsalesCostPerKG()
    {
        return getBigDecimal("expectedsalesCostPerKG");
    }
    public void setExpectedsalesCostPerKG(java.math.BigDecimal item)
    {
        setBigDecimal("expectedsalesCostPerKG", item);
    }
    /**
     * Object:ʳƷ��Ԥ��'s ����״̬property 
     */
    public com.kingdee.eas.custom.bsxbudget.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.bsxbudget.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.bsxbudget.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("855505A3");
    }
}