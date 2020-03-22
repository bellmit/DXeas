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
     * Object: ũ������ 's null property 
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
     * Object: ũ������ 's ��ֳ�� property 
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
     * Object:ũ������'s �Ϸ�����property 
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
     * Object:ũ������'s ����property 
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
     * Object:ũ������'s �޾�property 
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
     * Object:ũ������'s ɢ��property 
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
     * Object:ũ������'s ����property 
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
     * Object:ũ������'s ����property 
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
     * Object:ũ������'s ����property 
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
     * Object:ũ������'s ����property 
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
     * Object:ũ������'s �ܾ���(%)property 
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
     * Object:ũ������'s ������(%)property 
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
     * Object: ũ������ 's ���� property 
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
     * Object: ũ������ 's ��Ӧ�� property 
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
     * Object:ũ������'s �ϸ�����property 
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
     * Object:ũ������'s ������(%)property 
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
     * Object:ũ������'s ������(%)property 
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