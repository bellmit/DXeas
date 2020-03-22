package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInvestmentPolicyChickenEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInvestmentPolicyChickenEntryInfo()
    {
        this("id");
    }
    protected AbstractInvestmentPolicyChickenEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 药品成本物料分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:药品成本物料分录's 成本property 
     */
    public java.math.BigDecimal getCost()
    {
        return getBigDecimal("cost");
    }
    public void setCost(java.math.BigDecimal item)
    {
        setBigDecimal("cost", item);
    }
    /**
     * Object: 药品成本物料分录 's 结算项目 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettleItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settleItem");
    }
    public void setSettleItem(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settleItem", item);
    }
    /**
     * Object:药品成本物料分录's 生效日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:药品成本物料分录's 失效日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:药品成本物料分录's 成本价格property 
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
     * Object:药品成本物料分录's 合同结算价格property 
     */
    public java.math.BigDecimal getContractPrice()
    {
        return getBigDecimal("contractPrice");
    }
    public void setContractPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractPrice", item);
    }
    /**
     * Object:药品成本物料分录's 市场结算价格property 
     */
    public java.math.BigDecimal getMarketPrice()
    {
        return getBigDecimal("marketPrice");
    }
    public void setMarketPrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketPrice", item);
    }
    /**
     * Object: 药品成本物料分录 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNuo()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNuo");
    }
    public void setMaterialNuo(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNuo", item);
    }
    /**
     * Object:药品成本物料分录's 物料名称property 
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
     * Object:药品成本物料分录's 打疫苗溢价空间property 
     */
    public java.math.BigDecimal getOutPrice()
    {
        return getBigDecimal("outPrice");
    }
    public void setOutPrice(java.math.BigDecimal item)
    {
        setBigDecimal("outPrice", item);
    }
    /**
     * Object:药品成本物料分录's 规格型号property 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    /**
     * Object:药品成本物料分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("26691CE4");
    }
}