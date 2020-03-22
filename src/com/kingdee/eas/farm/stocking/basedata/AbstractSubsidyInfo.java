package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSubsidyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSubsidyInfo()
    {
        this("id");
    }
    protected AbstractSubsidyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �������� 's ��� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SubsidyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SubsidyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.SubsidyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: �������� 's ������֯ property 
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
     * Object:��������'s ��Ч����property 
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
     * Object:��������'s ʧЧ����property 
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
     * Object:��������'s ״̬property 
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
     * Object:��������'s �������property 
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
     * Object:��������'s ������ʽproperty 
     */
    public com.kingdee.eas.farm.stocking.basedata.SubsidyTypeEnum getSubsidyType()
    {
        return com.kingdee.eas.farm.stocking.basedata.SubsidyTypeEnum.getEnum(getInt("subsidyType"));
    }
    public void setSubsidyType(com.kingdee.eas.farm.stocking.basedata.SubsidyTypeEnum item)
    {
		if (item != null) {
        setInt("subsidyType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E924533A");
    }
}