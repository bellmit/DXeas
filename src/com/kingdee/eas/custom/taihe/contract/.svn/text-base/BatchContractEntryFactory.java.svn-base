package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractEntryFactory
{
    private BatchContractEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1B172182") ,com.kingdee.eas.custom.taihe.contract.IBatchContractEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1B172182") ,com.kingdee.eas.custom.taihe.contract.IBatchContractEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1B172182"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1B172182"));
    }
}