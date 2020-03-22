package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedAreaInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedAreaInfo()
    {
        this("id");
    }
    protected AbstractBreedAreaInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:区's 是否生成凭证property 
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
     * Object:区's 区名称property 
     */
    public String getAreaName()
    {
        return getString("areaName");
    }
    public void setAreaName(String item)
    {
        setString("areaName", item);
    }
    /**
     * Object: 区 's 所属养殖场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 区 's 区长 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:区's 状态property 
     */
    public com.kingdee.eas.farm.breed.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.farm.breed.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.farm.breed.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EF97B007");
    }
}