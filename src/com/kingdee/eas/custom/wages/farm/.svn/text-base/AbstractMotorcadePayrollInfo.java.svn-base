package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMotorcadePayrollInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMotorcadePayrollInfo()
    {
        this("id");
    }
    protected AbstractMotorcadePayrollInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.farm.MotorcadePayrollEntryCollection());
    }
    /**
     * Object: 车队计件工资计算单 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.farm.MotorcadePayrollEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.farm.MotorcadePayrollEntryCollection)get("entrys");
    }
    /**
     * Object:车队计件工资计算单's 单据状态property 
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
     * Object:车队计件工资计算单's 种鸡补助标准property 
     */
    public java.math.BigDecimal getChainckenstandard()
    {
        return getBigDecimal("chainckenstandard");
    }
    public void setChainckenstandard(java.math.BigDecimal item)
    {
        setBigDecimal("chainckenstandard", item);
    }
    /**
     * Object:车队计件工资计算单's 最低吨数指标property 
     */
    public java.math.BigDecimal getMintonnage()
    {
        return getBigDecimal("mintonnage");
    }
    public void setMintonnage(java.math.BigDecimal item)
    {
        setBigDecimal("mintonnage", item);
    }
    /**
     * Object:车队计件工资计算单's 核算起始日期property 
     */
    public java.util.Date getBegindate()
    {
        return getDate("begindate");
    }
    public void setBegindate(java.util.Date item)
    {
        setDate("begindate", item);
    }
    /**
     * Object:车队计件工资计算单's 核算结束日期property 
     */
    public java.util.Date getEnddate()
    {
        return getDate("enddate");
    }
    public void setEnddate(java.util.Date item)
    {
        setDate("enddate", item);
    }
    /**
     * Object:车队计件工资计算单's 总吨数property 
     */
    public String getSumweight()
    {
        return getString("sumweight");
    }
    public void setSumweight(String item)
    {
        setString("sumweight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D0B3BB5B");
    }
}