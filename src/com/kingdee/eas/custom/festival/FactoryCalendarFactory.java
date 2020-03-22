package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FactoryCalendarFactory
{
    private FactoryCalendarFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendar getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendar)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("242A4AFD") ,com.kingdee.eas.custom.festival.IFactoryCalendar.class);
    }
    
    public static com.kingdee.eas.custom.festival.IFactoryCalendar getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendar)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("242A4AFD") ,com.kingdee.eas.custom.festival.IFactoryCalendar.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendar getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendar)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("242A4AFD"));
    }
    public static com.kingdee.eas.custom.festival.IFactoryCalendar getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IFactoryCalendar)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("242A4AFD"));
    }
}