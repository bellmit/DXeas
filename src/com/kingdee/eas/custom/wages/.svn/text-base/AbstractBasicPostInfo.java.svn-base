package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasicPostInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBasicPostInfo()
    {
        this("id");
    }
    protected AbstractBasicPostInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.BasicPostEntryCollection());
    }
    /**
     * Object:基础岗位's 岗位工资property 
     */
    public java.math.BigDecimal getPostSalary()
    {
        return getBigDecimal("PostSalary");
    }
    public void setPostSalary(java.math.BigDecimal item)
    {
        setBigDecimal("PostSalary", item);
    }
    /**
     * Object: 基础岗位 's 所属班组 property 
     */
    public com.kingdee.eas.custom.wages.WageOrganizationInfo getTheGroup()
    {
        return (com.kingdee.eas.custom.wages.WageOrganizationInfo)get("theGroup");
    }
    public void setTheGroup(com.kingdee.eas.custom.wages.WageOrganizationInfo item)
    {
        put("theGroup", item);
    }
    /**
     * Object:基础岗位's 产品系数property 
     */
    public java.math.BigDecimal getProductRatio()
    {
        return getBigDecimal("ProductRatio");
    }
    public void setProductRatio(java.math.BigDecimal item)
    {
        setBigDecimal("ProductRatio", item);
    }
    /**
     * Object: 基础岗位 's 提取来源 property 
     */
    public com.kingdee.eas.custom.wages.ExtractFromInfo getExtractFrom()
    {
        return (com.kingdee.eas.custom.wages.ExtractFromInfo)get("ExtractFrom");
    }
    public void setExtractFrom(com.kingdee.eas.custom.wages.ExtractFromInfo item)
    {
        put("ExtractFrom", item);
    }
    /**
     * Object:基础岗位's 资料状态property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBaseStatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("BaseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("BaseStatus", item.getValue());
		}
    }
    /**
     * Object:基础岗位's 基本工资property 
     */
    public java.math.BigDecimal getBasicWages()
    {
        return getBigDecimal("BasicWages");
    }
    public void setBasicWages(java.math.BigDecimal item)
    {
        setBigDecimal("BasicWages", item);
    }
    /**
     * Object:基础岗位's 岗位名称property 
     */
    public String getPostname()
    {
        return getString("postname");
    }
    public void setPostname(String item)
    {
        setString("postname", item);
    }
    /**
     * Object: 基础岗位 's 所属岗位 property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("position");
    }
    public void setPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("position", item);
    }
    /**
     * Object:基础岗位's 宰杀常数property 
     */
    public java.math.BigDecimal getSlaughter()
    {
        return getBigDecimal("slaughter");
    }
    public void setSlaughter(java.math.BigDecimal item)
    {
        setBigDecimal("slaughter", item);
    }
    /**
     * Object:基础岗位's 系数property 
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
     * Object: 基础岗位 's 公司 property 
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
     * Object: 基础岗位 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.BasicPostEntryCollection)get("Entry");
    }
    /**
     * Object:基础岗位's 计量单位property 
     */
    public com.kingdee.eas.custom.wages.FractionUnit getUnitMetering()
    {
        return com.kingdee.eas.custom.wages.FractionUnit.getEnum(getString("UnitMetering"));
    }
    public void setUnitMetering(com.kingdee.eas.custom.wages.FractionUnit item)
    {
		if (item != null) {
        setString("UnitMetering", item.getValue());
		}
    }
    /**
     * Object:基础岗位's 工资类型property 
     */
    public com.kingdee.eas.custom.wages.wagesType getWagesType()
    {
        return com.kingdee.eas.custom.wages.wagesType.getEnum(getString("wagesType"));
    }
    public void setWagesType(com.kingdee.eas.custom.wages.wagesType item)
    {
		if (item != null) {
        setString("wagesType", item.getValue());
		}
    }
    /**
     * Object: 基础岗位 's 岗位系数 property 
     */
    public com.kingdee.eas.custom.wages.CoefficientInfo getCoefficientRate()
    {
        return (com.kingdee.eas.custom.wages.CoefficientInfo)get("CoefficientRate");
    }
    public void setCoefficientRate(com.kingdee.eas.custom.wages.CoefficientInfo item)
    {
        put("CoefficientRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1F8BC6E6");
    }
}