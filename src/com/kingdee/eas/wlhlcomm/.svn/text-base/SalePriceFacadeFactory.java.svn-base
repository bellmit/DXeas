package com.kingdee.eas.wlhlcomm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalePriceFacadeFactory
{
    private SalePriceFacadeFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.ISalePriceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.ISalePriceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2F20860B") ,com.kingdee.eas.wlhlcomm.ISalePriceFacade.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.ISalePriceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.ISalePriceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2F20860B") ,com.kingdee.eas.wlhlcomm.ISalePriceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.ISalePriceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.ISalePriceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2F20860B"));
    }
    public static com.kingdee.eas.wlhlcomm.ISalePriceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.ISalePriceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2F20860B"));
    }
}