package com.kingdee.eas.custom.rentalapplicationform;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RentalApplicationOfBusinessCarFactory
{
    private RentalApplicationOfBusinessCarFactory()
    {
    }
    public static com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F6743734") ,com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar.class);
    }
    
    public static com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F6743734") ,com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F6743734"));
    }
    public static com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rentalapplicationform.IRentalApplicationOfBusinessCar)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F6743734"));
    }
}