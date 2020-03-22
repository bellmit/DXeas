package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedDataSeedEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedDataSeedEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedDataSeedEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种苗分录 's null property 
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
     * Object: 种苗分录 's 物料编码 property 
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
     * Object:种苗分录's 物料名称property 
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
     * Object:种苗分录's 规格property 
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
     * Object:种苗分录's 公母property 
     */
    public com.kingdee.eas.farm.stocking.basedata.MaleOrFemaleEnum getMaleOrFemale()
    {
        return com.kingdee.eas.farm.stocking.basedata.MaleOrFemaleEnum.getEnum(getInt("maleOrFemale"));
    }
    public void setMaleOrFemale(com.kingdee.eas.farm.stocking.basedata.MaleOrFemaleEnum item)
    {
		if (item != null) {
        setInt("maleOrFemale", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7AD9D3F4");
    }
}