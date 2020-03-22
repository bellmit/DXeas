package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCollectSpermBIllInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCollectSpermBIllInfo()
    {
        this("id");
    }
    protected AbstractCollectSpermBIllInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllEntryCollection());
    }
    /**
     * Object: �ɾ���¼�� 's ��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllEntryCollection)get("entrys");
    }
    /**
     * Object:�ɾ���¼��'s �Ƿ�����ƾ֤property 
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
     * Object:�ɾ���¼��'s ���ʱ��property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: �ɾ���¼�� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:�ɾ���¼��'s ״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: �ɾ���¼�� 's �ɾ���Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getCollectPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("collectPerson");
    }
    public void setCollectPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("collectPerson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3ABC9C1C");
    }
}