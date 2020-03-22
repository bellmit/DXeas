package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSpermCheckBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSpermCheckBillEntryInfo()
    {
        this("id");
    }
    protected AbstractSpermCheckBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 采精公猪 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarInfo getBoar()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarInfo)get("boar");
    }
    public void setBoar(com.kingdee.eas.farm.pig.breedingboar.BoarInfo item)
    {
        put("boar", item);
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
     * Object:分录's 公猪名称property 
     */
    public String getBoarName()
    {
        return getString("boarName");
    }
    public void setBoarName(String item)
    {
        setString("boarName", item);
    }
    /**
     * Object:分录's 采精时间property 
     */
    public java.util.Date getCollectTime()
    {
        return getDate("collectTime");
    }
    public void setCollectTime(java.util.Date item)
    {
        setDate("collectTime", item);
    }
    /**
     * Object:分录's 标签号码property 
     */
    public String getLabelNumber()
    {
        return getString("labelNumber");
    }
    public void setLabelNumber(String item)
    {
        setString("labelNumber", item);
    }
    /**
     * Object:分录's 批次号码property 
     */
    public String getBatchNumber()
    {
        return getString("batchNumber");
    }
    public void setBatchNumber(String item)
    {
        setString("batchNumber", item);
    }
    /**
     * Object:分录's 采精量(毫升)property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:分录's 取样数量(毫升)property 
     */
    public java.math.BigDecimal getSampleQty()
    {
        return getBigDecimal("sampleQty");
    }
    public void setSampleQty(java.math.BigDecimal item)
    {
        setBigDecimal("sampleQty", item);
    }
    /**
     * Object: 分录 's 稀释剂 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getDilutionMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("dilutionMaterial");
    }
    public void setDilutionMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("dilutionMaterial", item);
    }
    /**
     * Object:分录's 稀释时间property 
     */
    public java.sql.Time getDilutionTime()
    {
        return getTime("dilutionTime");
    }
    public void setDilutionTime(java.sql.Time item)
    {
        setTime("dilutionTime", item);
    }
    /**
     * Object:分录's 稀释剂用量(毫升)property 
     */
    public java.math.BigDecimal getDilutionQty()
    {
        return getBigDecimal("dilutionQty");
    }
    public void setDilutionQty(java.math.BigDecimal item)
    {
        setBigDecimal("dilutionQty", item);
    }
    /**
     * Object:分录's 入库成品精液数量(毫升)property 
     */
    public java.math.BigDecimal getInQty()
    {
        return getBigDecimal("inQty");
    }
    public void setInQty(java.math.BigDecimal item)
    {
        setBigDecimal("inQty", item);
    }
    /**
     * Object: 分录 's 成品精液物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getInMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("inMaterial");
    }
    public void setInMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("inMaterial", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8B52AA0A");
    }
}