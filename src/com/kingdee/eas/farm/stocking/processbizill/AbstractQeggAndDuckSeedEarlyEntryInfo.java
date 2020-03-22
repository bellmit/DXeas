package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQeggAndDuckSeedEarlyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractQeggAndDuckSeedEarlyEntryInfo()
    {
        this("id");
    }
    protected AbstractQeggAndDuckSeedEarlyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 区 property 
     */
    public com.kingdee.eas.farm.hatch.HatchAreaInfo getHactchArea()
    {
        return (com.kingdee.eas.farm.hatch.HatchAreaInfo)get("hactchArea");
    }
    public void setHactchArea(com.kingdee.eas.farm.hatch.HatchAreaInfo item)
    {
        put("hactchArea", item);
    }
    /**
     * Object:分录's 合格蛋一级property 
     */
    public java.math.BigDecimal getQEggLevel1()
    {
        return getBigDecimal("qEggLevel1");
    }
    public void setQEggLevel1(java.math.BigDecimal item)
    {
        setBigDecimal("qEggLevel1", item);
    }
    /**
     * Object:分录's 合格蛋大二级property 
     */
    public java.math.BigDecimal getQEggLevelB2()
    {
        return getBigDecimal("qEggLevelB2");
    }
    public void setQEggLevelB2(java.math.BigDecimal item)
    {
        setBigDecimal("qEggLevelB2", item);
    }
    /**
     * Object:分录's 合格蛋二级property 
     */
    public java.math.BigDecimal getQEggLevel2()
    {
        return getBigDecimal("qEggLevel2");
    }
    public void setQEggLevel2(java.math.BigDecimal item)
    {
        setBigDecimal("qEggLevel2", item);
    }
    /**
     * Object:分录's 一级苗property 
     */
    public java.math.BigDecimal getSeedLevel1()
    {
        return getBigDecimal("seedLevel1");
    }
    public void setSeedLevel1(java.math.BigDecimal item)
    {
        setBigDecimal("seedLevel1", item);
    }
    /**
     * Object:分录's 小苗property 
     */
    public java.math.BigDecimal getSeedLevelSmall()
    {
        return getBigDecimal("seedLevelSmall");
    }
    public void setSeedLevelSmall(java.math.BigDecimal item)
    {
        setBigDecimal("seedLevelSmall", item);
    }
    /**
     * Object:分录's 二级苗property 
     */
    public java.math.BigDecimal getSeedLevel2()
    {
        return getBigDecimal("seedLevel2");
    }
    public void setSeedLevel2(java.math.BigDecimal item)
    {
        setBigDecimal("seedLevel2", item);
    }
    /**
     * Object:分录's 三级苗property 
     */
    public java.math.BigDecimal getSeedLevel3()
    {
        return getBigDecimal("seedLevel3");
    }
    public void setSeedLevel3(java.math.BigDecimal item)
    {
        setBigDecimal("seedLevel3", item);
    }
    /**
     * Object:分录's 无品property 
     */
    public java.math.BigDecimal getSeedLevelNo()
    {
        return getBigDecimal("seedLevelNo");
    }
    public void setSeedLevelNo(java.math.BigDecimal item)
    {
        setBigDecimal("seedLevelNo", item);
    }
    /**
     * Object:分录's 转死苗property 
     */
    public java.math.BigDecimal getSeedLevelDead()
    {
        return getBigDecimal("seedLevelDead");
    }
    public void setSeedLevelDead(java.math.BigDecimal item)
    {
        setBigDecimal("seedLevelDead", item);
    }
    /**
     * Object:分录's 上孵一级property 
     */
    public java.math.BigDecimal getHatchLevel1()
    {
        return getBigDecimal("hatchLevel1");
    }
    public void setHatchLevel1(java.math.BigDecimal item)
    {
        setBigDecimal("hatchLevel1", item);
    }
    /**
     * Object:分录's 上孵大二级property 
     */
    public java.math.BigDecimal getHatchLevelB2()
    {
        return getBigDecimal("hatchLevelB2");
    }
    public void setHatchLevelB2(java.math.BigDecimal item)
    {
        setBigDecimal("hatchLevelB2", item);
    }
    /**
     * Object:分录's 上孵二级property 
     */
    public java.math.BigDecimal getHatchLevel2()
    {
        return getBigDecimal("hatchLevel2");
    }
    public void setHatchLevel2(java.math.BigDecimal item)
    {
        setBigDecimal("hatchLevel2", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemarks()
    {
        return getString("remarks");
    }
    public void setRemarks(String item)
    {
        setString("remarks", item);
    }
    /**
     * Object:分录's 代系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenerateType getProgeny()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenerateType.getEnum(getString("progeny"));
    }
    public void setProgeny(com.kingdee.eas.farm.stocking.hatch.GenerateType item)
    {
		if (item != null) {
        setString("progeny", item.getValue());
		}
    }
    /**
     * Object:分录's 各区鸭苗库存合计property 
     */
    public java.math.BigDecimal getSeedInventorytotal()
    {
        return getBigDecimal("seedInventorytotal");
    }
    public void setSeedInventorytotal(java.math.BigDecimal item)
    {
        setBigDecimal("seedInventorytotal", item);
    }
    /**
     * Object:分录's 种鸭苗property 
     */
    public java.math.BigDecimal getSeedDuck()
    {
        return getBigDecimal("seedDuck");
    }
    public void setSeedDuck(java.math.BigDecimal item)
    {
        setBigDecimal("seedDuck", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("16186E17");
    }
}