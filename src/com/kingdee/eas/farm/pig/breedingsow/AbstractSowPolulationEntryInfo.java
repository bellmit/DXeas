package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSowPolulationEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSowPolulationEntryInfo()
    {
        this("id");
    }
    protected AbstractSowPolulationEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ĸ�� property 
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
     * Object:��¼'s ĸ������property 
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
     * Object:��¼'s ��������property 
     */
    public java.util.Date getBornDate()
    {
        return getDate("bornDate");
    }
    public void setBornDate(java.util.Date item)
    {
        setDate("bornDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F01E13E7");
    }
}