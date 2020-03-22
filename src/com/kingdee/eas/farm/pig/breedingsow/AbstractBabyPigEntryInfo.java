package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBabyPigEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBabyPigEntryInfo()
    {
        this("id");
    }
    protected AbstractBabyPigEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.BabyPigInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.BabyPigInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.BabyPigInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��״property 
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
     * Object:��¼'s �Ա�property 
     */
    public com.kingdee.eas.farm.pig.Sex getSex()
    {
        return com.kingdee.eas.farm.pig.Sex.getEnum(getString("sex"));
    }
    public void setSex(com.kingdee.eas.farm.pig.Sex item)
    {
		if (item != null) {
        setString("sex", item.getValue());
		}
    }
    /**
     * Object:��¼'s �������ˣ�property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
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
     * Object:��¼'s ���߶���property 
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
     * Object:��¼'s ����property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8E936F1B");
    }
}