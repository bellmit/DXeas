package com.kingdee.eas.farm.breed.freedplan;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedFodderPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedFodderPlanInfo()
    {
        this("id");
    }
    protected AbstractBreedFodderPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanEntryCollection());
    }
    /**
     * Object: ����Ҫ�ϼƻ� 's ��¼ property 
     */
    public com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.freedplan.BreedFodderPlanEntryCollection)get("entrys");
    }
    /**
     * Object:����Ҫ�ϼƻ�'s �Ƿ�����ƾ֤property 
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
     * Object:����Ҫ�ϼƻ�'s ���ʱ��property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6CE20F2C");
    }
}