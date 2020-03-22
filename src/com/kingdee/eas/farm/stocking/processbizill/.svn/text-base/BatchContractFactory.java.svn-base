package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractFactory
{
    private BatchContractFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContract getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContract)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CBC4A327") ,com.kingdee.eas.farm.stocking.processbizill.IBatchContract.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContract getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContract)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CBC4A327") ,com.kingdee.eas.farm.stocking.processbizill.IBatchContract.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContract getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContract)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CBC4A327"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContract getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContract)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CBC4A327"));
    }
}