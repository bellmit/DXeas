package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PurFrightFactory
{
    private PurFrightFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IPurFright getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFright)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("32EDC341") ,com.kingdee.eas.farm.feedfactory.IPurFright.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IPurFright getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFright)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("32EDC341") ,com.kingdee.eas.farm.feedfactory.IPurFright.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IPurFright getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFright)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("32EDC341"));
    }
    public static com.kingdee.eas.farm.feedfactory.IPurFright getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFright)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("32EDC341"));
    }
}