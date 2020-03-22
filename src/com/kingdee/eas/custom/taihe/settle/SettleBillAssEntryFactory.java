package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillAssEntryFactory
{
    private SettleBillAssEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1A311D06") ,com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1A311D06") ,com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1A311D06"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBillAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1A311D06"));
    }
}