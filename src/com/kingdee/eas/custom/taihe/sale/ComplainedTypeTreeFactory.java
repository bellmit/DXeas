package com.kingdee.eas.custom.taihe.sale;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ComplainedTypeTreeFactory
{
    private ComplainedTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("84EAAC27") ,com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("84EAAC27") ,com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("84EAAC27"));
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("84EAAC27"));
    }
}