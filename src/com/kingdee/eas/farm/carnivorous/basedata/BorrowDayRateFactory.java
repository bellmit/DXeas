package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BorrowDayRateFactory
{
    private BorrowDayRateFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("369EFC85") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("369EFC85") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("369EFC85"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("369EFC85"));
    }
}