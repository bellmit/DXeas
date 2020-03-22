package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowRentoutBillEntryFactory
{
    private SowRentoutBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B3298EB0") ,com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B3298EB0") ,com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B3298EB0"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B3298EB0"));
    }
}