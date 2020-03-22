package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CollectSpermBIllEntryFactory
{
    private CollectSpermBIllEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("828CADB6") ,com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("828CADB6") ,com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("828CADB6"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ICollectSpermBIllEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("828CADB6"));
    }
}