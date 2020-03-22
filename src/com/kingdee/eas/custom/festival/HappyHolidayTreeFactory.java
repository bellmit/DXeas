package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HappyHolidayTreeFactory
{
    private HappyHolidayTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IHappyHolidayTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHolidayTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87949721") ,com.kingdee.eas.custom.festival.IHappyHolidayTree.class);
    }
    
    public static com.kingdee.eas.custom.festival.IHappyHolidayTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHolidayTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87949721") ,com.kingdee.eas.custom.festival.IHappyHolidayTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IHappyHolidayTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHolidayTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87949721"));
    }
    public static com.kingdee.eas.custom.festival.IHappyHolidayTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IHappyHolidayTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87949721"));
    }
}