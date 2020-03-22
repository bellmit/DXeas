package com.kingdee.eas.custom.test;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignwasthetableEntryFactory
{
    private SignwasthetableEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.test.ISignwasthetableEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetableEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6F97AA9A") ,com.kingdee.eas.custom.test.ISignwasthetableEntry.class);
    }
    
    public static com.kingdee.eas.custom.test.ISignwasthetableEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetableEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6F97AA9A") ,com.kingdee.eas.custom.test.ISignwasthetableEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.test.ISignwasthetableEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetableEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6F97AA9A"));
    }
    public static com.kingdee.eas.custom.test.ISignwasthetableEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ISignwasthetableEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6F97AA9A"));
    }
}