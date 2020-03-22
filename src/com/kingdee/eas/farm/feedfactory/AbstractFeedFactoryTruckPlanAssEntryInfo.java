package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFactoryTruckPlanAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFeedFactoryTruckPlanAssEntryInfo()
    {
        this("id");
    }
    protected AbstractFeedFactoryTruckPlanAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 要料情况明细分录 's null property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 要料情况明细分录 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFarm()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 要料情况明细分录 's 料塔 property 
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
     * Object:要料情况明细分录's 剩余库存property 
     */
    public java.math.BigDecimal getInventory()
    {
        return getBigDecimal("inventory");
    }
    public void setInventory(java.math.BigDecimal item)
    {
        setBigDecimal("inventory", item);
    }
    /**
     * Object: 要料情况明细分录 's 饲料 property 
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
     * Object:要料情况明细分录's 要料量(公斤)property 
     */
    public java.math.BigDecimal getFodderQty()
    {
        return getBigDecimal("fodderQty");
    }
    public void setFodderQty(java.math.BigDecimal item)
    {
        setBigDecimal("fodderQty", item);
    }
    /**
     * Object: 要料情况明细分录 's 车号 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedTruckInfo getTruck()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedTruckInfo)get("truck");
    }
    public void setTruck(com.kingdee.eas.farm.feedfactory.FeedTruckInfo item)
    {
        put("truck", item);
    }
    /**
     * Object:要料情况明细分录's 所需车次property 
     */
    public int getTruckCount()
    {
        return getInt("truckCount");
    }
    public void setTruckCount(int item)
    {
        setInt("truckCount", item);
    }
    /**
     * Object:要料情况明细分录's 是否忽略property 
     */
    public boolean isIsIgnore()
    {
        return getBoolean("isIgnore");
    }
    public void setIsIgnore(boolean item)
    {
        setBoolean("isIgnore", item);
    }
    /**
     * Object:要料情况明细分录's 前序车次(行号)property 
     */
    public String getMergeTrunckNum()
    {
        return getString("mergeTrunckNum");
    }
    public void setMergeTrunckNum(String item)
    {
        setString("mergeTrunckNum", item);
    }
    /**
     * Object:要料情况明细分录's 料口property 
     */
    public String getFodderPort()
    {
        return getString("fodderPort");
    }
    public void setFodderPort(String item)
    {
        setString("fodderPort", item);
    }
    /**
     * Object:要料情况明细分录's 要料备注property 
     */
    public String getFarmDesc()
    {
        return getString("farmDesc");
    }
    public void setFarmDesc(String item)
    {
        setString("farmDesc", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C539B16F");
    }
}