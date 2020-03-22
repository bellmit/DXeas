package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigHouseFactory
{
    private PigHouseFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigHouse getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouse)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FF51E872") ,com.kingdee.eas.farm.pig.IPigHouse.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigHouse getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouse)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FF51E872") ,com.kingdee.eas.farm.pig.IPigHouse.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigHouse getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouse)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FF51E872"));
    }
    public static com.kingdee.eas.farm.pig.IPigHouse getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouse)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FF51E872"));
    }
}