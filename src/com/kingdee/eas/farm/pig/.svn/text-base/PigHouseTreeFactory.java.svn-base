package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigHouseTreeFactory
{
    private PigHouseTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigHouseTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouseTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BA8C4730") ,com.kingdee.eas.farm.pig.IPigHouseTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigHouseTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouseTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BA8C4730") ,com.kingdee.eas.farm.pig.IPigHouseTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigHouseTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouseTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BA8C4730"));
    }
    public static com.kingdee.eas.farm.pig.IPigHouseTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigHouseTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BA8C4730"));
    }
}