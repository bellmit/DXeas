package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigFarmFactory
{
    private PigFarmFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigFarm getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarm)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FFF944A4") ,com.kingdee.eas.farm.pig.IPigFarm.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigFarm getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarm)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FFF944A4") ,com.kingdee.eas.farm.pig.IPigFarm.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigFarm getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarm)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FFF944A4"));
    }
    public static com.kingdee.eas.farm.pig.IPigFarm getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarm)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FFF944A4"));
    }
}