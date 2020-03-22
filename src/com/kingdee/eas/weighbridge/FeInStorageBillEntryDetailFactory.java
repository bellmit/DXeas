package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeInStorageBillEntryDetailFactory
{
    private FeInStorageBillEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FA79C860") ,com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail.class);
    }
    
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FA79C860") ,com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FA79C860"));
    }
    public static com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IFeInStorageBillEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FA79C860"));
    }
}