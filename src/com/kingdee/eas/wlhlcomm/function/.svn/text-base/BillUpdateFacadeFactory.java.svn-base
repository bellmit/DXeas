package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BillUpdateFacadeFactory
{
    private BillUpdateFacadeFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("84778989") ,com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("84778989") ,com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("84778989"));
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("84778989"));
    }
}