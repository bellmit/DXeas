package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInjuryinsuranceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInjuryinsuranceEntryInfo()
    {
        this("id");
    }
    protected AbstractInjuryinsuranceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.InjuryinsuranceInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.InjuryinsuranceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.InjuryinsuranceInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 备注property 
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
     * Object: 分录 's 员工编码 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:分录's 员工姓名property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:分录's 事故发生时间property 
     */
    public java.util.Date getOpentime()
    {
        return getDate("opentime");
    }
    public void setOpentime(java.util.Date item)
    {
        setDate("opentime", item);
    }
    /**
     * Object:分录's 地点property 
     */
    public String getSite()
    {
        return getString("site");
    }
    public void setSite(String item)
    {
        setString("site", item);
    }
    /**
     * Object:分录's 事故情况简述property 
     */
    public String getAccdescription()
    {
        return getString("accdescription");
    }
    public void setAccdescription(String item)
    {
        setString("accdescription", item);
    }
    /**
     * Object: 分录 's 就诊医院 property 
     */
    public com.kingdee.eas.custom.wages.HospitalInfo getHospital()
    {
        return (com.kingdee.eas.custom.wages.HospitalInfo)get("Hospital");
    }
    public void setHospital(com.kingdee.eas.custom.wages.HospitalInfo item)
    {
        put("Hospital", item);
    }
    /**
     * Object:分录's 治疗时间property 
     */
    public java.util.Date getCuretime()
    {
        return getDate("curetime");
    }
    public void setCuretime(java.util.Date item)
    {
        setDate("curetime", item);
    }
    /**
     * Object:分录's 产生费用property 
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
     * Object: 分录 's 险种 property 
     */
    public com.kingdee.eas.custom.wages.InsuranceTypeInfo getInsurancetype()
    {
        return (com.kingdee.eas.custom.wages.InsuranceTypeInfo)get("insurancetype");
    }
    public void setInsurancetype(com.kingdee.eas.custom.wages.InsuranceTypeInfo item)
    {
        put("insurancetype", item);
    }
    /**
     * Object:分录's 备案时间property 
     */
    public java.util.Date getFilingdate()
    {
        return getDate("filingdate");
    }
    public void setFilingdate(java.util.Date item)
    {
        setDate("filingdate", item);
    }
    /**
     * Object:分录's 是否做工伤伤残鉴定property 
     */
    public boolean isIsAppraisal()
    {
        return getBoolean("isAppraisal");
    }
    public void setIsAppraisal(boolean item)
    {
        setBoolean("isAppraisal", item);
    }
    /**
     * Object:分录's 鉴定结果property 
     */
    public String getJdjg()
    {
        return getString("jdjg");
    }
    public void setJdjg(String item)
    {
        setString("jdjg", item);
    }
    /**
     * Object: 分录 's 事件负责人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getCuser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("cuser");
    }
    public void setCuser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("cuser", item);
    }
    /**
     * Object:分录's 保险理赔金额property 
     */
    public java.math.BigDecimal getSureAmount()
    {
        return getBigDecimal("SureAmount");
    }
    public void setSureAmount(java.math.BigDecimal item)
    {
        setBigDecimal("SureAmount", item);
    }
    /**
     * Object: 分录 's 公司 property 
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
     * Object:分录's 费用类型property 
     */
    public com.kingdee.eas.custom.wages.Costtype getCosttype()
    {
        return com.kingdee.eas.custom.wages.Costtype.getEnum(getString("costtype"));
    }
    public void setCosttype(com.kingdee.eas.custom.wages.Costtype item)
    {
		if (item != null) {
        setString("costtype", item.getValue());
		}
    }
    /**
     * Object:分录's 案件状态property 
     */
    public com.kingdee.eas.custom.wages.casetype getCasetype()
    {
        return com.kingdee.eas.custom.wages.casetype.getEnum(getString("casetype"));
    }
    public void setCasetype(com.kingdee.eas.custom.wages.casetype item)
    {
		if (item != null) {
        setString("casetype", item.getValue());
		}
    }
    /**
     * Object:分录's 理赔方式property 
     */
    public com.kingdee.eas.custom.wages.ClaimMethod getClaimMethod()
    {
        return com.kingdee.eas.custom.wages.ClaimMethod.getEnum(getString("ClaimMethod"));
    }
    public void setClaimMethod(com.kingdee.eas.custom.wages.ClaimMethod item)
    {
		if (item != null) {
        setString("ClaimMethod", item.getValue());
		}
    }
    /**
     * Object: 分录 's 鉴定委托方 property 
     */
    public com.kingdee.eas.custom.wages.AppraisalclientInfo getAppraisalClient()
    {
        return (com.kingdee.eas.custom.wages.AppraisalclientInfo)get("AppraisalClient");
    }
    public void setAppraisalClient(com.kingdee.eas.custom.wages.AppraisalclientInfo item)
    {
        put("AppraisalClient", item);
    }
    /**
     * Object:分录's 公司赔偿金额property 
     */
    public java.math.BigDecimal getCompanyAmount()
    {
        return getBigDecimal("companyAmount");
    }
    public void setCompanyAmount(java.math.BigDecimal item)
    {
        setBigDecimal("companyAmount", item);
    }
    /**
     * Object:分录's 事件负责人property 
     */
    public String getSjfzr()
    {
        return getString("sjfzr");
    }
    public void setSjfzr(String item)
    {
        setString("sjfzr", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AC88BCF7");
    }
}