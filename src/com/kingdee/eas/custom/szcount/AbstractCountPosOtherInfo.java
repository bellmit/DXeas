package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountPosOtherInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractCountPosOtherInfo()
    {
        this("id");
    }
    protected AbstractCountPosOtherInfo(String pkField)
    {
        super(pkField);
        put("CppEntry", new com.kingdee.eas.custom.szcount.CountPosOtherCppEntryCollection());
    }
    /**
     * Object:其他分类定义's 计数岗位property 
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
     * Object: 其他分类定义 's 计数岗位产品分录 property 
     */
    public com.kingdee.eas.custom.szcount.CountPosOtherCppEntryCollection getCppEntry()
    {
        return (com.kingdee.eas.custom.szcount.CountPosOtherCppEntryCollection)get("CppEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7389F7C0");
    }
}