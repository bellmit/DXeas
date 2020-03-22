package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class GetDataFacadeFactory
{
    private GetDataFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IGetDataFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IGetDataFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1DEED4F") ,com.kingdee.eas.custom.szcount.IGetDataFacade.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IGetDataFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IGetDataFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1DEED4F") ,com.kingdee.eas.custom.szcount.IGetDataFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IGetDataFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IGetDataFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1DEED4F"));
    }
    public static com.kingdee.eas.custom.szcount.IGetDataFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IGetDataFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1DEED4F"));
    }
}