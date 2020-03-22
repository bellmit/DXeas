package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFoodDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFoodDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractFoodDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 产品明细 's null property 
     */
    public com.kingdee.eas.custom.dx.baseset.FoodDailyInfo getParent()
    {
        return (com.kingdee.eas.custom.dx.baseset.FoodDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.dx.baseset.FoodDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 产品明细 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNum()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNum");
    }
    public void setMaterialNum(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNum", item);
    }
    /**
     * Object:产品明细's 物料名称property 
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
     * Object:产品明细's 规格property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object: 产品明细 's 物料类别 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroup");
    }
    public void setMaterialGroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroup", item);
    }
    /**
     * Object:产品明细's 数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:产品明细's 单价property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:产品明细's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:产品明细's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:产品明细's 出成率property 
     */
    public java.math.BigDecimal getCcRate()
    {
        return getBigDecimal("ccRate");
    }
    public void setCcRate(java.math.BigDecimal item)
    {
        setBigDecimal("ccRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("25BFCE23");
    }
}