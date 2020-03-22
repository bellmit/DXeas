package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpermCheckBillEntryFactory
{
    private SpermCheckBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8B52AA0A") ,com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8B52AA0A") ,com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8B52AA0A"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8B52AA0A"));
    }
}