package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractDetailEntryFactory
{
    private BatchContractDetailEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("21DEE0FA") ,com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("21DEE0FA") ,com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("21DEE0FA"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBatchContractDetailEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("21DEE0FA"));
    }
}