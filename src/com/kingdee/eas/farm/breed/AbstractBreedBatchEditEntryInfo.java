package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedBatchEditEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedBatchEditEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedBatchEditEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������ 's null property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ������ 's ���� property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object:������'s ��������property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:������'s �����property 
     */
    public com.kingdee.eas.farm.breed.ChikenType getChikenType()
    {
        return com.kingdee.eas.farm.breed.ChikenType.getEnum(getString("chikenType"));
    }
    public void setChikenType(com.kingdee.eas.farm.breed.ChikenType item)
    {
		if (item != null) {
        setString("chikenType", item.getValue());
		}
    }
    /**
     * Object:������'s ��������property 
     */
    public int getAddQty()
    {
        return getInt("addQty");
    }
    public void setAddQty(int item)
    {
        setInt("addQty", item);
    }
    /**
     * Object:������'s �������property 
     */
    public java.util.Date getAddDate()
    {
        return getDate("addDate");
    }
    public void setAddDate(java.util.Date item)
    {
        setDate("addDate", item);
    }
    /**
     * Object:������'s ���ԭ��property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    /**
     * Object:������'s Դ����IDproperty 
     */
    public String getSourceID()
    {
        return getString("sourceID");
    }
    public void setSourceID(String item)
    {
        setString("sourceID", item);
    }
    /**
     * Object:������'s Դ������ϸIDproperty 
     */
    public String getSourceEntryID()
    {
        return getString("sourceEntryID");
    }
    public void setSourceEntryID(String item)
    {
        setString("sourceEntryID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D8F6F968");
    }
}