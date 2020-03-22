package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowRentoutBillFactory
{
    private SowRentoutBillFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("248186E2") ,com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("248186E2") ,com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("248186E2"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowRentoutBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("248186E2"));
    }
}