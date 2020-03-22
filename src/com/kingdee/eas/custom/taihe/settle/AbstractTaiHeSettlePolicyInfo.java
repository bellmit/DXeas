package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTaiHeSettlePolicyInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractTaiHeSettlePolicyInfo()
    {
        this("id");
    }
    protected AbstractTaiHeSettlePolicyInfo(String pkField)
    {
        super(pkField);
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
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:��������'s ʧЧ����property 
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
     * Object:��������'s �����۸�property 
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
     * Object:��������'s ��ֵ�۸�property 
     */
    public java.math.BigDecimal getHedgingPrice()
    {
        return getBigDecimal("hedgingPrice");
    }
    public void setHedgingPrice(java.math.BigDecimal item)
    {
        setBigDecimal("hedgingPrice", item);
    }
    /**
     * Object:��������'s �̶�ϵ��property 
     */
    public java.math.BigDecimal getFixedCoeff()
    {
        return getBigDecimal("fixedCoeff");
    }
    public void setFixedCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("fixedCoeff", item);
    }
    /**
     * Object:��������'s ����ϵ��property 
     */
    public java.math.BigDecimal getShareCoeff()
    {
        return getBigDecimal("shareCoeff");
    }
    public void setShareCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("shareCoeff", item);
    }
    /**
     * Object:��������'s ���ϵ��property 
     */
    public java.math.BigDecimal getChickenSzCoeff()
    {
        return getBigDecimal("chickenSzCoeff");
    }
    public void setChickenSzCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSzCoeff", item);
    }
    /**
     * Object:��������'s ���߱��׼�property 
     */
    public java.math.BigDecimal getPolicyPrice()
    {
        return getBigDecimal("policyPrice");
    }
    public void setPolicyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("policyPrice", item);
    }
    /**
     * Object:��������'s ��ͬ���׼�property 
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
     * Object:��������'s �ű�property 
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
     * Object: �������� 's ��ͬ��� property 
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
     * Object:��������'s ��׼������property 
     */
    public java.math.BigDecimal getStdCarcass()
    {
        return getBigDecimal("stdCarcass");
    }
    public void setStdCarcass(java.math.BigDecimal item)
    {
        setBigDecimal("stdCarcass", item);
    }
    /**
     * Object:��������'s ʵ����property 
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
        return new BOSObjectType("E6F5C1D3");
    }
}