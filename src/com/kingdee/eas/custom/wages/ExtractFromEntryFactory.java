package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExtractFromEntryFactory
{
    private ExtractFromEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IExtractFromEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFromEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("680C4B6F") ,com.kingdee.eas.custom.wages.IExtractFromEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IExtractFromEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFromEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("680C4B6F") ,com.kingdee.eas.custom.wages.IExtractFromEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IExtractFromEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFromEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("680C4B6F"));
    }
    public static com.kingdee.eas.custom.wages.IExtractFromEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IExtractFromEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("680C4B6F"));
    }
}