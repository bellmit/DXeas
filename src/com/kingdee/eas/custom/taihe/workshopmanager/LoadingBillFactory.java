package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LoadingBillFactory
{
    private LoadingBillFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BEDBE401") ,com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill.class);
    }
    
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BEDBE401") ,com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BEDBE401"));
    }
    public static com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BEDBE401"));
    }
}