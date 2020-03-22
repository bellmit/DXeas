package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarFactory
{
    private BoarFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoar getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoar)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EBFDA8FA") ,com.kingdee.eas.farm.pig.breedingboar.IBoar.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoar getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoar)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EBFDA8FA") ,com.kingdee.eas.farm.pig.breedingboar.IBoar.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoar getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoar)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EBFDA8FA"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoar getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoar)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EBFDA8FA"));
    }
}