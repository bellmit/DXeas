package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmFactory
{
    private FarmFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarm getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarm)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E33948D8") ,com.kingdee.eas.farm.carnivorous.basedata.IFarm.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarm getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarm)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E33948D8") ,com.kingdee.eas.farm.carnivorous.basedata.IFarm.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarm getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarm)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E33948D8"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarm getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarm)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E33948D8"));
    }
}