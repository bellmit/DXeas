package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCollectSpermBIllEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCollectSpermBIllEntryInfo()
    {
        this("id");
    }
    protected AbstractCollectSpermBIllEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllInfo item)
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
     * Object:��¼'s �ɾ�����property 
     */
    public java.math.BigDecimal getIndoorTemp()
    {
        return getBigDecimal("indoorTemp");
    }
    public void setIndoorTemp(java.math.BigDecimal item)
    {
        setBigDecimal("indoorTemp", item);
    }
    /**
     * Object:��¼'s ��Һ��ɫproperty 
     */
    public com.kingdee.eas.farm.pig.SpermColor getSpermColor()
    {
        return com.kingdee.eas.farm.pig.SpermColor.getEnum(getString("spermColor"));
    }
    public void setSpermColor(com.kingdee.eas.farm.pig.SpermColor item)
    {
		if (item != null) {
        setString("spermColor", item.getValue());
		}
    }
    /**
     * Object:��¼'s ��Һ��ζproperty 
     */
    public com.kingdee.eas.farm.pig.SpermSmell getSpermSmell()
    {
        return com.kingdee.eas.farm.pig.SpermSmell.getEnum(getString("spermSmell"));
    }
    public void setSpermSmell(com.kingdee.eas.farm.pig.SpermSmell item)
    {
		if (item != null) {
        setString("spermSmell", item.getValue());
		}
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("828CADB6");
    }
}