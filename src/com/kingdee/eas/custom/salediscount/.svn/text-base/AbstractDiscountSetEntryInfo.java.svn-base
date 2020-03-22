package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountSetEntryInfo extends com.kingdee.eas.framework.CoreBaseInfo implements Serializable 
{
    public AbstractDiscountSetEntryInfo()
    {
        this("id");
    }
    protected AbstractDiscountSetEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:具体物料价格政策's 生效日期property 
     */
    public java.util.Date getEffectiveDate()
    {
        return getDate("effectiveDate");
    }
    public void setEffectiveDate(java.util.Date item)
    {
        setDate("effectiveDate", item);
    }
    /**
     * Object:具体物料价格政策's 失效日期property 
     */
    public java.util.Date getExpireDate()
    {
        return getDate("expireDate");
    }
    public void setExpireDate(java.util.Date item)
    {
        setDate("expireDate", item);
    }
    /**
     * Object: 具体物料价格政策 's 物料 property 
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
     * Object: 具体物料价格政策 's 币别 property 
     */
    public com.kingdee.eas.basedata.assistant.CurrencyInfo getCurrency()
    {
        return (com.kingdee.eas.basedata.assistant.CurrencyInfo)get("currency");
    }
    public void setCurrency(com.kingdee.eas.basedata.assistant.CurrencyInfo item)
    {
        put("currency", item);
    }
    /**
     * Object:具体物料价格政策's 备注property 
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
     * Object: 具体物料价格政策 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getMeasureUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("measureUnit");
    }
    public void setMeasureUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("measureUnit", item);
    }
    /**
     * Object:具体物料价格政策's 销货提前期property 
     */
    public float getSaleLeadTime()
    {
        return getFloat("saleLeadTime");
    }
    public void setSaleLeadTime(float item)
    {
        setFloat("saleLeadTime", item);
    }
    /**
     * Object:具体物料价格政策's 审核标志property 
     */
    public com.kingdee.eas.framework.CheckedStatusEnum getCheckedStatus()
    {
        return com.kingdee.eas.framework.CheckedStatusEnum.getEnum(getInt("checkedStatus"));
    }
    public void setCheckedStatus(com.kingdee.eas.framework.CheckedStatusEnum item)
    {
		if (item != null) {
        setInt("checkedStatus", item.getValue());
		}
    }
    /**
     * Object:具体物料价格政策's 折扣条件property 
     */
    public com.kingdee.eas.basedata.scm.common.DiscountConditionEnum getDiscountCondition()
    {
        return com.kingdee.eas.basedata.scm.common.DiscountConditionEnum.getEnum(getInt("discountCondition"));
    }
    public void setDiscountCondition(com.kingdee.eas.basedata.scm.common.DiscountConditionEnum item)
    {
		if (item != null) {
        setInt("discountCondition", item.getValue());
		}
    }
    /**
     * Object: 具体物料价格政策 's 客户 property 
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
     * Object: 具体物料价格政策 's 头 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountSetInfo getParent()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salediscount.DiscountSetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 具体物料价格政策 's 辅助属性 property 
     */
    public com.kingdee.eas.basedata.master.material.AsstAttrValueInfo getAsistProperty()
    {
        return (com.kingdee.eas.basedata.master.material.AsstAttrValueInfo)get("asistProperty");
    }
    public void setAsistProperty(com.kingdee.eas.basedata.master.material.AsstAttrValueInfo item)
    {
        put("asistProperty", item);
    }
    /**
     * Object:具体物料价格政策's 数量一（吨）property 
     */
    public java.math.BigDecimal getQty1()
    {
        return getBigDecimal("qty1");
    }
    public void setQty1(java.math.BigDecimal item)
    {
        setBigDecimal("qty1", item);
    }
    /**
     * Object:具体物料价格政策's 标准一property 
     */
    public java.math.BigDecimal getStandard1()
    {
        return getBigDecimal("standard1");
    }
    public void setStandard1(java.math.BigDecimal item)
    {
        setBigDecimal("standard1", item);
    }
    /**
     * Object:具体物料价格政策's 数量二（吨）property 
     */
    public java.math.BigDecimal getQty2()
    {
        return getBigDecimal("qty2");
    }
    public void setQty2(java.math.BigDecimal item)
    {
        setBigDecimal("qty2", item);
    }
    /**
     * Object:具体物料价格政策's 标准二property 
     */
    public java.math.BigDecimal getStandard2()
    {
        return getBigDecimal("standard2");
    }
    public void setStandard2(java.math.BigDecimal item)
    {
        setBigDecimal("standard2", item);
    }
    /**
     * Object:具体物料价格政策's 标准计算方式property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountUnitTypeEnum getDiscountUnitType()
    {
        return com.kingdee.eas.custom.salediscount.DiscountUnitTypeEnum.getEnum(getString("discountUnitType"));
    }
    public void setDiscountUnitType(com.kingdee.eas.custom.salediscount.DiscountUnitTypeEnum item)
    {
		if (item != null) {
        setString("discountUnitType", item.getValue());
		}
    }
    /**
     * Object:具体物料价格政策's 总销量限额（吨）property 
     */
    public java.math.BigDecimal getQtyLimit()
    {
        return getBigDecimal("qtyLimit");
    }
    public void setQtyLimit(java.math.BigDecimal item)
    {
        setBigDecimal("qtyLimit", item);
    }
    /**
     * Object:具体物料价格政策's 折扣总额限制（元）property 
     */
    public java.math.BigDecimal getSdLimit()
    {
        return getBigDecimal("sdLimit");
    }
    public void setSdLimit(java.math.BigDecimal item)
    {
        setBigDecimal("sdLimit", item);
    }
    /**
     * Object:具体物料价格政策's 销售总金额控制（元）property 
     */
    public java.math.BigDecimal getSaleAmountLimit()
    {
        return getBigDecimal("saleAmountLimit");
    }
    public void setSaleAmountLimit(java.math.BigDecimal item)
    {
        setBigDecimal("saleAmountLimit", item);
    }
    /**
     * Object:具体物料价格政策's 实物折扣量一(吨)property 
     */
    public java.math.BigDecimal getSwQty1()
    {
        return getBigDecimal("swQty1");
    }
    public void setSwQty1(java.math.BigDecimal item)
    {
        setBigDecimal("swQty1", item);
    }
    /**
     * Object:具体物料价格政策's 实物折扣量二(吨)property 
     */
    public java.math.BigDecimal getSwQty2()
    {
        return getBigDecimal("swQty2");
    }
    public void setSwQty2(java.math.BigDecimal item)
    {
        setBigDecimal("swQty2", item);
    }
    /**
     * Object:具体物料价格政策's 实物赠包二property 
     */
    public int getSwStandard2()
    {
        return getInt("swStandard2");
    }
    public void setSwStandard2(int item)
    {
        setInt("swStandard2", item);
    }
    /**
     * Object:具体物料价格政策's 实物赠包一property 
     */
    public int getSwStandard1()
    {
        return getInt("swStandard1");
    }
    public void setSwStandard1(int item)
    {
        setInt("swStandard1", item);
    }
    /**
     * Object:具体物料价格政策's 禁用状态property 
     */
    public com.kingdee.eas.custom.salediscount.EntryState getLockedState()
    {
        return com.kingdee.eas.custom.salediscount.EntryState.getEnum(getString("lockedState"));
    }
    public void setLockedState(com.kingdee.eas.custom.salediscount.EntryState item)
    {
		if (item != null) {
        setString("lockedState", item.getValue());
		}
    }
    /**
     * Object:具体物料价格政策's 数量三（吨）property 
     */
    public java.math.BigDecimal getQty3()
    {
        return getBigDecimal("qty3");
    }
    public void setQty3(java.math.BigDecimal item)
    {
        setBigDecimal("qty3", item);
    }
    /**
     * Object:具体物料价格政策's 实物折扣量三（吨）property 
     */
    public java.math.BigDecimal getSwQty3()
    {
        return getBigDecimal("swQty3");
    }
    public void setSwQty3(java.math.BigDecimal item)
    {
        setBigDecimal("swQty3", item);
    }
    /**
     * Object:具体物料价格政策's 实物增包三property 
     */
    public int getSwStandard3()
    {
        return getInt("swStandard3");
    }
    public void setSwStandard3(int item)
    {
        setInt("swStandard3", item);
    }
    /**
     * Object:具体物料价格政策's 标准三property 
     */
    public java.math.BigDecimal getStandard3()
    {
        return getBigDecimal("standard3");
    }
    public void setStandard3(java.math.BigDecimal item)
    {
        setBigDecimal("standard3", item);
    }
    /**
     * Object:具体物料价格政策's 数量四（吨）property 
     */
    public java.math.BigDecimal getQty4()
    {
        return getBigDecimal("qty4");
    }
    public void setQty4(java.math.BigDecimal item)
    {
        setBigDecimal("qty4", item);
    }
    /**
     * Object:具体物料价格政策's 实物折扣量四（吨）property 
     */
    public java.math.BigDecimal getSwQty4()
    {
        return getBigDecimal("swQty4");
    }
    public void setSwQty4(java.math.BigDecimal item)
    {
        setBigDecimal("swQty4", item);
    }
    /**
     * Object:具体物料价格政策's 实物增包四property 
     */
    public int getSwStandard4()
    {
        return getInt("swStandard4");
    }
    public void setSwStandard4(int item)
    {
        setInt("swStandard4", item);
    }
    /**
     * Object:具体物料价格政策's 标准四property 
     */
    public java.math.BigDecimal getStandard4()
    {
        return getBigDecimal("standard4");
    }
    public void setStandard4(java.math.BigDecimal item)
    {
        setBigDecimal("standard4", item);
    }
    /**
     * Object:具体物料价格政策's 数量五（吨）property 
     */
    public java.math.BigDecimal getQty5()
    {
        return getBigDecimal("qty5");
    }
    public void setQty5(java.math.BigDecimal item)
    {
        setBigDecimal("qty5", item);
    }
    /**
     * Object:具体物料价格政策's 实物折扣量五（吨）property 
     */
    public java.math.BigDecimal getSwQty5()
    {
        return getBigDecimal("swQty5");
    }
    public void setSwQty5(java.math.BigDecimal item)
    {
        setBigDecimal("swQty5", item);
    }
    /**
     * Object:具体物料价格政策's 实物增包五property 
     */
    public int getSwStandard5()
    {
        return getInt("swStandard5");
    }
    public void setSwStandard5(int item)
    {
        setInt("swStandard5", item);
    }
    /**
     * Object:具体物料价格政策's 标准五property 
     */
    public java.math.BigDecimal getStandard5()
    {
        return getBigDecimal("Standard5");
    }
    public void setStandard5(java.math.BigDecimal item)
    {
        setBigDecimal("Standard5", item);
    }
    /**
     * Object: 具体物料价格政策 's 累计物料类别 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getAccumulaMaterialGroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("accumulaMaterialGroup");
    }
    public void setAccumulaMaterialGroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("accumulaMaterialGroup", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C518C08C");
    }
}