package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPackbasicEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPackbasicEntryInfo()
    {
        this("id");
    }
    protected AbstractPackbasicEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 产品明细 's null property 
     */
    public com.kingdee.eas.custom.dx.baseset.PackbasicInfo getParent()
    {
        return (com.kingdee.eas.custom.dx.baseset.PackbasicInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.dx.baseset.PackbasicInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 产品明细 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNum()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNum");
    }
    public void setMaterialNum(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNum", item);
    }
    /**
     * Object:产品明细's 物料名称property 
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
     * Object:产品明细's 规格property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:产品明细's 数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8E562909");
    }
}