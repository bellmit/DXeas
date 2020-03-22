package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzSemiProductFactory
{
    private SzSemiProductFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzSemiProduct getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProduct)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("02ABF12F") ,com.kingdee.eas.custom.szcount.ISzSemiProduct.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzSemiProduct getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProduct)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("02ABF12F") ,com.kingdee.eas.custom.szcount.ISzSemiProduct.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzSemiProduct getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProduct)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("02ABF12F"));
    }
    public static com.kingdee.eas.custom.szcount.ISzSemiProduct getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzSemiProduct)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("02ABF12F"));
    }
}