package com.kingdee.eas.message.webservices;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DataUniFormFacadeFactory
{
    private DataUniFormFacadeFactory()
    {
    }
    public static com.kingdee.eas.message.webservices.IDataUniFormFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.message.webservices.IDataUniFormFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C58CEE4F") ,com.kingdee.eas.message.webservices.IDataUniFormFacade.class);
    }
    
    public static com.kingdee.eas.message.webservices.IDataUniFormFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.message.webservices.IDataUniFormFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C58CEE4F") ,com.kingdee.eas.message.webservices.IDataUniFormFacade.class, objectCtx);
    }
    public static com.kingdee.eas.message.webservices.IDataUniFormFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.message.webservices.IDataUniFormFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C58CEE4F"));
    }
    public static com.kingdee.eas.message.webservices.IDataUniFormFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.message.webservices.IDataUniFormFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C58CEE4F"));
    }
}