package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowReturnbackBillEntryFactory
{
    private SowReturnbackBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7D48EE1A") ,com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7D48EE1A") ,com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7D48EE1A"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowReturnbackBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7D48EE1A"));
    }
}