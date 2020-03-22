package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractModifySIStatusEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractModifySIStatusEntryInfo()
    {
        this("id");
    }
    protected AbstractModifySIStatusEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo getParent()
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 选择property 
     */
    public boolean isIsSelected()
    {
        return getBoolean("isSelected");
    }
    public void setIsSelected(boolean item)
    {
        setBoolean("isSelected", item);
    }
    /**
     * Object:分录's 人员编码property 
     */
    public String getShrPersonNum()
    {
        return getString("shrPersonNum");
    }
    public void setShrPersonNum(String item)
    {
        setString("shrPersonNum", item);
    }
    /**
     * Object:分录's 人员名称property 
     */
    public String getShrPersonName()
    {
        return getString("shrPersonName");
    }
    public void setShrPersonName(String item)
    {
        setString("shrPersonName", item);
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
     * Object:分录's 原社保状态property 
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
     * Object:分录's 目标社保状态property 
     */
    public String getDesSIStatus()
    {
        return getString("desSIStatus");
    }
    public void setDesSIStatus(String item)
    {
        setString("desSIStatus", item);
    }
    /**
     * Object:分录's 用工关系状态property 
     */
    public String getEmpType()
    {
        return getString("empType");
    }
    public void setEmpType(String item)
    {
        setString("empType", item);
    }
    /**
     * Object:分录's 公司property 
     */
    public String getCompany()
    {
        return getString("company");
    }
    public void setCompany(String item)
    {
        setString("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5583E331");
    }
}