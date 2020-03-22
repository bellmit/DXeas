package com.kingdee.eas.farm.stocking.assistfunction;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSquareChechPermissionInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSquareChechPermissionInfo()
    {
        this("id");
    }
    protected AbstractSquareChechPermissionInfo(String pkField)
    {
        super(pkField);
        put("EntryUser", new com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionEntryUserCollection());
    }
    /**
     * Object: ����У��ƽ̨Ȩ�� 's �û���¼ property 
     */
    public com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionEntryUserCollection getEntryUser()
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionEntryUserCollection)get("EntryUser");
    }
    /**
     * Object: ����У��ƽ̨Ȩ�� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("506C83AC");
    }
}