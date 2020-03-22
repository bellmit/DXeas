package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBaseDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractHatchBaseDataInfo()
    {
        this("id");
    }
    protected AbstractHatchBaseDataInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 孵化厂设置 's 组别 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 孵化厂设置 's 孵化场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getHatchFactory()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object:孵化厂设置's 孵化蛋车装蛋数property 
     */
    public int getEggQtyPerCar()
    {
        return getInt("eggQtyPerCar");
    }
    public void setEggQtyPerCar(int item)
    {
        setInt("eggQtyPerCar", item);
    }
    /**
     * Object:孵化厂设置's 暂存天数property 
     */
    public int getSaveDays()
    {
        return getInt("saveDays");
    }
    public void setSaveDays(int item)
    {
        setInt("saveDays", item);
    }
    /**
     * Object:孵化厂设置's 出雏标准日期property 
     */
    public int getHatchingDays()
    {
        return getInt("hatchingDays");
    }
    public void setHatchingDays(int item)
    {
        setInt("hatchingDays", item);
    }
    /**
     * Object:孵化厂设置's 标准出雏率property 
     */
    public java.math.BigDecimal getHatchingRate()
    {
        return getBigDecimal("hatchingRate");
    }
    public void setHatchingRate(java.math.BigDecimal item)
    {
        setBigDecimal("hatchingRate", item);
    }
    /**
     * Object:孵化厂设置's 单据状态property 
     */
    public com.kingdee.eas.farm.hatch.billStatus getBillStatus()
    {
        return com.kingdee.eas.farm.hatch.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.farm.hatch.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object: 孵化厂设置 's 默认幼苗仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getDefaultBabyWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("defaultBabyWarehouse");
    }
    public void setDefaultBabyWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("defaultBabyWarehouse", item);
    }
    /**
     * Object: 孵化厂设置 's 默认蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getDefaultEggWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("defaultEggWarehouse");
    }
    public void setDefaultEggWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("defaultEggWarehouse", item);
    }
    /**
     * Object:孵化厂设置's 默认种蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.EggType getDefaultEggType()
    {
        return com.kingdee.eas.farm.hatch.EggType.getEnum(getString("defaultEggType"));
    }
    public void setDefaultEggType(com.kingdee.eas.farm.hatch.EggType item)
    {
		if (item != null) {
        setString("defaultEggType", item.getValue());
		}
    }
    /**
     * Object:孵化厂设置's 默认种蛋来源类型property 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getDefaultEggSourceType()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("defaultEggSourceType"));
    }
    public void setDefaultEggSourceType(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("defaultEggSourceType", item.getValue());
		}
    }
    /**
     * Object: 孵化厂设置 's 默认父母代蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getDefaultParentWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("defaultParentWarehouse");
    }
    public void setDefaultParentWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("defaultParentWarehouse", item);
    }
    /**
     * Object: 孵化厂设置 's 默认祖代蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getDefaultGrandWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("defaultGrandWarehouse");
    }
    public void setDefaultGrandWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("defaultGrandWarehouse", item);
    }
    /**
     * Object: 孵化厂设置 's 默认商品代蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getDefaultCDWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("defaultCDWarehouse");
    }
    public void setDefaultCDWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("defaultCDWarehouse", item);
    }
    /**
     * Object: 孵化厂设置 's 对应成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object: 孵化厂设置 's 副产品库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getOtherProductWare()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("otherProductWare");
    }
    public void setOtherProductWare(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("otherProductWare", item);
    }
    /**
     * Object: 孵化厂设置 's 默认商品蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getDefaultSPDWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("defaultSPDWarehouse");
    }
    public void setDefaultSPDWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("defaultSPDWarehouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("22461B2D");
    }
}