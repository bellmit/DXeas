package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggCandlingBillFarmerSumEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggCandlingBillFarmerSumEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggCandlingBillFarmerSumEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 农户汇总 's null property 
     */
    public com.kingdee.eas.farm.hatch.BEggCandlingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BEggCandlingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BEggCandlingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 农户汇总 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:农户汇总's 上孵蛋数property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object:农户汇总's 活胚property 
     */
    public int getHealthEggQty()
    {
        return getInt("healthEggQty");
    }
    public void setHealthEggQty(int item)
    {
        setInt("healthEggQty", item);
    }
    /**
     * Object:农户汇总's 无精property 
     */
    public int getNoFertileEggQty()
    {
        return getInt("noFertileEggQty");
    }
    public void setNoFertileEggQty(int item)
    {
        setInt("noFertileEggQty", item);
    }
    /**
     * Object:农户汇总's 散黄property 
     */
    public int getBrokenYolkQty()
    {
        return getInt("brokenYolkQty");
    }
    public void setBrokenYolkQty(int item)
    {
        setInt("brokenYolkQty", item);
    }
    /**
     * Object:农户汇总's 死胚property 
     */
    public int getAddleEggQty()
    {
        return getInt("addleEggQty");
    }
    public void setAddleEggQty(int item)
    {
        setInt("addleEggQty", item);
    }
    /**
     * Object:农户汇总's 臭蛋property 
     */
    public int getRottenEggQty()
    {
        return getInt("rottenEggQty");
    }
    public void setRottenEggQty(int item)
    {
        setInt("rottenEggQty", item);
    }
    /**
     * Object:农户汇总's 破损property 
     */
    public int getBrokenEggQty()
    {
        return getInt("brokenEggQty");
    }
    public void setBrokenEggQty(int item)
    {
        setInt("brokenEggQty", item);
    }
    /**
     * Object:农户汇总's 差异property 
     */
    public int getDiffEggQty()
    {
        return getInt("diffEggQty");
    }
    public void setDiffEggQty(int item)
    {
        setInt("diffEggQty", item);
    }
    /**
     * Object:农户汇总's 受精率(%)property 
     */
    public java.math.BigDecimal getFertilityRate()
    {
        return getBigDecimal("fertilityRate");
    }
    public void setFertilityRate(java.math.BigDecimal item)
    {
        setBigDecimal("fertilityRate", item);
    }
    /**
     * Object:农户汇总's 死胚率(%)property 
     */
    public java.math.BigDecimal getAddleEggRate()
    {
        return getBigDecimal("addleEggRate");
    }
    public void setAddleEggRate(java.math.BigDecimal item)
    {
        setBigDecimal("addleEggRate", item);
    }
    /**
     * Object: 农户汇总 's 栋舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object: 农户汇总 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupploer1()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supploer1");
    }
    public void setSupploer1(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supploer1", item);
    }
    /**
     * Object:农户汇总's 合格蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.QcEggTypeEnum getHgdlx()
    {
        return com.kingdee.eas.farm.hatch.QcEggTypeEnum.getEnum(getInt("hgdlx"));
    }
    public void setHgdlx(com.kingdee.eas.farm.hatch.QcEggTypeEnum item)
    {
		if (item != null) {
        setInt("hgdlx", item.getValue());
		}
    }
    /**
     * Object:农户汇总's 破损率(%)property 
     */
    public java.math.BigDecimal getBrokenRate()
    {
        return getBigDecimal("brokenRate");
    }
    public void setBrokenRate(java.math.BigDecimal item)
    {
        setBigDecimal("brokenRate", item);
    }
    /**
     * Object:农户汇总's 臭蛋率(%)property 
     */
    public java.math.BigDecimal getRottenRate()
    {
        return getBigDecimal("rottenRate");
    }
    public void setRottenRate(java.math.BigDecimal item)
    {
        setBigDecimal("rottenRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("565773AC");
    }
}