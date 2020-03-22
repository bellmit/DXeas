package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleOrderAutoCloseFacadeFactory
{
    private SaleOrderAutoCloseFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DAC344FC") ,com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade.class);
    }
    
    public static com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DAC344FC") ,com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DAC344FC"));
    }
    public static com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.ISaleOrderAutoCloseFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DAC344FC"));
    }
}