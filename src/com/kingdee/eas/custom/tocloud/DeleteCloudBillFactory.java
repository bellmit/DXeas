package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeleteCloudBillFactory
{
    private DeleteCloudBillFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IDeleteCloudBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDeleteCloudBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("45766238") ,com.kingdee.eas.custom.tocloud.IDeleteCloudBill.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IDeleteCloudBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDeleteCloudBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("45766238") ,com.kingdee.eas.custom.tocloud.IDeleteCloudBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IDeleteCloudBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDeleteCloudBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("45766238"));
    }
    public static com.kingdee.eas.custom.tocloud.IDeleteCloudBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IDeleteCloudBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("45766238"));
    }
}