package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExtractFromFactory
{
    private ExtractFromFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IExtractFrom getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFrom)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0EFD8EC3") ,com.kingdee.eas.custom.wages.IExtractFrom.class);
    }
    
    public static com.kingdee.eas.custom.wages.IExtractFrom getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFrom)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0EFD8EC3") ,com.kingdee.eas.custom.wages.IExtractFrom.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IExtractFrom getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFrom)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0EFD8EC3"));
    }
    public static com.kingdee.eas.custom.wages.IExtractFrom getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFrom)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0EFD8EC3"));
    }
}