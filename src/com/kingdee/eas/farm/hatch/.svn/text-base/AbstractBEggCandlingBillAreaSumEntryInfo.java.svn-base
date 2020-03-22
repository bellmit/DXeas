package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBEggCandlingBillAreaSumEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBEggCandlingBillAreaSumEntryInfo()
    {
        this("id");
    }
    protected AbstractBEggCandlingBillAreaSumEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 片区汇总 's null property 
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
     * Object: 片区汇总 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutArea()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outArea");
    }
    public void setOutArea(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outArea", item);
    }
    /**
     * Object:片区汇总's 合格蛋类别property 
     */
    public com.kingdee.eas.farm.hatch.QcEggTypeEnum getQcEggType()
    {
        return com.kingdee.eas.farm.hatch.QcEggTypeEnum.getEnum(getInt("qcEggType"));
    }
    public void setQcEggType(com.kingdee.eas.farm.hatch.QcEggTypeEnum item)
    {
		if (item != null) {
        setInt("qcEggType", item.getValue());
		}
    }
    /**
     * Object:片区汇总's 上孵数量property 
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
     * Object:片区汇总's 活胚property 
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
     * Object:片区汇总's 无精property 
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
     * Object:片区汇总's 散黄property 
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
     * Object:片区汇总's 死胚property 
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
     * Object:片区汇总's 臭蛋property 
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
     * Object:片区汇总's 破损property 
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
     * Object:片区汇总's 差异property 
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
     * Object:片区汇总's 受精率(%)property 
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
     * Object:片区汇总's 死胚率(%)property 
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
     * Object: 片区汇总 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D7AB7356");
    }
}