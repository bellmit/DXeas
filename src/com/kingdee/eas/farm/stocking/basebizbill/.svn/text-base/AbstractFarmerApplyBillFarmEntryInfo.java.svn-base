package com.kingdee.eas.farm.stocking.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerApplyBillFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerApplyBillFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerApplyBillFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场信息 's null property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:养殖场信息's 名称property 
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
     * Object: 养殖场信息 's 养殖场编码 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 养殖场信息 's 养殖场分类 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo getFarmGroup()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo)get("farmGroup");
    }
    public void setFarmGroup(com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo item)
    {
        put("farmGroup", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3622816B");
    }
}