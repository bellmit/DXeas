package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SpermCheckBillFactory
{
    private SpermCheckBillFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EFD73B48") ,com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EFD73B48") ,com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EFD73B48"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.ISpermCheckBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EFD73B48"));
    }
}