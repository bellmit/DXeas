package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReserveSowEntryFactory
{
    private ReserveSowEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("04783C32") ,com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("04783C32") ,com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("04783C32"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSowEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("04783C32"));
    }
}