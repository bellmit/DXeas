package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSowAbortionEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSowAbortionEntryInfo()
    {
        this("id");
    }
    protected AbstractSowAbortionEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowAbortionInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowAbortionInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.SowAbortionInfo item)
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
    /**
     * Object:分录's 怀孕天数property 
     */
    public int getFetationDays()
    {
        return getInt("fetationDays");
    }
    public void setFetationDays(int item)
    {
        setInt("fetationDays", item);
    }
    /**
     * Object:分录's 流产原因property 
     */
    public String getAbortionReason()
    {
        return getString("abortionReason");
    }
    public void setAbortionReason(String item)
    {
        setString("abortionReason", item);
    }
    /**
     * Object:分录's 流产日期property 
     */
    public java.util.Date getAbortionDate()
    {
        return getDate("abortionDate");
    }
    public void setAbortionDate(java.util.Date item)
    {
        setDate("abortionDate", item);
    }
    /**
     * Object: 分录 's 所属猪舍 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPighouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pighouse");
    }
    public void setPighouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pighouse", item);
    }
    /**
     * Object: 分录 's 所属栏位 property 
     */
    public com.kingdee.eas.farm.pig.PigFieldInfo getPigFields()
    {
        return (com.kingdee.eas.farm.pig.PigFieldInfo)get("pigFields");
    }
    public void setPigFields(com.kingdee.eas.farm.pig.PigFieldInfo item)
    {
        put("pigFields", item);
    }
    /**
     * Object: 分录 's 转到栏位 property 
     */
    public com.kingdee.eas.farm.pig.PigFieldInfo getTurnFields()
    {
        return (com.kingdee.eas.farm.pig.PigFieldInfo)get("turnFields");
    }
    public void setTurnFields(com.kingdee.eas.farm.pig.PigFieldInfo item)
    {
        put("turnFields", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1028B2C0");
    }
}