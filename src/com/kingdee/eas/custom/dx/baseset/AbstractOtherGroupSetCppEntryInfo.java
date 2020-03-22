package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherGroupSetCppEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOtherGroupSetCppEntryInfo()
    {
        this("id");
    }
    protected AbstractOtherGroupSetCppEntryInfo(String pkField)
    {
        super(pkField);
        put("GroupEntry", new com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryGroupEntryCollection());
    }
    /**
     * Object: 计数岗位产品分录 's null property 
     */
    public com.kingdee.eas.custom.dx.baseset.OtherGroupSetInfo getParent()
    {
        return (com.kingdee.eas.custom.dx.baseset.OtherGroupSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.dx.baseset.OtherGroupSetInfo item)
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
    public com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryGroupEntryCollection getGroupEntry()
    {
        return (com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryGroupEntryCollection)get("GroupEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4EFE7376");
    }
}