package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LoadingBillFacadeFactory
{
    private LoadingBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AD3FBBFB") ,com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AD3FBBFB") ,com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AD3FBBFB"));
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AD3FBBFB"));
    }
}