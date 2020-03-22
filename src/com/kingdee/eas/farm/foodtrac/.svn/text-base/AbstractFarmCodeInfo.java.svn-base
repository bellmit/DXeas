package com.kingdee.eas.farm.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmCodeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFarmCodeInfo()
    {
        this("id");
    }
    protected AbstractFarmCodeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场编号 's 组别 property 
     */
    public com.kingdee.eas.farm.foodtrac.FarmCodeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.foodtrac.FarmCodeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.foodtrac.FarmCodeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 养殖场编号 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CDD7F34D");
    }
}