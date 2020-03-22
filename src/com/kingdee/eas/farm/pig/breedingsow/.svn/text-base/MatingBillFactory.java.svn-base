package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MatingBillFactory
{
    private MatingBillFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C17BBE8A") ,com.kingdee.eas.farm.pig.breedingsow.IMatingBill.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C17BBE8A") ,com.kingdee.eas.farm.pig.breedingsow.IMatingBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C17BBE8A"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IMatingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IMatingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C17BBE8A"));
    }
}