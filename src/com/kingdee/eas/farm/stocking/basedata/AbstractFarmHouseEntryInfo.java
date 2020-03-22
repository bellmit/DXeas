package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmHouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmHouseEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 棚舍信息 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:棚舍信息's 编码property 
     */
    public String getNumber()
    {
        return getString("number");
    }
    public void setNumber(String item)
    {
        setString("number", item);
    }
    /**
     * Object:棚舍信息's 名称property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:棚舍信息's 养殖面积property 
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
     * Object:棚舍信息's 建筑面积property 
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
     * Object: 棚舍信息 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCentor()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCentor");
    }
    public void setCostCentor(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCentor", item);
    }
    /**
     * Object: 棚舍信息 's 蛋库 property 
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
     * Object: 棚舍信息 's 饲料仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getSlwarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("slwarehouse");
    }
    public void setSlwarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("slwarehouse", item);
    }
    /**
     * Object: 棚舍信息 's 药品仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getYpwarehousse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("ypwarehousse");
    }
    public void setYpwarehousse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("ypwarehousse", item);
    }
    /**
     * Object: 棚舍信息 's 饲养员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getBreedPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("breedPerson");
    }
    public void setBreedPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("breedPerson", item);
    }
    /**
     * Object:棚舍信息's 养殖规模property 
     */
    public int getScale()
    {
        return getInt("scale");
    }
    public void setScale(int item)
    {
        setInt("scale", item);
    }
    /**
     * Object: 棚舍信息 's 商品蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getSpdwareHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("spdwareHouse");
    }
    public void setSpdwareHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("spdwareHouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("69E58799");
    }
}