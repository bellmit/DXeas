package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleAwardPolicyInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractSettleAwardPolicyInfo()
    {
        this("id");
    }
    protected AbstractSettleAwardPolicyInfo(String pkField)
    {
        super(pkField);
        put("AwardEntry", new com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyAwardEntryCollection());
        put("Entry", new com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyEntryCollection());
    }
    /**
     * Object: ���㽱������ 's ������֯ property 
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
     * Object: ���㽱������ 's ������Χ property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyEntryCollection)get("Entry");
    }
    /**
     * Object:���㽱������'s ��Ч����property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:���㽱������'s ʧЧ����property 
     */
    public java.util.Date getUnEffectDate()
    {
        return getDate("unEffectDate");
    }
    public void setUnEffectDate(java.util.Date item)
    {
        setDate("unEffectDate", item);
    }
    /**
     * Object: ���㽱������ 's ��ͬ��� property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractTypeInfo getContractType()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractTypeInfo)get("contractType");
    }
    public void setContractType(com.kingdee.eas.custom.signwasthetable.ContractTypeInfo item)
    {
        put("contractType", item);
    }
    /**
     * Object: ���㽱������ 's ��ֵ��ͬ��� property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractTypeInfo getHedgingContractType()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractTypeInfo)get("hedgingContractType");
    }
    public void setHedgingContractType(com.kingdee.eas.custom.signwasthetable.ContractTypeInfo item)
    {
        put("hedgingContractType", item);
    }
    /**
     * Object: ���㽱������ 's ���׺�ͬ property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyAwardEntryCollection getAwardEntry()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyAwardEntryCollection)get("AwardEntry");
    }
    /**
     * Object:���㽱������'s ��˾ռ��property 
     */
    public java.math.BigDecimal getComapnyProp()
    {
        return getBigDecimal("comapnyProp");
    }
    public void setComapnyProp(java.math.BigDecimal item)
    {
        setBigDecimal("comapnyProp", item);
    }
    /**
     * Object:���㽱������'s ��Ӧ��ռ��property 
     */
    public java.math.BigDecimal getSupplierProp()
    {
        return getBigDecimal("supplierProp");
    }
    public void setSupplierProp(java.math.BigDecimal item)
    {
        setBigDecimal("supplierProp", item);
    }
    /**
     * Object: ���㽱������ 's ���׺�ͬ��� property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractTypeInfo getFlooredContractType()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractTypeInfo)get("flooredContractType");
    }
    public void setFlooredContractType(com.kingdee.eas.custom.signwasthetable.ContractTypeInfo item)
    {
        put("flooredContractType", item);
    }
    /**
     * Object:���㽱������'s ���ϵ��property 
     */
    public java.math.BigDecimal getChickenSzCoff()
    {
        return getBigDecimal("chickenSzCoff");
    }
    public void setChickenSzCoff(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSzCoff", item);
    }
    /**
     * Object:���㽱������'s ʵ����property 
     */
    public String getDAOImpl()
    {
        return getString("DAOImpl");
    }
    public void setDAOImpl(String item)
    {
        setString("DAOImpl", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("013226C1");
    }
}