package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowFactory
{
    private SowFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISow getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISow)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DFBAC7DA") ,com.kingdee.eas.farm.pig.breedingsow.ISow.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISow getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISow)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DFBAC7DA") ,com.kingdee.eas.farm.pig.breedingsow.ISow.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISow getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISow)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DFBAC7DA"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISow getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISow)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DFBAC7DA"));
    }
}