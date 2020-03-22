package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowReturnbackBillFactory
{
    private SowReturnbackBillFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DEEAAD38") ,com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DEEAAD38") ,com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DEEAAD38"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DEEAAD38"));
    }
}