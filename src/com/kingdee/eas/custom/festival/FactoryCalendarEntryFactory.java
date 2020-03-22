package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FactoryCalendarEntryFactory
{
    private FactoryCalendarEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E06E2375") ,com.kingdee.eas.custom.festival.IFactoryCalendarEntry.class);
    }
    
    public static com.kingdee.eas.custom.festival.IFactoryCalendarEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E06E2375") ,com.kingdee.eas.custom.festival.IFactoryCalendarEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E06E2375"));
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E06E2375"));
    }
}