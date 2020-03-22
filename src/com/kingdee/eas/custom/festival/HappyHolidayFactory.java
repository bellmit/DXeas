package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HappyHolidayFactory
{
    private HappyHolidayFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IHappyHoliday getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHoliday)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0B99D8E3") ,com.kingdee.eas.custom.festival.IHappyHoliday.class);
    }
    
    public static com.kingdee.eas.custom.festival.IHappyHoliday getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHoliday)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0B99D8E3") ,com.kingdee.eas.custom.festival.IHappyHoliday.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IHappyHoliday getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHoliday)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0B99D8E3"));
    }
    public static com.kingdee.eas.custom.festival.IHappyHoliday getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHoliday)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0B99D8E3"));
    }
}