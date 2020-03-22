package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherGroupSetInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractOtherGroupSetInfo()
    {
        this("id");
    }
    protected AbstractOtherGroupSetInfo(String pkField)
    {
        super(pkField);
        put("CppEntry", new com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryCollection());
    }
    /**
     * Object:车间物料分类对应设置's 计数岗位property 
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
     * Object: 车间物料分类对应设置 's 计数岗位产品分录 property 
     */
    public com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryCollection getCppEntry()
    {
        return (com.kingdee.eas.custom.dx.baseset.OtherGroupSetCppEntryCollection)get("CppEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F135A1C7");
    }
}