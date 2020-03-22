package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCManufactureBillEntryInfo extends com.kingdee.eas.scm.im.inv.InvBillBaseEntryInfo implements Serializable 
{
    public AbstractCManufactureBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCManufactureBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 生产入库单体 's 生产入库单头 property 
     */
    public com.kingdee.eas.farm.food.CManufactureBillInfo getParent()
    {
        return (com.kingdee.eas.farm.food.CManufactureBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.CManufactureBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:生产入库单体's 生产订单分录IDproperty 
     */
    public String getManuBillEntryID()
    {
        return getString("manuBillEntryID");
    }
    public void setManuBillEntryID(String item)
    {
        setString("manuBillEntryID", item);
    }
    /**
     * Object: 生产入库单体 's 成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:生产入库单体's 接受数量property 
     */
    public java.math.BigDecimal getRecQty()
    {
        return getBigDecimal("recQty");
    }
    public void setRecQty(java.math.BigDecimal item)
    {
        setBigDecimal("recQty", item);
    }
    /**
     * Object:生产入库单体's 接收基本数量property 
     */
    public java.math.BigDecimal getBaseRecQty()
    {
        return getBigDecimal("baseRecQty");
    }
    public void setBaseRecQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseRecQty", item);
    }
    /**
     * Object:生产入库单体's 生产订单单号property 
     */
    public String getManuBillNumber()
    {
        return getString("manuBillNumber");
    }
    public void setManuBillNumber(String item)
    {
        setString("manuBillNumber", item);
    }
    /**
     * Object:生产入库单体's 生产订单行号property 
     */
    public int getManuBillEntrySeq()
    {
        return getInt("manuBillEntrySeq");
    }
    public void setManuBillEntrySeq(int item)
    {
        setInt("manuBillEntrySeq", item);
    }
    /**
     * Object:生产入库单体's 生产订单IDproperty 
     */
    public String getManuBillID()
    {
        return getString("manuBillID");
    }
    public void setManuBillID(String item)
    {
        setString("manuBillID", item);
    }
    /**
     * Object:生产入库单体's 应收数量property 
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
     * Object:生产入库单体's 销售订单IDproperty 
     */
    public String getSaleOrderBillID()
    {
        return getString("saleOrderBillID");
    }
    public void setSaleOrderBillID(String item)
    {
        setString("saleOrderBillID", item);
    }
    /**
     * Object:生产入库单体's 销售订单号property 
     */
    public String getSaleOrderNum()
    {
        return getString("saleOrderNum");
    }
    public void setSaleOrderNum(String item)
    {
        setString("saleOrderNum", item);
    }
    /**
     * Object:生产入库单体's 销售订单行号property 
     */
    public int getSaleOrderEntrySeq()
    {
        return getInt("saleOrderEntrySeq");
    }
    public void setSaleOrderEntrySeq(int item)
    {
        setInt("saleOrderEntrySeq", item);
    }
    /**
     * Object:生产入库单体's property 
     */
    public String getTraceNo()
    {
        return getString("traceNo");
    }
    public void setTraceNo(String item)
    {
        setString("traceNo", item);
    }
    /**
     * Object:生产入库单体's 单价property 
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
     * Object:生产入库单体's 金额property 
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
     * Object:生产入库单体's 业务日期property 
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
     * Object: 生产入库单体 's 主制部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrgUnit");
    }
    public void setAdminOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrgUnit", item);
    }
    /**
     * Object: 生产入库单体 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenterOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenterOrgUnit");
    }
    public void setCostCenterOrgUnit(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenterOrgUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7FE40B83");
    }
}