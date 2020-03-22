package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class parentFacadeFactory
{
    private parentFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IparentFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IparentFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D8E26C1E") ,com.kingdee.eas.farm.breed.IparentFacade.class);
    }
    
    public static com.kingdee.eas.farm.breed.IparentFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IparentFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D8E26C1E") ,com.kingdee.eas.farm.breed.IparentFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IparentFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IparentFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D8E26C1E"));
    }
    public static com.kingdee.eas.farm.breed.IparentFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IparentFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D8E26C1E"));
    }
}