package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EntrustSettleStandardFactory
{
    private EntrustSettleStandardFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandard getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandard)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("38EF653D") ,com.kingdee.eas.farm.breed.IEntrustSettleStandard.class);
    }
    
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandard getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandard)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("38EF653D") ,com.kingdee.eas.farm.breed.IEntrustSettleStandard.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandard getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandard)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("38EF653D"));
    }
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandard getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandard)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("38EF653D"));
    }
}