package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ForecasetTransOrderFacadeFactory
{
    private ForecasetTransOrderFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6A8DFB1B") ,com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6A8DFB1B") ,com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6A8DFB1B"));
    }
    public static com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6A8DFB1B"));
    }
}