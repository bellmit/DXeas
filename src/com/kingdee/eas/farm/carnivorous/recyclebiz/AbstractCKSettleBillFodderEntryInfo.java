package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillFodderEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillFodderEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillFodderEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 领料单 's null property 
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
     * Object:领料单's 业务日期property 
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
     * Object:领料单's 单据编号property 
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
     * Object:领料单's 单据类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType getBizType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object: 领料单 's 饲料编码 property 
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
     * Object:领料单's 饲料名称property 
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
     * Object:领料单's 单包重property 
     */
    public java.math.BigDecimal getUnitQty()
    {
        return getBigDecimal("unitQty");
    }
    public void setUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("unitQty", item);
    }
    /**
     * Object:领料单's 包数property 
     */
    public int getBagQty()
    {
        return getInt("bagQty");
    }
    public void setBagQty(int item)
    {
        setInt("bagQty", item);
    }
    /**
     * Object:领料单's 领用数量property 
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
     * Object:领料单's 政策单价property 
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
     * Object:领料单's 金额property 
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
     * Object:领料单's 单据状态property 
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
     * Object: 领料单 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("Car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("Car", item);
    }
    /**
     * Object: 领料单 's 司机 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:领料单's 单位成本property 
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
     * Object:领料单's 饲料成本property 
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
     * Object:领料单's 回机费property 
     */
    public java.math.BigDecimal getHjFee()
    {
        return getBigDecimal("hjFee");
    }
    public void setHjFee(java.math.BigDecimal item)
    {
        setBigDecimal("hjFee", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("829B38A5");
    }
}