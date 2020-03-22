package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRawmaterialinfoPicentryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRawmaterialinfoPicentryInfo()
    {
        this("id");
    }
    protected AbstractRawmaterialinfoPicentryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ͼƬ��¼ 's null property 
     */
    public com.kingdee.eas.custom.foodtrac.RawmaterialinfoInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.RawmaterialinfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.RawmaterialinfoInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:ͼƬ��¼'s ͼƬ����property 
     */
    public String getPicname()
    {
        return getString("picname");
    }
    public void setPicname(String item)
    {
        setString("picname", item);
    }
    /**
     * Object:ͼƬ��¼'s ͼƬ·��property 
     */
    public String getPicpath()
    {
        return getString("picpath");
    }
    public void setPicpath(String item)
    {
        setString("picpath", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A0AE3060");
    }
}