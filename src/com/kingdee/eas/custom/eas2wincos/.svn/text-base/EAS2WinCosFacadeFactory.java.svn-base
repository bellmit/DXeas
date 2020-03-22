package com.kingdee.eas.custom.eas2wincos;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EAS2WinCosFacadeFactory
{
    private EAS2WinCosFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F173CE7D") ,com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade.class);
    }
    
    public static com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F173CE7D") ,com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F173CE7D"));
    }
    public static com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2wincos.IEAS2WinCosFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F173CE7D"));
    }
}