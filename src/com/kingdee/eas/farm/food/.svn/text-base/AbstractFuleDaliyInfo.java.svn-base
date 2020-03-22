package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFuleDaliyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFuleDaliyInfo()
    {
        this("id");
    }
    protected AbstractFuleDaliyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 能源消耗统计 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("StorageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("StorageOrgUnit", item);
    }
    /**
     * Object:能源消耗统计's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object:能源消耗统计's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("AuditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("AuditTime", item);
    }
    /**
     * Object: 能源消耗统计 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    /**
     * Object:能源消耗统计's 燃煤消耗property 
     */
    public java.math.BigDecimal getCoalQty()
    {
        return getBigDecimal("coalQty");
    }
    public void setCoalQty(java.math.BigDecimal item)
    {
        setBigDecimal("coalQty", item);
    }
    /**
     * Object:能源消耗统计's 食堂用电(kW·h)property 
     */
    public java.math.BigDecimal getMessElectricity()
    {
        return getBigDecimal("messElectricity");
    }
    public void setMessElectricity(java.math.BigDecimal item)
    {
        setBigDecimal("messElectricity", item);
    }
    /**
     * Object:能源消耗统计's 办公用电(kW·h)property 
     */
    public java.math.BigDecimal getWorkElectricity()
    {
        return getBigDecimal("workElectricity");
    }
    public void setWorkElectricity(java.math.BigDecimal item)
    {
        setBigDecimal("workElectricity", item);
    }
    /**
     * Object:能源消耗统计's 宿舍用电(kW·h)property 
     */
    public java.math.BigDecimal getDormElectricity()
    {
        return getBigDecimal("dormElectricity");
    }
    public void setDormElectricity(java.math.BigDecimal item)
    {
        setBigDecimal("dormElectricity", item);
    }
    /**
     * Object:能源消耗统计's 柴油消耗(L)property 
     */
    public java.math.BigDecimal getDieselQty()
    {
        return getBigDecimal("dieselQty");
    }
    public void setDieselQty(java.math.BigDecimal item)
    {
        setBigDecimal("dieselQty", item);
    }
    /**
     * Object:能源消耗统计's 生产用电(kW·h)property 
     */
    public java.math.BigDecimal getManuElectricity()
    {
        return getBigDecimal("manuElectricity");
    }
    public void setManuElectricity(java.math.BigDecimal item)
    {
        setBigDecimal("manuElectricity", item);
    }
    /**
     * Object:能源消耗统计's 用水量(m?)property 
     */
    public java.math.BigDecimal getWaterVolume()
    {
        return getBigDecimal("waterVolume");
    }
    public void setWaterVolume(java.math.BigDecimal item)
    {
        setBigDecimal("waterVolume", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("677C6DED");
    }
}