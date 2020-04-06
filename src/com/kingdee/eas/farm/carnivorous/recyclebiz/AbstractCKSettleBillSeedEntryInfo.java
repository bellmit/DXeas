package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillSeedEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillSeedEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillSeedEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 领苗单 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:领苗单's 业务日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:领苗单's 单据编号property 
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
     * Object:领苗单's 业务类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object: 领苗单 's 雏苗编码 property 
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
     * Object:领苗单's 雏苗名称property 
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
     * Object:领苗单's 实际领用数量property 
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
     * Object:领苗单's 政策单价property 
     */
    public java.math.BigDecimal getPolicyPrice()
    {
        return getBigDecimal("policyPrice");
    }
    public void setPolicyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("policyPrice", item);
    }
    /**
     * Object:领苗单's 金额property 
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
     * Object:领苗单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object:领苗单's 单位成本property 
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
     * Object:领苗单's 雏鸡成本property 
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
     * Object:领苗单's 合同结算单价property 
     */
    public java.math.BigDecimal getContPrice()
    {
        return getBigDecimal("contPrice");
    }
    public void setContPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contPrice", item);
    }
    /**
     * Object:领苗单's 合同结算金额property 
     */
    public java.math.BigDecimal getContAmount()
    {
        return getBigDecimal("contAmount");
    }
    public void setContAmount(java.math.BigDecimal item)
    {
        setBigDecimal("contAmount", item);
    }
    /**
     * Object:领苗单's 实际开票价property 
     */
    public java.math.BigDecimal getActPrice()
    {
        return getBigDecimal("actPrice");
    }
    public void setActPrice(java.math.BigDecimal item)
    {
        setBigDecimal("actPrice", item);
    }
    /**
     * Object:领苗单's 实际开票金额property 
     */
    public java.math.BigDecimal getActAmount()
    {
        return getBigDecimal("actAmount");
    }
    public void setActAmount(java.math.BigDecimal item)
    {
        setBigDecimal("actAmount", item);
    }
    /**
     * Object:领苗单's 政策搭雏比例property 
     */
    public java.math.BigDecimal getPolicyCRate()
    {
        return getBigDecimal("policyCRate");
    }
    public void setPolicyCRate(java.math.BigDecimal item)
    {
        setBigDecimal("policyCRate", item);
    }
    /**
     * Object:领苗单's 实际搭雏比例property 
     */
    public java.math.BigDecimal getActCRate()
    {
        return getBigDecimal("actCRate");
    }
    public void setActCRate(java.math.BigDecimal item)
    {
        setBigDecimal("actCRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("954E36CA");
    }
}