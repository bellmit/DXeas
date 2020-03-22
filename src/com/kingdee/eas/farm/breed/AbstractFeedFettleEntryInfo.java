package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFettleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFeedFettleEntryInfo()
    {
        this("id");
    }
    protected AbstractFeedFettleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.FeedFettleInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.FeedFettleInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.FeedFettleInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 单据日期property 
     */
    public java.util.Date getBillDate()
    {
        return getDate("billDate");
    }
    public void setBillDate(java.util.Date item)
    {
        setDate("billDate", item);
    }
    /**
     * Object:分录's 单据编号property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    /**
     * Object: 分录 's 物料 property 
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
     * Object:分录's 物料名称property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:分录's 数量(kg)property 
     */
    public java.math.BigDecimal getBaseQty()
    {
        return getBigDecimal("baseQty");
    }
    public void setBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseQty", item);
    }
    /**
     * Object:分录's 售价property 
     */
    public java.math.BigDecimal getSalePrice()
    {
        return getBigDecimal("salePrice");
    }
    public void setSalePrice(java.math.BigDecimal item)
    {
        setBigDecimal("salePrice", item);
    }
    /**
     * Object:分录's 销售额property 
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
     * Object:分录's 成本价property 
     */
    public java.math.BigDecimal getCostPrice()
    {
        return getBigDecimal("costPrice");
    }
    public void setCostPrice(java.math.BigDecimal item)
    {
        setBigDecimal("costPrice", item);
    }
    /**
     * Object:分录's 成本property 
     */
    public java.math.BigDecimal getCostAmount()
    {
        return getBigDecimal("costAmount");
    }
    public void setCostAmount(java.math.BigDecimal item)
    {
        setBigDecimal("costAmount", item);
    }
    /**
     * Object:分录's 公司毛利润property 
     */
    public java.math.BigDecimal getCompanyGrossProfit()
    {
        return getBigDecimal("companyGrossProfit");
    }
    public void setCompanyGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("companyGrossProfit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6157A502");
    }
}