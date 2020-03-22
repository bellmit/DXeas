package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SCalSchemeFactory
{
    private SCalSchemeFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISCalScheme getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISCalScheme)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DDE6036F") ,com.kingdee.eas.custom.salaryvoucher.ISCalScheme.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.ISCalScheme getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISCalScheme)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DDE6036F") ,com.kingdee.eas.custom.salaryvoucher.ISCalScheme.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISCalScheme getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISCalScheme)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DDE6036F"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISCalScheme getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISCalScheme)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DDE6036F"));
    }
}