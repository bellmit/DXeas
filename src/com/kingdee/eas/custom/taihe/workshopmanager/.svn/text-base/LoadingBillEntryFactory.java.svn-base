package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LoadingBillEntryFactory
{
    private LoadingBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("68A78CF1") ,com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("68A78CF1") ,com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("68A78CF1"));
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("68A78CF1"));
    }
}