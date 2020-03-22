package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CollectSpermBIllFactory
{
    private CollectSpermBIllFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3ABC9C1C") ,com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3ABC9C1C") ,com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3ABC9C1C"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIll)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3ABC9C1C"));
    }
}