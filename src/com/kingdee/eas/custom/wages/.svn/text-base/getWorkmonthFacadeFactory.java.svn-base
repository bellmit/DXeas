package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class getWorkmonthFacadeFactory
{
    private getWorkmonthFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IgetWorkmonthFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetWorkmonthFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("545B333B") ,com.kingdee.eas.custom.wages.IgetWorkmonthFacade.class);
    }
    
    public static com.kingdee.eas.custom.wages.IgetWorkmonthFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetWorkmonthFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("545B333B") ,com.kingdee.eas.custom.wages.IgetWorkmonthFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IgetWorkmonthFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetWorkmonthFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("545B333B"));
    }
    public static com.kingdee.eas.custom.wages.IgetWorkmonthFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IgetWorkmonthFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("545B333B"));
    }
}