package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowAbortionFactory
{
    private SowAbortionFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortion getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortion)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5E8018D2") ,com.kingdee.eas.farm.pig.breedingsow.ISowAbortion.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortion getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortion)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5E8018D2") ,com.kingdee.eas.farm.pig.breedingsow.ISowAbortion.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortion getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortion)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5E8018D2"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortion getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortion)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5E8018D2"));
    }
}