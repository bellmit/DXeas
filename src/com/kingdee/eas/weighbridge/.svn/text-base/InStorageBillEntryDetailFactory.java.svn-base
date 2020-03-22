package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InStorageBillEntryDetailFactory
{
    private InStorageBillEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IInStorageBillEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("974C6F41") ,com.kingdee.eas.weighbridge.IInStorageBillEntryDetail.class);
    }
    
    public static com.kingdee.eas.weighbridge.IInStorageBillEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("974C6F41") ,com.kingdee.eas.weighbridge.IInStorageBillEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IInStorageBillEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("974C6F41"));
    }
    public static com.kingdee.eas.weighbridge.IInStorageBillEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IInStorageBillEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("974C6F41"));
    }
}