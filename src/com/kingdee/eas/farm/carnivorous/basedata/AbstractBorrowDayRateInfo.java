package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBorrowDayRateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBorrowDayRateInfo()
    {
        this("id");
    }
    protected AbstractBorrowDayRateInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �����Ŀ������ 's ��� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: �����Ŀ������ 's ������֯ property 
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
     * Object:�����Ŀ������'s ����״̬property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:�����Ŀ������'s ��ʼ����property 
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
     * Object:�����Ŀ������'s ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:�����Ŀ������'s ������(%)property 
     */
    public java.math.BigDecimal getDayRate()
    {
        return getBigDecimal("dayRate");
    }
    public void setDayRate(java.math.BigDecimal item)
    {
        setBigDecimal("dayRate", item);
    }
    /**
     * Object: �����Ŀ������ 's �����Ŀ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo getBrowerItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo)get("browerItem");
    }
    public void setBrowerItem(com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo item)
    {
        put("browerItem", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("369EFC85");
    }
}