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
     * Object: ��¼ 's ����ͷ property 
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
     * Object: ��¼ 's �ɾ����� property 
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
     * Object:��¼'s ��ȱproperty 
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
     * Object:��¼'s ����property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s �ɾ�ʱ��property 
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
     * Object:��¼'s ��ǩ����property 
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
     * Object:��¼'s ���κ���property 
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
     * Object:��¼'s �ɾ���(����)property 
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
     * Object:��¼'s ȡ������(����)property 
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
     * Object: ��¼ 's ϡ�ͼ� property 
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
     * Object:��¼'s ϡ��ʱ��property 
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
     * Object:��¼'s ϡ�ͼ�����(����)property 
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
     * Object:��¼'s ����Ʒ��Һ����(����)property 
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
     * Object: ��¼ 's ��Ʒ��Һ���� property 
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