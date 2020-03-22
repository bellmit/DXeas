package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigFarmTreeFactory
{
    private PigFarmTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigFarmTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarmTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("22E63A62") ,com.kingdee.eas.farm.pig.IPigFarmTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigFarmTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarmTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("22E63A62") ,com.kingdee.eas.farm.pig.IPigFarmTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigFarmTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarmTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("22E63A62"));
    }
    public static com.kingdee.eas.farm.pig.IPigFarmTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFarmTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("22E63A62"));
    }
}