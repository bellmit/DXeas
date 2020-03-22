package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractContractPaymentInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractContractPaymentInfo()
    {
        this("id");
    }
    protected AbstractContractPaymentInfo(String pkField)
    {
        super(pkField);
        put("PayInfo", new com.kingdee.eas.custom.signwasthetable.ContractPaymentPayInfoCollection());
    }
    /**
     * Object: 付款阶段 's null property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.ContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 付款阶段 's 付款信息 property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractPaymentPayInfoCollection getPayInfo()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractPaymentPayInfoCollection)get("PayInfo");
    }
    /**
     * Object:付款阶段's 阶段property 
     */
    public int getPhaseCoding()
    {
        return getInt("PhaseCoding");
    }
    public void setPhaseCoding(int item)
    {
        setInt("PhaseCoding", item);
    }
    /**
     * Object: 付款阶段 's 行政组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("AdminOrg");
    }
    public void setAdminOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("AdminOrg", item);
    }
    /**
     * Object:付款阶段's 付款条件property 
     */
    public String getPayCondition()
    {
        return getString("payCondition");
    }
    public void setPayCondition(String item)
    {
        setString("payCondition", item);
    }
    /**
     * Object:付款阶段's 付款比率（%）property 
     */
    public java.math.BigDecimal getPaymentRate()
    {
        return getBigDecimal("paymentRate");
    }
    public void setPaymentRate(java.math.BigDecimal item)
    {
        setBigDecimal("paymentRate", item);
    }
    /**
     * Object:付款阶段's 付款金额property 
     */
    public java.math.BigDecimal getPayAmount()
    {
        return getBigDecimal("payAmount");
    }
    public void setPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("payAmount", item);
    }
    /**
     * Object:付款阶段's 付款金额本位币property 
     */
    public java.math.BigDecimal getPayAmountLocal()
    {
        return getBigDecimal("payAmountLocal");
    }
    public void setPayAmountLocal(java.math.BigDecimal item)
    {
        setBigDecimal("payAmountLocal", item);
    }
    /**
     * Object:付款阶段's 已申请付款金额property 
     */
    public java.math.BigDecimal getRequiredPayAmount()
    {
        return getBigDecimal("requiredPayAmount");
    }
    public void setRequiredPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("requiredPayAmount", item);
    }
    /**
     * Object:付款阶段's 已申请付款金额本位币property 
     */
    public java.math.BigDecimal getReqPayAmountLocal()
    {
        return getBigDecimal("reqPayAmountLocal");
    }
    public void setReqPayAmountLocal(java.math.BigDecimal item)
    {
        setBigDecimal("reqPayAmountLocal", item);
    }
    /**
     * Object:付款阶段's 已付款金额property 
     */
    public java.math.BigDecimal getPayedAmount()
    {
        return getBigDecimal("payedAmount");
    }
    public void setPayedAmount(java.math.BigDecimal item)
    {
        setBigDecimal("payedAmount", item);
    }
    /**
     * Object:付款阶段's 已付款金额本位币property 
     */
    public java.math.BigDecimal getPayedAmountLocal()
    {
        return getBigDecimal("payedAmountLocal");
    }
    public void setPayedAmountLocal(java.math.BigDecimal item)
    {
        setBigDecimal("payedAmountLocal", item);
    }
    /**
     * Object:付款阶段's 未付款金额property 
     */
    public java.math.BigDecimal getPayingAmount()
    {
        return getBigDecimal("payingAmount");
    }
    public void setPayingAmount(java.math.BigDecimal item)
    {
        setBigDecimal("payingAmount", item);
    }
    /**
     * Object:付款阶段's 未付款金额本位币property 
     */
    public java.math.BigDecimal getPayingAmountLocal()
    {
        return getBigDecimal("payingAmountLocal");
    }
    public void setPayingAmountLocal(java.math.BigDecimal item)
    {
        setBigDecimal("payingAmountLocal", item);
    }
    /**
     * Object:付款阶段's 未申请付款金额property 
     */
    public java.math.BigDecimal getUnRequiredAmt()
    {
        return getBigDecimal("unRequiredAmt");
    }
    public void setUnRequiredAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unRequiredAmt", item);
    }
    /**
     * Object:付款阶段's 未申请付款金额本位币property 
     */
    public java.math.BigDecimal getUnReqAmtLocal()
    {
        return getBigDecimal("unReqAmtLocal");
    }
    public void setUnReqAmtLocal(java.math.BigDecimal item)
    {
        setBigDecimal("unReqAmtLocal", item);
    }
    /**
     * Object: 付款阶段 's 工程项目 property 
     */
    public com.kingdee.eas.custom.signwasthetable.EngProjectInfo getEngneerProject()
    {
        return (com.kingdee.eas.custom.signwasthetable.EngProjectInfo)get("engneerProject");
    }
    public void setEngneerProject(com.kingdee.eas.custom.signwasthetable.EngProjectInfo item)
    {
        put("engneerProject", item);
    }
    /**
     * Object:付款阶段's 是否保证金property 
     */
    public boolean isIsBailAmt()
    {
        return getBoolean("isBailAmt");
    }
    public void setIsBailAmt(boolean item)
    {
        setBoolean("isBailAmt", item);
    }
    /**
     * Object:付款阶段's 组织比例property 
     */
    public java.math.BigDecimal getOrgRate()
    {
        return getBigDecimal("orgRate");
    }
    public void setOrgRate(java.math.BigDecimal item)
    {
        setBigDecimal("orgRate", item);
    }
    /**
     * Object: 付款阶段 's 自定义核算项 property 
     */
    public com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo getGeneralAssActType()
    {
        return (com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo)get("generalAssActType");
    }
    public void setGeneralAssActType(com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo item)
    {
        put("generalAssActType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C410D04A");
    }
}