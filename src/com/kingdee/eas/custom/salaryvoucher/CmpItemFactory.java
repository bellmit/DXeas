package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CmpItemFactory
{
    private CmpItemFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.ICmpItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ICmpItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DA9E9C4A") ,com.kingdee.eas.custom.salaryvoucher.ICmpItem.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.ICmpItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ICmpItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DA9E9C4A") ,com.kingdee.eas.custom.salaryvoucher.ICmpItem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.ICmpItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ICmpItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DA9E9C4A"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.ICmpItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ICmpItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DA9E9C4A"));
    }
}