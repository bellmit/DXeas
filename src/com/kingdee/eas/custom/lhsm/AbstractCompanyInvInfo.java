package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyInvInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCompanyInvInfo()
    {
        this("id");
    }
    protected AbstractCompanyInvInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 公司及时库存 's 组别 property 
     */
    public com.kingdee.eas.custom.lhsm.CompanyInvTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.lhsm.CompanyInvTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.lhsm.CompanyInvTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 公司及时库存 's 公司 property 
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
     * Object: 公司及时库存 's 物料 property 
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
     * Object:公司及时库存's 库存数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:公司及时库存's 当前可用库存property 
     */
    public java.math.BigDecimal getQty2()
    {
        return getBigDecimal("qty2");
    }
    public void setQty2(java.math.BigDecimal item)
    {
        setBigDecimal("qty2", item);
    }
    /**
     * Object:公司及时库存's 待出库数量property 
     */
    public java.math.BigDecimal getQty1()
    {
        return getBigDecimal("qty1");
    }
    public void setQty1(java.math.BigDecimal item)
    {
        setBigDecimal("qty1", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("286E7161");
    }
}