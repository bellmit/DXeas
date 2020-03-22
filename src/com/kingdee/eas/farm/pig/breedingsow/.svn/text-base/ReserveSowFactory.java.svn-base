package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReserveSowFactory
{
    private ReserveSowFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSow getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSow)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A438F020") ,com.kingdee.eas.farm.pig.breedingsow.IReserveSow.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSow getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSow)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A438F020") ,com.kingdee.eas.farm.pig.breedingsow.IReserveSow.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSow getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSow)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A438F020"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IReserveSow getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IReserveSow)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A438F020"));
    }
}