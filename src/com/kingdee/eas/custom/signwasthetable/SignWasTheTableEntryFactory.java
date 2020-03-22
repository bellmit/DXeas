package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SignWasTheTableEntryFactory
{
    private SignWasTheTableEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AED71213") ,com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AED71213") ,com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AED71213"));
    }
    public static com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.ISignWasTheTableEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AED71213"));
    }
}