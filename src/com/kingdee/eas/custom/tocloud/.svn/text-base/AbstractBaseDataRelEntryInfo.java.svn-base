package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseDataRelEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBaseDataRelEntryInfo()
    {
        this("id");
    }
    protected AbstractBaseDataRelEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataRelInfo getParent()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataRelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.tocloud.BaseDataRelInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 源系统编码property 
     */
    public String getSrcNumber()
    {
        return getString("srcNumber");
    }
    public void setSrcNumber(String item)
    {
        setString("srcNumber", item);
    }
    /**
     * Object:分录's 源系统名称property 
     */
    public String getSrcName()
    {
        return getString("srcName");
    }
    public void setSrcName(String item)
    {
        setString("srcName", item);
    }
    /**
     * Object:分录's 目标系统编码property 
     */
    public String getTargetNumber()
    {
        return getString("targetNumber");
    }
    public void setTargetNumber(String item)
    {
        setString("targetNumber", item);
    }
    /**
     * Object:分录's 目标系统名称property 
     */
    public String getTargetName()
    {
        return getString("targetName");
    }
    public void setTargetName(String item)
    {
        setString("targetName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("04FEBFAD");
    }
}