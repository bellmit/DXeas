package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecondAllotInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSecondAllotInfo()
    {
        this("id");
    }
    protected AbstractSecondAllotInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 二次利润分配设置 's 财务组织 property 
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
     * Object:二次利润分配设置's 限定售价property 
     */
    public java.math.BigDecimal getSalePrice()
    {
        return getBigDecimal("salePrice");
    }
    public void setSalePrice(java.math.BigDecimal item)
    {
        setBigDecimal("salePrice", item);
    }
    /**
     * Object:二次利润分配设置's 单价每高property 
     */
    public java.math.BigDecimal getEachPrice()
    {
        return getBigDecimal("eachPrice");
    }
    public void setEachPrice(java.math.BigDecimal item)
    {
        setBigDecimal("eachPrice", item);
    }
    /**
     * Object:二次利润分配设置's 成本上调property 
     */
    public java.math.BigDecimal getAddPrice()
    {
        return getBigDecimal("addPrice");
    }
    public void setAddPrice(java.math.BigDecimal item)
    {
        setBigDecimal("addPrice", item);
    }
    /**
     * Object:二次利润分配设置's 作用物料编码property 
     */
    public String getMaterialNum()
    {
        return getString("materialNum");
    }
    public void setMaterialNum(String item)
    {
        setString("materialNum", item);
    }
    /**
     * Object: 二次利润分配设置 's 结算项目 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettleType()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settleType");
    }
    public void setSettleType(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settleType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E44F1D08");
    }
}