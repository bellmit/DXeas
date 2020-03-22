package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractAllotEntryFactory
{
    private BatchContractAllotEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8D18A1BC") ,com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8D18A1BC") ,com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8D18A1BC"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContractAllotEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8D18A1BC"));
    }
}