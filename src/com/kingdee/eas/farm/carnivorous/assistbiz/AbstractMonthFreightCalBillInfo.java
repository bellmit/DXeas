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
     * Object:���˷Ѻ���'s �Ƿ�����ƾ֤property 
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
     * Object: ���˷Ѻ��� 's ������֯ property 
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
     * Object: ���˷Ѻ��� 's ����·� property 
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
     * Object: ���˷Ѻ��� 's �ͻ� property 
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
     * Object: ���˷Ѻ��� 's Ʒ�� property 
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
     * Object:���˷Ѻ���'s ������������property 
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
     * Object:���˷Ѻ���'s ���ܻ��վ���property 
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
     * Object:���˷Ѻ���'s ��ƽ��������(%)property 
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
     * Object:���˷Ѻ���'s �����ʵ���ϵ��(%)property 
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
     * Object:���˷Ѻ���'s ������ϵ��property 
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