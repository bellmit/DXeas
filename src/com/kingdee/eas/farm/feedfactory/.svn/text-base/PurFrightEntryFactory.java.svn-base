package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PurFrightEntryFactory
{
    private PurFrightEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IPurFrightEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFrightEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CD1F35B1") ,com.kingdee.eas.farm.feedfactory.IPurFrightEntry.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IPurFrightEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFrightEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CD1F35B1") ,com.kingdee.eas.farm.feedfactory.IPurFrightEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IPurFrightEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFrightEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CD1F35B1"));
    }
    public static com.kingdee.eas.farm.feedfactory.IPurFrightEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IPurFrightEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CD1F35B1"));
    }
}