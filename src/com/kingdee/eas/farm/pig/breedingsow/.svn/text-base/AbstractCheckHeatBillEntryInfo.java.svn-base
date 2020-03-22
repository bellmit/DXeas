package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckHeatBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCheckHeatBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCheckHeatBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.CheckHeatBillInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.CheckHeatBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.CheckHeatBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 母猪 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowInfo getSow()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowInfo)get("sow");
    }
    public void setSow(com.kingdee.eas.farm.pig.breedingsow.SowInfo item)
    {
        put("sow", item);
    }
    /**
     * Object:分录's 耳缺property 
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
     * Object:分录's 耳标property 
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
     * Object:分录's 免疫耳标property 
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
     * Object:分录's 品种property 
     */
    public String getPigType()
    {
        return getString("pigType");
    }
    public void setPigType(String item)
    {
        setString("pigType", item);
    }
    /**
     * Object:分录's 母猪名称property 
     */
    public String getSowName()
    {
        return getString("sowName");
    }
    public void setSowName(String item)
    {
        setString("sowName", item);
    }
    /**
     * Object:分录's 胎次property 
     */
    public int getFetusNum()
    {
        return getInt("fetusNum");
    }
    public void setFetusNum(int item)
    {
        setInt("fetusNum", item);
    }
    /**
     * Object:分录's 情期property 
     */
    public int getHeatNum()
    {
        return getInt("heatNum");
    }
    public void setHeatNum(int item)
    {
        setInt("heatNum", item);
    }
    /**
     * Object:分录's 是否发情property 
     */
    public boolean isIsHeat()
    {
        return getBoolean("isHeat");
    }
    public void setIsHeat(boolean item)
    {
        setBoolean("isHeat", item);
    }
    /**
     * Object:分录's 性状property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D8896854");
    }
}