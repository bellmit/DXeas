package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMatingBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMatingBillEntryInfo()
    {
        this("id");
    }
    protected AbstractMatingBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.MatingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.MatingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.MatingBillInfo item)
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
     * Object:分录's 用精量(毫升)property 
     */
    public java.math.BigDecimal getUseQty()
    {
        return getBigDecimal("useQty");
    }
    public void setUseQty(java.math.BigDecimal item)
    {
        setBigDecimal("useQty", item);
    }
    /**
     * Object:分录's 评分property 
     */
    public int getGrade()
    {
        return getInt("grade");
    }
    public void setGrade(int item)
    {
        setInt("grade", item);
    }
    /**
     * Object:分录's 配种时间property 
     */
    public java.util.Date getMeatTime()
    {
        return getDate("meatTime");
    }
    public void setMeatTime(java.util.Date item)
    {
        setDate("meatTime", item);
    }
    /**
     * Object: 分录 's 技术员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1BA7E008");
    }
}