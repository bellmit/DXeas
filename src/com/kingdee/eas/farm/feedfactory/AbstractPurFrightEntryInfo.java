package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPurFrightEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPurFrightEntryInfo()
    {
        this("id");
    }
    protected AbstractPurFrightEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.feedfactory.PurFrightInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.PurFrightInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.PurFrightInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMateriel()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("Materiel");
    }
    public void setMateriel(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("Materiel", item);
    }
    /**
     * Object:分录's 物料名称property 
     */
    public String getMaterielName()
    {
        return getString("MaterielName");
    }
    public void setMaterielName(String item)
    {
        setString("MaterielName", item);
    }
    /**
     * Object:分录's 运费property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("Amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("Amount", item);
    }
    /**
     * Object: 分录 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("Warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("Warehouse", item);
    }
    /**
     * Object:分录's 订单数量property 
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
     * Object:分录's 原料单价property 
     */
    public java.math.BigDecimal getYldj()
    {
        return getBigDecimal("yldj");
    }
    public void setYldj(java.math.BigDecimal item)
    {
        setBigDecimal("yldj", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CD1F35B1");
    }
}