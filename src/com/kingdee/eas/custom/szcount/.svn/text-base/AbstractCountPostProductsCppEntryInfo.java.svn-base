package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountPostProductsCppEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCountPostProductsCppEntryInfo()
    {
        this("id");
    }
    protected AbstractCountPostProductsCppEntryInfo(String pkField)
    {
        super(pkField);
        put("GroupEntry", new com.kingdee.eas.custom.szcount.CountPostProductsCppEntryGroupEntryCollection());
    }
    /**
     * Object: 计数岗位产品分录 's null property 
     */
    public com.kingdee.eas.custom.szcount.CountPostProductsInfo getParent()
    {
        return (com.kingdee.eas.custom.szcount.CountPostProductsInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.szcount.CountPostProductsInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:计数岗位产品分录's 物料分类property 
     */
    public String getMaterialType()
    {
        return getString("materialType");
    }
    public void setMaterialType(String item)
    {
        setString("materialType", item);
    }
    /**
     * Object: 计数岗位产品分录 's 物料分类分录 property 
     */
    public com.kingdee.eas.custom.szcount.CountPostProductsCppEntryGroupEntryCollection getGroupEntry()
    {
        return (com.kingdee.eas.custom.szcount.CountPostProductsCppEntryGroupEntryCollection)get("GroupEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("721E4377");
    }
}