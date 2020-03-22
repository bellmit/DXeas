package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFractionBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFractionBillEntryInfo()
    {
        this("id");
    }
    protected AbstractFractionBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分数工资分录 's null property 
     */
    public com.kingdee.eas.custom.wages.FractionBillInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.FractionBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.FractionBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分数工资分录 's 员工编码 property 
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
     * Object:分数工资分录's 员工名称property 
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
     * Object:分数工资分录's 员工系数property 
     */
    public java.math.BigDecimal getPersonRatio()
    {
        return getBigDecimal("personRatio");
    }
    public void setPersonRatio(java.math.BigDecimal item)
    {
        setBigDecimal("personRatio", item);
    }
    /**
     * Object:分数工资分录's 分数property 
     */
    public java.math.BigDecimal getFraction()
    {
        return getBigDecimal("fraction");
    }
    public void setFraction(java.math.BigDecimal item)
    {
        setBigDecimal("fraction", item);
    }
    /**
     * Object: 分数工资分录 's 员工岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getPersonPost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("personPost");
    }
    public void setPersonPost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("personPost", item);
    }
    /**
     * Object:分数工资分录's 宰杀数量property 
     */
    public java.math.BigDecimal getSlaughterQty()
    {
        return getBigDecimal("slaughterQty");
    }
    public void setSlaughterQty(java.math.BigDecimal item)
    {
        setBigDecimal("slaughterQty", item);
    }
    /**
     * Object:分数工资分录's 岗位系数property 
     */
    public java.math.BigDecimal getPostRatio()
    {
        return getBigDecimal("postRatio");
    }
    public void setPostRatio(java.math.BigDecimal item)
    {
        setBigDecimal("postRatio", item);
    }
    /**
     * Object:分数工资分录's 宰杀常数property 
     */
    public java.math.BigDecimal getSlaughterCt()
    {
        return getBigDecimal("slaughterCt");
    }
    public void setSlaughterCt(java.math.BigDecimal item)
    {
        setBigDecimal("slaughterCt", item);
    }
    /**
     * Object:分数工资分录's 日工资property 
     */
    public java.math.BigDecimal getDayWages()
    {
        return getBigDecimal("dayWages");
    }
    public void setDayWages(java.math.BigDecimal item)
    {
        setBigDecimal("dayWages", item);
    }
    /**
     * Object:分数工资分录's 计量单位property 
     */
    public com.kingdee.eas.custom.wages.FractionUnit getFractionUnit()
    {
        return com.kingdee.eas.custom.wages.FractionUnit.getEnum(getString("fractionUnit"));
    }
    public void setFractionUnit(com.kingdee.eas.custom.wages.FractionUnit item)
    {
		if (item != null) {
        setString("fractionUnit", item.getValue());
		}
    }
    /**
     * Object:分数工资分录's 班次property 
     */
    public com.kingdee.eas.custom.wages.classesState getClasses()
    {
        return com.kingdee.eas.custom.wages.classesState.getEnum(getString("classes"));
    }
    public void setClasses(com.kingdee.eas.custom.wages.classesState item)
    {
		if (item != null) {
        setString("classes", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("ADA015C1");
    }
}