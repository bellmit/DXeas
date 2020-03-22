package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProductCategoryInfoEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProductCategoryInfoEntryInfo()
    {
        this("id");
    }
    protected AbstractProductCategoryInfoEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.foodtrac.ProductCategoryInfoInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.ProductCategoryInfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.ProductCategoryInfoInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 物料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialnumber()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialnumber");
    }
    public void setMaterialnumber(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialnumber", item);
    }
    /**
     * Object:分录's 物料名称property 
     */
    public String getMaterialname()
    {
        return getString("materialname");
    }
    public void setMaterialname(String item)
    {
        setString("materialname", item);
    }
    /**
     * Object:分录's 规格型号property 
     */
    public String getMaterialmodel()
    {
        return getString("materialmodel");
    }
    public void setMaterialmodel(String item)
    {
        setString("materialmodel", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B373919C");
    }
}