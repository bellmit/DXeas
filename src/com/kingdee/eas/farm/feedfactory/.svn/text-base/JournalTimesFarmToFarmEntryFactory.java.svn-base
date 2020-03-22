package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class JournalTimesFarmToFarmEntryFactory
{
    private JournalTimesFarmToFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("176DA21A") ,com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("176DA21A") ,com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("176DA21A"));
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFarmToFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("176DA21A"));
    }
}