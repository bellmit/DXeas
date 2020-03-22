package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConnectServerFactory
{
    private ConnectServerFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.IConnectServer getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IConnectServer)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3CEBDADE") ,com.kingdee.eas.custom.salaryvoucher.IConnectServer.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.IConnectServer getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IConnectServer)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3CEBDADE") ,com.kingdee.eas.custom.salaryvoucher.IConnectServer.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.IConnectServer getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IConnectServer)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3CEBDADE"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.IConnectServer getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IConnectServer)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3CEBDADE"));
    }
}