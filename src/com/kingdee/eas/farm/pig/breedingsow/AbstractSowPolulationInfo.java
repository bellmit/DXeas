package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSowPolulationInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSowPolulationInfo()
    {
        this("id");
    }
    protected AbstractSowPolulationInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.SowPolulationEntryCollection());
    }
    /**
     * Object: ĸ����Ⱥ 's ��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowPolulationEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowPolulationEntryCollection)get("entrys");
    }
    /**
     * Object:ĸ����Ⱥ's �Ƿ�����ƾ֤property 
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
     * Object:ĸ����Ⱥ's ��Ⱥ����property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:ĸ����Ⱥ's ���ὨȺ����property 
     */
    public java.util.Date getIncoopDate()
    {
        return getDate("incoopDate");
    }
    public void setIncoopDate(java.util.Date item)
    {
        setDate("incoopDate", item);
    }
    /**
     * Object:ĸ����Ⱥ's ��ʼ����property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:ĸ����Ⱥ's ��ʼ����property 
     */
    public int getDay()
    {
        return getInt("day");
    }
    public void setDay(int item)
    {
        setInt("day", item);
    }
    /**
     * Object: ĸ����Ⱥ 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getTechnician()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("technician");
    }
    public void setTechnician(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("technician", item);
    }
    /**
     * Object:ĸ����Ⱥ's ���ʱ��property 
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
     * Object: ĸ����Ⱥ 's ���� property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EF9E5B4B");
    }
}