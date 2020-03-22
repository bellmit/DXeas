package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarketPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMarketPolicyInfo()
    {
        this("id");
    }
    protected AbstractMarketPolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �г��������� 's ��˾ property 
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
     * Object:�г���������'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: �г��������� 's ����� property 
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
     * Object:�г���������'s ���ʱ��property 
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
     * Object:�г���������'s ������property 
     */
    public java.math.BigDecimal getYieldRate()
    {
        return getBigDecimal("yieldRate");
    }
    public void setYieldRate(java.math.BigDecimal item)
    {
        setBigDecimal("yieldRate", item);
    }
    /**
     * Object:�г���������'s �г���property 
     */
    public java.math.BigDecimal getContractPrice()
    {
        return getBigDecimal("contractPrice");
    }
    public void setContractPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractPrice", item);
    }
    /**
     * Object:�г���������'s �г�����property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType getMarketType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType.getEnum(getString("marketType"));
    }
    public void setMarketType(com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType item)
    {
		if (item != null) {
        setString("marketType", item.getValue());
		}
    }
    /**
     * Object:�г���������'s �г�ë���۸�(Ԫ/ֻ)property 
     */
    public java.math.BigDecimal getMarketChicOrice()
    {
        return getBigDecimal("marketChicOrice");
    }
    public void setMarketChicOrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketChicOrice", item);
    }
    /**
     * Object:�г���������'s �г�С���۸�(Ԫ/ֻ)property 
     */
    public java.math.BigDecimal getMarketSmartPrice()
    {
        return getBigDecimal("marketSmartPrice");
    }
    public void setMarketSmartPrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketSmartPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("837DB730");
    }
}