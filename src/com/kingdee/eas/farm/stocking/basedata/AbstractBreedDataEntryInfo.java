package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedDataEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedDataEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedDataEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��Ʒ��¼ 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��Ʒ��¼ 's ���ϱ��� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:��Ʒ��¼'s ��������property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:��Ʒ��¼'s ����ͺ�property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:��Ʒ��¼'s �Ƿ�ϸ�Ʒproperty 
     */
    public boolean isIsQualified()
    {
        return getBoolean("isQualified");
    }
    public void setIsQualified(boolean item)
    {
        setBoolean("isQualified", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8EFBE565");
    }
}