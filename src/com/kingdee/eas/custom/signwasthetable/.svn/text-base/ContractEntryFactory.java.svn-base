package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ContractEntryFactory
{
    private ContractEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0F1267B6") ,com.kingdee.eas.custom.signwasthetable.IContractEntry.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IContractEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0F1267B6") ,com.kingdee.eas.custom.signwasthetable.IContractEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0F1267B6"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0F1267B6"));
    }
}