package com.kingdee.eas.custom.taihe.sale;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ComplaintTableFactory
{
    private ComplaintTableFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTable getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTable)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AF5C2C2A") ,com.kingdee.eas.custom.taihe.sale.IComplaintTable.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTable getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTable)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AF5C2C2A") ,com.kingdee.eas.custom.taihe.sale.IComplaintTable.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTable getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTable)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AF5C2C2A"));
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplaintTable getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplaintTable)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AF5C2C2A"));
    }
}