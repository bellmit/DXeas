package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHenhouseInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHenhouseInfo()
    {
        this("id");
    }
    protected AbstractHenhouseInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:«›…·'s  «∑Ò…˙≥…∆æ÷§property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:«›…·'s µÁ±Ì±‡∫≈property 
     */
    public String getAmmeter()
    {
        return getString("ammeter");
    }
    public void setAmmeter(String item)
    {
        setString("ammeter", item);
    }
    /**
     * Object:«›…·'s ÀÆ±Ì±‡∫≈property 
     */
    public String getWatermeter()
    {
        return getString("watermeter");
    }
    public void setWatermeter(String item)
    {
        setString("watermeter", item);
    }
    /**
     * Object:«›…·'s «›…·¿‡±property 
     */
    public com.kingdee.eas.farm.breed.HenhouseType getHouseType()
    {
        return com.kingdee.eas.farm.breed.HenhouseType.getEnum(getString("houseType"));
    }
    public void setHouseType(com.kingdee.eas.farm.breed.HenhouseType item)
    {
		if (item != null) {
        setString("houseType", item.getValue());
		}
    }
    /**
     * Object: «›…· 's ¡œÀ˛≤÷ø‚ property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getTower()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("tower");
    }
    public void setTower(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("tower", item);
    }
    /**
     * Object:«›…·'s ◊¥Ã¨property 
     */
    public com.kingdee.eas.farm.breed.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.farm.breed.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.farm.breed.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    /**
     * Object: «›…· 's ¡œÀ˛2≤÷ø‚ property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getCockTower()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("cockTower");
    }
    public void setCockTower(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("cockTower", item);
    }
    /**
     * Object: «›…· 's ≤÷ø‚ property 
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
     * Object:«›…·'s «›…·√˚≥∆property 
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
     * Object: «›…· 's ≥…±æ÷––ƒ property 
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
     * Object: «›…· 's ¥´ÀÕ¥¯ property 
     */
    public com.kingdee.eas.farm.breed.layegg.EggConveyorInfo getConveyor()
    {
        return (com.kingdee.eas.farm.breed.layegg.EggConveyorInfo)get("conveyor");
    }
    public void setConveyor(com.kingdee.eas.farm.breed.layegg.EggConveyorInfo item)
    {
        put("conveyor", item);
    }
    /**
     * Object: «›…· 's —¯÷≥≥°≥°≤øø‚ property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getFarmWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("farmWarehouse");
    }
    public void setFarmWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("farmWarehouse", item);
    }
    /**
     * Object:«›…·'s ’ºµÿ√Êª˝£®©O£©property 
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
     * Object: «›…· 's ¡• Ù—¯÷≥≥° property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: «›…· 's «›…·ø‚¥Ê◊È÷Ø property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getHenhouseStoorg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("henhouseStoorg");
    }
    public void setHenhouseStoorg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("henhouseStoorg", item);
    }
    /**
     * Object: «›…· 's À˘ Ù«¯”Ú property 
     */
    public com.kingdee.eas.farm.breed.BreedAreaInfo getBreedArea()
    {
        return (com.kingdee.eas.farm.breed.BreedAreaInfo)get("breedArea");
    }
    public void setBreedArea(com.kingdee.eas.farm.breed.BreedAreaInfo item)
    {
        put("breedArea", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EFA27609");
    }
}