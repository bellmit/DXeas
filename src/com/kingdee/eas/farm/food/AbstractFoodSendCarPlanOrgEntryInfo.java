package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFoodSendCarPlanOrgEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFoodSendCarPlanOrgEntryInfo()
    {
        this("id");
    }
    protected AbstractFoodSendCarPlanOrgEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 商品鸡场信息 's null property 
     */
    public com.kingdee.eas.farm.food.FoodSendCarPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.food.FoodSendCarPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.FoodSendCarPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:商品鸡场信息's 选择property 
     */
    public boolean isIsSelected()
    {
        return getBoolean("isSelected");
    }
    public void setIsSelected(boolean item)
    {
        setBoolean("isSelected", item);
    }
    /**
     * Object: 商品鸡场信息 's 商品鸡场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrg");
    }
    public void setStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrg", item);
    }
    /**
     * Object:商品鸡场信息's 日龄property 
     */
    public int getDayAge()
    {
        return getInt("dayAge");
    }
    public void setDayAge(int item)
    {
        setInt("dayAge", item);
    }
    /**
     * Object:商品鸡场信息's 存栏量property 
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
     * Object: 商品鸡场信息 's 鸡舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object: 商品鸡场信息 's 批次 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object:商品鸡场信息's 顺序号property 
     */
    public com.kingdee.eas.farm.food.orderEnum getOrder()
    {
        return com.kingdee.eas.farm.food.orderEnum.getEnum(getInt("order"));
    }
    public void setOrder(com.kingdee.eas.farm.food.orderEnum item)
    {
		if (item != null) {
        setInt("order", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4FBA625B");
    }
}