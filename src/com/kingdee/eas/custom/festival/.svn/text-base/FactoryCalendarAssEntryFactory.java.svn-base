package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FactoryCalendarAssEntryFactory
{
    private FactoryCalendarAssEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("95B8688E") ,com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry.class);
    }
    
    public static com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("95B8688E") ,com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("95B8688E"));
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("95B8688E"));
    }
}