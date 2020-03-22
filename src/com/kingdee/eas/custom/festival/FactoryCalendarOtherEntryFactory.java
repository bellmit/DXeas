package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FactoryCalendarOtherEntryFactory
{
    private FactoryCalendarOtherEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("23DED21F") ,com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry.class);
    }
    
    public static com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("23DED21F") ,com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("23DED21F"));
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendarOtherEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("23DED21F"));
    }
}