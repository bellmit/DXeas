package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WincosForSHRFactory
{
    private WincosForSHRFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IWincosForSHR getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IWincosForSHR)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F4928315") ,com.kingdee.eas.custom.shr.IWincosForSHR.class);
    }
    
    public static com.kingdee.eas.custom.shr.IWincosForSHR getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IWincosForSHR)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F4928315") ,com.kingdee.eas.custom.shr.IWincosForSHR.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IWincosForSHR getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IWincosForSHR)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F4928315"));
    }
    public static com.kingdee.eas.custom.shr.IWincosForSHR getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IWincosForSHR)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F4928315"));
    }
}