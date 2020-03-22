package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class THWgtFacadeFactory
{
    private THWgtFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ITHWgtFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITHWgtFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67ECC974") ,com.kingdee.eas.custom.taihe.weight.ITHWgtFacade.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ITHWgtFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITHWgtFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67ECC974") ,com.kingdee.eas.custom.taihe.weight.ITHWgtFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ITHWgtFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITHWgtFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67ECC974"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ITHWgtFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ITHWgtFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67ECC974"));
    }
}