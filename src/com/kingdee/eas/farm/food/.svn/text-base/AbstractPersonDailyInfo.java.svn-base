package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPersonDailyInfo()
    {
        this("id");
    }
    protected AbstractPersonDailyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 员工出勤统计 's 库存组织 property 
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
     * Object:员工出勤统计's 单据状态property 
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
     * Object:员工出勤统计's 审核时间property 
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
     * Object: 员工出勤统计 's 财务组织 property 
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
     * Object:员工出勤统计's 在职员工总数property 
     */
    public int getAllPersonQty()
    {
        return getInt("allPersonQty");
    }
    public void setAllPersonQty(int item)
    {
        setInt("allPersonQty", item);
    }
    /**
     * Object:员工出勤统计's 生产人员总数property 
     */
    public int getManuPersonQty()
    {
        return getInt("manuPersonQty");
    }
    public void setManuPersonQty(int item)
    {
        setInt("manuPersonQty", item);
    }
    /**
     * Object:员工出勤统计's 设备人员总数property 
     */
    public int getDevicePersonQty()
    {
        return getInt("devicePersonQty");
    }
    public void setDevicePersonQty(int item)
    {
        setInt("devicePersonQty", item);
    }
    /**
     * Object:员工出勤统计's 物流人员总数property 
     */
    public int getLogisticsPersonQty()
    {
        return getInt("logisticsPersonQty");
    }
    public void setLogisticsPersonQty(int item)
    {
        setInt("logisticsPersonQty", item);
    }
    /**
     * Object:员工出勤统计's 财务人员总数property 
     */
    public int getFIPersonQty()
    {
        return getInt("FIPersonQty");
    }
    public void setFIPersonQty(int item)
    {
        setInt("FIPersonQty", item);
    }
    /**
     * Object:员工出勤统计's 综合人员总数property 
     */
    public int getSynthesisPersonQty()
    {
        return getInt("synthesisPersonQty");
    }
    public void setSynthesisPersonQty(int item)
    {
        setInt("synthesisPersonQty", item);
    }
    /**
     * Object:员工出勤统计's 销售人员总数property 
     */
    public int getSalePersonQty()
    {
        return getInt("salePersonQty");
    }
    public void setSalePersonQty(int item)
    {
        setInt("salePersonQty", item);
    }
    /**
     * Object:员工出勤统计's 生产人员出勤数property 
     */
    public int getManuTodayQty()
    {
        return getInt("manuTodayQty");
    }
    public void setManuTodayQty(int item)
    {
        setInt("manuTodayQty", item);
    }
    /**
     * Object:员工出勤统计's 设备人员出勤数property 
     */
    public int getDeceiveTodayQty()
    {
        return getInt("deceiveTodayQty");
    }
    public void setDeceiveTodayQty(int item)
    {
        setInt("deceiveTodayQty", item);
    }
    /**
     * Object:员工出勤统计's 物流人员出勤数property 
     */
    public int getLogisticsTodayQty()
    {
        return getInt("logisticsTodayQty");
    }
    public void setLogisticsTodayQty(int item)
    {
        setInt("logisticsTodayQty", item);
    }
    /**
     * Object:员工出勤统计's 财务人员出勤数property 
     */
    public int getFITodayQty()
    {
        return getInt("FITodayQty");
    }
    public void setFITodayQty(int item)
    {
        setInt("FITodayQty", item);
    }
    /**
     * Object:员工出勤统计's 综合人员将出勤数property 
     */
    public int getSynthesisTodayQty()
    {
        return getInt("synthesisTodayQty");
    }
    public void setSynthesisTodayQty(int item)
    {
        setInt("synthesisTodayQty", item);
    }
    /**
     * Object:员工出勤统计's 销售人员出勤数property 
     */
    public int getSaleTodayQty()
    {
        return getInt("saleTodayQty");
    }
    public void setSaleTodayQty(int item)
    {
        setInt("saleTodayQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("24FF14DA");
    }
}