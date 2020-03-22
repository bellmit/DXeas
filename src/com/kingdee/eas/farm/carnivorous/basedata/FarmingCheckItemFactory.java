package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmingCheckItemFactory
{
    private FarmingCheckItemFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E8F81B51") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E8F81B51") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E8F81B51"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmingCheckItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E8F81B51"));
    }
}