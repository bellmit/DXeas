package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettleBillCompanyEntryPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggSettleBillCompanyEntryPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractEggSettleBillCompanyEntryPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 价格明细 's null property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 价格明细 's 物料编码 property 
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
     * Object:价格明细's 物料名称property 
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
     * Object:价格明细's 规格property 
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
     * Object:价格明细's 数量property 
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
     * Object:价格明细's 单价property 
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
     * Object:价格明细's 金额property 
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
     * Object:价格明细's 备注property 
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
     * Object:价格明细's 枚数property 
     */
    public int getNum()
    {
        return getInt("num");
    }
    public void setNum(int item)
    {
        setInt("num", item);
    }
    /**
     * Object:价格明细's 路损数量property 
     */
    public java.math.BigDecimal getLossQty()
    {
        return getBigDecimal("lossQty");
    }
    public void setLossQty(java.math.BigDecimal item)
    {
        setBigDecimal("lossQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0ECD8F0B");
    }
}