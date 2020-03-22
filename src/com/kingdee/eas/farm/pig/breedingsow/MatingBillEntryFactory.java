package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MatingBillEntryFactory
{
    private MatingBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1BA7E008") ,com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1BA7E008") ,com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1BA7E008"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1BA7E008"));
    }
}