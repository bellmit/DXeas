package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggDailyConveyorInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggDailyConveyorInfo()
    {
        this("id");
    }
    protected AbstractLayEggDailyConveyorInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 传送带信息 's null property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 传送带信息 's 传送带 property 
     */
    public com.kingdee.eas.farm.breed.layegg.EggConveyorInfo getConveyorNumber()
    {
        return (com.kingdee.eas.farm.breed.layegg.EggConveyorInfo)get("conveyorNumber");
    }
    public void setConveyorNumber(com.kingdee.eas.farm.breed.layegg.EggConveyorInfo item)
    {
        put("conveyorNumber", item);
    }
    /**
     * Object:传送带信息's 包含禽舍property 
     */
    public String getHenhouseDesc()
    {
        return getString("henhouseDesc");
    }
    public void setHenhouseDesc(String item)
    {
        setString("henhouseDesc", item);
    }
    /**
     * Object:传送带信息's 合格蛋property 
     */
    public int getQualifiedEggs()
    {
        return getInt("qualifiedEggs");
    }
    public void setQualifiedEggs(int item)
    {
        setInt("qualifiedEggs", item);
    }
    /**
     * Object:传送带信息's 畸形蛋property 
     */
    public int getFreakEggs()
    {
        return getInt("freakEggs");
    }
    public void setFreakEggs(int item)
    {
        setInt("freakEggs", item);
    }
    /**
     * Object:传送带信息's 双黄蛋property 
     */
    public int getDoubleYolkedEggs()
    {
        return getInt("doubleYolkedEggs");
    }
    public void setDoubleYolkedEggs(int item)
    {
        setInt("doubleYolkedEggs", item);
    }
    /**
     * Object:传送带信息's 破蛋property 
     */
    public int getBrokenEggs()
    {
        return getInt("brokenEggs");
    }
    public void setBrokenEggs(int item)
    {
        setInt("brokenEggs", item);
    }
    /**
     * Object:传送带信息's 平均蛋重（g）property 
     */
    public java.math.BigDecimal getEggAverageWeight()
    {
        return getBigDecimal("eggAverageWeight");
    }
    public void setEggAverageWeight(java.math.BigDecimal item)
    {
        setBigDecimal("eggAverageWeight", item);
    }
    /**
     * Object:传送带信息's 调拨双黄蛋数property 
     */
    public int getDoubleYolkTransQty()
    {
        return getInt("doubleYolkTransQty");
    }
    public void setDoubleYolkTransQty(int item)
    {
        setInt("doubleYolkTransQty", item);
    }
    /**
     * Object:传送带信息's 调拨畸形蛋数property 
     */
    public int getFreakTransQty()
    {
        return getInt("freakTransQty");
    }
    public void setFreakTransQty(int item)
    {
        setInt("freakTransQty", item);
    }
    /**
     * Object:传送带信息's 调拨合格蛋数property 
     */
    public int getQulifiedTransQty()
    {
        return getInt("qulifiedTransQty");
    }
    public void setQulifiedTransQty(int item)
    {
        setInt("qulifiedTransQty", item);
    }
    /**
     * Object:传送带信息's 双黄蛋及时库存property 
     */
    public java.math.BigDecimal getDoubleYolkInventory()
    {
        return getBigDecimal("doubleYolkInventory");
    }
    public void setDoubleYolkInventory(java.math.BigDecimal item)
    {
        setBigDecimal("doubleYolkInventory", item);
    }
    /**
     * Object:传送带信息's 畸形蛋及时库存property 
     */
    public java.math.BigDecimal getFreakInventory()
    {
        return getBigDecimal("freakInventory");
    }
    public void setFreakInventory(java.math.BigDecimal item)
    {
        setBigDecimal("freakInventory", item);
    }
    /**
     * Object:传送带信息's 合格蛋及时库存property 
     */
    public java.math.BigDecimal getQualifyInventory()
    {
        return getBigDecimal("qualifyInventory");
    }
    public void setQualifyInventory(java.math.BigDecimal item)
    {
        setBigDecimal("qualifyInventory", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FBB2E016");
    }
}