package com.kingdee.eas.custom.taihe.sale;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ComplainedTypeFactory
{
    private ComplainedTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplainedType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("969F60E9") ,com.kingdee.eas.custom.taihe.sale.IComplainedType.class);
    }
    
    public static com.kingdee.eas.custom.taihe.sale.IComplainedType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("969F60E9") ,com.kingdee.eas.custom.taihe.sale.IComplainedType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplainedType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("969F60E9"));
    }
    public static com.kingdee.eas.custom.taihe.sale.IComplainedType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.sale.IComplainedType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("969F60E9"));
    }
}