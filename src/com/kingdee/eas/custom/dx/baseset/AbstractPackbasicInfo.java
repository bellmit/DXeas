package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPackbasicInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractPackbasicInfo()
    {
        this("id");
    }
    protected AbstractPackbasicInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.dx.baseset.PackbasicEntryCollection());
    }
    /**
     * Object:��װ��Ϣά��'s �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: ��װ��Ϣά�� 's ��Ʒ��ϸ property 
     */
    public com.kingdee.eas.custom.dx.baseset.PackbasicEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.dx.baseset.PackbasicEntryCollection)get("Entry");
    }
    /**
     * Object: ��װ��Ϣά�� 's ��˾ property 
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
        return new BOSObjectType("EAD218E9");
    }
}