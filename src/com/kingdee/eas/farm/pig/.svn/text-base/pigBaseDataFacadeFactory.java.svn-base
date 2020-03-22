package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class pigBaseDataFacadeFactory
{
    private pigBaseDataFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IpigBaseDataFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IpigBaseDataFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D8B4F1A3") ,com.kingdee.eas.farm.pig.IpigBaseDataFacade.class);
    }
    
    public static com.kingdee.eas.farm.pig.IpigBaseDataFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IpigBaseDataFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D8B4F1A3") ,com.kingdee.eas.farm.pig.IpigBaseDataFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IpigBaseDataFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IpigBaseDataFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D8B4F1A3"));
    }
    public static com.kingdee.eas.farm.pig.IpigBaseDataFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IpigBaseDataFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D8B4F1A3"));
    }
}