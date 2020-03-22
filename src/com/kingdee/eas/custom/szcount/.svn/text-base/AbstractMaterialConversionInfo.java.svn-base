package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialConversionInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMaterialConversionInfo()
    {
        this("id");
    }
    protected AbstractMaterialConversionInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 物料换算 's 组别 property 
     */
    public com.kingdee.eas.custom.szcount.MaterialConversionTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.szcount.MaterialConversionTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.szcount.MaterialConversionTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:物料换算's 一盘property 
     */
    public java.math.BigDecimal getOneDise()
    {
        return getBigDecimal("oneDise");
    }
    public void setOneDise(java.math.BigDecimal item)
    {
        setBigDecimal("oneDise", item);
    }
    /**
     * Object:物料换算's 一件property 
     */
    public java.math.BigDecimal getOneItem()
    {
        return getBigDecimal("oneItem");
    }
    public void setOneItem(java.math.BigDecimal item)
    {
        setBigDecimal("oneItem", item);
    }
    /**
     * Object:物料换算's 一包property 
     */
    public java.math.BigDecimal getOnePackage()
    {
        return getBigDecimal("onePackage");
    }
    public void setOnePackage(java.math.BigDecimal item)
    {
        setBigDecimal("onePackage", item);
    }
    /**
     * Object: 物料换算 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    /**
     * Object: 物料换算 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:物料换算's 物料名称property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:物料换算's 物料编码property 
     */
    public String getMaterialNumber()
    {
        return getString("materialNumber");
    }
    public void setMaterialNumber(String item)
    {
        setString("materialNumber", item);
    }
    /**
     * Object:物料换算's 规格型号property 
     */
    public String getSpecifications()
    {
        return getString("specifications");
    }
    public void setSpecifications(String item)
    {
        setString("specifications", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EC09F248");
    }
}