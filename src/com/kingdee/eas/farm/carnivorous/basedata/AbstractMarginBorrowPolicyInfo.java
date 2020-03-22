package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginBorrowPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMarginBorrowPolicyInfo()
    {
        this("id");
    }
    protected AbstractMarginBorrowPolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��֤���ȡ����'s ����״̬property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: ��֤���ȡ���� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: ��֤���ȡ���� 's Ʒ�� property 
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
     * Object:��֤���ȡ����'s ��͵�ֻ��֤��(Ԫ/ֻ)property 
     */
    public java.math.BigDecimal getMostLess()
    {
        return getBigDecimal("mostLess");
    }
    public void setMostLess(java.math.BigDecimal item)
    {
        setBigDecimal("mostLess", item);
    }
    /**
     * Object:��֤���ȡ����'s ������͵�ֻ��֤��ʱ������(%)property 
     */
    public java.math.BigDecimal getMostLessRate()
    {
        return getBigDecimal("mostLessRate");
    }
    public void setMostLessRate(java.math.BigDecimal item)
    {
        setBigDecimal("mostLessRate", item);
    }
    /**
     * Object:��֤���ȡ����'s ��ʼ����property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:��֤���ȡ����'s ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C238A177");
    }
}