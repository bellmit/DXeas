package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PollingRecordFacadeFactory
{
    private PollingRecordFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4096B630") ,com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4096B630") ,com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4096B630"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4096B630"));
    }
}