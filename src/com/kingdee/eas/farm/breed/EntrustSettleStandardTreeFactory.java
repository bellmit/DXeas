package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EntrustSettleStandardTreeFactory
{
    private EntrustSettleStandardTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandardTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandardTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BC38667B") ,com.kingdee.eas.farm.breed.IEntrustSettleStandardTree.class);
    }
    
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandardTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandardTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BC38667B") ,com.kingdee.eas.farm.breed.IEntrustSettleStandardTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandardTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandardTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BC38667B"));
    }
    public static com.kingdee.eas.farm.breed.IEntrustSettleStandardTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IEntrustSettleStandardTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BC38667B"));
    }
}