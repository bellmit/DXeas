package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountPosOtherCppEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCountPosOtherCppEntryInfo()
    {
        this("id");
    }
    protected AbstractCountPosOtherCppEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 计数岗位产品分录 's null property 
     */
    public com.kingdee.eas.custom.szcount.CountPosOtherInfo getParent()
    {
        return (com.kingdee.eas.custom.szcount.CountPosOtherInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.szcount.CountPosOtherInfo item)
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2CBDC06F");
    }
}