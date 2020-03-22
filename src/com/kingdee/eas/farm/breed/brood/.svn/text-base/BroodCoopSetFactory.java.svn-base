package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BroodCoopSetFactory
{
    private BroodCoopSetFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A16BE215") ,com.kingdee.eas.farm.breed.brood.IBroodCoopSet.class);
    }
    
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A16BE215") ,com.kingdee.eas.farm.breed.brood.IBroodCoopSet.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A16BE215"));
    }
    public static com.kingdee.eas.farm.breed.brood.IBroodCoopSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.brood.IBroodCoopSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A16BE215"));
    }
}