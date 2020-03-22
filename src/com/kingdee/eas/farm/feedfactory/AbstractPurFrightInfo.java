package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPurFrightInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPurFrightInfo()
    {
        this("id");
    }
    protected AbstractPurFrightInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.feedfactory.PurFrightEntryCollection());
    }
    /**
     * Object: 采购运费单 's 分录 property 
     */
    public com.kingdee.eas.farm.feedfactory.PurFrightEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.PurFrightEntryCollection)get("entrys");
    }
    /**
     * Object:采购运费单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 采购运费单 's 过磅单 property 
     */
    public com.kingdee.eas.weighbridge.InStorageBillInfo getWeightBill()
    {
        return (com.kingdee.eas.weighbridge.InStorageBillInfo)get("weightBill");
    }
    public void setWeightBill(com.kingdee.eas.weighbridge.InStorageBillInfo item)
    {
        put("weightBill", item);
    }
    /**
     * Object: 采购运费单 's 质检员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object: 采购运费单 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:采购运费单's 车号property 
     */
    public String getTruckNumber()
    {
        return getString("truckNumber");
    }
    public void setTruckNumber(String item)
    {
        setString("truckNumber", item);
    }
    /**
     * Object:采购运费单's 到货日期property 
     */
    public java.util.Date getArriveDate()
    {
        return getDate("arriveDate");
    }
    public void setArriveDate(java.util.Date item)
    {
        setDate("arriveDate", item);
    }
    /**
     * Object:采购运费单's 送检日期property 
     */
    public java.util.Date getSendDate()
    {
        return getDate("sendDate");
    }
    public void setSendDate(java.util.Date item)
    {
        setDate("sendDate", item);
    }
    /**
     * Object:采购运费单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:采购运费单's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 采购运费单 's 采购订单 property 
     */
    public com.kingdee.eas.scm.sm.pur.PurOrderInfo getPurOrder()
    {
        return (com.kingdee.eas.scm.sm.pur.PurOrderInfo)get("purOrder");
    }
    public void setPurOrder(com.kingdee.eas.scm.sm.pur.PurOrderInfo item)
    {
        put("purOrder", item);
    }
    /**
     * Object:采购运费单's 采购订单编码property 
     */
    public String getPurOrderNumber()
    {
        return getString("purOrderNumber");
    }
    public void setPurOrderNumber(String item)
    {
        setString("purOrderNumber", item);
    }
    /**
     * Object:采购运费单's 过磅净重property 
     */
    public java.math.BigDecimal getSumweight()
    {
        return getBigDecimal("sumweight");
    }
    public void setSumweight(java.math.BigDecimal item)
    {
        setBigDecimal("sumweight", item);
    }
    /**
     * Object:采购运费单's 压车天数property 
     */
    public int getYcts()
    {
        return getInt("ycts");
    }
    public void setYcts(int item)
    {
        setInt("ycts", item);
    }
    /**
     * Object:采购运费单's 压车金额property 
     */
    public java.math.BigDecimal getYcje()
    {
        return getBigDecimal("ycje");
    }
    public void setYcje(java.math.BigDecimal item)
    {
        setBigDecimal("ycje", item);
    }
    /**
     * Object:采购运费单's 亏重金额property 
     */
    public java.math.BigDecimal getKzje()
    {
        return getBigDecimal("kzje");
    }
    public void setKzje(java.math.BigDecimal item)
    {
        setBigDecimal("kzje", item);
    }
    /**
     * Object:采购运费单's 运费单价property 
     */
    public java.math.BigDecimal getFrightPrice()
    {
        return getBigDecimal("FrightPrice");
    }
    public void setFrightPrice(java.math.BigDecimal item)
    {
        setBigDecimal("FrightPrice", item);
    }
    /**
     * Object: 采购运费单 's 承运商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSuppile()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("suppile");
    }
    public void setSuppile(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("suppile", item);
    }
    /**
     * Object:采购运费单's 承运商承担亏重数量property 
     */
    public java.math.BigDecimal getSuppchkz()
    {
        return getBigDecimal("suppchkz");
    }
    public void setSuppchkz(java.math.BigDecimal item)
    {
        setBigDecimal("suppchkz", item);
    }
    /**
     * Object:采购运费单's 标准运费单价property 
     */
    public java.math.BigDecimal getSfrightPrice()
    {
        return getBigDecimal("SfrightPrice");
    }
    public void setSfrightPrice(java.math.BigDecimal item)
    {
        setBigDecimal("SfrightPrice", item);
    }
    /**
     * Object: 采购运费单 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    /**
     * Object:采购运费单's 出厂日期property 
     */
    public java.util.Date getOutDate()
    {
        return getDate("outDate");
    }
    public void setOutDate(java.util.Date item)
    {
        setDate("outDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("32EDC341");
    }
}