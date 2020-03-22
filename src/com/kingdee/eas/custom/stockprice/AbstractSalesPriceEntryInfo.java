package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalesPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSalesPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractSalesPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.stockprice.SalesPriceInfo getParent()
    {
        return (com.kingdee.eas.custom.stockprice.SalesPriceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.stockprice.SalesPriceInfo item)
    {
        put("parent", item);
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
     * Object:分录's 物料编码property 
     */
    public String getMaterialNum()
    {
        return getString("materialNum");
    }
    public void setMaterialNum(String item)
    {
        setString("materialNum", item);
    }
    /**
     * Object:分录's 规格型号property 
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
     * Object: 分录 's 创建人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getCreator()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("creator");
    }
    public void setCreator(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("creator", item);
    }
    /**
     * Object: 分录 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:分录's 审核日期property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object:分录's 创建日期property 
     */
    public java.util.Date getCreateTime()
    {
        return getDate("createTime");
    }
    public void setCreateTime(java.util.Date item)
    {
        setDate("createTime", item);
    }
    /**
     * Object:分录's 最高限价property 
     */
    public java.math.BigDecimal getMaxPrice()
    {
        return getBigDecimal("maxPrice");
    }
    public void setMaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("maxPrice", item);
    }
    /**
     * Object:分录's 最低限价property 
     */
    public java.math.BigDecimal getMinPrice()
    {
        return getBigDecimal("minPrice");
    }
    public void setMinPrice(java.math.BigDecimal item)
    {
        setBigDecimal("minPrice", item);
    }
    /**
     * Object:分录's 价格property 
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
     * Object: 分录 's 辅助属性 property 
     */
    public com.kingdee.eas.basedata.master.material.AsstAttrValueInfo getAssistProperty()
    {
        return (com.kingdee.eas.basedata.master.material.AsstAttrValueInfo)get("assistProperty");
    }
    public void setAssistProperty(com.kingdee.eas.basedata.master.material.AsstAttrValueInfo item)
    {
        put("assistProperty", item);
    }
    /**
     * Object: 分录 's 渠道类型 property 
     */
    public com.kingdee.eas.basedata.assistant.ChannelTypeInfo getChannelType()
    {
        return (com.kingdee.eas.basedata.assistant.ChannelTypeInfo)get("channelType");
    }
    public void setChannelType(com.kingdee.eas.basedata.assistant.ChannelTypeInfo item)
    {
        put("channelType", item);
    }
    /**
     * Object: 分录 's 价格类型 property 
     */
    public com.kingdee.eas.basedata.scm.sd.sale.PriceTypeInfo getPriceType()
    {
        return (com.kingdee.eas.basedata.scm.sd.sale.PriceTypeInfo)get("priceType");
    }
    public void setPriceType(com.kingdee.eas.basedata.scm.sd.sale.PriceTypeInfo item)
    {
        put("priceType", item);
    }
    /**
     * Object:分录's 优先级property 
     */
    public int getPriority()
    {
        return getInt("priority");
    }
    public void setPriority(int item)
    {
        setInt("priority", item);
    }
    /**
     * Object: 分录 's 币别 property 
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
     * Object:分录's 启用状态property 
     */
    public com.kingdee.eas.basedata.scm.sd.sale.BlockedStatusEnum getBlockedStatus()
    {
        return com.kingdee.eas.basedata.scm.sd.sale.BlockedStatusEnum.getEnum(getInt("blockedStatus"));
    }
    public void setBlockedStatus(com.kingdee.eas.basedata.scm.sd.sale.BlockedStatusEnum item)
    {
		if (item != null) {
        setInt("blockedStatus", item.getValue());
		}
    }
    /**
     * Object:分录's 审核状态property 
     */
    public com.kingdee.eas.basedata.scm.sd.sale.CheckedStatusEnum getCheckedStatus()
    {
        return com.kingdee.eas.basedata.scm.sd.sale.CheckedStatusEnum.getEnum(getInt("checkedStatus"));
    }
    public void setCheckedStatus(com.kingdee.eas.basedata.scm.sd.sale.CheckedStatusEnum item)
    {
		if (item != null) {
        setInt("checkedStatus", item.getValue());
		}
    }
    /**
     * Object:分录's 生效日期property 
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
     * Object:分录's 失效日期property 
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
     * Object: 分录 's 组织单元 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("orgUnit");
    }
    public void setOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("orgUnit", item);
    }
    /**
     * Object:分录's 业务日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2E254C65");
    }
}