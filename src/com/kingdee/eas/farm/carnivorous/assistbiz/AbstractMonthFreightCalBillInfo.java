package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthFreightCalBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMonthFreightCalBillInfo()
    {
        this("id");
    }
    protected AbstractMonthFreightCalBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:月运费核算's 是否生成凭证property 
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
     * Object: 月运费核算 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object: 月运费核算 's 年度月份 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object: 月运费核算 's 客户 property 
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
     * Object: 月运费核算 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:月运费核算's 月总胴体数量property 
     */
    public java.math.BigDecimal getMonthCarcassWgt()
    {
        return getBigDecimal("monthCarcassWgt");
    }
    public void setMonthCarcassWgt(java.math.BigDecimal item)
    {
        setBigDecimal("monthCarcassWgt", item);
    }
    /**
     * Object:月运费核算's 月总回收净重property 
     */
    public java.math.BigDecimal getMonthRecSuttle()
    {
        return getBigDecimal("monthRecSuttle");
    }
    public void setMonthRecSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("monthRecSuttle", item);
    }
    /**
     * Object:月运费核算's 月平均出肉率(%)property 
     */
    public java.math.BigDecimal getMonthAvgFmRate()
    {
        return getBigDecimal("monthAvgFmRate");
    }
    public void setMonthAvgFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("monthAvgFmRate", item);
    }
    /**
     * Object:月运费核算's 出肉率调整系数(%)property 
     */
    public java.math.BigDecimal getFmAdjustRate()
    {
        return getBigDecimal("fmAdjustRate");
    }
    public void setFmAdjustRate(java.math.BigDecimal item)
    {
        setBigDecimal("fmAdjustRate", item);
    }
    /**
     * Object:月运费核算's 出肉率系数property 
     */
    public java.math.BigDecimal getFmRateCoe()
    {
        return getBigDecimal("fmRateCoe");
    }
    public void setFmRateCoe(java.math.BigDecimal item)
    {
        setBigDecimal("fmRateCoe", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A2E4E9C3");
    }
}