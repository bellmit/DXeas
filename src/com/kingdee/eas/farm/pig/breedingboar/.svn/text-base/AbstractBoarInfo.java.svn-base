package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBoarInfo()
    {
        this("id");
    }
    protected AbstractBoarInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种公猪档案 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.breedingboar.BoarTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 种公猪档案 's 所属养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:种公猪档案's 耳缺property 
     */
    public String getEarGap()
    {
        return getString("earGap");
    }
    public void setEarGap(String item)
    {
        setString("earGap", item);
    }
    /**
     * Object:种公猪档案's 耳标property 
     */
    public String getEarTag()
    {
        return getString("earTag");
    }
    public void setEarTag(String item)
    {
        setString("earTag", item);
    }
    /**
     * Object:种公猪档案's 免疫耳标property 
     */
    public String getImmuneTag()
    {
        return getString("immuneTag");
    }
    public void setImmuneTag(String item)
    {
        setString("immuneTag", item);
    }
    /**
     * Object: 种公猪档案 's 品系 property 
     */
    public com.kingdee.eas.farm.pig.StrainInfo getStrain()
    {
        return (com.kingdee.eas.farm.pig.StrainInfo)get("strain");
    }
    public void setStrain(com.kingdee.eas.farm.pig.StrainInfo item)
    {
        put("strain", item);
    }
    /**
     * Object: 种公猪档案 's 品种 property 
     */
    public com.kingdee.eas.farm.pig.PigTypeInfo getPigType()
    {
        return (com.kingdee.eas.farm.pig.PigTypeInfo)get("pigType");
    }
    public void setPigType(com.kingdee.eas.farm.pig.PigTypeInfo item)
    {
        put("pigType", item);
    }
    /**
     * Object:种公猪档案's 祖代级次property 
     */
    public com.kingdee.eas.farm.pig.GrandLevel getGrandLevel()
    {
        return com.kingdee.eas.farm.pig.GrandLevel.getEnum(getString("grandLevel"));
    }
    public void setGrandLevel(com.kingdee.eas.farm.pig.GrandLevel item)
    {
		if (item != null) {
        setString("grandLevel", item.getValue());
		}
    }
    /**
     * Object:种公猪档案's 左乳数property 
     */
    public int getLeftNippleCount()
    {
        return getInt("leftNippleCount");
    }
    public void setLeftNippleCount(int item)
    {
        setInt("leftNippleCount", item);
    }
    /**
     * Object:种公猪档案's 右乳数property 
     */
    public int getRightNippleCount()
    {
        return getInt("rightNippleCount");
    }
    public void setRightNippleCount(int item)
    {
        setInt("rightNippleCount", item);
    }
    /**
     * Object: 种公猪档案 's 父亲 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.BoarInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 种公猪档案 's 母亲 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowInfo getMother()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowInfo)get("mother");
    }
    public void setMother(com.kingdee.eas.farm.pig.breedingsow.SowInfo item)
    {
        put("mother", item);
    }
    /**
     * Object:种公猪档案's 出生地property 
     */
    public String getBornAddress()
    {
        return getString("bornAddress");
    }
    public void setBornAddress(String item)
    {
        setString("bornAddress", item);
    }
    /**
     * Object:种公猪档案's 出生日期property 
     */
    public java.util.Date getBornDate()
    {
        return getDate("bornDate");
    }
    public void setBornDate(java.util.Date item)
    {
        setDate("bornDate", item);
    }
    /**
     * Object: 种公猪档案 's 出生猪场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getBornFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("bornFarm");
    }
    public void setBornFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("bornFarm", item);
    }
    /**
     * Object: 种公猪档案 's 出生猪舍 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getBornPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("bornPigHouse");
    }
    public void setBornPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("bornPigHouse", item);
    }
    /**
     * Object:种公猪档案's 出生重量property 
     */
    public java.math.BigDecimal getBornWeight()
    {
        return getBigDecimal("bornWeight");
    }
    public void setBornWeight(java.math.BigDecimal item)
    {
        setBigDecimal("bornWeight", item);
    }
    /**
     * Object:种公猪档案's 遗传缺陷property 
     */
    public String getHeredityProblem()
    {
        return getString("heredityProblem");
    }
    public void setHeredityProblem(String item)
    {
        setString("heredityProblem", item);
    }
    /**
     * Object:种公猪档案's 毛质特征property 
     */
    public String getHairFeature()
    {
        return getString("hairFeature");
    }
    public void setHairFeature(String item)
    {
        setString("hairFeature", item);
    }
    /**
     * Object:种公猪档案's 肢蹄特征property 
     */
    public String getHoofFeature()
    {
        return getString("hoofFeature");
    }
    public void setHoofFeature(String item)
    {
        setString("hoofFeature", item);
    }
    /**
     * Object:种公猪档案's 皮肤特征property 
     */
    public String getSkinFeature()
    {
        return getString("skinFeature");
    }
    public void setSkinFeature(String item)
    {
        setString("skinFeature", item);
    }
    /**
     * Object:种公猪档案's 耳朵特征property 
     */
    public String getEarFeature()
    {
        return getString("earFeature");
    }
    public void setEarFeature(String item)
    {
        setString("earFeature", item);
    }
    /**
     * Object:种公猪档案's 断奶日期property 
     */
    public java.util.Date getWeaningDate()
    {
        return getDate("weaningDate");
    }
    public void setWeaningDate(java.util.Date item)
    {
        setDate("weaningDate", item);
    }
    /**
     * Object:种公猪档案's 断奶日龄property 
     */
    public int getWeaningDays()
    {
        return getInt("weaningDays");
    }
    public void setWeaningDays(int item)
    {
        setInt("weaningDays", item);
    }
    /**
     * Object:种公猪档案's 断奶重量property 
     */
    public java.math.BigDecimal getWeaningWeight()
    {
        return getBigDecimal("weaningWeight");
    }
    public void setWeaningWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weaningWeight", item);
    }
    /**
     * Object:种公猪档案's 单据来源property 
     */
    public String getBoraSource()
    {
        return getString("boraSource");
    }
    public void setBoraSource(String item)
    {
        setString("boraSource", item);
    }
    /**
     * Object:种公猪档案's 来源单据编号property 
     */
    public String getSourceBillNumber()
    {
        return getString("sourceBillNumber");
    }
    public void setSourceBillNumber(String item)
    {
        setString("sourceBillNumber", item);
    }
    /**
     * Object:种公猪档案's 状态property 
     */
    public com.kingdee.eas.farm.pig.BoarStatus getStatus()
    {
        return com.kingdee.eas.farm.pig.BoarStatus.getEnum(getString("status"));
    }
    public void setStatus(com.kingdee.eas.farm.pig.BoarStatus item)
    {
		if (item != null) {
        setString("status", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EBFDA8FA");
    }
}