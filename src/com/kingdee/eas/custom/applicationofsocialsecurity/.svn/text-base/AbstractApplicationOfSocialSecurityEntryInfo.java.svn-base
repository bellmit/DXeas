package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractApplicationOfSocialSecurityEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractApplicationOfSocialSecurityEntryInfo()
    {
        this("id");
    }
    protected AbstractApplicationOfSocialSecurityEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo getParent()
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 姓名property 
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
     * Object:分录's 性别property 
     */
    public com.kingdee.eas.basedata.person.Genders getGender()
    {
        return com.kingdee.eas.basedata.person.Genders.getEnum(getInt("gender"));
    }
    public void setGender(com.kingdee.eas.basedata.person.Genders item)
    {
		if (item != null) {
        setInt("gender", item.getValue());
		}
    }
    /**
     * Object:分录's 身份证号码property 
     */
    public String getIdCardNo()
    {
        return getString("idCardNo");
    }
    public void setIdCardNo(String item)
    {
        setString("idCardNo", item);
    }
    /**
     * Object: 分录 's 学历 property 
     */
    public com.kingdee.eas.basedata.hraux.DiplomaInfo getDiploma()
    {
        return (com.kingdee.eas.basedata.hraux.DiplomaInfo)get("diploma");
    }
    public void setDiploma(com.kingdee.eas.basedata.hraux.DiplomaInfo item)
    {
        put("diploma", item);
    }
    /**
     * Object:分录's 岗位property 
     */
    public String getPosition()
    {
        return getString("position");
    }
    public void setPosition(String item)
    {
        setString("position", item);
    }
    /**
     * Object:分录's 月薪property 
     */
    public java.math.BigDecimal getSalary()
    {
        return getBigDecimal("salary");
    }
    public void setSalary(java.math.BigDecimal item)
    {
        setBigDecimal("salary", item);
    }
    /**
     * Object:分录's 合同期限property 
     */
    public java.math.BigDecimal getContractLimitAuto()
    {
        return getBigDecimal("contractLimitAuto");
    }
    public void setContractLimitAuto(java.math.BigDecimal item)
    {
        setBigDecimal("contractLimitAuto", item);
    }
    /**
     * Object:分录's 生效日期property 
     */
    public java.util.Date getContractEffectDate()
    {
        return getDate("contractEffectDate");
    }
    public void setContractEffectDate(java.util.Date item)
    {
        setDate("contractEffectDate", item);
    }
    /**
     * Object:分录's 合同终止日期property 
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
     * Object:分录's 联系方式property 
     */
    public String getContact()
    {
        return getString("contact");
    }
    public void setContact(String item)
    {
        setString("contact", item);
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
     * Object:分录's shr人员编码property 
     */
    public String getShrPersonCode()
    {
        return getString("shrPersonCode");
    }
    public void setShrPersonCode(String item)
    {
        setString("shrPersonCode", item);
    }
    /**
     * Object:分录's 入职日期property 
     */
    public java.util.Date getEnterDate()
    {
        return getDate("enterDate");
    }
    public void setEnterDate(java.util.Date item)
    {
        setDate("enterDate", item);
    }
    /**
     * Object:分录's 部门property 
     */
    public String getDepartment()
    {
        return getString("department");
    }
    public void setDepartment(String item)
    {
        setString("department", item);
    }
    /**
     * Object:分录's 原始社保状态property 
     */
    public String getSrcSIStatus()
    {
        return getString("srcSIStatus");
    }
    public void setSrcSIStatus(String item)
    {
        setString("srcSIStatus", item);
    }
    /**
     * Object:分录's 修改后社保状态property 
     */
    public String getAfterSIStatus()
    {
        return getString("afterSIStatus");
    }
    public void setAfterSIStatus(String item)
    {
        setString("afterSIStatus", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E290CB3D");
    }
}