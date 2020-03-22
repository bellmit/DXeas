package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigLevelFactory
{
    private PigLevelFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigLevel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigLevel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FF85BCD6") ,com.kingdee.eas.farm.pig.IPigLevel.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigLevel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigLevel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FF85BCD6") ,com.kingdee.eas.farm.pig.IPigLevel.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigLevel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigLevel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FF85BCD6"));
    }
    public static com.kingdee.eas.farm.pig.IPigLevel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigLevel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FF85BCD6"));
    }
}