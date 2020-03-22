package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigFieldInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPigFieldInfo()
    {
        this("id");
    }
    protected AbstractPigFieldInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 栏位 's 组别 property 
     */
    public com.kingdee.eas.farm.pig.PigFieldTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.pig.PigFieldTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.pig.PigFieldTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 栏位 's 所属猪舍 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pigHouse");
    }
    public void setPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pigHouse", item);
    }
    /**
     * Object: 栏位 's 所属养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getPigFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("pigFarm");
    }
    public void setPigFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("pigFarm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FF32C24C");
    }
}