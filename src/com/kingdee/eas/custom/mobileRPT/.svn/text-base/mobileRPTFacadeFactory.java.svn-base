package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class mobileRPTFacadeFactory
{
    private mobileRPTFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("00578DEF") ,com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade.class);
    }
    
    public static com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("00578DEF") ,com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("00578DEF"));
    }
    public static com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileRPT.ImobileRPTFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("00578DEF"));
    }
}