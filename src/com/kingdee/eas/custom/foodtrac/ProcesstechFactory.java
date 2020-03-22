package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProcesstechFactory
{
    private ProcesstechFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstech getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstech)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("698223A0") ,com.kingdee.eas.custom.foodtrac.IProcesstech.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IProcesstech getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstech)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("698223A0") ,com.kingdee.eas.custom.foodtrac.IProcesstech.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstech getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstech)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("698223A0"));
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstech getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstech)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("698223A0"));
    }
}