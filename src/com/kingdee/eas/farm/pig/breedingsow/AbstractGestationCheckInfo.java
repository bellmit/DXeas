package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractGestationCheckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractGestationCheckInfo()
    {
        this("id");
    }
    protected AbstractGestationCheckInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.GestationCheckEntryCollection());
    }
    /**
     * Object: ĸ���Ѽ��¼�� 's ��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.GestationCheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.GestationCheckEntryCollection)get("entrys");
    }
    /**
     * Object:ĸ���Ѽ��¼��'s �Ƿ�����ƾ֤property 
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
     * Object:ĸ���Ѽ��¼��'s ���ʱ��property 
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
     * Object:ĸ���Ѽ��¼��'s ״̬property 
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
     * Object: ĸ���Ѽ��¼�� 's ���� property 
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
     * Object: ĸ���Ѽ��¼�� 's ĸ����Ⱥ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo getPolulation()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo)get("polulation");
    }
    public void setPolulation(com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo item)
    {
        put("polulation", item);
    }
    /**
     * Object: ĸ���Ѽ��¼�� 's �����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("07CBAC73");
    }
}