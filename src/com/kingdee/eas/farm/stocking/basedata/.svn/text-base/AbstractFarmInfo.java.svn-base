package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFarmInfo()
    {
        this("id");
    }
    protected AbstractFarmInfo(String pkField)
    {
        super(pkField);
        put("HouseEntry", new com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryCollection());
    }
    /**
     * Object: 养殖场信息 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:养殖场信息's 地址property 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object:养殖场信息's 养殖面积property 
     */
    public java.math.BigDecimal getArea()
    {
        return getBigDecimal("area");
    }
    public void setArea(java.math.BigDecimal item)
    {
        setBigDecimal("area", item);
    }
    /**
     * Object:养殖场信息's 状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:养殖场信息's 棚舍数量property 
     */
    public int getSuccahQty()
    {
        return getInt("succahQty");
    }
    public void setSuccahQty(int item)
    {
        setInt("succahQty", item);
    }
    /**
     * Object: 养殖场信息 's 财务组织 property 
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
     * Object: 养殖场信息 's 棚舍信息 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryCollection getHouseEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryCollection)get("HouseEntry");
    }
    /**
     * Object:养殖场信息's 建筑面积property 
     */
    public java.math.BigDecimal getFloorArea()
    {
        return getBigDecimal("floorArea");
    }
    public void setFloorArea(java.math.BigDecimal item)
    {
        setBigDecimal("floorArea", item);
    }
    /**
     * Object: 养殖场信息 's 成本中心 property 
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
     * Object:养殖场信息's 棚舍管理property 
     */
    public boolean isIsHouseManager()
    {
        return getBoolean("isHouseManager");
    }
    public void setIsHouseManager(boolean item)
    {
        setBoolean("isHouseManager", item);
    }
    /**
     * Object: 养殖场信息 's 场部库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    /**
     * Object: 养殖场信息 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:养殖场信息's 养殖场类别property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum getFarmType()
    {
        return com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum.getEnum(getInt("farmType"));
    }
    public void setFarmType(com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum item)
    {
		if (item != null) {
        setInt("farmType", item.getValue());
		}
    }
    /**
     * Object:养殖场信息's 已分配property 
     */
    public boolean isIsAllot()
    {
        return getBoolean("isAllot");
    }
    public void setIsAllot(boolean item)
    {
        setBoolean("isAllot", item);
    }
    /**
     * Object:养殖场信息's 养殖规模property 
     */
    public String getGm()
    {
        return getString("gm");
    }
    public void setGm(String item)
    {
        setString("gm", item);
    }
    /**
     * Object:养殖场信息's 养殖模式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmsType getFaemsType()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmsType.getEnum(getString("FaemsType"));
    }
    public void setFaemsType(com.kingdee.eas.farm.stocking.basedata.FarmsType item)
    {
		if (item != null) {
        setString("FaemsType", item.getValue());
		}
    }
    /**
     * Object: 养殖场信息 's 场种苗库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getParentHenWare()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("parentHenWare");
    }
    public void setParentHenWare(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("parentHenWare", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AD78C307");
    }
}