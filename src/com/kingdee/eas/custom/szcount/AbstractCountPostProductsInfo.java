package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountPostProductsInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractCountPostProductsInfo()
    {
        this("id");
    }
    protected AbstractCountPostProductsInfo(String pkField)
    {
        super(pkField);
        put("CppEntry", new com.kingdee.eas.custom.szcount.CountPostProductsCppEntryCollection());
    }
    /**
     * Object:������λ��Ӧ��Ʒ's ������λproperty 
     */
    public com.kingdee.eas.custom.szcount.szCountSet getCountPost()
    {
        return com.kingdee.eas.custom.szcount.szCountSet.getEnum(getString("countPost"));
    }
    public void setCountPost(com.kingdee.eas.custom.szcount.szCountSet item)
    {
		if (item != null) {
        setString("countPost", item.getValue());
		}
    }
    /**
     * Object: ������λ��Ӧ��Ʒ 's ������λ��Ʒ��¼ property 
     */
    public com.kingdee.eas.custom.szcount.CountPostProductsCppEntryCollection getCppEntry()
    {
        return (com.kingdee.eas.custom.szcount.CountPostProductsCppEntryCollection)get("CppEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1E0202C8");
    }
}