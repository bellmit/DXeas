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
     * Object: 结算政策 's 财务组织 property 
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
     * Object:结算政策's 生效日期property 
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
     * Object:结算政策's 失效日期property 
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
     * Object:结算政策's 基础价格property 
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
     * Object:结算政策's 保值价格property 
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
     * Object:结算政策's 固定系数property 
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
     * Object:结算政策's 分享系数property 
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
     * Object:结算政策's 扣嗉系数property 
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
     * Object:结算政策's 政策保底价property 
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
     * Object:结算政策's 合同保底价property 
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
     * Object:结算政策's 脚本property 
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
     * Object: 结算政策 's 合同类别 property 
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
     * Object:结算政策's 标准出成率property 
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
     * Object:结算政策's 实现类property 
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