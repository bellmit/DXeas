package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedSeedReceiveBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedSeedReceiveBillEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedSeedReceiveBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 合同数量property 
     */
    public java.math.BigDecimal getReceiveQty()
    {
        return getBigDecimal("receiveQty");
    }
    public void setReceiveQty(java.math.BigDecimal item)
    {
        setBigDecimal("receiveQty", item);
    }
    /**
     * Object:分录's 领用单价property 
     */
    public java.math.BigDecimal getReceivePrice()
    {
        return getBigDecimal("receivePrice");
    }
    public void setReceivePrice(java.math.BigDecimal item)
    {
        setBigDecimal("receivePrice", item);
    }
    /**
     * Object: 分录 's 领用仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    /**
     * Object:分录's 确认数量property 
     */
    public java.math.BigDecimal getConfirmQty()
    {
        return getBigDecimal("confirmQty");
    }
    public void setConfirmQty(java.math.BigDecimal item)
    {
        setBigDecimal("confirmQty", item);
    }
    /**
     * Object:分录's 基础单价property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object: 分录 's 种苗编码 property 
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
     * Object:分录's 种苗名称property 
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
     * Object:分录's 规格property 
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
     * Object: 分录 's 单位 property 
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
     * Object:分录's 金额property 
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
     * Object:分录's 另补数量property 
     */
    public java.math.BigDecimal getSupplementQty()
    {
        return getBigDecimal("supplementQty");
    }
    public void setSupplementQty(java.math.BigDecimal item)
    {
        setBigDecimal("supplementQty", item);
    }
    /**
     * Object:分录's 路损数量property 
     */
    public java.math.BigDecimal getLossQty()
    {
        return getBigDecimal("lossQty");
    }
    public void setLossQty(java.math.BigDecimal item)
    {
        setBigDecimal("lossQty", item);
    }
    /**
     * Object:分录's 实际领用数量property 
     */
    public java.math.BigDecimal getAllReceiveQty()
    {
        return getBigDecimal("allReceiveQty");
    }
    public void setAllReceiveQty(java.math.BigDecimal item)
    {
        setBigDecimal("allReceiveQty", item);
    }
    /**
     * Object:分录's 单位成本property 
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
     * Object:分录's 实际成本property 
     */
    public java.math.BigDecimal getActualCost()
    {
        return getBigDecimal("actualCost");
    }
    public void setActualCost(java.math.BigDecimal item)
    {
        setBigDecimal("actualCost", item);
    }
    /**
     * Object:分录's 路耗数量property 
     */
    public java.math.BigDecimal getGiftQty()
    {
        return getBigDecimal("giftQty");
    }
    public void setGiftQty(java.math.BigDecimal item)
    {
        setBigDecimal("giftQty", item);
    }
    /**
     * Object:分录's 备注property 
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
     * Object:分录's 物料批次property 
     */
    public String getMaterialBatch()
    {
        return getString("materialBatch");
    }
    public void setMaterialBatch(String item)
    {
        setString("materialBatch", item);
    }
    /**
     * Object:分录's 领用数量备份property 
     */
    public java.math.BigDecimal getAllRQty()
    {
        return getBigDecimal("allRQty");
    }
    public void setAllRQty(java.math.BigDecimal item)
    {
        setBigDecimal("allRQty", item);
    }
    /**
     * Object:分录's 路耗数量备份property 
     */
    public java.math.BigDecimal getGqty()
    {
        return getBigDecimal("gqty");
    }
    public void setGqty(java.math.BigDecimal item)
    {
        setBigDecimal("gqty", item);
    }
    /**
     * Object: 分录 's 棚舍 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:分录's 返雏数量property 
     */
    public java.math.BigDecimal getReturnChicken()
    {
        return getBigDecimal("returnChicken");
    }
    public void setReturnChicken(java.math.BigDecimal item)
    {
        setBigDecimal("returnChicken", item);
    }
    /**
     * Object:分录's 合同结算单价property 
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
     * Object:分录's 实际开票价格property 
     */
    public java.math.BigDecimal getActualPrice()
    {
        return getBigDecimal("actualPrice");
    }
    public void setActualPrice(java.math.BigDecimal item)
    {
        setBigDecimal("actualPrice", item);
    }
    /**
     * Object:分录's 政策结算金额property 
     */
    public java.math.BigDecimal getPolicySettleAmt()
    {
        return getBigDecimal("policySettleAmt");
    }
    public void setPolicySettleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("policySettleAmt", item);
    }
    /**
     * Object:分录's 合同结算金额property 
     */
    public java.math.BigDecimal getContractAmt()
    {
        return getBigDecimal("contractAmt");
    }
    public void setContractAmt(java.math.BigDecimal item)
    {
        setBigDecimal("contractAmt", item);
    }
    /**
     * Object:分录's 实际金额property 
     */
    public java.math.BigDecimal getActualAmt()
    {
        return getBigDecimal("actualAmt");
    }
    public void setActualAmt(java.math.BigDecimal item)
    {
        setBigDecimal("actualAmt", item);
    }
    /**
     * Object:分录's 批次库存property 
     */
    public java.math.BigDecimal getBatchInv()
    {
        return getBigDecimal("batchInv");
    }
    public void setBatchInv(java.math.BigDecimal item)
    {
        setBigDecimal("batchInv", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7B27A749");
    }
}