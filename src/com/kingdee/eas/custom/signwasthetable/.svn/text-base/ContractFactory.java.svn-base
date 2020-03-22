package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ContractFactory
{
    private ContractFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IContract getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContract)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8C0AA21C") ,com.kingdee.eas.custom.signwasthetable.IContract.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IContract getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContract)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8C0AA21C") ,com.kingdee.eas.custom.signwasthetable.IContract.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IContract getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContract)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8C0AA21C"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IContract getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContract)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8C0AA21C"));
    }
}