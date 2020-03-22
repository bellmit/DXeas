package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRewardsPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractRewardsPolicyInfo()
    {
        this("id");
    }
    protected AbstractRewardsPolicyInfo(String pkField)
    {
        super(pkField);
        put("PolicyEntry", new com.kingdee.eas.farm.stocking.basedata.RewardsPolicyPolicyEntryCollection());
    }
    /**
     * Object: �������� 's ��� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo item)
    {
        put("treeid", item);
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
     * Object: �������� 's ����� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:��������'s ���ʱ��property 
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
     * Object:��������'s ��׼ֵproperty 
     */
    public java.math.BigDecimal getBaseQty()
    {
        return getBigDecimal("baseQty");
    }
    public void setBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseQty", item);
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
     * Object: �������� 's ���߷�¼ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.RewardsPolicyPolicyEntryCollection getPolicyEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.RewardsPolicyPolicyEntryCollection)get("PolicyEntry");
    }
    /**
     * Object:��������'s ��������property 
     */
    public com.kingdee.eas.farm.stocking.basedata.AwardsTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.stocking.basedata.AwardsTypeEnum.getEnum(getInt("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.stocking.basedata.AwardsTypeEnum item)
    {
		if (item != null) {
        setInt("bizType", item.getValue());
		}
    }
    /**
     * Object:��������'s ���㷽ʽproperty 
     */
    public com.kingdee.eas.farm.stocking.basedata.AwardsCalType getCalType()
    {
        return com.kingdee.eas.farm.stocking.basedata.AwardsCalType.getEnum(getInt("calType"));
    }
    public void setCalType(com.kingdee.eas.farm.stocking.basedata.AwardsCalType item)
    {
		if (item != null) {
        setInt("calType", item.getValue());
		}
    }
    /**
     * Object:��������'s ��׼�۸�property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object:��������'s ��ʽ�ı�property 
     */
    public String getFormulaTxt()
    {
        return getString("formulaTxt");
    }
    public void setFormulaTxt(String item)
    {
        setString("formulaTxt", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4753EDC5");
    }
}