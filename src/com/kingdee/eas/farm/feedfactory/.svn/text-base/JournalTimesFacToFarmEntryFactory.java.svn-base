package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class JournalTimesFacToFarmEntryFactory
{
    private JournalTimesFacToFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4BE2A50A") ,com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4BE2A50A") ,com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4BE2A50A"));
    }
    public static com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IJournalTimesFacToFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4BE2A50A"));
    }
}