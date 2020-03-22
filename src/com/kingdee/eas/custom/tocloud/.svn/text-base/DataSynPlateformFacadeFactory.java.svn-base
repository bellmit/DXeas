package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DataSynPlateformFacadeFactory
{
    private DataSynPlateformFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("70F321CF") ,com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("70F321CF") ,com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("70F321CF"));
    }
    public static com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDataSynPlateformFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("70F321CF"));
    }
}