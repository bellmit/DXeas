package com.kingdee.eas.custom.ccchargeback;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChargeBackStdInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractChargeBackStdInfo()
    {
        this("id");
    }
    protected AbstractChargeBackStdInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�ۿ��׼'s צ���׼property 
     */
    public java.math.BigDecimal getPulvillusSTD()
    {
        return getBigDecimal("pulvillusSTD");
    }
    public void setPulvillusSTD(java.math.BigDecimal item)
    {
        setBigDecimal("pulvillusSTD", item);
    }
    /**
     * Object:�ۿ��׼'s ��������property 
     */
    public java.math.BigDecimal getIncrProportion()
    {
        return getBigDecimal("incrProportion");
    }
    public void setIncrProportion(java.math.BigDecimal item)
    {
        setBigDecimal("incrProportion", item);
    }
    /**
     * Object:�ۿ��׼'s �������property 
     */
    public java.math.BigDecimal getProportionAmt()
    {
        return getBigDecimal("proportionAmt");
    }
    public void setProportionAmt(java.math.BigDecimal item)
    {
        setBigDecimal("proportionAmt", item);
    }
    /**
     * Object:�ۿ��׼'s �ز�Ƥ�ױ�׼property 
     */
    public java.math.BigDecimal getDermatitisSTD()
    {
        return getBigDecimal("dermatitisSTD");
    }
    public void setDermatitisSTD(java.math.BigDecimal item)
    {
        setBigDecimal("dermatitisSTD", item);
    }
    /**
     * Object:�ۿ��׼'s ��������property 
     */
    public java.math.BigDecimal getIncrProportionDer()
    {
        return getBigDecimal("incrProportionDer");
    }
    public void setIncrProportionDer(java.math.BigDecimal item)
    {
        setBigDecimal("incrProportionDer", item);
    }
    /**
     * Object:�ۿ��׼'s �������property 
     */
    public java.math.BigDecimal getIncrAmtDer()
    {
        return getBigDecimal("incrAmtDer");
    }
    public void setIncrAmtDer(java.math.BigDecimal item)
    {
        setBigDecimal("incrAmtDer", item);
    }
    /**
     * Object:�ۿ��׼'s ����״̬property 
     */
    public com.kingdee.eas.custom.ccchargeback.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.ccchargeback.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.ccchargeback.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:�ۿ��׼'s ��ұ�׼property 
     */
    public java.math.BigDecimal getCropSTD()
    {
        return getBigDecimal("cropSTD");
    }
    public void setCropSTD(java.math.BigDecimal item)
    {
        setBigDecimal("cropSTD", item);
    }
    /**
     * Object:�ۿ��׼'s ����ϵ��property 
     */
    public java.math.BigDecimal getCoefficient()
    {
        return getBigDecimal("coefficient");
    }
    public void setCoefficient(java.math.BigDecimal item)
    {
        setBigDecimal("coefficient", item);
    }
    /**
     * Object:�ۿ��׼'s �ۿ�ϵ��property 
     */
    public java.math.BigDecimal getCoefficientGold()
    {
        return getBigDecimal("coefficientGold");
    }
    public void setCoefficientGold(java.math.BigDecimal item)
    {
        setBigDecimal("coefficientGold", item);
    }
    /**
     * Object:�ۿ��׼'s �����׼property 
     */
    public java.math.BigDecimal getCarcassSTD()
    {
        return getBigDecimal("carcassSTD");
    }
    public void setCarcassSTD(java.math.BigDecimal item)
    {
        setBigDecimal("carcassSTD", item);
    }
    /**
     * Object:�ۿ��׼'s ������property 
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
     * Object:�ۿ��׼'s ��д˵��property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: �ۿ��׼ 's ������ property 
     */
    public com.kingdee.eas.base.permission.UserInfo getCancelcanceler()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("cancelcanceler");
    }
    public void setCancelcanceler(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("cancelcanceler", item);
    }
    /**
     * Object:�ۿ��׼'s ����ʱ��property 
     */
    public java.util.Date getCancelcancelTime()
    {
        return getDate("cancelcancelTime");
    }
    public void setCancelcancelTime(java.util.Date item)
    {
        setDate("cancelcancelTime", item);
    }
    /**
     * Object: �ۿ��׼ 's ������ property 
     */
    public com.kingdee.eas.base.permission.UserInfo getCancelUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("cancelUser");
    }
    public void setCancelUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("cancelUser", item);
    }
    /**
     * Object:�ۿ��׼'s ����ʱ��property 
     */
    public java.util.Date getCancelTime()
    {
        return getDate("cancelTime");
    }
    public void setCancelTime(java.util.Date item)
    {
        setDate("cancelTime", item);
    }
    /**
     * Object: �ۿ��׼ 's ����� property 
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
     * Object:�ۿ��׼'s ���ʱ��property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6E4B5E00");
    }
}