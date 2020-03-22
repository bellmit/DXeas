package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasicPostFoodInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBasicPostFoodInfo()
    {
        this("id");
    }
    protected AbstractBasicPostFoodInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.food.BasicPostFoodEntryCollection());
    }
    /**
     * Object:后勤基础岗位's 岗位工资property 
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
     * Object:后勤基础岗位's 岗位补助property 
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
     * Object: 后勤基础岗位 's 岗位人员 property 
     */
    public com.kingdee.eas.custom.wages.food.BasicPostFoodEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.food.BasicPostFoodEntryCollection)get("Entry");
    }
    /**
     * Object:后勤基础岗位's 计量单位property 
     */
    public com.kingdee.eas.custom.wages.UnitOfMetering getUnitMetering()
    {
        return com.kingdee.eas.custom.wages.UnitOfMetering.getEnum(getString("UnitMetering"));
    }
    public void setUnitMetering(com.kingdee.eas.custom.wages.UnitOfMetering item)
    {
		if (item != null) {
        setString("UnitMetering", item.getValue());
		}
    }
    /**
     * Object:后勤基础岗位's 资料状态property 
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
     * Object:后勤基础岗位's 基本工资property 
     */
    public java.math.BigDecimal getFoodamount()
    {
        return getBigDecimal("foodamount");
    }
    public void setFoodamount(java.math.BigDecimal item)
    {
        setBigDecimal("foodamount", item);
    }
    /**
     * Object: 后勤基础岗位 's 所属部门 property 
     */
    public com.kingdee.eas.custom.wages.food.WageFoodOrganInfo getTheGroup()
    {
        return (com.kingdee.eas.custom.wages.food.WageFoodOrganInfo)get("theGroup");
    }
    public void setTheGroup(com.kingdee.eas.custom.wages.food.WageFoodOrganInfo item)
    {
        put("theGroup", item);
    }
    /**
     * Object:后勤基础岗位's 满勤property 
     */
    public java.math.BigDecimal getFullwork()
    {
        return getBigDecimal("Fullwork");
    }
    public void setFullwork(java.math.BigDecimal item)
    {
        setBigDecimal("Fullwork", item);
    }
    /**
     * Object:后勤基础岗位's 考核满额property 
     */
    public java.math.BigDecimal getFullAssessment()
    {
        return getBigDecimal("FullAssessment");
    }
    public void setFullAssessment(java.math.BigDecimal item)
    {
        setBigDecimal("FullAssessment", item);
    }
    /**
     * Object:后勤基础岗位's 是否参与考核测算property 
     */
    public boolean isIsAssessment()
    {
        return getBoolean("isAssessment");
    }
    public void setIsAssessment(boolean item)
    {
        setBoolean("isAssessment", item);
    }
    /**
     * Object: 后勤基础岗位 's 考核测算指标 property 
     */
    public com.kingdee.eas.custom.wages.food.ProdasseindexInfo getAssessmentIndex()
    {
        return (com.kingdee.eas.custom.wages.food.ProdasseindexInfo)get("AssessmentIndex");
    }
    public void setAssessmentIndex(com.kingdee.eas.custom.wages.food.ProdasseindexInfo item)
    {
        put("AssessmentIndex", item);
    }
    /**
     * Object: 后勤基础岗位 's 职位 property 
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
     * Object:后勤基础岗位's 岗位名称property 
     */
    public String getPostname()
    {
        return getString("postname");
    }
    public void setPostname(String item)
    {
        setString("postname", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C5FBD1AA");
    }
}