package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCandlingBillInputModelInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCandlingBillInputModelInfo()
    {
        this("id");
    }
    protected AbstractCandlingBillInputModelInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�յ�����ģʽ's �Ƿ����öproperty 
     */
    public boolean isIsCFPM()
    {
        return getBoolean("isCFPM");
    }
    public void setIsCFPM(boolean item)
    {
        setBoolean("isCFPM", item);
    }
    /**
     * Object: �յ�����ģʽ 's �û� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("user", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("939A679E");
    }
}