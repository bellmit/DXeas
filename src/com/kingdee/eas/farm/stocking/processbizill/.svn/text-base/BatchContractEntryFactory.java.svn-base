package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractEntryFactory
{
    private BatchContractEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5B36558B") ,com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5B36558B") ,com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5B36558B"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5B36558B"));
    }
}