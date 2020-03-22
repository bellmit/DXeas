package com.kingdee.eas.custom.wlhllicensemanager;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public abstract class AbstractWlhlDataBaseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWlhlDataBaseInfo()
    {
        this("id");
    }
    protected AbstractWlhlDataBaseInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: Wlhl�������� 's ��׼�� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getApprover()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("approver");
    }
    public void setApprover(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("approver", item);
    }
    /**
     * Object:Wlhl��������'s ��׼ʱ��property 
     */
    public java.util.Date getApproveTime()
    {
        return getDate("approveTime");
    }
    public void setApproveTime(java.util.Date item)
    {
        setDate("approveTime", item);
    }
    /**
     * Object:Wlhl��������'s ����״̬property 
     */
    public com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("39BC3AD2");
    }
}